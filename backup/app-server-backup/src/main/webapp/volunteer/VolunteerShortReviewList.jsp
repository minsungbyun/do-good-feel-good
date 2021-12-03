<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>소통해요 : 한줄후기 등록</title>
  <link rel="stylesheet" href="../node_modules/bootstrap/dist/css/bootstrap.css">
  
  <script src="../node_modules/@popperjs/core/dist/umd/popper.js"></script>
  <script src="../node_modules/bootstrap/dist/js/bootstrap.js"></script>
 
 <style>
    .container {
        width:640px;      
    }
  </style>
</head>
<body>
<div class="container">
<h1>봉사 후기 - 한 줄 후기 목록</h1>
<a href='reviewForm'>후기 작성</a><br>
<table border='1'>
<thead>
  <tr>
    <th>번호</th>
    <th>작성자</th>
    <th>내용</th>
    <th>등록일</th>
    <th>변경/ 삭제</th>
    
  </tr>
</thead>
<tbody>

<c:forEach items="${volunteerShortReviewList}" var="volunteerShortReviewDTO">
<tr>
    <td>${volunteerShortReviewDTO.no}</td> 
    <!-- <td>${volunteerShortReviewDTO.volNo}</td> -->
    <td>${volunteerShortReviewDTO.content}</td> 
    <td>${volunteerShortReviewDTO.owner.id}</td> 
    <td>${volunteerShortReviewDTO.registeredDate}</td>
    <td><button>변경</button> <a href='delete?no=${volunteerShortReviewDTO.no}'>[삭제]</a></td> 
</tr>


 
</c:forEach>

</tbody>
</table>
</body>
</html>








