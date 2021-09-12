package com.share.ftp.handler.admin;

import java.util.List;
import com.share.ftp.domain.admin.QuestionDTO;

public class AdminQuestionListHandler extends AbstractAdminQuestionHandler {



  public AdminQuestionListHandler(List<QuestionDTO> questionDTOList) {
    super(questionDTOList);
  }

  public void execute() {
    System.out.println("[문의사항 목록]");
    for (QuestionDTO questionDTO : questionDTOList) {
      System.out.printf("%d, %s, %s\n", 
          questionDTO.getAdminId(), 
          questionDTO.getTitle(), 
          questionDTO.getContent());
    }
  }



}
