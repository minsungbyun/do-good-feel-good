package com.share.ftp.handler.personal.community;

import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolunteerShortReviewDao;
import com.share.ftp.domain.community.VolunteerShortReviewDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class VolunteerShortReviewUpdateHandler implements Command {

  VolunteerShortReviewDao volunteerShortReviewDao;
  SqlSession sqlSession;

  public VolunteerShortReviewUpdateHandler(VolunteerShortReviewDao volunteerShortReviewDao, SqlSession sqlSession) {
    this.volunteerShortReviewDao = volunteerShortReviewDao;
    this.sqlSession=sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[  한 줄 후기 변경  ]");
    int no = (int) request.getAttribute("no");

    VolunteerShortReviewDTO volunteerShortReviewDTO = volunteerShortReviewDao.findByNo(no);


    if (volunteerShortReviewDTO == null) {
      System.out.println("[  해당 번호의 후기가 없습니다.  ]");
      return;
    }

    //        if (volunteerShortReviewDTO.getOwner().getId() != AuthLoginHandler.getLoginUser().getId()) {
    //          System.out.println("[  삭제 권한이 없습니다.  ]");
    //          return;
    //        }

    String content = Prompt.inputString(String.format("내용(%s)? ", volunteerShortReviewDTO.getContent()));
    String input = Prompt.inputString("[  정말 변경하시겠습니까?(y/N)  ]");

    if (input.equalsIgnoreCase("n")) {
      System.out.println("[  변경을 취소하였습니다.  ]");
      return;

    } else if(input.equals("y")) {
      volunteerShortReviewDTO.setContent(content);

      volunteerShortReviewDao.update(volunteerShortReviewDTO);
      sqlSession.commit();

      System.out.println();
      System.out.println("[  변경 되었습니다. ]");
      //      return;
    }

    //    else {
    //      System.out.println("[ y 또는 n을 입력하세요. ]");
    //      continue;
    //    }

  }
}










