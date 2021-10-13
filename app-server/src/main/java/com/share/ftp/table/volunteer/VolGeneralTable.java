package com.share.ftp.table.volunteer;

import com.share.ftp.domain.volunteer.GeneralRequestDTO;
import com.share.ftp.table.JsonDataTable;
import com.share.server.DataProcessor;
import com.share.server.Request;
import com.share.server.Response;

public class VolGeneralTable extends JsonDataTable<GeneralRequestDTO> implements DataProcessor {

  public VolGeneralTable() {
    super("generalRequestDTO.json",GeneralRequestDTO.class);
  }

  @Override
  public void execute(Request request, Response response) throws Exception {
    switch (request.getCommand()) {
      case "vol.insert": insert(request, response); break;
      case "vol.selectList": selectList(request, response); break;
      case "vol.selectOne": selectOne(request, response); break;
      case "vol.selectApplyOne": selectApplyOne(request, response); break;
      case "vol.update": update(request, response); break;
      case "vol.delete": delete(request, response); break;
      case "vol.getNextNum": getNextNum(request, response); break;
    }
  }

  private void insert(Request request, Response response) throws Exception {
    GeneralRequestDTO volRequest = request.getObject(GeneralRequestDTO.class);
    list.add(volRequest);
    response.setStatus(Response.SUCCESS);
  }

  private void selectList(Request request, Response response) throws Exception {
    response.setStatus(Response.SUCCESS);
    response.setValue(list);
  }


  private void selectOne(Request request, Response response) throws Exception {
    int volNo = Integer.parseInt(request.getParameter("volNo"));

    GeneralRequestDTO generalRequestDTO = null;
    for (GeneralRequestDTO volRequestList : list) {
      if (volRequestList.getNo() == volNo) {
        generalRequestDTO = volRequestList; 
      }
    }

    if (generalRequestDTO == null) {
      response.setStatus(Response.FAIL);
      response.setValue("해당 챌린지가 없습니다!");
      return;
    }

    response.setStatus(Response.SUCCESS);
    response.setValue(generalRequestDTO);
  }

  private void selectApplyOne(Request request, Response response) throws Exception {
    int volApplyNo = Integer.parseInt(request.getParameter("volApplyNo"));

    GeneralRequestDTO generalRequestDTO = null;
    for (GeneralRequestDTO volRequestList : list) {
      //      if (volRequestList.getStatus().)
      if (volRequestList.getNo() == volApplyNo) {
        generalRequestDTO = volRequestList; 
      }
    }

    if (generalRequestDTO == null) {
      response.setStatus(Response.FAIL);
      response.setValue("해당 챌린지가 없습니다!");
      return;
    }

    response.setStatus(Response.SUCCESS);
    response.setValue(generalRequestDTO);
  }

  private void update(Request request, Response response) throws Exception {
    GeneralRequestDTO updateVolRequest = request.getObject(GeneralRequestDTO.class);

    int index = indexOf(updateVolRequest.getNo());

    list.set(index, updateVolRequest);
    response.setStatus(Response.SUCCESS);
  }

  private void delete(Request request, Response response) throws Exception {
    GeneralRequestDTO deleteVolRequest = request.getObject(GeneralRequestDTO.class);

    list.remove(deleteVolRequest);
    response.setStatus(Response.SUCCESS);
  }


  private void getNextNum(Request request, Response response) throws Exception {
    GeneralRequestDTO volRequest = new GeneralRequestDTO();

    volRequest.setNo(getLastNum());

    response.setStatus(Response.SUCCESS);
    response.setValue(volRequest);
  }

  private int getLastNum() {
    if (list.size() > 0) {
      return list.get(list.size() - 1).getNo() + 1;
    } else {
      return 1;
    }
  }

  private int indexOf(int no) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }

}
