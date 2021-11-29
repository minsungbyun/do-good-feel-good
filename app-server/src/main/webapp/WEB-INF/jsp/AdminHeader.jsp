<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="head">
	<div class="container">
	  <!-- header -->
		<div class="header">
			<h6 class="navbar-brand" style="color: #5979c2 !important; letter-spacing: -0.04em;">
				Happy<b class="text-primary logo" style="color: #ff8184 !important;">Share</b>
			</h6>
			<div class="btn-logoout">
				<c:if test="${not empty sessionScope.loginUser}">
                    ${sessionScope.loginUser.name}
                    <a href="${contextPath}/auth/logout"
						class="btn btn-primary btn-sm btn-logo">로그아웃</a>
				</c:if>
			</div>
		</div>
		<!-- //header -->
	</div>
</div>
