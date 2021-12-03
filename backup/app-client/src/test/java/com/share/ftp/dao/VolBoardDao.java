package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.community.CommBoardDTO;

//역할
//- happyshare 나눔이야기(후기게시판)의 데이터를 처리하는 객체 사용법을 정의한다.

public interface VolBoardDao {

  // 나눔이야기 게시글
  void insert(CommBoardDTO addcommBoard) throws Exception;
  List<CommBoardDTO> findAll() throws Exception;
  List<CommBoardDTO> findByKeyword(String commBoardkeyword) throws Exception;
  CommBoardDTO findByCommBoardNo(int commBoardNo) throws Exception;
  void updateCount(int no) throws Exception;
  void update(CommBoardDTO updateCommBoard) throws Exception;
  void delete(CommBoardDTO deleteCommBoard) throws Exception;
  //  void like(CommBoardDTO likeCommBoard) throws Exception;

}
