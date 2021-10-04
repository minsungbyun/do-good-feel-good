package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.personal.QuestionListDTO;

// 게시글 데이터를 처리하는 객체 사용법을 정의
public interface QuestionDao {

  void insert(QuestionListDTO myQuestionListDTO) throws Exception;
  List<QuestionListDTO> findAll() throws Exception;
  List<QuestionListDTO> findByKeyword(String keyword) throws Exception;
  QuestionListDTO findByNo(int no) throws Exception;
  void update(QuestionListDTO myQuestionListDTO) throws Exception;
  void delete(int no) throws Exception;
  int getNextNum() throws Exception; // 회원 고유번호 지정
  //connect 추가(?)

}
