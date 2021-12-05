package com.share.ftp.handler.admin;

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

  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ 공지사항 - 등록 ]");

    NoticeDTO noticeDTO = new NoticeDTO();

    noticeDTO.setAdmin(AuthLoginHandler.getLoginUser());
    noticeDTO.setTitle(Prompt.inputString("제목: "));
    noticeDTO.setContent(Prompt.inputString("내용: ")); 
    noticeDTO.setFileUpload(Prompt.inputString("첨부파일: ")); 

    // 고유회원번호 부여

    noticeDao.insert(noticeDTO);

    System.out.println();
    System.out.println("게시글 등록이 완료 되었습니다.");

  }



}
