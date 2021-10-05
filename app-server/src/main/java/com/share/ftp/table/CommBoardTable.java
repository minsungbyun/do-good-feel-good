package com.share.ftp.table;

import java.util.ArrayList;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.server.DataProcessor;
import com.share.server.Request;
import com.share.server.Response;

public class CommBoardTable extends JsonDataTable<CommBoardDTO> implements DataProcessor {

  public CommBoardTable() {
    super("commBoard.json",CommBoardDTO.class);
  }

  @Override
  public void execute(Request request, Response response) throws Exception {
    switch (request.getCommand()) {
      case "commBoard.insert": insert(request, response); break;
      case "commBoard.selectList": selectList(request, response); break;
      case "commBoard.selectListByKeyword": selectListByKeyword(request, response); break;
      case "commBoard.selectOne": selectOne(request, response); break;
      case "commBoard.update": update(request, response); break;
      case "commBoard.delete": delete(request, response); break;
      case "commBoard.getNextNum": getNextNum(request, response); break;
      default:
        response.setStatus(Response.FAIL);
        response.setValue("해당 명령을 지원하지 않습니다.");
    }
  }

  private void insert(Request request, Response response) throws Exception {
    CommBoardDTO commBoardDTO = request.getObject(CommBoardDTO.class);
    System.out.println(commBoardDTO);
    list.add(commBoardDTO);
    response.setStatus(Response.SUCCESS);
  }

  private void selectList(Request request, Response response) throws Exception {
    response.setStatus(Response.SUCCESS);
    response.setValue(list);
  }

  private void selectListByKeyword(Request request, Response response) throws Exception {
    String keyword = request.getParameter("keyword");

    ArrayList<CommBoardDTO> searchResult = new ArrayList<>();
    for (CommBoardDTO commBoardDTO : list) {
      if (!commBoardDTO.getTitle().contains(keyword) &&
          !commBoardDTO.getContent().contains(keyword)) {
        continue;
      }
      searchResult.add(commBoardDTO);
    }

    response.setStatus(Response.SUCCESS);
    response.setValue(searchResult);
  }


  private void selectOne(Request request, Response response) throws Exception {
    int commNo = Integer.parseInt(request.getParameter("commNo"));
    CommBoardDTO commBoardDTO = findByCommNo(commNo);

    if (commBoardDTO != null) {
      response.setStatus(Response.SUCCESS);
      response.setValue(commBoardDTO);
    } else {
      response.setStatus(Response.FAIL);
      response.setValue("해당 번호의 게시글을 찾을 수 없습니다.");
    }
  }

  private void update(Request request, Response response) {
    // TODO Auto-generated method stub

  }

  private void delete(Request request, Response response) throws Exception {
    int no = Integer.parseInt(request.getParameter("commNo"));
    int index = indexOf(no);

    if (index == -1) {
      response.setStatus(Response.FAIL);
      response.setValue("해당 번호의 게시글을 찾을 수 없습니다.");
      return;
    }

    list.remove(index);
    response.setStatus(Response.SUCCESS);
  }

  private void getNextNum(Request request, Response response) throws Exception {
    CommBoardDTO commBoardDTO = new CommBoardDTO();

    commBoardDTO.setCommNo(getLastNum());

    response.setStatus(Response.SUCCESS);
    response.setValue(commBoardDTO);
  }

  private int getLastNum() {
    if (list.size() > 0) {
      return list.get(list.size() - 1).getCommNo() + 1;
    } else {
      return 1;
    }
  }
  private CommBoardDTO findByCommNo(int no) {
    for (CommBoardDTO commBoardDTO : list) {
      if (commBoardDTO.getCommNo() == no) {
        return commBoardDTO;
      }
    }
    return null;
  }

  private int indexOf(int commBoardNo) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getCommNo() == commBoardNo) {
        return i;
      }
    }
    return -1;
  }

}
