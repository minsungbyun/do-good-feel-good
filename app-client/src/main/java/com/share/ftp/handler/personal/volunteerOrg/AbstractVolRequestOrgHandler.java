package com.share.ftp.handler.personal.volunteerOrg;

import java.util.List;
import com.share.ftp.domain.volunteer.OrgRequestDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractVolRequestOrgHandler implements Command { // 개인 봉사신청 양식 쓰는 곳

  // 개인 기관 공통 리스트
  //  protected List<GeneralRequestDTO> generalRequestDTOList;
  //  protected List<GeneralRequestDTO> personalRequestApplyDTOList;
  //  protected List<GeneralRequestDTO> personalRequestRejectDTOList;
  //  protected List<GeneralRequestDTO> orgRequestDTOApplyList;
  //  protected List<GeneralRequestDTO> orgRequestDTORejectList;

  //  // 기관 전체 리스트
  protected List<OrgRequestDTO> orgRequestDTOList;
  // 기관 봉사 승인 리스트
  protected List<OrgRequestDTO> orgRequestApplyDTOList;
  // 기관 봉사 반려 리스트
  protected List<OrgRequestDTO> orgRequestRejectDTOList;


  public AbstractVolRequestOrgHandler(List<OrgRequestDTO> orgRequestDTOList) {
    this.orgRequestDTOList = orgRequestDTOList;
  }

  public AbstractVolRequestOrgHandler(
      List<OrgRequestDTO> orgRequestDTOList,
      List<OrgRequestDTO> orgRequestApplyDTOList,
      List<OrgRequestDTO> orgRequestRejectDTOList) {

    this(orgRequestDTOList);
    this.orgRequestApplyDTOList = orgRequestApplyDTOList;
    this.orgRequestRejectDTOList = orgRequestRejectDTOList;
  }

  //  public AbstractVolRequestPersonalHandler(
  //      List<GeneralRequestDTO> orgRequestDTOApplyList,
  //      List<GeneralRequestDTO> orgRequestDTORejectList) {
  //
  //    this.orgRequestDTOApplyList = orgRequestDTOApplyList;
  //    this.orgRequestDTORejectList = orgRequestDTORejectList;
  //  }



  //  public AbstractVolRequestPersonalHandler(
  //      List<GeneralRequestDTO> generalRequestDTOList,
  //      List<GeneralRequestDTO> personalRequestApplyDTOList,
  //      List<GeneralRequestDTO> personalRequestRejectDTOList,
  //      List<GeneralRequestDTO> orgRequestDTOApplyList,
  //      List<GeneralRequestDTO> orgRequestDTORejectList) {
  //
  //    this.generalRequestDTOList = this.generalRequestDTOList;
  //    this.personalRequestApplyDTOList = personalRequestApplyDTOList;
  //    this.personalRequestRejectDTOList = personalRequestRejectDTOList;
  //    this.orgRequestDTOApplyList = orgRequestDTOApplyList;
  //    this.orgRequestDTORejectList = orgRequestDTORejectList;
  //
  //  }







  protected OrgRequestDTO findByVol(int no) {
    for (OrgRequestDTO orgRequestDTO : orgRequestDTOList) {
      if (orgRequestDTO.getNo() == no) {
        return orgRequestDTO;
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
