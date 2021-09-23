package com.share.ftp.handler.personal.challenge;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.admin.AbstractAdminChallengeHandler;

public class MyChallengeBookmarkHandler extends AbstractAdminChallengeHandler {

  public MyChallengeBookmarkHandler(List<ChallengeDTO> challengeDTOList) {
    super(challengeDTOList);
  }

  public void execute(CommandRequest request) throws Exception {

  }

}
