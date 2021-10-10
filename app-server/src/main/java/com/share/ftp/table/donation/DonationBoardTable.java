package com.share.ftp.table.donation;

import java.util.ArrayList;
import com.share.ftp.domain.donation.DonationBoardDTO;
import com.share.ftp.table.JsonDataTable;
import com.share.server.DataProcessor;
import com.share.server.Request;
import com.share.server.Response;

// 역할
// - 프로젝트 데이터를 처리하는 일을 한다.
// 
public class DonationBoardTable extends JsonDataTable<DonationBoardDTO> implements DataProcessor {

  public DonationBoardTable() {
    super("donationBoard.json", DonationBoardDTO.class);
  }

  @Override
  public void execute(Request request, Response response) throws Exception {
    switch (request.getCommand()) {
      case "donationBoard.insert": insert(request, response); break;
      case "donationBoard.selectList": selectList(request, response); break;
      case "donationBoard.selectListByKeyword": selectListByKeyword(request, response); break;
      case "donationBoard.selectOne": selectOne(request, response); break;
      case "donationBoard.update": update(request, response); break;
      case "donationBoard.delete": delete(request, response); break;
      case "donationBoard.getNextNum": getNextNum(request, response); break;
      default:
        response.setStatus(Response.FAIL);
        response.setValue("해당 명령을 지원하지 않습니다.");
    }
  }

  private void insert(Request request, Response response) throws Exception {
    DonationBoardDTO donationBoardDTO = request.getObject(DonationBoardDTO.class);
    list.add(donationBoardDTO);
    response.setStatus(Response.SUCCESS);
  }

  private void selectList(Request request, Response response) throws Exception {
    response.setStatus(Response.SUCCESS);
    response.setValue(list);
  }

  private void selectListByKeyword(Request request, Response response) throws Exception {
    String keyword = request.getParameter("donationBoardKeyword");

    ArrayList<DonationBoardDTO> searchResult = new ArrayList<>();
    for (DonationBoardDTO donationBoardDTO : list) {
      if (!donationBoardDTO.getTitle().contains(keyword) &&
          !donationBoardDTO.getContent().contains(keyword) &&
          !donationBoardDTO.getLeader().contains(keyword)) {
        continue;
      }
      searchResult.add(donationBoardDTO);
    }

    response.setStatus(Response.SUCCESS);
    response.setValue(searchResult);
  }

  private void selectOne(Request request, Response response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));
    DonationBoardDTO donationBoardDTO = findByNo(no);

    if (donationBoardDTO != null) {
      response.setStatus(Response.SUCCESS);
      response.setValue(donationBoardDTO);
    } else {
      response.setStatus(Response.FAIL);
      response.setValue("해당 번호의  모금함을 찾을 수 없습니다.");
    }
  }

  private void update(Request request, Response response) throws Exception {
    DonationBoardDTO donationBoardDTO = request.getObject(DonationBoardDTO.class);

    int index = indexOf(donationBoardDTO.getNo());
    if (index == -1) {
      response.setStatus(Response.FAIL);
      response.setValue("해당 번호의 모금함을 찾을 수 없습니다.");
      return;
    }

    list.set(index, donationBoardDTO);
    response.setStatus(Response.SUCCESS);
  }

  private void delete(Request request, Response response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));
    int index = indexOf(no);

    if (index == -1) {
      response.setStatus(Response.FAIL);
      response.setValue("해당 번호의 모금함을 찾을 수 없습니다.");
      return;
    }

    list.remove(index);
    response.setStatus(Response.SUCCESS);
  }

  private DonationBoardDTO findByNo(int no) {
    for (DonationBoardDTO donationBoardDTO : list) {
      if (donationBoardDTO.getNo() == no) {
        return donationBoardDTO;
      }
    }
    return null;
  }

  private int indexOf(int donationBoardNo) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == donationBoardNo) {
        return i;
      }
    }
    return -1;
  }

  private void getNextNum(Request request, Response response) throws Exception {
    DonationBoardDTO donationBoardDTO = new DonationBoardDTO();

    donationBoardDTO.setNo(getLastNum());

    response.setStatus(Response.SUCCESS);
    response.setValue(donationBoardDTO);
  }

  private int getLastNum() {
    if (list.size() > 0) {
      return list.get(list.size() - 1).getNo() + 1;
    } else {
      return 1;
    }
  }
}













