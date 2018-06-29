<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:useBean id="VF" class="pkgBeans.pkgVideos.clsVideoFileImplimentation" />  
<title>Particular Search</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen, projection" />
    <link rel="stylesheet" href="css/login.css" type="text/css" media="screen, projection" />
    <link rel="stylesheet" href="css/loginpopup.css" type="text/css" media="screen, projection" />
    <link href="css/js-image-slider.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="css/table.css" type="text/css"/>
    <script src="js/js-image-slider.js" type="text/javascript"></script>
<style>
div.img
{
  margin-left:90px;
  margin-top:30px;
  border: 1px solid #0000ff;
  height: auto;
  width: auto;
  float: left;
  text-align: center;
  margin-bottom:30px;
 
}	
div.img img
{
  display: inline;
  margin: 0px;
  border: 1px solid #ffffff;
 
}
div.img a:hover img {border: 1px solid #0000ff;}
div.desc
{
  text-align: center;
  font-weight: normal;
  width: 120px;
  margin: 2px;
}
</style>
    
</head>
<body>
<div id="wrapper">

    <div id="header">
        <div  id="logo"></div>

    </div><!-- #header-->
    <div id="headnav">
                <ul class="menu">

			<li><a href="User.jsp">Home</a></li>
            <li><a href="ParticularSearch.jsp">Search</a></li>
           
            <li><a href='<c:url value="servAllvideoSearch"><c:param name="check" value="Directory"/></c:url>'>Directory</a>

                <ul>
                    <li><a href='<c:url value="servAllvideoSearch"><c:param name="check" value="Play"/></c:url>'>Play</a>
                   <li><a href='<c:url value="#"></c:url>'>Download</a>
                </ul>




            </li>



        </ul>        <div class="registration">
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
    <!-- Login popup Start Here----->

    <!----Ends Here--->

    <div id="middle">

        <div id="container">
            <div id="content">
                <form action="servParticularSearch" method="get">
                <pre>




                    <input type="text" name="query" style="width:500px"/><input type="submit" value="Search"style="background: #cb5661"/>







                </pre>
                </form>
          
        
            
			
			
			 
			
		  </div><!-- #content-->			

    <div class="styletable" style="width:780px;">
    <table>
		<tr>
			<td>File name</td>
			<td>size</td>
			<td>play</td>
			
		</tr>

		<c:forEach var="row" items="${AllVideos}">
			<tr>
				<td><a href='<c:url value="http://localhost/VideoDirectory/servDownloadVideo"><c:param name="n2" value="${row.sFileName}"/></c:url>'>${row.sFileName}</a></td>
				<td>${VF.ProperQuantity(row.lSizeByte)}</td>
				<td><a href='<c:url value="http://localhost/VideoDirectory/servDownloadVideo"><c:param name="n2" value="${row.sFileName}"/></c:url>'>Download</a></td>
				
			</tr>
		</c:forEach>
	</table>
	</div>
         <div class="img">
 			<a target="_blank" href="#"><img src="images/ranjhna.jpg" alt="Ranjhna" width="110" height="110"></a>
 			<div class="desc">Click to play</div>
			</div>
			<div class="img">
 			<a target="_blank" href="#"><img src="images/chennaiexpress.jpg" alt="Chennai Express" width="110" height="110"></a>
 			<div class="desc">Click to play</div>
			</div>
			<div class="img">
 			<a target="_blank" href="#"><img src="images/chashmebadoor.jpg" alt="chashmebadoor" width="110" height="110"></a>
 			<div class="desc">Click to play</div>
			</div>
			<div class="img">
 			<a target="_blank" href="#"><img src="images/lootere.jpg" alt="lootere" width="110" height="110"></a>
 			<div class="desc">Click to play</div>
			</div>
			<div class="img">
 			<a target="_blank" href="#"><img src="images/ghanchakkar.jpg" alt="ghanchakkar" width="110" height="110"></a>
 			<div class="desc">Click to play</div>
			</div>
			<div class="img">
			 <a target="_blank" href="#"><img src="images/gogoagne.jpg" alt="go goa gone" width="110" height="110"></a>
 			<div class="desc">Click to play</div>
			</div>
			<div class="img">
 			<a target="_blank" href="#"><img src="images/exotic.jpg" alt="exotic" width="110" height="110"></a>
 			<div class="desc">Click to play</div>
			</div>
			<div class="img">
 			<a target="_blank" href="#"><img src="images/yehjwanihaideewani.jpg" alt="yeh jawani hai deewani" width="110" height="110"></a>
 			<div class="desc">Click to play</div>
			</div>
			<div class="img">
 			<a target="_blank" href="#"><img src="images/Aashiqui2.jpg" alt="Aashiqui2" width="110" height="110"></a>
 			<div class="desc">Click to play</div>
			</div>
			<div class="img">
 			<a target="_blank" href="#"><img src="images/bhagmilkha.jpg" alt="Bhag milkha Bhag" width="110" height="110"></a>
 			<div class="desc">Click to play</div>
			</div>
			<div class="img">
 			<a target="_blank" href="#"><img src="images/Fukrey.jpg" alt="Fukrey" width="110" height="110"></a>
 			<div class="desc">Click to play</div>
			</div>
			<div class="img">
 			<a target="_blank" href="#"><img src="images/vickey.jpg" alt="vickey" width="110" height="110"></a>
 			<div class="desc">Click to Play</div>
			</div>
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
        <li><a href="#">Home</a>&#124;&#124;</li>
        <li><a href="#">About</a>&#124;&#124;</li>
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