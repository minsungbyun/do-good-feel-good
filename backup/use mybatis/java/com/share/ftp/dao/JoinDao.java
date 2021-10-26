package com.share.ftp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.share.ftp.domain.join.JoinDTO;

// 역할
//- happyshare 회원의 데이터를 처리하는 객체 사용법을 정의한다.
public interface JoinDao {

  List<JoinDTO> findAll() throws Exception;               // 회원 목록

  JoinDTO findByIdPassword(
      @Param("userId") String userId, 
      @Param("userPassword") String userPassword) throws Exception;

  JoinDTO findByType(String userId) throws Exception;
  JoinDTO selectOneByIdPassword(String userId, String userPassword) throws Exception; // 로그인 유효성 검사
  JoinDTO selectOneByIdEmail(String userId, String userEmail) throws Exception; // 로그인 유효성 검사
  JoinDTO selectOneByUser(String userId, String userPassword) throws Exception; // 회원정보 상세보기
  JoinDTO selectOneByEmail(String userEmail) throws Exception; // 회원정보 상세보기
  JoinDTO selectOneByTel(String userTel) throws Exception; // 회원정보 상세보기
  JoinDTO validId(JoinDTO joinDTO) throws Exception;               // 아이디 유효성 검사

}
