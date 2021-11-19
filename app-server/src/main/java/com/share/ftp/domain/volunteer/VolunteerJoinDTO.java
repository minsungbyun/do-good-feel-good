package com.share.ftp.domain.volunteer;

import java.sql.Date;
import com.share.ftp.domain.join.JoinDTO;


public class VolunteerJoinDTO {

  private JoinDTO joinUser;
  private VolunteerRequestDTO volunteer;
  private Date applyDate;
  private String startTime;
  private String endTime;
  private int status;
  private Date registeredDate;
  private String note;

  @Override
  public String toString() {
    return "VolunteerJoinDTO [joinUser=" + joinUser + ", volunteerNo=" + volunteer
        + ", applyDate=" + applyDate + ", startTime=" + startTime + ", endTime=" + endTime
        + ", status=" + status + ", registeredDate=" + registeredDate + ", note=" + note + "]";
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

  public Date getApplyDate() {
    return applyDate;
  }
  public void setApplyDate(Date applyDate) {
    this.applyDate = applyDate;
  }
  public String getStartTime() {
    return startTime;
  }
  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }
  public String getEndTime() {
    return endTime;
  }
  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }
  public int getStatus() {
    return status;
  }
  public void setStatus(int status) {
    this.status = status;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
  public String getNote() {
    return note;
  }
  public void setNote(String note) {
    this.note = note;
  }




}

