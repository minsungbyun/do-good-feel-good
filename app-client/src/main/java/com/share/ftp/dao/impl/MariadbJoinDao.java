package com.share.ftp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.share.ftp.dao.JoinDao;
import com.share.ftp.domain.join.JoinDTO;

//역할
//- 로그인 데이터를 서버를 통해 관리한다.
//
public class MariadbJoinDao implements JoinDao {

  Connection con;

  public MariadbJoinDao(Connection con) {
    this.con = con;
  }

  @Override
  public void insert(JoinDTO joinDTO) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "insert into ftp_user(user_id,password,name,tel,email,pst_no,bas_addr,det_addr)"
            + " values(?,password(?),?,?,?,?,?,?)")) {

      stmt.setString(1, joinDTO.getId());
      stmt.setString(2, joinDTO.getPassword());
      stmt.setString(3, joinDTO.getName());
      stmt.setString(4, joinDTO.getTel());
      stmt.setString(5, joinDTO.getEmail());
      stmt.setString(6, joinDTO.getAddress());
      stmt.setString(7, joinDTO.getBasicAddress());
      stmt.setString(8, joinDTO.getDetailAddress());

      if (stmt.executeUpdate() == 0) {
        throw new Exception("회원 데이터 저장 실패!");
      }
    }
  }

  @Override
  public List<JoinDTO> findAll() throws Exception {

    try (PreparedStatement stmt = con.prepareStatement(
        "select"
            + " user_no,"
            + " user_id,"
            //            + " password,"
            + " email,"
            + " name,"
            + " tel,"
            + " create_dt,"
            + " pst_no,"
            + " bas_addr,"
            + " det_addr"
            + " from"
            + " ftp_user order by user_no asc");
        ResultSet rs = stmt.executeQuery()) {


      ArrayList<JoinDTO> list = new ArrayList<>();

      while (rs.next()) {
        JoinDTO joinDTO = new JoinDTO();
        joinDTO.setNo(rs.getInt("user_no"));
        joinDTO.setId(rs.getString("user_id"));
        //        joinDTO.setPassword(rs.getString("password"));
        joinDTO.setName(rs.getString("name"));
        joinDTO.setEmail(rs.getString("email"));
        joinDTO.setTel(rs.getString("tel"));
        joinDTO.setRegisterDate(rs.getDate("create_dt"));
        joinDTO.setAddress(rs.getString("pst_no"));
        joinDTO.setBasicAddress(rs.getString("bas_addr"));
        joinDTO.setDetailAddress(rs.getString("det_addr"));

        list.add(joinDTO);
      }

      return list;
    }

    //    requestAgent.request("join.selectList", null);
    //
    //    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
    //      throw new Exception("회원 목록 조회 실패!");
    //    }
    //
    //    return new ArrayList<>(requestAgent.getObjects(JoinDTO.class));
  }

  @Override
  public void update(JoinDTO joinDTO) throws Exception {

    try (PreparedStatement stmt = con.prepareStatement(
        "update ftp_user set"
            + " name=?,password=password(?),tel=?,pst_no,bas_addr,det_addr"
            + " where user_no=?")) {

      stmt.setString(1, joinDTO.getName());
      stmt.setString(2, joinDTO.getPassword());
      stmt.setString(3, joinDTO.getTel());
      stmt.setString(4, joinDTO.getAddress());
      stmt.setString(5, joinDTO.getBasicAddress());
      stmt.setString(6, joinDTO.getDetailAddress());

      if (stmt.executeUpdate() == 0) {
        throw new Exception("회원 데이터 변경 실패!");
      }
    }

    //    requestAgent.request("join.update", joinDTO);
    //
    //    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
    //      throw new Exception("회원 정보 변경 실패!");
    //    }
  }


  @Override
  public void delete(JoinDTO joinDTO) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "delete from ftp_user where user_no=?")) {

      stmt.setInt(1, joinDTO.getNo());

      if (stmt.executeUpdate() == 0) {
        throw new Exception("회원 데이터 삭제 실패!");
      }
    }

    //
    //    requestAgent.request("join.delete", loginUser);
    //
    //    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
    //      throw new Exception("회원 탈퇴 실패!");
    //    }

  }

  @Override
  public JoinDTO validId(JoinDTO joinDTO) throws Exception {

    //
    //    requestAgent.request("join.validId", joinDTO);
    //
    //    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
    //      return null;
    //
    //    } else {
    //      return requestAgent.getObject(JoinDTO.class);
    //    }
    return null;
  }


  @Override
  public int getNextNum() throws Exception {
    //
    //    requestAgent.request("join.getNextNum", null);
    //
    //    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
    //      throw new Exception("고유번호 부여 중 오류 발생!");
    //    }
    //    JoinDTO joinDTO = requestAgent.getObject(JoinDTO.class);
    //
    //
    //    return joinDTO.getNo();
    return 0;
  }

  @Override
  public JoinDTO selectOneByIdPassword(String userId, String userPassword) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "select user_no,user_id,name,email,tel,create_dt from ftp_user"
            + " where user_id=? and password=password(?)")) {

      stmt.setString(1, userId);
      stmt.setString(2, userPassword);

      try (ResultSet rs = stmt.executeQuery()) {
        if (!rs.next()) {
          return null;
        }

        JoinDTO joinDTO = new JoinDTO();
        joinDTO.setNo(rs.getInt("user_no"));
        joinDTO.setName(rs.getString("name"));
        joinDTO.setEmail(rs.getString("email"));
        joinDTO.setTel(rs.getString("tel"));
        joinDTO.setRegisterDate(rs.getDate("create_dt"));
        return joinDTO;
      }
    }
    //    HashMap<String,String> params = new HashMap<>();
    //    params.put("loginId", userId);
    //    params.put("loginPassword", userPassword);
    //
    //    requestAgent.request("join.selectOneByIdPassword", params);
    //
    //    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
    //      return null;
    //    } else {
    //      return requestAgent.getObject(JoinDTO.class);
    //
    //    }
    //    return null;
  }

  @Override
  public JoinDTO selectOneByIdEmail(String userId, String userEmail) throws Exception {

    try (PreparedStatement stmt = con.prepareStatement(
        "select user_no,user_id,name,email,tel,create_dt from ftp_user"
            + " where user_id=? and email=?")) {

      stmt.setString(1, userId);
      stmt.setString(2, userEmail);

      try (ResultSet rs = stmt.executeQuery()) {
        if (!rs.next()) {
          return null;
        }

        JoinDTO joinDTO = new JoinDTO();
        joinDTO.setNo(rs.getInt("user_no"));
        joinDTO.setName(rs.getString("name"));
        joinDTO.setEmail(rs.getString("email"));
        joinDTO.setTel(rs.getString("tel"));
        joinDTO.setRegisterDate(rs.getDate("create_dt"));
        return joinDTO;
      }
    }

    //
    //    HashMap<String,String> params = new HashMap<>();
    //    params.put("loginId", userId);
    //    params.put("loginEmail", userEmail);
    //
    //    requestAgent.request("join.selectOneByIdEmail", params);
    //
    //    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
    //      return null;
    //    }
    //
    //    return requestAgent.getObject(JoinDTO.class);
  }

  @Override
  public JoinDTO selectOneByUser(String userId, String userPassword) throws Exception {
    //
    //    HashMap<String,String> params = new HashMap<>();
    //    params.put("userId", userId);
    //    params.put("userPassword", userPassword);
    //
    //    requestAgent.request("join.selectOneByUser", params);
    //
    //    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
    //      return null;
    //    }
    //
    //    return requestAgent.getObject(JoinDTO.class);
    return null;
  }

  @Override
  public JoinDTO selectOneByEmail(String userEmail) throws Exception {

    try (PreparedStatement stmt = con.prepareStatement(
        "select user_no,user_id,name,email,tel,create_dt from ftp_user"
            + " where email=?")) {

      stmt.setString(1, userEmail);

      try (ResultSet rs = stmt.executeQuery()) {
        if (!rs.next()) {
          return null;
        }

        JoinDTO joinDTO = new JoinDTO();
        joinDTO.setNo(rs.getInt("user_no"));
        joinDTO.setId(rs.getString("user_id"));
        joinDTO.setName(rs.getString("name"));
        joinDTO.setEmail(rs.getString("email"));
        joinDTO.setTel(rs.getString("tel"));
        joinDTO.setRegisterDate(rs.getDate("create_dt"));
        return joinDTO;
      }
    }

    //
    //    HashMap<String,String> params = new HashMap<>();
    //    params.put("userEmail", userEmail);
    //
    //    requestAgent.request("join.selectOneByEmail", params);
    //
    //    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
    //      return null;
    //    }
    //
    //    return requestAgent.getObject(JoinDTO.class);
  }

  @Override
  public JoinDTO selectOneByTel(String userTel) throws Exception {

    try (PreparedStatement stmt = con.prepareStatement(
        "select user_no,user_id,name,email,tel,create_dt from ftp_user"
            + " where tel=?")) {

      stmt.setString(1, userTel);

      try (ResultSet rs = stmt.executeQuery()) {
        if (!rs.next()) {
          return null;
        }

        JoinDTO joinDTO = new JoinDTO();
        joinDTO.setNo(rs.getInt("user_no"));
        joinDTO.setId(rs.getString("user_id"));
        joinDTO.setName(rs.getString("name"));
        joinDTO.setEmail(rs.getString("email"));
        joinDTO.setTel(rs.getString("tel"));
        joinDTO.setRegisterDate(rs.getDate("create_dt"));
        return joinDTO;
      }
    }

    //    HashMap<String,String> params = new HashMap<>();
    //    params.put("userTel", userTel);
    //
    //    requestAgent.request("join.selectOneByTel", params);
    //
    //    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
    //      return null;
    //    }
    //
    //    return requestAgent.getObject(JoinDTO.class);
  }





}
