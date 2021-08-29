package com.share.ftp.domain.personal;

import java.sql.Date;

public class CommBoardDTO {
  public int no;
  public String title;
  // public String memberId;
  public String content;
  public String fileUpload;
  public String password;
  public Date registeredDate;
  public int viewCount;

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
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

  public String getFileUpload() {
    return fileUpload;
  }

  public void setFileUpload(String fileUpload) {
    this.fileUpload = fileUpload;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Date getRegisteredDate() {
    return registeredDate;
  }

  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }

  public int getViewCount() {
    return viewCount;
  }

  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }


}
