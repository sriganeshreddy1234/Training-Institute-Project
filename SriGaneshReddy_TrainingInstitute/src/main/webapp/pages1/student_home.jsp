<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
      <meta charset="utf-8">
      <title>Student Dashboard</title>
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
      				<li><a href="student_insertcomplaint.jsp">Insert Complaint</a></li>
      	
            		<li><a href="student_logout.jsp">Logout</a></li>
         </ul>
      </nav>
      <div><h1> Student Logged in Successfully...  Userid: ${Name} </h1></div>
   </body>
</html>

    
    
    
    
    
    
    
 