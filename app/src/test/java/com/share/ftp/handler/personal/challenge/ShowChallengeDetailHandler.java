package com.share.ftp.handler.personal.challenge;

import com.share.ftp.handler.Command;

public class ShowChallengeDetailHandler implements Command {

  @Override
  public void execute() {
    System.out.println();
    System.out.println("챌린지에 도전해보세요!");
    System.out.println("이 챌린지에는 --포인트가 걸려있습니다.");
    System.out.println("챌린지 참여방법은 ---입니다!");
    
  }

}
