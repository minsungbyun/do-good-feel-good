package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.personal.ChallengeReviewDTO;

public interface ChallengeReviewDao {

  // 챌린지 답글 관련
  void insert(ChallengeReviewDTO addChallengeReview) throws Exception;
  List<ChallengeReviewDTO> findAllReview() throws Exception;      
  void update(ChallengeReviewDTO updateChallengeReview) throws Exception;          
  void delete(ChallengeReviewDTO deleteChallengeReviewNo) throws Exception; 

  int getNextReviewNum(ChallengeDTO challengeDTO) throws Exception;
  ChallengeReviewDTO findByChallengeReviewNo(int challengeReviewNo, ChallengeDTO challengeNo) throws Exception;

  boolean isEmpty() throws Exception;

}
