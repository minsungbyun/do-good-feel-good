package com.share.ftp.domain.personal;

import java.sql.Date;
import java.util.Objects;

public class CommReviewDTO {
  public int no;
  public String content;
  //public int memberId;
  public Date registeredDate;

  @Override
  public String toString() {
    return "CommReviewDTO [no=" + no + ", content=" + content + ", registeredDate=" + registeredDate
        + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, no, registeredDate);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CommReviewDTO other = (CommReviewDTO) obj;
    return Objects.equals(content, other.content) && no == other.no
        && Objects.equals(registeredDate, other.registeredDate);
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }



}
