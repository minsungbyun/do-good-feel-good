package com.share.ftp.domain.volunteer;

import java.sql.Date;
import com.share.ftp.domain.join.JoinDTO;


public class VolunteerQuestionDTO {

  private int no;
  private JoinDTO joinUser;
  private VolunteerRequestDTO volunteer;
  private String content;
  private Date registeredDate;
  private String reply;


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
  public String getReply() {
    return reply;
  }
  public void setReply(String reply) {
    this.reply = reply;
  }
  public JoinDTO getJoinUser() {
    return joinUser;
  }
  public void setJoinUser(JoinDTO joinUser) {
    this.joinUser = joinUser;
  }
  public VolunteerRequestDTO getVolunteer() {
    return volunteer;
  }
  public void setVolunteer(VolunteerRequestDTO volunteer) {
    this.volunteer = volunteer;
  }





}
