package com.share.ftp.handler.admin;

import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class AdminChallengeUpdateHandler extends AbstractAdminChallengeHandler {

  public AdminChallengeUpdateHandler(List<ChallengeDTO> challengeDTOList) {
    super(challengeDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[ 챌린지 변경 ]");
    int no = (int) request.getAttribute("no");

    ChallengeDTO challengeDTO = findByNo(no);

    if (challengeDTO == null) {
      System.out.println("해당 번호의 챌린지가 없습니다.");
      return;
    }

    String title = Prompt.inputString("제목(" + challengeDTO.getTitle() + ")? ");
    String content = Prompt.inputString("내용(" + challengeDTO.getContent() + ")? ");
    String fileUpload = Prompt.inputString("첨부파일(" + challengeDTO.getFileUpload() + ")? ");

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("공지사항 변경을 취소하였습니다.");
      return;
    }

    challengeDTO.setTitle(title);
    challengeDTO.setContent(content);
    challengeDTO.setFileUpload(fileUpload);

    System.out.println("챌린지를 변경하였습니다.");
  }
}
