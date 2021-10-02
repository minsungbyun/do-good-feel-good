package com.share.ftp.domain.personal;

import java.util.Objects;

public class ApproveOrgDTO {
  private int no;
  private String orgName;
  private String sort;
  private String orgCheif;
  private String tel;
  private String orgAddress;
  private String orgInfo;
  private String fileUpload;

  @Override
  public String toString() {
    return "ApproveOrgDTO [no=" + no + ", orgName=" + orgName + ", sort=" + sort + ", orgCheif="
        + orgCheif + ", tel=" + tel + ", orgAddress=" + orgAddress + ", orgInfo=" + orgInfo
        + ", fileUpload=" + fileUpload + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(fileUpload, no, orgAddress, orgCheif, orgInfo, orgName, sort, tel);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ApproveOrgDTO other = (ApproveOrgDTO) obj;
    return Objects.equals(fileUpload, other.fileUpload) && no == other.no
        && Objects.equals(orgAddress, other.orgAddress) && Objects.equals(orgCheif, other.orgCheif)
        && Objects.equals(orgInfo, other.orgInfo) && Objects.equals(orgName, other.orgName)
        && Objects.equals(sort, other.sort) && Objects.equals(tel, other.tel);
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getOrgName() {
    return orgName;
  }
  public void setOrgName(String orgName) {
    this.orgName = orgName;
  }
  public String getSort() {
    return sort;
  }
  public void setSort(String sort) {
    this.sort = sort;
  }
  public String getOrgCheif() {
    return orgCheif;
  }
  public void setOrgCheif(String orgCheif) {
    this.orgCheif = orgCheif;
  }
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  public String getOrgAddress() {
    return orgAddress;
  }
  public void setOrgAddress(String orgAddress) {
    this.orgAddress = orgAddress;
  }
  public String getOrgInfo() {
    return orgInfo;
  }
  public void setOrgInfo(String orgInfo) {
    this.orgInfo = orgInfo;
  }
  public String getFileUpload() {
    return fileUpload;
  }
  public void setFileUpload(String fileUpload) {
    this.fileUpload = fileUpload;
  }

}
