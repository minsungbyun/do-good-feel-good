package com.share.ftp.domain.join;

import java.util.Comparator;

public class JoinComparator implements Comparator<JoinDTO> {
  @Override
  public int compare(JoinDTO o1, JoinDTO o2) {
    int frist = Integer.valueOf(o1.getPoint());
    int second = Integer.valueOf(o2.getPoint());

    if (frist > second) {
      return -1;
    } else if (frist < second) {
      return 1;
    } else {
      return 0;
    }
  }

}
