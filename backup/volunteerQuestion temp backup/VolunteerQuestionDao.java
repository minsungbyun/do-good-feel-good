

import java.util.List;
import com.share.ftp.domain.volunteer.VolunteerQuestionDTO;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;

// 역할
// - 봉사 문의사항를 처리하는 객체 사용법을 정의한다.
public interface VolunteerQuestionDao {

  void insert(VolunteerQuestionDTO addVolQuestionDTO) throws Exception;
  List<VolunteerRequestDTO> findAllApproved() throws Exception;      


  //  VolunteerQuestionDTO getQnaCount(int volunteerNo) throws Exception; 

}
