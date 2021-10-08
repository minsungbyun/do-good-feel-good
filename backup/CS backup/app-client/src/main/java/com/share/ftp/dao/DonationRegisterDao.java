package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.personal.DonationRegisterDTO;

public interface DonationRegisterDao {
  void insert(DonationRegisterDTO donationRegisterDTO) throws Exception;
  List<DonationRegisterDTO> findAll() throws Exception;
  List<DonationRegisterDTO> findByKeyword(String keyword) throws Exception;
  DonationRegisterDTO findByNo(int no) throws Exception;
  void update(DonationRegisterDTO donationBoardDTO) throws Exception;
  void delete(int no) throws Exception;
  int getNextNum() throws Exception; 
}
