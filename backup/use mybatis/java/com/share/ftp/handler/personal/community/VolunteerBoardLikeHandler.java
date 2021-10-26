package com.share.ftp.handler.personal.community;

import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolunteerBoardDao;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class VolunteerBoardLikeHandler implements Command {

  VolunteerBoardDao volunteerBoardDao;
  SqlSession sqlSession;

  public VolunteerBoardLikeHandler(VolunteerBoardDao volunteerBoardDao, SqlSession sqlSession) {
    this.volunteerBoardDao =  volunteerBoardDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    //
    //    JoinDTO joinDTO = AuthLoginHandler.getLoginUser();
    //    // while (true) {
    //    System.out.println("[  LIKE  ]");
    //    System.out.println();
    //    int no = (int) request.getAttribute("no");
    //    System.out.println();
    //
    //    // VolunteerBoardDTO volunteerBoardDTO = findByNo(no); 
    //    //  Collection<VolunteerBoardDTO> VolunteerBoardDTOList = VolunteerBoardDao.findAll();
    //
    //    VolunteerBoardDTO volunteerBoardDTO = volunteerBoardDao.findByNo(no);
    //
    //    String input = Prompt.inputString("[  공감이 되셨다면 좋아요를 눌러주세요(y/N)  ] ");
    //
    //    if (volunteerBoardDTO.getLikeMembers().contains(joinDTO)) {
    //      System.out.println("좋아요는 1번만 가능합니다."); 
    //      return;
    //    }
    //
    //    if (input.equalsIgnoreCase("n") || input.length() == 0) {
    //      System.out.println("[  좋아요 취소  ]");
    //      return;
    //
    //    } else if (input.equals("y")) {
    //      volunteerBoardDTO.setLike(volunteerBoardDTO.getLike() + 1);
    //      volunteerBoardDTO.addLikeMember(joinDTO);
    //
    //      System.out.println("[  LIKE 등록 완료  ]");
    //
    //      volunteerBoardDao.update(volunteerBoardDTO);
    //      sqlSession.commit();
    //
    //      return;
    //
    //    }
  } 
}

