<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
<c:if test="${not empty refresh}">
  <meta http-equiv="Refresh" content="${refresh}">   
</c:if>
    <!-- meta -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

  
    <title>${pageTitle}</title>
    <!-- link -->
    <link rel="stylesheet" href="${contextPath}/assets/css/bootstrap.css">
    <link rel="stylesheet" href="${contextPath}/assets/css/maicons.css">
    <link rel="stylesheet" href="${contextPath}/assets/vendor/animate/animate.css">
    <link rel="stylesheet" href="${contextPath}/assets/vendor/owl-carousel/css/owl.carousel.css">
    <link rel="stylesheet" href="${contextPath}/assets/vendor/fancybox/css/jquery.fancybox.css">
    <link rel="stylesheet" href="${contextPath}/assets/css/theme.css">
    <link rel="stylesheet" href="${contextPath}/assets/css/style.css">
    <%--   캘린더 설정 나두세요
    <link rel="stylesheet" href="${contextPath}/assets/calendar/css/style.css" />
    <link rel="stylesheet" href="${contextPath}/assets/calendar/css/cal.css" />
    --%>
    
  </head>
<body>
<div class="container">

<jsp:include page="header.jsp"/>
 
<div id="content">
<jsp:include page="${contentUrl}"/>
</div><!-- #content --> 

<jsp:include page="footer.jsp"/>

</div><!-- .container -->
    <script src="${contextPath}/assets/js/jquery-3.5.1.min.js"></script>
    <script src="${contextPath}/assets/js/bootstrap.bundle.min.js"></script>
    <script src="${contextPath}/assets/vendor/owl-carousel/js/owl.carousel.min.js"></script>
    <script src="${contextPath}/assets/vendor/wow/wow.min.js"></script>
    <script src="${contextPath}/assets/vendor/fancybox/js/jquery.fancybox.min.js"></script>
    <script src="${contextPath}/assets/vendor/isotope/isotope.pkgd.min.js"></script>
    <script src="${contextPath}/assets/js/google-maps.js"></script>
    <script src="${contextPath}/assets/js/theme.js"></script>
<%--  캘린더 설정 나두세요
<script src="${contextPath}/assets/calendar/js/calendar.js"></script>
    <script>
      dycalendar.draw({
        target:'#calendar',
        type:'month',
        dayformat:'full',
        monthformat:'full',
        highlighttargetdate:true,
        prevnextbutton:'show'
      })
      </script>
      --%>
</body>
</html>








