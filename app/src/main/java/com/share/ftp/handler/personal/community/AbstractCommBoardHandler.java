package com.share.ftp.handler.personal.community;

import java.util.List;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.domain.personal.CommBoardReplyDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractCommBoardHandler implements Command {

  protected List<CommBoardDTO> commBoardDTOList;
  protected List<CommBoardReplyDTO> commBoardReplyDTOList;

  public AbstractCommBoardHandler(
      List<CommBoardDTO> commBoardDTOList, 
      List<CommBoardReplyDTO> commBoardReplyDTOList) {
    this.commBoardDTOList = commBoardDTOList;
    this.commBoardReplyDTOList = commBoardReplyDTOList;
  }

  protected CommBoardDTO findByNo(int no) {
    for(CommBoardDTO commBoardDTO : commBoardDTOList) {
      if (commBoardDTO.getCommNo() == no) {
        return commBoardDTO;
      }
    }
    return null;
  }

  protected int getNextNum() {
    if (commBoardDTOList.size() > 0) {
      return commBoardDTOList.get(commBoardDTOList.size() - 1).getCommNo() + 1;
    } else {
      return 1;
    }
  }
}


//  에러 걸려서 주석좀 막을게 !! 에러 걸려서 주석좀 막을게 !! 에러 걸려서 주석좀 막을게 !! 
//  에러 걸려서 주석좀 막을게 !! 에러 걸려서 주석좀 막을게 !! 에러 걸려서 주석좀 막을게 !!

//  protected void addComment(CommBoardDTO commBoardDTOList) {
//    System.out.println();
//    System.out.println("▶ 댓글 등록");
//    System.out.println();
//
//
//



//    CommBoardCommentDTO commBoardCommentDTO = new CommBoardCommentDTO();
//
//    commBoardCommentDTO.setCommentText(Prompt.inputString("댓글 내용 : "));
//    System.out.println();
//    commBoardCommentDTO.setCommentAdminWiter(adminWiter);
//    commBoardCommentDTO.setCommentRegisteredDate(new Date(System.currentTimeMillis()));
//    //
//    String input = Prompt.inputString("정말 등록하시겠습니까? (네 / 아니오) ");
//    if (!input.equalsIgnoreCase("네")) {
//      System.out.println("댓글 등록을 취소하였습니다.");
//      return;
//    }
//
//    commentList.add(commBoardCommentDTO);
//    askBoard.getAdminComment().add(commBoardCommentDTO);
//
//    System.out.println("댓글이 등록되었습니다.");
//  }
//}
//
//protected void listComment(AskBoard askBoard) {
//  System.out.println();
//  System.out.println("=============댓글=============");
//  int commentSize = 0;
//
//  for (Comment comment : askBoard.getAdminComment()) {
//    System.out.printf("(%d) >> 내용 : %s | 작성자 : %s | 등록일 : %s\n",
//        comment.getCommentNo(),
//        comment.getCommentText(), 
//        comment.getCommentAdminWiter().getMasterNickname(),
//        comment.getCommentRegisteredDate());
//    commentSize++;
//  }
//
//  if (commentSize == 0) {
//    System.out.println("등록된 댓글이 없습니다.");
//  }
//
//}
//

//  protected Comment findByComment (int commentNo) {
//    for (Comment comment : commentList) {
//      if (comment.getCommentNo() == commentNo) {
//        return comment;
//      }
//    }
//    return null;
//  }
//