package com.share.ftp.handler.personal.community;

import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolBoardDao;
import com.share.ftp.domain.community.CommBoardDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class CommBoardUpdateHandler implements Command {

  VolBoardDao volBoardDao;
  SqlSession sqlSession;

  public CommBoardUpdateHandler (VolBoardDao volBoardDao, SqlSession sqlSession) {
    this.volBoardDao =  volBoardDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {


    System.out.println();
    System.out.println("[  나눔이야기 게시글변경  ]");
    int commBoardNo = (int) request.getAttribute("commBoardNo");

    CommBoardDTO commBoardDTO = volBoardDao.findByCommBoardNo(commBoardNo);

    if (commBoardDTO == null) {
      System.out.println("[  해당 게시글이 없습니다.  ]");
      return;
    }
    //    CommBoardDTO updateCommBoard = new CommBoardDTO();
    //
    //    updateCommBoard.setTitle(Prompt.inputString("제목(" + commBoardDTO.getTitle() + ")? "));
    //    updateCommBoard.setContent(Prompt.inputString("내용(" + commBoardDTO.getContent() + ")? "));
    //    updateCommBoard.setFileUpload(Prompt.inputString("첨부파일(" + commBoardDTO.getFileUpload() + ")? "));

    String title = Prompt.inputString(String.format("제목(%s)? ", commBoardDTO.getTitle()));
    String content = Prompt.inputString(String.format("내용(%s)? ", commBoardDTO.getContent()));
    //    String fileUpload = Prompt.inputString(String.format("첨부파일(%s)? ", commBoardDTO.getFileUpload()));

    String input = Prompt.inputString("[  정말 변경하시겠습니까?(y/N)  ]");

    if (input.equalsIgnoreCase("n")) {
      System.out.println("[  변경을 취소하였습니다.  ]");
      return;

    } else if(input.equals("y")) {
      commBoardDTO.setTitle(title);
      commBoardDTO.setContent(content);
      //      commBoardDTO.setFileUpload(fileUpload);

      volBoardDao.update(commBoardDTO);
      sqlSession.commit();

      System.out.println();
      System.out.println("[  게시글을 변경하였습니다.  ]");
      // return;
    }

  }
}





