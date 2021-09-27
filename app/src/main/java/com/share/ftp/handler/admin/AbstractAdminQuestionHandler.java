package com.share.ftp.handler.admin;

<<<<<<< HEAD
import java.util.List;
import com.share.ftp.domain.personal.QuestionListDTO;
=======
>>>>>>> c27b0391f173a168574413371c0167609cd56190
import com.share.ftp.handler.Command;

public abstract class AbstractAdminQuestionHandler implements Command {

<<<<<<< HEAD
  protected List<QuestionListDTO> myQuestionListDTOList;

  public AbstractAdminQuestionHandler(List<QuestionListDTO> myQuestionListDTOList) {
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
=======
  // 에러나서 주석 막아놓음!

  //  protected List<QuestionDTO> questionDTOList;
  //
  //  public AbstractAdminQuestionHandler(List<QuestionDTO> questionDTOList) {
  //    this.questionDTOList = questionDTOList;
  //  }
  //
  //
  //  protected QuestionDTO findByNo(int no) {
  //    for (QuestionDTO questionDTO : questionDTOList) {
  //      if (questionDTO.getNo() == no) {
  //        return questionDTO;
  //      }
  //    }
  //    return null;
  //  }
  //
  //  protected int getNextNum() {
  //    if (questionDTOList.size() > 0) {
  //      return questionDTOList.get(questionDTOList.size() - 1).getNo() + 1;
  //    } else {
  //      return 1;
  //    }
  //  }
>>>>>>> c27b0391f173a168574413371c0167609cd56190

}
