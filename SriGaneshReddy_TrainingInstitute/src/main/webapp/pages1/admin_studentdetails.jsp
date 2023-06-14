<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Details</title>
<link rel="stylesheet" href="../css/admininstitutes.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>

</head>
<body>
<nav>
         <ul>
            <li><a  href="#">Home</a></li>
            <li>
               <ul>
               		
               </ul>
            </li>
   					<li><a  href="admin_institutedetails.jsp">View Institute details</a></li>
      				<li><a  href="admin_institutedelete.jsp">Delete Institute</a></li>
                  	<li><a class="active" href="admin_studentdetails.jsp">View Student Details</a></li>
      				<li><a href="admin_complaintdetails.jsp">View Complaints</a></li>
           			 <li><a href="admin_logout.jsp">Logout</a></li>
         </ul>
      </nav>
 <div class="center">
      <h1>List Of Students</h1>
      <form name="Name" action="admin_home.do" method="post">
       
       
        <input type="submit" name="action" value="viewstudents">
        
      </form>
</body>
</html>