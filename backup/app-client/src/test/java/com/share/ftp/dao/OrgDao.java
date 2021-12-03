package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.join.OrgDTO;

// 역할
//- happyshare 회원의 데이터를 처리하는 객체 사용법을 정의한다.
public interface OrgDao {

  void insert(OrgDTO orgDTO) throws Exception;          // 회원 추가
  List<OrgDTO> findAll() throws Exception;               // 회원 목록
  void update(OrgDTO orgDTO) throws Exception;          // 회원 수정
  void delete(OrgDTO orgDTO) throws Exception;          // 회원 삭제
  OrgDTO selectOneByIdPassword(String userId, String userPassword) throws Exception; // 로그인 유효성 검사
  OrgDTO selectOneByIdEmail(String userId, String userEmail) throws Exception; // 로그인 유효성 검사
  OrgDTO selectOneByUser(String userId, String userPassword) throws Exception; // 회원정보 상세보기
  OrgDTO selectOneByEmail(String userEmail) throws Exception; // 회원정보 상세보기
  OrgDTO selectOneByTel(String userTel) throws Exception; // 회원정보 상세보기
  OrgDTO validId(OrgDTO orgDTO) throws Exception;               // 아이디 유효성 검사

}
