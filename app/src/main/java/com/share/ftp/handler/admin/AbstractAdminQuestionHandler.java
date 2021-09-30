package com.share.ftp.handler.admin;

import java.util.List;
import com.share.ftp.domain.personal.QuestionListDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractAdminQuestionHandler implements Command {

  protected List<QuestionListDTO> myQuestionListDTOList;
  protected List<QuestionListDTO> adminQuestionDTOList;

  public AbstractAdminQuestionHandler(List<QuestionListDTO> myQuestionListDTOList) {
    this.myQuestionListDTOList = myQuestionListDTOList;
  }
  public AbstractAdminQuestionHandler(
      List<QuestionListDTO> myQuestionListDTOList,
      List<QuestionListDTO> adminQuestionDTOList) {

    this.myQuestionListDTOList = myQuestionListDTOList;
    this.adminQuestionDTOList = adminQuestionDTOList;
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

  protected int indexOf(int adminNo) {
    for (int i = 0; i < myQuestionListDTOList.size(); i++) {
      if (myQuestionListDTOList.get(i).getNo() == adminNo) {
        return i;
      }
    }
    return -1;
  }


}
