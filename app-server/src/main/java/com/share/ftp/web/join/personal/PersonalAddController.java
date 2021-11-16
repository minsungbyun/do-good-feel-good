package com.share.ftp.web.join.personal;

import java.io.IOException;
import java.sql.Date;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.PersonalDao;
import com.share.ftp.domain.join.PersonalDTO;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

//@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
//@WebServlet("/join/personal/add")
public class PersonalAddController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  SqlSession sqlSession;
  PersonalDao personalDao;

  @Override
  public void init()  {
    ServletContext 웹애플리케이션공용저장소 = getServletContext();
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
    personalDao = (PersonalDao) 웹애플리케이션공용저장소.getAttribute("personalDao");
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      PersonalDTO personalDTO = new PersonalDTO();

      personalDTO.setId(request.getParameter("id"));
      personalDTO.setPassword(request.getParameter("password"));
      personalDTO.setName(request.getParameter("name"));
      personalDTO.setTel(request.getParameter("tel"));
      personalDTO.setEmail(request.getParameter("email"));
      personalDTO.setPostNo(request.getParameter("postNo"));
      personalDTO.setBasicAddress(request.getParameter("basicAddress"));
      personalDTO.setDetailAddress(request.getParameter("detailAddress"));

      personalDTO.setBirthdate(Date.valueOf(request.getParameter("birthdate")));
      personalDTO.setType(1);
      personalDTO.setStatus(1);
      personalDTO.setLevel("천콩이");

      Part photoPart = request.getPart("photo");
      if (photoPart.getSize() > 0) {
        String filename = UUID.randomUUID().toString();
        photoPart.write(getServletContext().getRealPath("/upload/user") + "/" + filename);
        personalDTO.setPhoto(filename);

        Thumbnails.of(getServletContext().getRealPath("/upload/user") + "/" + filename)
        .size(20, 20)
        .outputFormat("jpg")
        .crop(Positions.CENTER)
        //.toFiles(Rename.PREFIX_DOT_THUMBNAIL);
        .toFiles(new Rename() {
          @Override
          public String apply(String name, ThumbnailParameter param) {
            return name + "_20x20";
          }
        });

        Thumbnails.of(getServletContext().getRealPath("/upload/user") + "/" + filename)
        .size(100, 100)
        .outputFormat("jpg")
        .crop(Positions.CENTER)
        //.toFiles(Rename.PREFIX_DOT_THUMBNAIL);
        .toFiles(new Rename() {
          @Override
          public String apply(String name, ThumbnailParameter param) {
            return name + "_100x100";
          }
        });
      }


      personalDao.insert(personalDTO);
      personalDao.insertPersonal(personalDTO.getNo(), personalDTO.getBirthdate(), personalDTO.getLevel());
      sqlSession.commit();


      response.setHeader("Refresh", "1;url=../../home");
      request.setAttribute("contentUrl", "/join/personal/PersonalUserAdd.jsp");
      request.getRequestDispatcher("/template1.jsp").forward(request, response);
      //      request.getRequestDispatcher("/join/personal/PersonalUserAdd.jsp").forward(request, response);

    } catch (Exception e) {
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);

    }
  }
}







