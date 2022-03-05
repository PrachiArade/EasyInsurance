<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">

 <jsp:include page="../include/createPolicyHeader.jsp" />

  <!-- <body onload="getAllEmployeeInfo()"> -->
   <body style="background-image: linear-gradient(#ffd89b ,#19547b);"
    onload="getAllPolicies()">
      <form action ="/registerSubmit" method ="POST">
        <div class="container register-form">
            <div class="form">


                <div class="form-content">
                    <div class="row">
                    <div class="col-md-3"></div>
                        <div class="col-md-3">
                            <div class="form-group">
                                <select id="categoryId" class="form-control"></select>

                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Enter Policy Name" value=""/>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Enter Price" value=""/>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Enter Tenure" value=""/>
                            </div>
                        </div>
                        <div class="col-md-3"></div>
                    </div>
                    <button type="button" class="btn btn-primary">Submit</button>
                </div>
            </div>
        </div>
      </form>



<script>

function getAllEmployeeInfo() {
    jQuery
        .ajax({
                type: 'GET',
                cache: true,
                async: false,
                contentType: 'application/json',
                dataType: 'json',
                url: location.origin + "/AllPolicies",
                success: function(data)
                    {
                     $("#categoryId").append($("<option     />").val("").text("Choose Category"));
                        $.each(data, function() {
                        debugger;
                            $("#categoryId").append($("<option     />").val(this).text(this));
                        });
                    },

                    error: function(data) {
                        alert("failed");
                    }
                });
        }
</script>

   </body>
</html>