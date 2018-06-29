<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<title></title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<link rel="stylesheet" href="css/style.css" type="text/css" media="screen, projection" />
    <link rel="stylesheet" href="css/login.css" type="text/css" media="screen, projection" />
    <link rel="stylesheet" href="css/loginpopup.css" type="text/css" media="screen, projection" />
    <link href="css/js-image-slider.css" rel="stylesheet" type="text/css" />
    <script src="js/js-image-slider.js" type="text/javascript"></script>
</head>

<body>

<div id="wrapper">

	<div id="header">
        <div  id="logo"></div>

    </div><!-- #header-->
    <div id="headnav">
        <ul class="menu">

            <li><a href="#">Home</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">Contact</a></li>
        </ul>
        <div class="registration">
            <p> Welcome! Guest </p>
            <ul class="Reg">

                <li><a href="#">Login</a>
                <ul>
                    <li><a href="#" class="signout"></a>
                   
<form method="post" action="servCheckLogIn">
 <pre>
      UserName:

   <input type="text" name="username"/>

      PassWord:

   <input type="password" name="password"/>

        <input type="submit" value="Login" />
                    </pre>
</form>
                     </li>



                </ul>
                </li>
                <li><a href="Registration.jsp">Registration</a></li>
            </ul>
        </div>
    </div>
 <!-- Login popup Start Here----->

<!----Ends Here--->

    <div id="middle">

		<div id="container">
			<div id="content">
                <div id="slider">
                    <a href="#">
                        <img src="images/slider-1.jpg" />
                    </a>
                    <img src="images/slider-2.jpg" />
                    <img src="images/slider-3.jpg" alt="#htmlcaption3" />
                    <img src="images/slider-4.jpg" />
                </div>
                <!--thumbnails-->
                <div id="thumbs">
                    <div class="thumb"><img src="images/thumb-1.gif" /></div>
                    <div class="thumb"><img src="images/thumb-2.gif" /></div>
                    <div class="thumb"><img src="images/thumb-3.gif" /></div>
                    <div class="thumb"><img src="images/thumb-4.gif" /></div>
                </div>

			</div><!-- #content-->
             <div class="VideoTubeHead">
                <strong>
                    Videos Gallery
                </strong>
            </div>
            <pre>

<iframe title="YouTube video player" class="youtube-player"  width="473" height="390" src="http://www.youtube.com/embed/icAFUlsysqg?rel=0" frameborder="0"></iframe>  <iframe title="YouTube video player" class="youtube-player" width="473" height="390" src="http://www.youtube.com/embed/WC0E9jHw1B8?rel=0" frameborder="0"></iframe>

<iframe title="YouTube video player" class="youtube-player"  width="473" height="390" src="http://www.youtube.com/embed/icAFUlsysqg?rel=0" frameborder="0"></iframe>  <iframe title="YouTube video player" class="youtube-player" width="473" height="390" src="http://www.youtube.com/embed/WC0E9jHw1B8?rel=0" frameborder="0"></iframe>

<iframe title="YouTube video player" class="youtube-player"  width="473" height="390" src="http://www.youtube.com/embed/icAFUlsysqg?rel=0" frameborder="0"></iframe>  <iframe title="YouTube video player" class="youtube-player" width="473" height="390" src="http://www.youtube.com/embed/WC0E9jHw1B8?rel=0" frameborder="0"></iframe>
            </pre>
            




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
        <li><a href="#">Home</a> &#124;&#124;</li>
        <li><a href="#">About</a>  &#124;&#124; </li>
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