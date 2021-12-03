package com.share.ftp.handler.personal.support;

import java.util.Collection;
import com.share.ftp.dao.QuestionDao;
import com.share.ftp.domain.support.QuestionAttachedFile;
import com.share.ftp.domain.support.QuestionListDTO;
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
    System.out.println("[ 문의하기 - 목록 ]");

    Collection<QuestionListDTO> questionList = questionDao.findAll();



    if (questionList.isEmpty()) {
      System.out.println("게시글이 없습니다.");
      System.out.println();
    }


    for (QuestionListDTO questionListDTO : questionList) {
      System.out.printf("%d, %s, %s, %s, %s, %d, %d\n", 
          questionListDTO.getNo(),
          questionListDTO.getQnaType().getTitle(),
          questionListDTO.getTitle(), 
          questionListDTO.getOwner().getId(),
          questionListDTO.getRegisteredDate(),
          questionListDTO.getViewCount(),
          questionListDTO.getStatus());
      for (QuestionAttachedFile questionAttachedFile : questionListDTO.getFileUpload()) {
        System.out.printf("%s\n", questionAttachedFile.getFilepath());
      }
      if (questionListDTO.getStatus() == 1) {
        System.out.println("답변드립니다.");
      }

    }
  }
}