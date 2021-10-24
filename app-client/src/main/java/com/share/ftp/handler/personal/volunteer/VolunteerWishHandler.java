package com.share.ftp.handler.personal.volunteer;

import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolunteerWishHandler implements Command {

  VolunteerDao volunteerDao;
  SqlSession sqlSession;

  public VolunteerWishHandler(VolunteerDao volunteerDao,SqlSession sqlSession) {
    this.volunteerDao = volunteerDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[  🎈 WISH 🎈  ]");
    System.out.println();

    int volNo = (int) request.getAttribute("volNo");

    VolunteerRequestDTO VolunteerRequestDTO = volunteerDao.findByApprovedVolunteerNo(volNo); 

    while (true) {
      String input = Prompt.inputString("[  🎈 관심 봉사로 추가하시겠습니까?(y/N) 🎈 ] ");

      if (input.equalsIgnoreCase("n") || input.length() == 0) {
        System.out.println();
        System.out.println("[  ❌ WISH 취소 ❌  ]");
        return;

      } else if (input.equalsIgnoreCase("y")) {
        System.out.println();
        VolunteerRequestDTO.setWish(AuthLoginHandler.getLoginUser());
        volunteerDao.addWish(AuthLoginHandler.getLoginUser().getNo(),VolunteerRequestDTO.getNo());
        sqlSession.commit();
        System.out.println("[  🎈 관심 봉사로 등록되었습니다. 🎈  ]");
        return;

      } else {
        System.out.println("y 또는 n을 입력하세요.");
        continue;
      } 
    } 
  }
}

