package com.share.ftp.domain.community;

import java.sql.Date;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;

public class VolunteerShortReviewDTO {
  private int no;
  private String content;
  private JoinDTO owner;
  private VolunteerRequestDTO volNo;
  private Date registeredDate;



  @Override
  public String toString() {
    return "VolunteerShortReviewDTO [no=" + no + ", content=" + content + ", owner=" + owner
        + ", volNo=" + volNo + ", registeredDate=" + registeredDate + "]";
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
  public JoinDTO getOwner() {
    return owner;
  }
  public void setOwner(JoinDTO owner) {
    this.owner = owner;
  }
  public VolunteerRequestDTO getVolNo() {
    return volNo;
  }
  public void setVolNo(VolunteerRequestDTO volNo) {
    this.volNo = volNo;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }



}