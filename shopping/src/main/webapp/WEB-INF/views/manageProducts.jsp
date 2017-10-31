<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
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
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h1>Fill Product Details</h1>
				</div>
				<div class="panel-body">
					<sf:form class="form-horizontal" modelAttribute="product"
							action="${contextRoot}/manage/products"
							method="POST"
							enctype="multipart/form-data"
							>
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter
								Product Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name"
									placeholder="Product Name" class="form-control" />
									<sf:errors path="name" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter
								Product Brand:</label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand"
									placeholder="Product Brand" class="form-control" />
									<sf:errors path="brand" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="description">Enter
								Product Description:</label>
							<div class="col-md-8">
								<sf:textarea path="description" id="description" rows="4"
									placeholder="Product Description" class="form-control"/>
									<sf:errors path="description" cssClass="help-block" element="em"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="unitPrice">Enter
								Product Unit-Price:</label>
							<div class="col-md-8">
								<sf:input type="text" path="unitPrice" id="unitPrice"
									placeholder="Product Unit-Price" class="form-control" />
									<sf:errors path="unitPrice" cssClass="help-block" element="em"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Enter
								Product Quantity:</label>
							<div class="col-md-8">
								<sf:input type="text" path="quantity" id="quantity"
									placeholder="Product Quantity" class="form-control" />
									<sf:errors path="quantity" cssClass="help-block" element="em"/>
							</div>
						</div>
						<!-- This is for File upload -->
						<div class="form-group">
							<label class="control-label col-md-4" for="file">Upload Image</label>
							<div class="col-md-8">
								<sf:input type="file" path="file" id="file"
									class="form-control" />
							</div>
						</div>
							<div class="form-group">
								<label class="control-label col-md-4" for="categoryId">Select Category:</label>
								<div class="col-md-8">
									<sf:select class="form-control" path="categoryId" id="categoryId"
										items="${categories}"
										itemLabel="ctgryName"
										itemValue="ctgryId"
									/>
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-offset-4 col-md-8">
									<input type="submit" name="submit" id="submit" value="Save"
										class="btn btn-info" />
								</div>
							</div>
							<!-- Hidden Fields -->
							<sf:hidden path="id"/>
							<sf:hidden path="code"/>
							<sf:hidden path="supplierId"/>
							<sf:hidden path="active"/>
							<sf:hidden path="purchases"/>
							<sf:hidden path="views"/>
					</sf:form>
				</div>
			</div>
		</div>
	</div>
</div>