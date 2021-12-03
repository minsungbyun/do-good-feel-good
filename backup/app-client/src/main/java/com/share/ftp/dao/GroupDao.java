package com.share.ftp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.share.ftp.domain.join.GroupDTO;

// 역할
//- happyshare 회원의 데이터를 처리하는 객체 사용법을 정의한다.
public interface GroupDao {

  void insert(GroupDTO groupDTO) throws Exception;          // 단체회원 추가
  void insertGroup(
      @Param("userNo") int userNo, 
      @Param("groupCnt") int groupCount) throws Exception;          // 단체회원 추가
  List<GroupDTO> findAllGroup() throws Exception;               // 단체회원 목록
  List<GroupDTO> findAllWaitGroup() throws Exception;               // 단체회원 목록
  void update(GroupDTO groupDTO) throws Exception;  
  void updateGroup(int groupCount) throws Exception;
  void updateStatus(GroupDTO groupDTO) throws Exception;  
  void updateStatusReject(
      @Param("userNo") int userNo,
      @Param("note") String note) throws Exception; // 단체회원 수정
  //  void updateGroup(GroupDTO groupDTO) throws Exception;
  void delete(GroupDTO groupDTO) throws Exception;   
  void deleteGroup(GroupDTO groupDTO) throws Exception; // 회원 삭제
  //  void deleteGroup(GroupDTO groupDTO) throws Exception;          // 회원 삭제
  GroupDTO findByIdPassword(
      @Param("userId") String userId,
      @Param("userPassword") String userPassword) throws Exception; // 로그인 유효성 검사

  GroupDTO findByGroupNo(int userNo) throws Exception;
  GroupDTO validId(String userId) throws Exception;
  void printNote(int userNo) throws Exception;


  GroupDTO selectOneByIdEmail(String userId, String userEmail) throws Exception; // 로그인 유효성 검사
  GroupDTO selectOneByUser(String userId, String userPassword) throws Exception; // 회원정보 상세보기
  GroupDTO selectOneByEmail(String userEmail) throws Exception; // 회원정보 상세보기
  GroupDTO selectOneByTel(String userTel) throws Exception; // 회원정보 상세보기
  GroupDTO validId(GroupDTO groupDTO) throws Exception;               // 아이디 유효성 검사

}
