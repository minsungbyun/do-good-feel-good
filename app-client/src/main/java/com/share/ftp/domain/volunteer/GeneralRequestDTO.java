package com.share.ftp.domain.volunteer;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.share.ftp.domain.join.JoinDTO;


public abstract class GeneralRequestDTO {

  private int volNo;
  private int volMemberType; 
  private String volTitle;
  private String volName;
  private String volStatus;
  private JoinDTO volOwner; 
  private String volType;
  private String volTel;
  private String volEmail;
  private Date volStartDate;
  private Date volEndDate;
  private String volStartTime;
  private String volEndTime;
  private String volContent;
  private String volFileUpload;
  private Date volSubmitTime; 
  private int volLimitNum; // 총 정원
  private int volTotalJoinCount = 1; // 현재 참여 인원 (주최자는 미리 포함)
  private List<JoinDTO> volMembers = new ArrayList<>(); // 봉사 참여한 멤버들


  @Override
  public int hashCode() {
    return Objects.hash(volContent, volEmail, volEndDate, volEndTime, volFileUpload, volLimitNum,
        volMemberType, volMembers, volName, volNo, volOwner, volStartDate, volStartTime, volStatus,
        volSubmitTime, volTel, volTitle, volTotalJoinCount, volType);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    GeneralRequestDTO other = (GeneralRequestDTO) obj;
    return Objects.equals(volContent, other.volContent) && Objects.equals(volEmail, other.volEmail)
        && Objects.equals(volEndDate, other.volEndDate)
        && Objects.equals(volEndTime, other.volEndTime)
        && Objects.equals(volFileUpload, other.volFileUpload) && volLimitNum == other.volLimitNum
        && volMemberType == other.volMemberType && Objects.equals(volMembers, other.volMembers)
        && Objects.equals(volName, other.volName) && volNo == other.volNo
        && Objects.equals(volOwner, other.volOwner)
        && Objects.equals(volStartDate, other.volStartDate)
        && Objects.equals(volStartTime, other.volStartTime)
        && Objects.equals(volStatus, other.volStatus)
        && Objects.equals(volSubmitTime, other.volSubmitTime)
        && Objects.equals(volTel, other.volTel) && Objects.equals(volTitle, other.volTitle)
        && volTotalJoinCount == other.volTotalJoinCount && Objects.equals(volType, other.volType);
  }

  @Override
  public String toString() {
    return "GeneralRequestDTO [volNo=" + volNo + ", volMemberType=" + volMemberType + ", volTitle="
        + volTitle + ", volName=" + volName + ", volStatus=" + volStatus + ", volOwner=" + volOwner
        + ", volType=" + volType + ", volTel=" + volTel + ", volEmail=" + volEmail
        + ", volStartDate=" + volStartDate + ", volEndDate=" + volEndDate + ", volStartTime="
        + volStartTime + ", volEndTime=" + volEndTime + ", volContent=" + volContent
        + ", volFileUpload=" + volFileUpload + ", volSubmitTime=" + volSubmitTime + ", volLimitNum="
        + volLimitNum + ", volTotalJoinCount=" + volTotalJoinCount + ", volMembers=" + volMembers
        + "]";
  }

  public int getVolNo() {
    return volNo;
  }

  public void setVolNo(int volNo) {
    this.volNo = volNo;
  }

  public int getVolMemberType() {
    return volMemberType;
  }

  public void setVolMemberType(int memberType) {
    this.volMemberType = memberType;
  }

  public String getVolTitle() {
    return volTitle;
  }

  public void setVolTitle(String volTitle) {
    this.volTitle = volTitle;
  }

  public String getVolName() {
    return volName;
  }

  public void setVolName(String volName) {
    this.volName = volName;
  }

  public JoinDTO getVolOwner() {
    return volOwner;
  }

  public void setOwner(JoinDTO volOwner) {
    this.volOwner = volOwner;
  }


  public String getVolType() {
    return volType;
  }

  public void setVolType(String volType) {
    this.volType = volType;
  }

  public String getVolTel() {
    return volTel;
  }

  public void setVolTel(String volTel) {
    this.volTel = volTel;
  }

  public String getVolEmail() {
    return volEmail;
  }

  public void setVolEmail(String volEmail) {
    this.volEmail = volEmail;
  }

  public Date getVolStartDate() {
    return volStartDate;
  }

  public void setVolStartDate(Date volStartDate) {
    this.volStartDate = volStartDate;
  }

  public Date getVolEndDate() {
    return volEndDate;
  }

  public void setVolEndDate(Date volEndDate) {
    this.volEndDate = volEndDate;
  }

  public String getVolStartTime() {
    return volStartTime;
  }

  public void setVolStartTime(String volStartTime) {
    this.volStartTime = volStartTime;
  }

  public String getVolEndTime() {
    return volEndTime;
  }

  public void setVolEndTime(String volEndTime) {
    this.volEndTime = volEndTime;
  }

  public int getVolLimitNum() {
    return volLimitNum;
  }

  public void setVolLimitNum(int volLimitNum) {
    this.volLimitNum = volLimitNum;
  }

  public String getVolContent() {
    return volContent;
  }

  public void setVolContent(String volContent) {
    this.volContent = volContent;
  }

  public String getVolFileUpload() {
    return volFileUpload;
  }

  public void setVolFileUpload(String volFileUpload) {
    this.volFileUpload = volFileUpload;
  }


  public Date getVolSubmitTime() {
    return volSubmitTime;
  }

  public void setVolSubmitTime(Date volSubmitTime) {
    this.volSubmitTime = volSubmitTime;
  }


  public int getVolTotalJoinCount() {
    return volTotalJoinCount;
  }

  public void setVolTotalJoinCount(int volTotalJoinCount) {
    this.volTotalJoinCount = volTotalJoinCount;
  }

  public List<JoinDTO> getVolMembers() {
    return volMembers;
  }

  public void setMembers(List<JoinDTO> volMembers) {
    this.volMembers = volMembers;
  }


  public void addVolMembers(JoinDTO volMember) {
    this.volMembers.add(volMember);
  }

  public void removeMembers(JoinDTO volMember) {
    this.volMembers.remove(volMember);
  }


  public String getVolMemberNames() {
    if (volMembers == null) {
      return "";
    }
    StringBuilder names = new StringBuilder();


    for (JoinDTO joinDTO : volMembers) {
      if (names.length() > 0) {
        names.append("\n");
      }
      names.append(joinDTO.getId()).append("("+joinDTO.getName()+")");
    }
    return names.toString();
  }


}