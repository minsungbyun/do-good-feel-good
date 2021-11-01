<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>나눔이야기 목록</title>
</head>
<body>
<h1>봉사 게시판 - 나눔이야기 목록</h1>
<a href='form'>게시글 작성</a><br>
<table border='1'>
<thead>
  <tr>
    <th>번호</th>
    <th>작성자</th>
    <th>제목</th>
    <th>등록일</th>
    <th>조회수</th>

  </tr>
</thead>
<tbody>

<c:forEach items="${volunteerBoardList}" var="volunteerBoardDTO">
<tr>
    <td><a href='detail?no=${volunteerBoardDTO.no}'>${volunteerBoardDTO.no}</a></td>
    <td>${volunteerBoardDTO.owner.id}</td> 
    <td>${volunteerBoardDTO.title}</td> 
    <td>${volunteerBoardDTO.registeredDate}</td>
    <td>${volunteerBoardDTO.viewCount}</td> 
</tr>
</c:forEach>

</tbody>
</table>
</body>
</html>








