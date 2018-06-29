<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.io.* " %> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

            <li><a href="Admin.jsp">Home</a></li>
            <li><a href="#">Search</a>
            <ul>
            <li><a href="AdminParticularSearch.jsp">Videos</a></li>
          	<li><a href='<c:url value="servUsers"></c:url>'>Users detail</a></li>
            </ul>
            </li>
           
            <li><a href='<c:url value="#"><c:param name="check" value="Directory"/></c:url>'>Directory</a>

                <ul>
                    <li><a href='<c:url value="AdminservAllvideoSearch"><c:param name="check" value="Play"/></c:url>'>Play</a>
                   <li><a href='<c:url value="AdminservAllvideoSearch"><c:param name="check" value="Download"/></c:url>'>Download</a>
                </ul>



            </li>
            <li><a href='<c:url value="#"></c:url>'>Process</a>

                <ul>
                    <li><a href='<c:url value="AdminUpload.jsp"></c:url>'>Upload</a></li>
                   <li><a href='<c:url value="AdminRename.jsp"></c:url>'>Rename</a></li>
                	<li><a href='<c:url value="#"></c:url>'>Delete</a></li>
                </ul>



            </li>
            
		 


        </ul>
        <div class="registration">
            <p> Welcome! <%if(session.getAttribute("username")!=null) out.println(session.getAttribute("username")); else out.println("Guest"); %></p>
            <ul class="Reg">

                <li><a href='<c:url value="servLogOut"></c:url>'>Logout</a>
                <li><a href="#" class="Viewprofile">Profile</a>
                <ul>
                    <li><a href="#" class="profiledetail"></a>
                    <pre>
                    	
                    	
First Name:<%=session.getAttribute("Fname") %>

Last Name:<%=session.getAttribute("Lname") %>

User Name:<%=session.getAttribute("nusername") %>

Email_Id:<%=session.getAttribute("Email") %>


                    
                    
                    </pre>
                    
                    </li>
				</ul>
                </li>
            </ul>
        </div>
    </div>
    <div id="middle">

        <div id="container">
            <div id="regcontent">
			<div class="regishead">
                <p>Delete  A file Here...</p>
                </div>




<form action="servDelete" method="post" style="
    border:1px solid black;width:500px;padding:40px;-moz-box-shadow:0px 0px 10px 7px #777777;
	-webkit-box-shadow:0px 0px 10px 7px #777777;
	box-shadow:0px 0px 10px 7px #777777;">
			<pre>


File Name:   <input type="text" name="n3" value=""/>
			
	
			
			<input type="submit" value="Delete"/>
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
        <li><a href="About.jsp">About</a> &#124;&#124;  </li>
        <li><a href="Contact.jsp">Contact</a></li>

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