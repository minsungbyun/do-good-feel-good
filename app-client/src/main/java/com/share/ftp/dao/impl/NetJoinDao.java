package com.share.ftp.dao.impl;

import java.util.List;
import com.share.ftp.dao.JoinDao;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.request.RequestAgent;

public class NetJoinDao implements JoinDao {

  RequestAgent requestAgent;

  public NetJoinDao(RequestAgent requestAgent) {
    this.requestAgent = requestAgent;
  }

  @Override
  public void insert(JoinDTO joinDTO) throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public List<JoinDTO> findAll() throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void update(JoinDTO joinDTO) throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public void delete(JoinDTO joinDTO) throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public List<JoinDTO> validId() throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<JoinDTO> validName() throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<JoinDTO> getNextNum() throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<JoinDTO> selectOneByIdPassword() throws Exception {
    // TODO Auto-generated method stub
    return null;
  }



}
