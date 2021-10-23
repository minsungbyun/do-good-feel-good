package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;

public interface ChallengeDao {

  // 챌린지 관련
  void insert(ChallengeDTO addChallenge) throws Exception;      
  List<ChallengeDTO> findAll() throws Exception;      
  void update(ChallengeDTO updateChallenge) throws Exception;          
  void delete(int challengeNo) throws Exception;          
  void insertUser(int challengeNo, int UserNo) throws Exception;
  void deleteUser(int challengeNo, int UserNo) throws Exception;

  ChallengeDTO findByNo(int challengeNo) throws Exception;
  String getRemainTime(long millis) throws Exception;
}