package com.share.ftp.handler.personal.community;

import java.util.Collection;
import com.share.ftp.dao.VolunteerBoardCommentDao;
import com.share.ftp.dao.VolunteerBoardDao;
import com.share.ftp.domain.community.VolunteerBoardCommentDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class VolunteerBoardCommentListHandler implements Command {

  VolunteerBoardDao volunteerBoardDao;
  VolunteerBoardCommentDao volunteerBoardCommentDao;

  public VolunteerBoardCommentListHandler (
      VolunteerBoardDao volunteerBoardDao,
      VolunteerBoardCommentDao volunteerBoardCommentDao) {
    this.volunteerBoardDao=volunteerBoardDao;
    this.volunteerBoardCommentDao = volunteerBoardCommentDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    while (true) {
      int volBoardNo = (int)request.getAttribute("volBoardNo");

      System.out.println("[  나눔이야기 댓글 목록  ]");

      Collection<VolunteerBoardCommentDTO> List = volunteerBoardCommentDao.findAll();
      for(VolunteerBoardCommentDTO volunteerBoardCommentDTO: List) {
        if (volunteerBoardCommentDTO.getVolBoardNo() == volBoardNo) {
          System.out.printf("%d, %d, %s, %s, %s\n", 
              volunteerBoardCommentDTO.getVolBoardNo(),
              volunteerBoardCommentDTO.getNo(), 
              volunteerBoardCommentDTO.getOwner().getId(),
              volunteerBoardCommentDTO.getCommentContent(),
              volunteerBoardCommentDTO.getRegisteredDate());
        }
      }
      System.out.println();
      System.out.println("1번 ▶ 댓글 등록");
      System.out.println("2번 ▶ 댓글 변경");
      System.out.println("3번 ▶ 댓글 삭제");
      System.out.println("0번 ▶ 이전");
      int input = Prompt.inputInt("번호 입력 ▶ ");
      switch (input) {

        case 1: request.getRequestDispatcher("/volunteerBoardComment/add").forward(request); return;
        case 2: request.getRequestDispatcher("/volunteerBoardComment/update").forward(request); return;
        case 3: request.getRequestDispatcher("/volunteerBoardComment/delete").forward(request); return;
        case 0: return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");
      }

    } 
  } 
}
