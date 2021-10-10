package com.share.ftp.table.community;

import java.util.ArrayList;
import com.share.ftp.domain.community.CommReviewDTO;
import com.share.ftp.table.JsonDataTable;
import com.share.server.DataProcessor;
import com.share.server.Request;
import com.share.server.Response;

public class CommReviewTable extends JsonDataTable<CommReviewDTO> implements DataProcessor {

  public CommReviewTable() {
    super("commReview.json",CommReviewDTO.class);
  }

  @Override
  public void execute(Request request, Response response) throws Exception {
    switch (request.getCommand()) {
      case "commReview.insert": insert(request, response); break;
      case "commReview.selectList": selectList(request, response); break;
      case "commReview.selectListByKeyword": selectListByKeyword(request, response); break;
      case "commReview.selectOne": selectOne(request, response); break;
      case "commReview.update": update(request, response); break;
      case "commReview.delete": delete(request, response); break;
      case "commReview.getNextNum": getNextNum(request, response); break;
      default:
        response.setStatus(Response.FAIL);
        response.setValue("해당 명령을 지원하지 않습니다.");
    }
  }

  private void insert(Request request, Response response) throws Exception {
    CommReviewDTO commReviewDTO = request.getObject(CommReviewDTO.class);
    System.out.println(commReviewDTO);
    list.add(commReviewDTO);
    response.setStatus(Response.SUCCESS);
  }

  private void selectList(Request request, Response response) throws Exception {
    response.setStatus(Response.SUCCESS);
    response.setValue(list);
  }

  private void selectListByKeyword(Request request, Response response) throws Exception {
    String keyword = request.getParameter("keyword");

    ArrayList<CommReviewDTO> searchResult = new ArrayList<>();
    for (CommReviewDTO commReviewDTO : list) {
      if (!commReviewDTO.getContent().contains(keyword) &&
          !commReviewDTO.getOwner().getId().contains(keyword)){
        continue;
      }
      searchResult.add(commReviewDTO);
    }

    response.setStatus(Response.SUCCESS);
    response.setValue(searchResult);
  }

  private void selectOne(Request request, Response response) throws Exception {
    int commReviewNo = Integer.parseInt(request.getParameter("commReviewNo"));
    CommReviewDTO commReviewDTO = findByCommReviewNo(commReviewNo);

    if (commReviewDTO != null) {
      response.setStatus(Response.SUCCESS);
      response.setValue(commReviewDTO);
    } else {
      response.setStatus(Response.FAIL);
      response.setValue("해당 번호의 후기를 찾을 수 없습니다.");
    }
  }

  private void update(Request request, Response response) throws Exception {
    CommReviewDTO updateCommReview = request.getObject(CommReviewDTO.class);

    int index = indexOf(updateCommReview.getCommReviewNo());

    list.set(index, updateCommReview);
    response.setStatus(Response.SUCCESS);
  }

  private void delete(Request request, Response response) throws Exception {
    CommReviewDTO deleteCommReview = request.getObject(CommReviewDTO.class);

    //    int commReviewNo = Integer.parseInt(request.getParameter("commReviewNo"));
    //    int index = indexOf(commReviewNo);
    //
    //    if (index == -1) {
    //      response.setStatus(Response.FAIL);
    //      response.setValue("해당 번호의 후기를 찾을 수 없습니다.");
    //      return;
    //    }

    list.remove(deleteCommReview);
    response.setStatus(Response.SUCCESS);
  }

  private void getNextNum(Request request, Response response) throws Exception {
    CommReviewDTO commReviewDTO = new CommReviewDTO();

    commReviewDTO.setCommReviewNo(getLastNum());

    response.setStatus(Response.SUCCESS);
    response.setValue(commReviewDTO);
  }

  private int getLastNum() {
    if (list.size() > 0) {
      return list.get(list.size() - 1).getCommReviewNo() + 1;
    } else {
      return 1;
    }
  }
  private CommReviewDTO findByCommReviewNo(int commNo) {
    for (CommReviewDTO commReviewDTO : list) {
      if (commReviewDTO.getCommReviewNo() == commNo) {
        return commReviewDTO;
      }
    }
    return null;
  }

  private int indexOf(int commReviewNo) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getCommReviewNo() == commReviewNo) {
        return i;
      }
    }
    return -1;
  }

}
