
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-ex1-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand blue" href="#">Shopping</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav">
				<li id="home"><a href="${contextRoot}/home">Home</a></li>
				<li id="about"><a href="${contextRoot}/about">About us</a></li>
				<li id="viewproduct"><a href="${contextRoot}/show/all/products">View
						Products</a></li>
				<li id="contact"><a href="${contextRoot}/contact">Contact
						us</a>
				</li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown">Admin Manage Products<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li id="adminaddproducts"><a href="${contextRoot}/manage/adminaddproducts">Admin Add Products</a></li>
							<li id="adminshowproducts"><a href="${contextRoot}/manage/adminshowproducts">Admin Show Products</a></li>
						</ul>
				</li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>
