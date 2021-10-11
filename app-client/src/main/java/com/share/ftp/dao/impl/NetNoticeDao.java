package com.share.ftp.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.share.ftp.dao.NoticeDao;
import com.share.ftp.domain.admin.NoticeDTO;
import com.share.request.RequestAgent;

// 게시글 데이터를 서버를 통해 관리한다.

public class NetNoticeDao implements NoticeDao {

  RequestAgent requestAgent;

  public NetNoticeDao(RequestAgent requestAgent) {
    this.requestAgent = requestAgent;
  }

  @Override
  public void insert(NoticeDTO addNotice) throws Exception {
    requestAgent.request("notice.insert", addNotice);

    if (requestAgent.getStatus().equals(RequestAgent.SUCCESS)) {
      System.out.println("[ 게시글 등록이 정상적으로 완료되었습니다! ]");

    } else {
      throw new Exception("게시글 등록 실패!");
    }
  }

  @Override
  public List<NoticeDTO> findAll() throws Exception {

    requestAgent.request("notice.selectList", null);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("게시글 목록 조회 실패!");
    }
    return new ArrayList<>(requestAgent.getObjects(NoticeDTO.class));
  }

  @Override
  public List<NoticeDTO> findByKeyword(String keyword) throws Exception {
    HashMap<String,String> params = new HashMap<>();
    params.put("keyword", keyword);
    requestAgent.request("notice.selectListByKeyword", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("게시글 검색 실패!");
    }

    return new ArrayList<>(requestAgent.getObjects(NoticeDTO.class));
  }

  @Override
  public NoticeDTO findByNoticeNo(int noticeNo) throws Exception {
    HashMap<String,String> params = new HashMap<>();
    params.put("noticeNo", String.valueOf(noticeNo));

    requestAgent.request("notice.selectOne", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      return null;
    }

    return requestAgent.getObject(NoticeDTO.class);
  }


  @Override
  public void update(NoticeDTO updateNotice) throws Exception {
    requestAgent.request("notice.update", updateNotice);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("게시글 수정 실패!");
    }

  }

  @Override
  public void delete(int noticeNo) throws Exception {
    HashMap<String,String> params = new HashMap<>();
    params.put("noticeNo", String.valueOf(noticeNo));

    requestAgent.request("notice.delete", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("게시글 삭제 실패!");
    }
  }

  @Override
  public int getNextNum() throws Exception {

    requestAgent.request("notice.getNextNum", null);


    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("게시글 번호 부여 중 오류 발생!");
    }
    System.out.println("확인");
    NoticeDTO noticeDTO = requestAgent.getObject(NoticeDTO.class);


    return noticeDTO.getNo();
  }

}
