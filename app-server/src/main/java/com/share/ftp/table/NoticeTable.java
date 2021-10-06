package com.share.ftp.table;

import java.util.ArrayList;
import com.share.ftp.domain.admin.NoticeDTO;
import com.share.ftp.domain.personal.QuestionListDTO;
import com.share.server.DataProcessor;
import com.share.server.Request;
import com.share.server.Response;

// 게시글 데이터를 처리하는 일을 한다.
public class NoticeTable extends JsonDataTable<NoticeDTO> implements DataProcessor {

  public NoticeTable() {
    super("notice.json", NoticeDTO.class);
  }

  @Override
  public void execute(Request request, Response response) throws Exception {
    switch (request.getCommand() ) {
      case "notice.insert": insert(request, response); break;
      case "notice.selectList": selectList(request, response); break;
      case "notice.selectListByKeyword": selectListByKeyword(request, response); break;
      case "notice.selectOne": selectOne(request, response); break;
      case "notice.update": update(request, response); break;
      case "notice.delete": delete(request, response); break;
      case "notice.getNextNum": getNextNum(request, response); break;
      default:
        response.setStatus(Response.FAIL);
        response.setValue("해당 명령을 지원하지 않습니다.");
    }
  }

  private void insert(Request request, Response response) throws Exception {
    NoticeDTO notice = request.getObject(NoticeDTO.class);
    System.out.println(notice);
    list.add(notice);
    response.setStatus(Response.SUCCESS);
  }

  private void selectList(Request request, Response response) throws Exception {
    response.setStatus(Response.SUCCESS);
    response.setValue(list);
  }

  private void selectListByKeyword(Request request, Response response) throws Exception {
    String keyword = request.getParameter("keyword");

    ArrayList<NoticeDTO> searchResult = new ArrayList<>();
    for (NoticeDTO noticeList : list) {
      if (!noticeList.getTitle().contains(keyword) &&
          !noticeList.getContent().contains(keyword) &&
          !noticeList.getOwner().getId().contains(keyword)) {
        continue;
      }
      searchResult.add(noticeList);
    }

    response.setStatus(Response.SUCCESS);
    response.setValue(searchResult);
  }

  private void selectOne(Request request, Response response) throws Exception {
    int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
    NoticeDTO noticeDTO = findByNo(noticeNo);

    if (noticeDTO != null) {
      response.setStatus(Response.SUCCESS);
      response.setValue(noticeDTO);
    } else {
      response.setStatus(Response.FAIL);
      response.setValue("해당 번호의 게시글을 찾을 수 없습니다.");
    }
  }

  private void update(Request request, Response response) throws Exception {
    NoticeDTO updateNotice = request.getObject(NoticeDTO.class);

    int index = indexOf(updateNotice.getNo());
    if (index == -1) {
      response.setStatus(Response.FAIL);
      response.setValue("해당 번호의 게시글을 찾을 수 없습니다.");
      return;
    }

    list.set(index, updateNotice);
    response.setStatus(Response.SUCCESS);
  }

  private void delete(Request request, Response response) throws Exception {
    NoticeDTO deleteNotice = request.getObject(NoticeDTO.class);

    int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
    int index = indexOf(noticeNo);

    if (index == -1) {
      response.setStatus(Response.FAIL);
      response.setValue("해당 번호의 게시글을 찾을 수 없습니다.");
      return;
    }

    list.remove(deleteNotice);
    response.setStatus(Response.SUCCESS);
  }

  private void getNextNum(Request request, Response response) throws Exception {
    QuestionListDTO question = new QuestionListDTO();

    question.setNo(getLastNum());

    response.setStatus(Response.SUCCESS);
    response.setValue(question);
  }

  private int getLastNum() {
    if (list.size() > 0) {
      return list.get(list.size() - 1).getNo() + 1;
    } else {
      return 1;
    }
  }

  private NoticeDTO findByNo(int noticeNo) {
    for (NoticeDTO noticeDTO : list) {
      if (noticeDTO.getNo() == noticeNo) {
        return noticeDTO;
      }
    }
    return null;
  }

  private int indexOf(int noticeNo) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == noticeNo) {
        return i;
      }
    }
    return -1;
  }
}