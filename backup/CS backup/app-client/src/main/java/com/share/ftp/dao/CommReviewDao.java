package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.personal.CommReviewDTO;

//역할
//- happyshare 한 줄후기()의 데이터를 처리하는 객체 사용법을 정의한다.

public interface CommReviewDao {

  void insert(CommReviewDTO commReviewDTO) throws Exception;
  List<CommReviewDTO> findAll() throws Exception;
  List<CommReviewDTO> findByKeyword(String commReviewkeyword) throws Exception;
  CommReviewDTO findByCommReviewNo(int commReviewNo) throws Exception;
  void update(CommReviewDTO commReviewDTO) throws Exception;
  void delete(int deleteCommReviewNo) throws Exception;
  int getNextNum() throws Exception;            // 게시글 번호 지정
  // like 관련 메서드 들어가야함 
}
