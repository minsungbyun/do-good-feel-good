package com.share.ftp.handler.personal.volunteer;

import java.util.List;
import com.share.ftp.domain.personal.OrgRequestDTO;
import com.share.ftp.domain.personal.PersonalRequestDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractVolRequestPersonalHandler implements Command { // 개인 봉사신청 양식 쓰는 곳

  // 개인 기관 공통 리스트
  //  protected List<GeneralRequestDTO> generalRequestDTOList;
  //  protected List<GeneralRequestDTO> personalRequestApplyDTOList;
  //  protected List<GeneralRequestDTO> personalRequestRejectDTOList;
  //  protected List<GeneralRequestDTO> orgRequestDTOApplyList;
  //  protected List<GeneralRequestDTO> orgRequestDTORejectList;
  //  // 개인 전체 리스트
  protected List<PersonalRequestDTO> personalRequestDTOList;
  // 개인 봉사 승인 리스트
  protected List<PersonalRequestDTO> personalRequestApplyDTOList;
  //  //  List<PersonalRequestApplyDTO> personalRequestApplyDTOList;
  // 개인 봉사 반려 리스트
  protected List<PersonalRequestDTO> personalRequestRejectDTOList;
  //  //  List<PersonalRequestRejectDTO> personalRequestRejectDTOList;

  protected List<OrgRequestDTO> orgRequestDTOList;
  protected List<OrgRequestDTO> orgRequestApplyDTOList;
  protected List<OrgRequestDTO> orgRequestRejectDTOList;


  public AbstractVolRequestPersonalHandler(List<PersonalRequestDTO> personalRequestDTOList) {
    this.personalRequestDTOList = personalRequestDTOList;
  }

  public AbstractVolRequestPersonalHandler(
      List<PersonalRequestDTO> personalRequestDTOList,
      List<PersonalRequestDTO> personalRequestApplyDTOList,
      List<PersonalRequestDTO> personalRequestRejectDTOList) {

    this(personalRequestDTOList);
    this.personalRequestApplyDTOList = personalRequestApplyDTOList;
    this.personalRequestRejectDTOList = personalRequestRejectDTOList;
  }

  //  public AbstractVolRequestPersonalHandler(
  //      List<GeneralRequestDTO> orgRequestDTOApplyList,
  //      List<GeneralRequestDTO> orgRequestDTORejectList) {
  //
  //    this.orgRequestDTOApplyList = orgRequestDTOApplyList;
  //    this.orgRequestDTORejectList = orgRequestDTORejectList;
  //  }

  //
  public AbstractVolRequestPersonalHandler(
      List<PersonalRequestDTO> personalRequestDTOList,
      List<OrgRequestDTO> orgRequestDTOList,
      List<PersonalRequestDTO> personalRequestApplyDTOList,
      List<PersonalRequestDTO> personalRequestRejectDTOList,
      List<OrgRequestDTO> orgRequestDTOApplyList,
      List<OrgRequestDTO> orgRequestDTORejectList) {

    this(personalRequestDTOList);
    this.orgRequestDTOList = this.orgRequestDTOList;
    this.personalRequestApplyDTOList = personalRequestApplyDTOList;
    this.personalRequestRejectDTOList = personalRequestRejectDTOList;
    this.orgRequestApplyDTOList = orgRequestApplyDTOList;
    this.orgRequestRejectDTOList = orgRequestRejectDTOList;

  }







  protected PersonalRequestDTO findByVol(int no) {
    for (PersonalRequestDTO personalRequestDTO : personalRequestDTOList) {
      if (personalRequestDTO.getNo() == no) {
        return personalRequestDTO;
      }
    }
    return null;

  }

  //  protected GeneralRequestDTO findByVol(int no) {
  //    for (GeneralRequestDTO generalRequestDTO : generalRequestDTOList) {
  //      if (generalRequestDTO.getNo() == no) {
  //        return generalRequestDTO;
  //      }
  //    }
  //    return null;
  //
  //  }

  //  private int indexOf(int no) {
  //    for (int i = 0; i < this.size; i++) {
  //      if (this.personalRequestsDTO[i].getNo() == no) {
  //        return i;
  //      }
  //    }
  //    return -1;
  //  }
  //
  //  public String getReturnMessage() {
  //    for (int i = 0; i < this.size; i++) {
  //      if (this.personalRequestsDTO[i] == null) {
  //        return ""; 
  //      }
  //    }
  //    return null;
  //  }

  //  private PersonalRequestDTO findByVol(int no) {
  //    for (int i = 0; i < this.size; i++) {
  //      if (personalRequestsDTO[i].getNo() == no) {
  //        return personalRequestsDTO[i];
  //      }
  //    }
  //    return null;
  //
  //  }


}
