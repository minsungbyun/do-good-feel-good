package com.share.ftp.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.dao.ChallengeQuestionDao;
import com.share.ftp.dao.ChallengeReviewDao;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;
import com.share.ftp.domain.personal.ChallengeReviewDTO;
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
  public List<ChallengeDTO> findChallengeAll() throws Exception {

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

  @Override
  public void insert(ChallengeQuestionDTO addChallengeQuestion) throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public void delete(ChallengeQuestionDTO challengeQuestion) throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public List<ChallengeQuestionDTO> findByKeyword(String keyword) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ChallengeQuestionDTO findByChallengeQuestionNo(int challengeQuestionNo,
      ChallengeDTO challengeNo) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int getNextQuestionNum(ChallengeDTO challengeDTO) throws Exception {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int indexOf(int challengeQuestionNo, ChallengeQuestionDTO challengeQuestionDTO)
      throws Exception {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void insertAdmin(int index, ChallengeQuestionDTO challengeQuestionDTO) throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public void sortChallengeQuestion() throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public void insert(ChallengeReviewDTO addChallengeReview) throws Exception {
    requestAgent.request("challengeReview.insert", addChallengeReview);

    if (requestAgent.getStatus().equals(RequestAgent.SUCCESS)) {
      System.out.println("[ 챌린지 등록이 정상적으로 완료되었습니다! ]");

    } else {
      throw new Exception("챌린지 등록 실패!");
    }

  }

  @Override
  public int getNextReviewNum(ChallengeDTO challengeDTO) throws Exception {
    requestAgent.request("challengeReview.getNextNum", null);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("고유번호 부여 중 오류 발생!");
    }
    ChallengeReviewDTO challengeReviewDTO = requestAgent.getObject(ChallengeReviewDTO.class);


    return challengeReviewDTO.getNo();
  }

  @Override
  public ChallengeReviewDTO findByChallengeReviewNo(int challengeReviewNo, ChallengeDTO challengeDTO)
      throws Exception {
    HashMap<String,String> params = new HashMap<>();
    params.put("challengeReviewNo", String.valueOf(challengeReviewNo));

    requestAgent.request("challengeReview.selectOne", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      return null;
    }

    return requestAgent.getObject(ChallengeReviewDTO.class);
  }

  @Override
  public boolean isEmpty() throws Exception {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public List<ChallengeQuestionDTO> findAllQuestion() throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<ChallengeReviewDTO> findAllReview() throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void delete(ChallengeReviewDTO deleteChallengeReviewNo) throws Exception {
    requestAgent.request("challengeReview.delete", deleteChallengeReviewNo);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("참여인증&댓글 삭제 실패!");
    }    
  }

  @Override
  public void update(ChallengeReviewDTO updateChallengeReview) throws Exception {
    requestAgent.request("challengeReview.update", updateChallengeReview);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("참여인증&댓글 변경 실패!");
    }

  }

  @Override
  public void delete(int deleteChallengeQuestionNo) throws Exception {
    // TODO Auto-generated method stub

  }







}
