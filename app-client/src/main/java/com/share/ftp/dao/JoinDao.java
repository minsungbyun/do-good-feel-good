package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.join.JoinDTO;

public interface JoinDao {

  void insert(JoinDTO joinDTO) throws Exception;
  List<JoinDTO> findAll() throws Exception;
  void update(JoinDTO joinDTO) throws Exception;
  void delete(JoinDTO joinDTO) throws Exception;
  List<JoinDTO> selectOneByIdPassword() throws Exception;
  List<JoinDTO> validId() throws Exception;
  List<JoinDTO> validName() throws Exception;
  List<JoinDTO> getNextNum() throws Exception;

}
