$(document).ready(function(){
	
	switch(menu){
	case 'About us': $('#about').addClass('active');
	break;
	case 'Contact us': $('#contact').addClass('active');
	break;
	case 'View Product': $('#viewproduct').addClass('active');
	break;
	case 'Manage Products': $('#manageproducts').addClass('active');
	break;
	default : $('#home').addClass('active');
	break;
	}
	

	
	var jsonUrl = '';
	
	 if(window.categoryId == '')
		 jsonUrl = window.contextRoot+'/json/data/all/products';
	 else
		 jsonUrl = window.contextRoot+'/json/data/category/'+window.categoryId+'/products';
	var $table = $('#productListTable');
//	Execute only when table have atleast 1 row
	if($table.length){
		console.log("Table is inserted");
		$table.dataTable({
			lengthMenu: [[3,5,10,-1], ['3 Records','5 Records','10 Records','All Records']],
			pageLength: -1,
			ajax:{
				url: jsonUrl,
				dataSrc: ''
			},
			columns: [
						{
							data: 'code',
							mRender: function(data, type, row){
								return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>';
							}
						},
						{
							data: 'name'
						},
						{
							data: 'brand'
						},
						{
							data: 'unitPrice',
							mRender: function(data, type, row){
								return '&#8360; '+ data
							}
						},
						{
							data: 'quantity',
							mRender: function(data, type, row){
								if(data < 1)
									return '<span style="color:red;"><strong>Out of Stock</strong></span>'
								
									return data
							}
						},
						{
							data: 'id',
							bSortable: false,
							mRender: function(data, type, row){
								var str = '';
								str += '<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
								
								if(row.quantity < 1){
									str += '<a href="javascript:void(0)" class="btn btn-danger disabled"><span class="glyphicon glyphicon-shopping-cart"></a>';
								}
								else {
									str += '<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-danger"><span class="glyphicon glyphicon-shopping-cart"></a>';
								}
						
								return str
							}
						}
					]
		});
		
		
	}
	
	var $alert = $('.alert');
		if($alert.length){
			setTimeut(function(){
				$alert.fadeOut('slow')
			}, 3000)
		}
	
	
});