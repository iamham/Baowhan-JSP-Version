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

public final class register1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Baowhan:เบาหวาน - ลงทะเบียน</title>\r\n");
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
      out.write("        <style type=\"text/css\">\r\n");
      out.write("html { \r\n");
      out.write("  background: url(img/pizza.jpg) no-repeat center center fixed; \r\n");
      out.write("  -webkit-background-size: cover;\r\n");
      out.write("  -moz-background-size: cover;\r\n");
      out.write("  -o-background-size: cover;\r\n");
      out.write("  background-size: cover;\r\n");
      out.write("}\r\n");
      out.write("        </style>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <!-- Login Container -->\r\n");
      out.write("        <div id=\"login-container\">\r\n");
      out.write("            <!-- Register Header -->\r\n");
      out.write("            <h1 class=\"h2 text-light text-center push-top-bottom animation-slideDown\">\r\n");
      out.write("                <i class=\"fa fa-plus\"></i> <strong>สร้างผู้ใช้</strong>\r\n");
      out.write("            </h1>\r\n");
      out.write("            <!-- END Register Header -->\r\n");
      out.write("\r\n");
      out.write("            <!-- Register Form -->\r\n");
      out.write("            <div class=\"block animation-fadeInQuickInv\">\r\n");
      out.write("                <!-- Register Title -->\r\n");
      out.write("                <div class=\"block-title\">\r\n");
      out.write("                    <div class=\"block-options pull-right\">\r\n");
      out.write("                        <a href=\"Login.jsp\" class=\"btn btn-effect-ripple btn-primary\" data-toggle=\"tooltip\" data-placement=\"left\" title=\"Back to login\"><i class=\"fa fa-user\"></i></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <h2>Register</h2>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- END Register Title -->\r\n");
      out.write("\r\n");
      out.write("                <!-- Register Form -->\r\n");
      out.write("                <form id=\"form-register\" action=\"Register\" method=\"post\" class=\"form-horizontal\">\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <div class=\"col-xs-12\">          \r\n");
      out.write("                            ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write(" \r\n");
      out.write("                            <input type=\"text\" id=\"username\" name=\"username\" class=\"form-control\" placeholder=\"ชื่อผู้ใช้ (Username)\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <div class=\"col-xs-12\">\r\n");
      out.write("                            <input type=\"text\" id=\"email\" name=\"email\" class=\"form-control\" placeholder=\"อีเมล์ (Email)\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <div class=\"col-xs-12\">\r\n");
      out.write("                            <input type=\"password\" id=\"pwd1\" name=\"pwd1\" class=\"form-control\" placeholder=\"รหัสผ่าน (Password)\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <div class=\"col-xs-12\">\r\n");
      out.write("                            <input type=\"password\" id=\"pwd2\" name=\"pwd2\" class=\"form-control\" placeholder=\"ยืนยันรหัสผ่าน (Verify Password)\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"form-group form-actions\">\r\n");
      out.write("                        <div class=\"col-xs-6\">\r\n");
      out.write("                            <label class=\"csscheckbox csscheckbox-primary\" data-toggle=\"tooltip\" title=\"Agree to the terms\">\r\n");
      out.write("                                <input type=\"checkbox\" id=\"register-terms\" name=\"register-terms\">\r\n");
      out.write("                                <span></span>\r\n");
      out.write("                            </label>\r\n");
      out.write("                            <a href=\"#modal-terms\" data-toggle=\"modal\">ข้อตกลง</a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-xs-6 text-right\">\r\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-effect-ripple btn-success\"><i class=\"fa fa-plus\"></i> สร้างผู้ใช้</button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </form>\r\n");
      out.write("                <!-- END Register Form -->\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- END Register Block -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- END Login Container -->\r\n");
      out.write("\r\n");
      out.write("        <!-- Modal Terms -->\r\n");
      out.write("        <div id=\"modal-terms\" class=\"modal fade\" tabindex=\"-1\" role=\"dialog\" aria-hidden=\"true\">\r\n");
      out.write("            <div class=\"modal-dialog\">\r\n");
      out.write("                <div class=\"modal-content\">\r\n");
      out.write("                    <div class=\"modal-header\">\r\n");
      out.write("                        <h3 class=\"modal-title text-center\"><strong>Terms and Conditions</strong></h3>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"modal-body\">\r\n");
      out.write("                        <h4 class=\"page-header\">1. <strong>General</strong></h4>\r\n");
      out.write("                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ultrices, justo vel imperdiet gravida, urna ligula hendrerit nibh, ac cursus nibh sapien in purus. Mauris tincidunt tincidunt turpis in porta. Integer fermentum tincidunt auctor.</p>\r\n");
      out.write("                        <h4 class=\"page-header\">2. <strong>Account</strong></h4>\r\n");
      out.write("                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ultrices, justo vel imperdiet gravida, urna ligula hendrerit nibh, ac cursus nibh sapien in purus. Mauris tincidunt tincidunt turpis in porta. Integer fermentum tincidunt auctor.</p>\r\n");
      out.write("                        <h4 class=\"page-header\">3. <strong>Service</strong></h4>\r\n");
      out.write("                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ultrices, justo vel imperdiet gravida, urna ligula hendrerit nibh, ac cursus nibh sapien in purus. Mauris tincidunt tincidunt turpis in porta. Integer fermentum tincidunt auctor.</p>\r\n");
      out.write("                        <h4 class=\"page-header\">4. <strong>Payments</strong></h4>\r\n");
      out.write("                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ultrices, justo vel imperdiet gravida, urna ligula hendrerit nibh, ac cursus nibh sapien in purus. Mauris tincidunt tincidunt turpis in porta. Integer fermentum tincidunt auctor.</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"modal-footer\">\r\n");
      out.write("                        <div class=\"text-center\">\r\n");
      out.write("                            <button type=\"button\" class=\"btn btn-effect-ripple btn-sm btn-primary\" data-dismiss=\"modal\">I've read them!</button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- END Modal Terms -->\r\n");
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
      out.write("        <script src=\"js/pages/readyRegister.js\"></script>\r\n");
      out.write("        <script>$(function(){ ReadyRegister.init(); });</script>\r\n");
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
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${msg != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                <div class=\"alert alert-danger alert-dismissable\">\r\n");
        out.write("                                        <h5 style=\"text-align:center\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${msg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</h5>\r\n");
        out.write("                                </div>\r\n");
        out.write("                            ");
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
}
