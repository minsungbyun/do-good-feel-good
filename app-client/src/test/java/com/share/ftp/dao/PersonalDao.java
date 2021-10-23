package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.join.PersonalDTO;

// 역할
//- happyshare 개인회원의 데이터를 처리하는 객체 사용법을 정의한다.
public interface PersonalDao {

  void insert(PersonalDTO personalDTO) throws Exception;          // 회원 추가
  List<PersonalDTO> findAll() throws Exception;               // 회원 목록
  void update(PersonalDTO personalDTO) throws Exception;          // 회원 수정
  void delete(PersonalDTO personalDTO) throws Exception;          // 회원 삭제
  PersonalDTO selectOneByIdPassword(String userId, String userPassword) throws Exception; // 로그인 유효성 검사
  PersonalDTO selectOneByIdEmail(String userId, String userEmail) throws Exception; // 로그인 유효성 검사
  PersonalDTO selectOneByUser(String userId, String userPassword) throws Exception; // 회원정보 상세보기
  PersonalDTO selectOneByEmail(String userEmail) throws Exception; // 회원정보 상세보기
  PersonalDTO selectOneByTel(String userTel) throws Exception; // 회원정보 상세보기
  PersonalDTO validId(PersonalDTO personalDTO) throws Exception;               // 아이디 유효성 검사

}
