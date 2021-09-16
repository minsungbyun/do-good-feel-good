package com.share.ftp.handler.personal.support;

import java.util.List;
import com.share.ftp.domain.personal.QuestionListDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractQuestionHandler implements Command {

  protected List<QuestionListDTO> myQuestionListDTOList;

  public AbstractQuestionHandler(List<QuestionListDTO> myQuestionListDTOList) {
    this.myQuestionListDTOList = myQuestionListDTOList;
  }

  protected QuestionListDTO findByNo(int boardNo) {
    for (QuestionListDTO myQuestionListDTO : myQuestionListDTOList) {
      if (myQuestionListDTO.getBoardNo() == boardNo) {
        return myQuestionListDTO;
      }
    }
    return null;
  }

}





