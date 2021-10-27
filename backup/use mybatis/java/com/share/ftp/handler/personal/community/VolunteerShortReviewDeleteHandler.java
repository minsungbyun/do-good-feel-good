package com.share.ftp.handler.personal.community;

import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolunteerShortReviewDao;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolunteerShortReviewDeleteHandler implements Command {

  VolunteerShortReviewDao volunteerShortReviewDao;
  SqlSession sqlSession;

  public VolunteerShortReviewDeleteHandler(VolunteerShortReviewDao volunteerShortReviewDao, SqlSession sqlSession) {
    this.volunteerShortReviewDao = volunteerShortReviewDao;
    this.sqlSession=sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    try {

      System.out.println();
      System.out.println("[  한 줄 후기 삭제  ]");
      int no = (int) request.getAttribute("no");

      VolunteerRequestDTO volunteerShortReviewDTO = volunteerShortReviewDao.findByNo(no);


      if (volunteerShortReviewDTO == null) {
        System.out.println("[  해당 번호의 후기가 없습니다.  ]");
        return;
      }

      if ((volunteerShortReviewDTO.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) ||
          AuthLoginHandler.getLoginUser().getId().equals("admin")) {

      } else {
        System.out.println("삭제 권한이 없습니다.");
        return;
      }

      String input = Prompt.inputString("[  정말 삭제하시겠습니까?(y/N)  ]");
      if (input.equalsIgnoreCase("n") || input.length() == 0) {
        System.out.println("[  한 줄 후기 삭제를 취소하였습니다.  ]");
        return;
      } 

      volunteerShortReviewDao.delete(no);

      System.out.println("[  한 줄 후기가 삭제 되었습니다. ]");
    }


    catch (Throwable e) {

    }
  }
}














