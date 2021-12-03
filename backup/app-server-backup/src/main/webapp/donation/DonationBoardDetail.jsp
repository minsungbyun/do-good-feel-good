<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
    <main>
      <div class="page-section">
        <div class="container">
        
        <a href="" class="theme" style="text-decoration:none">${donationBoardDTO.category.title}</a>
        
        <ul class="nav nav-tabs">
                    <li class="nav-item">
                      <a class="nav-link active" href="#">모금함 소개</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link active" href="${contextPath}/register/list?no=${donationBoardDTO.no}">기부 내역</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link active" href="#">모금 소식</a>
                    </li>
                  </ul>
                  
           <img src="https://happybean-phinf.pstatic.net/20211103_47/16359178050095kGYu_JPEG/KakaoTalk_20210517_174428137.jpg?type=w720" class="d-block w-80" alt="...">
          <dl>
          <dt id="paragraphTitle">${donationBoardDTO.title}</dt>
          <dd id="paragraphContent">${donationBoardDTO.content}</dd>
          </dl>
          <hr>
          
          <strong>기부금 계획</strong> <span>여러분들의 소중한 기부금 이렇게 사용됩니다.</span>
          
          
          <table class="table table-hover">
            <colgroup><col style="width:160px">
            <col>
            <col style="width:160px">
            </colgroup>
            <thead>
            <tr>
                <th scope="col" colspan="2">사용계획내용</th>
                <th scope="col">사용금액</th>
            </tr>
            </thead>
            <tbody>
            <tr class="total">
                <td class="use"><strong>총 집행금액</strong></td>
                <td colspan="2"><em>${remainMoney}</em> 원 (목표금액 ${donationBoardDTO.moneyTarget}원)</td>
            </tr>
            
                <tr>
                    <td class="use">사업비</td>
                    <td>의료비(검사,약제비등) 50만원*6명 </td>
                    <td class="amount"><em>3,000,000</em>원</td>
                </tr>
            
                <tr>
                    <td class="use">사업비</td>
                    <td>양육물품(내복,젖병등)약40만*14명 </td>
                    <td class="amount"><em>5,415,000</em>원</td>
                </tr>
            
                <tr>
                    <td class="use">경상운영비</td>
                    <td>사업진행비 </td>
                    <td class="amount"><em>1,485,000</em>원</td>
                </tr>
            
            </tbody>
        </table>
              
      </div>  <!-- //container -->
      </div> <!-- //page-section -->
    </main>  
    
    