package com.share.ftp.domain.donation;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.share.ftp.domain.Category;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.join.OrgDTO;

public class DonationBoardDTO {

  private int no;
  private int orgNo;
  private Category category;
  private OrgDTO leader;
  private String title;
  private String content;
  private String tel;
  private String email;
  private Date startDate;
  private Date endDate;
  private String totalDate;
  private String remainDate;
  private long moneyTarget;
  private int status;
  private String note;
  private List<DonationBoardAttachedFile> fileUpload = new ArrayList<>();
  private List<JoinDTO> members = new ArrayList<>();




  @Override
  public String toString() {
    return "DonationBoardDTO [no=" + no + ", orgNo=" + orgNo + ", category=" + category
        + ", leader=" + leader + ", title=" + title + ", content=" + content + ", tel=" + tel
        + ", email=" + email + ", startDate=" + startDate + ", endDate=" + endDate + ", totalDate="
        + totalDate + ", remainDate=" + remainDate + ", moneyTarget=" + moneyTarget + ", status="
        + status + ", note=" + note + ", fileUpload=" + fileUpload + ", members=" + members + "]";
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getOrgNo() {
    return orgNo;
  }
  public void setOrgNo(int orgNo) {
    this.orgNo = orgNo;
  }
  public Category getCategory() {
    return category;
  }
  public void setCategory(Category category) {
    this.category = category;
  }
  public OrgDTO getLeader() {
    return leader;
  }
  public void setLeader(OrgDTO leader) {
    this.leader = leader;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public Date getStartDate() {
    return startDate;
  }
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  public Date getEndDate() {
    return endDate;
  }
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
  public String getTotalDate() {
    return totalDate;
  }
  public void setTotalDate(String totalDate) {
    this.totalDate = totalDate;
  }
  public String getRemainDate() {
    return remainDate;
  }
  public void setRemainDate(String remainDate) {
    this.remainDate = remainDate;
  }
  public long getMoneyTarget() {
    return moneyTarget;
  }
  public void setMoneyTarget(long moneyTarget) {
    this.moneyTarget = moneyTarget;
  }
  public int getStatus() {
    return status;
  }
  public void setStatus(int status) {
    this.status = status;
  }
  public String getNote() {
    return note;
  }
  public void setNote(String note) {
    this.note = note;
  }
  public List<DonationBoardAttachedFile> getFileUpload() {
    return fileUpload;
  }
  public void setFileUpload(List<DonationBoardAttachedFile> fileUpload) {
    this.fileUpload = fileUpload;
  }
  public List<JoinDTO> getMembers() {
    return members;
  }
  public void setMembers(List<JoinDTO> members) {
    this.members = members;
  }

  public String getFileNames() {
    if (this.members == null) {
      return "";
    }

    StringBuilder names = new StringBuilder();
    for (DonationBoardAttachedFile file : this.fileUpload) {
      if (names.length() > 0) {
        names.append(", ");
      }
      names.append(file.getFilepath());
    }
    return names.toString();
  }
}
