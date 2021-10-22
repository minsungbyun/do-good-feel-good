package com.share.ftp.domain.join;

import java.io.Serializable;
import java.util.Objects;


public class GroupDTO extends JoinDTO implements Serializable {

  private static final long serialVersionUID = 2397935818210730479L;

  private int groupNo;
  private int groupCount;

  @Override
  public int hashCode() {
    return Objects.hash(groupCount);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    GroupDTO other = (GroupDTO) obj;
    return groupCount == other.groupCount;
  }



  public int getGroupNo() {
    return groupNo;
  }

  public void setGroupNo(int groupNo) {
    this.groupNo = groupNo;
  }

  @Override
  public String toString() {
    return "GroupDTO [groupCount=" + groupCount + "]";
  }

  public int getGroupCount() {
    return groupCount;
  }

  public void setGroupCount(int groupCount) {
    this.groupCount = groupCount;
  } 



}
