package com.share.ftp.handler.personal.challenge;

import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class MyRankingHandler implements Command {

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[내 랭킹보기]");
    System.out.println("나의 등급: 1");
    System.out.println("나의 포인트: 100");
    System.out.println("나의 랭킹: 1위");

  }

}
