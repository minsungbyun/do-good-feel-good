package com.share.ftp.domain.personal;

import java.sql.Date;
import java.util.Objects;

public class CommBoardDTO {
  private int no;
  private String title;
  // private String memberId;
  private String content;
  private String fileUpload;
  private String password;
  private Date registeredDate;
  private int viewCount;


  @Override
  public String toString() {
    return "CommBoardDTO [no=" + no + ", title=" + title + ", content=" + content + ", fileUpload="
        + fileUpload + ", password=" + password + ", registeredDate=" + registeredDate
        + ", viewCount=" + viewCount + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, fileUpload, no, password, registeredDate, title, viewCount);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CommBoardDTO other = (CommBoardDTO) obj;
    return Objects.equals(content, other.content) && Objects.equals(fileUpload, other.fileUpload)
        && no == other.no && Objects.equals(password, other.password)
        && Objects.equals(registeredDate, other.registeredDate)
        && Objects.equals(title, other.title) && viewCount == other.viewCount;
  }

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
