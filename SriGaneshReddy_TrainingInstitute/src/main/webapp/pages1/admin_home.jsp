<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
      <meta charset="utf-8">
      <title>Admin Userboard</title>
      <link rel="stylesheet" href="../css/admininstitutes.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>

   </head>
   <body>

      <nav>
         <ul>
            <li><a class="active" href="#">Home</a></li>
            <li>
               <ul>
               		
               </ul>
            </li>
   					<li><a href="admin_institutedetails.jsp">View Institute details</a></li>
      				<li><a href="admin_institutedelete.jsp">Delete Institute</a></li>
                  
            <li><a href="admin_studentdetails.jsp">View Student Details</a></li>
      	<li><a href="admin_complaintdetails.jsp">View Complaints</a></li>
            <li><a href="admin_logout.jsp">Logout</a></li>
         </ul>
      </nav>
      <div>
      <h1> Admin Logged in Successfully  ${Name}</h1>
      </div>
   </body>
</html>

 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
<%-- <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
<style>
* {
  box-sizing: border-box;
}
body {
  background-color: white;
}

.header {
  background-color: grey;
  color: white;
  padding: 15px;
  text-align:center;
}

.column {
  float: center;
  padding: 15px;
}

.clearfix::after {
  content: "";
  clear: both;
  display: table;
}

.menu {
  width: 25%;
}

.content {
  width: 75%;
}

.menu ul {
  list-style-type: none;
  margin: 5px;
  padding: 0;
  text-align:center;
}

.menu li {
  padding:50px 0px;
  margin-bottom: 8px;
  background-color: #33b5e5;
  color: #ffffff;
}

.menu li:hover {
  background-color: red;
}
</style>
</head>
<body>

<div class="header">
  <h1>Admin Dashboard</h1>
</div>
<%
String context = request.getContextPath(); 
%>

<div class="clearfix">
  <div class="column menu">
    <ul>
      <li><a href="<%=context%>\pages1\AdminInstitute.jsp"><h3>View Institute details</h3></a></li>
      <li><a href="#"><h3>Delete Institute</h3></a></li>
      <li><a href="<%=context%>\Admin\AdminStudent.jsp"><h3>View Student Details</h3></a></li>
      <li><a href="<%=context%>\Admin\AdminComplaint.jsp"><h3>View Complaints</h3></a></li>
    </ul>
  </div>

</body>
</html>
 --%>