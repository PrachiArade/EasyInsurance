<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
   <jsp:include page="../include/header.jsp" />
   <body style="background-image: linear-gradient(#ffd89b ,#19547b);">
      <h3>
         <center>
            Policies Offered By <em>Easy Insurance </em>
         </center>
      </h3>
      <div class="table-responsive" style="padding: 130px;">
      <table class="table table-hover table-striped">
        <thead class="thead-dark">

            <th>Policy Name</th>
            <th>Tenure</th>
             <th>Price</th>
              <th>Category</th>
         </thead>
         <tbody>
            <c:forEach items="${policies}" var="emp">
               <tr>

                   <td>${emp.policyName}</td>
                  <td>${emp.tenure}</td>
                  <td>${emp.price}</td>
                  <td>${emp.category}</td>



               </tr>
            </c:forEach>


         </tbody>
         <tfoot class="thead-light">

         </tfoot>
      </table>
      <a href="/login/login"><button class ="btn btn-primary">Click here to book a Policy</button> </a>
      </div>
   </body>
   <jsp:include page="../include/footer.jsp" />
</html>