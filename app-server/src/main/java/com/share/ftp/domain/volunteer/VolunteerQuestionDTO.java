package com.share.ftp.domain.volunteer;

import java.io.Serializable;
import java.sql.Date;
import com.share.ftp.domain.join.JoinDTO;


public class VolunteerQuestionDTO implements Serializable {
  private static final long serialVersionUID = 1L;

  private int questionNo;
  private int volunteerNo;
  private int getContentCount;
  private int getReplyCount;
  private String title;
  private String content;
  private Date registeredDate;
  private JoinDTO owner;
  private String reply;
  public int getQuestionNo() {
    return questionNo;
  }
  public void setQuestionNo(int questionNo) {
    this.questionNo = questionNo;
  }
  public int getVolunteerNo() {
    return volunteerNo;
  }
  public void setVolunteerNo(int volunteerNo) {
    this.volunteerNo = volunteerNo;
  }
  public int getGetContentCount() {
    return getContentCount;
  }
  public void setGetContentCount(int getContentCount) {
    this.getContentCount = getContentCount;
  }
  public int getGetReplyCount() {
    return getReplyCount;
  }
  public void setGetReplyCount(int getReplyCount) {
    this.getReplyCount = getReplyCount;
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
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
  public JoinDTO getOwner() {
    return owner;
  }
  public void setOwner(JoinDTO owner) {
    this.owner = owner;
  }
  public String getReply() {
    return reply;
  }
  public void setReply(String reply) {
    this.reply = reply;
  }






}
