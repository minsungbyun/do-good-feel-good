package com.share.ftp.domain.community;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import com.share.ftp.domain.join.JoinDTO;

@SuppressWarnings("serial")
public class CommBoardReplyDTO implements Serializable {

  private int commNo;
  private int commReplyNo;
  private String Commentid;
  private String Commentcontent;
  private Date registeredDate;
  private JoinDTO owner;
  private int commReplyPassword;


  @Override
  public String toString() {
    return "CommBoardReplyDTO [commNo=" + commNo + ", commReplyNo=" + commReplyNo + ", Commentid="
        + Commentid + ", Commentcontent=" + Commentcontent + ", registeredDate=" + registeredDate
        + ", owner=" + owner + ", commReplyPassword=" + commReplyPassword + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(Commentcontent, Commentid, commNo, commReplyNo, commReplyPassword, owner,
        registeredDate);
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
        && Objects.equals(Commentid, other.Commentid) && commNo == other.commNo
        && commReplyNo == other.commReplyNo && commReplyPassword == other.commReplyPassword
        && Objects.equals(owner, other.owner)
        && Objects.equals(registeredDate, other.registeredDate);
  }

  public int getCommNo() {
    return commNo;
  }
  public void setCommNo(int commNo) {
    this.commNo = commNo;
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
  public int getCommReplyPassword() {
    return commReplyPassword;
  }
  public void setCommReplyPassword(int commReplyPassword) {
    this.commReplyPassword = commReplyPassword;
  }
}