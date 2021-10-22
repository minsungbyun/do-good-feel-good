package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.challenge.ChallengeQuestionDTO;

public interface ChallengeQuestionDao {

  // 챌린지 문의사항 관련
  void insert(ChallengeQuestionDTO addChallengeQuestion) throws Exception;
  void insertAdmin(int challengeQuestionNo, ChallengeQuestionDTO addChallengeQuestion) throws Exception;
  List<ChallengeQuestionDTO> findAll() throws Exception;      
  void update(ChallengeQuestionDTO updateChallengeQuestion) throws Exception;          
  void delete(ChallengeQuestionDTO challengeQuestion) throws Exception; 
  List<ChallengeQuestionDTO> findByKeyword(String keyword) throws Exception;
  void sortChallengeQuestion(ChallengeQuestionDTO sortChallengeQuestion) throws Exception;

  ChallengeQuestionDTO findByNo(int challengeNo, int challengeQuestionNo) throws Exception;
  int getNextNum(ChallengeDTO challenge) throws Exception;
}
