package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.volunteer.VolQuestionDTO;

// 역할
// - 봉사 문의사항를 처리하는 객체 사용법을 정의한다.
public interface VolunteerQuestionDao {

  void insertQuestion(VolQuestionDTO addVolQuestionDTO) throws Exception;
  void insertAdmin(int VolQuestionNo, VolQuestionDTO addVolQuestion) throws Exception;
  List<VolQuestionDTO> findAllQuestion() throws Exception;      
  void updateQuestion(VolQuestionDTO updateVolQuestion) throws Exception;          
  void deleteQuestion(VolQuestionDTO VolQuestion) throws Exception; 

  VolQuestionDTO findByVolQuestionNo(int volNo, int volQuestionNo) throws Exception;
}
