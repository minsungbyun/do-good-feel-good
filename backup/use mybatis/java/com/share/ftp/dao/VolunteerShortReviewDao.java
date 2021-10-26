package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;

//역할
//- happyshare 나눔이야기(한 줄 후기)의 데이터를 처리하는 객체 사용법을 정의한다.

public interface VolunteerShortReviewDao {

  // 한 줄 후기 
  void insert(VolunteerRequestDTO volunteerRequestDTO) throws Exception;
  List<VolunteerRequestDTO> findAll() throws Exception;
  List<VolunteerRequestDTO> findByKeyword(String keyword) throws Exception;
  VolunteerRequestDTO findByNo(int no) throws Exception;
  void update(VolunteerRequestDTO volunteerRequestDTO) throws Exception;
  void delete(int no) throws Exception;





}
