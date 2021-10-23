package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;

// 역할
// - 봉사신청서를 처리하는 객체 사용법을 정의한다.
public interface VolunteerDao {

  void insert(VolunteerRequestDTO addVol) throws Exception;      
  List<VolunteerRequestDTO> findAll() throws Exception;      
  void update(VolunteerRequestDTO updateVol) throws Exception;          
  void delete(VolunteerRequestDTO deleteVol) throws Exception;    

  VolunteerRequestDTO findByVolNo(int volNo) throws Exception;

}
