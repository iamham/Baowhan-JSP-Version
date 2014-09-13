package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.User;
import model.DiabetesLog;
import model.NutritionDB;
import model.MedicineDB;
import model.Content;
import java.util.List;

public final class dashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<!--[if IE 9]>         <html class=\"no-js lt-ie10\"> <![endif]-->\r\n");
      out.write("<!--[if gt IE 9]><!--> <html class=\"no-js\"> <!--<![endif]-->\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("\r\n");
      out.write("        <title>Baowhan:เบาหวาน - หน้าหลัก</title>\r\n");
      out.write("\r\n");
      out.write("        <meta name=\"description\" content=\"AppUI is a Bootstrap Admin Web App Template created by pixelcave and published on Themeforest\">\r\n");
      out.write("        <meta name=\"author\" content=\"pixelcave\">\r\n");
      out.write("        <meta name=\"robots\" content=\"noindex, nofollow\">\r\n");
      out.write("\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width,initial-scale=1,maximum-scale=1.0\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Icons -->\r\n");
      out.write("        <!-- The following icons can be replaced with your own, they are used by desktop and mobile browsers -->\r\n");
      out.write("        <link rel=\"shortcut icon\" href=\"img/favicon.ico\">\r\n");
      out.write("        <link rel=\"apple-touch-icon\" href=\"img/icon57.png\" sizes=\"57x57\">\r\n");
      out.write("        <link rel=\"apple-touch-icon\" href=\"img/icon72.png\" sizes=\"72x72\">\r\n");
      out.write("        <link rel=\"apple-touch-icon\" href=\"img/icon76.png\" sizes=\"76x76\">\r\n");
      out.write("        <link rel=\"apple-touch-icon\" href=\"img/icon114.png\" sizes=\"114x114\">\r\n");
      out.write("        <link rel=\"apple-touch-icon\" href=\"img/icon120.png\" sizes=\"120x120\">\r\n");
      out.write("        <link rel=\"apple-touch-icon\" href=\"img/icon144.png\" sizes=\"144x144\">\r\n");
      out.write("        <link rel=\"apple-touch-icon\" href=\"img/icon152.png\" sizes=\"152x152\">\r\n");
      out.write("        <!-- END Icons -->\r\n");
      out.write("\r\n");
      out.write("        <!-- Stylesheets -->\r\n");
      out.write("        <!-- Bootstrap is included in its original form, unaltered -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Related styles of various icon packs and plugins -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/plugins.css\">\r\n");
      out.write("\r\n");
      out.write("        <!-- The main stylesheet of this template. All Bootstrap overwrites are defined in here -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/main.css\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Include a specific file here from css/themes/ folder to alter the default theme of the template -->\r\n");
      out.write("\r\n");
      out.write("        <!-- The themes stylesheet of this template (for using specific theme color in individual elements - must included last) -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/themes.css\">\r\n");
      out.write("        <!-- END Stylesheets -->\r\n");
      out.write("\r\n");
      out.write("        <!-- Modernizr (browser feature detection library) -->\r\n");
      out.write("        <script src=\"js/vendor/modernizr-2.8.3.js\"></script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <!-- Page Wrapper -->\r\n");
      out.write("        <!-- In the PHP version you can set the following options from inc/config file -->\r\n");
      out.write("        <!--\r\n");
      out.write("            Available classes:\r\n");
      out.write("\r\n");
      out.write("            'page-loading'      enables page preloader\r\n");
      out.write("        -->\r\n");
      out.write("        <div id=\"page-wrapper\" class=\"page-loading\">\r\n");
      out.write("            <!-- Preloader -->\r\n");
      out.write("            <!-- Preloader functionality (initialized in js/app.js) - pageLoading() -->\r\n");
      out.write("            <!-- Used only if page preloader enabled from inc/config (PHP version) or the class 'page-loading' is added in body element (HTML version) -->\r\n");
      out.write("            <div class=\"preloader\">\r\n");
      out.write("                <div class=\"inner\">\r\n");
      out.write("                    <!-- Animation spinner for all modern browsers -->\r\n");
      out.write("                    <div class=\"preloader-spinner themed-background hidden-lt-ie10\"></div>\r\n");
      out.write("\r\n");
      out.write("                    <!-- Text for IE9 -->\r\n");
      out.write("                    <h3 class=\"text-primary visible-lt-ie10\"><strong>จัดเตรียมข้อมูลของคุณ...</strong></h3>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- END Preloader -->\r\n");
      out.write("\r\n");
      out.write("            <!-- Page Container -->\r\n");
      out.write("            <!-- In the PHP version you can set the following options from inc/config file -->\r\n");
      out.write("            <!--\r\n");
      out.write("                Available #page-container classes:\r\n");
      out.write("\r\n");
      out.write("                'sidebar-visible-lg-mini'                       main sidebar condensed - Mini Navigation (> 991px)\r\n");
      out.write("                'sidebar-visible-lg-full'                       main sidebar full - Full Navigation (> 991px)\r\n");
      out.write("\r\n");
      out.write("                'sidebar-alt-visible-lg'                        alternative sidebar visible by default (> 991px) (You can add it along with another class)\r\n");
      out.write("\r\n");
      out.write("                'header-fixed-top'                              has to be added only if the class 'navbar-fixed-top' was added on header.navbar\r\n");
      out.write("                'header-fixed-bottom'                           has to be added only if the class 'navbar-fixed-bottom' was added on header.navbar\r\n");
      out.write("            -->\r\n");
      out.write("            <div id=\"page-container\" class=\"header-fixed-top sidebar-visible-lg-full\">\r\n");
      out.write("                <!-- Alternative Sidebar -->\r\n");
      out.write("                <div id=\"sidebar-alt\" tabindex=\"-1\" aria-hidden=\"true\">\r\n");
      out.write("\r\n");
      out.write("                    <!-- Wrapper for scrolling functionality -->\r\n");
      out.write("                    <div id=\"sidebar-scroll-alt\">\r\n");
      out.write("                        <!-- Sidebar Content -->\r\n");
      out.write("                        <div class=\"sidebar-content\">\r\n");
      out.write("                            \r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!-- END Sidebar Content -->\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!-- END Wrapper for scrolling functionality -->\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- END Alternative Sidebar -->\r\n");
      out.write("\r\n");
      out.write("                <!-- Main Sidebar -->\r\n");
      out.write("                <div id=\"sidebar\">\r\n");
      out.write("                    <!-- Sidebar Brand -->\r\n");
      out.write("                    <div id=\"sidebar-brand\" class=\"themed-background\">\r\n");
      out.write("                        <a href=\"index.html\" class=\"sidebar-title\">\r\n");
      out.write("                             <span class=\"sidebar-nav-mini-hide\">เบา<strong>หวาน</strong> | Bao<strong>whan</strong></span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!-- END Sidebar Brand -->\r\n");
      out.write("\r\n");
      out.write("                    <!-- Wrapper for scrolling functionality -->\r\n");
      out.write("                    <div id=\"sidebar-scroll\">\r\n");
      out.write("                        <!-- Sidebar Content -->\r\n");
      out.write("                        <div class=\"sidebar-content\">\r\n");
      out.write("                            <!-- Sidebar Navigation -->\r\n");
      out.write("                            <ul class=\"sidebar-nav\">\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <a href=\"#\" class=\" active\"><i class=\"gi gi-compass sidebar-nav-icon\"></i><span class=\"sidebar-nav-mini-hide\">หน้าหลัก</span></a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li class=\"sidebar-separator\">\r\n");
      out.write("                                    <i class=\"fa fa-ellipsis-h\"></i>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <a href=\"#\" class=\"sidebar-nav-submenu\"><i class=\"fa fa-tint sidebar-nav-icon\"></i><i class=\"fa fa-chevron-left sidebar-nav-indicator\"></i><span class=\"sidebar-nav-mini-hide\">ผลน้ำตาล</span></a>\r\n");
      out.write("                                     <ul>\r\n");
      out.write("                                                <li>\r\n");
      out.write("                                                    <a href=\"addRecord\">เพิ่ม/บันทึก ผลน้ำตาล</a>\r\n");
      out.write("                                                </li>\r\n");
      out.write("                                                <li>\r\n");
      out.write("                                                    <a href=\"checkRecord\">ตรวจสอบผลน้ำตาล</a>\r\n");
      out.write("                                                </li>\r\n");
      out.write("                                    </ul>\r\n");
      out.write("\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <a href=\"message\" ><i class=\"fa fa-comments sidebar-nav-icon\"></i><span class=\"sidebar-nav-mini-hide\">ติดต่อแพทย์</span></a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                 <li>\r\n");
      out.write("                                    <a href=\"calendar\" ><i class=\"fa fa-calendar sidebar-nav-icon\"></i><span class=\"sidebar-nav-mini-hide\">ปฏิทิน</span></a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <a href=\"tools\" ><i class=\"fa fa-stethoscope sidebar-nav-icon\"></i><span class=\"sidebar-nav-mini-hide\">เครื่องมือ</span></a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <a href=\"nutrient\" ><i class=\"fa fa-cutlery sidebar-nav-icon\"></i><span class=\"sidebar-nav-mini-hide\">โภชนาการ</span></a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <a href=\"news\" ><i class=\"fa fa-folder-open sidebar-nav-icon\"></i><span class=\"sidebar-nav-mini-hide\">ข่าวสาร</span></a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                        \r\n");
      out.write("                                           \r\n");
      out.write("                            </ul>\r\n");
      out.write("                            <!-- END Sidebar Navigation -->\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!-- END Sidebar Content -->\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!-- END Wrapper for scrolling functionality -->\r\n");
      out.write("\r\n");
      out.write("                    \r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- END Main Sidebar -->\r\n");
      out.write("\r\n");
      out.write("                <!-- Main Container -->\r\n");
      out.write("                <div id=\"main-container\">\r\n");
      out.write("                    <!-- Header -->\r\n");
      out.write("                    <!-- In the PHP version you can set the following options from inc/config file -->\r\n");
      out.write("                    <!--\r\n");
      out.write("                        Available header.navbar classes:\r\n");
      out.write("\r\n");
      out.write("                        'navbar-default'            for the default light header\r\n");
      out.write("                        'navbar-inverse'            for an alternative dark header\r\n");
      out.write("\r\n");
      out.write("                        'navbar-fixed-top'          for a top fixed header (fixed sidebars with scroll will be auto initialized, functionality can be found in js/app.js - handleSidebar())\r\n");
      out.write("                            'header-fixed-top'      has to be added on #page-container only if the class 'navbar-fixed-top' was added\r\n");
      out.write("\r\n");
      out.write("                        'navbar-fixed-bottom'       for a bottom fixed header (fixed sidebars with scroll will be auto initialized, functionality can be found in js/app.js - handleSidebar()))\r\n");
      out.write("                            'header-fixed-bottom'   has to be added on #page-container only if the class 'navbar-fixed-bottom' was added\r\n");
      out.write("                    -->\r\n");
      out.write("                    <header class=\"navbar navbar-inverse navbar-fixed-top\">\r\n");
      out.write("                        <!-- Left Header Navigation -->\r\n");
      out.write("                        <ul class=\"nav navbar-nav-custom\">\r\n");
      out.write("                            <!-- Main Sidebar Toggle Button -->\r\n");
      out.write("                            \r\n");
      out.write("                            <!-- END Main Sidebar Toggle Button -->\r\n");
      out.write("\r\n");
      out.write("                            <!-- Header Link -->\r\n");
      out.write("                           \r\n");
      out.write("                            <!-- END Header Link -->\r\n");
      out.write("                        </ul>\r\n");
      out.write("                        <!-- END Left Header Navigation -->\r\n");
      out.write("\r\n");
      out.write("                        <!-- Right Header Navigation -->\r\n");
      out.write("                        <ul class=\"nav navbar-nav-custom pull-right\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            <!-- User Dropdown -->\r\n");
      out.write("                            <li class=\"dropdown\">\r\n");
      out.write("                                <a href=\"javascript:void(0)\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\r\n");
      out.write("                                    <img src=\"img/user/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${profilepic}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" alt=\"avatar\"> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("                                </a>\r\n");
      out.write("                                <ul class=\"dropdown-menu dropdown-menu-right\">\r\n");
      out.write("                                    \r\n");
      out.write("                                    <li>\r\n");
      out.write("                                        <a href=\"message\">\r\n");
      out.write("                                            <i class=\"fa fa-inbox fa-fw pull-right\"></i>\r\n");
      out.write("                                            กล่องจดหมาย\r\n");
      out.write("                                        </a>\r\n");
      out.write("                                    </li>\r\n");
      out.write("                                    \r\n");
      out.write("                                    <li class=\"divider\"><li>\r\n");
      out.write("                                    <li>\r\n");
      out.write("                                        <a href=\"setting\">\r\n");
      out.write("                                            <i class=\"gi gi-settings fa-fw pull-right\"></i>\r\n");
      out.write("                                            ตั้งค่า\r\n");
      out.write("                                        </a>\r\n");
      out.write("                                    </li>\r\n");
      out.write("                                   \r\n");
      out.write("                                    <li>\r\n");
      out.write("                                        <a href=\"logout\">\r\n");
      out.write("                                            <i class=\"fa fa-power-off fa-fw pull-right\"></i>\r\n");
      out.write("                                            ออกจากระบบ\r\n");
      out.write("                                        </a>\r\n");
      out.write("                                    </li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <!-- END User Dropdown -->\r\n");
      out.write("                        </ul>\r\n");
      out.write("                        <!-- END Right Header Navigation -->\r\n");
      out.write("                    </header>\r\n");
      out.write("                    <!-- END Header -->\r\n");
      out.write("\r\n");
      out.write("                    <!-- Page content -->\r\n");
      out.write("                    <div id=\"page-content\">\r\n");
      out.write("                        <!-- First Row -->\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <!-- Simple Stats Widgets -->\r\n");
      out.write("                            \r\n");
      out.write("                            <div class=\"col-sm-6 col-lg-3\">\r\n");
      out.write("                                <a href=\"calendar\" class=\"widget\">\r\n");
      out.write("                                    <div class=\"widget-content themed-background-danger text-light-op text-center\">\r\n");
      out.write("                                                <div class=\"widget-icon center-block push\">\r\n");
      out.write("                                                    <i class=\"fa fa-plus\"></i>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                                <strong>เพิ่ม/บันทึก ผลน้ำตาล</strong>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                </a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-sm-6 col-lg-3\">\r\n");
      out.write("                                <a href=\"calendar\" class=\"widget\">\r\n");
      out.write("                                    <div class=\"widget-content widget-content-mini themed-background-success text-light-op\">\r\n");
      out.write("                                        <i class=\"fa fa-clock-o\"></i> <strong>ตารางนัดหมหาย</strong>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"widget-content text-right clearfix\">\r\n");
      out.write("                                        <div class=\"widget-icon pull-left\">\r\n");
      out.write("                                            <i class=\"fa fa-calendar text-muted\"></i>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <h2 class=\"widget-heading h3 text-success\">\r\n");
      out.write("                                            <i class=\"fa fa-plus\"></i> <strong>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${nextApp}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</strong>\r\n");
      out.write("                                        </h2>\r\n");
      out.write("                                        <span class=\"text-muted\">รพ.");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${hospital}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-sm-6 col-lg-3\">\r\n");
      out.write("                                <a href=\"javascript:void(0)\" class=\"widget\">\r\n");
      out.write("                                    <div class=\"widget-content widget-content-mini themed-background-warning text-light-op\">\r\n");
      out.write("                                        <i class=\"fa fa-clock-o\"></i> <strong>ผลบันทึกล่าสุด</strong>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"widget-content text-right clearfix\">\r\n");
      out.write("                                        <div class=\"widget-icon pull-left\">\r\n");
      out.write("                                            <i class=\"fa fa-tint text-muted\"></i>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <h2 class=\"widget-heading h3 text-warning\">\r\n");
      out.write("                                            <i class=\"fa fa-plus\"></i> <strong><span data-toggle=\"counter\" data-to=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${lastRec}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></span></strong>\r\n");
      out.write("                                        </h2>\r\n");
      out.write("                                        <span class=\"text-muted\">mg/dL</span>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"col-sm-6 col-lg-3\">\r\n");
      out.write("                                <a href=\"ranking\" class=\"widget\">\r\n");
      out.write("                                    <div class=\"widget-content widget-content-mini themed-background-danger text-light-op\">\r\n");
      out.write("                                        <i class=\"fa fa-clock-o\"></i> <strong>อันดับคะแนน</strong>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"widget-content text-right clearfix\">\r\n");
      out.write("                                        <div class=\"widget-icon pull-left\">\r\n");
      out.write("                                            <i class=\"gi gi-cardio text-muted\"></i>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <h2 class=\"widget-heading h3 text-danger\">\r\n");
      out.write("                                            <i class=\"fa fa-plus\"></i> <strong><span data-toggle=\"counter\" data-to=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${position}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></span></strong>\r\n");
      out.write("                                        </h2>\r\n");
      out.write("                                        <span class=\"text-muted\">อันดับที่</span>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            \r\n");
      out.write("                            <!-- END Simple Stats Widgets -->\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!-- END First Row -->\r\n");
      out.write("\r\n");
      out.write("                        <!-- Second Row -->\r\n");
      out.write("                        \r\n");
      out.write("                            <div class=\"block\">\r\n");
      out.write("                                <div class=\"widget-content\">\r\n");
      out.write("                                        <div class=\"row text-center\">\r\n");
      out.write("                                            \r\n");
      out.write("                                            <div class=\"widget-content widget-content-mini themed-background-");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write(" text-light-op\">\r\n");
      out.write("                                                ค่าเฉลี่ยน้ำตาลของคุณคือ ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eAG}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${instruction}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("                                                 </div>\r\n");
      out.write("                                            \r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                <!-- Chart Widget -->\r\n");
      out.write("                                <div class=\"widget\">\r\n");
      out.write("                                    <div class=\"widget-content widget-content-mini themed-background-dark text-light-op\">\r\n");
      out.write("                                        \r\n");
      out.write("                                        <i class=\"fa fa-fw fa-database\"></i> <strong>ผลน้ำตาลในรอบ 1 เดือน</strong>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"widget-content themed-background-muted\">\r\n");
      out.write("                                        <!-- Flot Charts (initialized in js/pages/readyDashboard.js), for more examples you can check out http://www.flotcharts.org/ -->\r\n");
      out.write("                                        <div id=\"chart-classic-dash\" style=\"height: 393px;\"></div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    \r\n");
      out.write("                                </div>\r\n");
      out.write("                                <!-- END Chart Widget -->\r\n");
      out.write("                            </div>\r\n");
      out.write("                            \r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!-- END Third Row -->\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!-- END Page Content -->\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- END Main Container -->\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- END Page Container -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- END Page Wrapper -->\r\n");
      out.write("\r\n");
      out.write("        <!-- Include Jquery library from Google's CDN but if something goes wrong get Jquery from local file (Remove 'http:' if you have SSL) -->\r\n");
      out.write("        <script src=\"http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js\"></script>\r\n");
      out.write("        <script>!window.jQuery && document.write(decodeURI('%3Cscript src=\"js/vendor/jquery-2.1.1.min.js\"%3E%3C/script%3E'));</script>\r\n");
      out.write("\r\n");
      out.write("        <!-- Bootstrap.js, Jquery plugins and Custom JS code -->\r\n");
      out.write("        <script src=\"js/vendor/bootstrap.min.js\"></script>\r\n");
      out.write("        <script src=\"js/plugins.js\"></script>\r\n");
      out.write("        <script src=\"js/app.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- Load and execute javascript code used only in this page -->\r\n");
      out.write("        <script>\r\n");
      out.write("            var dataBlood= ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${chartValue}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("            var dataMonths= ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${chartDate}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("        <script src=\"js/pages/readyDashboard.js\"></script>\r\n");
      out.write("        <script>$(function(){ ReadyDashboard.init(); });</script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eAG > 160}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("danger");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${eAG < 160}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("success");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }
}
