package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.community.VolunteerBoardDTO;
import com.share.ftp.domain.volunteer.VolunteerJoinDTO;

//역할
//- 봉사 게시판의 데이터를 처리하는 객체 사용법을 정의한다.

public interface VolunteerJoinDao {

  void insertUser(VolunteerJoinDTO VolunteerJoinDTO) throws Exception;
  List<VolunteerBoardDTO> findAllUser() throws Exception;
  void getCount(int volNo) throws Exception;
  void updateStatus(VolunteerJoinDTO VolunteerJoinDTO) throws Exception;
  void delete(int volNo) throws Exception;

}