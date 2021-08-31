package com.share.ftp.handler.personal;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.share.ftp.domain.guest.JoinDTO;
import com.share.util.Prompt;

public class JoinHandler {
  List<JoinDTO> JoinDTOList;
  DonationBoardHandler donationBoardHandler;

  public JoinHandler(List<JoinDTO> JoinDTOList, DonationBoardHandler donationBoardHandler) {
    this.JoinDTOList = JoinDTOList;
    this.donationBoardHandler = donationBoardHandler;
  }

  //  this.memberList = memberList;
  //
  //  Member testUser = new Member();
  //  testUser.setNo(0);
  //  testUser.setName("aaa");
  //  testUser.setEmail("a@test.com");
  //  testUser.setPassword("1111");
  //  testUser.setPhoto("1.jpg");
  //  testUser.setTel("010-1111-1111");
  //  testUser.setRegisteredDate(new Date(System.currentTimeMillis()));
  //
  //  memberList.add(testUser);
  //
  //  testUser = new Member();
  //  testUser.setNo(1);
  //  testUser.setName("bbb");
  //  testUser.setEmail("b@test.com");
  //  testUser.setPassword("1111");
  //  testUser.setPhoto("b.jpg");
  //  testUser.setTel("010-1111-2");
  //  testUser.setRegisteredDate(new Date(System.currentTimeMillis()));
  //
  //  memberList.add(testUser);
  //
  //  memberList.add(testUser);
  //
  //  testUser = new Member();
  //  testUser.setNo(2);
  //  testUser.setName("bbb");
  //  testUser.setEmail("b@test.com");
  //  testUser.setPassword("1111");
  //  testUser.setPhoto("b.jpg");
  //  testUser.setTel("010-1111-2");
  //  testUser.setRegisteredDate(new Date(System.currentTimeMillis()));
  //
  //  memberList.add(testUser);


  // 가입하기
  public void joinSite() {
    System.out.println("[회원 가입]");

    JoinDTO joinDTO = new JoinDTO();

    joinDTO.setId(Prompt.inputString("번호? "));
    joinDTO.setPassword(Prompt.inputString("이름? "));
    joinDTO.setName(Prompt.inputString("이메일? "));
    joinDTO.setTel(Prompt.inputString("암호? "));
    joinDTO.setEmail(Prompt.inputString("사진? "));
    joinDTO.setAdress(Prompt.inputString("전화? "));
    joinDTO.setRegisterDate(new Date(System.currentTimeMillis()));

    JoinDTOList.add(joinDTO);
  }

  public void list() {
    System.out.println("[회원 목록]");
    for (JoinDTO joinDTO : JoinDTOList) {
      System.out.printf("%s, %s, %s, %s, %s\n", 
          joinDTO.getId(), 
          joinDTO.getPassword(), 
          joinDTO.getTel(), 
          joinDTO.getEmail(), 
          joinDTO.getAdress());
      joinDTO.getRegisterDate());
    }
  }

  public void detail() {
    System.out.println("[회원 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Member member = findByNo(no);

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    System.out.printf("이름: %s\n", member.getName());
    System.out.printf("이메일: %s\n", member.getEmail());
    System.out.printf("사진: %s\n", member.getPhoto());
    System.out.printf("전화: %s\n", member.getTel());
    System.out.printf("등록일: %s\n", member.getRegisteredDate());
  }

  public void update() {
    System.out.println("[회원 변경]");
    int no = Prompt.inputInt("번호? ");

    Member member = findByNo(no);

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    String name = Prompt.inputString("이름(" + member.getName()  + ")? ");
    String email = Prompt.inputString("이메일(" + member.getEmail() + ")? ");
    String password = Prompt.inputString("암호? ");
    String photo = Prompt.inputString("사진(" + member.getPhoto() + ")? ");
    String tel = Prompt.inputString("전화(" + member.getTel() + ")? ");

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("회원 변경을 취소하였습니다.");
      return;
    }

    member.setName(name);
    member.setEmail(email);
    member.setPassword(password);
    member.setPhoto(photo);
    member.setTel(tel);

    System.out.println("회원을 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[회원 삭제]");
    int no = Prompt.inputInt("번호? ");

    Member member = findByNo(no);

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("회원 삭제를 취소하였습니다.");
      return;
    }

    memberList.remove(member);

    System.out.println("회원을 삭제하였습니다.");
  }

  private Member findByNo(int no) {
    for (Member member : memberList) {
      if (member.getNo() == no) {
        return member;
      }
    }
    return null;
  }

  private Member findByName(String name) {
    for (Member member : memberList) {
      if (member.getName().equalsIgnoreCase(name)) {
        return member;
      }
    }
    return null;
  }

  public boolean exist(String name) {
    for (Member member : memberList) {
      if (member.getName().equals(name)) {
        return true;
      }
    }
    return false;
  }

  public Member promptMember(String label) {
    while (true) {
      String memberName = Prompt.inputString(label);
      if (memberName.length() == 0) {
        return null;
      }

      Member member = findByName(memberName);
      if (member != null) {
        return member;
      }

      System.out.println("등록된 회원이 아닙니다.");
    }
  }

  public static Member promptMember(String label, List<Member> memberList) {
    while (true) {
      String memberName = Prompt.inputString(label);
      if (memberName.length() == 0) {
        return null;
      }

      Member member = findByName(memberName, memberList);
      if (member != null) {
        return member;
      }

      System.out.println("등록된 회원이 아닙니다.");
    }
  }

  private static Member findByName(String name, List<Member> memberList) {
    for (Member member : memberList) {
      if (member.getName().equalsIgnoreCase(name)) {
        return member;
      }
    }
    return null;
  }

  public List<Member> promptMembers(String label) {
    ArrayList<Member> members = new ArrayList<>();

    while (true) {
      String memberName = Prompt.inputString(label);
      Member member = findByName(memberName);
      if (member != null) {
        members.add(member);
        continue;
      } else if (memberName.length() == 0) {
        break;
      } 
      System.out.println("등록된 회원이 아닙니다.");
    }
    return members;
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




