package com.share.ftp.table;

import java.text.DecimalFormat;
import com.share.ftp.domain.personal.DonationBoardDTO;
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
      case "donationBoard.selectOne": selectOne(request, response); break;
      case "donationBoard.update": update(request, response); break;
      case "donationBoard.delete": delete(request, response); break;
      case "donationBoard.getNextNum": getNextNum(request, response); break;
      case "donationBoard.printDonationBoard": printDonationBoard(request, response); break;
      //      case "donationBoard.getRemainTime": getRemainTime(request, response); break;
      //      case "donationBoard.findByNo": findByNo(request, response); break;
      //      case "project.task.insert": insertTask(request, response); break;
      //      case "project.task.update": updateTask(request, response); break;
      //      case "project.task.delete": deleteTask(request, response); break;
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

  private void printDonationBoard(Request request, Response response) throws Exception {

    DecimalFormat formatter = new DecimalFormat("###,###,###");
    DonationBoardDTO donationBoardDTO = request.getObject(DonationBoardDTO.class);

    if (donationBoardDTO.getIsSigned().equals("반려됨")) {
      System.out.println();
      System.out.println("해당 번호의 모금함 개설 신청내역이 없습니다.");
      return;
    } else if (donationBoardDTO.getIsSigned().equals("승인됨")) {
      System.out.println();
      System.out.printf("개설번호: %s\n", donationBoardDTO.getNo());
      System.out.printf("개설분류: %s\n", donationBoardDTO.getSort());
      System.out.printf("제목: %s\n", donationBoardDTO.getTitle());
      System.out.printf("주최자: %s\n", donationBoardDTO.getLeader());
      System.out.printf("내용: %s\n", donationBoardDTO.getContent());
      System.out.printf("첨부파일: %s\n", donationBoardDTO.getFileUpload());
      System.out.printf("시작일: %s\n", donationBoardDTO.getRegisteredStartDate());
      System.out.printf("종료일: %s\n", donationBoardDTO.getRegisteredEndDate());
      System.out.printf("모금함기간 ▶ %d일\n",  ((((donationBoardDTO.getRegisteredEndDate().getTime() - donationBoardDTO.getRegisteredStartDate().getTime()) / 1000)) / (24*60*60)));
      System.out.printf(getRemainTime(donationBoardDTO.getRegisteredEndDate().getTime() - System.currentTimeMillis()));
      System.out.printf("목표금액: %s원\n", formatter.format(donationBoardDTO.getMoneyTarget()));
      System.out.println();

    } else {
      System.out.println("해당 번호의 모금함 개설 신청내역이 없습니다.");
      return;
    }

  }

  private static String getRemainTime(long millis) {

    long sec = millis / 1000;
    long min = sec / 60;
    long hour = min / 60;
    long day = millis / 1000 / (24 * 60 * 60);

    hour = hour % 24; 
    sec = sec % 60;
    min = min % 60;

    return String.format("남은시간 ▶ %d일 %d시간 %d분 %d초 남았습니다\n", day, hour, min, sec);
  }



  //  private int getNextNum() {
  //    if (donationBoardDTOList.size() > 0) {
  //      return donationBoardDTOList.get(donationBoardDTOList.size() - 1).getNo() + 1;
  //    } else {
  //      return 1;
  //    }
  //  }

  //  private void insertTask(Request request, Response response) throws Exception {
  //    Task task = request.getObject(Task.class);
  //    Project project = findByNo(task.getProject().getNo());
  //    project.getTasks().add(task);
  //    response.setStatus(Response.SUCCESS);
  //  }
  //
  //  private void updateTask(Request request, Response response) throws Exception {
  //    Task task = request.getObject(Task.class);
  //    Project project = findByNo(task.getProject().getNo());
  //
  //    int index = indexOfTask(task.getNo(), project.getTasks());
  //    if (index == -1) {
  //      response.setStatus(Response.FAIL);
  //      response.setValue("해당 번호의 작업을 찾을 수 없습니다.");
  //      return;
  //    }
  //
  //    project.getTasks().set(index, task);
  //    response.setStatus(Response.SUCCESS);
  //  }
  //
  //  private void deleteTask(Request request, Response response) throws Exception {
  //    int taskNo = Integer.parseInt(request.getParameter("taskNo"));
  //    int projectNo = Integer.parseInt(request.getParameter("projectNo"));
  //
  //    Project project = findByNo(projectNo);
  //
  //    int index = indexOfTask(taskNo, project.getTasks());
  //    if (index == -1) {
  //      response.setStatus(Response.FAIL);
  //      response.setValue("해당 번호의 작업을 찾을 수 없습니다.");
  //      return;
  //    }
  //
  //    project.getTasks().remove(index);
  //    response.setStatus(Response.SUCCESS);
  //  }
  //
  //  private int indexOfTask(int taskNo, List<Task> taskList) {
  //    for (int i = 0; i < taskList.size(); i++) {
  //      if (taskList.get(i).getNo() == taskNo) {
  //        return i;
  //      }
  //    }
  //    return -1;
  //  }



}













