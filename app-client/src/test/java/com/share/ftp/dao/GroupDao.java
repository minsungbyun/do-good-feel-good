package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.join.GroupDTO;

// 역할
//- happyshare 회원의 데이터를 처리하는 객체 사용법을 정의한다.
public interface GroupDao {

  void insert(GroupDTO groupDTO) throws Exception;          // 회원 추가
  List<GroupDTO> findAll() throws Exception;               // 회원 목록
  void update(GroupDTO groupDTO) throws Exception;          // 회원 수정
  void delete(GroupDTO groupDTO) throws Exception;          // 회원 삭제
  GroupDTO selectOneByIdPassword(String userId, String userPassword) throws Exception; // 로그인 유효성 검사
  GroupDTO selectOneByIdEmail(String userId, String userEmail) throws Exception; // 로그인 유효성 검사
  GroupDTO selectOneByUser(String userId, String userPassword) throws Exception; // 회원정보 상세보기
  GroupDTO selectOneByEmail(String userEmail) throws Exception; // 회원정보 상세보기
  GroupDTO selectOneByTel(String userTel) throws Exception; // 회원정보 상세보기
  GroupDTO validId(GroupDTO groupDTO) throws Exception;               // 아이디 유효성 검사

}
