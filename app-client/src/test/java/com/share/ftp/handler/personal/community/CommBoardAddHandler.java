package com.share.ftp.handler.personal.community;

import java.sql.Date;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolunteerBoardDao;
import com.share.ftp.domain.community.CommBoardDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class CommBoardAddHandler implements Command {

  VolunteerBoardDao volunteerBoardDao;
  SqlSession sqlSession;

  public CommBoardAddHandler(VolunteerBoardDao volunteerBoardDao, SqlSession sqlSession) {
    this.volunteerBoardDao =  volunteerBoardDao;
    this.sqlSession = sqlSession;

  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[  나눔이야기 등록  ]");

    CommBoardDTO commBoardDTO = new CommBoardDTO();

    commBoardDTO.setTitle(Prompt.inputString("제목 ▶ "));
    commBoardDTO.setContent(Prompt.inputString("내용 ▶ "));
    commBoardDTO.setFileUpload(Prompt.inputString("첨부파일 ▶ "));
    commBoardDTO.setRegisteredDate(new Date(System.currentTimeMillis()));
    commBoardDTO.setOwner(AuthLoginHandler.getLoginUser());


    volunteerBoardDao.insert(commBoardDTO);
    sqlSession.commit();

    System.out.println();
    System.out.println("[  게시글 등록이 완료되었습니다.  ]");
  }


}