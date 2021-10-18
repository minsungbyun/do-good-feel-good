package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.join.JoinDTO;

// 역할
//- happyshare 회원의 데이터를 처리하는 객체 사용법을 정의한다.
public interface JoinDao {

  void insert(JoinDTO joinDTO) throws Exception;          // 회원 추가
  List<JoinDTO> findAll() throws Exception;               // 회원 목록
  void update(JoinDTO joinDTO) throws Exception;          // 회원 수정
  void delete(JoinDTO joinDTO) throws Exception;          // 회원 삭제
  JoinDTO selectOneByIdPassword(String userId, String userPassword) throws Exception; // 로그인 유효성 검사
  JoinDTO selectOneByIdEmail(String userId, String userEmail) throws Exception; // 로그인 유효성 검사
  JoinDTO selectOneByUser(String userId, String userPassword) throws Exception; // 회원정보 상세보기
  JoinDTO selectOneByEmail(String userEmail) throws Exception; // 회원정보 상세보기
  JoinDTO selectOneByTel(String userTel) throws Exception; // 회원정보 상세보기
  JoinDTO validId(JoinDTO joinDTO) throws Exception;               // 아이디 유효성 검사

}
