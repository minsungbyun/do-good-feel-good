package com.share.ftp.dao.impl;

import java.sql.Connection;
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
    sqlSession.insert("CommBoardMapper.insert", addCommBoard);
    sqlSession.commit();
  }

  @Override
  public List<CommBoardDTO> findAll() throws Exception {
    return sqlSession.selectList("CommBoardMapper.findAll");  
  }

  @Override
  public List<CommBoardDTO> findByKeyword(String keyword) throws Exception {
    return sqlSession.selectList("CommBoardMapper.findByKeyword", keyword);
  }


  @Override
  public CommBoardDTO findByCommBoardNo(int commBoardNo) throws Exception {
    return sqlSession.selectOne("CommBoardMapper.findByCommBoardNo", commBoardNo);
  }

  @Override
  public void updateCount(int no) throws Exception {
    sqlSession.update("CommBoardMapper.updateCount", no);
    sqlSession.commit();
  }

  @Override
  public void update(CommBoardDTO updateCommBoard) throws Exception {
    sqlSession.update("CommBoardMapper.update", updateCommBoard);
    sqlSession.commit();
  }

  @Override
  public void delete(CommBoardDTO deleteCommBoard) throws Exception {
    sqlSession.delete("CommBoardMapper.delete", deleteCommBoard);
    sqlSession.commit();
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
