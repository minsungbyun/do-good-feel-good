package com.share.ftp.handler.personal.volunteer;

import java.util.List;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.personal.GeneralRequestDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;

public class MyRejectedVolHandler extends AbstractVolGeneralHandler { 


  public MyRejectedVolHandler(
      List<GeneralRequestDTO> generalRequestDTOList,
      List<GeneralRequestDTO> generalRequestApplyDTOList,
      List<GeneralRequestDTO> generalRequestRejectDTOList) {

    super(generalRequestDTOList, generalRequestApplyDTOList, generalRequestRejectDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[  봉사반려 목록  ]");


    JoinDTO loginUser = AuthLoginHandler.getLoginUser();

    if (generalRequestRejectDTOList.isEmpty()) {
      System.out.println();
      System.out.println("[  현재 반려된 봉사목록이 없습니다. ]");
      return;
    }



    for (GeneralRequestDTO generalRequestRejectDTO : generalRequestRejectDTOList) {
      if (generalRequestRejectDTO.getOwner().getName().equals(loginUser.getName())) {
        System.out.printf("%d, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %d, %s, %s, %s \n", 
            generalRequestRejectDTO.getVolNo(),      
            generalRequestRejectDTO.getMemberType(),      
            generalRequestRejectDTO.getVolTitle(),     
            generalRequestRejectDTO.getOwner().getName(), 
            generalRequestRejectDTO.getVolType(), 
            generalRequestRejectDTO.getVolTel(),
            generalRequestRejectDTO.getVolEmail(),
            generalRequestRejectDTO.getVolStartDate(),
            generalRequestRejectDTO.getVolEndDate(),
            generalRequestRejectDTO.getVolStartTime(),
            generalRequestRejectDTO.getVolEndTime(),
            //            personalRequestRejectDTO.getVolList(),
            generalRequestRejectDTO.getVolLimitNum(),
            generalRequestRejectDTO.getVolContent(),
            generalRequestRejectDTO.getVolFileUpload(),
            generalRequestRejectDTO.getIsSigned()
            );
      } else {
        System.out.println();
        System.out.println("[  현재 반려된 봉사목록이 없습니다. ]");
        return;
      }
    }
  }
}
