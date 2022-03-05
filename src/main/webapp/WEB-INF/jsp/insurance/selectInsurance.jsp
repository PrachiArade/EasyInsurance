
<html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> <!-- includes header and footer-->

<jsp:include page="../include/homeHeader.jsp" />

<!DOCTYPE html>
<html lang="en">
<head>

            <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
            <!--linking css to html-->
             <link rel="stylesheet" href="pub/css/policies.css">
             <link href="<spring:url value="pub/css/home.css" />" rel="stylesheet">

      <body style="background-image: linear-gradient(#ffd89b ,#19547b);" >



          <form method = "POST" action ="/insurance">
            <h4><center><b> We Have Got You Covered </b><i class="fas fa-umbrella"></i> </h4>
            <h3> <center>Welcome to Easy Insurance, Choose Your Insurance Type </h3>

            <h3><center> Hi,${firstName} Select Insurance category from options below </h3>

         <!--    <sec:authentication property= "principal.username" /><a href= "Welcome! Apply For Insurance Policy" </a> -->


    <div class = "row" >
          <div class = "column" >
           <a href="/policies/Property"> <font color="black";font size=3px> <img src="https://t4.ftcdn.net/jpg/00/81/31/05/240_F_81310549_x57wb4jlE0a2wkVS394u6IM9wx2mBxYz.jpg" height= 300,width=300> <figcaption> Click to see our<em><b> PERSONAL PROPERTY INSURANCE</b></em>  </figcaption> </img></a>
         </div>

         <div class = "column" >
           <a href="/policies/Auto"><font color="black";font size=3px> <img src="https://t4.ftcdn.net/jpg/01/65/21/41/240_F_165214141_DSzDh7YymcT42H1AfBxhFVKjNSPLFI4J.jpg" height= 300,width=300> <figcaption> Click to see our <em><b> AUTO INSURANCE POLICIES</b></em> </figcaption> </img></a>
         </div>

         <div class = "column" >
           <a href="/policies/Health"><font color="black";font size=3px> <img src="https://t4.ftcdn.net/jpg/03/50/26/59/240_F_350265946_21SULYL0IOSyM5t6bLfSxEB505oWWRqP.jpg" height= 300,width=300> <figcaption> Click here to see our <em><b>HEALTH INSURANCE POLISIES</b></em> </figcaption> </img></a>
         </div>
     </div>




       <!--        <h2> Which Insurance Do You Want To Buy Today? </h2>

                   Name Of Insurance Policy <input type="text" name="policy">
                   <br>

                   <button type="submit">Search</button>  -->

     <!--   <script>
         function login(loginForm)
         {
         if(loginForm.username.value && loginForm.password.value)
         } -->


<jsp:include page="../include/footer.jsp" />
