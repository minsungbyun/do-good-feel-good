package com.share.ftp.handler.admin;

import java.sql.Date;
import com.share.ftp.dao.QuestionDao;
import com.share.ftp.domain.support.QuestionListDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class AdminQuestionAddHandler implements Command {

  QuestionDao questionDao;

  public AdminQuestionAddHandler(QuestionDao questionDao) {
    this.questionDao = questionDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[ 문의사항 - 답글 등록]");

    int questionNo = (int) request.getAttribute("questionNo");
    QuestionListDTO adminQuestionListDTO = questionDao.findByQuestionNo(questionNo);

    QuestionListDTO questionListDTO = new QuestionListDTO();

    questionListDTO.setTitle(Prompt.inputString("제목? "));
    questionListDTO.setContent(Prompt.inputString("내용? "));
    questionListDTO.setQnaType(adminQuestionListDTO.getQnaType());
    questionListDTO.setOwner(AuthLoginHandler.getLoginUser());
    questionListDTO.setPassword(AuthLoginHandler.getLoginUser().getAdminPassword());
    questionListDTO.setFileUpload(Prompt.inputString("파일첨부? "));
    questionListDTO.setRegisteredDate(new Date(System.currentTimeMillis()));


    questionListDTO.setNo(adminQuestionListDTO.getNo());

    int a = indexOf(adminQuestionListDTO.getNo());

    myQuestionListDTOList.add(a + 1, myQuestionListDTO);


    System.out.println();
    System.out.println("문의 답글이 등록되었습니다.");

  }

  //  @Override
  //  public void execute(CommandRequest request) throws Exception {
  //
  //    System.out.println();
  //    System.out.println("[ 문의사항 - 답글]");
  //
  //    int questionNo = (int) request.getAttribute("adminNo");
  //    QuestionListDTO adminQuestionListDTO = findByNo(questionNo);
  //
  //    QuestionListDTO questionListDTO = new QuestionListDTO();
  //
  //    questionListDTO.setTitle(Prompt.inputString("제목? "));
  //    questionListDTO.setContent(Prompt.inputString("내용? "));
  //    questionListDTO.setQnaType(adminQuestionListDTO.getQnaType());
  //    questionListDTO.setOwner(AuthLoginHandler.getLoginUser());
  //    questionListDTO.setPassword(AuthLoginHandler.getLoginUser().getAdminPassword());
  //    questionListDTO.setFileUpload(Prompt.inputString("파일첨부? "));
  //    questionListDTO.setRegisteredDate(new Date(System.currentTimeMillis()));
  //
  //    myQuestionListDTO.setNo(adminQuestionListDTO.getNo());

  //  int a = indexOf(adminQuestionListDTO.getNo());
  //
  //  myQuestionListDTOList.add(a + 1, myQuestionListDTO);
  //
  //    System.out.println();
  //    System.out.println("문의 답글이 등록되었습니다.");
  //
  //  }



}
