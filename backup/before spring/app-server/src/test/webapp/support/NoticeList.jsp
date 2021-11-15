<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>HappyShare 공지사항 목록</title>
</head>
<body>
<h1>공지사항 목록</h1>
<a href='form'>글쓰기</a><br>
<table border='1'>
<thead>
  <tr>
    <th>번호</th>
    <th>제목</th>
    <th>등록일</th>
    <th>조회수</th>
  </tr>
</thead>
<tbody>
<c:forEach items="${noticeList}" var="notice" >

<tr>
    <td>${notice.no}</td>
    <td><a href='detail?no=${notice.no}'>${notice.title}</a></td> 
    <td>${notice.registeredDate}</td> 
    <td>${notice.viewCount}</td> 
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>








