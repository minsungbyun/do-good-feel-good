package com.share.ftp.handler.personal.community;

import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolunteerBoardDao;
import com.share.ftp.domain.community.VolunteerBoardDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolunteerBoardLikeHandler implements Command {

  VolunteerBoardDao volunteerBoardDao;
  SqlSession sqlSession;

  public VolunteerBoardLikeHandler(VolunteerBoardDao volunteerBoardDao, SqlSession sqlSession) {
    this.volunteerBoardDao =  volunteerBoardDao;
    this.sqlSession = sqlSession;
  }


  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[  LIKE  ]");

    int volBoardNo = (int) request.getAttribute("volBoardNo");

    VolunteerBoardDTO volunteerBoardDTO = volunteerBoardDao.findByNo(volBoardNo);

    while (true) {
      //      JoinDTO joinDTO = AuthLoginHandler.getLoginUser();
      //    Collection<VolunteerBoardDTO> VolunteerBoardDTOList = volunteerBoardDao.findAll();

      String input = Prompt.inputString("[  공감이 되셨다면 좋아요를 눌러주세요(y/N)  ] ");

      //      if (volunteerBoardDTO.getLikeMembers().contains(joinDTO)) {
      //        System.out.println("좋아요는 1번만 가능합니다."); 
      //        return;
      //      }

      if (input.equalsIgnoreCase("n") || input.length() == 0) {
        System.out.println("[  좋아요 취소  ]");
        return;

      } else if (input.equals("y")) {

        try {
          volunteerBoardDTO.setLike(AuthLoginHandler.getLoginUser());

          volunteerBoardDao.addLike(AuthLoginHandler.getLoginUser().getNo(),volunteerBoardDTO.getNo());
          sqlSession.commit();
          System.out.println("[  LIKE 등록 되었습니다.  ]");
          return;
        } catch (Exception e) {
          String input2 = Prompt.inputString("[  좋아요를 취소하시겠습니까?(y/N)  ] ");
          if (input2.equalsIgnoreCase("y")) {
            System.out.println("[  좋아요 취소  ]");
            volunteerBoardDao.deleteLike(volunteerBoardDTO.getLike().getNo(), volunteerBoardDTO.getNo());
            sqlSession.commit();
            return;

          }
        }

      } else {
        System.out.println("y 또는 n을 입력하세요.");
        continue;
      }
    } 
  }
}

