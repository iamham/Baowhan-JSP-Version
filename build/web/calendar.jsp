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
        <img src="img/bg.jpg" alt="Full Background" class="full-bg full-bg-bottom animation-pulseSlow">
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
                        <a href="dashboard" class="sidebar-title">
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
                                    <a href="#"><i class="gi gi-compass sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">หน้าหลัก</span></a>
                                </li>
                                <li class="sidebar-separator">
                                    <i class="fa fa-ellipsis-h"></i>
                                </li>
                                <li>
                                    <a href="#" class="sidebar-nav-submenu"><i class="fa fa-tint sidebar-nav-icon"></i><i class="fa fa-chevron-left sidebar-nav-indicator"></i><span class="sidebar-nav-mini">ผลน้ำตาล</span></a>
                                    <ul>
                                        <li>
                                            <a href="addRecord" >เพิ่ม/บันทึก ผลน้ำตาล</a>
                                        </li>
                                        <li>
                                            <a href="checkRecord" >ตรวจสอบผลน้ำตาล</a>
                                        </li>
                                    </ul>

                                </li>
                                <li>
                                    <a href="message" ><i class="fa fa-comments sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">ติดต่อแพทย์</span></a>
                                </li>
                                <li>
                                    <a href="calendar" class="active"><i class="fa fa-calendar sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">ปฏิทิน</span></a>
                                </li>
                                <li>
                                    <a href="tools" ><i class="fa fa-stethoscope sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">เครื่องมือ</span></a>
                                </li>
                                <li>
                                    <a href="nutrient" ><i class="fa fa-cutlery sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">โภชนาการ</span></a>
                                </li>
                                <li>
                                    <a href="news" ><i class="fa fa-folder-open sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">ข่าวสาร</span></a>
                                </li>
                                <li>
                                    <a href="setting"><i class="fa fa-folder-open sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">ตั้งค่า</span></a>
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
                                <a href=""><strong>ปฏิทิน</strong></a>
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
                                    <img src="img/user/${user.getProfilePIC()}" alt="avatar"> ${user.getFirstname()} ${user.getLastname()}
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
                        <div class="row">

                            <!-- Calendar Header -->
                            ${req}
                            <!-- FullCalendar Block -->
                            <div class="form-group">
                                <c:if test="${(status == 2)}">
                                    <a href="#addDoctor" class="btn btn-effect-ripple btn-info" data-toggle="modal">เพิ่มการนัดหมาย</a>
                                </c:if>
                                <a href="#addSelf" class="btn btn-effect-ripple btn-info" data-toggle="modal">เพิ่มปฏิทินส่วนตัว</a>
                            </div>
                            <div class="block col-sm-9">

                                <div class="row">


                                    <!-- FullCalendar (initialized in js/pages/compCalendar.js), for more info and examples you can check out http://arshaw.com/fullcalendar/ -->
                                    <div id="calendar"></div>
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <a href="message" class="widget">
                                    <div class="widget-image widget-image-sm">
                                        <img src="img/doctor.jpg" alt="image">
                                        <div class="widget-image-content">
                                            <h2 class="widget-heading text-light"><strong>นัดพบแพทย์ง่ายๆ</strong></h2>
                                            <h3 class="widget-heading text-light-op h4">1. เพิ่มปฏิทินการนัดหมาย<br />2. กรอกรายละเอียด<br />3. รอแพทย์ตอบรับ</h3>
                                        </div>

                                        <i class="fa fa-hospital-o"></i>
                                    </div>
                                </a>
                            </div>
                            <!-- END FullCalendar Block -->
                        </div>
                    </div>
                    <!-- END Page Content -->
                </div>
                <!-- END Main Container -->
            </div>
            <!-- END Page Container -->
        </div>
        <!-- END Page Wrapper -->
        <div id="addDoctor" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog ">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h3 class="modal-title"><strong>เพิ่มการนัดหมายกับแพทย์</strong></h3>
                    </div>
                    <div class="modal-body">
                        <form action="addCal" method="post"  class="form-horizontal form-bordered" >
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="to">นัดหมาย</label>
                                <div class="col-md-6">
                                    <input type="text" id="type" name="type" value="1" hidden>
                                    <input type="text" id="to" name="to" class="form-control" value="${doctor}" disabled required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="date">วันที่นัดหมาย</label>
                                <div class="col-md-5">
                                    <input type="text" id="date" name="date" class="form-control input-datepicker" data-date-format="dd/mm/yy" placeholder="วว/ดด/ปป" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="time">เวลาที่นัดหมาย</label>
                                <div class="col-md-5">
                                    <div class="input-group bootstrap-timepicker">
                                        <input type="text" id="time" name="time" class="form-control input-timepicker24" required>
                                        <span class="input-group-btn">
                                            <a href="javascript:void(0)" class="btn btn-effect-ripple btn-primary"><i class="fa fa-clock-o" ></i></a>
                                        </span>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-3 control-label" for="note">บันทึกเพิ่มเติม</label>
                                <div class="col-md-9">
                                    <textarea id="note" name="note" rows="7" class="form-control" placeholder="บันทึกเพิ่มเติม.."></textarea>
                                </div>
                            </div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-effect-ripple btn-primary">บันทึก</button>
                        <button type="reset" class="btn btn-effect-ripple btn-danger">ล้างข้อมูล</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div id="addSelf" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h3 class="modal-title"><strong>เพิ่มปฏิทินส่วนตัว</strong></h3>
                    </div>
                    <div class="modal-body">
                        <form action="addCal" method="post"  class="form-horizontal form-bordered" >
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="note">หัวข้อ</label>
                                <div class="col-md-9">
                                    <input type="text" id="type" name="type" value="2" hidden>
                                    <input type="text" id="note" name="note" class="form-control" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="date">วันที่</label>
                                <div class="col-md-5">
                                    <input type="text" id="date" name="date" class="form-control input-datepicker" data-date-format="dd/mm/yy" placeholder="วว/ดด/ปป" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="time">เวลา</label>
                                <div class="col-md-5">
                                    <div class="input-group bootstrap-timepicker">
                                        <input type="text" id="time" name="time" class="form-control input-timepicker24" required>
                                        <span class="input-group-btn">
                                            <a href="javascript:void(0)" class="btn btn-effect-ripple btn-primary"><i class="fa fa-clock-o" ></i></a>
                                        </span>
                                    </div>
                                </div>
                            </div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-effect-ripple btn-primary">บันทึก</button>
                        <button type="reset" class="btn btn-effect-ripple btn-danger">ล้างข้อมูล</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Include Jquery library from Google's CDN but if something goes wrong get Jquery from local file (Remove 'http:' if you have SSL) -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script>!window.jQuery && document.write(decodeURI('%3Cscript src="js/vendor/jquery-2.1.1.min.js"%3E%3C/script%3E'));</script>

        <!-- Bootstrap.js, Jquery plugins and Custom JS code -->
        <script src="js/vendor/bootstrap.min.js"></script>
        <script src="js/plugins.js"></script>
        <script src="js/app.js"></script>

        <!-- Load and execute javascript code used only in this page -->
        <script>
                                    var CompCalendar = function() {
                                        var calendarEvents = $('.calendar-events');

                                        /* Function for initializing drag and drop event functionality */
                                        var initEvents = function() {
                                            calendarEvents.find('li').each(function() {
                                                // create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
                                                var eventObject = {title: $.trim($(this).text()), color: $(this).css('background-color')};

                                                // store the Event Object in the DOM element so we can get to it later
                                                $(this).data('eventObject', eventObject);

                                                // make the event draggable using jQuery UI
                                                $(this).draggable({zIndex: 999, revert: true, revertDuration: 0});
                                            });
                                        };

                                        return {
                                            init: function() {
                                                /* Initialize drag and drop event functionality */
                                                initEvents();

                                                /* Add new event in the events list */
                                                var eventInput = $('#add-event');
                                                var eventInputVal = '';

                                                // When the add button is clicked
                                                $('#add-event-btn').on('click', function() {
                                                    // Get input value
                                                    eventInputVal = eventInput.prop('value');

                                                    // Check if the user entered something
                                                    if (eventInputVal) {
                                                        // Add it to the events list
                                                        calendarEvents.prepend('<li class="animation-fadeInQuick2Inv"><i class="fa fa-calendar"></i> ' + $('<div />').text(eventInputVal).html() + '</li>');

                                                        // Clear input field
                                                        eventInput.prop('value', '');

                                                        // Init Events
                                                        initEvents();

                                                        // Focus the input at the end
                                                        eventInput.focus();
                                                    }

                                                    // Don't let the form submit
                                                    return false;
                                                });

                                                $('#calendar').fullCalendar({
                                                    header: {
                                                        left: 'title',
                                                        center: '',
                                                        right: 'today month,agendaWeek,agendaDay prev,next'
                                                    },
                                                    firstDay: 1,
                                                    editable: false,
                                                    droppable: false,
                                                    events: ${cal}
                                                });
                                            }
                                        };
                                    }();
        </script>
        <script>$(function() {
                CompCalendar.init();
            });</script>
        <script src="js/pages/uiTypography.js"></script>
        <script>$(function() {
                UiTypography.init();
            });</script>

    </body>
</html>