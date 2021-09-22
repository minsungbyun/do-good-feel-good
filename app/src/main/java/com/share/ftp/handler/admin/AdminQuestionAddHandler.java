package com.share.ftp.handler.admin;

import java.util.List;
import com.share.ftp.domain.admin.QuestionDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class AdminQuestionAddHandler extends AbstractAdminQuestionHandler {

  public AdminQuestionAddHandler(List<QuestionDTO> questionDTOList) {
    super(questionDTOList);
  }

  public void execute(CommandRequest request) throws Exception {
    System.out.println("[문의사항 등록]");

    QuestionDTO questionDTO = new QuestionDTO();

    questionDTO.setAdminId(Prompt.inputInt("관리자ID: "));
    questionDTO.setTitle(Prompt.inputString("제목: "));
    questionDTO.setContent(Prompt.inputString("내용: "));

    questionDTOList.add(questionDTO);
  }



}
