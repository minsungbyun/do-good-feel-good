package com.share.ftp.handler.admin;

import java.util.List;
import com.share.ftp.domain.admin.QuestionDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractAdminQuestionHandler implements Command {

  protected List<QuestionDTO> questionDTOList;

  public AbstractAdminQuestionHandler(List<QuestionDTO> questionDTOList) {
    this.questionDTOList = questionDTOList;
  }


  protected QuestionDTO findByNo(int no) {
    QuestionDTO[] arr = questionDTOList.toArray(new QuestionDTO[0]);
    for (QuestionDTO questionDTO : arr) {
      if (questionDTO.getNo() == no) {
        return questionDTO;
      }
    }
    return null;
  }

}
