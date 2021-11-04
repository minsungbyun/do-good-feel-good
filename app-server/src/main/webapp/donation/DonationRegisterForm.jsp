<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     trimDirectiveWhitespaces="true" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>모금함 개설신청 양식</title>
	<style>
	label {
		margin-right: 5px;
		text-align: right;
		display: inline-block;
		 width: 100px;
	 }
	</style>
</head>
<body>
<h1>모금함 개설신청 양식(MVC)</h1>
<form action='registerAdd'>
    
    <label for='f-donationBoard'>모금함번호</label> 
    <input id='f-donationBoard' type='number' name='donationBoard' value="${donationBoardNo}" readonly><br>
    
    <label for='f-donator'>기부자</label> 
    <input id='f-donator' type="number" name='donator'><br>
    
    
    <label for='f-donationMoney'>기부금액</label> 
    <input id='f-donationMoney' type='number' name='donationMoney'><br>
    
    <label for='f-registerationNumber'>주민등록번호</label> 
    <input id='f-registerationNumber' type='number' name='registerationNumber'><span>-</span><input id='f-registerationNumber' type='password' name='registerationNumber'><br>
    
    <c:forEach items="${payTypes}" var="donationRegisterPayType">
    <label for='f-payType'>${donationRegisterPayType.title}</label> 
    <input id='f-payType' type='radio' name='payType' value="${donationRegisterPayType.no}"><br>
</c:forEach>
<br>
<button>기부하기</button><br>
</form>
</body>
</html>
     