package com.share.ftp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.share.ftp.domain.admin.ChallengeDTO;

public interface ChallengeDao {

  // 챌린지 관련
  void insert(ChallengeDTO addChallenge) throws Exception;      
  List<ChallengeDTO> findAll() throws Exception;      
  void update(ChallengeDTO updateChallenge) throws Exception;          
  void delete(int challengeNo) throws Exception;          
  void insertUser(@Param("challengeNo")int challengeNo, int userNo) throws Exception;
  void deleteUser(int challengeNo, int UserNo) throws Exception;

  ChallengeDTO findByNo(int challengeNo) throws Exception;
  String getRemainTime(long millis) throws Exception;
}