
 <%@ page import="com.supportclass.*" %>
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
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/business-casual.css" rel="stylesheet">
	
    <!-- Fonts -->
    <!-- <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css"> -->
    <link href="css/font_style1.css" rel="stylesheet">
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
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/dzyngiri.css" rel="stylesheet" type="text/css">
<link href="fonts/pacifico/stylesheet.css" rel="stylesheet" type="text/css" />

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
<style type="text/css">
    #wrapper 
    {
        width:350px;
        margin:0 auto;
        font-family:Verdana, sans-serif;
        top: 150px;
        position: absolute;
        left: 250px;
    }
    legend {
        color:#994c00;
        font-size:16px;
        padding:0 10px;
        background:#fff;
        -moz-border-radius:4px;
        box-shadow: 0 1px 5px rgba(4, 129, 177, 0.5);
        padding:5px 10px;
        text-transform:uppercase;
        font-family:Helvetica, sans-serif;
        font-weight:bold;
    }
    fieldset {
        border-radius:4px;
        background: #fff; 
        background: -moz-linear-gradient(#fff, #f9fdff);
        background: -o-linear-gradient(#fff, #f9fdff);
        background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#fff), to(#f9fdff)); /
        background: -webkit-linear-gradient(#fff, #f9fdff);
        padding:20px;
        border-color:#336600;
    }
    input,
    textarea {
        color: #CC6633;
        background: #fff;
        border: 1px solid #CCCCCC;
        color: #aaa;
        font-size: 14px;
        line-height: 1.2em;
        margin-bottom:15px;

        -moz-border-radius:4px;
        -webkit-border-radius:4px;
        border-radius:4px;
        box-shadow: 0 1px 2px rgba(0, 0, 0, 0.1) inset, 0 1px 0 rgba(255, 255, 255, 0.2);
    }
    input[type="text"],
    input[type="password"]{
        padding: 8px 6px;
        height: 22px;
        width:280px;
    }
    input[type="text"]:focus,
    input[type="password"]:focus {
        background:#fff;
        text-indent: 0;
        z-index: 1;
        color: #000;
        -webkit-transition-duration: 400ms;
        -webkit-transition-property: width, background;
        -webkit-transition-timing-function: ease;
        -moz-transition-duration: 400ms;
        -moz-transition-property: width, background;
        -moz-transition-timing-function: ease;
        -o-transition-duration: 400ms;
        -o-transition-property: width, background;
        -o-transition-timing-function: ease;
        width: 280px;
        
        border-color:#CC6633;
        box-shadow:#CC6633;
        opacity:0.6;
    }
    input[type="submit"]{
        background: #994c00;
        border: none;
        text-shadow: 0 -1px 0 rgba(0,0,0,0.3);
        text-transform:uppercase;
        color: #eee;
        cursor: pointer;
        font-size: 15px;
        margin: 10px 80px;
        padding: 5px 22px ;
        -moz-border-radius: 4px;
        border-radius: 4px;
        -webkit-border-radius:4px;
        -webkit-box-shadow: 0px 1px 2px rgba(0,0,0,0.3);
        -moz-box-shadow: 0px 1px 2px rgba(0,0,0,0.3);
        box-shadow: 0px 1px 2px rgba(0,0,0,0.3);
        
        
    }
   
    .small {
        line-height:14px;
        font-size:12px;
        color:#999898;
        margin-bottom:3px;
    }
</style>
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
 

        <form action="<%=request.getContextPath()%>/NewUser" class="login-form" method="post">
            <fieldset>
                <legend>User Register</legend>
                <div>
                    <input type="text" name="loginid" placeholder="Login ID"/>
                </div>
                <div>
                    <input type="text" name="name" placeholder="Name"/>
                </div>
                <div>
                    <input type="password" name="pass" placeholder="Password"/>
                </div>
                
                <div>
                    <input type="text" name="email" placeholder="Email"/>
                </div>
                 <div>
                    <input type="text" name="phone" placeholder="Phone Number"/>
                </div>
                <input type="submit" name="submit" value="Register"/>
            </fieldset>    
        </form>
    <%	
		int no=Utility.parse(request.getParameter("no"));
		if(no==1)
		{%>
		
			<div  style="position: absolute;top: 500px;left: 300px;color: #336633;font-size: 20px; ">	
		<script type="text/javascript">
		 $().toastmessage('showErrorToast', "UserId Already Exist ..!");
		
		</script></div>	
					
		<%
		}
		%>

</div>
                        
</div>
                   
                    
                   
                   
</div>
</div>
</div>

      

      
    </div>
   
    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Script to Activate the Carousel -->
    <script>
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
    </script>

</body>

</html>
