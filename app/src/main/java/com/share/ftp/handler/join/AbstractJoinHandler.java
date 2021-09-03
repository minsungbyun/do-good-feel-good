package com.share.ftp.handler.join;

import java.util.ArrayList;
import java.util.List;
import com.share.ftp.domain.guest.JoinDTO;
import com.share.ftp.handler.Command;
import com.share.util.Prompt;

public abstract class AbstractJoinHandler implements Command {
  protected List<JoinDTO> joinDTOList;

  public AbstractJoinHandler(List<JoinDTO> joinDTOList) {
    this.joinDTOList = joinDTOList;
  }


  protected JoinDTO findByMember(String id, String email) {
    for (JoinDTO joinDTO : joinDTOList) {
      if (joinDTO.getId().equalsIgnoreCase(id) && 
          joinDTO.getEmail().equalsIgnoreCase(email)) {
        return joinDTO;
      }
    }
    return null;
  }

  protected JoinDTO findByMember(String password) {
    for (JoinDTO joinDTO : joinDTOList) {
      if (joinDTO.getId().equals(password)) {
        return joinDTO;
      }
    }
    return null;
  }

  protected JoinDTO findById(String name, String email) {
    for (JoinDTO joinDTO : joinDTOList) {
      if (joinDTO.getName().equalsIgnoreCase(name) &&
          joinDTO.getEmail().equalsIgnoreCase(email)) {
        return joinDTO;
      }
    }
    return null;
  }


  protected JoinDTO findByName(String name) {
    for (JoinDTO joinDTO : joinDTOList) {
      if (joinDTO.getName().equals(name)) {
        return joinDTO;
      }
    }
    return null;
  }

  protected JoinDTO findByEmail(String email) {
    for (JoinDTO joinDTO : joinDTOList) {
      if (joinDTO.getEmail().equals(email)) {
        return joinDTO;
      }
    }
    return null;
  }




  protected boolean exist(String name) {
    for (JoinDTO joinDTO : joinDTOList) {
      if (joinDTO.getName().equals(name)) {
        return true;
      }
    }
    return false;
  }


  protected JoinDTO promptMember(String label) {
    while (true) {
      String joinDTOmemberName = Prompt.inputString(label);
      if (joinDTOmemberName.length() == 0) {
        return null;
      }

      JoinDTO joinDTO = findByName(joinDTOmemberName);
      if (joinDTO != null) {
        return joinDTO;
      }

      System.out.println("등록된 회원이 아닙니다.");
    }
  }

  protected static JoinDTO promptMember(String label, List<JoinDTO> joinDTOList) {
    while (true) {
      String joinDTOmemberName = Prompt.inputString(label);
      if (joinDTOmemberName.length() == 0) {
        return null;
      }

      JoinDTO joinDTO = findByName(joinDTOmemberName, joinDTOList);
      if (joinDTO != null) {
        return joinDTO;
      }

      System.out.println("등록된 회원이 아닙니다.");
    }
  }

  protected static JoinDTO findByName(String name, List<JoinDTO> joinDTOList) {
    for (JoinDTO joinDTO : joinDTOList) {
      if (joinDTO.getName().equalsIgnoreCase(name)) {
        return joinDTO;
      }
    }
    return null;
  }

  protected List<JoinDTO> promptMembers(String label) {
    ArrayList<JoinDTO> joinDTOmembers = new ArrayList<>();

    while (true) {
      String joinDTOmemberName = Prompt.inputString(label);
      JoinDTO joinDTO = findByName(joinDTOmemberName);
      if (joinDTO != null) {
        joinDTOmembers.add(joinDTO);
        continue;
      } else if (joinDTOmemberName.length() == 0) {
        break;
      } 
      System.out.println("등록된 회원이 아닙니다.");
    }
    return joinDTOmembers;
  }



  protected JoinDTO promptJoinDTO() {
    System.out.println("이름:");
    for (JoinDTO joinDTO : joinDTOList) {
      System.out.printf("%s\n", joinDTO.getName());
    }
    while (true) {
      String joinDTOName = Prompt.inputString("이름? (취소: 0) ");
      if (joinDTOName == null) {
        return null;
      }
      JoinDTO selectedJoinDTO = findByName(joinDTOName);
      if (selectedJoinDTO != null) {
        return selectedJoinDTO;
      }
      System.out.println("프로젝트 번호가 옳지 않습니다.");
    }
  }

}
