package com.share.ftp.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.share.ftp.dao.CommBoardDao;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.request.RequestAgent;

// 게시글 데이터를 서버를 통해 관리한다.

public class NetCommBoardDao implements CommBoardDao {

  RequestAgent requestAgent;

  public NetCommBoardDao(RequestAgent requestAgent) {
    this.requestAgent = requestAgent;
  }

  @Override
  public void insert(CommBoardDTO addCommBoard) throws Exception {
    requestAgent.request("commBoard.insert", addCommBoard);

    if (requestAgent.getStatus().equals(RequestAgent.SUCCESS)) {
      System.out.println("[ 게시글 등록이 정상적으로 완료되었습니다! ]");

    } else {
      throw new Exception("게시글 등록 실패!");
    }
  }

  @Override
  public List<CommBoardDTO> findAll() throws Exception {

    requestAgent.request("commBoard.selectList", null);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("게시글 목록 조회 실패!");
    }
    return new ArrayList<>(requestAgent.getObjects(CommBoardDTO.class));
  }

  @Override
  public List<CommBoardDTO> findByKeyword(String keyword) throws Exception {
    HashMap<String,String> params = new HashMap<>();
    params.put("keyword", keyword);
    requestAgent.request("commBoard.selectListByKeyword", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("게시글 검색 실패!");
    }

    return new ArrayList<>(requestAgent.getObjects(CommBoardDTO.class));
  }

  @Override
  public CommBoardDTO findByCommNo(int commBoardNo) throws Exception {
    HashMap<String,String> params = new HashMap<>();
    params.put("commBoardNo", String.valueOf(commBoardNo));

    requestAgent.request("commBoard.selectOne", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      return null;
    }

    return requestAgent.getObject(CommBoardDTO.class);
  }


  @Override
  public void update(CommBoardDTO updateCommBoard) throws Exception {
    requestAgent.request("commBoard.update", updateCommBoard);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("게시글 변경 실패!");
    }

  }

  @Override
  public void delete(int deleteCommBoardNo) throws Exception {

    HashMap<String,String> params = new HashMap<>();
    params.put("deleteCommBoardNo", String.valueOf(deleteCommBoardNo));

    requestAgent.request("commBoard.delete", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("게시글 삭제 실패!");
    }
  }

  @Override
  public int getNextNum() throws Exception {

    requestAgent.request("commBoard.getNextNum", null);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("게시글 번호 부여 중 오류 발생!");
    }
    CommBoardDTO commBoardDTO = requestAgent.getObject(CommBoardDTO.class);


    return commBoardDTO.getCommNo();
  }
}
