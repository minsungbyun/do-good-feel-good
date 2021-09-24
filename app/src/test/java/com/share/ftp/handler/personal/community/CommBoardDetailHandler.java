package com.share.ftp.handler.personal.community;

import java.util.List;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.personal.CommBoardReplyDTO;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class CommBoardDetailHandler extends AbstractCommBoardHandler {


  public CommBoardDetailHandler(
      List<CommBoardDTO> commBoardDTOList, 
      List<CommBoardReplyDTO> commBoardCommentDTOList) {
    super(commBoardDTOList, commBoardCommentDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    while(true) {
      System.out.println();
      System.out.println("[  소통해요/ 나눔이야기/ 상세보기  ]");
      System.out.println();

      int no = Prompt.inputInt("번호? ");

      CommBoardDTO commBoardDTO = findByNo(no);

      if (commBoardDTO == null) {
        System.out.println("[  해당 게시글이 없습니다.  ]");
        return;
      }
      //AuthLoginHandler.loginUser.getId(),

      System.out.printf("아이디 ▶ %s\n", commBoardDTO.getOwner().getId());
      System.out.printf("번호 ▶ %s\n", commBoardDTO.getCommNo());
      System.out.printf("제목 ▶ %s\n", commBoardDTO.getTitle());
      System.out.printf("내용 ▶ %s\n", commBoardDTO.getContent());
      System.out.printf("첨부파일 ▶ %s\n", commBoardDTO.getFileUpload());

      commBoardDTO.setViewCount(commBoardDTO.getViewCount() + 1);
      System.out.printf("조회수 ▶ %d\n", commBoardDTO.getViewCount());
      System.out.printf("좋아요♡  %d\n", commBoardDTO.getLike());
      System.out.println();

      JoinDTO loginUser = AuthLoginHandler.getLoginUser(); 

      if (commBoardDTO.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) {

        request.setAttribute("no", no);

        while (true) {
          String input = Prompt.inputString("변경(U), 삭제(D), 이전(0)>");
          switch (input) {
            case "U":
            case "u":
              request.getRequestDispatcher("/commBoard/update").forward(request);
              return;
            case "D":
            case "d":
              request.getRequestDispatcher("/commBoard/delete").forward(request);
              return;
            case "0":
              return;
            default:
              System.out.println("명령어가 올바르지 않습니다!");
          }
        } 
      } 

      if (loginUser!= null) {

        request.setAttribute("no", no);

        while (true) {
          String input = Prompt.inputString("좋아요(L), 댓글(R), 이전(0)>");
          switch (input) {
            case "L":
            case "l":
              request.getRequestDispatcher("/commBoard/like").forward(request);
              return;
            case "R":
            case "r":
              request.getRequestDispatcher("/commBoardReply/connect").forward(request);
              return;
            case "0":
              return;
            default:
              System.out.println("명령어가 올바르지 않습니다!");
          }
        } 
      }

    }
  }



  //      while (true) {
  //        System.out.println();
  //        System.out.println("1: 댓글");
  //        System.out.println("2: 여자 목록");
  //        System.out.println("3번: 참여인증&댓글");
  //        System.out.println("4번: 문의하기");
  //        System.out.println("5번: 좋아요♡");
  //        System.out.println("6번: 찜하기🎈");
  //        System.out.println("0번: 이전");
  //        int input = Prompt.inputInt("번호 입력 > ");
  //        switch (input) {
  //          case 1: request.getRequestDispatcher("/challengeJoin/join").forward(request); break;
  //          case 2: request.getRequestDispatcher("/challengeJoin/list").forward(request); break;
  //          case 3: request.getRequestDispatcher("/challengeReview/connect").forward(request); break;
  //          case 4: request.getRequestDispatcher("/challengeQuestion/connect").forward(request); break;
  //          case 5: request.getRequestDispatcher("/challengeDetail/like").forward(request); break;
  //          case 6: request.getRequestDispatcher("/challengeDetail/wish").forward(request); break;
  //          case 0: return;
  //          default:
  //            System.out.println("명령어가 올바르지 않습니다!");
  //        }
  //      
}

