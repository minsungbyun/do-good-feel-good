package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;

public interface ChallengeDao {

  // 챌린지 관련
  void insert(ChallengeDTO addChallenge) throws Exception;      
  List<ChallengeDTO> findAll() throws Exception;      
  void update(ChallengeDTO updateChallenge) throws Exception;          
  void delete(ChallengeDTO updateChallenge) throws Exception;          

  ChallengeDTO findByChallengeNo(int challengeNo) throws Exception;
  String getRemainTime(long millis) throws Exception;
  int getNextNum() throws Exception;       

}
