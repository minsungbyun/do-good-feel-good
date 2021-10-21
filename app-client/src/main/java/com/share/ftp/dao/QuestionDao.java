package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.support.QuestionListDTO;

// 게시글 데이터를 처리하는 객체 사용법을 정의
public interface QuestionDao {

  void insert(QuestionListDTO addQuestion) throws Exception;
  List<QuestionListDTO> findAll() throws Exception;
  List<QuestionListDTO> findByKeyword(String keyword) throws Exception;
  QuestionListDTO findByQuestionNo(int questionNo) throws Exception;
  void update(QuestionListDTO updateQuestion) throws Exception;
  void delete(int questionNo) throws Exception;
  //  int getNextNum() throws Exception; // 회원 고유번호 지정
  //  int getNextQuestionNum(QuestionListDTO question) throws Exception;

}
