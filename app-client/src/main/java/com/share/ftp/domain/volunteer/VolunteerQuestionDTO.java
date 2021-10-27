package com.share.ftp.domain.volunteer;

import java.io.Serializable;
import java.sql.Date;
import com.share.ftp.domain.join.JoinDTO;


public class VolunteerQuestionDTO implements Serializable {
  private static final long serialVersionUID = 1L;

  private int no;
  private int questionNo;
  private String title;
  private String content;
  private Date registeredDate;
  private JoinDTO owner;
  private int replyCount;


  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getQuestionNo() {
    return questionNo;
  }
  public void setQuestionNo(int questionNo) {
    this.questionNo = questionNo;
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
  public int getReplyCount() {
    return replyCount;
  }
  public void setReplyCount(int replyCount) {
    this.replyCount = replyCount;
  }
}
