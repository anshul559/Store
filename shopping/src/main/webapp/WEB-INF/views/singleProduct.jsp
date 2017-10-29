<div class="container">
	<div class="row">
		<div class="col-xs-12">
			<ol class="breadcrumb">
				<li><a href="${contextRoot}/Home">Home</a></li>
				<li><a href="${contextRoot}/show/all/products">Products</a></li>
				<li class="active">${product.name}</li>
			</ol>
		</div>
	</div>

	<div class="row">
		<!-- Display of Product image -->
		<div class="col-xs-12 col-sm-4">
			<div class="thumbnail">
					<img src="${images}/${product.code}.jpg" />				
			</div>
		</div>
		<!-- Display of Product Description -->
		<div class="col-xs-12 col-sm-8">
			<h3>${product.name}</h3>
			<hr>
			<p>${product.description}</p>
			<hr>
			<h4>
				Price: <strong> &#8360; ${product.unitPrice} /-</strong>
			</h4>
			<hr>
			<c:choose>
				<c:when test="${product.quantity < 1}">
					<h6>Qty. Available: <span style="color:red;"><strong>Out of Stock</strong></span></h6>
				</c:when>
				<c:otherwise>
					<h6>Qty. Available: ${product.quantity}</h6>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${product.quantity  < 1}">
					<a href="javascript:void(0)"
				class="btn btn-danger disabled"><span
				class="glyphicon glyphicon-shopping-cart"><del>Add to Cart</del></span></a>
				</c:when>
				<c:otherwise>
					<a href="${contextRoot}/cart/add/${product.id}/product"
				class="btn btn-danger"><span
				class="glyphicon glyphicon-shopping-cart">Add to Cart</span></a>
				</c:otherwise>
			</c:choose>
			
			 <a href="${contextRoot}/show/all/products" class="btn btn-info"><span
				class="glyphicon glyphicon-step-backward">Back</span></a>
		</div>
	</div>
</div>