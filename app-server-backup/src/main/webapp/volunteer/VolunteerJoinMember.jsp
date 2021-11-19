
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<body>
  <h1>[ 참여자 목록 ]</h1>
    <table border='1'>
      <thead>
        <tr>
          <th>아이디</th>
          <th>이름</th>
          <th>신청일</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${volunteerList}" var="volunteerRequestDTO" >
          <tr>
              <td>${volunteerRequestDTO.members.id}</td> 
              <td>${volunteerRequestDTO.members.name}</td> 
              <td>${volunteerRequestDTO.createdDate}</td> 
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <a href='../detail?no=${volNo}'>[목록]</a>
    
    
    
    
     

