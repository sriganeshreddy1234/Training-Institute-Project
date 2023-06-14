<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%> 
<%@page import="com.nttdata.training.domain.Institute"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Institute Details</title>
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
   					<li><a class="active" href="admin_institutedetails.jsp">View Institute details</a></li>
      				<li><a href="admin_institutedelete.jsp">Delete Institute</a></li>
                  
            <li><a href="admin_studentdetails.jsp">View Student Details</a></li>
      	<li><a href="admin_complaintdetails.jsp">View Complaints</a></li>
            <li><a href="admin_logout.jsp">Logout</a></li>
         </ul>
      </nav>

 <div class="center">
      <h1>List Of Institute</h1>
      <form name="Institute_Name" action="admin_home.do" method="post">
       
       
        <input type="submit" name="action" value="viewinstitutes">
        
      </form>
</body>
      
 <%-- div class="table-responsive">
  <table id="myTable" class="display table">
    <thead>
        <tr>
        <th> Institute Name </th>
        <th> Password </th>
        <th> Date </th>
        <th> Address </th>
        <th> Seats </th>
        <th> Courses </th>
        <th> Delete </th>
       </tr>
    </thead>
<tbody>

<%
for(Institute pr: ((ArrayList<Institute>) request.getAttribute("InstituteDetails"))) {
%>
<tr>
<td><%=pr.getInstitute_Name() %></td>
<td><%=pr.getPassword() %> </td>
<td><%=pr.getAffiliation_Date()  %> </td>
<td><%=pr.getAddress() %> </td>
<td><%=pr.getNumber_Of_Seats() %> </td>
<td><%=pr.getNumber_Of_Course() %> </td>
<td> <a href="admin_home?action=deleteinstitute&Institute_Name=<%=pr.getInstitute_Name()%>"> Delete </a>  </td>
<% } %>
</tr>

</tbody>
</table>
</div>
</div> --%>
</body>
</html>