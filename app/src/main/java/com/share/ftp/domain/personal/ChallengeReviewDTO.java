package com.share.ftp.domain.personal;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import com.share.ftp.domain.join.JoinDTO;


public class ChallengeReviewDTO implements Serializable {
  private static final long serialVersionUID = 1L;

  private int no;
  private int reviewNo;
  private int point;
  private String content;
  private String fileUpload;
  private Date registeredDate;
  private JoinDTO owner;




  @Override
  public String toString() {
    return "ChallengeReviewDTO [no=" + no + ", reviewNo=" + reviewNo + ", point=" + point
        + ", content=" + content + ", fileUpload=" + fileUpload + ", registeredDate="
        + registeredDate + ", owner=" + owner + "]";
  }
  @Override
  public int hashCode() {
    return Objects.hash(content, fileUpload, no, owner, point, registeredDate, reviewNo);
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ChallengeReviewDTO other = (ChallengeReviewDTO) obj;
    return Objects.equals(content, other.content) && Objects.equals(fileUpload, other.fileUpload)
        && no == other.no && Objects.equals(owner, other.owner) && point == other.point
        && Objects.equals(registeredDate, other.registeredDate) && reviewNo == other.reviewNo;
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getReviewNo() {
    return reviewNo;
  }
  public void setReviewNo(int reviewNo) {
    this.reviewNo = reviewNo;
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
  public int getPoint() {
    return point;
  }
  public void setPoint(int point) {
    this.point = point;
  }


}
