package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.personal.ChallengeQuestionDTO;

public interface ChallengeQuestionDao {

  // 챌린지 문의사항 관련
  void insertQuestion(ChallengeQuestionDTO addChallengeQuestion) throws Exception;
  List<ChallengeQuestionDTO> findAllQuestion() throws Exception;      
  void updateQuestion(ChallengeQuestionDTO updateChallengeQuestion) throws Exception;          
  void deleteQuestion(int deleteChallengeQuestionNo) throws Exception; 
  void deleteQuestion(ChallengeQuestionDTO challengeQuestion) throws Exception; 
  List<ChallengeQuestionDTO> findByQuestionKeyword(String keyword) throws Exception;


  ChallengeQuestionDTO findByChallengeQuestionNo(int challengeQuestionNo, ChallengeDTO challengeNo) throws Exception;
  ChallengeQuestionDTO findByChallengeQuestionNo(int challengeQuestionNo) throws Exception;
  int getNextQuestionNum(ChallengeDTO challengeDTO) throws Exception;
  int indexOf(int challengeQuestionNo, ChallengeQuestionDTO challengeQuestionDTO) throws Exception;
  void insertAdmin(int index, ChallengeQuestionDTO challengeQuestionDTO) throws Exception;
  void sortChallengeQuestion() throws Exception;

  //  boolean isEmpty() throws Exception;
}
