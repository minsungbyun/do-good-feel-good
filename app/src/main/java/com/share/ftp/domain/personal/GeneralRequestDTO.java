package com.share.ftp.domain.personal;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.share.ftp.domain.join.JoinDTO;


public class GeneralRequestDTO implements Serializable {


  private static final long serialVersionUID = 1L;


  private int volNo;
  private String volTitle;
  private String volName;
  private JoinDTO owner; // 주최자
  private String ownerId;
  private String volType;
  private String volTel;
  private String volEmail;
  private Date volStartDate;
  private Date volEndDate;
  private String volStartTime;
  private String volEndTime;
  //  private String volList; // 봉사 api 지금은 필요없을 것 같아 닫아놓음
  private int volLimitNum; // 총 정원
  private String volContent;
  private String volFileUpload;

  private boolean isPersonal; // true 개인 , false 기관
  private String isSigned = "승인대기"; // 관리자 승인 여부확인
  private Date volSubmitTime; // 봉사 신청서 제출 시간
  private List<JoinDTO> members = new ArrayList<>(); // 봉사 참여한 멤버들
  private int totalJoinCount = 1; // 현재 참여 인원 (주최자는 미리 포함)





  @Override
  public String toString() {
    return "PersonalRequestDTO [volNo=" + volNo + ", volTitle=" + volTitle + ", volName=" + volName
        + ", owner=" + owner + ", ownerId=" + ownerId + ", volSort=" + volType + ", volTel="
        + volTel + ", volEmail=" + volEmail + ", volStartDate=" + volStartDate + ", volEndDate="
        + volEndDate + ", volStartTime=" + volStartTime + ", volEndTime=" + volEndTime
        + ", volLimitNum=" + volLimitNum + ", volContent=" + volContent + ", volFileUpload="
        + volFileUpload + ", isPersonal=" + isPersonal +  ", isSigned="
        + isSigned + ", volSubmitTime=" + volSubmitTime + ", members=" + members
        + ", totalJoinCount=" + totalJoinCount + "]";
  }


  @Override
  public int hashCode() {
    return Objects.hash( isPersonal, isSigned, members, owner, ownerId, totalJoinCount,
        volContent, volEmail, volEndDate, volEndTime, volFileUpload, volLimitNum, volName, volNo,
        volType, volStartDate, volStartTime, volSubmitTime, volTel, volTitle);
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
    return isPersonal == other.isPersonal
        && Objects.equals(isSigned, other.isSigned) && Objects.equals(members, other.members)
        && Objects.equals(owner, other.owner) && Objects.equals(ownerId, other.ownerId)
        && totalJoinCount == other.totalJoinCount && Objects.equals(volContent, other.volContent)
        && Objects.equals(volEmail, other.volEmail) && Objects.equals(volEndDate, other.volEndDate)
        && Objects.equals(volEndTime, other.volEndTime)
        && Objects.equals(volFileUpload, other.volFileUpload) && volLimitNum == other.volLimitNum
        && Objects.equals(volName, other.volName) && volNo == other.volNo
        && Objects.equals(volType, other.volType)
        && Objects.equals(volStartDate, other.volStartDate)
        && Objects.equals(volStartTime, other.volStartTime)
        && Objects.equals(volSubmitTime, other.volSubmitTime)
        && Objects.equals(volTel, other.volTel) && Objects.equals(volTitle, other.volTitle);
  }





  public int getVolNo() {
    return volNo;
  }


  public void setVolNo(int volNo) {
    this.volNo = volNo;
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


  public JoinDTO getOwner() {
    return owner;
  }


  public void setOwner(JoinDTO owner) {
    this.owner = owner;
  }


  public String getOwnerId() {
    return ownerId;
  }


  public void setOwnerId(String ownerId) {
    this.ownerId = ownerId;
  }


  public String getVolType() {
    return volType;
  }


  public void setVolType(String volSort) {
    this.volType = volSort;
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


  public boolean isPersonal() {
    return isPersonal;
  }


  public void setPersonal(boolean isPersonal) {
    this.isPersonal = isPersonal;
  }





  public String getIsSigned() {
    return isSigned;
  }


  public void setIsSigned(String isSigned) {
    this.isSigned = isSigned;
  }


  public Date getVolSubmitTime() {
    return volSubmitTime;
  }


  public void setVolSubmitTime(Date volSubmitTime) {
    this.volSubmitTime = volSubmitTime;
  }


  public List<JoinDTO> getMembers() {
    return members;
  }


  public void setMembers(List<JoinDTO> members) {
    this.members = members;
  }


  public int getTotalJoinCount() {
    return totalJoinCount;
  }


  public void setTotalJoinCount(int totalJoinCount) {
    this.totalJoinCount = totalJoinCount;
  }


  public void addMembers(JoinDTO member) {
    this.members.add(member);
  }

  public void removeMembers(JoinDTO member) {
    this.members.remove(member);
  }


  public String getMemberNames() {
    if (members == null) {
      return "";
    }
    StringBuilder names = new StringBuilder();
    for (JoinDTO joinDTO : members) {
      if (names.length() > 0) {
        names.append("\n");
      }
      names.append(joinDTO.getId()).append("("+joinDTO.getName()+")");
    }
    return names.toString();
  }



}