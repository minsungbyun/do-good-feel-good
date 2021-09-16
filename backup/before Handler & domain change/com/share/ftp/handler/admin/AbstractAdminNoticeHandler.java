package com.share.ftp.handler.admin;

import java.util.List;
import com.share.ftp.domain.admin.NoticeDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractAdminNoticeHandler implements Command {

  protected List<NoticeDTO> noticeDTOList;
  public AbstractAdminNoticeHandler(List<NoticeDTO> noticeDTOList) {
    this.noticeDTOList = noticeDTOList;
  }

  protected NoticeDTO findByNo(int no) {
    for (NoticeDTO noticeDTO : noticeDTOList) {
      if (noticeDTO.getNo() == no) {
        return noticeDTO;
      }
    }
    return null;
  }



  //  if (this.size == this.noticesDTO.length) {
  //    NoticeDTO[] arr = new NoticeDTO[this.noticesDTO.length + (this.noticesDTO.length >> 1)];
  //    for (int i = 0; i < this.size; i++) {
  //      arr[i] = this.noticesDTO[i];
  //    }
  //    this.noticesDTO = arr;
  //  }
  //  this.noticesDTO[this.size++] = noticeDTO;

}
