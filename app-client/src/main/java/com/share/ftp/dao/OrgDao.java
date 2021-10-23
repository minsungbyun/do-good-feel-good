package com.share.ftp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.share.ftp.domain.join.OrgDTO;

// 역할
//- happyshare 회원의 데이터를 처리하는 객체 사용법을 정의한다.
public interface OrgDao {

  void insert(OrgDTO orgDTO) throws Exception;          // 기관회원 추가
  void insertOrg(
      @Param("userNo") int userNo,
      @Param("corpNo") String corpNo,
      @Param("fax") String fax,
      @Param("homepage") String homepage) throws Exception;          // 기관회원 추가
  List<OrgDTO> findAllOrg() throws Exception;               // 기관회원 목록
  void update(OrgDTO orgDTO) throws Exception;          // 기관회원 수정
  //  void updateOrg(OrgDTO orgDTO) throws Exception;          // 기관회원 수정
  void delete(OrgDTO orgDTO) throws Exception;          // 기관회원 삭제
  //  void deleteOrg(OrgDTO orgDTO) throws Exception;          // 기관회원 삭제
  OrgDTO findByIdPassword(
      @Param("userId") String userId,
      @Param("userPassword") String userPassword) throws Exception; // 로그인 유효성 검사
  OrgDTO selectOneByIdEmail(String userId, String userEmail) throws Exception; // 로그인 유효성 검사
  OrgDTO selectOneByUser(String userId, String userPassword) throws Exception; // 회원정보 상세보기
  OrgDTO selectOneByEmail(String userEmail) throws Exception; // 회원정보 상세보기
  OrgDTO selectOneByTel(String userTel) throws Exception; // 회원정보 상세보기
  OrgDTO validId(OrgDTO orgDTO) throws Exception;               // 아이디 유효성 검사

}
