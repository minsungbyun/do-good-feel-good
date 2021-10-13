package com.share.ftp.table.community;

import java.util.ArrayList;
import com.share.ftp.domain.community.CommBoardDTO;
import com.share.ftp.table.JsonDataTable;
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
      case "commBoard.like": like(request, response); break;
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
          !commBoardDTO.getContent().contains(keyword) &&
          !commBoardDTO.getOwner().getId().contains(keyword)){
        continue;
      }
      searchResult.add(commBoardDTO);
    }

    response.setStatus(Response.SUCCESS);
    response.setValue(searchResult);
  }

  private void selectOne(Request request, Response response) throws Exception {
    int commNo = Integer.parseInt(request.getParameter("commBoardNo"));
    CommBoardDTO commBoardDTO = findByCommBoardNo(commNo);

    if (commBoardDTO != null) {
      response.setStatus(Response.SUCCESS);
      response.setValue(commBoardDTO);
    } else {
      response.setStatus(Response.FAIL);
      response.setValue("해당 번호의 게시글을 찾을 수 없습니다.");
    }
  }

  private void update(Request request, Response response) throws Exception {
    CommBoardDTO updateCommBoard = request.getObject(CommBoardDTO.class);

    int index = indexOf(updateCommBoard.getNo());

    list.set(index, updateCommBoard);
    response.setStatus(Response.SUCCESS);
  }

  private void delete(Request request, Response response) throws Exception {
    CommBoardDTO deleteCommBoard = request.getObject(CommBoardDTO.class);

    //    int commNo = Integer.parseInt(request.getParameter("commNo"));
    //    int index = indexOf(commNo);
    //
    //    if (index == -1) {
    //      response.setStatus(Response.FAIL);
    //      response.setValue("해당 번호의 게시글을 찾을 수 없습니다.");
    //      return;
    //    }

    list.remove(deleteCommBoard);
    response.setStatus(Response.SUCCESS);
  }

  private void like(Request request, Response response) {
    CommBoardDTO likeCommBoard = request.getObject(CommBoardDTO.class);

    int index = indexOf(likeCommBoard.getNo());

    list.set(index, likeCommBoard);
    response.setStatus(Response.SUCCESS);
  }

  private void getNextNum(Request request, Response response) throws Exception {
    CommBoardDTO commBoardDTO = new CommBoardDTO();

    commBoardDTO.setNo(getLastNum());

    response.setStatus(Response.SUCCESS);
    response.setValue(commBoardDTO);
  }

  private int getLastNum() {
    if (list.size() > 0) {
      return list.get(list.size() - 1).getNo() + 1;
    } else {
      return 1;
    }
  }
  private CommBoardDTO findByCommBoardNo(int commBoardNo) {
    for (CommBoardDTO commBoardDTO : list) {
      if (commBoardDTO.getNo() == commBoardNo) {
        return commBoardDTO;
      }
    }
    return null;
  }

  private int indexOf(int commBoardNo) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == commBoardNo) {
        return i;
      }
    }
    return -1;
  }

}
