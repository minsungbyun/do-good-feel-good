package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.volunteer.VolunteerJoinDTO;

// 역할
// - 봉사신청서를 처리하는 객체 사용법을 정의한다.
public interface VolunteerJoinDao {

  List<VolunteerJoinDTO> findAll(int volunteerNo) throws Exception;      
  void insert(VolunteerJoinDTO addVolunteer) throws Exception;      
  void update(VolunteerJoinDTO updateVolunteer) throws Exception;          
  void delete(VolunteerJoinDTO deleteVolunteer) throws Exception;    
  VolunteerJoinDTO findByVolunteerNo(int volunteerNo) throws Exception;

}
