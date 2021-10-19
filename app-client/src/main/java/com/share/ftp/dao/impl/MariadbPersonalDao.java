package com.share.ftp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.share.ftp.dao.PersonalDao;
import com.share.ftp.domain.join.PersonalDTO;

//역할
//- 로그인 데이터를 서버를 통해 관리한다.
//
public class MariadbPersonalDao implements PersonalDao {

  Connection con;

  public MariadbPersonalDao(Connection con) {
    this.con = con;
  }

  @Override
  public void insert(PersonalDTO personalDTO) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "insert into ftp_user(id,password,name,tel,email,post_no,basic_address,detail_address,type,status)"
            + " values(?,password(?),?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS)) {

      stmt.setString(1, personalDTO.getId());
      stmt.setString(2, personalDTO.getPassword());
      stmt.setString(3, personalDTO.getName());
      stmt.setString(4, personalDTO.getTel());
      stmt.setString(5, personalDTO.getEmail());
      stmt.setInt(6, personalDTO.getPostNo());
      stmt.setString(7, personalDTO.getBasicAddress());
      stmt.setString(8, personalDTO.getDetailAddress());
      stmt.setInt(9, personalDTO.getType());
      stmt.setInt(10, personalDTO.getStatus());


      if (stmt.executeUpdate() == 0) {
        throw new Exception("회원 데이터 저장 실패!");
      }

      int userNo = 0;
      try(ResultSet pkRs = stmt.getGeneratedKeys()) {
        if (pkRs.next()) {
          userNo = pkRs.getInt("user_no");
        }
      }

      try(PreparedStatement stmt2 = con.prepareStatement("insert into ftp_user_personal(user_no,birthdate,rank)"
          + " values(?,?,?)")) {
        stmt2.setInt(1, userNo);
        stmt2.setDate(2, personalDTO.getBirthdate());
        stmt2.setString(3, personalDTO.getLevel());
        stmt2.executeUpdate();
      }

      /*
       * 개인회원 조회 join
select
 u.user_no,
 u.id,
 u.name,
 u.tel,
 u.email,
 u.created_dt,
 u.basic_address,
 u.detail_address,
 u.donation,
 u.type,
 p.birthdate,
 p.rank,
 p.point
from ftp_user u
 inner join ftp_user_personal p on u.user_no=p.user_no;
       */

    }
  }

  @Override
  public List<PersonalDTO> findAll() throws Exception {

    try (PreparedStatement stmt = con.prepareStatement(
        "select"
            + " u.user_no,"
            + " u.id,"
            + " u.name,"
            + " u.tel,"
            + " u.email,"
            + " u.created_dt,"
            + " u.basic_address,"
            + " u.detail_address,"
            + " u.donation,"
            + " u.type,"
            + " p.birthdate,"
            + " p.rank,"
            + " p.point"
            + " from ftp_user u"
            + " inner join ftp_user_personal p on u.user_no=p.user_no");
        ResultSet rs = stmt.executeQuery()) {


      ArrayList<PersonalDTO> list = new ArrayList<>();

      while (rs.next()) {
        PersonalDTO personalDTO = new PersonalDTO();
        personalDTO.setNo(rs.getInt("user_no"));
        personalDTO.setId(rs.getString("id"));
        personalDTO.setName(rs.getString("name"));
        personalDTO.setEmail(rs.getString("email"));
        personalDTO.setTel(rs.getString("tel"));
        personalDTO.setRegisterDate(rs.getDate("create_dt"));
        personalDTO.setBasicAddress(rs.getString("basic_address"));
        personalDTO.setDetailAddress(rs.getString("detail_address"));
        personalDTO.setDonationMoney(rs.getInt("donation"));
        personalDTO.setType(rs.getInt("type"));
        personalDTO.setLevel(rs.getString("rank"));
        personalDTO.setPoint(rs.getInt("point"));
        personalDTO.setBirthdate(rs.getDate("birthdate"));

        list.add(personalDTO);
      }

      return list;
    }
  }

  @Override
  public void update(PersonalDTO personalDTO) throws Exception {

    try (PreparedStatement stmt = con.prepareStatement(
        "update ftp_user set"
            + " name=?,password=password(?),tel=?,post_no,basic_address,detail_address"
            + " where user_no=?")) {

      stmt.setString(1, personalDTO.getName());
      stmt.setString(2, personalDTO.getPassword());
      stmt.setString(3, personalDTO.getTel());
      stmt.setInt(4, personalDTO.getPostNo());
      stmt.setString(5, personalDTO.getBasicAddress());
      stmt.setString(6, personalDTO.getDetailAddress());

      if (stmt.executeUpdate() == 0) {
        throw new Exception("회원 데이터 변경 실패!");
      }
    }
  }


  @Override
  public void delete(PersonalDTO personalDTO) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "delete from ftp_user where user_no=?")) {

      stmt.setInt(1, personalDTO.getNo());

      if (stmt.executeUpdate() == 0) {
        throw new Exception("회원 데이터 삭제 실패!");
      }
    }
  }

  @Override
  public PersonalDTO validId(PersonalDTO personalDTO) throws Exception {
    return null;
  }


  @Override
  public PersonalDTO selectOneByIdPassword(String userId, String userPassword) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "select user_no,id,name,email,tel,create_dt from ftp_user"
            + " where id=? and password=password(?)")) {

      stmt.setString(1, userId);
      stmt.setString(2, userPassword);

      try (ResultSet rs = stmt.executeQuery()) {
        if (!rs.next()) {
          return null;
        }

        PersonalDTO personalDTO = new PersonalDTO();
        personalDTO.setNo(rs.getInt("user_no"));
        personalDTO.setName(rs.getString("name"));
        personalDTO.setEmail(rs.getString("email"));
        personalDTO.setTel(rs.getString("tel"));
        personalDTO.setRegisterDate(rs.getDate("create_dt"));
        return personalDTO;
      }
    }
  }

  @Override
  public PersonalDTO selectOneByIdEmail(String userId, String userEmail) throws Exception {

    try (PreparedStatement stmt = con.prepareStatement(
        "select user_no,id,name,email,tel,create_dt from ftp_user"
            + " where id=? and email=?")) {

      stmt.setString(1, userId);
      stmt.setString(2, userEmail);

      try (ResultSet rs = stmt.executeQuery()) {
        if (!rs.next()) {
          return null;
        }

        PersonalDTO personalDTO = new PersonalDTO();
        personalDTO.setNo(rs.getInt("user_no"));
        personalDTO.setName(rs.getString("name"));
        personalDTO.setEmail(rs.getString("email"));
        personalDTO.setTel(rs.getString("tel"));
        personalDTO.setRegisterDate(rs.getDate("create_dt"));
        return personalDTO;
      }
    }
  }

  @Override
  public PersonalDTO selectOneByUser(String userId, String userPassword) throws Exception {
    return null;
  }

  @Override
  public PersonalDTO selectOneByEmail(String userEmail) throws Exception {

    try (PreparedStatement stmt = con.prepareStatement(
        "select user_no,id,name,email,tel,create_dt from ftp_user"
            + " where email=?")) {

      stmt.setString(1, userEmail);

      try (ResultSet rs = stmt.executeQuery()) {
        if (!rs.next()) {
          return null;
        }

        PersonalDTO personalDTO = new PersonalDTO();
        personalDTO.setNo(rs.getInt("user_no"));
        personalDTO.setId(rs.getString("id"));
        personalDTO.setName(rs.getString("name"));
        personalDTO.setEmail(rs.getString("email"));
        personalDTO.setTel(rs.getString("tel"));
        personalDTO.setRegisterDate(rs.getDate("create_dt"));
        return personalDTO;
      }
    }
  }

  @Override
  public PersonalDTO selectOneByTel(String userTel) throws Exception {

    try (PreparedStatement stmt = con.prepareStatement(
        "select user_no,id,name,email,tel,create_dt from ftp_user"
            + " where tel=?")) {

      stmt.setString(1, userTel);

      try (ResultSet rs = stmt.executeQuery()) {
        if (!rs.next()) {
          return null;
        }

        PersonalDTO personalDTO = new PersonalDTO();
        personalDTO.setNo(rs.getInt("user_no"));
        personalDTO.setId(rs.getString("id"));
        personalDTO.setName(rs.getString("name"));
        personalDTO.setEmail(rs.getString("email"));
        personalDTO.setTel(rs.getString("tel"));
        personalDTO.setRegisterDate(rs.getDate("create_dt"));
        return personalDTO;
      }
    }
  }
}
