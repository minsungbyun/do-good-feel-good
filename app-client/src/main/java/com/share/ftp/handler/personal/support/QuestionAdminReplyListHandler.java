package com.share.ftp.handler.personal.support;

import java.util.Collection;
import com.share.ftp.dao.QuestionDao;
import com.share.ftp.domain.support.QuestionListDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class QuestionAdminReplyListHandler implements Command {

  QuestionDao questionDao;

  public QuestionAdminReplyListHandler(QuestionDao questionDao) {
    this.questionDao = questionDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ 문의하기 - 관리자 답글목록 ]");

    Collection<QuestionListDTO> questionList = questionDao.findAll();

    if (questionList.isEmpty()) {
      System.out.println("게시글이 없습니다.");
      System.out.println();
    }


    for (QuestionListDTO questionListDTO : questionList) {
      System.out.printf("%d, %s, %d,", 
          questionListDTO.getNo(),
          questionListDTO.getRegisteredDate(),
          questionListDTO.getViewCount());
      if (questionListDTO.getReply() != null) {
        System.out.printf("%s\n", questionListDTO.getReply());
      }

    }
  }
}