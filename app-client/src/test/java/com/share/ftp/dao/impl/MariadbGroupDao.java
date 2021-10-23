package com.share.ftp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.share.ftp.dao.GroupDao;
import com.share.ftp.domain.join.GroupDTO;

//역할
//- 로그인 데이터를 서버를 통해 관리한다.
//
public class MariadbGroupDao implements GroupDao {

  Connection con;

  public MariadbGroupDao(Connection con) {
    this.con = con;
  }

  @Override
  public void insert(GroupDTO groupDTO) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "insert into ftp_user(id,password,name,tel,email,post_no,basic_address,detail_address,type,status)"
            + " values(?,password(?),?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS)) {

      stmt.setString(1, groupDTO.getId());
      stmt.setString(2, groupDTO.getPassword());
      stmt.setString(3, groupDTO.getName());
      stmt.setString(4, groupDTO.getTel());
      stmt.setString(5, groupDTO.getEmail());
      stmt.setInt(6, groupDTO.getPostNo());
      stmt.setString(7, groupDTO.getBasicAddress());
      stmt.setString(8, groupDTO.getDetailAddress());
      stmt.setInt(9, groupDTO.getType());
      stmt.setInt(10, groupDTO.getStatus());

      if (stmt.executeUpdate() == 0) {
        throw new Exception("회원 데이터 저장 실패!");
      }

      int userNo = 0;
      try(ResultSet pkRs = stmt.getGeneratedKeys()) {
        if (pkRs.next()) {
          userNo = pkRs.getInt("user_no");
        }
      }

      try(PreparedStatement stmt2 = con.prepareStatement("insert into ftp_user_group(user_no,group_cnt)"
          + " values(?,?)")) {
        stmt2.setInt(1, userNo);
        stmt2.setInt(2, groupDTO.getGroupCount());
        stmt2.executeUpdate();
      }

    }
  }

  @Override
  public List<GroupDTO> findAll() throws Exception {

    try (PreparedStatement stmt = con.prepareStatement(
        "select"
            + " user_no,"
            + " id,"
            //            + " password,"
            + " email,"
            + " name,"
            + " tel,"
            + " created_dt,"
            + " post_no,"
            + " basic_address,"
            + " detail_address,"
            + " group_cnt"
            + " from"
            + " ftp_user order by user_no asc");
        ResultSet rs = stmt.executeQuery()) {


      ArrayList<GroupDTO> list = new ArrayList<>();

      while (rs.next()) {
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setNo(rs.getInt("user_no"));
        groupDTO.setId(rs.getString("id"));
        //        groupDTO.setPassword(rs.getString("password"));
        groupDTO.setName(rs.getString("name"));
        groupDTO.setEmail(rs.getString("email"));
        groupDTO.setTel(rs.getString("tel"));
        groupDTO.setRegisterDate(rs.getDate("create_dt"));
        groupDTO.setPostNo(rs.getInt("post_no"));
        groupDTO.setBasicAddress(rs.getString("basic_address"));
        groupDTO.setDetailAddress(rs.getString("detail_address"));
        groupDTO.setGroupCount(rs.getInt("group_cnt"));

        list.add(groupDTO);
      }

      return list;
    }
  }

  @Override
  public void update(GroupDTO groupDTO) throws Exception {

    try (PreparedStatement stmt = con.prepareStatement(
        "update ftp_user set"
            + " name=?,password=password(?),tel=?,post_no,basic_address,detail_address,group_cnt"
            + " where user_no=?")) {

      stmt.setString(1, groupDTO.getName());
      stmt.setString(2, groupDTO.getPassword());
      stmt.setString(3, groupDTO.getTel());
      stmt.setInt(4, groupDTO.getPostNo());
      stmt.setString(5, groupDTO.getBasicAddress());
      stmt.setString(6, groupDTO.getDetailAddress());
      stmt.setInt(7, groupDTO.getGroupCount());

      if (stmt.executeUpdate() == 0) {
        throw new Exception("회원 데이터 변경 실패!");
      }
    }
  }


  @Override
  public void delete(GroupDTO groupDTO) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "delete from ftp_user where user_no=?")) {

      stmt.setInt(1, groupDTO.getNo());

      if (stmt.executeUpdate() == 0) {
        throw new Exception("회원 데이터 삭제 실패!");
      }
    }
  }

  @Override
  public GroupDTO validId(GroupDTO groupDTO) throws Exception {
    return null;
  }


  @Override
  public GroupDTO selectOneByIdPassword(String userId, String userPassword) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "select user_no,id,name,email,tel,create_dt from ftp_user"
            + " where id=? and password=password(?)")) {

      stmt.setString(1, userId);
      stmt.setString(2, userPassword);

      try (ResultSet rs = stmt.executeQuery()) {
        if (!rs.next()) {
          return null;
        }

        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setNo(rs.getInt("user_no"));
        groupDTO.setName(rs.getString("name"));
        groupDTO.setEmail(rs.getString("email"));
        groupDTO.setTel(rs.getString("tel"));
        groupDTO.setRegisterDate(rs.getDate("create_dt"));
        return groupDTO;
      }
    }
  }

  @Override
  public GroupDTO selectOneByIdEmail(String userId, String userEmail) throws Exception {

    try (PreparedStatement stmt = con.prepareStatement(
        "select user_no,id,name,email,tel,create_dt from ftp_user"
            + " where id=? and email=?")) {

      stmt.setString(1, userId);
      stmt.setString(2, userEmail);

      try (ResultSet rs = stmt.executeQuery()) {
        if (!rs.next()) {
          return null;
        }

        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setNo(rs.getInt("user_no"));
        groupDTO.setName(rs.getString("name"));
        groupDTO.setEmail(rs.getString("email"));
        groupDTO.setTel(rs.getString("tel"));
        groupDTO.setRegisterDate(rs.getDate("create_dt"));
        return groupDTO;
      }
    }
  }

  @Override
  public GroupDTO selectOneByUser(String userId, String userPassword) throws Exception {
    return null;
  }

  @Override
  public GroupDTO selectOneByEmail(String userEmail) throws Exception {

    try (PreparedStatement stmt = con.prepareStatement(
        "select user_no,id,name,email,tel,create_dt from ftp_user"
            + " where email=?")) {

      stmt.setString(1, userEmail);

      try (ResultSet rs = stmt.executeQuery()) {
        if (!rs.next()) {
          return null;
        }

        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setNo(rs.getInt("user_no"));
        groupDTO.setId(rs.getString("id"));
        groupDTO.setName(rs.getString("name"));
        groupDTO.setEmail(rs.getString("email"));
        groupDTO.setTel(rs.getString("tel"));
        groupDTO.setRegisterDate(rs.getDate("create_dt"));
        return groupDTO;
      }
    }
  }

  @Override
  public GroupDTO selectOneByTel(String userTel) throws Exception {

    try (PreparedStatement stmt = con.prepareStatement(
        "select user_no,id,name,email,tel,create_dt from ftp_user"
            + " where tel=?")) {

      stmt.setString(1, userTel);

      try (ResultSet rs = stmt.executeQuery()) {
        if (!rs.next()) {
          return null;
        }

        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setNo(rs.getInt("user_no"));
        groupDTO.setId(rs.getString("id"));
        groupDTO.setName(rs.getString("name"));
        groupDTO.setEmail(rs.getString("email"));
        groupDTO.setTel(rs.getString("tel"));
        groupDTO.setRegisterDate(rs.getDate("create_dt"));
        return groupDTO;
      }
    }
  }
}
