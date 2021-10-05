package com.share.ftp.handler.personal.support;

import com.share.ftp.dao.QuestionDao;
import com.share.ftp.domain.personal.QuestionListDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class QuestionListHandler implements Command {

  QuestionDao questionDao;

  public QuestionListHandler(QuestionDao questionDao) {
    this.questionDao = questionDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[고객센터/문의하기/문의하기 목록]");

    if (questionList.isEmpty()) {
      System.out.println("게시글이 없습니다.");
      System.out.println();
    }

    for (QuestionListDTO myQuestionListDTO : questionList) {

      System.out.printf("%d, %s, %s, %s, %s, %d\n", 
          myQuestionListDTO.getNo(),
          myQuestionListDTO.getQnaType(),
          myQuestionListDTO.getTitle(), 
          //          myQuestionListDTO.getContent(),
          myQuestionListDTO.getOwner().getId(),
          //          myQuestionListDTO.getFileUpload(),
          myQuestionListDTO.getRegisteredDate(),
          myQuestionListDTO.getViewCount());
    }
  }

}