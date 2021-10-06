package com.share.ftp.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.google.gson.Gson;
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
  public void insertQuestion(ChallengeQuestionDTO addChallengeQuestion) throws Exception {
    requestAgent.request("challengeQuestion.insert", addChallengeQuestion);

    if (requestAgent.getStatus().equals(RequestAgent.SUCCESS)) {
      System.out.println("[ 챌린지 문의 등록이 정상적으로 완료되었습니다! ]");

    } else {
      throw new Exception("챌린지 문의 등록 실패!");
    }



  }

  @Override
  public List<ChallengeQuestionDTO> findAllQuestion() throws Exception {


    requestAgent.request("challengeQuestion.selectList", null);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      System.out.println("실패했어요");
      throw new Exception("챌린지 문의 목록 조회 실패!");
    }
    return new ArrayList<>(requestAgent.getObjects(ChallengeQuestionDTO.class));
  }

  @Override
  public void updateQuestion(int challengeNo, ChallengeQuestionDTO updateChallengeQuestion) throws Exception {
    HashMap<String,String> params = new HashMap<>();
    params.put("challengeNo", String.valueOf(challengeNo));
    params.put("updateChallengeQuestion", new Gson().toJson(updateChallengeQuestion));

    requestAgent.request("challengeQuestion.update", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("챌린지 문의 변경 실패!");
    }
  }

  @Override
  public void deleteQuestion(ChallengeQuestionDTO deleteChallengeQuestion) throws Exception {
    requestAgent.request("challengeQuestion.delete", deleteChallengeQuestion);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("챌린지 문의 삭제 실패!");
    }

  }

  @Override
  public void deleteQuestion(int challengeNo, ChallengeQuestionDTO deleteChallengeQuestion) throws Exception {
    HashMap<String,String> params = new HashMap<>();
    params.put("challengeNo", String.valueOf(challengeNo));
    params.put("deleteChallengeQuestion", new Gson().toJson(deleteChallengeQuestion));


    requestAgent.request("challengeQuestion.deleteIndex", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("챌린지 문의 삭제 실패!");
    }
  }


  @Override
  public List<ChallengeQuestionDTO> findByQuestionKeyword(String questionKeyword) throws Exception {

    HashMap<String,String> params = new HashMap<>();
    params.put("challengeQuestionKeyword", questionKeyword);
    requestAgent.request("challengeQuestion.selectListByKeyword", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("챌린지 문의 검색 실패!");
    }

    return new ArrayList<>(requestAgent.getObjects(ChallengeQuestionDTO.class));

  }


  @Override
  public ChallengeQuestionDTO findByChallengeQuestionNo(int challengeNo, int challengeQuestionNo) throws Exception {

    HashMap<String,String> params = new HashMap<>();
    params.put("challengeNo", String.valueOf(challengeNo));
    params.put("challengeQuestionNo", String.valueOf(challengeQuestionNo));
    requestAgent.request("challengeQuestion.selectOne", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      return null;
    }

    return requestAgent.getObject(ChallengeQuestionDTO.class);

  }

  @Override
  public int getNextQuestionNum(ChallengeDTO challengeDTO) throws Exception {
    requestAgent.request("challengeQuestion.getNextNum", challengeDTO);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      return 1;
    }

    ChallengeDTO challenge = requestAgent.getObject(ChallengeDTO.class);

    return challenge.getQuestionCount();
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
  public void insertReview(ChallengeReviewDTO addChallengeReview) throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public List<ChallengeReviewDTO> findAllReview() throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void updateReview(ChallengeDTO updateChallengeReview) throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public void deleteReview(int deleteChallengeReviewNo) throws Exception {
    // TODO Auto-generated method stub

  }


  @Override
  public int getNextReviewNum(ChallengeDTO challengeDTO) throws Exception {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public ChallengeReviewDTO findByChallengeReviewNo(int challengeReviewNo, ChallengeDTO challengeNo)
      throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ChallengeQuestionDTO findByChallengeQuestionNo(int challengeQuestionNo) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }




  // 다른 클래스 만들어서 static 메서드로 뺄 예정
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
