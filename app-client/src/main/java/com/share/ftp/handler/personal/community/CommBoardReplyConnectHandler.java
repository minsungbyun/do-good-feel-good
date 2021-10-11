package com.share.ftp.handler.personal.community;

import com.share.ftp.dao.CommunityDao;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.domain.personal.CommBoardReplyDTO;
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

    int commNo = (int) request.getAttribute("commNo");
    CommBoardDTO commBoardDTO = communityDao.findByCommNo(commNo);

    int replyNo = Prompt.inputInt("댓글 번호를 입력해주세요 ▶ ");
    CommBoardReplyDTO commBoardReplyDTO = communityDao.findByCommReplyNo(replyNo);


    if (commBoardReplyDTO == null) {
      System.out.println("해당 번호의 댓글이 없습니다.");
      return;
    }

    if (!commBoardReplyDTO.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) {
      System.out.println("변경 권한이 없습니다.");
      return;
    }

    request.setAttribute("replyNo", replyNo); 

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