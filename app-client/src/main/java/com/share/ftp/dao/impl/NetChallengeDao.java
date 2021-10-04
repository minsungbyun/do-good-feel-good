package com.share.ftp.dao.impl;

import java.util.ArrayList;
import java.util.List;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.request.RequestAgent;

public class NetChallengeDao implements ChallengeDao {

  RequestAgent requestAgent;

  public NetChallengeDao(RequestAgent requestAgent) {
    this.requestAgent = requestAgent;
  }

  @Override
  public int getNextNum() throws Exception {

    requestAgent.request("challenge.getNextNum", null);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("고유번호 부여 중 오류 발생!");
    }
    ChallengeDTO challengeDTO = requestAgent.getObject(ChallengeDTO.class);


    return challengeDTO.getNo();
  }

  @Override
  public void insert(ChallengeDTO challengeDTO) throws Exception {

    requestAgent.request("challenge.insert", challengeDTO);

    if (requestAgent.getStatus().equals(RequestAgent.SUCCESS)) {
      System.out.println("[ 챌린지 등록이 정상적으로 완료되었습니다! ]");

    } else {
      throw new Exception("챌린지 등록 실패!");
    }
  }

  @Override
  public List<ChallengeDTO> findAll() throws Exception {

    requestAgent.request("challenge.selectList", null);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("챌린지 목록 조회 실패!");
    }

    return new ArrayList<>(requestAgent.getObjects(ChallengeDTO.class));
  }

  @Override
  public void update(ChallengeDTO challengeDTO) throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public void delete(ChallengeDTO challengeDTO) throws Exception {
    // TODO Auto-generated method stub

  }



}
