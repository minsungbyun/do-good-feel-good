package com.share.ftp.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.share.ftp.dao.DonationBoardDao;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.request.RequestAgent;

// 역할
// - 게시글 데이터를 서버를 통해 관리한다.
//
public class NetDonationBoardDao implements DonationBoardDao {
  RequestAgent requestAgent;

  public NetDonationBoardDao(RequestAgent requestAgent) {
    this.requestAgent = requestAgent;
  }


  @Override
  public void insert(DonationBoardDTO donationBoardDTO) throws Exception {
    requestAgent.request("donationBoard.insert", donationBoardDTO);
    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("모금함 개설 기부등록 데이터 저장 실패!");
    }

  }

  @Override
  public List<DonationBoardDTO> findAll() throws Exception {
    requestAgent.request("donationBoard.selectList", null);
    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("모금함 목록 조회 실패!");
    }

    return new ArrayList<>(requestAgent.getObjects(DonationBoardDTO.class));

  }

  @Override
  public List<DonationBoardDTO> findByKeyword(String keyword) throws Exception {
    HashMap<String,String> params = new HashMap<>();
    params.put("donationBoardKeyword", keyword);
    requestAgent.request("donationBoard.selectListByKeyword", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("모금함 검색 실패!");
    }

    return new ArrayList<>(requestAgent.getObjects(DonationBoardDTO.class));
  }

  @Override
  public DonationBoardDTO findByNo(int no) throws Exception {
    HashMap<String,String> params = new HashMap<>();
    params.put("no", String.valueOf(no));

    requestAgent.request("donationBoard.selectOne", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      return null;
    }

    return requestAgent.getObject(DonationBoardDTO.class);
  }

  @Override
  public void update(DonationBoardDTO donationBoardDTO) throws Exception {
    requestAgent.request("donationBoard.update", donationBoardDTO);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("모금함 개설 변경 실패!");
    }
  }

  @Override
  public void delete(int no) throws Exception {
    HashMap<String,String> params = new HashMap<>();
    params.put("no", String.valueOf(no));

    requestAgent.request("donationBoard.delete", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("모금함 개설 삭제 실패!");
    }
  }

  @Override
  public int getNextNum() throws Exception {

    requestAgent.request("donationBoard.getNextNum", null);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("고유번호 부여 중 오류 발생!");
    }
    DonationBoardDTO donationBoardDTO = requestAgent.getObject(DonationBoardDTO.class);


    return donationBoardDTO.getNo();
  }


}
