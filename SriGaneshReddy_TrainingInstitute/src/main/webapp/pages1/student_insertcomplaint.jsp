<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student</title>
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
   					<li><a href="student_studentdetails.jsp">View Student details</a></li>
      				<li><a href="student_updatestudentdetails.jsp">Modify Student Details</a></li>
                  	<li><a href="student_insertfeedback.jsp">Insert Feedback</a></li>
      				<li><a class="active" href="student_insertcomplaint.jsp">Insert Complaint</a></li>
      	
            		<li><a href="student_logout.jsp">Logout</a></li>
         </ul>
      </nav>
 <div class="center">
      <h1>Insert Complaint</h1>
      <form name="Name" action="student_home.do" method="post">
       
       
        <input type="submit" name="action" value="insertcomplaint">
        
      </form>
</body>
</html>