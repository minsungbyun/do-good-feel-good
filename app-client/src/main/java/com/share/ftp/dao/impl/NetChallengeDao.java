package com.share.ftp.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.dao.ChallengeQuestionDao;
import com.share.ftp.dao.ChallengeReviewDao;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.request.RequestAgent;

public class NetChallengeDao implements ChallengeDao, ChallengeReviewDao, ChallengeQuestionDao {

  RequestAgent requestAgent;

  public NetChallengeDao(RequestAgent requestAgent) {
    this.requestAgent = requestAgent;
  }

  // 챌린지 관련 메서드
  @Override
  public void insert(ChallengeDTO addChallenge) throws Exception {

    requestAgent.request("challenge.insert", addChallenge);

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
  public void update(ChallengeDTO updateChallenge) throws Exception {
    requestAgent.request("challenge.update", updateChallenge);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("챌린지 변경 실패!");
    }

  }

  @Override
  public void delete(int deleteChallengeNo) throws Exception {
    HashMap<String,String> params = new HashMap<>();
    params.put("deleteChallengeNo", String.valueOf(deleteChallengeNo));

    requestAgent.request("challenge.delete", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("챌린지 삭제 실패!");
    }
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
  public ChallengeDTO findByChallengeNo(int challengeNo) throws Exception {

    HashMap<String,String> params = new HashMap<>();
    params.put("challengeNo", String.valueOf(challengeNo));

    requestAgent.request("challenge.selectOne", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      return null;
    }

    return requestAgent.getObject(ChallengeDTO.class);
  }

  @Override
  public String getRemainTime(long millis) throws Exception {
    HashMap<String,String> params = new HashMap<>();
    params.put("getRemainTime", String.valueOf(millis));

    requestAgent.request("challenge.getRemainTime", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      return null;
    }
    ChallengeDTO challengeDTO = requestAgent.getObject(ChallengeDTO.class);

    return challengeDTO.getRemainTime();
  }



}
