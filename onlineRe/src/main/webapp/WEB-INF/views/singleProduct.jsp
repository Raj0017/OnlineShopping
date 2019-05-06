







 <div class="container">

	<div class="row">
		<div class="col-xs-12">
			<ol class="breadcrumb">
				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/products">Product</a></li>
				<li class="active">${product.name}</li>
			</ol>


		</div>


	</div>
  <div class="row">
	<!-- Display The Product Image -->
	<div class="col-xs-12 col-sm-4">
	     <div class="thumbnail">
	       <img src="${images}/${product.code}.jpg" class="img img-responsive"/>
	     </div>
	
	</div>
	<!-- Display the Product Description  -->
         <div class="col-xs-12 col-sm-8">  
         <h3>${product.name}</h3>
         <hr/>
         <p>${product.description}</p>
         <hr/>
         <h4>Price:<strong>$ ${product.unitPrice}</strong></h4>
         <hr/>         
           
             <c:choose>
                 <c:when test="${product.quantity < 1}">
                       <strong>Qty.Available: <span style="color:red">Out of Stock!</span></strong>
                 </c:when>
                 <c:otherwise>
                       <h6><strong>Qty.Available:<span style="color:green"> ${product.quantity}</span></strong></h6>
                 </c:otherwise>
           </c:choose> 
           <br><br>
           
             <c:choose>
                 <c:when test="${product.quantity < 1}">
          <a href="javascript:void(0)" class="btn btn-success disabled"><strike><span class="glyphicon glyphicon-shopping-cart"></span>&#160 Add to Cart</a></strike>&#160
           
                 </c:when>
                 <c:otherwise>
                  <a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span>&#160 Add to Cart</a>&#160
                      
                 </c:otherwise>
           </c:choose> 
           
           
           
           
           
           <a href="${contextRoot}/show/all/products" class="btn btn-primary">Back</a>
         </div>
	</div> 

 </div>  