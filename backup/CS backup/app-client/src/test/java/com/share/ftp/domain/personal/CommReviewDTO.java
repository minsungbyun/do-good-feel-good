package com.share.ftp.domain.personal;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import com.share.ftp.domain.join.JoinDTO;

@SuppressWarnings("serial")
public class CommReviewDTO implements Serializable {
  private int commReviewNo;
  private String content;
  private JoinDTO owner;
  private Date registeredDate;



  @Override
  public String toString() {
    return "CommReviewDTO [no=" + commReviewNo + ", content=" + content + ", owner=" + owner
        + ", registeredDate=" + registeredDate + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, commReviewNo, owner, registeredDate);
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
    return Objects.equals(content, other.content) && commReviewNo == other.commReviewNo
        && Objects.equals(owner, other.owner)
        && Objects.equals(registeredDate, other.registeredDate);
  }
  public int getNo() {
    return commReviewNo;
  }
  public void setNo(int no) {
    this.commReviewNo = no;
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
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }


}