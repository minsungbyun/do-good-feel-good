package com.share.ftp.handler.admin;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.admin.NoticeDTO;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class AdminNoticeAddHandler extends AbstractAdminNoticeHandler {

  int boardNo;

  public AdminNoticeAddHandler(List<NoticeDTO> noticeDTOList) {
    super(noticeDTOList);
  }

  public void execute() {
    System.out.println("[공지사항 등록]");

    NoticeDTO noticeDTO = new NoticeDTO();

    noticeDTO.setAdmin(AuthLoginHandler.getLoginUser());
    noticeDTO.setTitle(Prompt.inputString("제목? "));
    noticeDTO.setContent(Prompt.inputString("내용? ")); 
    noticeDTO.setFileUpload(Prompt.inputString("첨부파일? ")); 
    noticeDTO.setRegisteredDate(new Date(System.currentTimeMillis()));
    noticeDTO.setBoardNo(++boardNo);


    noticeDTOList.add(noticeDTO);

  }



}
