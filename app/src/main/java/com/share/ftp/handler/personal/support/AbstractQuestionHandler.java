package com.share.ftp.handler.personal.support;

import java.util.List;
import com.share.ftp.domain.admin.CommentDTO;
import com.share.ftp.domain.personal.QuestionListDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractQuestionHandler implements Command {

  protected List<QuestionListDTO> myQuestionListDTOList;
  protected List<CommentDTO> commentDTOList;

  public AbstractQuestionHandler(List<QuestionListDTO> myQuestionListDTOList,
      List<CommentDTO> commentDTOList) {
    this.myQuestionListDTOList = myQuestionListDTOList;
    this.commentDTOList = commentDTOList;
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





