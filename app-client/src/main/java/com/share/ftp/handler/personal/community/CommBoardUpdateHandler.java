package com.share.ftp.handler.personal.community;

import com.share.ftp.dao.CommunityDao;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class CommBoardUpdateHandler  implements Command {

  CommunityDao communityDao;

  public CommBoardUpdateHandler (CommunityDao communityDao) {
    this.communityDao =  communityDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {


    System.out.println();
    System.out.println("[  나눔이야기 게시글변경  ]");
    int commNo = (int) request.getAttribute("commNo");

    CommBoardDTO commBoardDTO = communityDao.findByCommNo(commNo);

    if (commBoardDTO == null) {
      System.out.println("[  해당 게시글이 없습니다.  ]");
      return;
    }

    CommBoardDTO updateCommBoard = new CommBoardDTO();

    updateCommBoard.setTitle(Prompt.inputString("제목(" + commBoardDTO.getTitle() + ")? "));
    updateCommBoard.setContent(Prompt.inputString("내용(" + commBoardDTO.getContent() + ")? "));
    updateCommBoard.setFileUpload(Prompt.inputString("첨부파일(" + commBoardDTO.getFileUpload() + ")? "));

    String input = Prompt.inputString("[  정말 변경하시겠습니까?(y/N)  ]");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("[  게시글 변경을 취소하였습니다.  ]");
      return;
    }

    //        else if(input.equals("y")) {
    //          commBoardDTO.setTitle(title);
    //          commBoardDTO.setContent(content);
    //          commBoardDTO.setFileUpload(fileUpload);

    communityDao.update(commBoardDTO);

    System.out.println("[  게시글을 변경하였습니다.  ]");
    return;
  }


}





