package com.share.ftp.handler.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.share.ftp.dao.GeneralDao;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
import com.share.util.GeneralHelper;

public class VolunteerTest {

  public static void main(String[] args)throws Exception {

    SqlSession sqlSession;
    sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
        "com/share/ftp/conf/mybatis-config.xml")).openSession();

    VolunteerDao volunteerDao = sqlSession.getMapper(VolunteerDao.class);
    GeneralDao generalDao = sqlSession.getMapper(GeneralDao.class);

    VolunteerRequestDTO volunteerRequestDTO = new VolunteerRequestDTO();
    // 전체 날짜 반환
    VolunteerRequestDTO date = volunteerDao.totalDate(1);
    VolunteerRequestDTO date2 = volunteerDao.remainDate(1);
    System.out.println(date.getTotalDate()+"일 남았습니다.");
    System.out.println(date2.getRemainDate()+"일 남았습니다.");

    // 파일업로드 , 첨부파일 테스트 하나씩 주석 풀고 테스트해보세요
    //    volunteerRequestDTO.setFileUpload(GeneralHelper.promptFileUpload());
    volunteerRequestDTO.setCategory(new GeneralHelper(generalDao).promptCategory());

    // 첨부파일 출력 테스트
    //    List<VolunteerAttachedFile> file = volunteerRequestDTO.getFileUpload();
    //    for (VolunteerAttachedFile volunteerAttachedFile : file) {
    //      System.out.println(volunteerAttachedFile.getFilepath());
    //    }

    // 카테고리 출력 테스트
    System.out.println();
    System.out.println(volunteerRequestDTO.getCategory().getTitle());


  }

}
