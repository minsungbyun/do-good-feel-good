package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.community.CommBoardReplyDTO;
import com.share.ftp.domain.community.VolunteerBoardCommentDTO;

//역할
//- happyshare 나눔이야기(후기게시판)의 데이터를 처리하는 객체 사용법을 정의한다.

public interface VolunteerBoardCommentDao {

  // 나눔이야기 게시판 댓글 
  void insert(VolunteerBoardCommentDTO volunteerBoardCommentDTO) throws Exception;
  List<CommBoardReplyDTO> findAll() throws Exception;
  VolunteerBoardCommentDTO findByNo(int no) throws Exception;
  void update(VolunteerBoardCommentDTO volunteerBoardCommentDTO) throws Exception;
  void delete(VolunteerBoardCommentDTO no) throws Exception;
  //  CommBoardReplyDTO findByCommReplyNo(int commReplyNo) throws Exception;
  //  VolunteerBoardCommentDTO findByNo(int no, int commBoardReplyNo) throws Exception;

}
