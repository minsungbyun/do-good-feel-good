<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>관리자 모금함목록</title>
  <link rel="stylesheet" href="../node_modules/bootstrap/dist/css/bootstrap.css">
  
  <script src="../node_modules/@popperjs/core/dist/umd/popper.js"></script>
  <script src="../node_modules/bootstrap/dist/js/bootstrap.js"></script>
</head>
<body>
<div class="container">
<h1>관리자 모금함목록(MVC + EL + JSTL1)</h1>

<table class="table">
<thead>
  <tr>
    <th>개설번호</th>
    <th>모금함 분류</th>
    <th>주최자</th>
    <th>제목</th>
    <th>내용</th>
    <th>첨부파일</th>
    <th>개설시작일</th>
    <th>개설종료일</th>
    <th>총기간</th>
    <th>남은기간</th>
    <th>목표금액</th>
    <th>승인여부</th>
  </tr>
</thead>
<tbody>

<c:forEach items="${adminDonationBoardList}" var="donationBoardDTO">
<tr>
	  <td>${donationBoardDTO.no}</td> 
	  <td>${donationBoardDTO.category.title}</td> 
	  <td>${donationBoardDTO.leader.name}</td> 
	  <td>${donationBoardDTO.title}</td> 
	  <td>${donationBoardDTO.content}</td>
	  <td>${donationBoardDTO.fileNames}</td>
	  <td>${donationBoardDTO.startDate}</td>
	  <td>${donationBoardDTO.endDate}</td>
	  <td>${donationBoardDTO.totalDate}</td>
    <td>${donationBoardDTO.remainDate}</td>
	  <td>${donationBoardDTO.moneyTarget}</td>
	  <td>${donationBoardDTO.status}</td>
<td><input id='f-adminList' type='radio' name='adminList' value="${donationBoardDTO.no}"></td>
<th><a href='boardApprove?no=${donationBoardDTO.no}'>[승인하기]</a></th>
<th><a href='boardReject?no=${donationBoardDTO.no}'>[반려하기]</a></th>
</tr>
</c:forEach>
</tbody>
</table>
</div><!-- .container -->
</body>
</html>












    