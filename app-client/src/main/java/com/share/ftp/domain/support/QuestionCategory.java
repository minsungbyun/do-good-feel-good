package com.share.ftp.domain.support;

import java.util.Objects;

public class QuestionCategory {

  private int no;
  private String title;

  @Override
  public int hashCode() {
    return Objects.hash(no, title);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    QuestionCategory other = (QuestionCategory) obj;
    return no == other.no && Objects.equals(title, other.title);
  }

  @Override
  public String toString() {
    return "QuestionCategory [no=" + no + ", title=" + title + "]";
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


}
