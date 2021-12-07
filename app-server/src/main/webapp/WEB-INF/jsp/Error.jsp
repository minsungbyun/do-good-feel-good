<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set scope="page" var="contextRoot" value="${pageContext.servletContext.contextPath}"/>

<div class="page-banner bg-img bg-img-parallax overlay-dark"
  style="background-image: url(${contextPath}/images/volunteer1.jpg);">
  <div class="container h-100">
    <div class="row justify-content-center align-items-center h-100">
      <div class="col-lg-8">
        <nav aria-label="breadcrumb">
          <ol
            class="breadcrumb breadcrumb-dark bg-transparent justify-content-center py-0">
            <li class="breadcrumb-item"><a href="#"
              style="font-size: 20px;">함께해요</a></li>
            <li class="breadcrumb-item active" aria-current="page"
              style="font-size: 22px;">봉사목록</li>
          </ol>
        </nav>
      </div>
    </div>
  </div>
</div>
<!-- //page-banner -->
<body>
<div class="container">


<div id="content">
<pre>
${error}
<%-- 
<%
Exception error = (Exception) request.getAttribute("error");
error.printStackTrace(new PrintWriter(out));
%>
--%>
</pre>
<button onClick="location.href='list'">돌아가기</button>
</div><!-- #content -->

</div><!-- .container -->













    