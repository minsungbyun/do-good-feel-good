package com.share.ftp.dao.impl;

import java.util.ArrayList;
import java.util.List;
import com.share.ftp.dao.ChallengeJoinDao;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.request.RequestAgent;

public class NetChallengeJoinDao implements ChallengeJoinDao {

  RequestAgent requestAgent;

  public NetChallengeJoinDao(RequestAgent requestAgent) {
    this.requestAgent = requestAgent;
  }

  @Override
  public void insert(ChallengeDTO challengeDTO) throws Exception {
    requestAgent.request("challengeJoin.insert", challengeDTO);

    if (requestAgent.getStatus().equals(RequestAgent.SUCCESS)) {
      System.out.println("챌린지 참여가 정상적으로 완료되었습니다.");

    } else {
      throw new Exception("챌린지 참여 실패!");
    }
  }

  @Override
  public List<ChallengeDTO> findAll() throws Exception {

    requestAgent.request("challengeJoin.selectList", null);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("챌린지 참여목록 조회 실패!");
    }

    return new ArrayList<>(requestAgent.getObjects(ChallengeDTO.class));
  }
}
