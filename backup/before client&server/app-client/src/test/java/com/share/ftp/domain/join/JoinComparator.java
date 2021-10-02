package com.share.ftp.domain.join;

import java.util.Comparator;

public class JoinComparator implements Comparator<JoinDTO> {

  @Override
  public int compare(JoinDTO firstPoint, JoinDTO secondPoint) {
    int first = firstPoint.getPoint();
    int second = secondPoint.getPoint();

    if (first > second) {
      return -1;

    } else if (first < second) {
      return 1;

    } else {
      return 0;
    }
  }



}
