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
  List<JoinDTO> selectOneByIdPassword() throws Exception; // 로그인 유효성 검사
  List<JoinDTO> validId() throws Exception;               // 아이디 유효성 검사
  List<JoinDTO> getNextNum() throws Exception;            // 회원 고유번호 지정

}
