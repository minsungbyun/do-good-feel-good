package com.share.ftp.domain.volunteer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.share.ftp.domain.join.JoinDTO;


public class OrgRequestDTO extends GeneralRequestDTO {

  private int volNo;
  private List<JoinDTO> volMembers = new ArrayList<>(); // 봉사 참여한 멤버들


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + Objects.hash(volMembers, volNo);
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
    OrgRequestDTO other = (OrgRequestDTO) obj;
    return Objects.equals(volMembers, other.volMembers) && volNo == other.volNo;
  }

  @Override
  public String toString() {
    return "OrgRequestDTO [volNo=" + volNo + ", volMembers=" + volMembers + "]";
  }

  @Override
  public int getVolNo() {
    return volNo;
  }

  @Override
  public void setVolNo(int volNo) {
    this.volNo = volNo;
  }

  @Override
  public List<JoinDTO> getVolMembers() {
    return volMembers;
  }

  @Override
  public void setMembers(List<JoinDTO> volMembers) {
    this.volMembers = volMembers;
  }


  @Override
  public void addVolMembers(JoinDTO volMember) {
    this.volMembers.add(volMember);
  }

  @Override
  public void removeMembers(JoinDTO volMember) {
    this.volMembers.remove(volMember);
  }


  @Override
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