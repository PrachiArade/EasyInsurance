<jsp:include page="../include/header.jsp" />
<body style="background-image: linear-gradient(#000000,#e74c3c);">
 <h1 style="color: white;">
         <center>
      <!--   <a href="#" class="logo"><span>E</span>asy <span>I</span>nsurance</a> -->
       Easy Insurance
      </h1>
      <h4 style="color: white;">
         <center>
           Sign Up below To See Your Best Insurance Bet
      </h4>
    <form action ="/registerSubmit" method ="POST">
            <input type="hidden" name="id" value="${formBeanKey.id}">
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
      											class="glyphicon glyphicon-user"></span> </span>

      											<input type="text" name="username" class="form-control" placeholder="Enter first Name" value="${formBeanKey.firstName}" required="required" >

      									</div>
      								</div>
      							</div>
<div class="col-md-6"><div class="form-group">
                                                        	<label for="email"> Last Name</label>
                                                      	<div class="input-group">
                                                        <span class="input-group-addon"><span
                                                        	class="glyphicon glyphicon-user"></span> </span>

                                                        			<input type="text"  class="form-control" placeholder="Enter last Name"  name = "lastName" value="${formBeanKey.firstName}"  >

                                                        									</div>
                                                        								</div></div>
      						</div>





                        <div class="row">

                                                          							<div class="col-md-6">
                                                          								<div class="form-group">
                                                          									<label for="email"> UserName(Email)</label>
                                                          									<div class="input-group">
                                                          										<span class="input-group-addon"><span
                                                          											class="glyphicon glyphicon-envelope"></span> </span>

                                                          											<input type="text"  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" class="form-control" type="email" id="Email" name = "email" placeholder="Enter your Email" value="${formBeanKey.email}" >

                                                          									</div>
                                                          								</div>
                                                          							</div>
<div class="col-md-6"><div class="form-group">
                                                                                									<label for="email"> Phone</label>
                                                                                									<div class="input-group">
                                                                                										<span class="input-group-addon"><span
                                                                                											class="glyphicon glyphicon-phone"></span> </span>

                                                                                											<input type="text"  id="Phone" class="form-control" name = "phone" placeholder="Enter Phone Number"  minlength="10" maxlength="10" >

                                                                                									</div>
                                                                                								</div></div>
                                                          						</div>









<div class="row">

                                                          							<div class="col-md-6">
                                                          								<div class="form-group">
                                                          									<label for="email">Password</label>
                                                          									<div class="input-group">
                                                          										<span class="input-group-addon"><span
                                                          											class="glyphicon glyphicon-lock"></span> </span>

                                                          											<input type="password"  class="form-control" id="txtNewSecPass" name = "password" placeholder="Enter Password" value="${formBeanKey.password}" >

                                                          									</div>
                                                          								</div>
                                                          							</div>
 <div class="col-md-6"><div class="form-group">
                                                                                 									<label for="confirm password">Confirm Password</label>
                                                                                 									<div class="input-group">
                                                                                 										<span class="input-group-addon"><span
                                                                                 											class="glyphicon glyphicon-lock"></span> </span>

                                                                                 											<input type="password"  class="form-control" id="txtConfirmSecPass" name = "confirmPassword" placeholder="Enter Confirm Password" value="${formBeanKey.confirmPassword}" >

                                                                                 									</div>
                                                                                 								</div></div>





<div class="col-md-6"><div class="form-group">
                                                                                 									<label for="email">User Type</label>
                                                                                 									<div class="input-group">
                                                                                 										<span class="input-group-addon"><span
                                                                                 											class="glyphicon glyphicon-user"></span> </span>

                                                                                 											<select class="form-control" name="userType">
                                                                                 											<option value="ADMIN">Admin</option>
                                                                                 											<option value="USER">User</option>
                                                                                 											</select>

                                                                                 									</div>
                                                                                 								</div></div>



</div>
























































                                  								<div class="row">
                                                                                                                                  							<div class="col-md-12">
                                                                                                                                  								<button type="submit" class="btn btn-primary pull-right"
                                                                                                                                  									id="btnContactUs">Create</button>
                                                                                                                                  							</div>
<div class="col-md-4"></div>

                                                                                                                                  						</div>
                                  							</div>



</div>


      					</form>
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