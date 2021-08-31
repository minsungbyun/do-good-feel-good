package com.share.ftp.domain.personal;

import java.sql.Date;
import java.util.Objects;

public class DonationBoardDTO {
  private int no;
  private String title;
  private String leader;
  private String content;
  private String fileUpload;
  private String password;
  private Date registeredDate;

  @Override
  public String toString() {
    return "DonationBoardDTO [no=" + no + ", title=" + title + ", leader=" + leader + ", content="
        + content + ", fileUpload=" + fileUpload + ", password=" + password + ", registeredDate="
        + registeredDate + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, fileUpload, leader, no, password, registeredDate, title);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    DonationBoardDTO other = (DonationBoardDTO) obj;
    return Objects.equals(content, other.content) && Objects.equals(fileUpload, other.fileUpload)
        && Objects.equals(leader, other.leader) && no == other.no
        && Objects.equals(password, other.password)
        && Objects.equals(registeredDate, other.registeredDate)
        && Objects.equals(title, other.title);
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
  public String getLeader() {
    return leader;
  }
  public void setLeader(String leader) {
    this.leader = leader;
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


}
