package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.Category;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;

// 역할
// - 봉사신청서를 처리하는 객체 사용법을 정의한다.
public interface VolunteerDao {

  void insert(VolunteerRequestDTO addVolunteer) throws Exception;      
  void insertFile(String filepath) throws Exception;      
  List<VolunteerRequestDTO> findAll() throws Exception;      
  List<VolunteerRequestDTO> findAllApproved() throws Exception;      
  List<VolunteerRequestDTO> findAllWait() throws Exception;      
  List<Category> findAllCategory() throws Exception;      
  void update(VolunteerRequestDTO updateVolunteer) throws Exception;          
  void updateFile(VolunteerRequestDTO updateVolunteer) throws Exception;          
  void delete(VolunteerRequestDTO deleteVolunteer) throws Exception;    
  void deleteFile(VolunteerRequestDTO deleteVolunteer) throws Exception;    

  VolunteerRequestDTO totalDate(int volunteerNo) throws Exception;
  VolunteerRequestDTO remainDate(int volunteerNo) throws Exception;
  VolunteerRequestDTO findByVolunteerNo(int volunteerNo) throws Exception;
  VolunteerRequestDTO findByApprovedVolunteerNo(int volunteerNo) throws Exception;
  VolunteerRequestDTO findByKeyword(String keyword) throws Exception;

}
