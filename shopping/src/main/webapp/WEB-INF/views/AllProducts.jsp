<div class="container more">
	<div class="row">
		<!-- This tag for Sidebar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp" %>
		</div>
		
		<div class="col-md-9">
		<!-- Added Breadcrumb Component -->
			<div class="row">
				<div class="col-Lg-12">
				<c:if test="${userClickAllProducts == true}">
					<script>
							window.categoryId = '';
					</script>
					<ol class="breadcrumb">
						<li><a href="${contextRoot}/home">Home</a></li>
						<li class="active">All Products</li>
					</ol>
				</c:if>
				
				<c:if test="${userClickCategoryProduct == true}">
					<script>
							window.categoryId = '${category.ctgryId}';
					</script>
					<ol class="breadcrumb">
						<li><a href="${contextRoot}/home">Home</a></li>
						<li class="active">Category</li>
						<li class="active">${category.ctgryName}</li>
					</ol>
				</c:if>		
				</div>
			</div>

		<div class="row">
			<div class="col-xs-12">
				<table class="table table-striped table-bordered" id="productListTable">
					<thead>
						<tr>
							<th>Image</th>
							<th>NAME</th>
							<th>BRAND</th>
							<th>PRICE</th>
							<th>QUANTITY Available</th>
							<th></th>
						</tr>
					</thead>
					
					<tfoot>
						<tr>
							<th>Image</th>
							<th>NAME</th>
							<th>BRAND</th>
							<th>PRICE</th>
							<th>QUANTITY Available</th>
							<th></th>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
		</div>
	</div>
</div>