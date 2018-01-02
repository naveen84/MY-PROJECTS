<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <link rel="stylesheet" type="text/css" href="register.css">
    </head>
    <body>
    <h1 style="background-color: blue">WELCOME TO NAVEEN SERVICES</h1>
    
    <h2>Create your account here</h2>
      <div class="register">
    <form action="register.html" method="post">
        id:               <input type="text" name ="id"><br>
        Username:<input type="text" name="userName"><br>
        Password:<input type="password" name="password"><br>
        Email:   <input type="text" name="email"><br>
        <input type="submit" value="submit">
       
    </form>
    </div>
    
    <div align="left">
    <h2 style="background-position: center; background-color: aqua;">Log-in here</h2>
    <form action="login.html" method = post>
  Username:  <input type="text" name="uname">
  Password:  <input type="password" name="pwd">
  			 <input type="submit" value="submit">
   </div>
   </form>  
    
    </body>
</html>
