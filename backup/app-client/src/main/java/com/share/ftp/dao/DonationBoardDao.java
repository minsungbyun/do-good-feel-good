package com.share.ftp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.share.ftp.domain.Category;
import com.share.ftp.domain.donation.DonationBoardDTO;

public interface DonationBoardDao {
  void insert(DonationBoardDTO donationBoardDTO) throws Exception;
  void insertFile(
      @Param("donationNo") int donationNo,
      @Param("filepath") String filepath) throws Exception;
  List<DonationBoardDTO> findAll() throws Exception;
  List<DonationBoardDTO> findAllApproved() throws Exception;      
  List<DonationBoardDTO> findAllApply() throws Exception;      
  List<DonationBoardDTO> findAllWait() throws Exception;      
  List<Category> findAllCategory() throws Exception;      
  void update(DonationBoardDTO updateDonation) throws Exception;          
  void updateStatus(DonationBoardDTO updateDonation) throws Exception;          
  void updateFile(DonationBoardDTO updateDonation) throws Exception;          
  void delete(DonationBoardDTO deleteDonation) throws Exception;    
  void deleteFile(DonationBoardDTO deleteDonation) throws Exception;    

  int totalDate(int donationNo) throws Exception;
  int remainDate(int donationNo) throws Exception;
  DonationBoardDTO findByDonationNo(int donationNo) throws Exception;
  DonationBoardDTO findByApprovedDonatinNo(int donationNo) throws Exception;
  List<DonationBoardDTO> findByKeyword(String keyword) throws Exception;
}
