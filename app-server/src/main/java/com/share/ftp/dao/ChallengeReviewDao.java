package com.share.ftp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.share.ftp.domain.challenge.ChallengeReviewDTO;

public interface ChallengeReviewDao {

  // 챌린지 참여인증&댓글 관련
  void insert(ChallengeReviewDTO addChallengeReview) throws Exception;
  void insertFile(
      @Param("challengeReviewNo") int challengeReviewNo,
      @Param("filepath") String filepath) throws Exception;
  List<ChallengeReviewDTO> findAll() throws Exception;      
  void update(ChallengeReviewDTO updateChallengeReview) throws Exception;          
  void delete(int no) throws Exception; 
  void deleteFile(int no) throws Exception;

  List<ChallengeReviewDTO> findAllNo(int challengeNo) throws Exception;

  ChallengeReviewDTO findByNo(int challengeReviewNo) throws Exception;
}
