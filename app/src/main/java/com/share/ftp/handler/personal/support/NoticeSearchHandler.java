//package com.share.ftp.handler.personal.support;
//
//import java.util.List;
//import com.share.ftp.domain.admin.NoticeDTO;
//import com.share.util.Prompt;
//
//public class NoticeSearchHandler extends AbstractNoticeHandler {
//
//  public NoticeSearchHandler(List<NoticeDTO> noticeDTOList) {
//    super(noticeDTOList);
//  }
//
//  @Override
//  public void execute() {
//    System.out.println("[고객센터/공지사항/공지사항 검색]");
//
//    String input = Prompt.inputString("검색어? ");
//
//    for (NoticeDTO noticeDTO : noticeDTOList) {
//      if (!noticeDTO.getTitle().contains(input) &&
//          !noticeDTO.getContent().contains(input) &&
//          !noticeDTO.getWriter().contains(input)) {
//        continue;
//      }
//      System.out.printf("%d %s, %s, %s, %d\n", 
//          noticeDTO.getNo(), 
//          noticeDTO.getTitle(), 
//          noticeDTO.getWriter(),
//          noticeDTO.getRegisteredDate(),
//          noticeDTO.getViewCount());
//    }
//  }
//}







