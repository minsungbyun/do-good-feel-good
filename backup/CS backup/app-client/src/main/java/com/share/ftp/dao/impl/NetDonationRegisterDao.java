package com.share.ftp.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.share.ftp.dao.DonationRegisterDao;
import com.share.ftp.domain.personal.DonationRegisterDTO;
import com.share.request.RequestAgent;

// 역할
// - 게시글 데이터를 서버를 통해 관리한다.
//
public class NetDonationRegisterDao implements DonationRegisterDao {
  RequestAgent requestAgent;

  public NetDonationRegisterDao(RequestAgent requestAgent) {
    this.requestAgent = requestAgent;
  }


  @Override
  public void insert(DonationRegisterDTO donationRegisterDTO) throws Exception {
    requestAgent.request("donationRegister.insert", donationRegisterDTO);
    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("모금함 개설 기부등록 데이터 저장 실패!");
    }

  }

  @Override
  public List<DonationRegisterDTO> findAll() throws Exception {
    requestAgent.request("donationRegister.selectList", null);
    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("모금함 개설 기부등록 데이터 저장 실패!");
    }

    return new ArrayList<>(requestAgent.getObjects(DonationRegisterDTO.class));

  }

  @Override
  public List<DonationRegisterDTO> findByKeyword(String keyword) throws Exception {
    HashMap<String,String> params = new HashMap<>();
    params.put("keyword", keyword);
    requestAgent.request("donationBoard.selectList", null);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("모금함 개설 기부등록 데이터 저장 실패!");
    }

    return new ArrayList<>(requestAgent.getObjects(DonationRegisterDTO.class));
  }

  @Override
  public DonationRegisterDTO findByNo(int no) throws Exception {
    HashMap<String,String> params = new HashMap<>();
    params.put("no", String.valueOf(no));

    requestAgent.request("donationBoard.selectOne", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      return null;
    }

    return requestAgent.getObject(DonationRegisterDTO.class);
  }

  @Override
  public void update(DonationRegisterDTO donationRegisterDTO) throws Exception {
    requestAgent.request("donationBoard.update", donationRegisterDTO);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("모금함 개설 기부 변경 실패!");
    }
  }

  @Override
  public void delete(int no) throws Exception {
    HashMap<String,String> params = new HashMap<>();
    params.put("no", String.valueOf(no));

    requestAgent.request("donationRegister.delete", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("모금함 개설 기부 삭제 실패!");
    }
  }

  @Override
  public int getNextNum() throws Exception {

    requestAgent.request("donationRegister.getNextNum", null);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("고유번호 부여 중 오류 발생!");
    }
    DonationRegisterDTO donationRegisterDTO = requestAgent.getObject(DonationRegisterDTO.class);


    return donationRegisterDTO.getNo();
  }


}
