package com.share.ftp.handler.org;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.personal.OrgRequestDTO;
import com.share.util.Prompt;

public class OrgVolRequestHandler {


  List<OrgRequestDTO> orgRequestDTOList;

  public OrgVolRequestHandler(List<OrgRequestDTO> orgRequestDTOList) {
    this.orgRequestDTOList = orgRequestDTOList;
  }

  public void apply() {
    OrgRequestDTO orgRequestDTO = new OrgRequestDTO();

    orgRequestDTO.setNo(Prompt.inputInt("번호? ")); 
    orgRequestDTO.setTitle(Prompt.inputString("제목? ")); 
    orgRequestDTO.setSort(Prompt.inputString("분류? ")); 
    orgRequestDTO.setTel(Prompt.inputString("전화번호? ")); 
    orgRequestDTO.setEmail(Prompt.inputString("이메일? ")); 
    orgRequestDTO.setVolunteerPeriod(Prompt.inputString("봉사기간? ")); 
    orgRequestDTO.setVolunteerTime(new Date(System.currentTimeMillis())); 
    orgRequestDTO.setVolunteerList(Prompt.inputString("봉사시간? ")); 
    orgRequestDTO.setContent(Prompt.inputString("내용? ")); 
    orgRequestDTO.setFileUpload(Prompt.inputString("파일? ")); 
    orgRequestDTO.setIsOrg(Prompt.inputBool("기업여부? ")); 

    orgRequestDTOList.add(orgRequestDTO);

    System.out.println("기관봉사신청이 완료되었습니다.");
  }
}
