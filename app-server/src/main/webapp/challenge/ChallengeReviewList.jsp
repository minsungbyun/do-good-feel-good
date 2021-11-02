<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>챌린지리뷰목록</title>
</head>
<body>
<h1>참여인증&댓글 목록</h1>
<table border='1'>
<thead>
  <tr>
    <th>번호</th>
    <th>내용</th>
<!--     <th>파일첨부</th> -->
    <th>작성자</th>
  </tr>
</thead>
<tbody>

<c:forEach items="${challengeReviewList}" var="challengeReviewDTO">
<tr>
    <td>${challengeReviewDTO.no}</td>
    <td><a href='detail?no=${challengeReviewDTO.reviewNo}'>${challengeReviewDTO.content}</a></td> 
<!--    <td>${challengeReviewDTO.fileUpload}</td> -->
    <td>${challengeReviewDTO.owner.id}</td> 
</tr>
</c:forEach>

</tbody>
</table>
</body>
</html>