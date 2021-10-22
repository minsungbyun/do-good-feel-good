package com.share.ftp.dao.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.QuestionDao;
import com.share.ftp.domain.support.QuestionListDTO;

// 게시글을 DBM서버를 통해 관리한다.

public class MybatisQuestionDao implements QuestionDao {

  SqlSession sqlSession;

  public MybatisQuestionDao(SqlSession sqlSession) {
    this.sqlSession = sqlSession;
  }

  @Override
  public void insert(QuestionListDTO addQuestion) throws Exception {

  }
  @Override
  public List<QuestionListDTO> findAll() throws Exception {
    return sqlSession.selectList("QuestionMapper.findAllQuestion");
  }

  @Override
  public List<QuestionListDTO> findByKeyword(String keyword) throws Exception {
    return null;
  }

  @Override
  public QuestionListDTO findByQuestionNo(int questionNo) throws Exception {
    return null;
  }


  @Override
  public void update(QuestionListDTO updateQuestion) throws Exception {

  }

  @Override
  public void delete(int questionNo) throws Exception {

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
