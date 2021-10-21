package com.share.ftp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.CommunityDao;
import com.share.ftp.domain.community.CommBoardDTO;
import com.share.ftp.domain.community.CommBoardReplyDTO;
import com.share.ftp.domain.community.CommReviewDTO;

// 게시글 데이터를 서버를 통해 관리한다.

public class MybatisCommunityDao implements CommunityDao {

  Connection con;
  SqlSession sqlSession;

  public MybatisCommunityDao(SqlSession sqlSession) {
    this.sqlSession=sqlSession;
  }

  @Override
  public void insert(CommBoardDTO addCommBoard) throws Exception {
    try(PreparedStatement stmt = con.prepareStatement(
        "insert into ftp_vol_board(title,content,user_no) values(?,?,?)",
        Statement.RETURN_GENERATED_KEYS)) {

      stmt.setString(1, addCommBoard.getTitle());
      stmt.setString(2, addCommBoard.getContent());
      stmt.setInt(3, addCommBoard.getOwner().getNo());

      if (stmt.executeUpdate() ==0) {
        throw new Exception("나눔이야기 게시글 등록 실패!");
      }

      int commBoardNo = 0;
      try(ResultSet pkRs = stmt.getGeneratedKeys()) {
        if (pkRs.next()) {
          commBoardNo = pkRs.getInt("vol_board_no");
        }
      }
      try(PreparedStatement stmt2 = con.prepareStatement(
          "insert into ftp_vol_board_file(vol_board_no,filepath)"
              + "values(?,?)")) {
        stmt2.setInt(1, commBoardNo);
        stmt2.setString(2, addCommBoard.getFileUpload());
        stmt2.executeUpdate();
      }
    }
  }

  @Override
  public List<CommBoardDTO> findAll() throws Exception {
    return sqlSession.selectList("CommBoardMapper.findAll");  
  }

  @Override
  public List<CommBoardDTO> findByKeyword(String keyword) throws Exception {
    return null;
  }


  @Override
  public CommBoardDTO findByCommBoardNo(int commBoardNo) throws Exception {
    return sqlSession.selectOne("CommBoardMapper.findByCommBoardNo", commBoardNo);
  }

  @Override
  public void update(CommBoardDTO updateCommBoard) throws Exception {
    sqlSession.update("CommBoardMapper.update", updateCommBoard);
  }

  @Override
  public void delete(CommBoardDTO deleteCommBoard) throws Exception {
    sqlSession.delete("CommBoardMapper.delete", deleteCommBoard);
  }

  // 좋아요 구현 필요
  //  @Override
  //  public void like(CommBoardDTO likeCommBoard) throws Exception {
  //
  //  }




  // 한 줄 후기

  @Override
  public void insertReview(CommReviewDTO addCommReview) throws Exception {

  }

  @Override
  public List<CommReviewDTO> findAllCommReview() throws Exception {

    return null;
  }

  @Override
  public List<CommReviewDTO> findByCommReviewKeyword(String commReviewkeyword) throws Exception {

    return null;
  }

  @Override
  public CommReviewDTO findByCommReviewNo(int commReviewNo) throws Exception {

    return null;
  }


  @Override
  public void updateCommReview(CommReviewDTO updateCommReview) throws Exception {

  }

  @Override
  public void deleteCommeReview(CommReviewDTO deleteCommReview) throws Exception {

  }


  // 나눔이야기 댓글

  @Override
  public void insertCommBoardReply(CommBoardReplyDTO addcommBoardReply) throws Exception {

  }


  @Override
  public List<CommBoardReplyDTO> findAllCommBoardReply() throws Exception {

    return null;
  }


  @Override
  public CommBoardReplyDTO findByCommBoardReplyNo(int commBoardNo, int commBoardReplyNo) {

    return null;
  }

  @Override
  public void updateCommBoardReply(CommBoardReplyDTO updateCommBoardReply) throws Exception {

  }


  @Override
  public void deleteCommBoardReply(CommBoardReplyDTO deleteCommBoardReply) throws Exception {

  }




}
