package com.share.ftp.handler.personal.challenge;

import com.share.ftp.handler.Command;

public class RankingHandler implements Command {

	@Override
	public void execute() {
		System.out.println("[이달의 전체랭킹 표시]");
		System.out.println("1위: 닉네임1");
		System.out.println("2위: 닉네임2");
		System.out.println("3위: 닉네임3");
		
	}

}
