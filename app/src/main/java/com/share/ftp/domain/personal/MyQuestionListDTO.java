package com.share.ftp.domain.personal;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import com.share.ftp.domain.join.JoinDTO;

@SuppressWarnings("serial")
public class MyQuestionListDTO implements Serializable {

  private int no;
  private String title;
  private String memberld;
  private int password;
  private String writer;
  private String content;
  private String fileUpload;
  private Date registeredDate;
  private int viewCount;
  private JoinDTO Owner;

  @Override
  public String toString() {
    return "MyQuestionListDTO [no=" + no + ", title=" + title + ", memberld=" + memberld
        + ", password=" + password + ", writer=" + writer + ", content=" + content + ", fileUpload="
        + fileUpload + ", registeredDate=" + registeredDate + ", viewCount=" + viewCount
        + ", Owner=" + Owner + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(Owner, content, fileUpload, memberld, no, password, registeredDate, title,
        viewCount, writer);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    MyQuestionListDTO other = (MyQuestionListDTO) obj;
    return Objects.equals(Owner, other.Owner) && Objects.equals(content, other.content)
        && Objects.equals(fileUpload, other.fileUpload) && Objects.equals(memberld, other.memberld)
        && no == other.no && password == other.password
        && Objects.equals(registeredDate, other.registeredDate)
        && Objects.equals(title, other.title) && viewCount == other.viewCount
        && Objects.equals(writer, other.writer);
  }

  public JoinDTO getOwner() {
    return Owner;
  }

  public void setOwner(JoinDTO owner) {
    Owner = owner;
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
  public String getMemberld() {
    return memberld;
  }
  public void setMemberld(String memberld) {
    this.memberld = memberld;
  }
  public int getPassword() {
    return password;
  }
  public void setPassword(int password) {
    this.password = password;
  }
  public String getWriter() {
    return writer;
  }
  public void setWriter(String writer) {
    this.writer = writer;
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
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }



}
