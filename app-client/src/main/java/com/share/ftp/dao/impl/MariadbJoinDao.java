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
        "insert into ftp_user(id,password,name,tel,email,post_no,basic_address,detail_address)"
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
            + " id,"
            //            + " password,"
            + " email,"
            + " name,"
            + " tel,"
            + " create_dt,"
            + " post_no,"
            + " basic_address,"
            + " detail_address"
            + " from"
            + " ftp_user order by user_no asc");
        ResultSet rs = stmt.executeQuery()) {


      ArrayList<JoinDTO> list = new ArrayList<>();

      while (rs.next()) {
        JoinDTO joinDTO = new JoinDTO();
        joinDTO.setNo(rs.getInt("user_no"));
        joinDTO.setId(rs.getString("id"));
        //        joinDTO.setPassword(rs.getString("password"));
        joinDTO.setName(rs.getString("name"));
        joinDTO.setEmail(rs.getString("email"));
        joinDTO.setTel(rs.getString("tel"));
        joinDTO.setRegisterDate(rs.getDate("create_dt"));
        joinDTO.setAddress(rs.getString("post_no"));
        joinDTO.setBasicAddress(rs.getString("basic_address"));
        joinDTO.setDetailAddress(rs.getString("detail_address"));

        list.add(joinDTO);
      }

      return list;
    }
  }

  @Override
  public void update(JoinDTO joinDTO) throws Exception {

    try (PreparedStatement stmt = con.prepareStatement(
        "update ftp_user set"
            + " name=?,password=password(?),tel=?,post_no,basic_address,detail_address"
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
  }

  @Override
  public JoinDTO validId(JoinDTO joinDTO) throws Exception {
    return null;
  }


  @Override
  public JoinDTO selectOneByIdPassword(String userId, String userPassword) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "select user_no,id,name,email,tel,create_dt from ftp_user"
            + " where id=? and password=password(?)")) {

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
  }

  @Override
  public JoinDTO selectOneByIdEmail(String userId, String userEmail) throws Exception {

    try (PreparedStatement stmt = con.prepareStatement(
        "select user_no,id,name,email,tel,create_dt from ftp_user"
            + " where id=? and email=?")) {

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
  }

  @Override
  public JoinDTO selectOneByUser(String userId, String userPassword) throws Exception {
    return null;
  }

  @Override
  public JoinDTO selectOneByEmail(String userEmail) throws Exception {

    try (PreparedStatement stmt = con.prepareStatement(
        "select user_no,id,name,email,tel,create_dt from ftp_user"
            + " where email=?")) {

      stmt.setString(1, userEmail);

      try (ResultSet rs = stmt.executeQuery()) {
        if (!rs.next()) {
          return null;
        }

        JoinDTO joinDTO = new JoinDTO();
        joinDTO.setNo(rs.getInt("user_no"));
        joinDTO.setId(rs.getString("id"));
        joinDTO.setName(rs.getString("name"));
        joinDTO.setEmail(rs.getString("email"));
        joinDTO.setTel(rs.getString("tel"));
        joinDTO.setRegisterDate(rs.getDate("create_dt"));
        return joinDTO;
      }
    }
  }

  @Override
  public JoinDTO selectOneByTel(String userTel) throws Exception {

    try (PreparedStatement stmt = con.prepareStatement(
        "select user_no,id,name,email,tel,create_dt from ftp_user"
            + " where tel=?")) {

      stmt.setString(1, userTel);

      try (ResultSet rs = stmt.executeQuery()) {
        if (!rs.next()) {
          return null;
        }

        JoinDTO joinDTO = new JoinDTO();
        joinDTO.setNo(rs.getInt("user_no"));
        joinDTO.setId(rs.getString("id"));
        joinDTO.setName(rs.getString("name"));
        joinDTO.setEmail(rs.getString("email"));
        joinDTO.setTel(rs.getString("tel"));
        joinDTO.setRegisterDate(rs.getDate("create_dt"));
        return joinDTO;
      }
    }
  }





}
