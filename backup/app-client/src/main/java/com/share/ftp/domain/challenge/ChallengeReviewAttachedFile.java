package com.share.ftp.domain.challenge;

public class ChallengeReviewAttachedFile {
  private int no;
  private String filepath;


  @Override
  public String toString() {
    return "ChallengeReviewAttachedFile [no=" + no + ", filepath=" + filepath + "]";
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
