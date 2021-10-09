package com.share.ftp.table;

import com.share.ftp.domain.personal.CommBoardReplyDTO;
import com.share.server.DataProcessor;
import com.share.server.Request;
import com.share.server.Response;

public class CommBoardReplyTable extends JsonDataTable<CommBoardReplyDTO> implements DataProcessor {

  public CommBoardReplyTable() {
    super("commBoardReply.json",CommBoardReplyDTO.class);
  }

  @Override
  public void execute(Request request, Response response) throws Exception {
    switch (request.getCommand()) {
      case "commReply.insert": insert(request, response); break;
      case "commReply.selectList": selectList(request, response); break;
      case "commReply.selectOne": selectOne(request, response); break;
      case "commReply.update": update(request, response); break;
      case "commReply.delete": delete(request, response); break;
      case "commReply.getNextNum": getNextNum(request, response); break;
      default:
        response.setStatus(Response.FAIL);
        response.setValue("해당 명령을 지원하지 않습니다.");
    }
  }

  private void insert(Request request, Response response) throws Exception {
    CommBoardReplyDTO commBoardReplyDTO = request.getObject(CommBoardReplyDTO.class);
    System.out.println(commBoardReplyDTO);
    list.add(commBoardReplyDTO);
    response.setStatus(Response.SUCCESS);
  }

  private void selectList(Request request, Response response) throws Exception {
    response.setStatus(Response.SUCCESS);
    response.setValue(list);
  }

  private void selectOne(Request request, Response response) throws Exception {
    int commBoardReplyNo = Integer.parseInt(request.getParameter("commBoardReplyNo"));
    CommBoardReplyDTO commBoardReplyDTO = findByCommReplyNo(commBoardReplyNo);

    if (commBoardReplyDTO != null) {
      response.setStatus(Response.SUCCESS);
      response.setValue(commBoardReplyDTO);
    } else {
      response.setStatus(Response.FAIL);
      response.setValue("해당 번호의 게시글을 찾을 수 없습니다.");
    }
  }

  private void update(Request request, Response response) throws Exception {
    CommBoardReplyDTO updateCommBoardReply = request.getObject(CommBoardReplyDTO.class);

    int index = indexOf(updateCommBoardReply.getCommReplyNo());

    list.set(index, updateCommBoardReply);
    response.setStatus(Response.SUCCESS);
  }

  private void delete(Request request, Response response) throws Exception {
    CommBoardReplyDTO deleteCommBoardReply = request.getObject(CommBoardReplyDTO.class);

    list.remove(deleteCommBoardReply);
    response.setStatus(Response.SUCCESS);
  }


  private void getNextNum(Request request, Response response) throws Exception {
    CommBoardReplyDTO commBoardReplyDTO = new CommBoardReplyDTO();

    commBoardReplyDTO.setCommReplyNo(getLastNum());

    response.setStatus(Response.SUCCESS);
    response.setValue(commBoardReplyDTO);
  }

  private int getLastNum() {
    if (list.size() > 0) {
      return list.get(list.size() - 1).getCommReplyNo() + 1;
    } else {
      return 1;
    }
  }
  private CommBoardReplyDTO findByCommReplyNo(int commReplyNo) {
    for (CommBoardReplyDTO commBoardReplyDTO : list) {
      if (commBoardReplyDTO.getCommReplyNo() == commReplyNo) {
        return commBoardReplyDTO;
      }
    }
    return null;
  }

  private int indexOf(int commReplyNo) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getCommReplyNo() == commReplyNo) {
        return i;
      }
    }
    return -1;
  }

}
