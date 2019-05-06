




$('.switch input[type="checkbox"]').on('change',function(){
	
		 var checkbox=$(this);
	  var checked=checkbox.prop('checked');
	  var dMsg=(checked)? 'You want activate the Product?':'yot want deactivate the Product?';
	  var value=checkbox.prop('value');
	  console.log("hi i am in www");
	  console.log(value);
	  bootbox.confirm({
		    size:'medium',
		    title:'Product activation or deactivation',
		    message:dMsg,
		    callback:function(confirmed){
		    	if(confirmed)
		    	{   
		    		console.log("hi this is in if confirmed");
		    		
		    		console.log(value);
		    		bootbox.alert({
		    			size:'medium',
		    		    title:'information',
		    		    message:'Your are going to perform on product'+value
		    		});
		    		
		    	}
		    	else{
		    		checkbox.prop('checked', !checked);
		    		console.log("Hi this is ");
		    	}
		    }
	        
	  });

 }); 


