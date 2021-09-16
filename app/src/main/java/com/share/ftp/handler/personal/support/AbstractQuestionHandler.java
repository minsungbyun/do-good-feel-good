package com.share.ftp.handler.personal.support;

import java.util.List;
import com.share.ftp.domain.personal.QuestionListDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractQuestionHandler implements Command {

  protected List<QuestionListDTO> myQuestionListDTOList;

  public AbstractQuestionHandler(List<QuestionListDTO> myQuestionListDTOList) {
    this.myQuestionListDTOList = myQuestionListDTOList;
  }

  protected QuestionListDTO findByNo(int no) {
    for (QuestionListDTO myQuestionListDTO : myQuestionListDTOList) {
      if (myQuestionListDTO.getNo() == no) {
        return myQuestionListDTO;
      }
    }
    return null;
  }

  protected int getNextNum() {
    if (myQuestionListDTOList.size() > 0) {
      return myQuestionListDTOList.get(myQuestionListDTOList.size() - 1).getNo() + 1;
    } else {
      return 1;
    }
  }

}





