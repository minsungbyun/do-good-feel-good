package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.community.VolunteerBoardDTO;

//역할
//- happyshare 나눔이야기(후기게시판)의 데이터를 처리하는 객체 사용법을 정의한다.

public interface VolunteerBoardDao {

  // 나눔이야기 게시글
  void insert(VolunteerBoardDTO volunteerBoardDTO) throws Exception;
  List<VolunteerBoardDTO> findAll() throws Exception;
  List<VolunteerBoardDTO> findByKeyword(String keyword) throws Exception;
  VolunteerBoardDTO findByNo(int no) throws Exception;
  void updateCount(int no) throws Exception;
  void update(VolunteerBoardDTO volunteerBoardDTO) throws Exception;
  void delete(int no) throws Exception;
  //  void like(VolunteerBoardDTO likeCommBoard) throws Exception;

}
