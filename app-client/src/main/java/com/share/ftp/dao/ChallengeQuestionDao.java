package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;

public interface ChallengeQuestionDao {

  // 챌린지 문의사항 관련
  void insertQuestion(ChallengeQuestionDTO addChallengeQuestion) throws Exception;
  List<ChallengeQuestionDTO> findAllQuestion() throws Exception;      
  void updateQuestion(int challengeNo, ChallengeQuestionDTO updateChallengeQuestion) throws Exception;          
  void deleteQuestion(int challengeNo, ChallengeQuestionDTO deleteChallengeQuestion) throws Exception; 
  void deleteQuestion(ChallengeQuestionDTO challengeQuestion) throws Exception; 
  List<ChallengeQuestionDTO> findByQuestionKeyword(String keyword) throws Exception;


  ChallengeQuestionDTO findByChallengeQuestionNo(int challengeNo, int challengeQuestionNo) throws Exception;
  ChallengeQuestionDTO findByChallengeQuestionNo(int challengeQuestionNo) throws Exception;
  int getNextQuestionNum(ChallengeDTO challenge) throws Exception;
  int indexOf(int challengeQuestionNo, ChallengeQuestionDTO challengeQuestion) throws Exception;
  void insertAdmin(int index, ChallengeQuestionDTO challengeQuestion) throws Exception;
  void sortChallengeQuestion() throws Exception;

  //  boolean isEmpty() throws Exception;
}
