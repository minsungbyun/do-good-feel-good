package com.share.ftp.domain.admin;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@SuppressWarnings("serial")
public class QuestionDTO implements Serializable {

  private int no;
  private int adminId;
  private String title;
  private String content;
  private String fileUpload;
  private Date registerDate;
  private int viewCount;


  @Override
  public int hashCode() {
    return Objects.hash(adminId, content, fileUpload, no, registerDate, title, viewCount);
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
    return adminId == other.adminId && Objects.equals(content, other.content)
        && Objects.equals(fileUpload, other.fileUpload) && no == other.no
        && Objects.equals(registerDate, other.registerDate) && Objects.equals(title, other.title)
        && viewCount == other.viewCount;
  }
  @Override
  public String toString() {
    return "QuestionDTO [no=" + no + ", adminId=" + adminId + ", title=" + title + ", content="
        + content + ", fileUpload=" + fileUpload + ", registerDate=" + registerDate + ", viewCount="
        + viewCount + "]";
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
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
