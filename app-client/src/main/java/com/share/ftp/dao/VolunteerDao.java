package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;

// 역할
// - 봉사신청서를 처리하는 객체 사용법을 정의한다.
public interface VolunteerDao {

  void insert(VolunteerRequestDTO addVolunteer) throws Exception;      
  List<VolunteerRequestDTO> findAll() throws Exception;      
  void update(VolunteerRequestDTO updateVolunteer) throws Exception;          
  void delete(VolunteerRequestDTO deleteVolunteer) throws Exception;    

  VolunteerRequestDTO findByVolNo(int volunteerNo) throws Exception;

}
