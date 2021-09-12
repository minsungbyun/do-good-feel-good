package com.share.menu;

public abstract class Menu {

  public static final int ENABLE_ALL = 0;
  public static final int ENABLE_LOGOUT = 1;
  public static final int ENABLE_LOGIN = 2;
  public static final int ENABLE_ADMIN = 3;
  public static final int ENABLE_MEMBER = 4;
  public static final int ENABLE_PERSONAL = 5;
  public static final int ENABLE_ORG = 6;

  String title;

  int enableState;
  int admin;

  public Menu(String title) {
    this.title = title;
  }

  public Menu(String title, int enableState) {

    this(title); // 메뉴 이름 설정은 기존 생성자를 통해 처리한다.
    this.enableState = enableState;
  }


  public abstract void execute();
}
