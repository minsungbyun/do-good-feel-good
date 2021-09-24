//package com.share.ftp.handler.admin;
//
//import java.util.List;
//import com.share.ftp.domain.admin.QuestionDTO;
//import com.share.ftp.handler.CommandRequest;
//import com.share.util.Prompt;
//
//public class AdminQuestionDetailHandler extends AbstractAdminQuestionHandler {
//
//
//
//  public AdminQuestionDetailHandler(List<QuestionDTO> questionDTOList) {
//    super(questionDTOList);
//  }
//
//
//  public void execute(CommandRequest request) throws Exception {
//    System.out.println("[문의사항 상세보기]");
//    int no = Prompt.inputInt("관리자ID: ");
//
//    QuestionDTO questionDTO = findByNo(no);
//
//    if (questionDTO == null) {
//      System.out.println("해당 번호의 게시글이 없습니다.");
//      return;
//    }
//
//    System.out.printf("제목: %s\n", questionDTO.getTitle());
//    System.out.printf("내용: %s\n", questionDTO.getContent());
//  }
//
//
//}
