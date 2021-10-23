package com.share.menu;

public abstract class Menu {

  public static final int ACCESS_LOGOUT = 0x01;         // 비회원
  public static final int ACCESS_PERSONAL = 0x02;       // 개인회원                0010
  public static final int ACCESS_GROUP = 0x04;            // 기관회원                0100      
  public static final int ACCESS_ORG = 0x08;            // 기관회원                0100      
  //  public static final int ACCESS_ORG = 0x04;            // 개인회원 + 단체회원      
  public static final int ACCESS_MEMBER = 0x10;         // 개인회원 + 기관회원     1000
  public static final int ACCESS_ADMIN = 0x20;          // 관리자
  public static final int ACCESS_MEMBER_ADMIN = 0x40;   // 개인회원 + 기관회원 + 관리자
  public static final int ACCESS_ALL = 0x80;            // 개인회원 + 기관회원 + 관리자

  String title;

  int accessScope;

  public Menu(String title) {
    this(title, ACCESS_LOGOUT | ACCESS_PERSONAL | ACCESS_ORG  | ACCESS_MEMBER | ACCESS_GROUP);
  }

  public Menu(String title, int accessScope) {
    this.title = title;
    this.accessScope = accessScope;
  }

  public int getAccessScope() {
    return accessScope;
  }

  public abstract void execute();
}
