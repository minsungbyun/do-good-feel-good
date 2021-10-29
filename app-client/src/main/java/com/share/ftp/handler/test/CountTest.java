package com.share.ftp.handler.test;

import com.share.ftp.domain.volunteer.VolunteerRequestDTO;

public class CountTest {

  public static void main(String[] args) {

    int num = VolunteerRequestDTO.questionCount;
    num++;


    System.out.println(num);

  }

}
