$(function() {
	// solving Active menu problem
	switch (menu) {
	case 'About Us':
		$('#about').addClass('active');
		break;

	case 'Contact':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#ListProduct').addClass('active');
		break;
	default:
		if (menu == "Home")
			break;
		$('#ListProduct').addClass('active');
		break;

	}
	
	
	//to tackle the csrf token
	var token=$('meta[name="_csrf"]').attr('content');
	var header=$('meta[name="_csrf_header"]').attr('content');
	if(token.length > 0 && header.length >0){
		$(document).ajaxSend(function(e,xhr,options){
			xhr.setRequestHeader(header,token);
		});
	}

	// code for jquary datatables

	
	/* var products = [
	   [ '1', 'ABhhhhhhhhhhhhhhhhhC' ,'1800','5'], [ '2', 'CYE' ], [ '3', 'DYR' ], [ '4', 'ABC' ], [ '5',
	  'ABC' ], [ '6', 'ABC' ], [ '7', 'KJH' ], [ '8', 'UYT' ],
	   ];
	*/
	 

	  var $table = $('#productListTable');
	  if ($table.length) {
	  console.log('Inside the table');
	  
	  var jsonUrl ="";
		if (window.categoryId =="") {
			jsonUrl ='http://localhost:9090/onlineRe/json/data/all/products';
			/*jsonUrl =window.contextRoot+'/json/data/all/products';*/
			console.log("all produts");
			console.log(jsonUrl);
		} else {
			jsonUrl = 'http://localhost:9090/onlineRe/json/data/category/'+window.categoryId+'/products';
			
			console.log(window.categoryId);
		}
		
	  $table.DataTable({
		  lengthMenu : [ [ 3, 5, 10, -1 ],
				[ '3 Records', '5 Records ', '10 Records', 'ALL' ] ],
		pageLength : 5,
	     ajax:{
	    	 url:jsonUrl,
	    	dataSrc:'',
	    	
	        
	     },
	     columns: [
	    	   
	    	      {data:'code',
	    	    	mRender:function(data,type,row)
	    	    	{
	    	    		return '<img src="/onlineRe/resources/images/'+data+'.jpg" height="100px" width="100px"/>';
	    	    		
	    	    	}
	    	           	  
	    	      
	    	      
	    	      
	    	      
	    	      },
	    	
	    	 
				{
				data : 'name'
			    }, 
			{
				data : 'brand'
			},
			 {
				'data' : 'unitPrice',
				mRender :function(data,type,row){
					return "$ " +data;
					
					}
			 },
			{
				data : 'quantity',
				mRender:function(data,type,row)
				{
					if(data<1)
						{
						   return '<span style="color:red">Out of Stock!</span>';
						}
					  return data;
				}
			},
			{
				data:'id',
		    	bSortable:false,
				mRender:function(data,type,row){
					var str='';
					str +='<a href="http://localhost:9090/onlineRe/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160';
					
					if(row.quantity<1)
						{
						
						str +='<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
						
						}
					else
						{
						str +='<a href="http://localhost:9090/onlineRe/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
						}
					
					return str; 
					
				}
			}
			]
	  });
	  }
	

	/*var $table = $('#productListTable'); // excute this code only when we
											// have
	if ($table.length) { // console.log('Inside the table');

		var jsonUrl ="";
		if (window.categoryId =="") {
			jsonUrl =window.contextRoot+'/json/data/all/products';
			console.log(jsonUrl);
		} else {
			jsonUrl = window.contextRoot+'/json/data/category/'+ window.categoryId +'/products';
			
			console.log(window.categoryId);
		}

		$('#productListTable').DataTable({

			lengthMenu : [ [ 3, 5, 10, -1 ],
					[ '3 Records', '5 Records ', '10 Records', 'ALL' ] ],
			pageLength : 5,
			// data:products
			

		 ajax:{

				url:jsonUrl,
			 dataSrc:'',
					 
				
				
                
				
			},
			columns:: [
				{
				data : 'name'
			    }, 
			{
				data : 'brand '
			},
			 {
				data : 'unitPrice'
			 },
			{
				data : 'quantity'
			} 
			]

		});


	}
*/
    var $alert=$('.alert');
    if($alert.length)
    	{
    	     setTimeout(function(){
    	    	 $alert.fadeOut('slow');
    	     },300);
    	}
	  
/*
 * for avalable produdats datatables
  */  
   // jqueery datatables for admin products
    
    
     var $productTable=$('#adminProductTable');  
     if($productTable.length){
    	 console.log("hiaaaaaaaaii");
    	  var ajsonAdminUrl='http://localhost:9090/onlineRe/json/data/admin/all/products';
    	  console.log("hiii");
    	  
    	  $productTable.DataTable({
    		
    		 lengthMenu:[[10,30,50,-1],['10 Record','30 Records','50 Records','ALL']],
    		 pageLength:10,
    		 ajax:{
    			 url:ajsonAdminUrl,
    	       dataSrc:'',
    		 },
    		 columns:[
                       {data:'id'},
                       {
                    	   data:'code',
                    	   mRender:function(data,type,row){
                    		      
                    		   return '<img class="adminDataTableImg" src="/onlineRe/resources/images/'+data+'.jpg"/>';
                    	   }
                       
                       },
                       {data:'brand'},
                       {data:'name'},
                       {data:'quantity'},
                       {data:'unitPrice'},
                       {
                    	   data:'active',
                    	   mRender:function(data,type,row){
                    		   var str='';
                    		   str+='<label class="switch">';
                    		   if(data){
                    			   str+='<input type="checkbox" checked="checked" value="'+row.id+'"/>';
                    		   }
                    		   else
                    			   {
                    			    str+='<input type="checkbox" value="'+row.id+'"/>';
                    			   }
                    		   str+='<div class="slider"></div></label>';
                    		   return str;
                    	   }
                       
                       },
                       {data:'id',
                       mRender:function(data,type,row){
                    	     var str='';
                    	     str+='<a href="/onlineRe/manage/'+data+'/product" class="btn btn-warning">';
                    	    str+='<span class="glyphicon glyphicon-pencil"></span></a>';
                    	     return str;
                    	   
                       }
                       
                       }
                       ],
    			        initComplete:function(){
    			        	
    			        	var api=this.api();
    			           /* api.$('.switch input[type="checkbox"]').on('change',function(){
    			            	 
    			            	 bootbox.confirm("Hello world!", function() {
    			                     console.log("Alert Callback");
    			                 });
    			                  });*/
    			        	
    			        	api.$('.switch input[type="checkbox"]').on('change',function(){
    			        		
    			       		 var checkbox=$(this);
    			       	  var checked=checkbox.prop('checked');
    			       	  var dMsg=(checked)? 'You want activate the Product?':'yot want deactivate the Product?';
    			       	  var value=checkbox.prop('value');
    			       	  console.log("hi i am in www");
    			       	  console.log(value);
    			       	  bootbox.confirm({
    			       		    size:'medium',
    			       		    title:'Product activation or deactivation??',
    			       		    message:dMsg,
    			       		    callback:function(confirmed){
    			       		    	if(confirmed)
    			       		    	{   
    			       		    		console.log("hi this is in if confirmed");
    			       		    		
    			       		    		var activationUrl='http://localhost:9090/onlineRe/manage/product/'+value+'/activation';
    			       		    		/*var activationUrl=window.contextRoot +'/manage/product/'+value+'/activation';*/
    			       		    		$.post(activationUrl,function(data){
    			       		    			console.log("yes in post");
    			       		    			bootbox.alert({
        			       		    			size:'medium',
        			       		    		    title:'Information',
        			       		    		    message:data
        			       		    		});
    			       		    			  
    			       		    		});
    			       		    		
    			       		    		console.log(value);
    			       		    		
    			       		    		
    			       		    	}
    			       		    	else{
    			       		    		checkbox.prop('checked', !checked);
    			       		    		console.log("Hi this is ");
    			       		    	}
    			       		    }
    			       	        
    			       	  });

    			        });
    			        	
    			            		
    			              
    			            	
    			       	
    			        //switch ends

    			        }//initcomplete end
    			     
    			 
    		
    			 
    			 
    		 
    	 });
    	 
    	 
    	 
    	 
    		 }
     
   //validation cade start for jquery validation
	 
	 var $categoryForm=$('#categoryForm');
	 if($categoryForm.length){
		 $categoryForm.validate({
			 rules:{
				 
				 name:{
					 required:true,
					 minlength:2
		             
				 },
				 description:{
					required:true,
					minlength:2
				 },
				 messages:{
					 name:{
						 required:'Please Enter the Category Name',
						 minlength:'Category name is not less than 2 cahracters'
					 },
					 description:{
						 required:'please Enter the Description',
						
					 },
					 
					 
				 },
				 errorElement:'em',
				 errorPlacement:function(error,element){
					 //add the class of help-block
					 error.addClass('help-block');
					 //add the error after insert element
					 error.insertAfter(element);
				 }
				 
			 }
			 
		 });
		 
	 }//validation ends
	 
	 //validation for login 
	 
	 var loginForm=$('#loginForm');
	 if($loginForm.length){
		 $loginForm.validate({
			 rules:{
				 
				 username:{
					 required:true,
					 email:true
		             
				 },
				 password:{
					required:true,
					
				 },
				 messages:{
					 username:{
						 required:'Please Enter the User Name!',
						 email:'please enter valid email address!'
					 },
					 password:{
						 required:'please Enter the Password',
						
					 },
					 
					 
				 },
				 errorElement:'em',
				 errorPlacement:function(error,element){
					 //add the class of help-block
					 error.addClass('help-block');
					 //add the error after insert element
					 error.insertAfter(element);
				 }
				 
			 }
			 
		 });
		 
	 }//validation login ends

	 
	 	
});







