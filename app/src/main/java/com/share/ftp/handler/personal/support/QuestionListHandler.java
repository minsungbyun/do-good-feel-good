package com.share.ftp.handler.personal.support;

import java.util.List;
import com.share.ftp.domain.admin.CommentDTO;
import com.share.ftp.domain.personal.QuestionListDTO;

public class QuestionListHandler extends AbstractQuestionHandler {

  public QuestionListHandler(List<QuestionListDTO> myQuestionListDTOList,
      List<CommentDTO> commentDTOList) {
    super (myQuestionListDTOList, commentDTOList);
  }

  public void execute() {
    System.out.println();
    System.out.println("[고객센터/문의하기/문의하기 목록]");

    for (QuestionListDTO myQuestionListDTO : myQuestionListDTOList) {

      System.out.printf("%d, %s, %s, %s, %s, %s, %s, %d\n", 
          myQuestionListDTO.getBoardNo(),
          myQuestionListDTO.getSort(),
          myQuestionListDTO.getTitle(), 
          myQuestionListDTO.getContent(),
          myQuestionListDTO.getOwner().getId(),
          myQuestionListDTO.getFileUpload(),
          myQuestionListDTO.getRegisteredDate(),
          myQuestionListDTO.getViewCount());
    }
  }

}