package com.share.ftp.domain.personal;

import java.sql.Date;

public class CommReviewDTO {
  public int no;
  public String content;
  //public int memberId;
  public Date registeredDate;


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
