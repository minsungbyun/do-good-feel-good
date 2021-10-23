package com.share.ftp.handler.admin;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractAdminChallengeHandler implements Command {

  protected List<ChallengeDTO> challengeDTOList;
  public AbstractAdminChallengeHandler(List<ChallengeDTO> challengeDTOList) {
    this.challengeDTOList = challengeDTOList;
  }

  protected String getRemainTime(long millis) {
    long sec =  millis / 1000;
    long min = sec / 60;
    long hour = min / 60;
    long day = (millis / 1000) / (24 * 60 * 60);

    hour = hour % 24; 
    sec = sec % 60;
    min = min % 60;

    return String.format("남은시간 ▶ %d일 %d시간 %d분 %d초 남았습니다\n", day, hour, min, sec);
  }

  protected ChallengeDTO findByNo(int no) {
    for (ChallengeDTO challengeDTO : challengeDTOList) {
      if (challengeDTO.getNo() == no) {
        return challengeDTO;
      }
    }
    return null;
  }
  protected int getNextNum() {
    if (challengeDTOList.size() > 0) {
      return challengeDTOList.get(challengeDTOList.size() - 1).getNo() + 1;
    } else {
      return 1;
    }
  }
}
