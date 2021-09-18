package com.share.ftp.handler.personal.support;

import java.util.List;
import com.share.ftp.domain.admin.NoticeDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractNoticeHandler implements Command {

  protected List<NoticeDTO> noticeDTOList;

  public AbstractNoticeHandler(List<NoticeDTO> noticeDTOList) {
    this.noticeDTOList = noticeDTOList;
  }

  protected NoticeDTO findByNo(int boardNo) {
    for (NoticeDTO noticeDTO : noticeDTOList) {
      if (noticeDTO.getBoardNo() == boardNo) {
        return noticeDTO;
      }
    }
    return null;
  }

}








