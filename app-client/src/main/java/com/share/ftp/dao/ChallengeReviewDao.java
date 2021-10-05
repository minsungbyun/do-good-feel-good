package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.personal.ChallengeReviewDTO;

public interface ChallengeReviewDao {

  // 챌린지 참여인증&댓글 관련
  void insertReview(ChallengeReviewDTO addChallengeReview) throws Exception;
  List<ChallengeReviewDTO> findAllReview() throws Exception;      
  void updateReview(ChallengeReviewDTO updateChallengeReview) throws Exception;          
  void deleteReview(ChallengeReviewDTO deleteChallengeReviewNo) throws Exception; 

  int getNextReviewNum(ChallengeDTO challengeDTO) throws Exception;
  ChallengeReviewDTO findByChallengeReviewNo(int challengeReviewNo, ChallengeDTO challengeDTO) throws Exception;

  //  boolean isEmpty() throws Exception;

}
