<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Privacy Preserving Cloud Computing</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=request.getContextPath()%>/css/business-casual.css" rel="stylesheet">
	
    <!-- Fonts -->
    <!-- <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css"> -->
    <link href="<%=request.getContextPath()%>/css/font_style1.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">

   <script src="<%=request.getContextPath()%>/jquery.toastmessage.js" type="text/javascript"></script>
    <link href="<%=request.getContextPath()%>/jquery.toastmessage.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript">
	  var _gaq = _gaq || [];
	  _gaq.push(['_setAccount', 'UA-29231762-1']);
	  _gaq.push(['_setDomainName', 'dzyngiri.com']);
	  _gaq.push(['_trackPageview']);
	
	  (function() {
		var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
		ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
		var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
	  })();
	</script>


<!--Stylesheets-->
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/dzyngiri.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/fonts/pacifico/stylesheet.css" rel="stylesheet" type="text/css" />

<!--Scripts-->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<!--Sliding icons-->
<script type="text/javascript">
$(document).ready(function() {
	$(".username").focus(function() {
		$(".user-icon").css("left","-48px");
	});
	$(".username").blur(function() {
		$(".user-icon").css("left","0px");
	});
	
	$(".password").focus(function() {
		$(".pass-icon").css("left","-48px");
	});
	$(".password").blur(function() {
		$(".pass-icon").css("left","0px");
	});
});
</script>

</head>

<body>

    <div class="brand">Privacy-Preserving Data Encryption Strategy</div>


    <div class="container">

        <div class="row">
            <div class="box">
                <div class="col-lg-12 text-center">
                    <div id="carousel-example-generic" class="carousel slide">
                       
                        
     <h2 class="brand-before">
                        <small>Welcome to</small>
     </h2>                    
 
<form name="login-form" class="login-form" action="<%=request.getContextPath()%>/UserLogin" method="post">

	<!--Header-->
    <div class="header">
    <h1>Admin Login Form</h1>
    
    </div>
    <!--END header-->
	
	<!--Input fields-->
    <div class="content">
	<!--USERNAME--><input name="userid" type="text" class="input username" placeholder="UserId" /><!--END USERNAME-->
    <!--PASSWORD--><input name="password" type="password" class="input password" placeholder="Password" /><!--END PASSWORD-->
    </div>
    <!--END Input fields-->
    
    <!--Buttons-->
    <div class="footer">
    <!--Login button--><input type="submit" name="submit" value="Admin" class="button" /><!--END Login button-->
    <!--Login button--><a href="<%=request.getContextPath()%>/index.jsp">User Login</a><!--END Login button-->
    
    <!--Register button--><input type="submit" name="submit" value="Register" class="register" /><!--END Register button-->
    </div>
    <!--END Buttons-->

</form>
<!--end login form-->

</div>
                        
</div>
                   
                    
                   
                   
</div>
</div>
</div>

      

      
    </div>
   
    <!-- jQuery -->
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>

    <!-- Script to Activate the Carousel -->
    <script>
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
    </script>

</body>

</html>
