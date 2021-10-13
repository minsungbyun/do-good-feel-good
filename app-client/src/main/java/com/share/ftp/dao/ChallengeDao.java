package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.challenge.ChallengeQuestionDTO;
import com.share.ftp.domain.challenge.ChallengeReviewDTO;

public interface ChallengeDao {

  // 챌린지 관련
  void insert(ChallengeDTO addChallenge) throws Exception;      
  List<ChallengeDTO> findAll() throws Exception;      
  void update(ChallengeDTO updateChallenge) throws Exception;          
  void delete(ChallengeDTO updateChallenge) throws Exception;          

  ChallengeDTO findByChallengeNo(int challengeNo) throws Exception;
  String getRemainTime(long millis) throws Exception;
  int getNextNum() throws Exception;       

  // 챌린지 문의사항 관련
  void insertQuestion(ChallengeQuestionDTO addChallengeQuestion) throws Exception;
  void insertAdmin(int challengeQuestionNo, ChallengeQuestionDTO addChallengeQuestion) throws Exception;
  List<ChallengeQuestionDTO> findAllQuestion() throws Exception;      
  void updateQuestion(ChallengeQuestionDTO updateChallengeQuestion) throws Exception;          
  void deleteQuestion(ChallengeQuestionDTO challengeQuestion) throws Exception; 
  List<ChallengeQuestionDTO> findByQuestionKeyword(String keyword) throws Exception;
  void sortChallengeQuestion(ChallengeQuestionDTO sortChallengeQuestion) throws Exception;

  ChallengeQuestionDTO findByChallengeQuestionNo(int challengeNo, int challengeQuestionNo) throws Exception;
  int getNextQuestionNum(ChallengeDTO challenge) throws Exception;

  // 챌린지 참여인증&댓글 관련
  void insertReview(ChallengeReviewDTO addChallengeReview) throws Exception;
  List<ChallengeReviewDTO> findAllReview() throws Exception;      
  void updateReview(ChallengeReviewDTO updateChallengeReview) throws Exception;          
  void deleteReview(ChallengeReviewDTO deleteChallengeReviewNo) throws Exception; 

  int getNextReviewNum(ChallengeDTO challengeDTO) throws Exception;
  ChallengeReviewDTO findByChallengeReviewNo(int challengeNo, int challengeReviewNo) throws Exception;



}