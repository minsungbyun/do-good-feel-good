package com.share.ftp.handler.admin;

import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.GeneralDao;
import com.share.ftp.dao.NoticeDao;
import com.share.ftp.domain.admin.NoticeAttachedFile;
import com.share.ftp.domain.admin.NoticeDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class AdminNoticeDeleteHandler implements Command {

  NoticeDao noticeDao;
  GeneralDao generalDao;
  SqlSession sqlSession;

  public AdminNoticeDeleteHandler(NoticeDao noticeDao, GeneralDao generalDao, SqlSession sqlSession) {
    this.noticeDao = noticeDao;
    this.generalDao = generalDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ 공지사항 - 삭제 ]");

    int noticeNo = (int) request.getAttribute("noticeNo"); 

    NoticeDTO noticeDTO = noticeDao.findByNo(noticeNo);

    if (noticeDTO == null) {
      System.out.println("해당 번호의 게시물이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    System.out.println();
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시물 삭제를 취소하였습니다.");
      return;
    }

    try {
      for (NoticeAttachedFile noticeAttachedFile : noticeDTO.getFileUpload()) {
        noticeDao.deleteFile(noticeDTO.getNo());
      }
      noticeDao.delete(noticeNo);
      sqlSession.commit();
    } catch (Exception e) {
      // 예외가 발생하기 전에 성공한 작업이 있으면 모두 취소한다.
      // 그래야 다음 작업에 영향을 끼치지 않는다.
      sqlSession.rollback();
    }

    System.out.println("게시물을 삭제하였습니다.");
  }


}
