package com.share.ftp.handler.admin;

import com.share.ftp.handler.Command;

public abstract class AbstractAdminQuestionReplyHandler implements Command {

  // 에러나서 주석 막아놓음!

  //  protected List<QuestionDTO> questionDTOList;
  //
  //  public AbstractAdminQuestionReplyHandler(List<QuestionDTO> questionDTOList) {
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

}
