<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
  <title>모금함상세</title>
	<style>
	label {
	margin-right: 10px;
	text-align: right;
	display: inline-block;
	 width: 100px;
	 }
	</style>
</head>
<body>
<h1>회원 상세(MVC + EL)</h1>
<form action='update'>
    <label for='f-no'>개설번호</label> 
    <input id='f-no' type='text' name='no' value='${donationBoardDTO.no}' readonly><br>
    
    <label for='f-category'>개설분류</label> 
    <input id=f-category type="text" name='category' value='${donationBoardDTO.category.title}'><br>
    
    <label for='f-leader'>주최자</label> 
    <input id='f-leader' type="text" name='leader' value='${donationBoardDTO.leader.name}'><br>
    
    <label for='f-title'>제목</label> 
    <input id='f-title' type='text' name='title' value='${donationBoardDTO.title}'><br>
    
    <label for='f-content'>내용</label> 
    <input id='f-content' type='text' name='content' value='${donationBoardDTO.content}'><br>
    
    <label for='f-file'>첨부파일</label> 
    <input id='f-file' type="file" name='fileUpload' value='${donationBoardDTO.fileNames}'><br>
    
    <label for='f-startDate'>시작일</label> 
    <input id='f-startDate' type="date" name='startDate' value='${donationBoardDTO.startDate}'><br>
    
    <label for='f-endDate'>종료일</label> 
    <input id='f-endDate' type="date" name='endDate' value='${donationBoardDTO.endDate}'><br>
    
    <label for='f-taget'>목표금액</label> 
    <input id='f-taget' type="number" name='moneyTarget' value='${donationBoardDTO.moneyTarget}'><br>
    <%-- 
    <label for='f-remainMoney'>남은금액</label> 
    <input id='f-remainMoney' type='text' name='remainMoney' value='${remainMoney}'><br>
    --%>
 <button>[변경]</button>
 <a href='delete?no=${donationBoardDTO.no}'>[삭제]</a> <a href='list'>[목록]</a><br>
</form>
</body>
</html>
    