<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css"></spring:url>
<spring:url var="js" value="/resources/js"></spring:url>
<spring:url var="images" value="/resources/images"></spring:url>







<c:set var="contextRoot" value='${pageContext.request.contextPath}'/>

<!DOCTYPE html>
<html lang="en">

<head>



<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<meta name="_csrf" content="${csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">

<title>Online Shoping Market-${title}</title>

<script>
	window.menu = '${title}';
	window.contextRoot='{$contextRoot}';
	
</script>


<!-- Bootstrap core CSS -->
 
<link href="${css}/Bootswatch-them.css" rel="stylesheet"/>
   <%--  <link href="${css}/bootstrap.min.css" rel="stylesheet"/> 
  <link href="${css}/bootstrap.css" rel="stylesheet"/>   --%>
   
  <!-- BootsWatch for Project Theme -->

 
   <!-- <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"/>  
   -->
   
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
   
   
   
  <!--  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"/>
 
 -->



 <!-- data TAbles for Bootstrap-->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet"/>


<!-- data TAbles for Bootstrap-->
 

 <link href="${css}/dataTables.bootstrap4.css" rel="stylesheet"/>

<link href="${css}/jquery.dataTables.css" rel="stylesheet"/>
 <%-- <link href="${css}/bootstrap.css" rel="stylesheet"/>  --%>



<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet"/>

</head>

<body>
   <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> -->  
   
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    
     <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.js"></script>


<!-- <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
   
     -->
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
     
      
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
			
			<!-- Single Product display   -->
			
			<c:if test="${userClickShowProduct==true}">
			     
				<%@include file="singleProduct.jsp"%>
			</c:if>
			
			<!-- Manage Products by  -->
			<c:if test="${userClickManageProducts==true}">
			     
				<%@include file="manageProducts.jsp"%>
			</c:if>
			
			
			
		</div>



		<!-- Footer -->
		<%@ include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<%-- <script src="${js}/jquery.js"></script> --%>
		 
		 
		 <!-- jaquer validator is not working to show product -->
		<%--   <script src="${js}/jquery.validate.js">
         <script src="${js}/jquery.validate.min.js"> --%>
         
	 	<%-- <script src="${js}/bootstrap.bundle.min.js"></script> --%>
        
        <!-- Jquary DataTables plugings -->
        <script src="${js}/jquery.dataTables.js"></script>
        
        
          <!-- DataTables bootstrap plugings -->
        <script src="${js}/dataTables.bootstrap.js"></script>
        
         <!-- DataTables bootstrap plugings -->
        <script src="${js}/dataTables.bootstrap4.js"></script> 
        
         
        <!-- bootbox js -->
      
         <script src="${js}/bootbox.min.js"></script>
         
         
        
        
        
           <%--   <script src="${js}/xyz.js">  --%>
        
		<!-- Self Coded of java Script -->
	 	    <script src="${js}/myapp.js">
			
		
		
		/* <script src="${js}/h.js"> */
			
		</script>
	</div>
</body>

</html>
