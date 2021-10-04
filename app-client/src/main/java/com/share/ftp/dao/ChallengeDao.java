package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.join.JoinDTO;

public interface ChallengeDao {


  ChallengeDTO findByChallengeNo(int no) throws Exception;
  String getRemainTime(long millis) throws Exception;
  int getNextNum() throws Exception;            // 회원 고유번호 지정
  void insert(ChallengeDTO challengeDTO) throws Exception;          // 회원 추가
  List<ChallengeDTO> findAll() throws Exception;               // 회원 목록

  void update(ChallengeDTO challengeDTO) throws Exception;          // 회원 수정
  void delete(ChallengeDTO challengeDTO) throws Exception;          // 회원 삭제
  JoinDTO selectOneByIdPassword(String userId, String userPassword) throws Exception; // 로그인 유효성 검사
  JoinDTO selectOneByIdEmail(String userId, String userEmail) throws Exception; // 로그인 유효성 검사
  JoinDTO selectOneByUser(String userId, String userPassword) throws Exception; // 회원정보 상세보기
  JoinDTO selectOneByEmail(String userEmail) throws Exception; // 회원정보 상세보기
  JoinDTO selectOneByTel(String userTel) throws Exception; // 회원정보 상세보기
  JoinDTO validId(ChallengeDTO challengeDTO) throws Exception;               // 아이디 유효성 검사


}
