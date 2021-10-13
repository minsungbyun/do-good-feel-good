package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.community.CommBoardDTO;
import com.share.ftp.domain.community.CommBoardReplyDTO;
import com.share.ftp.domain.community.CommReviewDTO;

//역할
//- happyshare 나눔이야기(후기게시판)의 데이터를 처리하는 객체 사용법을 정의한다.

public interface CommunityDao {

  // 나눔이야기 게시글
  void insert(CommBoardDTO addcommBoard) throws Exception;
  List<CommBoardDTO> findAll() throws Exception;
  List<CommBoardDTO> findByKeyword(String commBoardkeyword) throws Exception;
  CommBoardDTO findByCommBoardNo(int commBoardNo) throws Exception;
  void update(CommBoardDTO updateCommBoard) throws Exception;
  void delete(CommBoardDTO deleteCommBoard) throws Exception;
  void like(CommBoardDTO likeCommBoard) throws Exception;
  int getNextNum() throws Exception;            // 게시글 번호 지정


  // 나눔이야기 게시판 댓글 
  void insertCommBoardReply(CommBoardReplyDTO addcommBoardReply) throws Exception;
  List<CommBoardReplyDTO> findAllCommBoardReply() throws Exception;
  CommBoardReplyDTO findByCommBoardReplyNo(int commBoardNo, int commBoardReplyNo) throws Exception;
  void updateCommBoardReply(CommBoardReplyDTO updateCommBoardReply) throws Exception;
  void deleteCommBoardReply(CommBoardReplyDTO deleteCommBoardReply) throws Exception;
  int getNextNumCommBoardReply(CommBoardDTO commBoardDTO) throws Exception;            // 게시글 번호 지정
  //  CommBoardReplyDTO findByCommReplyNo(int commReplyNo) throws Exception;


  // 한 줄 후기 
  void insertReview(CommReviewDTO addcommReview) throws Exception;
  List<CommReviewDTO> findAllCommReview() throws Exception;
  List<CommReviewDTO> findByCommReviewKeyword(String commReviewkeyword) throws Exception;
  CommReviewDTO findByCommReviewNo(int commReviewNo) throws Exception;
  void updateCommReview(CommReviewDTO updateCommReview) throws Exception;
  void deleteCommeReview(CommReviewDTO deleteCommReview) throws Exception;
  int getNextNumCommReview() throws Exception;            // 게시글 번호 지정

  // 나눔이야기 BEST



}
