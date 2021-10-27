package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.volunteer.VolunteerQuestionDTO;

// 역할
// - 봉사 문의사항를 처리하는 객체 사용법을 정의한다.
public interface VolunteerQuestionDao {

  void insertQuestion(VolunteerQuestionDTO addVolQuestionDTO) throws Exception;
  void insertAdmin(int VolQuestionNo, VolunteerQuestionDTO addVolQuestion) throws Exception;
  List<VolunteerQuestionDTO> findAllQuestion() throws Exception;      
  void updateQuestion(VolunteerQuestionDTO updateVolQuestion) throws Exception;          
  void deleteQuestion(VolunteerQuestionDTO VolQuestion) throws Exception; 

  VolunteerQuestionDTO findByVolQuestionNo(int volNo, int volQuestionNo) throws Exception;
}
