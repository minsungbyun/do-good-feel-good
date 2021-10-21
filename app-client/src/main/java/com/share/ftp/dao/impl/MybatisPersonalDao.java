package com.share.ftp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.PersonalDao;
import com.share.ftp.domain.join.PersonalDTO;

//역할
//- 로그인 데이터를 서버를 통해 관리한다.
//
public class MybatisPersonalDao implements PersonalDao {

  Connection con;
  SqlSession sqlSession;

  public MybatisPersonalDao(SqlSession sqlSession) {
    this.sqlSession = sqlSession;
  }

  @Override
  public void insert(PersonalDTO personalDTO) throws Exception {
    sqlSession.insert("PersonalMapper.insert", personalDTO);

    HashMap<String,Object> params = new HashMap<>();
    params.put("userNo", personalDTO.getNo());
    params.put("userBirthdate", personalDTO.getBirthdate());
    params.put("userLevel", personalDTO.getLevel());

    sqlSession.insert("PersonalMapper.insertPersonal", params);
  }

  @Override
  public List<PersonalDTO> findAll() throws Exception {
    return sqlSession.selectList("PersonalMapper.findAllPersonal");
  }

  @Override
  public void update(PersonalDTO personalDTO) throws Exception {
    sqlSession.update("PersonalMapper.update", personalDTO);
    sqlSession.update("PersonalMapper.updatePersonal", personalDTO);
    sqlSession.commit();
    //    try (PreparedStatement stmt = con.prepareStatement(
    //        "update ftp_user set"
    //            + " password=password(?)"
    //            + " where user_no=?")) {
    //
    //      stmt.setString(1, personalDTO.getPassword());
    //      stmt.setInt(2, personalDTO.getNo());
    //      //      stmt.setInt(4, personalDTO.getPostNo());
    //      //      stmt.setString(5, personalDTO.getBasicAddress());
    //      //      stmt.setString(6, personalDTO.getDetailAddress());
    //
    //      if (stmt.executeUpdate() == 0) {
    //        throw new Exception("회원 데이터 변경 실패!");
    //      }
    //    }
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

    HashMap<String,Object> params = new HashMap<>();
    params.put("userId", userId);
    params.put("userPassword", userPassword);

    return sqlSession.selectOne("PersonalMapper.findByIdPassword", params);
    //    try (PreparedStatement stmt = con.prepareStatement(
    //        "select * from ftp_user"
    //            + " where id=? and password=password(?)")) {
    //
    //      stmt.setString(1, userId);
    //      stmt.setString(2, userPassword);
    //
    //      try (ResultSet rs = stmt.executeQuery()) {
    //        if (!rs.next()) {
    //          return null;
    //        }
    //
    //        PersonalDTO personalDTO = new PersonalDTO();
    //        //        personalDTO.setNo(rs.getInt("user_no"));
    //        //        personalDTO.setName(rs.getString("name"));
    //        //        personalDTO.setEmail(rs.getString("email"));
    //        //        personalDTO.setTel(rs.getString("tel"));
    //        //        personalDTO.setRegisterDate(rs.getDate("create_dt"));
    //        personalDTO.setName(rs.getString("name"));
    //        personalDTO.setType(rs.getInt("type"));
    //        return personalDTO;
    //      }
    //    }
  }

  @Override
  public PersonalDTO selectOneByIdEmail(String userId, String userEmail) throws Exception {

    try (PreparedStatement stmt = con.prepareStatement(
        "select password from ftp_user"
            + " where id=? and email=?")) {

      stmt.setString(1, userId);
      stmt.setString(2, userEmail);

      try (ResultSet rs = stmt.executeQuery()) {
        if (!rs.next()) {
          return null;
        }

        //        return rs.getString("password");
        PersonalDTO personalDTO = new PersonalDTO();
        //        personalDTO.setNo(rs.getInt("user_no"));
        //        personalDTO.setName(rs.getString("name"));
        //        personalDTO.setEmail(rs.getString("email"));
        //        personalDTO.setTel(rs.getString("tel"));
        //        personalDTO.setRegisterDate(rs.getDate("create_dt"));
        personalDTO.setPassword(rs.getString("password"));
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
