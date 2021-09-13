package com.share.ftp.domain.admin;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import com.share.ftp.domain.join.JoinDTO;

@SuppressWarnings("serial")
public class CommentDTO implements Serializable{

  private int commentNo;
  private String adminId;
  private String content;
  private JoinDTO admin;
  private Date registeredDate;



  @Override
  public int hashCode() {
    return Objects.hash(admin, adminId, commentNo, content, registeredDate);
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CommentDTO other = (CommentDTO) obj;
    return Objects.equals(admin, other.admin) && Objects.equals(adminId, other.adminId)
        && commentNo == other.commentNo && Objects.equals(content, other.content)
        && Objects.equals(registeredDate, other.registeredDate);
  }
  @Override
  public String toString() {
    return "CommentDTO [commentNo=" + commentNo + ", adminId=" + adminId + ", content=" + content
        + ", admin=" + admin + ", registeredDate=" + registeredDate + "]";
  }
  public int getCommentNo() {
    return commentNo;
  }
  public void setCommentNo(int commentNo) {
    this.commentNo = commentNo;
  }
  public String getAdminId() {
    return adminId;
  }
  public void setAdminId(String adminId) {
    this.adminId = adminId;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public JoinDTO getAdmin() {
    return admin;
  }
  public void setAdmin(JoinDTO admin) {
    this.admin = admin;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }




}