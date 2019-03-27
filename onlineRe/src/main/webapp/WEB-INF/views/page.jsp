<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css"></spring:url>
<spring:url var="js" value="/resources/js"></spring:url>
<spring:url var="images" value="/resources/images"></spring:url>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shoping Market-${title}</title>

<script>
	window.menu = '${title}';
	window.contextRoot='{$contextRoot}';
	
</script>


<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">



<!-- BootsWatch for Project Theme -->
<link href="${css}/Bootswatch-them.css" rel="stylesheet">

 <!-- data TAbles for Bootstrap-->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">


<!-- data TAbles for Bootstrap-->
<link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">


<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>
      
      
	<div class="wrapper">

		<!-- Navigation -->

		<%@ include file="./shared/navbar.jsp"%>



		<!-- Page Content -->

		<!-- loading home page content -->
		<div class="content">
			<c:if test="${userClickHome==true}">
				<%@ include file="home.jsp"%>
			</c:if>

			<!-- load this section when user click on about us -->
			<c:if test="${ userClickAbout==true}">
				<%@ include file="about.jsp"%>
			</c:if>

			<!-- load this section when user click on Contact us -->
			<c:if test="${userClickContact==true }">
				<%@include file="contact.jsp"%>
			</c:if>
			
			<!-- user click on alll products or indivsual produts -->
			<c:if test="${userClickAllProducts==true or userClickCategoryProducts==true }">
				<%@include file="listProducts.jsp"%>
			</c:if>
			
			
		</div>



		<!-- Footer -->
		<%@ include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.js"></script>
	 	<script src="${js}/bootstrap.bundle.min.js"></script>
        
        <!-- Jquary DataTables plugings -->
        <script src="${js}/jquery.dataTables.js"></script>
        
        
          <!-- DataTables bootstrap plugings -->
        <script src="${js}/dataTables.bootstrap.js"></script>
        
         <!-- DataTables bootstrap plugings -->
        <script src="${js}/dataTables.bootstrap4.js"></script>
        
        
        
		<!-- Self Coded of java Script -->
		<script src="${js}/myapp.js">
			
		</script>
	</div>
</body>

</html>
