package com.share.ftp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.share.ftp.domain.donation.DonationBoardDTO;

public interface DonationBoardDao {
  void insert(DonationBoardDTO donationBoardDTO) throws Exception;
  void insertFile(
      @Param("donationNo") int donationNo,
      @Param("filepath") String filepath) throws Exception;
  List<DonationBoardDTO> findAll() throws Exception;
  //  List<DonationBoardDTO> findByKeyword(String keyword) throws Exception;
  //  DonationBoardDTO findByNo(int no) throws Exception;
  //  void update(DonationBoardDTO donationBoardDTO) throws Exception;
  //  void delete(int no) throws Exception;
}
