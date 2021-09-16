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
    int boardNo = Prompt.inputInt("번호? ");

    QuestionListDTO myQuestionListDTO = findByNo(boardNo);

    if (myQuestionListDTO == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    if (myQuestionListDTO.getOwner().getId() == (AuthLoginHandler.getLoginUser().getId()) ||
        AuthLoginHandler.getLoginUser().getId().equals("admin")) {

      System.out.printf("번호: %s\n", myQuestionListDTO.getBoardNo());
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

    if (AuthLoginHandler.getLoginUser().getId().equals("admin")) {


      System.out.printf("%d", "--------------------------------------------");
      System.out.println("[2 ▶ 댓글 등록]");
      System.out.println("[3 ▶ 댓글 수정]");
      System.out.println("[4 ▶ 댓글 삭제]");

      //          int input = Prompt.inputInt("분류 ▶ ");
      //          switch (input) {
      //            case 1 : addComment(askBoard); break;
      //            case 2 : updateComment(); break;
      //            case 3 : deleteComment(askBoard); break;
      //            case 4 : deleteComment(askBoard); break;
      //          //            default : return;
      //        }
      //      }
      //    }
    } 


  }
}