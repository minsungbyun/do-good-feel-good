package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.community.CommReviewDTO;

//역할
//- happyshare 나눔이야기(후기게시판)의 데이터를 처리하는 객체 사용법을 정의한다.

public interface VolShortReviewDao {

  // 한 줄 후기 
  void insertReview(CommReviewDTO addcommReview) throws Exception;
  List<CommReviewDTO> findAllCommReview() throws Exception;
  List<CommReviewDTO> findByCommReviewKeyword(String commReviewkeyword) throws Exception;
  CommReviewDTO findByCommReviewNo(int commReviewNo) throws Exception;
  void updateCommReview(CommReviewDTO updateCommReview) throws Exception;
  void deleteCommeReview(CommReviewDTO deleteCommReview) throws Exception;

  // 나눔이야기 BEST



}
