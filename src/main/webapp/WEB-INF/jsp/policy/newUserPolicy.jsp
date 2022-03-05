<jsp:include page="../include/userHeader.jsp" />

<body style="background-image: linear-gradient(#ffd89b ,#19547b); "
 onload="getAllPolicies()">
	<h1>
		<center>
			<h1>Apply For New Policy</h1>
		</center>
	</h1>

	<form action="/bookPolicy" method="POST">
		<input type="hidden" name="id" value="${formBeanKey.id}">

		<c:if test="${errorMsg}"><span style="margin-left: 716px;color: red;">${errorMsg}</span></c:if>
		<div class="container">
			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-10">
					<div class="well well-sm">


						<div class="row">

							<div class="col-md-6">
								<div class="form-group">
									<label for="email"> First Name</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="glyphicon glyphicon-user"></span> </span> <input type="text"
											name="firstName" class="form-control"
											placeholder="Enter first Name"
											value="${formBeanKey.firstName}" required="required">

									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="email"> Last Name</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="glyphicon glyphicon-user"></span> </span> <input type="text"
											class="form-control" placeholder="Enter last Name"
											name="lastName" value="${formBeanKey.lastName}"
											required="required">

									</div>
								</div>
							</div>
						</div>





						<div class="row">

							<div class="col-md-6">
								<div class="form-group">
									<label for="email">Age</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="glyphicon glyphicon-user"></span> </span> <input type="text"
											class="form-control" id="age" name="age"placeholder="Enter your age"></input>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="email"> Phone</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="glyphicon glyphicon-phone"></span> </span> <input type="text"
											id="Phone" class="form-control" name="phone"
											placeholder="Enter Phone Number" minlength="10"
											maxlength="10">

									</div>
								</div>
							</div>
						</div>


						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="email">Gender</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="glyphicon glyphicon-user"></span> </span> <select
											class="form-control" id="" name="gender">

											<option value="Male">Male</option>

											<option value="Female">Female</option>


										</select>
									</div>
								</div>
							</div>

							<div class="col-md-6">
								<div class="form-group">
									<label for="email">Zip code</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="glyphicon glyphicon-home"></span> </span> <input type="text"
											class="form-control" id="zipCode" name="zipCode"placeholder="Enter Zip Code"></input>
									</div>
								</div>
							</div>
						</div>




						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="email">Policy Category</label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="glyphicon glyphicon-book"></span> </span> <select
											class="form-control" id="categoryId" name="category"
											onchange="getPolicyName()"></select>
									</div>
								</div>
							</div>

							<div class="col-md-6">
								<div class="form-group">
									<label for="email">Policy Category Name </label>
									<div class="input-group">
										<span class="input-group-addon"><span
											class="glyphicon glyphicon-book"></span> </span> <select
											class="form-control" id="categoryNameId" name="categoryName"placeholder="Name of category"></select>
									</div>
								</div>
							</div>
						</div>


						<div class="row">
							<div class="col-md-12">
								<button type="submit" class="btn btn-primary pull-right"
									id="Apply">Apply</button>
							</div>
							<div class="col-md-4"></div>

						</div>
					</div>



				</div>
	</form>

	<script>
		function getAllPolicies() {
			jQuery.ajax({
				type : 'GET',
				cache : true,
				async : false,
				contentType : 'application/json',
				dataType : 'json',
				url : location.origin + "/AllPolicies",
				success : function(data) {
					$("#categoryId")
							.append(
									$("<option     />").val("").text(
											"Choose Category"));
					$.each(data, function() {
						debugger;
						$("#categoryId").append(
								$("<option     />").val(this).text(this));
					});
				},

				error : function(data) {
					alert("failed");
				}
			});
		}

		function getPolicyName() {
			jQuery.ajax({
				type : 'GET',
				cache : true,
				async : false,
				contentType : 'application/json',
				dataType : 'json',
				url : location.origin + "/policyName/"
						+ document.getElementById("categoryId").value,
				success : function(data) {
					$("#categoryNameId").empty();
					$("#categoryNameId").append(
							$("<option     />").val("").text(
									"Choose Category Name"));
					$.each(data, function() {
						debugger;
						$("#categoryNameId").append(
								$("<option     />").val(this).text(this));
					});
				},

				error : function(data) {
					alert("failed");
				}
			});
		}
	</script>
</body>
<jsp:include page="../include/footer.jsp" />