package com.share.menu;

public abstract class Menu {
  //
  //  public static final int ENABLE_ALL = 0;
  //  public static final int ENABLE_LOGOUT = 1;
  //  public static final int ENABLE_LOGIN = 2;
  //  public static final int ENABLE_ADMIN = 3;
  //  public static final int ENABLE_MEMBER = 4;
  //  public static final int ENABLE_PERSONAL = 5;
  //  public static final int ENABLE_ORG = 6;
  //
  //  String title;
  //
  //  int enableState;
  //  int admin;
  //
  //  public Menu(String title) {
  //    this.title = title;
  //  }
  //
  //  public Menu(String title, int enableState) {
  //
  //    this(title); // 메뉴 이름 설정은 기존 생성자를 통해 처리한다.
  //    this.enableState = enableState;
  //  }
  //
  //
  //  public abstract void execute();



  public static final int ACCESS_LOGOUT = 0x01; //      비회원
  public static final int ACCESS_PERSONAL = 0x02; //    개인회원                0010
  public static final int ACCESS_ORG = 0x04;    //      기관회원                0100      
  public static final int ACCESS_MEMBER = 0x08;  //     개인회원 + 기관회원     1000
  public static final int ACCESS_ADMIN = 0x10; //       관리자
  public static final int ACCESS_MEMBER_ADMIN = 0x20;  // 개인회원 + 기관회원 + 관리자
  public static final int ACCESS_ALL = 0x40;  // 개인회원 + 기관회원 + 관리자
  //  public static final int ENABLE_PERSONAL = 5;

  String title;

  int accessScope;

  public Menu(String title) {
    this(title, ACCESS_LOGOUT | ACCESS_PERSONAL | ACCESS_ORG  | ACCESS_MEMBER );
  }

  public Menu(String title, int accessScope) {
    this.title = title;
    this.accessScope = accessScope;
  }


  public abstract void execute();

}
