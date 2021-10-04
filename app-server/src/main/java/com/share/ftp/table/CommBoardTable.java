package com.share.ftp.table;

import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.server.DataProcessor;
import com.share.server.Request;
import com.share.server.Response;

public class CommBoardTable extends JsonDataTable<JoinDTO> implements DataProcessor {



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
    list.add(commBoardDTO);
    response.setStatus(Response.SUCCESS);
  }

  private void selectList(Request request, Response response) throws Exception {
    response.setStatus(Response.SUCCESS);
    response.setValue(list);
  }

  private void selectListByKeyword(Request request, Response response) {
    // TODO Auto-generated method stub

  }

  private void selectOne(Request request, Response response) {
    // TODO Auto-generated method stub

  }

  private void update(Request request, Response response) {
    // TODO Auto-generated method stub

  }

  private void delete(Request request, Response response) throws Exception {
    CommBoardDTO commBoardDTO = request.getObject(CommBoardDTO.class);

    list.remove(commBoardDTO);
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
      return list.get(list.size() - 1).getNo() + 1;
    } else {
      return 1;
    }
  }

}
