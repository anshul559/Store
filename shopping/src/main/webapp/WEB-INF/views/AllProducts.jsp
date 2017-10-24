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
					<ol class="breadcrumb">
						<li><a href="${contextRoot}/home">Home</a></li>
						<li class="active">All Products</li>
					</ol>
				</c:if>
				
				<c:if test="${userClickCategoryProduct == true}">
					<ol class="breadcrumb">
						<li><a href="${contextRoot}/home">Home</a></li>
						<li class="active">Category</li>
						<li class="active">${category.ctgryName}</li>
					</ol>
				</c:if>		
				</div>
			</div>
		</div>
	</div>
</div>