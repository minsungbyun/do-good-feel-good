package com.share.ftp.handler.join;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.share.ftp.domain.guest.JoinDTO;
import com.share.util.Prompt;

public class JoinHandler {
  List<JoinDTO> joinDTOList;

  public JoinHandler(List<JoinDTO> joinDTOList) {
    this.joinDTOList = joinDTOList;

    // 로그인 테스드를 위한 데이터

    // 관리자
    JoinDTO admin = new JoinDTO();
    admin.setId("admin");
    admin.setName("관리자");
    admin.setEmail("aaa@test.com");
    admin.setPassword("111");
    admin.setTel("010-1111-1111");
    admin.setAdress("no");
    admin.setRegisterDate(new Date(System.currentTimeMillis()));
    admin.setAdmin(true);

    joinDTOList.add(admin);

    // 개인회원
    JoinDTO testUser = new JoinDTO();
    testUser.setId("aaa");
    testUser.setName("test1");
    testUser.setEmail("aaa@test.com");
    testUser.setPassword("111");
    testUser.setTel("010-2222-2222");
    testUser.setAdress("no");
    testUser.setRegisterDate(new Date(System.currentTimeMillis()));
    testUser.setPersonal(true);

    joinDTOList.add(testUser);

    // 기관회원
    testUser = new JoinDTO();
    testUser.setId("bbb");
    testUser.setName("test2");
    testUser.setEmail("bbb");
    testUser.setPassword("111");
    testUser.setTel("010-3333-3333");
    testUser.setAdress("no");
    testUser.setRegisterDate(new Date(System.currentTimeMillis()));
    testUser.setOrg(true);

    joinDTOList.add(testUser);

    testUser = new JoinDTO();
    testUser.setId("ccc");
    testUser.setName("test3");
    testUser.setEmail("ccc@test.com");
    testUser.setPassword("111");
    testUser.setTel("010-4444-4444");
    testUser.setAdress("no");
    testUser.setRegisterDate(new Date(System.currentTimeMillis()));

    joinDTOList.add(testUser);

  }


  // 회원 가입하기
  public void joinSite() {
    System.out.println("[회원 가입]");

    JoinDTO joinDTO = new JoinDTO();

    joinDTO.setId(Prompt.inputString("아이디? "));
    joinDTO.setPassword(Prompt.inputString("비밀번호? "));
    joinDTO.setName(Prompt.inputString("이름? "));
    joinDTO.setTel(Prompt.inputString("전화? "));
    joinDTO.setEmail(Prompt.inputString("이메일? "));
    joinDTO.setAdress(Prompt.inputString("주소? "));
    joinDTO.setRegisterDate(new Date(System.currentTimeMillis()));

    joinDTOList.add(joinDTO);
  }

  // 가입회원 목록 (관리자가 가입한 회원의 목록을 볼 수 있다) => 관리자 연결
  public void list() {
    System.out.println("[회원 목록]");
    for (JoinDTO joinDTO : joinDTOList) {
      System.out.printf("%s, %s, %s, %s, %s\n", 
          joinDTO.getId(), 
          joinDTO.getPassword(), 
          joinDTO.getTel(), 
          joinDTO.getEmail(), 
          joinDTO.getAdress(),
          joinDTO.getRegisterDate());
    }
  }

  // 아이디찾기 이름, 이메일을 통해 찾는다.
  public void searchId() {
    String name = Prompt.inputString("이름? ");
    String email = Prompt.inputString("이메일? ");

    JoinDTO joinDTO = findById(name, email);

    if (joinDTO == null) {
      System.out.println("해당 아이디를 찾을 수 없습니다.");
      return;
    }
    System.out.printf("아이디: %s\n", joinDTO.getId());
  }

  public void searchPassword() {
    String id = Prompt.inputString("아이디? ");
    String email = Prompt.inputString("이메일? ");

    JoinDTO joinDTO = findByMember(id, email);

    if (joinDTO == null) {
      System.out.println("해당 아이디를 찾을 수 없습니다.");
      return;
    }
    System.out.printf("아이디: %s\n", joinDTO.getId());
    System.out.printf("비밀번호: %s\n", joinDTO.getPassword());
  }


  // 가입회원 상세보기 (관리자가 가입한 회원의 상세정보를을 볼 수 있다) => 관리자 연결
  public void detail() {
    System.out.println("[회원 상세보기]");
    String id = Prompt.inputString("아이디? "); 
    String password = Prompt.inputString("비밀번호? ");

    JoinDTO joinDTO = findByMember(id, password);

    if (joinDTO == null) {
      System.out.println("해당 아이디와 비밀번호가 일치하지 않습니다.");
      return;
    }

    System.out.printf("이름: %s\n", joinDTO.getName());
    System.out.printf("전화: %s\n", joinDTO.getTel());
    System.out.printf("이메일: %s\n", joinDTO.getEmail());
    System.out.printf("주소: %s\n", joinDTO.getAdress());
    System.out.printf("등록일: %s\n", joinDTO.getRegisterDate());
  }


  // 
  public void update() {
    System.out.println("[회원 변경]");
    String id = Prompt.inputString("아이디? ");
    String password = Prompt.inputString("비밀번호? ");

    JoinDTO joinDTO = findByMember(id, password);

    if (joinDTO == null) {
      System.out.println("해당 아이디의 회원이 없습니다.");
      return;
    }

    String name = Prompt.inputString("이름(" + joinDTO.getName()  + ")? ");
    String tel = Prompt.inputString("전화(" + joinDTO.getTel() + ")? ");
    String email = Prompt.inputString("이메일(" + joinDTO.getEmail() + ")? ");
    String adress = Prompt.inputString("주소(" + joinDTO.getAdress() + ")? ");
    String passwords = Prompt.inputString("암호? ");

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("회원 변경을 취소하였습니다.");
      return;
    }

    joinDTO.setName(name);
    joinDTO.setTel(tel);
    joinDTO.setEmail(email);
    joinDTO.setAdress(adress);
    joinDTO.setPassword(passwords);

    System.out.println("회원을 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[회원 탈퇴]");
    String id = Prompt.inputString("아이디? ");
    String password = Prompt.inputString("비밀번호? ");

    JoinDTO joinDTO = findByMember(id, password);

    if (joinDTO == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 탈퇴 하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("회원 탈퇴를 취소하였습니다.");
      return;
    }

    joinDTO = null;
    //    joinDTOList.remove(joinDTO);

    System.out.println("회원을 탈퇴하였습니다.");
  }

  //  private JoinDTO findByPassword(int password) {
  //    for (JoinDTO joinDTO : joinDTOList) {
  //      if (joinDTO.getPassword() == password) {
  //        return joinDTO;
  //      }
  //    }
  //    return null;
  //  }

  public JoinDTO findByMember(String id, String email) {
    for (JoinDTO joinDTO : joinDTOList) {
      if (joinDTO.getId().equalsIgnoreCase(id) && 
          joinDTO.getEmail().equalsIgnoreCase(email)) {
        return joinDTO;
      }
    }
    return null;
  }

  private JoinDTO findById(String name, String email) {
    for (JoinDTO joinDTO : joinDTOList) {
      if (joinDTO.getName().equalsIgnoreCase(name) &&
          joinDTO.getEmail().equalsIgnoreCase(email)) {
        return joinDTO;
      }
    }
    return null;
  }


  public boolean exist(String name) {
    for (JoinDTO joinDTO : joinDTOList) {
      if (joinDTO.getName().equals(name)) {
        return true;
      }
    }
    return false;
  }

  protected JoinDTO findByName(String name) {
    for (JoinDTO joinDTO : joinDTOList) {
      if (joinDTO.getName().equalsIgnoreCase(name)) {
        return joinDTO;
      }
    }
    return null;
  }

  public JoinDTO promptMember(String label) {
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

  public static JoinDTO promptMember(String label, List<JoinDTO> joinDTOList) {
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

  private static JoinDTO findByName(String name, List<JoinDTO> joinDTOList) {
    for (JoinDTO joinDTO : joinDTOList) {
      if (joinDTO.getName().equalsIgnoreCase(name)) {
        return joinDTO;
      }
    }
    return null;
  }

  public List<JoinDTO> promptMembers(String label) {
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



  public JoinDTO promptJoinDTO() {
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



//  public void joinSite() {
//    System.out.println("가입하기");
//  }
//
//  public void idCheck() {
//    System.out.println("ID중복확인");
//  }
//
//  public void telCheck() {
//    System.out.println("휴대전화인증");
//  }
//
//  public void findAddress() {
//    System.out.println("우편번호검색");
//  }




