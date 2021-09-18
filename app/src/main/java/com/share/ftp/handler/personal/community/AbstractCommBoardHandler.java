package com.share.ftp.handler.personal.community;

import java.util.List;
import com.share.ftp.domain.personal.CommBoardCommentDTO;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractCommBoardHandler implements Command {

  protected List<CommBoardDTO> commBoardDTOList;
  protected List<CommBoardCommentDTO> commBoardCommentDTOList;

  public AbstractCommBoardHandler(List<CommBoardDTO> commBoardDTOList, List<CommBoardCommentDTO> commBoardCommentDTOList) {
    this.commBoardDTOList = commBoardDTOList;
    this.commBoardCommentDTOList = commBoardCommentDTOList;
  }

  protected CommBoardDTO findByNo(int no) {
    for(CommBoardDTO commBoardDTO : commBoardDTOList) {
      if (commBoardDTO.getCommNo() == no) {
        return commBoardDTO;
      }
    }
    return null;
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
  //protected void updateComment() {
  //  System.out.println();
  //  System.out.println("▶ 댓글 수정");
  //  System.out.println();
  //
  //  if (AuthAdminLoginHandler.getLoginAdmin() == null) {
  //    System.out.println("관리자만 변경 가능합니다.");
  //  } else  {
  //
  //    int admincommentNo = Prompt.inputInt("번호 : ");
  //
  //    Comment comment = findByComment(admincommentNo);
  //
  //    String AdmincommentTitle = Prompt.inputString(
  //        "댓글 내용(" +  comment.getCommentText() + ") : ");
  //    System.out.println();
  //
  //    String input = Prompt.inputString("정말 변경하시겠습니까? (네 / 아니오) ");
  //    if (!input.equalsIgnoreCase("네")) {
  //      System.out.println("댓글 변경이 취소되었습니다.");
  //      return;
  //    }
  //
  //    comment.setCommentText(AdmincommentTitle);
  //
  //    System.out.println("댓글을 변경하였습니다.");
  //  }
  //}
  //
  //protected void deleteComment(AskBoard askBoard) {
  //  System.out.println();
  //  System.out.println("▶ 댓글 삭제");
  //  System.out.println();
  //
  //  if (AuthAdminLoginHandler.getLoginAdmin() == null) {
  //    System.out.println("관리자만 삭제 가능합니다.");
  //  } else  {
  //
  //    int admincommentNo = Prompt.inputInt("번호 : ");
  //
  //    Comment comment = findByComment(admincommentNo);
  //
  //    System.out.println();
  //    String inputno = Prompt.inputString("정말 삭제하시겠습니까? (네 / 아니오) ");
  //    if (!inputno.equalsIgnoreCase("네")) {
  //      System.out.println("댓글 삭제를 취소하였습니다.");
  //      return;
  //    }
  //
  //    commentList.remove(comment);
  //    askBoard.getAdminComment().remove(comment);
  //
  //    System.out.println("댓글이 삭제되었습니다.");
  //
  //  }
  //}
}





//  protected Comment findByComment (int commentNo) {
//    for (Comment comment : commentList) {
//      if (comment.getCommentNo() == commentNo) {
//        return comment;
//      }
//    }
//    return null;
//  }
//