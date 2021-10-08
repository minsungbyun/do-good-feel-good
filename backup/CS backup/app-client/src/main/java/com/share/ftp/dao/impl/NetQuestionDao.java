package com.share.ftp.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.share.ftp.dao.QuestionDao;
import com.share.ftp.domain.personal.QuestionListDTO;
import com.share.request.RequestAgent;

// 게시글 데이터를 서버를 통해 관리한다.
//
public class NetQuestionDao implements QuestionDao {

  RequestAgent requestAgent;

  public NetQuestionDao(RequestAgent requestAgent) {
    this.requestAgent = requestAgent;
  }

  @Override
  public void insert(QuestionListDTO questionListDTO) throws Exception {
    requestAgent.request("question.insert", questionListDTO);
    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("게시글 등록 실패!");
    }
  }

  @Override
  public List<QuestionListDTO> findAll() throws Exception {
    requestAgent.request("question.selectList", null);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("게시글 목록 조회 실패!");
    }

    return new ArrayList<>(requestAgent.getObjects(QuestionListDTO.class));
  }

  @Override
  public List<QuestionListDTO> findByKeyword(String keyword) throws Exception {
    HashMap<String,String> params = new HashMap<>();
    params.put("keyword", keyword);
    requestAgent.request("question.selectListByKeyword", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("게시글 검색 실패!");
    }

    return new ArrayList<>(requestAgent.getObjects(QuestionListDTO.class));
  }

  @Override
  public QuestionListDTO findByNo(int questionNo) throws Exception {
    HashMap<String,String> params = new HashMap<>();
    params.put("questionNo", String.valueOf(questionNo));

    requestAgent.request("question.selectOne", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      return null;
    }

    return requestAgent.getObject(QuestionListDTO.class);
  }

  @Override
  public void update(QuestionListDTO updateQuestion) throws Exception {
    requestAgent.request("question.update", updateQuestion);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("게시글 변경 실패!");
    }
  }

  @Override
  public void delete(int questionNo) throws Exception {
    HashMap<String,String> params = new HashMap<>();
    params.put("questionNo", String.valueOf(questionNo));
    requestAgent.request("question.delete", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("게시글 삭제 실패!");
    }
  }
  @Override
  public int getNextNum() throws Exception {

    requestAgent.request("question.getNextNum", null);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("고유번호 부여 중 오류 발생!");
    }
    QuestionListDTO questionListDTO = requestAgent.getObject(QuestionListDTO.class);


    return questionListDTO.getNo();
  }
}



