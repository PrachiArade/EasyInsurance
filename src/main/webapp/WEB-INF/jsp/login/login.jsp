<jsp:include page="../include/header.jsp" />
 <!--<body style="background-color: "> -->

 <body style="background-image: linear-gradient(#000000,#e74c3c); ">



    <h3 style="color: white;"> <center>  Kindly login to use Easy Insurance</h3>

   <form action="/login/loginSecurityPost" method="POST">
      <input type="hidden" name="id" value="${formBeanKey.id}">

<c:if test="${errorMessage}"><span style="margin-left: 716px;color: red;">${errorMessage}</span></c:if>

<c:if test="${logoutMsg}"><span style="color: blue;">${logoutMsg}</span></c:if>




      <div class="container">
      		<div class="row">
      		<div class="col-md-3"></div>
      			<div class="col-md-6">
      				<div class="well well-sm">


      						<div class="row">
<div class="col-md-3"></div>
      							<div class="col-md-6">
      								<div class="form-group">
      									<label for="email"> Email Address</label>
      									<div class="input-group">
      										<span class="input-group-addon"><span
      											class="glyphicon glyphicon-envelope"></span> </span>

      											<input type="email" name="username" class="form-control" placeholder="Enter email" value="${formBeanKey.username}" required="required" >

      									</div>
      								</div>
      							</div>

      						</div>


      						<div class="row">
<div class="col-md-3"></div>

      						<div class="col-md-6">

                                  								<div class="form-group">
                                  									<label for="subject"> Password </label>
                                  									<div class="input-group">
                                  										<span class="input-group-addon"><span
                                  											class="glyphicon glyphicon-lock"></span> </span>


                                  											<input type="password" name="password" placeholder="Enter Password " class="form-control" value="${formBeanKey.password}" required >


                                  									</div>
                                  								</div>
                                  								<div class="row">
                                                                                                                                  							<div class="col-md-4">
                                                                                                                                  								<button type="submit" class="btn btn-primary pull-right"
                                                                                                                                  									id="btnContactUs">Login</button>
                                                                                                                                  							</div>
<div class="col-md-4"></div>
                                                                                                                                  							<div class="col-md-4">
                                                                                                                                                                     <a href="/register">Sign Up</a></div>
                                                                                                                                  						</div>
                                  							</div>



</div>



      				</div>
      			</div>

      		</div>
      	</div>

















   </form>
   <div>
      <c:forEach items="${formBeanKey.errorMessages}" var="message">
         <span style="color:red">${formBeanKey.errorMessages}</span><br>
      </c:forEach>
   </div>
</body>
<jsp:include page="../include/footer.jsp" />