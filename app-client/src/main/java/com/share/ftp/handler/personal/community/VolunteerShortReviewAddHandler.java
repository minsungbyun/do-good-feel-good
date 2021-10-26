package com.share.ftp.handler.personal.community;

import java.sql.Date;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolunteerShortReviewDao;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolunteerShortReviewAddHandler implements Command {

  VolunteerShortReviewDao volunteerShortReviewDao;
  SqlSession sqlSession;

  public VolunteerShortReviewAddHandler(VolunteerShortReviewDao volunteerShortReviewDao, SqlSession sqlSession) {
    this.volunteerShortReviewDao = volunteerShortReviewDao;
    this.sqlSession=sqlSession;
  }
  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[  한줄후기 등록  ]");

    VolunteerRequestDTO volunteerRequestDTO = (VolunteerRequestDTO) request.getAttribute("project");
    if (!volunteerRequestDTO.getMemberNames().contains(AuthLoginHandler.getLoginUser().getId()) ) {
      System.out.println("봉사 참여한 회원만 등록이 가능합니다!");
      return;
    }


    //      VolunteerRequestDTO volunteerRequestDTO = new VolunteerRequestDTO();

    //    volunteerShortReviewDTO.setNo(volunteerShortReviewDao.getNextNumCommReview());
    volunteerRequestDTO.setContent(Prompt.inputString("내용  ▶ "));
    volunteerRequestDTO.setRegisteredDate(new Date(System.currentTimeMillis()));
    volunteerRequestDTO.setOwner(AuthLoginHandler.getLoginUser());

    volunteerShortReviewDao.insert(volunteerRequestDTO);
    sqlSession.commit();

    System.out.println();
    System.out.println("[  후기가 등록 되었습니다. ]");
  }
}











