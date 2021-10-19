package com.share.ftp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.share.ftp.dao.NoticeDao;
import com.share.ftp.domain.admin.NoticeDTO;

// 게시글을 DBM서버를 통해 관리한다.

public class MariadbNoticeDao implements NoticeDao {

  Connection con;

  public MariadbNoticeDao(Connection con) {
    this.con = con;
  }

  @Override
  public void insert(NoticeDTO addNotice) throws Exception {

    try (PreparedStatement stmt = con.prepareStatement(
        "insert into ftp_support_notice(title,content,filepath) values(?,?,?)",
        Statement.RETURN_GENERATED_KEYS)) {

      stmt.setString(1, addNotice.getTitle());
      stmt.setString(2, addNotice.getContent());
      stmt.setString(3, addNotice.getFileUpload());

      if (stmt.executeUpdate() == 0) {
        throw new Exception("게시글 데이터 입력 실패!");
      }
    }
  }
  @Override
  public List<NoticeDTO> findAll() throws Exception {

    try (PreparedStatement stmt = con.prepareStatement(
        "select "
            + " notice_no"
            + " title,"
            + " create_dt,"
            + " view_cnt"
            + " from"
            + " ftp_support_notice"
            + " order by noticeNo desc");
        ResultSet rs = stmt.executeQuery()) {

      ArrayList<NoticeDTO> list = new ArrayList<>();

      while (rs.next()) {
        NoticeDTO noticeDTO = new NoticeDTO();
        noticeDTO.setNo(rs.getInt("notice_no"));
        noticeDTO.setTitle(rs.getString("title"));
        noticeDTO.setRegisteredDate(rs.getDate("create_dt"));
        noticeDTO.setViewCount(rs.getInt("view_cnt"));

        list.add(noticeDTO);
      }

      return list;
    }
  }

  @Override
  public List<NoticeDTO> findByKeyword(String keyword) throws Exception {
    return null;
  }

  @Override
  public NoticeDTO findByNoticeNo(int noticeNo) throws Exception {
    return null;
  }


  @Override
  public void update(NoticeDTO updateNotice) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "update ftp_support_notice set"
            + " title=?,content=?"
            + " where notice_no=?")) {

      stmt.setString(1, updateNotice.getTitle());
      stmt.setString(2, updateNotice.getContent());
      stmt.setInt(3, updateNotice.getNo());

      if (stmt.executeUpdate() == 0) {
        throw new Exception("게시글 데이터 변경 실패!");
      }
    }
  }

  @Override
  public void delete(int noticeNo) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "delete from ftp_support_notice where notice_no=?")) {

      stmt.setInt(1, noticeNo);

      if (stmt.executeUpdate() == 0) {
        throw new Exception("게시글 데이터 삭제 실패!");
      }
    }
  }


  //  @Override
  //  public int getNextNum() throws Exception {
  //
  //    requestAgent.request("notice.getNextNum", null);
  //
  //
  //    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
  //      throw new Exception("게시글 번호 부여 중 오류 발생!");
  //    }
  //    System.out.println("확인");
  //    NoticeDTO noticeDTO = requestAgent.getObject(NoticeDTO.class);
  //
  //
  //    return noticeDTO.getNo();
  //  }

}
