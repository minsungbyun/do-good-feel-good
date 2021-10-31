package com.share.ftp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.share.ftp.domain.challenge.ChallengeQuestionDTO;

public interface ChallengeQuestionDao {

  // 챌린지 문의사항 관련
  void insert(ChallengeQuestionDTO addChallengeQuestion) throws Exception;
  //  void insertReply(
  //      @Param("challengeQuestionNo")int challengeQuestionNo, 
  //      ChallengeQuestionDTO addChallengeQuestion) throws Exception;
  List<ChallengeQuestionDTO> findAll() throws Exception;      
  void update(ChallengeQuestionDTO updateChallengeQuestion) throws Exception;
  void updateReply(ChallengeQuestionDTO updateChallengeQuestionReply) throws Exception;
  void delete(int no) throws Exception; 
  List<ChallengeQuestionDTO> findByKeyword(String keyword) throws Exception;
  //  void sortChallengeQuestion(ChallengeQuestionDTO sortChallengeQuestion) throws Exception;

  ChallengeQuestionDTO findByNo(
      @Param("challengeNo")int challengeNo,
      @Param("challengeQuestionNo") int challengeQuestionNo) throws Exception;
}
