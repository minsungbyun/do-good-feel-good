package com.share.ftp.domain.donation;

public class DonationRegisterPayType {
  private int no;
  private String typeTitle;


  @Override
  public String toString() {
    return "DonationRegisterPayType [no=" + no + ", typeTitle=" + typeTitle + "]";
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getTypeTitle() {
    return typeTitle;
  }
  public void setTypeTitle(String typeTitle) {
    this.typeTitle = typeTitle;
  }


}
