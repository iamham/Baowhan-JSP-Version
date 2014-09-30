<%-- 
    Document   : Dashboard
    Created on : Aug 28, 2014, 5:43:35 PM
    Author     : Ham
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

        <title>Baowhan:เบาหวาน - หน้าหลัก</title>

        <meta name="description" content="AppUI is a Bootstrap Admin Web App Template created by pixelcave and published on Themeforest">
        <meta name="author" content="pixelcave">
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
        <!-- END Stylesheets -->

        <!-- Modernizr (browser feature detection library) -->
        <script src="js/vendor/modernizr-2.8.3.js"></script>
        
    </head>
    <body>
        <img src="img/bgd.jpg" alt="Full Background" class="full-bg full-bg-bottom animation-pulseSlow">
        <!-- Page Wrapper -->
        <!-- In the PHP version you can set the following options from inc/config file -->
        <!--
            Available classes:

            'page-loading'      enables page preloader
        -->
        <div id="page-wrapper" class="page-loading">
            <!-- Preloader -->
            <!-- Preloader functionality (initialized in js/app.js) - pageLoading() -->
            <!-- Used only if page preloader enabled from inc/config (PHP version) or the class 'page-loading' is added in body element (HTML version) -->
            <div class="preloader">
                <div class="inner">
                    <!-- Animation spinner for all modern browsers -->
                    <div class="preloader-spinner themed-background hidden-lt-ie10"></div>

                    <!-- Text for IE9 -->
                    <h3 class="text-primary visible-lt-ie10"><strong>จัดเตรียมข้อมูลของคุณ...</strong></h3>
                </div>
            </div>
            <!-- END Preloader -->

            <!-- Page Container -->
            <!-- In the PHP version you can set the following options from inc/config file -->
            <!--
                Available #page-container classes:

                'sidebar-visible-lg-mini'                       main sidebar condensed - Mini Navigation (> 991px)
                'sidebar-visible-lg-full'                       main sidebar full - Full Navigation (> 991px)

                'sidebar-alt-visible-lg'                        alternative sidebar visible by default (> 991px) (You can add it along with another class)

                'header-fixed-top'                              has to be added only if the class 'navbar-fixed-top' was added on header.navbar
                'header-fixed-bottom'                           has to be added only if the class 'navbar-fixed-bottom' was added on header.navbar
            -->
            <div id="page-container" class="header-fixed-top sidebar-visible-lg-full">
                <!-- Alternative Sidebar -->
                <div id="sidebar-alt" tabindex="-1" aria-hidden="true">

                    <!-- Wrapper for scrolling functionality -->
                    <div id="sidebar-scroll-alt">
                        <!-- Sidebar Content -->
                        <div class="sidebar-content">


                        </div>
                        <!-- END Sidebar Content -->
                    </div>
                    <!-- END Wrapper for scrolling functionality -->
                </div>
                <!-- END Alternative Sidebar -->

                <!-- Main Sidebar -->
                <div id="sidebar">
                    <!-- Sidebar Brand -->
                    <div id="sidebar-brand" class="themed-background">
                        <a href="docdashboard" class="sidebar-title">
                            <span class="sidebar-nav-mini-hide">เบา<strong>หวาน</strong> | Bao<strong>whan</strong></span>
                        </a>
                    </div>
                    <!-- END Sidebar Brand -->

                    <!-- Wrapper for scrolling functionality -->
                    <div id="sidebar-scroll">
                        <!-- Sidebar Content -->
                        <div class="sidebar-content">
                            <!-- Sidebar Navigation -->
                            <ul class="sidebar-nav">
                                <li>
                                    <a href="docdashboard" class="active"><i class="gi gi-compass sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">หน้าหลัก</span></a>
                                </li>
                                <li class="sidebar-separator">
                                    <i class="fa fa-ellipsis-h"></i>
                                </li>
                                <c:if test="${(user.getType() == 2)}">
                                    <li>
                                        <a href="docmessage" ><i class="fa fa-comments sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">ติดต่อคนไข้</span></a>
                                    </li>
                                    <li>
                                        <a href="doccalendar" ><i class="fa fa-calendar sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">ปฏิทิน/นัดหมาย</span></a>
                                    </li>
                                    <li>
                                        <a href="doctools" ><i class="fa fa-stethoscope sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">เครื่องมือ</span></a>
                                    </li>
                                </c:if>
                                <li>
                                    <a href="docnutrient" ><i class="fa fa-cutlery sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">โภชนาการ</span></a>
                                </li>
                                <li>
                                    <a href="docnews" ><i class="fa fa-folder-open sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">ข่าวสาร</span></a>
                                </li>


                            </ul>
                            <!-- END Sidebar Navigation -->
                        </div>
                        <!-- END Sidebar Content -->
                    </div>
                    <!-- END Wrapper for scrolling functionality -->


                </div>
                <!-- END Main Sidebar -->

                <!-- Main Container -->
                <div id="main-container">
                    <!-- Header -->
                    <!-- In the PHP version you can set the following options from inc/config file -->
                    <!--
                        Available header.navbar classes:

                        'navbar-default'            for the default light header
                        'navbar-inverse'            for an alternative dark header

                        'navbar-fixed-top'          for a top fixed header (fixed sidebars with scroll will be auto initialized, functionality can be found in js/app.js - handleSidebar())
                            'header-fixed-top'      has to be added on #page-container only if the class 'navbar-fixed-top' was added

                        'navbar-fixed-bottom'       for a bottom fixed header (fixed sidebars with scroll will be auto initialized, functionality can be found in js/app.js - handleSidebar()))
                            'header-fixed-bottom'   has to be added on #page-container only if the class 'navbar-fixed-bottom' was added
                    -->
                    <header class="navbar navbar-inverse navbar-fixed-top">
                        <!-- Left Header Navigation -->
                        <ul class="nav navbar-nav-custom">
                            <!-- Main Sidebar Toggle Button -->
                            <li>
                                <a href="javascript:void(0)" onclick="App.sidebar('toggle-sidebar');">
                                    <i class="fa fa-ellipsis-v fa-fw animation-fadeInRight" id="sidebar-toggle-mini"></i>
                                    <i class="fa fa-bars fa-fw animation-fadeInRight" id="sidebar-toggle-full"></i>
                                </a>
                            </li>
                            <!-- END Main Sidebar Toggle Button -->

                            <!-- Header Link -->
                            <li class="hidden-xs animation-fadeInQuick">
                                <a href=""><strong>หน้าหลัก</strong></a>
                            </li>
                            <!-- END Main Sidebar Toggle Button -->

                            <!-- Header Link -->

                            <!-- END Header Link -->
                        </ul>
                        <!-- END Left Header Navigation -->

                        <!-- Right Header Navigation -->
                        <ul class="nav navbar-nav-custom pull-right">


                            <!-- User Dropdown -->
                            <li class="dropdown">
                                <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">
                                    <img src="img/user/${profilepic}" alt="avatar"> ${name}
                                </a>
                                <ul class="dropdown-menu dropdown-menu-right">

                                    <li>
                                        <a href="message">
                                            <i class="fa fa-inbox fa-fw pull-right"></i>
                                            กล่องจดหมาย
                                        </a>
                                    </li>

                                    <li class="divider"><li>
                                    <li>
                                        <a href="setting">
                                            <i class="gi gi-settings fa-fw pull-right"></i>
                                            ตั้งค่า
                                        </a>
                                    </li>

                                    <li>
                                        <a href="logout">
                                            <i class="fa fa-power-off fa-fw pull-right"></i>
                                            ออกจากระบบ
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <!-- END User Dropdown -->
                        </ul>
                        <!-- END Right Header Navigation -->
                    </header>
                    <!-- END Header -->

                    <!-- Page content -->
                    <div id="page-content">
                        <!-- First Row -->
                        <div class="row">
                            <div class="col-sm-3">
                                        <a href="#" class="widget">
                                            <div class="widget-image widget-image-sm">
                                                <img src="img/notebook.jpg" alt="image">
                                                <div class="widget-image-content">
                                                    <h2 class="widget-heading text-light"><strong>ตรวจสอบผลน้ำตาลของผู้ป่วย</strong></h2>
                                                    <h3 class="widget-heading text-light-op h4"><em>ตรวจสอบได้ทันที ที่มีการจดข้อมูลเข้าระบบ</em></h3>
                                                </div>
                                                <i class="fa fa-plus"></i>
                                            </div>
                                        </a>
                                    </div>
                            <div class="col-sm-3">
                                        <a href="#" class="widget">
                                            <div class="widget-image widget-image-sm">
                                                <img src="img/graph.jpg" alt="image">
                                                <div class="widget-image-content">
                                                    <h2 class="widget-heading text-light"><strong>การสร้างกราฟ</strong></h2>
                                                    <h3 class="widget-heading text-light-op h4"><em>ตรวจสอบระดับน้ำตาลย้อนหลัง แสดงข้อมูลแบบกราฟ</em></h3>
                                                </div>
                                                <i class="fa fa-bar-chart-o"></i>
                                            </div>
                                        </a>
                            </div>
                                    <div class="col-sm-3">
                                        <a href="docmessage" class="widget">
                                            <div class="widget-image widget-image-sm">
                                                <img src="img/doctor.jpg" alt="image">
                                                <div class="widget-image-content">
                                                    <h2 class="widget-heading text-light"><strong>ติดต่อกับคนไข้</strong></h2>
                                                    <h3 class="widget-heading text-light-op h4"><em>พูดดคุยกับคนไข้ พร้อมแสดงข้อมูลการบันทึก</em></h3>
                                                </div>
                                                <i class="fa fa-comments"></i>
                                            </div>
                                        </a>
                                    </div>
                                    <div class="col-sm-3">
                                        <a href="ranking" class="widget">
                                            <div class="widget-image widget-image-sm">
                                                <img src="img/winner.jpg" alt="image">
                                                <div class="widget-image-content">
                                                    <h2 class="widget-heading text-light"><strong>การแข่งขัน</strong></h2>
                                                    <h3 class="widget-heading text-light-op h4"><em>เพิ่มความท้าทายให้แก่คนไข้ของคุณ !</em></h3>
                                                </div>
                                                <i class="fa fa-trophy"></i>
                                            </div>
                                        </a>
                                    </div>
                                    <!-- END Image Widgets -->
                            <!-- Simple Stats Widgets -->
                                <div class="col-sm-4">
                                    <a href="#" class="widget">
                                        <div class="widget-content widget-content-mini themed-background-info text-light-op">
                                            <i class="fa fa-clock-o"></i> <strong>ยินดีต้อนรับ</strong>
                                        </div>
                                        <div class="widget-content text-right clearfix">
                                            <div class="widget-icon pull-left">
                                                <i class="fa fa-user-md text-muted"></i>
                                            </div>
                                            <h2 class="widget-heading h3 text-info">
                                                <i class="fa fa-plus"></i> <strong>${name}</strong>
                                            </h2>
                                            <span class="text-muted">แพทย์ผู้รักษา</span>

                                        </div>
                                    </a>
                                </div>
                                <div class="col-sm-2">
                                    <a href="#"class="widget">
                                        <div class="widget-content themed-background-danger text-light-op text-center">
                                            <div class="widget-icon center-block push">
                                                <i class="fa fa-database"></i>
                                            </div>
                                            <strong>คนไข้ทั้งหมด<br /> ${pno} คน<br /></strong>
                                        </div>
                                    </a>
                                </div>
                                <div class="col-sm-2">
                                    <a href="req"class="widget">
                                        <div class="widget-content themed-background-info text-light-op text-center">
                                            <div class="widget-icon center-block push">
                                                <i class="fa fa-plus"></i>
                                            </div>
                                            <strong>คุณมี<br/> ${noreq} คำร้องขอ<br /></strong>
                                        </div>
                                    </a>
                                </div>

                                
                                <div class="col-sm-4">
                                    <a href="doccalendar" class="widget">
                                        <div class="widget-content widget-content-mini themed-background-success text-light-op">
                                            <i class="fa fa-clock-o"></i> <strong>ตารางนัดหมาย</strong>
                                        </div>
                                        <div class="widget-content text-right clearfix">
                                            <div class="widget-icon pull-left">
                                                <i class="fa fa-calendar text-muted"></i>
                                            </div>
                                            <h2 class="widget-heading h3 text-success">
                                                <i class="fa fa-plus"></i> <strong>${nextApp}</strong>
                                            </h2>
                                            <span class="text-muted">แสดงวันการนัดหมายครั้งถัดไป</span>
                                        </div>
                                    </a>
                                </div>

                                <div class="block col-sm-12">
                                    <div class="block-title">
                                        <h2>รายชื่อคนไข้ของฉัน</h2>
                                    </div>

                                    <div class="table-responsive">
                                        <table id="example-datatable" class="table table-striped table-bordered table-vcenter">
                                            <thead>
                                                <tr>
                                                    <th>ชื่อผู้ใช้</th>
                                                    <th>ชื่อจริง</th>
                                                    <th>โรงพยาบาล</th>
                                                    <th>eAG</th>
                                                    <th>ตำแหน่งคะแนน</th>

                                                </tr>
                                            </thead>
                                            <tbody>
                                                ${userTable}
                                        </table>   
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- END Third Row -->
                </div>
                <!-- END Page Content -->
            </div>
            <!-- END Main Container -->
        </div>
        <!-- END Page Container -->
    </div>
    <!-- END Page Wrapper -->

    <!-- Include Jquery library from Google's CDN but if something goes wrong get Jquery from local file (Remove 'http:' if you have SSL) -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script>!window.jQuery && document.write(decodeURI('%3Cscript src="js/vendor/jquery-2.1.1.min.js"%3E%3C/script%3E'));</script>

    <!-- Bootstrap.js, Jquery plugins and Custom JS code -->
    <script src="js/vendor/bootstrap.min.js"></script>
    <script src="js/plugins.js"></script>
    <script src="js/app.js"></script>

    <!-- Load and execute javascript code used only in this page -->
    <script>
                                    var dataBlood = ${chartValue}
                                    var dataMonths = ${chartDate}
    </script>
     <script src="js/pages/uiTables.js"></script>
    <script>$(function() {
                UiTables.init();
            });</script>
    
    
</body>
</html>