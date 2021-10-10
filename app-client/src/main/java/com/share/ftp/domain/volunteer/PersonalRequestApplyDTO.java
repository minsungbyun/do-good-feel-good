package com.share.ftp.domain.volunteer;

import java.util.Objects;

public class PersonalRequestApplyDTO extends GeneralRequestDTO {

  private int volNo;
  private String volStatus;

  @Override
  public String toString() {
    return "PersonalRequestApplyDTO [volNo=" + volNo + ", volStatus=" + volStatus + "]";
  }
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + Objects.hash(volNo, volStatus);
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
    PersonalRequestApplyDTO other = (PersonalRequestApplyDTO) obj;
    return volNo == other.volNo && Objects.equals(volStatus, other.volStatus);
  }
  @Override
  public int getVolNo() {
    return volNo;
  }
  @Override
  public void setVolNo(int volNo) {
    this.volNo = volNo;
  }
  public String getVolStatus() {
    return volStatus;
  }
  public void setVolStatus(String volStatus) {
    this.volStatus = volStatus;
  }




}
