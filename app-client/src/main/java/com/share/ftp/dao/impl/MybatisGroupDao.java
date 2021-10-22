package com.share.ftp.dao.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.GroupDao;
import com.share.ftp.domain.join.GroupDTO;

//역할
//- 로그인 데이터를 서버를 통해 관리한다.
//
public class MybatisGroupDao implements GroupDao {

  SqlSession sqlSession;

  public MybatisGroupDao(SqlSession sqlSession) {
    this.sqlSession = sqlSession;
  }

  @Override
  public void insert(GroupDTO groupDTO) throws Exception {
    //    try (PreparedStatement stmt = con.prepareStatement(
    //        "insert into ftp_user(id,password,name,tel,email,post_no,basic_address,detail_address,type,status)"
    //            + " values(?,password(?),?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS)) {
    //
    //      stmt.setString(1, personalDTO.getId());
    //      stmt.setString(2, personalDTO.getPassword());
    //      stmt.setString(3, personalDTO.getName());
    //      stmt.setString(4, personalDTO.getTel());
    //      stmt.setString(5, personalDTO.getEmail());
    //      stmt.setInt(6, personalDTO.getPostNo());
    //      stmt.setString(7, personalDTO.getBasicAddress());
    //      stmt.setString(8, personalDTO.getDetailAddress());
    //      stmt.setInt(9, personalDTO.getType());
    //      stmt.setInt(10, personalDTO.getStatus());
    //
    //
    //      if (stmt.executeUpdate() == 0) {
    //        throw new Exception("회원 데이터 저장 실패!");
    //      }
    //
    //      int userNo = 0;
    //      try(ResultSet pkRs = stmt.getGeneratedKeys()) {
    //        if (pkRs.next()) {
    //          userNo = pkRs.getInt("user_no");
    //        }
    //      }
    //
    //      try(PreparedStatement stmt2 = con.prepareStatement("insert into ftp_user_personal(user_no,birthdate,rank)"
    //          + " values(?,?,?)")) {
    //        stmt2.setInt(1, userNo);
    //        stmt2.setDate(2, personalDTO.getBirthdate());
    //        stmt2.setString(3, personalDTO.getLevel());
    //        stmt2.executeUpdate();
    //      }
    //    }
  }

  @Override
  public List<GroupDTO> findAll() throws Exception {
    return sqlSession.selectList("GroupMapper.findAllGroup");

  }

  @Override
  public void update(GroupDTO groupDTO) throws Exception {

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
  public void delete(GroupDTO groupDTO) throws Exception {
    //    try (PreparedStatement stmt = con.prepareStatement(
    //        "delete from ftp_user where user_no=?")) {
    //
    //      stmt.setInt(1, personalDTO.getNo());
    //
    //      if (stmt.executeUpdate() == 0) {
    //        throw new Exception("회원 데이터 삭제 실패!");
    //      }
    //    }
  }

  @Override
  public GroupDTO selectOneByEmail(String userEmail) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }
  @Override
  public GroupDTO selectOneByIdEmail(String userId, String userEmail) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }
  @Override
  public GroupDTO selectOneByIdPassword(String userId, String userPassword) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }
  @Override
  public GroupDTO selectOneByTel(String userTel) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }
  @Override
  public GroupDTO selectOneByUser(String userId, String userPassword) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }
  @Override
  public GroupDTO validId(GroupDTO groupDTO) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  //  @Override
  //  public GroupDTO validId(GroupDTO groupDTO) throws Exception {
  //    return null;
  //  }
  //
  //
  //  @Override
  //  public PersonalDTO selectOneByIdPassword(String userId, String userPassword) throws Exception {
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
  //  }
  //
  //  @Override
  //  public PersonalDTO selectOneByIdEmail(String userId, String userEmail) throws Exception {
  //
  //    try (PreparedStatement stmt = con.prepareStatement(
  //        "select password from ftp_user"
  //            + " where id=? and email=?")) {
  //
  //      stmt.setString(1, userId);
  //      stmt.setString(2, userEmail);
  //
  //      try (ResultSet rs = stmt.executeQuery()) {
  //        if (!rs.next()) {
  //          return null;
  //        }
  //
  //        //        return rs.getString("password");
  //        PersonalDTO personalDTO = new PersonalDTO();
  //        //        personalDTO.setNo(rs.getInt("user_no"));
  //        //        personalDTO.setName(rs.getString("name"));
  //        //        personalDTO.setEmail(rs.getString("email"));
  //        //        personalDTO.setTel(rs.getString("tel"));
  //        //        personalDTO.setRegisterDate(rs.getDate("create_dt"));
  //        personalDTO.setPassword(rs.getString("password"));
  //        return personalDTO;
  //      }
  //    }
  //  }
  //
  //  @Override
  //  public PersonalDTO selectOneByUser(String userId, String userPassword) throws Exception {
  //    return null;
  //  }
  //
  //  @Override
  //  public PersonalDTO selectOneByEmail(String userEmail) throws Exception {
  //
  //    try (PreparedStatement stmt = con.prepareStatement(
  //        "select user_no,id,name,email,tel,create_dt from ftp_user"
  //            + " where email=?")) {
  //
  //      stmt.setString(1, userEmail);
  //
  //      try (ResultSet rs = stmt.executeQuery()) {
  //        if (!rs.next()) {
  //          return null;
  //        }
  //
  //        PersonalDTO personalDTO = new PersonalDTO();
  //        personalDTO.setNo(rs.getInt("user_no"));
  //        personalDTO.setId(rs.getString("id"));
  //        personalDTO.setName(rs.getString("name"));
  //        personalDTO.setEmail(rs.getString("email"));
  //        personalDTO.setTel(rs.getString("tel"));
  //        personalDTO.setRegisterDate(rs.getDate("create_dt"));
  //        return personalDTO;
  //      }
  //    }
  //  }
  //
  //  @Override
  //  public PersonalDTO selectOneByTel(String userTel) throws Exception {
  //
  //    try (PreparedStatement stmt = con.prepareStatement(
  //        "select user_no,id,name,email,tel,create_dt from ftp_user"
  //            + " where tel=?")) {
  //
  //      stmt.setString(1, userTel);
  //
  //      try (ResultSet rs = stmt.executeQuery()) {
  //        if (!rs.next()) {
  //          return null;
  //        }
  //
  //        PersonalDTO personalDTO = new PersonalDTO();
  //        personalDTO.setNo(rs.getInt("user_no"));
  //        personalDTO.setId(rs.getString("id"));
  //        personalDTO.setName(rs.getString("name"));
  //        personalDTO.setEmail(rs.getString("email"));
  //        personalDTO.setTel(rs.getString("tel"));
  //        personalDTO.setRegisterDate(rs.getDate("create_dt"));
  //        return personalDTO;
  //      }
  //    }
  //  }
}
