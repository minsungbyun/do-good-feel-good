package com.share.ftp.table.community;


import com.share.ftp.domain.community.CommBoardReplyDTO;
import com.share.ftp.table.JsonDataTable;
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
      case "commBoardReply.insert": insertReply(request, response); break;
      case "commBoardReply.selectList": selectReplyList(request, response); break;
      case "commBoardReply.selectOne": selectOne(request, response); break;
      case "commBoardReply.update": updateReply(request, response); break;
      case "commBoardReply.delete": deleteReply(request, response); break;
      //      case "commBoardReply.getNextNum": getNextNum(request, response); break;
      default:
        response.setStatus(Response.FAIL);
        response.setValue("해당 명령을 지원하지 않습니다.");
    }
  }

  private void insertReply(Request request, Response response) throws Exception {
    CommBoardReplyDTO commBoardReplyDTO = request.getObject(CommBoardReplyDTO.class);
    System.out.println(commBoardReplyDTO);
    list.add(commBoardReplyDTO);
    response.setStatus(Response.SUCCESS);
  }


  private void selectReplyList(Request request, Response response) throws Exception {
    response.setStatus(Response.SUCCESS);
    response.setValue(list);
  }

  private void selectOne(Request request, Response response) throws Exception {
    int commBoardNo = Integer.parseInt(request.getParameter("commBoardNo"));
    int commBoardReplyNo = Integer.parseInt(request.getParameter("commBoardReplyNo"));

    CommBoardReplyDTO commBoardReplyDTO = null;

    commBoardReplyDTO = findByCommBoardReplyNo(commBoardNo, commBoardReplyNo);

    if (commBoardReplyDTO == null) {
      response.setStatus(Response.FAIL);
      response.setValue("해당 챌린지가 없습니다!");
      return;
    }

    response.setStatus(Response.SUCCESS);
    response.setValue(commBoardReplyDTO);
  }


  //    CommBoardReplyDTO commBoardReplyDTO = findByCommReplyNo(commBoardReplyNo);
  //
  //    if (commBoardReplyDTO != null) {
  //      response.setStatus(Response.SUCCESS);
  //      response.setValue(commBoardReplyDTO);
  //    } else {
  //      response.setStatus(Response.FAIL);
  //      response.setValue("해당 번호의 게시글을 찾을 수 없습니다.");
  //    }
  //  }

  private void updateReply(Request request, Response response) throws Exception {
    CommBoardReplyDTO updateCommBoardReply = request.getObject(CommBoardReplyDTO.class);

    int index = indexOf(updateCommBoardReply.getCommNo(), updateCommBoardReply.getCommReplyNo());

    list.set(index, updateCommBoardReply);
    response.setStatus(Response.SUCCESS);
  }

  private void deleteReply(Request request, Response response) throws Exception {
    CommBoardReplyDTO deleteCommBoardReply = request.getObject(CommBoardReplyDTO.class);

    list.remove(deleteCommBoardReply);
    response.setStatus(Response.SUCCESS);
  }


  private CommBoardReplyDTO findByCommBoardReplyNo(int commBoardNo, int commBoardReplyNo) {
    for (CommBoardReplyDTO commBoardReplyDTO : list) {
      if (commBoardReplyDTO.getCommNo() == commBoardNo) {
        if (commBoardReplyDTO.getCommReplyNo() == commBoardReplyNo) {
          return commBoardReplyDTO;
        }
      }
    }
    return null;
  }

  private int indexOf(int commBoardNo, int commBoardReplyNo) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getCommReplyNo() == commBoardNo) {
        if (list.get(i).getCommReplyNo() == commBoardReplyNo) {
          return i;
        }
      }
    }
    return -1;
  }
}

//private void getNextNum(Request request, Response response) throws Exception {
//  CommBoardReplyDTO commBoardReplyDTO = new CommBoardReplyDTO();
//  
//  commBoardReplyDTO.setCommReplyNo(getLastNum());
//  
//  response.setStatus(Response.SUCCESS);
//  response.setValue(commBoardReplyDTO);
//}
//
//private int getLastNum() {
//  if (list.size() > 0) {
//    return list.get(list.size() - 1).getCommReplyNo() + 1;
//  } else {
//    return 1;
//  }
//}