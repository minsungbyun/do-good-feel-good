package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;

public interface ChallengeJoinDao {
  void insert(ChallengeDTO ChallengeDTO) throws Exception;         // 챌린지 참여하기
  List<ChallengeDTO> findAll() throws Exception;                  // 챌린지 참여목록
}
