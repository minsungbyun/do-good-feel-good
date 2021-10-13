package com.share.ftp;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import com.share.ftp.table.challenge.ChallengeQuestionTable;
import com.share.ftp.table.challenge.ChallengeReviewTable;
import com.share.ftp.table.challenge.ChallengeTable;
import com.share.ftp.table.community.CommBoardReplyTable;
import com.share.ftp.table.community.CommBoardTable;
import com.share.ftp.table.community.CommReviewTable;
import com.share.ftp.table.donation.DonationBoardTable;
import com.share.ftp.table.donation.DonationRegisterTable;
import com.share.ftp.table.join.JoinTable;
import com.share.ftp.table.support.NoticeTable;
import com.share.ftp.table.support.QuestionTable;
import com.share.ftp.table.volunteer.VolGeneralTable;
import com.share.ftp.table.volunteer.VolQuestionTable;
import com.share.server.DataProcessor;
import com.share.server.RequestProcessor;

public class ServerApp {


  public static void main(String[] args) throws Exception {

    System.out.println("[happyshare 서버]");

    System.out.println("서버 실행중");
    ServerSocket serverSocket = new ServerSocket(8888);

    // RequestProcessor 가 사용할 DataProcessor 맵 준비
    HashMap<String,DataProcessor> dataProcessorMap = new HashMap<String,DataProcessor>();

    // => 데이터 처리 담당자를 등록한다.
    dataProcessorMap.put("join.", new JoinTable());

    dataProcessorMap.put("vol.", new VolGeneralTable());
    dataProcessorMap.put("volQuestion.", new VolQuestionTable());

    dataProcessorMap.put("commBoard.", new CommBoardTable());
    dataProcessorMap.put("commReview.", new CommReviewTable());
    dataProcessorMap.put("commReply.", new CommBoardReplyTable());

    dataProcessorMap.put("challenge.", new ChallengeTable());
    dataProcessorMap.put("challengeReview.", new ChallengeReviewTable());
    dataProcessorMap.put("challengeQuestion.", new ChallengeQuestionTable());

    dataProcessorMap.put("donationBoard.", new DonationBoardTable());
    dataProcessorMap.put("donationRegister.", new DonationRegisterTable());

    dataProcessorMap.put("notice.", new NoticeTable());
    dataProcessorMap.put("question.", new QuestionTable());

    while (true) {
      Socket socket = serverSocket.accept();
      System.out.println("클라이언트 접속");

      // 1) 새 실행 흐름 생성
      RequestProcessor requestProcessor = new RequestProcessor(socket, dataProcessorMap);

      // 2) 새로 생성한 실행 흐름을 시작시킨다.
      // => run()이 호출될 것이다.
      // => 시작시킨 후 즉시 리턴한다. 
      //    즉 새로 생성한 실행 흐름이 종료될 때까지 기다리지 않는다.
      requestProcessor.start();
    }

    //    System.out.println("서버 종료");
    //    serverSocket.close();

  }

}

