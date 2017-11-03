<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<div class="row">
		<c:if test="${not empty msg}">
			<div class="col-xs-12">
				<div class="alert alert-success alert-dismissable">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${msg}
				</div>
			</div>
		</c:if>
		<div class="col-md-offset-2 col-md-8">
			<c:if test="${edit == false}">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h1>Fill Product Details</h1>
			</c:if>
			<c:if test="${edit == true}">
				<div class="panel panel-danger">
					<div class="panel-heading" >
						<h1>Edit Product Details</h1>
			</c:if>
				</div>
				<div class="panel-body">
					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/adminaddproducts" method="POST"
						enctype="multipart/form-data">
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter
								Product Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name"
									placeholder="Product Name" class="form-control" />
								<sf:errors path="name" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter
								Product Brand:</label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand"
									placeholder="Product Brand" class="form-control" />
								<sf:errors path="brand" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="description">Enter
								Product Description:</label>
							<div class="col-md-8">
								<sf:textarea path="description" id="description" rows="4"
									placeholder="Product Description" class="form-control" />
								<sf:errors path="description" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="unitPrice">Enter
								Product Unit-Price:</label>
							<div class="col-md-8">
								<sf:input type="text" path="unitPrice" id="unitPrice"
									placeholder="Product Unit-Price" class="form-control" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Enter
								Product Quantity:</label>
							<div class="col-md-8">
								<sf:input type="text" path="quantity" id="quantity"
									placeholder="Product Quantity" class="form-control" />
								<sf:errors path="quantity" cssClass="help-block" element="em" />
							</div>
						</div>
						<!-- This is for File upload -->
						<div class="form-group">
							<c:if test="${edit == false}">
							<label class="control-label col-md-4" for="file">Upload Image</label>
							</c:if>
							<c:if test="${edit == true}">
							<label class="control-label col-md-4" for="file">Upload Image if you want to override previous one</label>
							</c:if>
							<div class="col-md-8">
								<sf:input type="file" path="file" id="file" class="form-control" />
								<sf:errors path="file" cssClass="help-block" element="em" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="categoryId">Select
								Category:</label>
							<div class="col-md-8">
								<sf:select class="form-control" path="categoryId"
									id="categoryId" items="${categories}" itemLabel="ctgryName"
									itemValue="ctgryId" />
									
									<c:if test="${product.id == 0}">
										<br>
										<div class="text-right">
											<button type="button" data-toggle="modal" data-target="#myModal" class="btn btn-warning btn-xs">Add Category</button>
										</div>
									</c:if>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="submit" value="Save"
									class="btn btn-info" />
							</div>
						</div>
						<!-- Hidden Fields -->
						<sf:hidden path="id" />
						<sf:hidden path="code" />
						<sf:hidden path="supplierId" />
						<sf:hidden path="active" />
						<sf:hidden path="purchases" />
						<sf:hidden path="views" />
					</sf:form>
				</div>
			</div>
			<div id="myModal" class="modal fade" role="dialog">
			  <div class="modal-dialog">
			
			    <!-- Modal content-->
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			        <h4 class="modal-title">Add Category Details</h4>
			      </div>
			      <div class="modal-body">
			      	<sf:form id="categoryForm" class="form-horizontal" modelAttribute="category"
						action="${contextRoot}/manage/category" method="POST">
					
						
						<div class="form-group">
							<label class="control-label col-md-4" for="ctgryName">Enter
								Category Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="ctgryName" id="ctgryName"
									placeholder="Category Name" class="form-control" />
								 <%-- <sf:errors path="ctgryName"  element="em" /> --%> 
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="ctgryDesc">Enter
								Category Description:</label>
							<div class="col-md-8">
								<sf:textarea rows="4" path="ctgryDesc" id="ctgryDesc"
									placeholder="Category Description" class="form-control" />
								 <%-- <sf:errors path="ctgryDesc"  element="em" />  --%>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="Category_submit" value="Save"
									class="btn btn-success" />
							</div>
						</div>
						</sf:form>
			      </div>
			    </div>
			
			  </div>
			</div>
</div>
	