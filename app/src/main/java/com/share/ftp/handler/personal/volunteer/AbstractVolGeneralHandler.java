package com.share.ftp.handler.personal.volunteer;

import java.util.List;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.personal.GeneralRequestDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractVolGeneralHandler implements Command { // 개인 봉사신청 양식 쓰는 곳

  protected List<GeneralRequestDTO> generalRequestDTOList;
  protected List<GeneralRequestDTO> generalRequestApplyDTOList;
  protected List<GeneralRequestDTO> generalRequestRejectDTOList;

  public AbstractVolGeneralHandler(List<GeneralRequestDTO> generalRequestDTOList) {
    this.generalRequestDTOList = generalRequestDTOList;
  }

  public AbstractVolGeneralHandler(
      List<GeneralRequestDTO> generalRequestDTOList,
      List<GeneralRequestDTO> generalRequestApplyDTOList,
      List<GeneralRequestDTO> generalRequestRejectDTOList) {

    this(generalRequestDTOList);
    this.generalRequestApplyDTOList = generalRequestApplyDTOList;
    this.generalRequestRejectDTOList = generalRequestRejectDTOList;
  }

  // 마지막 봉사 번호를 알아낸다.
  protected int getNextNum() {
    if (generalRequestDTOList.size() > 0) {
      return generalRequestDTOList.get(generalRequestDTOList.size() - 1).getVolNo() + 1;
    } else {
      return 1;
    }
  } 

  protected GeneralRequestDTO findByVol(int no) {
    for (GeneralRequestDTO generalRequestDTO : generalRequestDTOList) {
      if (generalRequestDTO.getVolNo() == no) {
        return generalRequestDTO;
      }
    }
    return null;
  }

  protected GeneralRequestDTO findByApplyVol(int no) {
    for (GeneralRequestDTO generalRequestDTO : generalRequestApplyDTOList) {
      if (generalRequestDTO.getVolNo() == no) {
        return generalRequestDTO;
      }
    }
    return null;
  }

  public boolean validOwner(JoinDTO owner) {
    for (GeneralRequestDTO generalRequestDTO : generalRequestApplyDTOList) {
      if (generalRequestDTO.getOwner() == owner) {
        return true;
      }
    }
    return false;
  }
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



