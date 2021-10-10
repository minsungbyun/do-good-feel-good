package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.volunteer.OrgRequestApplyDTO;
import com.share.ftp.domain.volunteer.OrgRequestDTO;
import com.share.ftp.domain.volunteer.OrgRequestRejectDTO;
import com.share.ftp.domain.volunteer.PersonalRequestApplyDTO;
import com.share.ftp.domain.volunteer.PersonalRequestDTO;
import com.share.ftp.domain.volunteer.PersonalRequestRejectDTO;

public interface VolunteerDao {

  // 개인 봉사활동
  void insert(PersonalRequestDTO addVol) throws Exception;      
  List<PersonalRequestDTO> findPersonalAll() throws Exception;      
  void update(PersonalRequestDTO updateVol) throws Exception;          
  void delete(PersonalRequestDTO deleteVol) throws Exception;    

  void insert(PersonalRequestApplyDTO addVol) throws Exception;      
  List<PersonalRequestApplyDTO> findPersonalApplyAll() throws Exception;      
  void update(PersonalRequestApplyDTO updateVol) throws Exception;          
  void delete(PersonalRequestApplyDTO deleteVol) throws Exception;    

  void insert(PersonalRequestRejectDTO addVol) throws Exception;      
  List<PersonalRequestRejectDTO> findPersonalRejectAll() throws Exception;      
  void update(PersonalRequestRejectDTO updateVol) throws Exception;          
  void delete(PersonalRequestRejectDTO deleteVol) throws Exception;    

  // 기관 봉사활동
  void insert(OrgRequestDTO addVol) throws Exception;      
  List<OrgRequestDTO> findAll() throws Exception;      
  void update(OrgRequestDTO updateVol) throws Exception;          
  void delete(OrgRequestDTO deleteVol) throws Exception;    

  void insert(OrgRequestApplyDTO addVol) throws Exception;      
  List<OrgRequestApplyDTO> findOrgApplyAll() throws Exception;      
  void update(OrgRequestApplyDTO updateVol) throws Exception;          
  void delete(OrgRequestApplyDTO deleteVol) throws Exception;    

  void insert(OrgRequestRejectDTO addVol) throws Exception;      
  List<OrgRequestRejectDTO> findOrgRejectAll() throws Exception;      
  void update(OrgRequestRejectDTO updateVol) throws Exception;          
  void delete(OrgRequestRejectDTO deleteVol) throws Exception;    


}
