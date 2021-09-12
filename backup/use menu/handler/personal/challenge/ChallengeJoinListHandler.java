package com.share.ftp.handler.personal.challenge;

import com.share.ftp.handler.Command;

public class ChallengeJoinListHandler implements Command {

  @Override
  public void execute() {
    System.out.println();
    System.out.println("참여자 목록");
    System.out.println("1. 닉네임1");
    System.out.println("2. 닉네임2");
    System.out.println("3. 닉네임3");
    
  }

}
