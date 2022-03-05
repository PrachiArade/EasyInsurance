<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>

<script>
$("#tblSample").DataTable();
</script>
</head>
   <jsp:include page="../include/adminHeader.jsp" />
   <body style="background-image: linear-gradient(#ffd89b ,#19547b);">
      <h3>
         <center>
            All Insurance Policies
         </center>
      </h3>
      <div class="table-responsive" style="padding: 5px;">
      <table class="table table-hover table-striped" id="tblSample">
        <thead class="thead-dark">
            <th>Policy Id</th>
            <th>Category</th>
            <th>Policy Name</th>
            <th>Tenure</th>
            <th>Price</th>
         </thead>
         <tbody>
            <c:forEach items="${policies}" var="emp">
               <tr>
                  <td>${emp.id}</td>
                  <td>${emp.category}</td>
                  <td>${emp.policyName}</td>
                  <td>${emp.tenure}</td>
                  <td>${emp.price}</td>

               </tr>
            </c:forEach>

         </tbody>
         <tfoot class="thead-light">
         </tfoot>
      </table>
      <script>
    $("#tblSample").DataTable({});
      </script>
      </div>
   </body>
   <jsp:include page="../include/footer.jsp" />
</html>