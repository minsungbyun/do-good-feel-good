package com.share.ftp.handler.personal.community;

import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolunteerBoardDao;
import com.share.ftp.domain.community.CommBoardDTO;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class CommBoardLikeHandler implements Command {

  VolunteerBoardDao volunteerBoardDao;
  SqlSession sqlSession;

  public CommBoardLikeHandler(VolunteerBoardDao volunteerBoardDao, SqlSession sqlSession) {
    this.volunteerBoardDao =  volunteerBoardDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    JoinDTO joinDTO = AuthLoginHandler.getLoginUser();
    // while (true) {
    System.out.println("[  LIKE  ]");
    System.out.println();
    int commBoardNo = (int) request.getAttribute("commBoardNo");
    System.out.println();

    // CommBoardDTO commBoard = findByCommNo(commNo); 
    //  Collection<CommBoardDTO> CommBoardDTOList = communityDao.findAll();

    CommBoardDTO commBoardDTO = volunteerBoardDao.findByCommBoardNo(commBoardNo);

    String input = Prompt.inputString("[  공감이 되셨다면 좋아요를 눌러주세요(y/N)  ] ");

    if (commBoardDTO.getLikeMembers().contains(joinDTO)) {
      System.out.println("좋아요는 1번만 가능합니다."); 
      return;
    }

    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("[  좋아요 취소  ]");
      return;

    } else if (input.equals("y")) {
      commBoardDTO.setLike(commBoardDTO.getLike() + 1);
      commBoardDTO.addLikeMember(joinDTO);

      System.out.println("[  LIKE 등록 완료  ]");

      volunteerBoardDao.update(commBoardDTO);
      sqlSession.commit();

      return;

    }
  } 
}



//    String input = Prompt.inputString("[  공감이 되셨다면 좋아요를 눌러주세요(y/N)  ] ");
//
//    for (CommBoardDTO commBoardDTO : CommBoardDTOList) {
//      if (commBoardDTO.getLikeMembers().contains(joinDTO)) {
//        System.out.println("좋아요는 1번만 가능합니다."); 
//        return;
//      }
//    }
//
//    if (input.equalsIgnoreCase("n") || input.length() == 0) {
//      System.out.println("[  좋아요 취소  ]");
//      return;
//
//    } else if (input.equals("y")) {
//      commBoardDTO.setLike(commBoardDTO.getLike() + 1);
//      commBoardDTO.addLikeMember(joinDTO);
//
//      commBoardDTO.add(commBoard);
//
//      System.out.println("[  LIKE 등록 완료  ]");
//
//      return;
//    } else {
//      System.out.println("y 또는 n을 입력하세요.");
//      continue;
//    } 
//  } 
//}
//}

