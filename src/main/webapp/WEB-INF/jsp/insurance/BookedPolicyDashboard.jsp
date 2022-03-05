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
         <center >
            List of Policies
         </center>
      </h3>
      <div class="table-responsive" style="padding: 140px;">
      <table class="table table-hover table-striped" id="tblSample">
        <thead class="thead-dark">
            <th>First Name</th>
            <th>Last Name</th>
            <th>Age</th>
            <th>Phone</th>
            <th>Gender</th>
       <!--     <th>zipcode</th> -->
            <th>Category</th>
            <th>Category Name</th>
            <th>Edit Record</th>
            <th>Delete Record</th>
          <!--  <th></th>-->
            <th></th>
         </thead>
         <tbody>
            <c:forEach items="${bookedPolicies}" var="emp">
               <tr>
                  <td>${emp.firstName}</td>
                  <td>${emp.lastName}</td>
                  <td>${emp.age}</td>
                  <td>${emp.phone}</td>
                  <td>${emp.gender}</td>
               <!--   <td>${emp.zipcode}</td> -->
                  <td>${emp.category}</td>
                  <td>${emp.categoryName}</td>
                  <td><input type"button" class="btn btn-primary"value="Edit"></input></td>
                  <td><a  href="/deleteRecord/${emp.id}"  class="btn btn-danger" value="Delete" >Delete</a></td>

               </tr>
            </c:forEach>

         </tbody>
         <tfoot class="thead-light">
         </tfoot>
      </table>
      <script>

      function deleteRecord(id) {
      			jQuery.ajax({
      				type : 'DELETE',
      				cache : true,
      				async : false,
      				contentType : 'application/json',
      				dataType : 'json',
      				url : location.origin + "/deleteRecord/"+id
      						,
      				success : function(data) {
      					window.location.href=location.origin+"/bookedPolicy";
      				},

      				error : function(data) {
      					window.location.href=location.origin+"/bookedPolicy";
      				}
      			});
      		}


      $("#tblSample").DataTable();
      </script>
      </div>
   </body>
   <jsp:include page="../include/footer.jsp" />
</html>