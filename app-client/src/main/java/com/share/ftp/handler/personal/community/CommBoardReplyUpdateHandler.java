package com.share.ftp.handler.personal.community;

import com.share.ftp.dao.CommunityDao;
import com.share.ftp.domain.personal.CommBoardReplyDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class CommBoardReplyUpdateHandler implements Command {

  CommunityDao communityDao;

  public CommBoardReplyUpdateHandler(CommunityDao communityDao) {
    this.communityDao =  communityDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[  나눔이야기 댓글 변경  ]");

    int commNo = (int) request.getAttribute("commNo");

    int updateNo = (int) request.getAttribute("commBoardReplyNo");

    CommBoardReplyDTO commBoardReplyDTO = communityDao.findByCommReplyNo(commNo, updateNo);


    if (commBoardReplyDTO == null) {
      System.out.println("[  해당 댓글이 없습니다.  ]");
      return;
    }

    if (!commBoardReplyDTO.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) {
      System.out.println("변경 권한이 없습니다.");
      return;
    }

    String content = Prompt.inputString(
        String.format("내용(%s)? ", commBoardReplyDTO.getCommentcontent()));

    String input = Prompt.inputString("[  정말 변경하시겠습니까?(y/N)  ]");
    if (input.equalsIgnoreCase("n") || input.length() == 0)  {
      System.out.println();
      System.out.println("[  댓글 변경을 취소하였습니다.  ]");
      return;

    } else if(input.equals("y")) {
      System.out.println();
      System.out.println("[  댓글을 변경하였습니다.  ]");
      commBoardReplyDTO.setCommentcontent(content);

      communityDao.updateCommReply(commBoardReplyDTO);

      return;


    } 
  }
}
