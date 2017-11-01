$(document)
		.ready(
				function() {

					switch (menu) {
					case 'About us':
						$('#about').addClass('active');
						break;
					case 'Contact us':
						$('#contact').addClass('active');
						break;
					case 'View Product':
						$('#viewproduct').addClass('active');
						break;
					case 'Admin Add Products':
						$('#adminaddproducts').addClass('active');
						break;
					case 'Admin Show Products':
						$('#adminshowproducts').addClass('active');
						break;
					default:
						$('#home').addClass('active');
						break;
					}

					var jsonUrl = '';

					if (window.categoryId == '')
						jsonUrl = window.contextRoot + '/json/data/all/products';
					else
						jsonUrl = window.contextRoot + '/json/data/category/'
								+ window.categoryId + '/products';
					var $table = $('#productListTable');
					// Execute only when table have atleast 1 row
					if ($table.length) {
						console.log("Table is inserted");
						$table
								.dataTable({
									lengthMenu : [
											[ 3, 5, 10, -1 ],
											[ '3 Records', '5 Records',
													'10 Records', 'All Records' ] ],
									pageLength : -1,
									ajax : {
										url : jsonUrl,
										dataSrc : ''
									},
									columns : [
											{
												data : 'code',
												mRender : function(data, type,
														row) {
													return '<img src="'
															+ window.contextRoot
															+ '/resources/images/'
															+ data
															+ '.jpg" class="dataTableImg"/>';
												}
											},
											{
												data : 'name'
											},
											{
												data : 'brand'
											},
											{
												data : 'unitPrice',
												mRender : function(data, type,
														row) {
													return '&#8360; ' + data
												}
											},
											{
												data : 'quantity',
												mRender : function(data, type,
														row) {
													if (data < 1)
														return '<span style="color:red;"><strong>Out of Stock</strong></span>'
													else
													return data
												}
											},
											{
												data : 'id',
												bSortable : false,
												mRender : function(data, type,
														row) {
													var str = '';
													str += '<a href="'
															+ window.contextRoot
															+ '/show/'
															+ data
															+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';

													if (row.quantity < 1) {
														str += '<a href="javascript:void(0)" class="btn btn-danger disabled"><span class="glyphicon glyphicon-shopping-cart"></a>';
													} else {
														str += '<a href="'
																+ window.contextRoot
																+ '/cart/add/'
																+ data
																+ '/product" class="btn btn-danger"><span class="glyphicon glyphicon-shopping-cart"></a>';
													}

													return str
												}
											} ]
								});

					}

					var $alert = $('.alert');
					if ($alert.length) {
						setTimeout(function() {
							$alert.fadeOut('slow')
						}, 3000)
					}
					
					

					
					
					
					var jsonUrl = window.contextRoot + '/json/data/admin/all/products';

					var $productsTable = $('#adminTable');
					// Execute only when table have atleast 1 row
					if ($productsTable.length) {
						console.log("Table is inserted");
						$productsTable.dataTable({
							lengthMenu : [
								[ 10, 30, 50, -1 ],
								[ '10 Records', '30 Records',
										'50 Records', 'All Records' ] ],
						pageLength : -1,
						ajax : {
							url : jsonUrl,
							dataSrc : ''
						},
						columns : [
											{
												data : 'id'
											},
											{
												data : 'code',
												mRender : function(data, type,row) {
													return '<img src="'+ window.contextRoot + '/resources/images/' + data + '.jpg" class="adminDataTableImg"/>'
												}
											},
											{
												data : 'name'
											},
											{
												data : 'brand'
											},
											{
												data : 'description'
											},
											{
												data : 'unitPrice',
												mRender : function(data, type, row) {
													return '&#8360; ' + data
												}
											},
											{
												data : 'quantity',
												mRender : function(data, type,row) {
													if (data < 1)
														return '<span><strong>Out of Stock</strong></span>'
													else
													return data
												}
											},
											{
												data : 'active',
												mRender : function(data, type, row){
													str = '';
													str += '<label class="switch">';
													if(data)
														str += '<input type="checkbox" checked value="'+row.id+'">';
													else
														str += '<input type="checkbox" value="'+row.id+'">';
													str += '<span class="slider round"></span></label>';
													return str
												}
											},
											{
												data : 'id',
												bSortable : false,
												mRender : function(data, type, row){
													str = '';
													str += '<a href="${contextRoot}/manage/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a>';
													return str
												}
												
											} 
										],
										
										initComplete: function(){
											var api = this.api();
											api.$('.switch input[type="checkbox"]')
											.on(
													'change',
													function() {
														var checkbox = $(this);
														var check = checkbox.prop('checked');
														dMsg = (check) ? 'You want to Activate this Product'
																: 'You want to Deactivate this Product';
														var value = checkbox.prop('value');

														bootbox
																.confirm({
																	size : 'small',
																	align: 'center',
																	title : 'Product Activate or Deactivate',
																	message : dMsg,
																	callback : function(
																			confirmed) {
																		if (confirmed) {
																			console
																					.log("Value is-"
																							+ value
																							+ " and Check is-"
																							+ check);
																			bootbox
																					.alert({
																						size : "medium",
																						title : "Information about Product",
																						message : "You are doing Operation on Product "
																								+ value
																					});
																		} else {
																			checkbox.prop(
																					'checked',
																					!check);
																		}
																	}
																});

													});
										}
								});

					}
					
				});