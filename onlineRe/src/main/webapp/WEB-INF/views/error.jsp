



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css"></spring:url>








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
 
<link href="${css}/Bootswatch-them.css" rel="stylesheet"/>
  <link href="${css}/bootstrap.min.css" rel="stylesheet"/> 
  
  <!-- BootsWatch for Project Theme -->


 <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" />  





 <!-- data TAbles for Bootstrap-->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet"/>


<!-- data TAbles for Bootstrap-->
 

 <link href="${css}/dataTables.bootstrap4.css" rel="stylesheet"/>

<link href="${css}/jquery.dataTables.css" rel="stylesheet"/>
<link href="${css}/bootstrap.css" rel="stylesheet"/>



<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet"/>

</head>

<body>
      
      <nav>
	<div class="wrapper">

		<!-- Navigation -->

		<div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto" id="home">
          <li class="nav-item active">
            <a class="nav-link" href="${contextRoot}/home">Home
              <span class="sr-only">(current)</span>
            </a>
            </li>
            </ul>
            </div>

</div>
	</nav>
	
	<div class="content">
	<div class="container">
	<div class="row">
	<div class="col-xs-12">
	     <div class="jumbottron">
	     <h1>${errorTitle}</h1>
	     <hr/>
	     <blockquote>
	     
	     ${errorDescription}
	     
	     </blockquote>
	     
	     
	     </div>
	
	</div>
	</div>
	
	
	
	
	
	
	
	</div>
	
	
	
	
	
	</div>
	
	
	

		<!-- Page Content -->

					
		



		<!-- Footer -->
		<%@ include file="./shared/footer.jsp"%>

		        
         
        
      
        
        
        
	
</body>

</html>
 