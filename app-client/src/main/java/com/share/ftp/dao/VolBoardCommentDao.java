package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.community.CommBoardReplyDTO;

//역할
//- happyshare 나눔이야기(후기게시판)의 데이터를 처리하는 객체 사용법을 정의한다.

public interface VolBoardCommentDao {

  // 나눔이야기 게시판 댓글 
  void insertCommBoardReply(CommBoardReplyDTO addcommBoardReply) throws Exception;
  List<CommBoardReplyDTO> findAllCommBoardReply() throws Exception;
  CommBoardReplyDTO findByCommBoardReplyNo(int commBoardNo, int commBoardReplyNo) throws Exception;
  void updateCommBoardReply(CommBoardReplyDTO updateCommBoardReply) throws Exception;
  void deleteCommBoardReply(CommBoardReplyDTO deleteCommBoardReply) throws Exception;
  //  CommBoardReplyDTO findByCommReplyNo(int commReplyNo) throws Exception;

}
