package com.share.ftp.handler.personal.community;

import com.share.ftp.dao.CommunityDao;
import com.share.ftp.domain.community.CommBoardReplyDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class CommBoardReplyConnectHandler implements Command {

  CommunityDao communityDao;

  public CommBoardReplyConnectHandler (CommunityDao communityDao) {
    this.communityDao = communityDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ 댓글 변경 / 삭제]");
    System.out.println();

    int commBoardNo = (int) request.getAttribute("commBoardNo");
    int commBoardReplyNo = Prompt.inputInt("댓글 번호를 입력해주세요 ▶ ");

    CommBoardReplyDTO commBoardReplyDTO = communityDao.findByCommBoardReplyNo(commBoardNo, commBoardReplyNo);

    if (commBoardReplyDTO == null) {
      System.out.println("해당 번호의 댓글이 없습니다.");
      return;
    }

    if ((commBoardReplyDTO.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) ||
        AuthLoginHandler.getLoginUser().getId().equals("admin")) {

      System.out.printf("아이디: %s\n", commBoardReplyDTO.getOwner().getId());
      System.out.printf("내용: %s\n", commBoardReplyDTO.getCommentcontent());
      System.out.printf("등록날짜: %s\n", commBoardReplyDTO.getRegisteredDate());

    } else {
      System.out.println("본인이 작성한 글만 변경할 수 있습니다.");
      return;
    }

    System.out.println();

    request.setAttribute("commBoardReplyNo", commBoardReplyNo); 

    while (true) {
      System.out.println();
      System.out.println("1번 ▶ 댓글 변경");
      System.out.println("2번 ▶ 댓글 삭제");
      System.out.println("0번: 이전");
      System.out.println();
      int input = Prompt.inputInt("번호 입력 ▶ ");
      switch (input) {
        case 1: request.getRequestDispatcher("/commBoardReply/update").forward(request); break;
        case 2: request.getRequestDispatcher("/commBoardReply/delete").forward(request); break;
        case 0: return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");
      }
    }
  }
}