package com.share.ftp.domain.admin;

import java.sql.Date;
import java.util.List;

public class NoticeDTO {

  private int no;
  private String title;
  private String content;
  private List<NoticeAttachedFile> fileUpload;
  private Date registeredDate;
  private int viewCount;

  @Override
  public String toString() {
    return "NoticeDTO [no=" + no + ", title=" + title + ", content=" + content + ", fileUpload="
        + fileUpload + ", registeredDate=" + registeredDate + ", viewCount=" + viewCount + "]";
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
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
  public List<NoticeAttachedFile> getFileUpload() {
    return fileUpload;
  }
  public void setFileUpload(List<NoticeAttachedFile> fileUpload) {
    this.fileUpload = fileUpload;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }



}