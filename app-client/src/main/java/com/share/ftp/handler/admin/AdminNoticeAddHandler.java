package com.share.ftp.handler.admin;

import java.sql.Date;
import com.share.ftp.dao.NoticeDao;
import com.share.ftp.domain.admin.NoticeDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class AdminNoticeAddHandler implements Command {

  NoticeDao noticeDao;

  public AdminNoticeAddHandler(NoticeDao noticeDao) {
    this.noticeDao = noticeDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ 공지사항 - 등록 ]");
    System.out.println();

    NoticeDTO noticeDTO = new NoticeDTO();

    noticeDTO.setAdmin(AuthLoginHandler.getLoginUser());
    noticeDTO.setTitle(Prompt.inputString("제목? "));
    noticeDTO.setContent(Prompt.inputString("내용? ")); 
    noticeDTO.setFileUpload(Prompt.inputString("첨부파일? ")); 
    noticeDTO.setRegisteredDate(new Date(System.currentTimeMillis()));

    // 고유회원번호 부여
    noticeDTO.setNo(noticeDao.getNextNum());

    noticeDao.insert(noticeDTO);

    System.out.println();
    System.out.println("공지사항 등록이 완료되었습니다.");

  }



}
