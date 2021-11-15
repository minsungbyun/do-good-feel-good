package com.share.ftp.domain.join;

public class OrgDTO extends JoinDTO {

  private int orgNo;
  private String corpNo;
  private String fax;
  private String homepage;

  @Override
  public String toString() {
    return "OrgDTO [orgNo=" + orgNo + ", corpNo=" + corpNo + ", fax=" + fax + ", homepage="
        + homepage + "]";
  }

  public int getOrgNo() {
    return orgNo;
  }
  public void setOrgNo(int orgNo) {
    this.orgNo = orgNo;
  }
  public String getCorpNo() {
    return corpNo;
  }
  public void setCorpNo(String corpNo) {
    this.corpNo = corpNo;
  }
  public String getFax() {
    return fax;
  }
  public void setFax(String fax) {
    this.fax = fax;
  }
  public String getHomepage() {
    return homepage;
  }
  public void setHomepage(String homepage) {
    this.homepage = homepage;
  }
}
