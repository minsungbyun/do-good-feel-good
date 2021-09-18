package com.share.ftp.domain.personal;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import com.share.ftp.domain.join.JoinDTO;

@SuppressWarnings("serial")
public class QuestionListDTO implements Serializable {

  private int No;
  private String title;
  private String memberld;
  private String password;
  private String writer;
  private String content;
  private String fileUpload;
  private Date registeredDate;
  private int viewCount;
  private JoinDTO Owner;

  private String sort;
  private String volunteerAsk = "함께해요 문의";
  private String commuityAsk = "나눔이야기 문의";
  private String donationAsk = "모금함 문의";
  private String challengeAsk = "챌린지 문의";
  private String siteAsk = "사이트이용 문의";
  private String otherAsk = "기타 문의";


  @Override
  public int hashCode() {
    return Objects.hash(No, Owner, challengeAsk, commuityAsk, content, donationAsk, fileUpload,
        memberld, otherAsk, password, registeredDate, siteAsk, sort, title, viewCount, volunteerAsk,
        writer);
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    QuestionListDTO other = (QuestionListDTO) obj;
    return No == other.No && Objects.equals(Owner, other.Owner)
        && Objects.equals(challengeAsk, other.challengeAsk)
        && Objects.equals(commuityAsk, other.commuityAsk) && Objects.equals(content, other.content)
        && Objects.equals(donationAsk, other.donationAsk)
        && Objects.equals(fileUpload, other.fileUpload) && Objects.equals(memberld, other.memberld)
        && Objects.equals(otherAsk, other.otherAsk) && password == other.password
        && Objects.equals(registeredDate, other.registeredDate)
        && Objects.equals(siteAsk, other.siteAsk) && Objects.equals(sort, other.sort)
        && Objects.equals(title, other.title) && viewCount == other.viewCount
        && Objects.equals(volunteerAsk, other.volunteerAsk) && Objects.equals(writer, other.writer);
  }
  @Override
  public String toString() {
    return "QuestionListDTO [No=" + No + ", title=" + title + ", memberld=" + memberld
        + ", password=" + password + ", writer=" + writer + ", content=" + content + ", fileUpload="
        + fileUpload + ", registeredDate=" + registeredDate + ", viewCount=" + viewCount
        + ", Owner=" + Owner + ", sort=" + sort + ", volunteerAsk=" + volunteerAsk
        + ", commuityAsk=" + commuityAsk + ", donationAsk=" + donationAsk + ", challengeAsk="
        + challengeAsk + ", siteAsk=" + siteAsk + ", otherAsk=" + otherAsk + "]";
  }
  public int getNo() {
    return No;
  }
  public void setNo(int no) {
    No = no;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getMemberld() {
    return memberld;
  }
  public void setMemberld(String memberld) {
    this.memberld = memberld;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getWriter() {
    return writer;
  }
  public void setWriter(String writer) {
    this.writer = writer;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public String getFileUpload() {
    return fileUpload;
  }
  public void setFileUpload(String fileUpload) {
    this.fileUpload = fileUpload;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
  public JoinDTO getOwner() {
    return Owner;
  }
  public void setOwner(JoinDTO owner) {
    Owner = owner;
  }
  public String getSort() {
    return sort;
  }
  public void setSort(String sort) {
    this.sort = sort;
  }
  public String getVolunteerAsk() {
    return volunteerAsk;
  }
  public void setVolunteerAsk(String volunteerAsk) {
    this.volunteerAsk = volunteerAsk;
  }
  public String getCommuityAsk() {
    return commuityAsk;
  }
  public void setCommuityAsk(String commuityAsk) {
    this.commuityAsk = commuityAsk;
  }
  public String getDonationAsk() {
    return donationAsk;
  }
  public void setDonationAsk(String donationAsk) {
    this.donationAsk = donationAsk;
  }
  public String getChallengeAsk() {
    return challengeAsk;
  }
  public void setChallengeAsk(String challengeAsk) {
    this.challengeAsk = challengeAsk;
  }
  public String getSiteAsk() {
    return siteAsk;
  }
  public void setSiteAsk(String siteAsk) {
    this.siteAsk = siteAsk;
  }
  public String getOtherAsk() {
    return otherAsk;
  }
  public void setOtherAsk(String otherAsk) {
    this.otherAsk = otherAsk;
  }




}
