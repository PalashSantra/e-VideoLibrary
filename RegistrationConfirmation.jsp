<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.io.* " %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title></title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen, projection" />
    <link rel="stylesheet" href="css/Registration.css" type="text/css" media="screen, projection" />
</head>


<body>

<div id="wrapper">

    <div id="header">
        <div  id="logo"></div>

    </div><!-- #header-->
    <div id="headnav">
        <ul class="menu">

            <li><a href="index.jsp">Home</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">Contact</a></li>
        </ul>
        <div class="registration">
            <p> Welcome! Guest </p>
            <ul class="Reg">

                <li><a href="#">Login</a>
                
																				
</li>



              <li><a href="#">Registration</a></li>
            </ul>
        </div>

    </div>

    <div id="middle">

        <div id="container">
            <div id="regcontent">
			<div class="regishead">
                    <p>Registration successfully</p>
                    <pre>Login in your account below.</pre>
                </div>
			
			<form action="servCheckLogIn" method="post" style="
    border:1px solid black;width:500px;padding:40px;-moz-box-shadow:0px 0px 10px 7px #777777;
	-webkit-box-shadow:0px 0px 10px 7px #777777;
	box-shadow:0px 0px 10px 7px #777777;">
			<pre>


UserName:   <input type="text" name="username"/>
			

Password:   <input type="password" name="password"/>
			
		

	     		<input type="submit" value="Login"/>
			</pre>
			</form>
            </div><!-- #content-->

        </div><!-- #container-->
        <!--
        <div class="sidebar" id="sideLeft">
			<strong>Left Sidebar:</strong> Integer velit. Vestibulum nisi nunc, accumsan ut, vehicula sit amet, porta a, mi. Nam nisl tellus, placerat eget, posuere eget, egestas eget, dui. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. In elementum urna a eros. Integer iaculis. Maecenas vel elit.
		</div><!-- .sidebar#sideLeft -->
        <!--
    <div class="sidebar" id="sideRight">
        <strong>Right Sidebar:</strong> Integer velit. Vestibulum nisi nunc, accumsan ut, vehicula sit amet, porta a, mi. Nam nisl tellus, placerat eget, posuere eget, egestas eget, dui. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. In elementum urna a eros. Integer iaculis. Maecenas vel elit.
    </div><!-- .sidebar#sideRight -->

    </div><!-- #middle-->

</div><!-- #wrapper -->


<div id="footer">
    <div id="footlogo"></div>
    <div class="footnav"><ul>
        <li><a href="#">Home</a>  &#124;&#124;  </li>
        <li><a href="#">About</a> &#124;&#124;  </li>
        <li><a href="#">Contact</a></li>

    </ul>
        <p>
            &copy;Copyright-2013. Powered by <a href="#"> <strong>V-Tube</strong></a>
        </p>

    </div>
    <div class="find_us"><a href="#"> <img src="images/fb.png" class="rotate"/></a>
        <a href="#"> <img src="images/twitt.png" class="rotate"/></a>
        <a href="#"> <img src="images/g+.png" class="rotate"/></a>
    </div>
</div><!-- #footer -->

</body>
</html>