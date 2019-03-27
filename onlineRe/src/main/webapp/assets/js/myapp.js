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

	/*
	 * var products = [
	 *  [ '1', 'ABC' ], [ '2', 'CYE' ], [ '3', 'DYR' ], [ '4', 'ABC' ], [ '5',
	 * 'ABC' ], [ '6', 'ABC' ], [ '7', 'KJH' ], [ '8', 'UYT' ],
	 *  ];
	 * 
	 * var $table = $('#productListTable'); if ($table.length) {
	 * console.log('Inside the table'); $table.DataTable({
	 * 
	 * data : products }); }
	 */

	var $table = $('#productListTable'); // excute this code only when we
											// have
	if ($table.length) { // console.log('Inside the table');

		var jsonUrl ="";
		if (window.categoryId =="") {
			jsonUrl =window.contextRoot+'/json/data/all/products';
			console.log(jsonUrl);
		} else {
			jsonUrl = window.contextRoot+'/json/data/category/'+ window.categoryId +'/products';
			console.log();
		}

		$table.DataTable({

			lengthMenu : [ [ 3, 5, 10, -1 ],
					[ '3 Records', '5 Records ', '10 Records', 'ALL' ] ],
			pageLength : 5,
			// data:products
			"serverSide": false,

		 "ajax":{

				"url" :jsonUrl,
				/*"type": "POST",
				"contentType": 'application/json; charset=utf-8',*/
				 'dataSrc':'',
					/* function (data) { 
					 return data = JSON.stringify(data);
				 }*/
				
				
                
				
			},
			coulmns: [ {
				data : 'name'
			}, {
				data : 'brand '
			}, {
				data : 'unitPrice'
			}, {
				data : 'quantity'
			}, ]

		});

	}

});