package com.share.ftp.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.share.ftp.dao.CommReviewDao;
import com.share.ftp.domain.personal.CommReviewDTO;
import com.share.request.RequestAgent;

// 한 줄 후기 데이터를 서버를 통해 관리한다.

public class NetCommReviewDao implements CommReviewDao {

  RequestAgent requestAgent;

  public NetCommReviewDao(RequestAgent requestAgent) {
    this.requestAgent = requestAgent;
  }

  @Override
  public void insert(CommReviewDTO addCommReview) throws Exception {
    requestAgent.request("commReview.insert", addCommReview);

    if (requestAgent.getStatus().equals(RequestAgent.SUCCESS)) {
      System.out.println("[ 한 줄 후기 등록이 정상적으로 완료되었습니다! ]");

    } else {
      throw new Exception("한 줄 후기 등록 실패!");
    }
  }

  @Override
  public List<CommReviewDTO> findAll() throws Exception {

    requestAgent.request("commReview.selectList", null);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("한 줄 후기 목록 조회 실패!");
    }
    return new ArrayList<>(requestAgent.getObjects(CommReviewDTO.class));
  }

  @Override
  public List<CommReviewDTO> findByKeyword(String keyword) throws Exception {
    HashMap<String,String> params = new HashMap<>();
    params.put("keyword", keyword);
    requestAgent.request("commReview.selectListByKeyword", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("한 줄 후기 검색 실패!");
    }

    return new ArrayList<>(requestAgent.getObjects(CommReviewDTO.class));
  }

  @Override
  public CommReviewDTO findByCommReviewNo(int commReviewNo) throws Exception {
    HashMap<String,String> params = new HashMap<>();
    params.put("commReviewNo", String.valueOf(commReviewNo));

    requestAgent.request("commReview.selectOne", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      return null;
    }

    return requestAgent.getObject(CommReviewDTO.class);
  }


  @Override
  public void update(CommReviewDTO updateCommReview) throws Exception {
    requestAgent.request("commReview.update", updateCommReview);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("한 줄 후기 변경 실패!");
    }

  }

  @Override
  public void delete(int deleteCommReviewNo) throws Exception {

    HashMap<String,String> params = new HashMap<>();
    params.put("deleteCommReviewNo", String.valueOf(deleteCommReviewNo));

    requestAgent.request("commReview.delete", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("한 줄 후기 삭제 실패!");
    }
  }

  @Override
  public int getNextNum() throws Exception {

    requestAgent.request("commReivew.getNextNum", null);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("한 줄 후기 번호 부여 중 오류 발생!");
    }
    CommReviewDTO commReviewDTO = requestAgent.getObject(CommReviewDTO.class);


    return commReviewDTO.getCommReviewNo();
  }


}
