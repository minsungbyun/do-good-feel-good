package com.share.ftp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.challenge.ChallengeReviewDTO;

public interface ChallengeReviewDao {

  // 챌린지 참여인증&댓글 관련
  void insert(ChallengeReviewDTO addChallengeReview) throws Exception;
  List<ChallengeReviewDTO> findAll() throws Exception;      
  void update(ChallengeReviewDTO updateChallengeReview) throws Exception;          
  void delete(ChallengeReviewDTO deleteChallengeReviewNo) throws Exception; 

  int getNextNum(ChallengeDTO challengeDTO) throws Exception;
  ChallengeReviewDTO findByNo(
      @Param("challengeNo")int challengeNo,
      @Param("challengeReviewNo") int challengeReviewNo) throws Exception;
}
