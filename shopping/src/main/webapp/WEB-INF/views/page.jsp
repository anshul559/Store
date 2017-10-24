<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Shopping-${title}</title>
<script type="text/javascript">
	window.menu = "${title}";
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.css" rel="stylesheet">

<link href="${css}/mytheme.css" rel="stylesheet">

<!-- Add custom CSS here -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>

	<!--Navbar here  -->

	<%@include file="./shared/navbar.jsp"%>

	<div class="content">
		<!--Main Content here  -->
		<c:if test="${userClickHome == true}">
			<%@include file="home.jsp"%>
		</c:if>


		<!--Loading only when click on About us  -->
		<c:if test="${userClickAbout == true}">
			<%@include file="about.jsp"%>
		</c:if>


		<!--Loading only when click on contact us  -->
		<c:if test="${userClickContact == true}">
			<%@include file="contact.jsp"%>
		</c:if>
		
		<!--Loading only when click on contact us  -->
		<c:if test="${userClickAllProducts == true or userClickCategoryProduct == true}">
			<%@include file="AllProducts.jsp"%>
		</c:if>

	</div>
	<!--Footer here  -->

	<%@include file="./shared/footer.jsp"%>

	<!-- JavaScript -->
	<script src="${js}/jquery.js"></script>
	<script src="${js}/bootstrap.js"></script>
	<script src="${js}/myapp.js"></script>

</body>

</html>