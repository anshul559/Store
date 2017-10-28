$(document).ready(function(){
	
	switch(menu){
	case 'About us': $('#about').addClass('active');
	break;
	case 'Contact us': $('#contact').addClass('active');
	break;
	case 'View Product': $('#viewproduct').addClass('active');
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
			pageLength: 5,
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
							data: 'quantity'
						},
						{
							data: 'id',
							bSortable: false,
							mRender: function(data, type, row){
								var str = '';
								str += '<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
								str += '<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-danger"><span class="glyphicon glyphicon-shopping-cart"></a>';
								return str
							}
						}
					]
		});
		
		
	}
	
	
});