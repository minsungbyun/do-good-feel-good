package com.share.ftp.domain.personal;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import com.share.ftp.domain.join.JoinDTO;

@SuppressWarnings("serial")
public class CommBoardReplyDTO implements Serializable {

  private int commReplyNo;
  private String Commentid;
  private String Commentcontent;
  private Date registeredDate;
  private JoinDTO owner;


  @Override
  public String toString() {
    return "CommBoardReplyDTO [commReplyNo=" + commReplyNo + ", Commentid=" + Commentid
        + ", Commentcontent=" + Commentcontent + ", registeredDate=" + registeredDate + ", owner="
        + owner + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(Commentcontent, Commentid, commReplyNo, owner, registeredDate);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CommBoardReplyDTO other = (CommBoardReplyDTO) obj;
    return Objects.equals(Commentcontent, other.Commentcontent)
        && Objects.equals(Commentid, other.Commentid) && commReplyNo == other.commReplyNo
        && Objects.equals(owner, other.owner)
        && Objects.equals(registeredDate, other.registeredDate);
  }
  public int getCommReplyNo() {
    return commReplyNo;
  }
  public void setCommReplyNo(int commReplyNo) {
    this.commReplyNo = commReplyNo;
  }
  public String getCommentid() {
    return Commentid;
  }
  public void setCommentid(String commentid) {
    Commentid = commentid;
  }
  public String getCommentcontent() {
    return Commentcontent;
  }
  public void setCommentcontent(String commentcontent) {
    Commentcontent = commentcontent;
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



}