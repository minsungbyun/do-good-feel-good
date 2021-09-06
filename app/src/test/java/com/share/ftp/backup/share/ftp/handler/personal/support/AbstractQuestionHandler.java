package com.share.ftp.handler.personal.support;

import java.util.List;
import com.share.ftp.domain.personal.MyQuestionListDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractQuestionHandler implements Command {

  protected List<MyQuestionListDTO> myQuestionListDTOList;

  public AbstractQuestionHandler(List<MyQuestionListDTO> myQuestionListDTOList) {
    this.myQuestionListDTOList = myQuestionListDTOList;
  }

  protected MyQuestionListDTO findByNo(int no) {
    for (MyQuestionListDTO myQuestionListDTO : myQuestionListDTOList) {
      if (myQuestionListDTO.getNo() == no) {
        return myQuestionListDTO;
      }
    }
    return null;
  }

}





