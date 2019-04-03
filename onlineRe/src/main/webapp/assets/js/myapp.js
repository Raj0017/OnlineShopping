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


	
});
