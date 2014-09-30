<%-- 
    Document   : Register
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

        <title>Baowhan:เบาหวาน - ลงทะเบียนสำหรับแพทย์</title>

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
        <img src="img/sunset.jpg" alt="Full Background" class="full-bg full-bg-bottom animation-pulseSlow">
        <!-- Login Container -->
        <div id="login-container" style="top:0px">
            <h1 class="h2 text-light text-center push-top-bottom animation-slideDown" style="margin-bottom:5px">
                <strong>ลงทะเบียนบุคลากรทางการแพทย์ เบาหวาน</strong>.com
                <h4 class="h4 text-light text-center push-top-bottom animation-slideDown" style="margin-top:0"><a href="register1" class="text-light" style="text-decoration: none">สำหรับผู้ป่วยโปรดลงทะเบียน ที่นี่</a></h4>
            </h1>
            ${msg}
            <!-- Progress Bars Wizard Title -->
            <div class="block animation-fadeInQuickInv">
                <div class="block-title">

                    <h2>ลงทะเบียน</h2>
                </div>
                <!-- END Progress Bar Wizard Title -->

                <!-- Progress Wizard Content -->
                <form id="progress-wizard" action="getdRegister"  method="post" class="form-horizontal form-bordered">
                    <div class="form-group">
                        <div class="col-xs-12">
                            <div class="progress progress-mini remove-margin">
                                <div id="progress-bar-wizard" class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0"></div>
                            </div>
                        </div>
                    </div>
                    <!-- END Progress Bar -->

                    <!-- First Step -->
                    <div id="progress-first" class="step">
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="username">ชื่อผู้ใช้<b class="text-danger">*</b><br>Username</label>
                            <div class="col-md-6">
                                <input type="text" id="username" name="username" class="form-control" placeholder="ชื่อผู้ใช้" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="email">อีเมล์<b class="text-danger">*</b><br>Email</label>
                            <div class="col-md-6">
                                <input type="email" id="email" name="email" class="form-control" placeholder="อีเมล์" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="pwd1">รหัสผ่าน<b class="text-danger">*</b><br>Password</label>
                            <div class="col-md-6">
                                <input type="password" id="pwd1" name="pwd1" class="form-control" placeholder="รหัสผ่าน" required="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="pwd2">ระบุรหัสผ่านอีกครั้ง<b class="text-danger">*</b></label>
                            <div class="col-md-6">
                                <input type="password" id="pwd2" name="pwd2" class="form-control" placeholder="ยืนยันรหัสผ่านอีกครั้ง" required>
                            </div>
                        </div>
                        
                    </div>
                    <!-- END First Step -->

                    <!-- Second Step -->
                    <div id="progress-second" class="step">
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="firstname">ชื่อ<b class="text-danger">*</b><br>Firstname</label>
                            <div class="col-md-6">
                                <input type="text" id="firstname" name="firstname" class="form-control" placeholder="ชื่อ" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="lastname">นามสกุล<b class="text-danger">*</b><br>Lastname</label>
                            <div class="col-md-6">
                                <input type="text" id="lastname" name="lastname" class="form-control" placeholder="นามสกุล" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="telephone">เบอร์โทรศัพท์<b class="text-danger">*</b><br>Telephone</label>
                            <div class="col-md-6">
                                <input type="telephone" id="telephone" name="telephone" class="form-control" placeholder="เบอร์โทรศัพท์" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="province">จังหวัด<br>Province</label>
                            <div class="col-md-5">
                                <select id="province" name="province" class="select-chosen" data-placeholder="จังหวัด">

                                    <option value="กรุงเทพมหานคร">กรุงเทพมหานคร</option>
                                    <option value="กระบี่">กระบี่ </option>
                                    <option value="กาญจนบุรี">กาญจนบุรี </option>
                                    <option value="กาฬสินธุ์">กาฬสินธุ์ </option>
                                    <option value="กำแพงเพชร">กำแพงเพชร </option>
                                    <option value="ขอนแก่น">ขอนแก่น</option>
                                    <option value="จันทบุรี">จันทบุรี</option>
                                    <option value="ฉะเชิงเทรา">ฉะเชิงเทรา </option>
                                    <option value="ชัยนาท">ชัยนาท </option>
                                    <option value="ชัยภูมิ">ชัยภูมิ </option>
                                    <option value="ชุมพร">ชุมพร </option>
                                    <option value="ชลบุรี">ชลบุรี </option>
                                    <option value="เชียงใหม่">เชียงใหม่ </option>
                                    <option value="เชียงราย">เชียงราย </option>
                                    <option value="ตรัง">ตรัง </option>
                                    <option value="ตราด">ตราด </option>
                                    <option value="ตาก">ตาก </option>
                                    <option value="นครนายก">นครนายก </option>
                                    <option value="นครปฐม">นครปฐม </option>
                                    <option value="นครพนม">นครพนม </option>
                                    <option value="นครราชสีมา">นครราชสีมา </option>
                                    <option value="นครศรีธรรมราช">นครศรีธรรมราช </option>
                                    <option value="นครสวรรค์">นครสวรรค์ </option>
                                    <option value="นราธิวาส">นราธิวาส </option>
                                    <option value="น่าน">น่าน </option>
                                    <option value="นนทบุรี">นนทบุรี </option>
                                    <option value="บึงกาฬ">บึงกาฬ</option>
                                    <option value="บุรีรัมย์">บุรีรัมย์</option>
                                    <option value="ประจวบคีรีขันธ์">ประจวบคีรีขันธ์ </option>
                                    <option value="ปทุมธานี">ปทุมธานี </option>
                                    <option value="ปราจีนบุรี">ปราจีนบุรี </option>
                                    <option value="ปัตตานี">ปัตตานี </option>
                                    <option value="พะเยา">พะเยา </option>
                                    <option value="พระนครศรีอยุธยา">พระนครศรีอยุธยา </option>
                                    <option value="พังงา">พังงา </option>
                                    <option value="พิจิตร">พิจิตร </option>
                                    <option value="พิษณุโลก">พิษณุโลก </option>
                                    <option value="เพชรบุรี">เพชรบุรี </option>
                                    <option value="เพชรบูรณ์">เพชรบูรณ์ </option>
                                    <option value="แพร่">แพร่ </option>
                                    <option value="พัทลุง">พัทลุง </option>
                                    <option value="ภูเก็ต">ภูเก็ต </option>
                                    <option value="มหาสารคาม">มหาสารคาม </option>
                                    <option value="มุกดาหาร">มุกดาหาร </option>
                                    <option value="แม่ฮ่องสอน">แม่ฮ่องสอน </option>
                                    <option value="ยโสธร">ยโสธร </option>
                                    <option value="ยะลา">ยะลา </option>
                                    <option value="ร้อยเอ็ด">ร้อยเอ็ด </option>
                                    <option value="ระนอง">ระนอง </option>
                                    <option value="ระยอง">ระยอง </option>
                                    <option value="ราชบุรี">ราชบุรี</option>
                                    <option value="ลพบุรี">ลพบุรี </option>
                                    <option value="ลำปาง">ลำปาง </option>
                                    <option value="ลำพูน">ลำพูน </option>
                                    <option value="เลย">เลย </option>
                                    <option value="ศรีสะเกษ">ศรีสะเกษ</option>
                                    <option value="สกลนคร">สกลนคร</option>
                                    <option value="สงขลา">สงขลา </option>
                                    <option value="สมุทรสาคร">สมุทรสาคร </option>
                                    <option value="สมุทรปราการ">สมุทรปราการ </option>
                                    <option value="สมุทรสงคราม">สมุทรสงคราม </option>
                                    <option value="สระแก้ว">สระแก้ว </option>
                                    <option value="สระบุรี">สระบุรี </option>
                                    <option value="สิงห์บุรี">สิงห์บุรี </option>
                                    <option value="สุโขทัย">สุโขทัย </option>
                                    <option value="สุพรรณบุรี">สุพรรณบุรี </option>
                                    <option value="สุราษฎร์ธานี">สุราษฎร์ธานี </option>
                                    <option value="สุรินทร์">สุรินทร์ </option>
                                    <option value="สตูล">สตูล </option>
                                    <option value="หนองคาย">หนองคาย </option>
                                    <option value="หนองบัวลำภู">หนองบัวลำภู </option>
                                    <option value="อำนาจเจริญ">อำนาจเจริญ </option>
                                    <option value="อุดรธานี">อุดรธานี </option>
                                    <option value="อุตรดิตถ์">อุตรดิตถ์ </option>
                                    <option value="อุทัยธานี">อุทัยธานี </option>
                                    <option value="อุบลราชธานี">อุบลราชธานี</option>
                                    <option value="อ่างทอง">อ่างทอง </option>
                                    <option value="อื่นๆ">อื่นๆ</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <!-- END Second Step -->

                    <!-- Third Step -->
                    <div id="progress-third" class="step">
                       
                           
                       
                        <div class="form-group">
                            <label class="col-md-4 control-label"><a href="#modal-terms" data-toggle="modal">ข้อตกลง<b class="text-danger">*</b></a></label>
                            <div class="col-md-8">
                                <label class="switch switch-primary" for="example-progress-terms">
                                    <input type="checkbox" id="example-progress-terms" name="example-progress-terms" value="1">
                                    <span data-toggle="tooltip" title="ฉันยอมรับข้อตกลง"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <!-- END Third Step -->

                    <!-- Form Buttons -->
                    <div class="form-group form-actions">
                        <div class="col-md-8 col-md-offset-4">
                            <button type="reset" class="btn btn-effect-ripple btn-danger" id="back1">กลับ</button>
                            <button type="submit" class="btn btn-effect-ripple btn-primary" id="next2">ต่อไป</button>
                        </div>
                    </div>
                    <!-- END Form Buttons -->
                </form>
                <!-- END Progress Bar Wizard Content -->
            </div>
            <!-- END Progress Bar Wizard Block -->

        </div>
        <!-- END Login Container -->

        <!-- Modal Terms -->
        <div id="modal-terms" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h3 class="modal-title text-center"><strong>Terms and Conditions</strong></h3>
                    </div>
                    <div class="modal-body">
                        <h4 class="page-header">1. <strong>General</strong></h4>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ultrices, justo vel imperdiet gravida, urna ligula hendrerit nibh, ac cursus nibh sapien in purus. Mauris tincidunt tincidunt turpis in porta. Integer fermentum tincidunt auctor.</p>
                        <h4 class="page-header">2. <strong>Account</strong></h4>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ultrices, justo vel imperdiet gravida, urna ligula hendrerit nibh, ac cursus nibh sapien in purus. Mauris tincidunt tincidunt turpis in porta. Integer fermentum tincidunt auctor.</p>
                        <h4 class="page-header">3. <strong>Service</strong></h4>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ultrices, justo vel imperdiet gravida, urna ligula hendrerit nibh, ac cursus nibh sapien in purus. Mauris tincidunt tincidunt turpis in porta. Integer fermentum tincidunt auctor.</p>
                        <h4 class="page-header">4. <strong>Payments</strong></h4>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ultrices, justo vel imperdiet gravida, urna ligula hendrerit nibh, ac cursus nibh sapien in purus. Mauris tincidunt tincidunt turpis in porta. Integer fermentum tincidunt auctor.</p>
                    </div>
                    <div class="modal-footer">
                        <div class="text-center">
                            <button type="button" class="btn btn-effect-ripple btn-sm btn-primary" data-dismiss="modal">I've read them!</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- END Modal Terms -->

        <!-- Include Jquery library from Google's CDN but if something goes wrong get Jquery from local file (Remove 'http:' if you have SSL) -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script>!window.jQuery && document.write(decodeURI('%3Cscript src="js/vendor/jquery-2.1.1.min.js"%3E%3C/script%3E'));</script>

        <!-- Bootstrap.js, Jquery plugins and Custom JS code -->
        <script src="js/vendor/bootstrap.min.js"></script>
        <script src="js/plugins.js"></script>
        <script src="js/app.js"></script>

        <!-- Load and execute javascript code used only in this page -->
        <script src="js/pages/readyRegister.js"></script>
        <script>$(function() {
                ReadyRegister.init();
            });</script>
        <!-- Load and execute javascript code used only in this page -->
        <script src="js/pages/formsWizard.js"></script>
        <script>$(function() {
                FormsWizard.init();
            });</script>

    </body>
</html>