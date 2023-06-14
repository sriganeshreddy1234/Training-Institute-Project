<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Institute Login</title>
    <style media="screen">
      *{
    box-sizing: border-box;
}
body{
    margin: 0;
    font-family: poppins, Arial, Helvetica, sans-serif;
    font-size: 16px;
    font-weight: 400;
    color: #666666;
    background: #eaeff4;
}

.wrapper{
    margin: 0 auto;
    width: 100%;
    max-width: 1140px;
    min-height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
}

.container{
    position: relative;
    width: 100%;
    max-width: 600px;
    height: auto;
    display: flex;
    background: #ffffff;
    box-shadow: 0 0 5px #999999;
}
.login .col-left,
.login .col-right{
    padding: 30px;
    display: flex;
}
.login .col-left{
    width: 60%;
    clip-path: polygon(0 0, 0% 100%, 100% 0 );
    background: #2aa15f;
}
.login .col-right{
    padding: 60px 30px;
    width: 50%;
    margin-left: -10%;
}

@media(max-width: 575px){
    .login .container{
        flex-direction: column;
        box-shadow: none;
    }
    .login .col-left,
    .login .col-right{
     width: 100%;
     margin: 0;
     clip-path: none;
    }
    .login .col-right{
        padding: 30px;
    }


}


.login .login-text{
    position: relative;
    width: 100%;
    color: #ffffff;
}
.login .login-text h2{
    margin: 0 0 15px 0;
    font-size: 30px;
    font-weight: 700;
}
.login .login-text p{
    margin: 0 0 20px 0;
    font-size: 16px;
    font-weight: 500;
    line-height: 22px;
}

.login .login-text .btn{
    display: inline-block;
    font-family: poppins;
    padding: 7px 20px;
    font-size: 16px;
    letter-spacing: 1px;
    text-decoration: none;
    border-radius: 30px;
    color: #ffffff;
    outline: none;
    border: 1px solid #ffffff;
    box-shadow: inset 0 0 0 0 #ffffff;
    transition: .3s;
}
.login .login-text .btn:hover{
    color: #2aa15f;
    box-shadow: inset 150px 0 0 0  #ffffff;
}


.login .login-form{
    position: relative;
    width: 100%;
}
.login .login-form h2{
    margin: 0 0 15px 0;
    font-size: 22px;
    font-weight: 700;
}
.login .login-form p{
    margin: 0 0 10px 0;
    text-align: left;
    color: #666666;
    font-size: 15px;
}
.login .login-form p:last-child{
    margin: 0;
    padding-top: 3px;
}
.login .login-form p a{
    color: #2aa15f;
    font-size: 14px;
    text-decoration: none;
}
.login .login-form label {
    display: block;
    width: 100%;
    margin-bottom: 2px;
    letter-spacing: .5px;
}
.login .login-form p:last-child label{
    width: 60%;
    float: left;
}
.login .login-form label span{
    color: #ff574e;
    padding-left: 2px;
}
.login .login-form input{
    display: block;
    width: 100%;
    height: 35px;
    padding: 0 10px;
    outline: none;
    border: 1px solid #cccccc;
    border-radius: 30px;
}
.login .login-form input:focus{
    border-color: #ff574e;
}
.login .login-form button,
.login .login-form input[type=submit] {
    display: inline-block;
    width: 100%;
    margin-top: 5px;
    color: #2aa15f;
    font-size: 16px;
    letter-spacing: 1px;
    cursor: pointer;
    background: transparent;
    border: 1px solid #2aa15f;
    border-radius: 30px;
    box-shadow: inset 0 0 0 0 #2aa15f;
    transition: .3s;
}
.login .login-form button:hover,
.login .login-form input[type=submit]:hover{
    color: #ffffff;
    box-shadow: inset 250px 0 0 0 #2aa15f;
}
    </style>
  </head>

 <body>
 <%
String context = request.getContextPath(); 
%>
    <div class="wrapper login">
            <div class="container">
                <div class="col-left">
                    <div class="login-text">
                        <h2>Welcome!</h2>
                        <p>Create your account.<br>For Free!</p>
                        <a href="<%=context%>\pages1\InstituteRegister.jsp" class="btn">Sign Up</a>
                    </div>
                </div>

                <div class="col-right">
                    <div class="login-form">
                        <h2>Institute Login</h2>

<form action="instituteLogin.do">  
<table>
	<tr>
		<td colspan="2"><c:if test="${requestScope.Err!=null}">
			<font color="red">${requestScope.Err}</font>
		</c:if></td>
	</tr>
</table>
                       
                            <p>
                                <label>Institute Name<span>*</span></label>
                                <input type="text" placeholder="Enter your Institute Name" name="Name" required>
                            </p>
                            <p>
                                <label>Password<span>*</span></label>
                                <input type="password" placeholder="Password" name="Password" required>
                            </p>
                            <p>
                                <input type="submit" value="Sign In">
                            </p>
                            <!-- <p>
                                <a href="">Forgot password?</a>                        </p> -->

                        </form>
                    </div>
                </div>

            </div>
        </div>
  </body>
</html>

