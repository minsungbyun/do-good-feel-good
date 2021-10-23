package com.share.ftp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.share.ftp.dao.OrgDao;
import com.share.ftp.domain.join.OrgDTO;

//역할
//- 로그인 데이터를 서버를 통해 관리한다.
//
public class MariadbOrgDao implements OrgDao {

  Connection con;

  public MariadbOrgDao(Connection con) {
    this.con = con;
  }

  @Override
  public void insert(OrgDTO orgDTO) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "insert into ftp_user(id,password,name,tel,email,post_no,basic_address,detail_address,type,status)"
            + " values(?,password(?),?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS)) {

      stmt.setString(1, orgDTO.getId());
      stmt.setString(2, orgDTO.getPassword());
      stmt.setString(3, orgDTO.getName());
      stmt.setString(4, orgDTO.getTel());
      stmt.setString(5, orgDTO.getEmail());
      stmt.setInt(6, orgDTO.getPostNo());
      stmt.setString(7, orgDTO.getBasicAddress());
      stmt.setString(8, orgDTO.getDetailAddress());
      stmt.setInt(9, orgDTO.getType());
      stmt.setInt(10, orgDTO.getStatus());


      if (stmt.executeUpdate() == 0) {
        throw new Exception("회원 데이터 저장 실패!");
      }

      int userNo = 0;
      try(ResultSet pkRs = stmt.getGeneratedKeys()) {
        if (pkRs.next()) {
          userNo = pkRs.getInt("user_no");
        }
      }

      try(PreparedStatement stmt2 = con.prepareStatement("insert into ftp_user_org(user_no,corp_no,fax,hp)"
          + " values(?,?,?,?)")) {
        stmt2.setInt(1, userNo);
        stmt2.setString(2, orgDTO.getCorpNo());
        stmt2.setString(3, orgDTO.getFax());
        stmt2.setString(4, orgDTO.getHomepage());
        stmt2.executeUpdate();
      }



    }
  }

  @Override
  public List<OrgDTO> findAll() throws Exception {

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
            + " corp_no,"
            + " fax,"
            + " hp"
            + " from"
            + " ftp_user order by user_no asc");
        ResultSet rs = stmt.executeQuery()) {


      ArrayList<OrgDTO> list = new ArrayList<>();

      while (rs.next()) {
        OrgDTO orgDTO = new OrgDTO();
        orgDTO.setNo(rs.getInt("user_no"));
        orgDTO.setId(rs.getString("id"));
        //        orgDTO.setPassword(rs.getString("password"));
        orgDTO.setName(rs.getString("name"));
        orgDTO.setEmail(rs.getString("email"));
        orgDTO.setTel(rs.getString("tel"));
        orgDTO.setRegisterDate(rs.getDate("create_dt"));
        orgDTO.setPostNo(rs.getInt("post_no"));
        orgDTO.setBasicAddress(rs.getString("basic_address"));
        orgDTO.setDetailAddress(rs.getString("detail_address"));
        orgDTO.setCorpNo(rs.getString("corp_no"));
        orgDTO.setFax(rs.getString("fax"));
        orgDTO.setHomepage(rs.getString("hp"));

        list.add(orgDTO);
      }

      return list;
    }
  }

  @Override
  public void update(OrgDTO orgDTO) throws Exception {

    try (PreparedStatement stmt = con.prepareStatement(
        "update ftp_user set"
            + " name=?,password=password(?),tel=?,post_no,basic_address,detail_address,corp_no,fax,hp"
            + " where user_no=?")) {

      stmt.setString(1, orgDTO.getName());
      stmt.setString(2, orgDTO.getPassword());
      stmt.setString(3, orgDTO.getTel());
      stmt.setInt(4, orgDTO.getPostNo());
      stmt.setString(5, orgDTO.getBasicAddress());
      stmt.setString(6, orgDTO.getDetailAddress());
      stmt.setString(7, orgDTO.getCorpNo());
      stmt.setString(8, orgDTO.getFax());
      stmt.setString(9, orgDTO.getHomepage());

      if (stmt.executeUpdate() == 0) {
        throw new Exception("회원 데이터 변경 실패!");
      }
    }
  }


  @Override
  public void delete(OrgDTO orgDTO) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "delete from ftp_user where user_no=?")) {

      stmt.setInt(1, orgDTO.getNo());

      if (stmt.executeUpdate() == 0) {
        throw new Exception("회원 데이터 삭제 실패!");
      }
    }
  }

  @Override
  public OrgDTO validId(OrgDTO orgDTO) throws Exception {
    return null;
  }


  @Override
  public OrgDTO selectOneByIdPassword(String userId, String userPassword) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "select user_no,id,name,email,tel,create_dt from ftp_user"
            + " where id=? and password=password(?)")) {

      stmt.setString(1, userId);
      stmt.setString(2, userPassword);

      try (ResultSet rs = stmt.executeQuery()) {
        if (!rs.next()) {
          return null;
        }

        OrgDTO orgDTO = new OrgDTO();
        orgDTO.setNo(rs.getInt("user_no"));
        orgDTO.setName(rs.getString("name"));
        orgDTO.setEmail(rs.getString("email"));
        orgDTO.setTel(rs.getString("tel"));
        orgDTO.setRegisterDate(rs.getDate("create_dt"));
        return orgDTO;
      }
    }
  }

  @Override
  public OrgDTO selectOneByIdEmail(String userId, String userEmail) throws Exception {

    try (PreparedStatement stmt = con.prepareStatement(
        "select user_no,id,name,email,tel,create_dt from ftp_user"
            + " where id=? and email=?")) {

      stmt.setString(1, userId);
      stmt.setString(2, userEmail);

      try (ResultSet rs = stmt.executeQuery()) {
        if (!rs.next()) {
          return null;
        }

        OrgDTO orgDTO = new OrgDTO();
        orgDTO.setNo(rs.getInt("user_no"));
        orgDTO.setName(rs.getString("name"));
        orgDTO.setEmail(rs.getString("email"));
        orgDTO.setTel(rs.getString("tel"));
        orgDTO.setRegisterDate(rs.getDate("create_dt"));
        return orgDTO;
      }
    }
  }

  @Override
  public OrgDTO selectOneByUser(String userId, String userPassword) throws Exception {
    return null;
  }

  @Override
  public OrgDTO selectOneByEmail(String userEmail) throws Exception {

    try (PreparedStatement stmt = con.prepareStatement(
        "select user_no,id,name,email,tel,create_dt from ftp_user"
            + " where email=?")) {

      stmt.setString(1, userEmail);

      try (ResultSet rs = stmt.executeQuery()) {
        if (!rs.next()) {
          return null;
        }

        OrgDTO orgDTO = new OrgDTO();
        orgDTO.setNo(rs.getInt("user_no"));
        orgDTO.setId(rs.getString("id"));
        orgDTO.setName(rs.getString("name"));
        orgDTO.setEmail(rs.getString("email"));
        orgDTO.setTel(rs.getString("tel"));
        orgDTO.setRegisterDate(rs.getDate("create_dt"));
        return orgDTO;
      }
    }
  }

  @Override
  public OrgDTO selectOneByTel(String userTel) throws Exception {

    try (PreparedStatement stmt = con.prepareStatement(
        "select user_no,id,name,email,tel,create_dt from ftp_user"
            + " where tel=?")) {

      stmt.setString(1, userTel);

      try (ResultSet rs = stmt.executeQuery()) {
        if (!rs.next()) {
          return null;
        }

        OrgDTO orgDTO = new OrgDTO();
        orgDTO.setNo(rs.getInt("user_no"));
        orgDTO.setId(rs.getString("id"));
        orgDTO.setName(rs.getString("name"));
        orgDTO.setEmail(rs.getString("email"));
        orgDTO.setTel(rs.getString("tel"));
        orgDTO.setRegisterDate(rs.getDate("create_dt"));
        return orgDTO;
      }
    }
  }
}
