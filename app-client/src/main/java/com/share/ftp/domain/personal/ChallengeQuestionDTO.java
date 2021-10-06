package com.share.ftp.domain.personal;

import java.sql.Date;
import java.util.Objects;
import com.share.ftp.domain.join.JoinDTO;


public class ChallengeQuestionDTO {

  private int no;
  private int questionNo;
  private String title;
  private String content;
  private Date registeredDate;
  private JoinDTO owner;
  private int replyCount;

  @Override
  public String toString() {
    return "ChallengeQuestionDTO [no=" + no + ", questionNo=" + questionNo + ", title=" + title
        + ", content=" + content + ", registeredDate=" + registeredDate + ", owner=" + owner
        + ", replyCount=" + replyCount + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, no, owner, questionNo, registeredDate, replyCount, title);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ChallengeQuestionDTO other = (ChallengeQuestionDTO) obj;
    return Objects.equals(content, other.content) && no == other.no
        && Objects.equals(owner, other.owner) && questionNo == other.questionNo
        && Objects.equals(registeredDate, other.registeredDate) && replyCount == other.replyCount
        && Objects.equals(title, other.title);
  }

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
