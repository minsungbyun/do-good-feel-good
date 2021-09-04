package com.share.ftp.handler.personal.support;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.admin.NoticeDTO;
import com.share.util.Prompt;

public class NoticeAddHandler extends AbstractNoticeHandler {

  public NoticeAddHandler(List<NoticeDTO> noticeDTOList) {
    super (noticeDTOList);
  }

  public void execute() {
    System.out.println();
    System.out.println("[고객센터/공지사항/공지사항 등록]");

    NoticeDTO noticeDTO = new NoticeDTO();

    noticeDTO.setNo(Prompt.inputInt("번호? "));
    noticeDTO.setTitle(Prompt.inputString("제목? "));
    noticeDTO.setContent(Prompt.inputString("내용? "));
    noticeDTO.setFileUpload(Prompt.inputString("파일첨부? "));
    noticeDTO.setRegisteredDate(new Date(System.currentTimeMillis()));

    noticeDTOList.add(noticeDTO);
  }

}