package com.share.ftp.domain.support;

import java.util.Objects;

public class QuestionAttachedFile {
  private int no;
  private String filepath;

  @Override
  public String toString() {
    return "QuestionAttachedFile [no=" + no + ", filepath=" + filepath + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(filepath, no);
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getFilepath() {
    return filepath;
  }
  public void setFilepath(String filepath) {
    this.filepath = filepath;
  }





}
