package com.share.ftp.domain.admin;

import java.util.Objects;
import com.share.ftp.domain.join.JoinDTO;

public class OrgApproveDTO {

  private int no;
  private long operatorNumber;
  private JoinDTO id;
  private String orgName;
  private String orgTel;
  private String orgAddress;
  private String exponentName;
  private String exponentTel;
  private String exponentAddress;




  @Override
  public String toString() {
    return "OrgApproveDTO [no=" + no + ", operatorNumber=" + operatorNumber + ", id=" + id
        + ", orgName=" + orgName + ", orgTel=" + orgTel + ", orgAddress=" + orgAddress
        + ", exponentName=" + exponentName + ", exponentTel=" + exponentTel + ", exponentAddress="
        + exponentAddress + "]";
  }
  @Override
  public int hashCode() {
    return Objects.hash(exponentAddress, exponentName, exponentTel, id, no, operatorNumber,
        orgAddress, orgName, orgTel);
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    OrgApproveDTO other = (OrgApproveDTO) obj;
    return Objects.equals(exponentAddress, other.exponentAddress)
        && Objects.equals(exponentName, other.exponentName)
        && Objects.equals(exponentTel, other.exponentTel) && Objects.equals(id, other.id)
        && no == other.no && operatorNumber == other.operatorNumber
        && Objects.equals(orgAddress, other.orgAddress) && Objects.equals(orgName, other.orgName)
        && Objects.equals(orgTel, other.orgTel);
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public long getOperatorNumber() {
    return operatorNumber;
  }
  public void setOperatorNumber(long operatorNumber) {
    this.operatorNumber = operatorNumber;
  }
  public String getOrgName() {
    return orgName;
  }
  public void setOrgName(String orgName) {
    this.orgName = orgName;
  }
  public String getOrgTel() {
    return orgTel;
  }
  public void setOrgTel(String orgTel) {
    this.orgTel = orgTel;
  }
  public String getOrgAddress() {
    return orgAddress;
  }
  public void setOrgAddress(String orgAddress) {
    this.orgAddress = orgAddress;
  }
  public String getExponentName() {
    return exponentName;
  }
  public void setExponentName(String exponentName) {
    this.exponentName = exponentName;
  }
  public String getExponentTel() {
    return exponentTel;
  }
  public void setExponentTel(String exponentTel) {
    this.exponentTel = exponentTel;
  }
  public String getExponentAddress() {
    return exponentAddress;
  }
  public void setExponentAddress(String exponentAddress) {
    this.exponentAddress = exponentAddress;
  }
  public JoinDTO getId() {
    return id;
  }
  public void setId(JoinDTO id) {
    this.id = id;
  }



}
