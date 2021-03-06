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
    <%-- <link href="${css}/bootstrap.min.css" rel="stylesheet"/> 
  <link href="${css}/bootstrap.css" rel="stylesheet"/>  
    --%>
  <!-- BootsWatch for Project Theme -->

 
   <!--  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"/>  
   -->
   
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
   
   
   
  <!--  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"/>
 

 -->


 <!-- data TAbles for Bootstrap-->



<!-- data TAbles for Bootstrap-->
 

 <%-- <link href="${css}/bootstrap.css" rel="stylesheet"/>   --%>



<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet"/>

</head>

<body>
    <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    -->
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    
      <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.js"></script>
 
<!--  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    -->
    
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
     
      
	<div class="wrapper">

		<!-- Navigation -->

           <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	        <div class="container">
	            <!-- Brand and toggle get grouped for better mobile display -->
	            <div class="navbar-header">
	                <a class="navbar-brand" href="${contextRoot}/home">Online Shopping</a>
	            </div>
			</div>
		</nav>		
	


		<!-- Page Content -->

		<!-- loading home page content -->
				
				<div class="content">
			
   <div class="container">
    
   	 <c:if test="${not empty message}">
		<div class="row">
			<div class="col-xs-12 col-md-offset-2 col-md-8">
				<div class="alert alert-danger fade in">${message}</div>
			</div>
		</div>
	</c:if>
         
   	<%-- <c:if test="${not empty logout}">
		<div class="row">
			<div class="col-xs-12 col-md-offset-2 col-md-8">
				<div class="alert alert-success">${logout}</div>
			</div>
		</div>
	</c:if>  --%>
       
    <div class="row">
     
     <div class="col-md-offset-3 col-md-6">
      
      <div class="panel panel-primary">
       
       <div class="panel-heading">
        <h4>Login</h4>
       </div>
       
       <div class="panel-body">
        <form action="${contextRoot}/login" method="POST" class="form-horizontal"
         id="loginForm"
        >
         <div class="form-group">
          <label for="username" class="col-md-4 control-label">Email: </label>
          <div class="col-md-8">
           <input type="text" name="username" id="username" class="form-control"/>
          </div>
         </div>
         <div class="form-group">
          <label for="password" class="col-md-4 control-label">Password: </label>
          <div class="col-md-8">
           <input type="password" name="password" id="password" class="form-control"/>
          </div>
         </div>
         <div class="form-group">
          <div class="col-md-offset-4 col-md-8">
          <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
           <input type="submit" value="Login" class="btn btn-primary"/>
          </div>
         </div>
        </form>
       
       </div>
       <div class="panel-footer">
       <div class="text-left">
        <a href="${contextRoot}/forget">Forgot Email or Password</a>
       </div>
       	<div class="text-right">
       		New User - <a href="${contextRoot}/register">Register Here</a>
       	</div>
       </div>
      
      </div> 
    
     </div>
     
    </div>    
   
   </div>
</div>
					
			
			
		



		<!-- Footer -->
		<%@ include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		 <%--  <script src="${js}/jquery.js"></script>  --%>
		 
		 
		 <!-- jaquer validator is not working to show product -->
		 <%--   <script src="${js}/jquery.validate.js">
         <script src="${js}/jquery.validate.min.js">  --%>
         <%-- 
	 	 <script src="${js}/bootstrap.bundle.min.js"></script>  --%>
        
        
         
      
        
        
        
          
        
		<!-- Self Coded of java Script -->
	 	    <script src="${js}/myapp.js">
			
		
		
		
			
		</script>
	</div>
</body>

</html>
