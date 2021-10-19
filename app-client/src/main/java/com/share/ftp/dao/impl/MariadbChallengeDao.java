package com.share.ftp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.share.ftp.dao.ChallengeDao;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.challenge.ChallengeQuestionDTO;
import com.share.ftp.domain.challenge.ChallengeReviewDTO;

public class MariadbChallengeDao implements ChallengeDao {

  Connection con;

  public MariadbChallengeDao(Connection con) {
    this.con = con;
  }

  ///관리자 챌린지 등록관련 메서드//////////////////////////////////////////////////////////////
  @Override
  public void insert(ChallengeDTO addChallenge) throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "insert into ftp_challenge(title,content,start_dt,end_dt) values(?,?,?,?)",
        Statement.RETURN_GENERATED_KEYS)) {

      stmt.setString(1, addChallenge.getTitle());
      stmt.setString(2, addChallenge.getContent());
      stmt.setDate(3, addChallenge.getStartDate());
      stmt.setDate(4, addChallenge.getEndDate());

      if (stmt.executeUpdate() == 0) {
        throw new Exception("챌린지 등록 실패!");
      }
    }
  }

  @Override
  public List<ChallengeDTO> findAll() throws Exception {
    try (PreparedStatement stmt = con.prepareStatement(
        "select"
            + " c.challenge_no,"
            + " c.title,"
            //            + " c.content,"
            //            + " c.review_cnt,"
            //            + " c.current_cnt,"
            //            + " m.name," // 첨부파일 수정필요
            + " c.start_dt,"
            + " c.end_dt"
            //            + " c.deadline_dt"
            //            + " c.deadline_time" // 챌린지 남은 시간
            + " from"
            + " ftp_challenge c"
            + " order by challenge_no desc");
        ResultSet rs = stmt.executeQuery()) {

      ArrayList<ChallengeDTO> list = new ArrayList<>();

      while (rs.next()) {
        ChallengeDTO challengeDTO = new ChallengeDTO();
        challengeDTO.setNo(rs.getInt("challenge_no"));
        challengeDTO.setTitle(rs.getString("title"));
        //        challengeDTO.setContent(rs.getString("content"));
        //        challengeDTO.setReviewCount(rs.getInt("review_cnt"));
        //        challengeDTO.setTotalJoinCount(rs.getInt("current_cnt"));
        challengeDTO.setStartDate(rs.getDate("start_dt"));
        challengeDTO.setEndDate(rs.getDate("end_dt"));


        list.add(challengeDTO);
      }

      return list;
    }
  }

  @Override
  public void update(ChallengeDTO updateChallenge) throws Exception {
    //    requestAgent.request("challenge.update", updateChallenge);
    //
    //    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
    //      throw new Exception("챌린지 변경 실패!");
    //    }

  }

  @Override
  public void delete(ChallengeDTO deleteChallenge) throws Exception {
    //    requestAgent.request("challenge.delete", deleteChallenge);
    //
    //    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
    //      throw new Exception("챌린지 삭제 실패!");
    //    }
  }

  //  @Override
  //  public int getNextNum() throws Exception {
  //    
  //        requestAgent.request("challenge.getNextNum", null);
  //    
  //        if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
  //          throw new Exception("고유번호 부여 중 오류 발생!");
  //        }
  //        ChallengeDTO challengeDTO = requestAgent.getObject(ChallengeDTO.class);
  //    
  //    
  //        return challengeDTO.getNo();
  //    return (Integer) null; // 임시 리턴
  //  }

  @Override
  public ChallengeDTO findByChallengeNo(int challengeNo) throws Exception {
    //
    //    HashMap<String,String> params = new HashMap<>();
    //    params.put("challengeNo", String.valueOf(challengeNo));
    //
    //    requestAgent.request("challenge.selectOne", params);
    //
    //    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
    //      return null;
    //    }
    //
    //    return requestAgent.getObject(ChallengeDTO.class);
    return null; // 임시 리턴
  }

  ///챌린지 문의하기///////////////////////////////////////////////////////////////////

  @Override
  public void insertQuestion(ChallengeQuestionDTO addChallengeQuestion) throws Exception {
    //    requestAgent.request("challengeQuestion.insert", addChallengeQuestion);
    //
    //    if (requestAgent.getStatus().equals(RequestAgent.SUCCESS)) {
    //      System.out.println("[ 챌린지 문의 등록이 정상적으로 완료되었습니다! ]");
    //
    //    } else {
    //      throw new Exception("챌린지 문의 등록 실패!");
    //    }
  }

  @Override
  public void insertAdmin(int challengeQuestionNo, ChallengeQuestionDTO addChallengeQuestion)
      throws Exception {
    //
    //    HashMap<String,String> params = new HashMap<>();
    //    params.put("challengeQuestionNo", String.valueOf(challengeQuestionNo));
    //    params.put("addChallengeQuestion", new Gson().toJson(addChallengeQuestion));
    //
    //    requestAgent.request("challengeQuestion.insertAdmin", params);
    //
    //    if (requestAgent.getStatus().equals(RequestAgent.SUCCESS)) {
    //      System.out.println("[ 챌린지 문의 등록이 정상적으로 완료되었습니다! ]");
    //
    //    } else {
    //      throw new Exception("챌린지 문의 등록 실패!");
    //    }
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
    //
    //
    //    requestAgent.request("challengeQuestion.selectList", null);
    //
    //    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
    //      System.out.println("실패했어요");
    //      throw new Exception("챌린지 문의 목록 조회 실패!");
    //    }
    //    return new ArrayList<>(requestAgent.getObjects(ChallengeQuestionDTO.class));
    return null; // 임시 리턴
  }

  @Override
  public void updateQuestion(ChallengeQuestionDTO updateChallengeQuestion) throws Exception {
    //
    //    requestAgent.request("challengeQuestion.update", updateChallengeQuestion);
    //
    //    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
    //      throw new Exception("챌린지 문의 변경 실패!");
    //    }
  }

  @Override
  public void deleteQuestion(ChallengeQuestionDTO deleteChallengeQuestion) throws Exception {
    //    requestAgent.request("challengeQuestion.delete", deleteChallengeQuestion);
    //
    //    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
    //      throw new Exception("챌린지 문의 삭제 실패!");
    //    }
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
    //
    //    HashMap<String,String> params = new HashMap<>();
    //    params.put("challengeNo", String.valueOf(challengeNo));
    //    params.put("challengeQuestionNo", String.valueOf(challengeQuestionNo));
    //    requestAgent.request("challengeQuestion.selectOne", params);
    //
    //    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
    //      return null;
    //    }
    //
    //    return requestAgent.getObject(ChallengeQuestionDTO.class);
    return null; // 임시 리턴
  }

  @Override
  public int getNextQuestionNum(ChallengeDTO challengeDTO) throws Exception {

    return challengeDTO.getQuestionCount() + 1;
  }


  ///챌린지 참여인증&댓글//////////////////////////////////////////////////////////////

  @Override
  public void insertReview(ChallengeReviewDTO addChallengeReview) throws Exception {
    //    requestAgent.request("challengeReview.insert", addChallengeReview);
    //
    //    if (requestAgent.getStatus().equals(RequestAgent.SUCCESS)) {
    //      System.out.println("[ 참여인증&댓글 등록이 정상적으로 완료되었습니다! ]");
    //
    //    } else {
    //      throw new Exception("참여인증&댓글 등록 실패!");
    //    }
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
  public ChallengeReviewDTO findByChallengeReviewNo(int challengeNo, int challengeReviewNo)
      throws Exception {
    //    HashMap<String,String> params = new HashMap<>();
    //    params.put("challengeNo", String.valueOf(challengeNo));
    //    params.put("challengeReviewNo", String.valueOf(challengeReviewNo));
    //    requestAgent.request("challengeReview.selectOne", params);
    //
    //    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
    //      return null;
    //    }
    //
    //    return requestAgent.getObject(ChallengeReviewDTO.class);
    return null; // 임시 리턴
  }

  @Override
  public void deleteReview(ChallengeReviewDTO deleteChallengeReviewNo) throws Exception {
    //    requestAgent.request("challengeReview.delete", deleteChallengeReviewNo);
    //
    //    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
    //      throw new Exception("참여인증&댓글 삭제 실패!");
    //    }    
  }

  @Override
  public void updateReview(ChallengeReviewDTO updateChallengeReview) throws Exception {
    //    requestAgent.request("challengeReview.update", updateChallengeReview);
    //
    //    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
    //      throw new Exception("참여인증&댓글 변경 실패!");
    //    }
  }

  @Override
  public List<ChallengeReviewDTO> findAllReview() throws Exception {
    //    requestAgent.request("challengeReview.selectList", null);
    //
    //    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
    //      throw new Exception("참여인증&댓글 목록 조회 실패!");
    //    }
    //    return new ArrayList<>(requestAgent.getObjects(ChallengeReviewDTO.class));
    return null; // 임시 리턴
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
