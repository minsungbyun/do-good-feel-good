package com.share.ftp.domain.admin;

public class QuestionDTO {

  private int adminId;
  private String title;
  private String content;


  public int getAdminId() {
    return adminId;
  }
  public void setAdminId(int adminId) {
    this.adminId = adminId;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }

}
