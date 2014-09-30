<%-- 
    Document   : Login
    Created on : Aug 28, 2014, 5:43:35 PM
    Author     : LudjaPae
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@page import="model.User"%>
<%@page import="model.DiabetesLog"%>
<%@page import="model.NutritionDB"%>
<%@page import="model.MedicineDB"%>
<%@page import="model.Content"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if IE 9]>         <html class="no-js lt-ie10"> <![endif]-->
<!--[if gt IE 9]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">

        <title>Baowhan:เบาหวาน</title>

        <meta name="description" content="Baowhan.com เว็บไซต์ช่วยเหลือในการจัดการโรคเบาหวาน พร้อมให้ข้อมูลเกี่ยวกับโรคเบาหวาน !">
        <meta name="author" content="Baowhan">
        <meta name="robots" content="noindex, nofollow">
        <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1.0">

        <!-- Icons -->
        <!-- The following icons can be replaced with your own, they are used by desktop and mobile browsers -->
        <link rel="shortcut icon" href="img/favicon.ico">
        <link rel="apple-touch-icon" href="img/icon57.png" sizes="57x57">
        <link rel="apple-touch-icon" href="img/icon72.png" sizes="72x72">
        <link rel="apple-touch-icon" href="img/icon76.png" sizes="76x76">
        <link rel="apple-touch-icon" href="img/icon114.png" sizes="114x114">
        <link rel="apple-touch-icon" href="img/icon120.png" sizes="120x120">
        <link rel="apple-touch-icon" href="img/icon144.png" sizes="144x144">
        <link rel="apple-touch-icon" href="img/icon152.png" sizes="152x152">
        <!-- END Icons -->

        <!-- Stylesheets -->
        <!-- Bootstrap is included in its original form, unaltered -->
        <link rel="stylesheet" href="css/bootstrap.min.css">

        <!-- Related styles of various icon packs and plugins -->
        <link rel="stylesheet" href="css/plugins.css">

        <!-- The main stylesheet of this template. All Bootstrap overwrites are defined in here -->
        <link rel="stylesheet" href="css/main.css">

        <!-- Include a specific file here from css/themes/ folder to alter the default theme of the template -->

        <!-- The themes stylesheet of this template (for using specific theme color in individual elements - must included last) -->
        <link rel="stylesheet" href="css/themes.css">
        <link rel="stylesheet" href="css/font.css">
        <!-- END Stylesheets -->

        <!-- Modernizr (browser feature detection library) -->
        <script src="js/vendor/modernizr-2.8.3.js"></script>
        <style type="text/css">

        </style>
    </head>
    <body>
        <img src="img/sunset.jpg" alt="Full Background" class="full-bg full-bg-bottom animation-pulseSlow">
        <header class="navbar navbar-inverse navbar-fixed-top" style="background-color: rgba(0,0,0,0.5);">
                        <!-- Left Header Navigation -->
                        <center><a href="http://baowhan.com" style="font-size: 35px;
text-decoration: none;
color: white;">เบา<strong>หวาน</strong> | Bao<strong>whan</a></strong></center>
                    </header>
        <!-- Login Container -->
        <div id="login-container">
            <!-- Login Header -->
            <h1 class="thai text-light text-center push-top-bottom animation-fadeInQuickInv ">
                <strong><b style="font-size:75px;">NEVER.GIVE.UP</b></strong><br />
                <b style="font-size:30px;">
                    ร่วมแสดงความยินดี<br /></b>
                <i style="font-size:40px;">
                    คุณ ${name}<br /></i>
                    <b style="font-size:30px;">
                ได้อยู่อันดับที่ ${point} ในการแข่งขันการควบคุมระดับน้ำตาลในเลือด<br />
                ร่วมแสดงความยินดีได้โดยการกด Like โพสที่แชร์บนหน้าวอล
                </b>
            </h1>
            
            <!-- END Login Header -->

            
            </div>
            <!-- END Login Block -->
        <nav class="navbar navbar-default navbar-fixed-bottom" role="navigation" style="background-color: rgba(0,0,0,0.5);color:white;text-decoration: none">
  <div class="container">
      <center>
      <i style="font-size:25px">
      ความรู้เพิ่มเติม - ระบบช่วยในการจัดการโรคเบาหวาน ฟรี ที่ <a href="http://baowhan.com" style="background-color: rgba(0,0,0,0.5);color:white;text-decoration: none">Baowhan.com</a>
      </i>
      </center>
  </div>
</nav>
        <!-- END Login Container -->

        <!-- Include Jquery library from Google's CDN but if something goes wrong get Jquery from local file (Remove 'http:' if you have SSL) -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script>!window.jQuery && document.write(decodeURI('%3Cscript src="js/vendor/jquery-2.1.1.min.js"%3E%3C/script%3E'));</script>

        <!-- Bootstrap.js, Jquery plugins and Custom JS code -->
        <script src="js/vendor/bootstrap.min.js"></script>
        <script src="js/plugins.js"></script>
        <script src="js/app.js"></script>

        <!-- Load and execute javascript code used only in this page -->
        <script src="js/pages/readyLogin.js"></script>
        <script>$(function(){ ReadyLogin.init(); });</script>
    </body>
</html>