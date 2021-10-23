package com.share.ftp.domain.join;

import java.io.Serializable;
import java.util.Objects;


public class OrgDTO extends JoinDTO implements Serializable {

  private static final long serialVersionUID = 2397935818210730479L;

  private String corpNo;
  private String fax;
  private String homepage;


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + Objects.hash(corpNo, fax, homepage);
    return result;
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    OrgDTO other = (OrgDTO) obj;
    return Objects.equals(corpNo, other.corpNo) && Objects.equals(fax, other.fax)
        && Objects.equals(homepage, other.homepage);
  }


  @Override
  public String toString() {
    return "OrgDTO [corpNo=" + corpNo + ", fax=" + fax + ", homepage=" + homepage + "]";
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
