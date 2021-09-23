//package com.share.ftp.handler.admin;
//
//import java.util.List;
//import com.share.ftp.domain.admin.QuestionDTO;
//import com.share.ftp.handler.CommandRequest;
//
//public class AdminQuestionListHandler extends AbstractAdminQuestionHandler {
//
//
//
//  public AdminQuestionListHandler(List<QuestionDTO> questionDTOList) {
//    super(questionDTOList);
//  }
//
//  @Override
//  public void execute(CommandRequest request) throws Exception {
//    System.out.println("[문의사항 목록]");
//    for (QuestionDTO questionDTO : questionDTOList) {
//      System.out.printf("%d, %s, %s\n", 
//          questionDTO.getAdminId(), 
//          questionDTO.getTitle(), 
//          questionDTO.getContent());
//    }
//  }
//
//
//
//}
