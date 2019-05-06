
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<div class="row">
	
	<div class="row">
		<div class="col-xs-12">
		<h3>Available Products</h3>
		<hr/>
		
		</div>
		<div class="col-xs-12">
		      <div style="overflow:auto">
		            <table id="adminProductTable" class="table table-striped table-bordered">
		            <thead>
		               <tr>
		                <th>ID</th>
		                <th>&#160;</th>
		                <th>Brand</th>
		                <th>Name</th>
		                <th>Quantity</th>
		                <th>Unit Price</th>
		                <th>Active</th> 
		                <th>Edit</th>	 	
		                </tr>
		            </thead>
		            <tbody>
		           <%--  <tr>
		               <td>4</td>
		               <td>
		               <img class="adminDataTableImg" src="${contextRoot}/resources/images/PRDABC123DEFX.jpg  "
		                 alt="Mackboo"/>         
		              		       
		               </td>
		               <td>Apple</td>
		               <td>Mackboook Pro</td>
		               <td>8</td>
		               <td>&#8377; 54000/-</td>
		               <td>
		                  <label class="switch">
		                  <input type="checkbox" checked="checked" value="4"/>
		                  <div class="slider"></div>
		                  
		                  </label>
		               
		               </td>
		               <td>
		               <a href="${contextRoot }/manage/4/product" class="btn btn-warning">
		                 <span class="glyphicon glyphicon-pencil"></span>
		               </a>
		               </td>
		            </tr>
		            
		            
		             <tr>
		               <td>4</td>
		               <td>
		               <img class="adminDataTableImg" src="${contextRoot}/resources/images/PRD5E11B15A9D.jpg "
		                 alt="Mackboo"/>         
		              		       
		               </td>
		               <td>Sumsung</td>
		               <td>Mackboook Pro</td>
		               <td>8</td>
		               <td>&#8377; 54000/-</td>
		               <td>
		                  <label class="switch">
		                  <input type="checkbox" checked="checked" value="4"/>
		                  <div class="slider"></div>
		                  
		                  </label>
		               
		               </td>
		               <td>
		               <a href="${contextRoot }/manage/4/product" class="btn btn-warning">
		                 <span class="glyphicon glyphicon-pencil"></span>
		               </a>
		               </td>
		            </tr>
		            
		            </tbody>
		             --%>
		            <tfoot>
		            <tr>
		                <th>ID</th>
		                <th>&#160;</th>
		                <th>Brand</th>
		                <th>Name</th>
		                <th>Quantity</th>
		                <th>Unit Price</th>
		                <th>Active</th> 
		                <th>Edit</th>	 	
		                </tr>
		            </tfoot>
		            </table>
		      </div>
		
		</div>
			<c:if test="${not empty message }">
			<div class="col-xs-12">
				<div class="alert alert-success alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<span style="color: #006400"> ${message}</span>

				</div>
			</div>
		</c:if>




		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Product Management</h4>



				</div>

				<div class="panel-body">

					<!-- Srart Form Here -->

					<sf:form class="horizontol" modelAttribute="product"
						action="/onlineRe/manage/products" method="POST"
						enctype="multipart/form-data">


						<!-- For product name Div -->
						<div class="form-group">

							<label class="control-label col-md-4" for="name">Enter
								Product Name: </label>

							<div class="col-md-8">
								<sf:input type="text" path="name" id="name"
									placeholder="Product Name" class="form-control" />
								<!-- <em class="help-block">please enter Product Name!!</em> -->

								<sf:errors path="name" cssClass="help-block" element="em" />
							</div>

						</div>&#160;

	<!-- for Brand  -->
						<div class="form-group">

							<label class="control-label col-md-4" for="brand">Enter
								Brand Name: </label>

							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand"
									placeholder="Brand Name" class="form-control" />
								<!-- <em
									class="help-block">please enter Brand Name!!</em> -->

								<sf:errors path="brand" cssClass="help-block" element="em" />
							</div>

						</div>&#160;
						
	<!-- for discription -->

						<div class="form-group">

							<label class="control-label col-md-4" for="brand">Product
								Description: </label>

							<div class="col-md-8">
								<sf:textarea path="description" id="description" rows="4"
									placeholder="write a description here!!!" class="form-control" />

								<sf:errors path="description" cssClass="help-block" element="em" />

							</div>

						</div>&#160;

<!-- for unit Price  -->
						<div class="form-group">

							<label class="control-label col-md-4" for="brand">Enter
								Unit Price: </label>

							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" id="unit"
									placeholder="unitPrice" class="form-control" />
								<!--  <em
									class="help-block">please enter Unit price!!</em> -->

								<sf:errors path="unitPrice" cssClass="help-block" element="em" />
							</div>

						</div>&#160;
						
<!-- File upload  -->
						<div class="form-group">

							<label class="control-label col-md-4" for="file">Upload
								Image: </label>

							<div class="col-md-8">
								<sf:input type="file" path="file" id="file" class="form-control" />
								<!--  <em class="help-block">please enter Unit price!!</em> -->

								<sf:errors path="file" cssClass="help-block" element="em" />
							</div>

						</div>&#160;
                         					
						
    <!-- for quantity Available -->
						<div class="form-group">

							<label class="control-label col-md-4" for="brand">Enter
								Quantity: </label>

							<div class="col-md-8">
								<sf:input type="number" path="quantity" id="quantity"
									placeholder="Enter Product quantity" class="form-control" />
							</div>

						</div>&#160;
						
						<!-- for category -->
						<div class="from-group">
							<label class="control-label col-md-4" for="categoryId">Select
								Category:</label>
							<div class="col-md-8">
								<sf:select class="form-control" path="categoryId"
									id="categoryId" items="${categories}" itemLabel="name"
									itemValue="id" />
									<c:if test='${product.id ==0 }'>
									   <div class="text-right">
									  <br/>
									  <button type="button" data-toggle="modal" data-target="#myCategoryModal" class="btn btn-warning btn-sm">Add Category</button>
									</div>
									</c:if>

							</div>
						</div>&#160;
                                    
<!-- for Button of submit -->
						<div class="form-group">



							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="submit" value="Submit"
									class="btn btn-primary" />

								<!-- all the filds of HIdden -->
								<sf:hidden path="id" />
								<sf:hidden path="code" />
								<sf:hidden path="supplierId" />
								<sf:hidden path="views" />
								<sf:hidden path="purchases" />
								<sf:hidden path="active" />
							</div>

						</div>



					</sf:form>


				</div>

			</div>
			      
			      
			       <!-- Modol start here  -->
               <div class="modal fade" id="myCategoryModal" role="dialog" tabindex="-1" aria-labelledby="myModalLabel">
               
                 <div class="modal-dialog" role="document">
                    <div class="modal-content">
                    <!-- Modol header -->
                       <div class="modal-header">
                          <button type="button" class="close" data-dismiss="modal">
                          <span>&times;</span>
                          </button>
                       <h4 class="modal-title">Add New Category</h4>
                       </div>
                       <div class="modal-body">
                       <!-- create category form -->
                       <sf:form id="categoryForm" modelAttribute="category" action="/onlineRe/manage/category" method="post" class="form-horizontol">
                           
                           
                           <!-- for category Name  -->
                            <div class="form-group">
                            <lable for="category_name" class="control-label col-md-4" >Category Name:</lable>
                            <div class="col-md-8">
                               <sf:input type="text" path="name" id="category_name" class="form-control"/>
                            
                            </div>
                            
                            </div>
                       <!-- for category description -->
                       
                        <div class="form-group">
                            <lable for="category_description" class="control-label col-md-4" >Description</lable>
                            <div class="col-md-8">
                               <sf:textarea type="text" cols="" rows="4" path="description" id="category_description" class="form-control"/>
                            </div>
                            </div>
                       <!-- for button  -->
                                <div class="form-group">
                                     <div class=col-md-offset-4 col-md-8>
                                     
                                     <input type="submit" value="Add Category" class="btn btn-primary"/>
                                     
                                     </div>
                           
                                </div>
                       
                       </sf:form>
                           
                       </div>
                    </div>
                 </div>
               </div><!-- Modol close --> 
			      
			      
		</div>
		
	</div>
	                
	
		</div>
		 
		   
		          
		      

</div>
    
		      