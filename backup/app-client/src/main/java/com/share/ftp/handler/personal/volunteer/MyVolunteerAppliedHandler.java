package com.share.ftp.handler.personal.volunteer;

import static com.share.util.General.check.APPLIED;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.volunteer.VolunteerAttachedFile;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class MyVolunteerAppliedHandler implements Command { // 개인 봉사신청 양식 쓰는 곳

  VolunteerDao volunteerDao;
  SqlSession sqlSession;

  public MyVolunteerAppliedHandler(VolunteerDao volunteerDao, SqlSession sqlSession) {
    this.volunteerDao = volunteerDao;
    this.sqlSession = sqlSession;
  }


  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[ 봉사승인 목록 ]");

    JoinDTO loginUser = AuthLoginHandler.getLoginUser();

    List<VolunteerRequestDTO> volunteerRequestDTOList = volunteerDao.findAll();

    if (volunteerRequestDTOList.isEmpty()) {
      System.out.println();
      System.out.println("[  현재 승인된 봉사목록이 없습니다. ]");
      return;
    } 

    for (VolunteerRequestDTO volunteerRequestDTO : volunteerRequestDTOList) {
      if (volunteerRequestDTO.getStatus() == APPLIED &&
          volunteerRequestDTO.getOwner().getName().equals(loginUser.getName())) {
        System.out.printf("%d, %s, %s, %s, %s, %s, %s, %s, %s, %s, %d, %s", 
            volunteerRequestDTO.getNo(),      
            volunteerRequestDTO.getTitle(),     
            volunteerRequestDTO.getOwner().getId(), 
            volunteerRequestDTO.getCategory().getTitle(), 
            volunteerRequestDTO.getTel(),
            volunteerRequestDTO.getEmail(),
            volunteerRequestDTO.getStartDate(),
            volunteerRequestDTO.getEndDate(),
            volunteerRequestDTO.getStartTime(),
            volunteerRequestDTO.getEndTime(),
            volunteerRequestDTO.getLimitNum(),
            volunteerRequestDTO.getContent() 
            );

        for (VolunteerAttachedFile file : volunteerRequestDTO.getFileUpload()) {
          System.out.printf(", %s", file.getFilepath());
        }
      } 
    }

    System.out.println();
    int volNo = Prompt.inputInt("삭제 할 봉사번호(취소 0) ▶ ");

    if (volNo == 0) {
      return;
    }

    VolunteerRequestDTO volunteerRequestDTO = volunteerDao.findByVolunteerNo(volNo);

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (!input.equals("y") || input.length() == 0) {
      System.out.println("[  해당 봉사신청 삭제를 취소하였습니다.  ]");
      return;
    }
    volunteerDao.delete(volunteerRequestDTO);
    sqlSession.commit();


    System.out.println("[  해당 봉사신청을 삭제하였습니다. ]");


  }
}
