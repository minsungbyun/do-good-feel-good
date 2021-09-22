package com.share.ftp.handler.personal.support;

import java.util.List;
import com.share.ftp.domain.personal.QuestionListDTO;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class QuestionDetailHandler extends AbstractQuestionHandler {

  public QuestionDetailHandler(List<QuestionListDTO> myQuestionListDTOList) {
    super (myQuestionListDTOList);
  }

  public void execute() {

    System.out.println();
    System.out.println("[고객센터/문의하기/상세보기]");
    System.out.println("비밀번호를 입력해주세요.");
    System.out.println();

    int passwoard = Prompt.inputInt("비밀번호: ");
    System.out.println();
    
    if (myQuestionListDTO.getPassword == )
      
//    int no = Prompt.inputInt("번호? ");
//
//    QuestionListDTO myQuestionListDTO = findByNo(no);

//    if (myQuestionListDTO == null) {
//      System.out.println("해당 번호의 게시글이 없습니다.");
//      return;
//    }

    if ((myQuestionListDTO.getOwner().getId() == AuthLoginHandler.getLoginUser().getId()) ||
        AuthLoginHandler.getLoginUser().getId().equals("admin")) {

      System.out.printf("번호: %s\n", myQuestionListDTO.getNo());
      System.out.printf("문의분야: %s\n", myQuestionListDTO.getSort());
      System.out.printf("제목: %s\n", myQuestionListDTO.getTitle());
      System.out.printf("아이디: %s\n", myQuestionListDTO.getOwner().getId());
      System.out.printf("내용: %s\n", myQuestionListDTO.getContent());
      System.out.printf("첨부파일: %s\n", myQuestionListDTO.getFileUpload());
      System.out.printf("등록일: %s\n", myQuestionListDTO.getRegisteredDate());

      myQuestionListDTO.setViewCount(myQuestionListDTO.getViewCount() + 1);
      System.out.printf("조회수: %d\n", myQuestionListDTO.getViewCount());

    }

    //    if (myQuestionListDTO.getOwner().getId() == (AuthLoginHandler.getLoginUser().getId()) ||
    //        AuthLoginHandler.getLoginUser().getId().equals("admin")) {
    //
    //      System.out.printf("번호: %s\n", myQuestionListDTO.getBoardNo());
    //      System.out.printf("문의분야: %s\n", myQuestionListDTO.getSort());
    //      System.out.printf("제목: %s\n", myQuestionListDTO.getTitle());
    //      System.out.printf("아이디: %s\n", myQuestionListDTO.getOwner().getId());
    //      System.out.printf("내용: %s\n", myQuestionListDTO.getContent());
    //      System.out.printf("첨부파일: %s\n", myQuestionListDTO.getFileUpload());
    //      System.out.printf("등록일: %s\n", myQuestionListDTO.getRegisteredDate());
    //
    //      myQuestionListDTO.setViewCount(myQuestionListDTO.getViewCount() + 1);
    //      System.out.printf("조회수: %d\n", myQuestionListDTO.getViewCount());
    //      return;
    //    }

    if (myQuestionListDTO.getOwner().getId() != AuthLoginHandler.getLoginUser().getId()) {
      System.out.println("본인이 작성한 글만 확인할 수 있습니다.");
      return;
    }

  } 


}