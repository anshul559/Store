<p class="lead">Shop Name</p>
<div class="list-group">
	<c:forEach items="${ctgries}" var="ctgr">
		<a href="${contextRoot}/show/category/${ctgr.ctgryId}/products" class="list-group-item">${ctgr.ctgryName}</a>
	</c:forEach>

	<!-- <a href="#" class="list-group-item">Printable</a> 
	<a href="#" class="list-group-item">Cupcake Wrappers</a> 
	<a href="#" class="list-group-item">Authentic Dragon Bones</a> -->
</div>