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
  public void delete(ChallengeDTO deleteChallenge) throws Exception {
    requestAgent.request("challenge.delete", deleteChallenge);

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
  public String getRemainTime(long millis) {

    long sec =  millis / 1000;
    long min = sec / 60;
    long hour = min / 60;
    long day = (millis / 1000) / (24 * 60 * 60);

    hour = hour % 24; 
    sec = sec % 60;
    min = min % 60;

    return String.format("남은시간 ▶ %d일 %d시간 %d분 %d초 남았습니다\n", day, hour, min, sec);
  }






}
