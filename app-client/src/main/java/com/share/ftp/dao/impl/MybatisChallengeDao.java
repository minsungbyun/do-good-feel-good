package com.share.ftp.dao.impl;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.challenge.ChallengeQuestionDTO;
import com.share.ftp.domain.challenge.ChallengeReviewDTO;

public class MybatisChallengeDao implements ChallengeDao {

  Connection con;
  SqlSession sqlSession;

  public MybatisChallengeDao(SqlSession sqlSession) {
    this.sqlSession = sqlSession;
  }

  ///관리자 챌린지 등록관련 메서드//////////////////////////////////////////////////////////////
  @Override
  public void insert(ChallengeDTO addChallenge) throws Exception {
    sqlSession.insert("ChallengeMapper.insert", addChallenge);
    sqlSession.commit();
  }

  @Override
  public List<ChallengeDTO> findAll() throws Exception {
    return sqlSession.selectList("ChallengeMapper.findAll");
  }

  @Override
  public void update(ChallengeDTO updateChallenge) throws Exception {
    sqlSession.update("ChallengeMapper.update", updateChallenge);
    sqlSession.commit();
  }

  @Override
  public void delete(int challengeNo) throws Exception {
    sqlSession.delete("ChallengeMapper.delete", challengeNo);
    sqlSession.commit();
  }

  @Override
  public ChallengeDTO findByNo(int challengeNo) throws Exception {
    return sqlSession.selectOne("ChallengeMapper.findByChallengeNo", challengeNo);
  }

  ///챌린지 문의하기///////////////////////////////////////////////////////////////////

  @Override
  public void insertQuestion(ChallengeQuestionDTO addChallengeQuestion) throws Exception {
    sqlSession.insert("ChallengeQuestionMapper.insert", addChallengeQuestion);
    sqlSession.commit();
  }

  @Override
  public void insertAdmin(int challengeQuestionNo, ChallengeQuestionDTO addChallengeQuestion)
      throws Exception {
  }


  @Override
  public void sortChallengeQuestion(ChallengeQuestionDTO sortChallengeQuestion) throws Exception {
    //    requestAgent.request("challengeQuestion.sort", sortChallengeQuestion);
    //
    //    if (requestAgent.getStatus().equals(RequestAgent.SUCCESS)) {
    //    } else {
    //      throw new Exception("챌린지 문의 등록 실패!");
    //    }

  }

  @Override
  public List<ChallengeQuestionDTO> findAllQuestion() throws Exception {
    return sqlSession.selectList("ChallengeQuestionMapper.findAll");
  }

  @Override
  public void updateQuestion(ChallengeQuestionDTO updateChallengeQuestion) throws Exception {
    sqlSession.update("ChallengeQuestionMapper.update", updateChallengeQuestion);
    sqlSession.commit();
  }

  @Override
  public void deleteQuestion(ChallengeQuestionDTO deleteChallengeQuestion) throws Exception {
    sqlSession.delete("ChallengeQuestionMapper.delete", deleteChallengeQuestion);
    sqlSession.commit();
  }

  @Override
  public List<ChallengeQuestionDTO> findByQuestionKeyword(String questionKeyword) throws Exception {
    //
    //    HashMap<String,String> params = new HashMap<>();
    //    params.put("challengeQuestionKeyword", questionKeyword);
    //    requestAgent.request("challengeQuestion.selectListByKeyword", params);
    //
    //    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
    //      throw new Exception("챌린지 문의 검색 실패!");
    //    }
    //
    //    return new ArrayList<>(requestAgent.getObjects(ChallengeQuestionDTO.class));
    return null; // 임시 리턴
  }


  @Override
  public ChallengeQuestionDTO findByChallengeQuestionNo(int challengeNo, int challengeQuestionNo) throws Exception {
    HashMap<String,Object> params = new HashMap<>();
    params.put("challengeNo", challengeNo);
    params.put("challengeQuestionNo", challengeQuestionNo);

    return sqlSession.selectOne("ChallengeQuestionMapper.findByNo", params);
  }

  @Override
  public int getNextQuestionNum(ChallengeDTO challengeDTO) throws Exception {

    return challengeDTO.getQuestionCount() + 1;
  }


  ///챌린지 참여인증&댓글//////////////////////////////////////////////////////////////

  @Override
  public void insertReview(ChallengeReviewDTO addChallengeReview) throws Exception {
    sqlSession.insert("ChallengeReviewMapper.insert", addChallengeReview);
    sqlSession.commit();
  }

  // 나중에 따로 분리해야함
  @Override
  public int getNextReviewNum(ChallengeDTO challengeDTO) throws Exception {
    //    requestAgent.request("challengeReview.getNextNum", null);
    //
    //    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
    //      throw new Exception("고유번호 부여 중 오류 발생!");
    //    }
    //    ChallengeReviewDTO challengeReviewDTO = requestAgent.getObject(ChallengeReviewDTO.class);


    return challengeDTO.getReviewCount() + 1;
  }

  @Override
  public ChallengeReviewDTO findByChallengeReviewNo(int challengeNo, int challengeReviewNo) {
    return sqlSession.selectOne("ChallengeReviewMapper.findByNo", challengeReviewNo);
  }

  @Override
  public void deleteReview(ChallengeReviewDTO deleteChallengeReviewNo) throws Exception {
    sqlSession.delete("ChallengeReviewMapper.delete", deleteChallengeReviewNo);
    sqlSession.commit();
  }

  @Override
  public void updateReview(ChallengeReviewDTO updateChallengeReview) throws Exception {
    sqlSession.update("ChallengeReviewMapper.update", updateChallengeReview);
    sqlSession.commit();
  }

  @Override
  public List<ChallengeReviewDTO> findAllReview() throws Exception {
    return sqlSession.selectList("ChallengeReviewMapper.findAll");
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
