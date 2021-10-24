package com.share.ftp.handler.personal.community;

import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolunteerBoardDao;
import com.share.ftp.domain.community.VolunteerBoardDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class VolunteerBoardUpdateHandler implements Command {

  VolunteerBoardDao volunteerBoardDao;
  SqlSession sqlSession;

  public VolunteerBoardUpdateHandler (VolunteerBoardDao volunteerBoardDao, SqlSession sqlSession) {
    this.volunteerBoardDao =  volunteerBoardDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {


    System.out.println();
    System.out.println("[  나눔이야기 게시글변경  ]");
    int no = (int) request.getAttribute("no");

    VolunteerBoardDTO volunteerBoardDTO = volunteerBoardDao.findByNo(no);

    if (volunteerBoardDTO == null) {
      System.out.println("[  해당 게시글이 없습니다.  ]");
      return;
    }
    //    VolunteerBoardDTO update = new VolunteerBoardDTO();
    //
    //    update.setTitle(Prompt.inputString("제목(" + volunteerBoardDTO.getTitle() + ")? "));
    //    update.setContent(Prompt.inputString("내용(" + volunteerBoardDTO.getContent() + ")? "));
    //    update.setFileUpload(Prompt.inputString("첨부파일(" + volunteerBoardDTO.getFileUpload() + ")? "));

    String title = Prompt.inputString(String.format("제목(%s)? ", volunteerBoardDTO.getTitle()));
    String content = Prompt.inputString(String.format("내용(%s)? ", volunteerBoardDTO.getContent()));
    //    String fileUpload = Prompt.inputString(String.format("첨부파일(%s)? ", volunteerBoardDTO.getFileUpload()));

    String input = Prompt.inputString("[  정말 변경하시겠습니까?(y/N)  ]");

    if (input.equalsIgnoreCase("n")) {
      System.out.println("[  변경을 취소하였습니다.  ]");
      return;

    } else if(input.equals("y")) {
      volunteerBoardDTO.setTitle(title);
      volunteerBoardDTO.setContent(content);
      //            volunteerBoardDTO.setFileUpload(fileUpload);

      volunteerBoardDao.update(volunteerBoardDTO);
      sqlSession.commit();

      System.out.println();
      System.out.println("[  게시글을 변경하였습니다.  ]");
      // return;
    }

  }
}





