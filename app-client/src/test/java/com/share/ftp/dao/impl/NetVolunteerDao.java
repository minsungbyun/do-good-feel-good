package com.share.ftp.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.google.gson.Gson;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
import com.share.ftp.domain.volunteer.VolQuestionDTO;
import com.share.request.RequestAgent;

public class NetVolunteerDao implements VolunteerDao {

  RequestAgent requestAgent;

  public NetVolunteerDao(RequestAgent requestAgent) {
    this.requestAgent = requestAgent;
  }

  ///봉사 등록관련 메서드//////////////////////////////////////////////////////////////
  @Override
  public void insert(VolunteerRequestDTO addVol) throws Exception {

    requestAgent.request("vol.insert", addVol);

    if (requestAgent.getStatus().equals(RequestAgent.SUCCESS)) {
      System.out.println("[ 봉사 등록이 정상적으로 완료되었습니다! ]");

    } else {
      throw new Exception("봉사 등록 실패!");
    }
  }

  @Override
  public List<VolunteerRequestDTO> findAll() throws Exception {

    requestAgent.request("vol.selectList", null);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("봉사 목록 조회 실패!");
    }
    return new ArrayList<>(requestAgent.getObjects(VolunteerRequestDTO.class));
  }

  @Override
  public void update(VolunteerRequestDTO updateVol) throws Exception {
    requestAgent.request("vol.update", updateVol);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("봉사 변경 실패!");
    }

  }

  @Override
  public void delete(VolunteerRequestDTO deleteVol) throws Exception {
    requestAgent.request("vol.delete", deleteVol);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("봉사 삭제 실패!");
    }
  }

  @Override
  public int getNextNum() throws Exception {

    requestAgent.request("vol.getNextNum", null);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("고유번호 부여 중 오류 발생!");
    }
    VolunteerRequestDTO VolunteerRequestDTO = requestAgent.getObject(VolunteerRequestDTO.class);


    return VolunteerRequestDTO.getNo();
  }

  @Override
  public VolunteerRequestDTO findByVolNo(int volNo) throws Exception {

    HashMap<String,String> params = new HashMap<>();
    params.put("volNo", String.valueOf(volNo));

    requestAgent.request("vol.selectOne", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      return null;
    }

    return requestAgent.getObject(VolunteerRequestDTO.class);
  }

  @Override
  public VolunteerRequestDTO findByApplyVol(int volApplyNo) throws Exception {

    HashMap<String,String> params = new HashMap<>();
    params.put("volApplyNo", String.valueOf(volApplyNo));

    requestAgent.request("vol.selectApplyOne", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      return null;
    }

    return requestAgent.getObject(VolunteerRequestDTO.class);
  }

  ///봉사 문의하기///////////////////////////////////////////////////////////////////

  @Override
  public void insertQuestion(VolQuestionDTO addVolQuestion) throws Exception {
    requestAgent.request("volQuestion.insert", addVolQuestion);

    if (requestAgent.getStatus().equals(RequestAgent.SUCCESS)) {
      System.out.println("[ 봉사 문의 등록이 정상적으로 완료되었습니다! ]");

    } else {
      throw new Exception("봉사 문의 등록 실패!");
    }



  }

  @Override
  public List<VolQuestionDTO> findAllQuestion() throws Exception {


    requestAgent.request("volQuestion.selectList", null);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      System.out.println("실패했어요");
      throw new Exception("봉사 문의 목록 조회 실패!");
    }
    return new ArrayList<>(requestAgent.getObjects(VolQuestionDTO.class));
  }

  @Override
  public void updateQuestion(VolQuestionDTO updateVolQuestion) throws Exception {

    requestAgent.request("volQuestion.update", updateVolQuestion);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("봉사 문의 변경 실패!");
    }
  }

  @Override
  public void deleteQuestion(VolQuestionDTO deleteVolQuestion) throws Exception {
    requestAgent.request("volQuestion.delete", deleteVolQuestion);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      throw new Exception("봉사 문의 삭제 실패!");
    }

  }


  @Override
  public VolQuestionDTO findByVolQuestionNo(int volNo, int volQuestionNo) throws Exception {

    HashMap<String,String> params = new HashMap<>();
    params.put("volNo", String.valueOf(volNo));
    params.put("volQuestionNo", String.valueOf(volQuestionNo));
    requestAgent.request("volQuestion.selectOne", params);

    if (requestAgent.getStatus().equals(RequestAgent.FAIL)) {
      return null;
    }

    return requestAgent.getObject(VolQuestionDTO.class);

  }

  @Override
  public int getNextQuestionNum(VolunteerRequestDTO VolunteerRequestDTO) throws Exception {

    return VolunteerRequestDTO.getQuestionCount() + 1;
  }

  @Override
  public void insertAdmin(int volQuestionNo, VolQuestionDTO addVolQuestion)
      throws Exception {

    HashMap<String,String> params = new HashMap<>();
    params.put("volQuestionNo", String.valueOf(volQuestionNo));
    params.put("addVolQuestion", new Gson().toJson(addVolQuestion));

    requestAgent.request("volQuestion.insertAdmin", params);

    if (requestAgent.getStatus().equals(RequestAgent.SUCCESS)) {
      System.out.println("[ 봉사 문의 등록이 정상적으로 완료되었습니다! ]");

    } else {
      throw new Exception("봉사 문의 등록 실패!");
    }
  }



}
