package com.share.ftp.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.share.ftp.dao.JoinDao;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.request.RequestAgent;

//역할
//- 로그인 데이터를 서버를 통해 관리한다.
//
public class NetJoinDao implements JoinDao {

  RequestAgent requestAgent;

  public NetJoinDao(RequestAgent requestAgent) {
    this.requestAgent = requestAgent;
  }

  @Override
  public void insert(JoinDTO joinDTO) throws Exception {
    requestAgent.request("join.insert", joinDTO);

    if (requestAgent.getStatus().equals(RequestAgent.SUCCESS)) {
      System.out.println("회원가입이 정상적으로 완료되었습니다.");

    } else {
      throw new Exception("회원가입 실패!");
    }
  }

  @Override
  public List<JoinDTO> findAll() throws Exception {

    requestAgent.request("join.selectList", null);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("회원 목록 조회 실패!");
    }

    return new ArrayList<>(requestAgent.getObjects(JoinDTO.class));
  }

  @Override
  public void update(JoinDTO joinDTO) throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public void delete(JoinDTO loginUser) throws Exception {

    requestAgent.request("join.delete", loginUser);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("회원 탈퇴 실패!");
    }

  }

  @Override
  public JoinDTO validId(JoinDTO joinDTO) throws Exception {

    //    HashMap<String,String> params = new HashMap<>();
    //    params.put("validId", setUserId);
    //    params.put("joinDTO", String.valueOf(joinDTO));

    requestAgent.request("join.validId", joinDTO);

    if (requestAgent.getStatus().equals(RequestAgent.SUCCESS)) {
      return null;

    } else {
      return requestAgent.getObject(JoinDTO.class);

    }

  }


  @Override
  public int getNextNum() throws Exception {

    requestAgent.request("join.getNextNum", null);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("고유번호 부여 중 오류 발생!");
    }
    JoinDTO joinDTO = requestAgent.getObject(JoinDTO.class);


    return joinDTO.getNo();
  }

  @Override
  public JoinDTO selectOneByIdPassword(String userId, String userPassword) throws Exception {

    HashMap<String,String> params = new HashMap<>();
    params.put("loginId", userId);
    params.put("loginPassword", userPassword);

    requestAgent.request("join.selectOneByIdPassword", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      return null;
    } else {
      return requestAgent.getObject(JoinDTO.class);

    }

  }

  @Override
  public JoinDTO selectOneByIdEmail(String userId, String userEmail) throws Exception {

    HashMap<String,String> params = new HashMap<>();
    params.put("loginId", userId);
    params.put("loginEmail", userEmail);

    requestAgent.request("join.selectOneByIdEmail", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      return null;
    }

    return requestAgent.getObject(JoinDTO.class);
  }

  @Override
  public JoinDTO selectOneByUser(String userId, String userPassword) throws Exception {

    HashMap<String,String> params = new HashMap<>();
    params.put("userId", userId);
    params.put("userPassword", userPassword);

    requestAgent.request("join.selectOneByUser", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      return null;
    }

    return requestAgent.getObject(JoinDTO.class);
  }

  @Override
  public JoinDTO selectOneByEmail(String userEmail) throws Exception {

    HashMap<String,String> params = new HashMap<>();
    params.put("userEmail", userEmail);

    requestAgent.request("join.selectOneByEmail", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      return null;
    }

    return requestAgent.getObject(JoinDTO.class);
  }

  @Override
  public JoinDTO selectOneByTel(String userTel) throws Exception {
    HashMap<String,String> params = new HashMap<>();
    params.put("userTel", userTel);

    requestAgent.request("join.selectOneByTel", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      return null;
    }

    return requestAgent.getObject(JoinDTO.class);
  }



}
