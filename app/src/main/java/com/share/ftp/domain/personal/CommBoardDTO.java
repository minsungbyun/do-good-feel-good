package com.share.ftp.domain.personal;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;
import com.share.ftp.domain.join.JoinDTO;

@SuppressWarnings("serial")
public class CommBoardDTO implements Serializable/*, Comparable<CommBoardDTO> */{

  private int commNo;
  private int replyCount;
  private String title;
  private String id;
  private String content;
  private String fileUpload;
  private String password;
  private Date registeredDate;
  private JoinDTO owner;
  private int like;
  private int viewCount;
  private List<CommBoardReplyDTO> commentList;


  @Override
  public String toString() {
    return "CommBoardDTO [commNo=" + commNo + ", replyCount=" + replyCount + ", title=" + title
        + ", id=" + id + ", content=" + content + ", fileUpload=" + fileUpload + ", password="
        + password + ", registeredDate=" + registeredDate + ", owner=" + owner + ", like=" + like
        + ", viewCount=" + viewCount + ", commentList=" + commentList + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(commNo, commentList, content, fileUpload, id, like, owner, password,
        registeredDate, replyCount, title, viewCount);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CommBoardDTO other = (CommBoardDTO) obj;
    return commNo == other.commNo && Objects.equals(commentList, other.commentList)
        && Objects.equals(content, other.content) && Objects.equals(fileUpload, other.fileUpload)
        && Objects.equals(id, other.id) && like == other.like && Objects.equals(owner, other.owner)
        && Objects.equals(password, other.password)
        && Objects.equals(registeredDate, other.registeredDate) && replyCount == other.replyCount
        && Objects.equals(title, other.title) && viewCount == other.viewCount;
  }

  public int getCommNo() {
    return commNo;
  }
  public void setCommNo(int commNo) {
    this.commNo = commNo;
  }
  public int getReplyCount() {
    return replyCount;
  }
  public void setReplyCount(int replyCount) {
    this.replyCount = replyCount;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
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
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
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
  public int getLike() {
    return like;
  }
  public void setLike(int like) {
    this.like = like;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
  public List<CommBoardReplyDTO> getCommentList() {
    return commentList;
  }
  public void setCommentList(List<CommBoardReplyDTO> commentList) {
    this.commentList = commentList;
  }
}

