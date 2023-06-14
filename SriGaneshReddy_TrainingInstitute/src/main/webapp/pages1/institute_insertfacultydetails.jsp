<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Institute</title>

	<link rel="stylesheet" href="../css/admininstitutes.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
</head>
<body>
<nav>
         <ul>
            </li>
   					<li><a  href="institute_studentdetails.jsp">View Student details</a></li>
      				<li><a  href="institute_uploadarticle.jsp">Upload Article</a></li>
                  	<li><a class="active" href="institute_insertfacultydetails.jsp">Insert Faculty</a></li>
      				<li><a href="institute_facultydetails.jsp">View Faculty</a></li>
      				<li><a href="institute_updateinstitutedetails.jsp">Modify Institute Details</a></li>
      				<li><a href="institute_viewfeedback.jsp">View Feedback By Students</a></li>
      	
            		<li><a href="institute_logout.jsp">Logout</a></li>
         </ul>
      </nav>
 <div class="center">
      <h1>Faculty Details</h1>
      <form name="Name" action="institute_home.do" method="post">
       
       
        <input type="submit" name="action" value="insertfaculty">
        
      </form>
</body>
</html>