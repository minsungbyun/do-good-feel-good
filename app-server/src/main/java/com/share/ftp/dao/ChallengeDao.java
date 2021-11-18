package com.share.ftp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.share.ftp.domain.admin.ChallengeDTO;

public interface ChallengeDao {

  // 챌린지 관련
  void insert(ChallengeDTO addChallenge) throws Exception;      
  void insertFile(
      @Param("challengeNo") int challengeNo,
      @Param("filepath") String filepath) throws Exception;
  List<ChallengeDTO> findAll() throws Exception;      
  void update(ChallengeDTO updateChallenge) throws Exception;          
  void delete(int challengeNo) throws Exception;          
  void deleteApply(int challengeNo) throws Exception;          
  void deleteReview(int challengeNo) throws Exception;          
  void deleteQuestion(int challengeNo) throws Exception;          
  void deleteFile(int challengeNo) throws Exception;          
  void insertUser(@Param("challengeNo")int challengeNo, int userNo) throws Exception;
  void deleteUser(int challengeNo, int UserNo) throws Exception;
  void insertWish(
      @Param("challengeNo")int challengeNo, @Param("userNo")int userNo) throws Exception;

  ChallengeDTO findByNo(int challengeNo) throws Exception;
  String getRemainTime(long millis) throws Exception;
}