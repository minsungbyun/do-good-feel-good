//package com.share.ftp.handler.admin;
//
//import java.sql.Date;
//import java.util.List;
//import com.share.ftp.domain.admin.QuestionDTO;
//import com.share.util.Prompt;
//
//public class AdminQuestionAddHandler extends AbstractAdminQuestionHandler {
//
//  public AdminQuestionAddHandler(List<QuestionDTO> questionDTOList) {
//    super(questionDTOList);
//  }
//
//  public void execute() {
//    System.out.println("[ 문의사항 답글 ]");
//
//    QuestionDTO questionDTO = new QuestionDTO();
//
//    questionDTO.setTitle(Prompt.inputString("제목: "));
//    questionDTO.setContent(Prompt.inputString("내용: "));
//    questionDTO.setAdminId("작성자: ");
//    questionDTO.setFileUpload(Prompt.inputString("파일첨부: "));
//    questionDTO.setRegisteredDate(new Date(System.currentTimeMillis()));
//
//    questionDTO.setNo(getNextNum());
//
//  }
//
//
//
//}
