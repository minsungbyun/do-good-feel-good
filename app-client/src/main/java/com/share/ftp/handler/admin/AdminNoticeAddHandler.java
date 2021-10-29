package com.share.ftp.handler.admin;

import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.GeneralDao;
import com.share.ftp.dao.NoticeDao;
import com.share.ftp.domain.admin.NoticeAttachedFile;
import com.share.ftp.domain.admin.NoticeDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.GeneralHelper;
import com.share.util.Prompt;

public class AdminNoticeAddHandler implements Command {

  NoticeDao noticeDao;
  GeneralDao generalDao;
  SqlSession sqlSession;

  public AdminNoticeAddHandler(NoticeDao noticeDao, GeneralDao generalDao, SqlSession sqlSession) {
    this.noticeDao = noticeDao;
    this.sqlSession = sqlSession;
    this.generalDao = generalDao;
  }

  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ 공지사항 - 등록 ]");

    NoticeDTO noticeDTO = new NoticeDTO();

    noticeDTO.setTitle(Prompt.inputString("제목: "));
    noticeDTO.setContent(Prompt.inputString("내용: ")); 
    noticeDTO.setFileUpload(GeneralHelper.promptNoticeFileUpload());

    try {
      noticeDao.insert(noticeDTO);
      for (NoticeAttachedFile noticeAttachedFile : noticeDTO.getFileUpload()) {
        noticeDao.insertFile(noticeDTO.getNo(), noticeAttachedFile.getFilepath());
      }
      sqlSession.commit();

    } catch (Exception e) {
      e.printStackTrace(); 
      sqlSession.rollback();
    }

    System.out.println();
    System.out.println("게시글 등록이 완료 되었습니다.");

  }
}
