package com.share.ftp.domain.admin;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@SuppressWarnings("serial")
public class QuestionDTO implements Serializable {

  private int no;
  private String title;
  private String adminId;
  private int password;
  private String content;
  private String fileUpload;
  private Date registerDate;
  private int viewCount;

  @Override
  public int hashCode() {
    return Objects.hash(adminId, content, fileUpload, no, password, registerDate, title, viewCount);
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    QuestionDTO other = (QuestionDTO) obj;
    return Objects.equals(adminId, other.adminId) && Objects.equals(content, other.content)
        && Objects.equals(fileUpload, other.fileUpload) && no == other.no
        && password == other.password && Objects.equals(registerDate, other.registerDate)
        && Objects.equals(title, other.title) && viewCount == other.viewCount;
  }
  @Override
  public String toString() {
    return "QuestionDTO [no=" + no + ", title=" + title + ", adminId=" + adminId + ", password="
        + password + ", content=" + content + ", fileUpload=" + fileUpload + ", registerDate="
        + registerDate + ", viewCount=" + viewCount + "]";
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
  public String getAdminId() {
    return adminId;
  }
  public void setAdminId(String adminId) {
    this.adminId = adminId;
  }
  public int getPassword() {
    return password;
  }
  public void setPassword(int password) {
    this.password = password;
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
  public Date getRegisterDate() {
    return registerDate;
  }
  public void setRegisterDate(Date registerDate) {
    this.registerDate = registerDate;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }



}
