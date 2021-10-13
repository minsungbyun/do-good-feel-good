package com.share.ftp.handler.personal.community;

import java.sql.Date;
import com.share.ftp.dao.CommunityDao;
import com.share.ftp.domain.community.CommBoardDTO;
import com.share.ftp.domain.community.CommBoardReplyDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class CommBoardReplyAddHandler implements Command {

  CommunityDao communityDao;

  public CommBoardReplyAddHandler (CommunityDao communityDao) {
    this.communityDao = communityDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[  나눔이야기 댓글 등록  ]");
    System.out.println();
    int commBoardNo = (int) request.getAttribute("commBoardNo");

    CommBoardDTO commBoardDTO = communityDao.findByCommBoardNo(commBoardNo);


    CommBoardReplyDTO commBoardReplyDTO = new CommBoardReplyDTO();

    commBoardReplyDTO.setNo(commBoardDTO.getNo());
    commBoardReplyDTO.setCommentcontent(Prompt.inputString("내용 ▶ "));
    commBoardReplyDTO.setRegisteredDate(new Date(System.currentTimeMillis()));
    commBoardReplyDTO.setOwner(AuthLoginHandler.getLoginUser());
    // commBoardReplyDTO.setCommReplyNo(getNextNum());
    // commBoardReplyDTO.setPassword(Prompt.inputString("비밀번호 ▶ "));

    if (commBoardDTO.getReplyCount() == 0) {
      commBoardDTO.setReplyCount(1);
      //      System.out.println("각 게시글의 첫 댓글입니다");
    } else {
      commBoardDTO.setReplyCount(communityDao.getNextNumCommBoardReply(commBoardDTO));
    }

    commBoardReplyDTO.setReplyNo(commBoardDTO.getReplyCount()); 

    while (true) {
      String input = Prompt.inputString("해당 게시글에 댓글 등록을 하시겠습니까? (y/N) ");
      System.out.println();
      if (!input.equals("y") || input.length() == 0) {
        System.out.println();
        System.out.println("댓글 등록이 취소되었습니다.");
        return;

      } else if (input.equalsIgnoreCase("y")) {

        communityDao.update(commBoardDTO);
        communityDao.insertCommBoardReply(commBoardReplyDTO);

        System.out.println();
        System.out.println("[  댓글 등록이 완료되었습니다.  ]");
        break;

      } else {
        System.out.println("다시 입력해주세요.");
      }
    }
  }
}