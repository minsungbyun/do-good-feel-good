package com.share.ftp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.share.ftp.domain.support.QuestionCategory;
import com.share.ftp.domain.support.QuestionListDTO;

// 게시글 데이터를 처리하는 객체 사용법을 정의
public interface QuestionDao {
  void insert(QuestionListDTO addQuestion) throws Exception;
  void insertFile(@Param("qnaNo") int qna_no,
      @Param("filepath") String filepath) throws Exception;
  List<QuestionListDTO> findAll() throws Exception;
  List<QuestionListDTO> findByKeyword(String keyword) throws Exception;
  List<QuestionCategory> findAllQnaCategory() throws Exception;
  QuestionListDTO findByNo(int questionNo) throws Exception;
  QuestionListDTO findByPassword(@Param("qnaNo") int qnaNo,
      @Param("qnaPassword") String password) throws Exception;
  void update(QuestionListDTO updateQuestion) throws Exception;
  void updateFile(QuestionListDTO updateQuestion) throws Exception;
  void updateReply(QuestionListDTO updateQuestionReply) throws Exception;
  void updateStatus(QuestionListDTO updateQuestion) throws Exception;
  void delete(int questionNo) throws Exception;
  void deleteFile(QuestionListDTO updateQuestion) throws Exception;
}
