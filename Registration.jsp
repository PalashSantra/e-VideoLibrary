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
    <script>
        function Admin()
        {
            if(document.getElementById("checkbox").checked==true)
            {
                document.getElementById("Show").style.visibility="visible";
            }
            else
            {
                document.getElementById("Show").style.visibility="hidden";

            }
        }
    </script>
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
                    <ul>
                        <li><a href="#" class="signout"></a>
                    <pre>

      UserName:

   <input type="text" name="Username"/>

      PassWord:

   <input type="password" name="pass"/>

        <input type="submit" value="Login" />
                    </pre>

                        </li>



                    </ul>
                </li>
              <li><a href="#">Registration</a></li>
            </ul>
        </div>

    </div>

    <div id="middle">

        <div id="container">
            <div id="regcontent">
                <div class="regishead">
                    <p>Register Your Account </p>
                    <pre> If you already  have an account .then mouse over on login button.
 
 NOTE:For Administrator give MasterPassword on checking the check 
 box button and fill the passWord.For general user the MasterPassword 
 is not Mandatory.
                    </pre>
                </div>
                <form action="CheckRegField" method="post">
     <pre>


    FirstName:          <input type="text" name="Fname" value="<%if(request.getAttribute("Ffield")!=null) out.println(request.getAttribute("Ffield"));%>"/>   <% if (request.getAttribute("Fmessg")!=null)
    					out.println(request.getAttribute("Fmessg"));%>

    
    LastName:		<input type="text" name="Lname" value="<%if(request.getAttribute("Lfield")!=null) out.println(request.getAttribute("Lfield"));%>"/>   <% if (request.getAttribute("Lmessg")!=null)
    				out.println(request.getAttribute("Lmessg"));%>
    
   
    UserName:	        <input type="text" name="Uname" value="<%if(request.getAttribute("Ufield")!=null) out.println(request.getAttribute("Ufield"));%>"/>   <% if (request.getAttribute("Umessg")!=null)
						out.println(request.getAttribute("Umessg"));%><%if(session.getAttribute("state1")!=null){out.println("User name duplicate");} %>
    
    
    PassWord:		<input type="password" name="PassWord"/>   <% if (request.getAttribute("Pmessg")!=null)
					out.println(request.getAttribute("Pmessg"));%>

    
    Confirm PassWord:	<input type="password" name="CPassWord"/>   <% if (request.getAttribute("CPmessg")!=null)
						out.println(request.getAttribute("CPmessg"));%>
    
    
    Email_Id:	        <input type="text" name="Email" value="<%if(request.getAttribute("Mfield")!=null) out.println(request.getAttribute("Mfield"));%>"/>   <% if (request.getAttribute("Emessg")!=null)
    					out.println(request.getAttribute("Emessg"));%>
    
    
    Gender:             <select name="sgender">
         <option value="">SELECT</option>
         <option value="Male">MALE</option>
         <option value="Female">FEMALE</option>
         <option value="Other">OTHER</option>
     </select>         <% if (request.getAttribute("Gmessg")!=null)
						out.println(request.getAttribute("Gmessg"));%>
						

    
    For  Admin           <input type="checkbox"  style=" width:13px"name="admin" id="checkbox" onclick="Admin()"/>   Check it.

  
    Master Password:	<input type="password" name="Mpass" id="Show" style="visibility: hidden"/><% if (request.getAttribute("Mmessg")!=null)
																	out.println(request.getAttribute("Mmessg"));%>

    

                        
                        <input type="submit" value="Create Account"/>

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