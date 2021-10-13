package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.volunteer.GeneralRequestDTO;
import com.share.ftp.domain.volunteer.VolQuestionDTO;

public interface VolunteerDao {

  // 봉사참여 관련
  void insert(GeneralRequestDTO addVol) throws Exception;      
  List<GeneralRequestDTO> findAll() throws Exception;      
  void update(GeneralRequestDTO updateVol) throws Exception;          
  void delete(GeneralRequestDTO deleteVol) throws Exception;    

  GeneralRequestDTO findByVolNo(int volNo) throws Exception;
  GeneralRequestDTO findByApplyVol(int volApplyNo) throws Exception;
  int getNextNum() throws Exception;       

  //  void insert(PersonalRequestApplyDTO addVol) throws Exception;      
  //  List<PersonalRequestApplyDTO> findPersonalApplyAll() throws Exception;      
  //  void update(PersonalRequestApplyDTO updateVol) throws Exception;          
  //  void delete(PersonalRequestApplyDTO deleteVol) throws Exception;    
  //
  //  void insert(PersonalRequestRejectDTO addVol) throws Exception;      
  //  List<PersonalRequestRejectDTO> findPersonalRejectAll() throws Exception;      
  //  void update(PersonalRequestRejectDTO updateVol) throws Exception;          
  //  void delete(PersonalRequestRejectDTO deleteVol) throws Exception;    

  //  // 기관 봉사활동
  //  void insert(OrgRequestDTO addVol) throws Exception;      
  //  List<OrgRequestDTO> findAll() throws Exception;      
  //  void update(OrgRequestDTO updateVol) throws Exception;          
  //  void delete(OrgRequestDTO deleteVol) throws Exception;    
  //
  //  void insert(OrgRequestApplyDTO addVol) throws Exception;      
  //  List<OrgRequestApplyDTO> findOrgApplyAll() throws Exception;      
  //  void update(OrgRequestApplyDTO updateVol) throws Exception;          
  //  void delete(OrgRequestApplyDTO deleteVol) throws Exception;    
  //
  //  void insert(OrgRequestRejectDTO addVol) throws Exception;      
  //  List<OrgRequestRejectDTO> findOrgRejectAll() throws Exception;      
  //  void update(OrgRequestRejectDTO updateVol) throws Exception;          
  //  void delete(OrgRequestRejectDTO deleteVol) throws Exception;    

  // 봉사 문의사항 관련
  void insertQuestion(VolQuestionDTO addVolQuestionDTO) throws Exception;
  void insertAdmin(int VolQuestionNo, VolQuestionDTO addVolQuestion) throws Exception;
  List<VolQuestionDTO> findAllQuestion() throws Exception;      
  void updateQuestion(VolQuestionDTO updateVolQuestion) throws Exception;          
  void deleteQuestion(VolQuestionDTO VolQuestion) throws Exception; 

  int getNextQuestionNum(GeneralRequestDTO GeneralRequestDTO) throws Exception;
  VolQuestionDTO findByVolQuestionNo(int volNo, int volQuestionNo) throws Exception;

}
