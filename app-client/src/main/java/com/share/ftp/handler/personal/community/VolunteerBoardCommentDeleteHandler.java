package com.share.ftp.handler.personal.community;

import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolunteerBoardCommentDao;
import com.share.ftp.dao.VolunteerBoardDao;
import com.share.ftp.domain.community.VolunteerBoardCommentDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolunteerBoardCommentDeleteHandler implements Command {

  VolunteerBoardDao volunteerBoardDao;
  VolunteerBoardCommentDao volunteerBoardCommentDao;
  SqlSession sqlSession;

  public VolunteerBoardCommentDeleteHandler (VolunteerBoardDao volunteerBoardDao,
      VolunteerBoardCommentDao volunteerBoardCommentDao,
      SqlSession sqlSession) {
    this.volunteerBoardDao = volunteerBoardDao;
    this.volunteerBoardCommentDao = volunteerBoardCommentDao;
    this.sqlSession =sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    while (true) {
      System.out.println("[  나눔이야기 댓글 삭제  ]");

      int volBoardNo = (int) request.getAttribute("volBoardNo");
      int commentNo = Prompt.inputInt("댓글 번호를 입력해주세요 ▶ ");

      VolunteerBoardCommentDTO volunteerBoardCommentDTO = volunteerBoardCommentDao.findByCommentNo(volBoardNo, commentNo);

      if (volunteerBoardCommentDTO == null) {
        System.out.println("[  해당 댓글이 없습니다.  ]");
        return;
      }

      if ((volunteerBoardCommentDTO.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) ||
          AuthLoginHandler.getLoginUser().getId().equals("admin")) {
      } else {
        System.out.println("변경 권한이 없습니다.");
        return;
      }

      while (true) {
        String input = Prompt.inputString("[  정말 삭제하시겠습니까?(y/N)  ]");
        if (input.equalsIgnoreCase("n") || input.length() == 0) {
          System.out.println();
          System.out.println("[  댓글 삭제를 취소하였습니다.  ]");
          return;

        } else if(input.equalsIgnoreCase("y")) {
          System.out.println();

          //          volunteerBoardDao.update(volunteerBoardDTO);
          volunteerBoardCommentDao.delete(commentNo);
          sqlSession.commit();

          System.out.println("[  댓글을 삭제하였습니다.  ]");
          return;

        } else  {
          System.out.println("[  y 또는 n을 입력하세요.  ]");
        } 
      }
    }
  }
}



