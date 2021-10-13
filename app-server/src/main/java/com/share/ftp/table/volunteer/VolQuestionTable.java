package com.share.ftp.table.volunteer;

import java.util.ArrayList;
import com.share.ftp.domain.volunteer.GeneralRequestDTO;
import com.share.ftp.domain.volunteer.VolQuestionDTO;
import com.share.ftp.table.JsonDataTable;
import com.share.server.DataProcessor;
import com.share.server.Request;
import com.share.server.Response;

public class VolQuestionTable extends JsonDataTable<VolQuestionDTO> implements DataProcessor {

  public VolQuestionTable() {
    super("volQuestion.json",VolQuestionDTO.class);
  }

  @Override
  public void execute(Request request, Response response) throws Exception {
    switch (request.getCommand()) {
      case "volQuestion.insert": insert(request, response); break;
      case "volQuestion.selectList": selectList(request, response); break;
      case "volQuestion.selectListKeyword": selectListKeyword(request, response); break;
      case "volQuestion.selectOne": selectOne(request, response); break;
      case "volQuestion.update": update(request, response); break;
      case "volQuestion.delete": delete(request, response); break;
      case "volQuestion.deleteIndex": deleteIndex(request, response); break;
      case "volQuestion.getNextNum": getNextQuestionNum(request, response); break;
    }
  }

  private void insert(Request request, Response response) throws Exception {
    VolQuestionDTO volQuestion = request.getObject(VolQuestionDTO.class);
    list.add(volQuestion);
    response.setStatus(Response.SUCCESS);
  }

  private void selectList(Request request, Response response) throws Exception {

    response.setStatus(Response.SUCCESS);
    response.setValue(list);
  }

  private void selectListKeyword(Request request, Response response) throws Exception {
    String keyword = request.getParameter("volQuestionKeyword");

    ArrayList<VolQuestionDTO> searchResult = new ArrayList<>();
    for (VolQuestionDTO volQuestion : list) {
      if (!volQuestion.getTitle().contains(keyword) &&
          !volQuestion.getContent().contains(keyword) &&
          !volQuestion.getOwner().getName().contains(keyword)) {
        continue;
      }
      searchResult.add(volQuestion);
    }

    response.setStatus(Response.SUCCESS);
    response.setValue(searchResult);
  }

  private void selectOne(Request request, Response response) throws Exception {
    int volNo = Integer.parseInt(request.getParameter("volNo"));
    int volQuestionNo = Integer.parseInt(request.getParameter("volQuestionNo"));


    VolQuestionDTO selectvol = null;
    for (VolQuestionDTO volQuestionDTO : list) {
      if (volQuestionDTO.getNo() == volNo) {
        if (volQuestionDTO.getQuestionNo() == volQuestionNo) {
          selectvol = volQuestionDTO;
        }
      }
    }

    if (selectvol == null) {
      response.setStatus(Response.FAIL);
      response.setValue("해당 봉사문의가 없습니다!");
      return;
    }

    response.setStatus(Response.SUCCESS);
    response.setValue(selectvol);
  }

  private void update(Request request, Response response) throws Exception {
    int volNo = Integer.parseInt(request.getParameter("volNo"));
    VolQuestionDTO updateVolQuestion = request.getObject(VolQuestionDTO.class);

    int index = indexOf(volNo, updateVolQuestion);

    list.set(index, updateVolQuestion);
    response.setStatus(Response.SUCCESS);
  }

  private void delete(Request request, Response response) throws Exception {
    VolQuestionDTO deleteVol = request.getObject(VolQuestionDTO.class);

    list.remove(deleteVol);
    response.setStatus(Response.SUCCESS);
  }

  private void deleteIndex(Request request, Response response) throws Exception {
    int volNo = Integer.parseInt(request.getParameter("volNo"));
    VolQuestionDTO deleteVolQuestion = request.getObject(VolQuestionDTO.class);


    int index = indexOf(volNo, deleteVolQuestion);

    list.remove(index);
    response.setStatus(Response.SUCCESS);
  }


  private void getNextQuestionNum(Request request, Response response) throws Exception {
    GeneralRequestDTO generalRequestDTO = request.getObject(GeneralRequestDTO.class);

    if (list.size() > 0) {
      generalRequestDTO.setQuestionCount(generalRequestDTO.getQuestionCount() + 1);
      response.setStatus(Response.SUCCESS);
      response.setValue(generalRequestDTO);
    } else {
      response.setStatus(Response.FAIL);
    }
  }

  //  private int getLastNum(volDTO volDTO) {
  //    if (list.size() > 0) {
  //      return volDTO.getQuestionCount() + 1;
  //    } else {
  //      return 1;
  //    }
  //  }

  private int indexOf(int volNo, VolQuestionDTO volQuestionDTO) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == volQuestionDTO.getNo()) {
        if (list.get(i).getQuestionNo() == volQuestionDTO.getQuestionNo()) {
          return i;
        }
      }
    }
    return -1;
  }

}
