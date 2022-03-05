<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
 <jsp:include page="../include/userHeader.jsp" />

   <body style="background-image: linear-gradient(#ffd89b ,#19547b);" >
      <h3>
         <center>
           <h1> Your <em>Easy Insurance </em> Policies </h1>
         </center>
      </h3>
      <div class="table-responsive" style="padding: 160px;">
      <table class="table table-hover table-striped">
        <thead class="thead-dark">
            <th>Policy Id</th>
            <th>Category</th>
            <th>Policy Name</th>
         </thead>
         <tbody>
            <c:forEach items="${policies}" var="emp">
               <tr>
                  <td>${emp.id}</td>
                   <td>${emp.category}</td>
                  <td>${emp.categoryName}</td>


               </tr>
            </c:forEach>

         </tbody>
         <tfoot class="thead-light">
         </tfoot>
      </table>
      </div>
   </body>
   <jsp:include page="../include/footer.jsp" />
</html>