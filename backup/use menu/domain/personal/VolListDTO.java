package com.share.ftp.domain.personal;

import java.util.Objects;

public class VolListDTO {

  private String title;
  private String content;
  private String location;
  private String detail;

  @Override
  public String toString() {
    return "VolListDTO [title=" + title + ", content=" + content + ", location=" + location
        + ", detail=" + detail + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(content, detail, location, title);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    VolListDTO other = (VolListDTO) obj;
    return Objects.equals(content, other.content) && Objects.equals(detail, other.detail)
        && Objects.equals(location, other.location) && Objects.equals(title, other.title);
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
  public String getLocation() {
    return location;
  }
  public void setLocation(String location) {
    this.location = location;
  }
  public String getDetail() {
    return detail;
  }
  public void setDetail(String detail) {
    this.detail = detail;
  }







}
