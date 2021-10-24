package com.share.ftp.handler.personal.community;

import java.sql.Date;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolunteerShortReviewDao;
import com.share.ftp.domain.community.VolunteerShortReviewDTO;
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

    // 봉사 참여 회원 등록 권한 설정 필요
    //    if (!generalRequestDTO.getMemberNames().contains(AuthLoginHandler.getLoginUser().getId()) ) {
    //      System.out.println("봉사 참여한 회원만 등록이 가능합니다!");
    //      return;

    VolunteerShortReviewDTO volunteerShortReviewDTO = new VolunteerShortReviewDTO();

    //    volunteerShortReviewDTO.setNo(volunteerShortReviewDao.getNextNumCommReview());
    volunteerShortReviewDTO.setContent(Prompt.inputString("내용  ▶ "));
    volunteerShortReviewDTO.setRegisteredDate(new Date(System.currentTimeMillis()));
    volunteerShortReviewDTO.setOwner(AuthLoginHandler.getLoginUser());

    volunteerShortReviewDao.insert(volunteerShortReviewDTO);
    sqlSession.commit();

    System.out.println();
    System.out.println("[  후기가 등록 되었습니다. ]");
  }
}










