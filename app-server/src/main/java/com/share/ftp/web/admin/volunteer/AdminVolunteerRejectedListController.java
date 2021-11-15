package com.share.ftp.web.admin.volunteer;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;


@WebServlet("/admin/volunteer/rejectedList")
public class AdminVolunteerRejectedListController extends HttpServlet { 

  private static final long serialVersionUID = 1L;


  VolunteerDao volunteerDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    volunteerDao = (VolunteerDao) 웹애플리케이션공용저장소.getAttribute("volunteerDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      List<VolunteerRequestDTO> volunteerList = volunteerDao.findAllRejected();

      request.setAttribute("volunteerList", volunteerList);
      request.getRequestDispatcher("/admin/AdminVolunteerRejectedList.jsp").forward(request, response);

    } catch (Exception e) {

      e.printStackTrace();
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }


  }


  //
  //  @Override
  //  public void execute(CommandRequest request) throws Exception {
  //    System.out.println();
  //    System.out.println("[ 봉사 목록 ]");
  //
  //
  //
  //    List<VolunteerRequestDTO> volunteerList = volunteerDao.findAllWait();
  //
  //    if (volunteerList.isEmpty()) {
  //      System.out.println("[  현재 봉사목록이 없습니다. ]");
  //      return;
  //    }
  //
  //    for (VolunteerRequestDTO volunteerRequestDTO : volunteerList) {
  //      System.out.printf("%d, %s, %s, %s, %s, %s, %s, %s, %s, %s, %d, %s \n", 
  //          volunteerRequestDTO.getNo(),      
  //          volunteerRequestDTO.getTitle(),     
  //          volunteerRequestDTO.getOwner().getId(), 
  //          volunteerRequestDTO.getCategory().getTitle(), 
  //          volunteerRequestDTO.getTel(),
  //          volunteerRequestDTO.getEmail(),
  //          volunteerRequestDTO.getStartDate(),
  //          volunteerRequestDTO.getEndDate(),
  //          volunteerRequestDTO.getStartTime(),
  //          volunteerRequestDTO.getEndTime(),
  //          volunteerRequestDTO.getLimitNum(),
  //          volunteerRequestDTO.getContent()
  //          );
  //    } 
  //
  //    int volNo = Prompt.inputInt("상태 변경할 봉사 번호를 입력해주세요 ▶ ");
  //
  //    request.setAttribute("volNo", volNo); 
  //
  //    while (true) {
  //      System.out.println();
  //      System.out.println("1번 ▶ 승인하기");
  //      System.out.println("2번 ▶ 반려하기");
  //      System.out.println("0번 ▶ 이전");
  //      int input = Prompt.inputInt("번호 입력 ▶ ");
  //      switch (input) {
  //        case 1: request.getRequestDispatcher("/vol/approve").forward(request); return;
  //        case 2: request.getRequestDispatcher("/vol/reject").forward(request); return;
  //        case 0: return;
  //        default:
  //          System.out.println("명령어가 올바르지 않습니다!");
  //      }
  //    }
  //
  //
  //  }
}
