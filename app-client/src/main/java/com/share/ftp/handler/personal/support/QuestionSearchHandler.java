package com.share.ftp.handler.personal.support;

import java.util.Collection;
import com.share.ftp.dao.QuestionDao;
import com.share.ftp.domain.support.QuestionListDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class QuestionSearchHandler implements Command {

  QuestionDao questionDao;

  public QuestionSearchHandler(QuestionDao questionDao) {
    this.questionDao = questionDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ 문의하기 - 검색 ]");

    String input = Prompt.inputString("검색어? ");

    Collection<QuestionListDTO> questionList = questionDao.findByKeyword(input);

    if (questionList.isEmpty()) {
      System.out.println();
      System.out.println("검색된 게시글이 없습니다.");
    }

    for (QuestionListDTO questionListDTO : questionList) {      
      System.out.printf("%d, %s, %s, %s, %d\n", 
          questionListDTO.getNo(), 
          questionListDTO.getTitle(), 
          questionListDTO.getOwner().getId(),
          questionListDTO.getRegisteredDate(),
          questionListDTO.getViewCount()); 
    }
  }
}







