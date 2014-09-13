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

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!--[if IE 9]>         <html class=\"no-js lt-ie10\"> <![endif]-->\n");
      out.write("<!--[if gt IE 9]><!--> <html class=\"no-js\"> <!--<![endif]-->\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("\n");
      out.write("        <title>Baowhan:เบาหวาน - เข้าสู่ระบบ</title>\n");
      out.write("\n");
      out.write("        <meta name=\"description\" content=\"AppUI is a Bootstrap Admin Web App Template created by pixelcave and published on Themeforest\">\n");
      out.write("        <meta name=\"author\" content=\"pixelcave\">\n");
      out.write("        <meta name=\"robots\" content=\"noindex, nofollow\">\n");
      out.write("\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width,initial-scale=1,maximum-scale=1.0\">\n");
      out.write("\n");
      out.write("        <!-- Icons -->\n");
      out.write("        <!-- The following icons can be replaced with your own, they are used by desktop and mobile browsers -->\n");
      out.write("        <link rel=\"shortcut icon\" href=\"img/favicon.ico\">\n");
      out.write("        <link rel=\"apple-touch-icon\" href=\"img/icon57.png\" sizes=\"57x57\">\n");
      out.write("        <link rel=\"apple-touch-icon\" href=\"img/icon72.png\" sizes=\"72x72\">\n");
      out.write("        <link rel=\"apple-touch-icon\" href=\"img/icon76.png\" sizes=\"76x76\">\n");
      out.write("        <link rel=\"apple-touch-icon\" href=\"img/icon114.png\" sizes=\"114x114\">\n");
      out.write("        <link rel=\"apple-touch-icon\" href=\"img/icon120.png\" sizes=\"120x120\">\n");
      out.write("        <link rel=\"apple-touch-icon\" href=\"img/icon144.png\" sizes=\"144x144\">\n");
      out.write("        <link rel=\"apple-touch-icon\" href=\"img/icon152.png\" sizes=\"152x152\">\n");
      out.write("        <!-- END Icons -->\n");
      out.write("\n");
      out.write("        <!-- Stylesheets -->\n");
      out.write("        <!-- Bootstrap is included in its original form, unaltered -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("        <!-- Related styles of various icon packs and plugins -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/plugins.css\">\n");
      out.write("\n");
      out.write("        <!-- The main stylesheet of this template. All Bootstrap overwrites are defined in here -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/main.css\">\n");
      out.write("\n");
      out.write("        <!-- Include a specific file here from css/themes/ folder to alter the default theme of the template -->\n");
      out.write("\n");
      out.write("        <!-- The themes stylesheet of this template (for using specific theme color in individual elements - must included last) -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/themes.css\">\n");
      out.write("        <!-- END Stylesheets -->\n");
      out.write("\n");
      out.write("        <!-- Modernizr (browser feature detection library) -->\n");
      out.write("        <script src=\"js/vendor/modernizr-2.8.3.js\"></script>\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("html { \n");
      out.write("  background: url(img/pizza.jpg) no-repeat center center fixed; \n");
      out.write("  -webkit-background-size: cover;\n");
      out.write("  -moz-background-size: cover;\n");
      out.write("  -o-background-size: cover;\n");
      out.write("  background-size: cover;\n");
      out.write("}\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!-- Login Container -->\n");
      out.write("        <div id=\"login-container\">\n");
      out.write("            <!-- Login Header -->\n");
      out.write("            <h1 class=\"h2 text-light text-center push-top-bottom animation-slideDown\">\n");
      out.write("                <strong>ยินดีต้อนรับสู่ เบาหวาน</strong>.com\n");
      out.write("            </h1>\n");
      out.write("            <!-- END Login Header -->\n");
      out.write("\n");
      out.write("            <!-- Login Block -->\n");
      out.write("            <div class=\"block animation-fadeInQuickInv\">\n");
      out.write("                <!-- Login Title -->\n");
      out.write("                <div class=\"block-title\">\n");
      out.write("                    <div class=\"block-options pull-right\">\n");
      out.write("                        <a href=\"recovery.jsp\" class=\"btn btn-effect-ripple btn-primary\" data-toggle=\"tooltip\" data-placement=\"left\" title=\"ลืมรหัสผ่าน\"><i class=\"fa fa-exclamation-circle\"></i></a>\n");
      out.write("                        <a href=\"register1.jsp\" class=\"btn btn-effect-ripple btn-primary\" data-toggle=\"tooltip\" data-placement=\"left\" title=\"สร้างผู้ใช้ใหม่\"><i class=\"fa fa-plus\"></i></a>\n");
      out.write("                    </div>\n");
      out.write("                    <h2>เข้าสู่ระบบ</h2>\n");
      out.write("                </div>\n");
      out.write("                <!-- END Login Title -->\n");
      out.write("\n");
      out.write("                <!-- Login Form -->\n");
      out.write("                <form id=\"form-login\" action=\"Login\" method=\"post\" class=\"form-horizontal\">\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <div class=\"col-xs-12\">\n");
      out.write("                            ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write(" \n");
      out.write("                            <input type=\"text\" id=\"username\" name=\"username\" class=\"form-control\" placeholder=\"อีเมล์/ชื่อผู้ใช้\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <div class=\"col-xs-12\">\n");
      out.write("                            <input type=\"password\" id=\"password\" name=\"password\" class=\"form-control\" placeholder=\"รหัสผ่าน\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group form-actions\">\n");
      out.write("                        <div class=\"col-xs-8\">\n");
      out.write("                            <label class=\"csscheckbox csscheckbox-primary\">\n");
      out.write("                                <input type=\"checkbox\" id=\"login-remember-me\" name=\"login-remember-me\">\n");
      out.write("                                <span></span>\n");
      out.write("                            </label>\n");
      out.write("                            จดจำ\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-xs-4 text-right\">\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-effect-ripple btn-sm btn-primary\"><i class=\"fa fa-check\"></i> เข้าสู่ระบบ</button>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("                <!-- END Login Form -->\n");
      out.write("            </div>\n");
      out.write("            <!-- END Login Block -->\n");
      out.write("        </div>\n");
      out.write("        <!-- END Login Container -->\n");
      out.write("\n");
      out.write("        <!-- Include Jquery library from Google's CDN but if something goes wrong get Jquery from local file (Remove 'http:' if you have SSL) -->\n");
      out.write("        <script src=\"http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js\"></script>\n");
      out.write("        <script>!window.jQuery && document.write(decodeURI('%3Cscript src=\"js/vendor/jquery-2.1.1.min.js\"%3E%3C/script%3E'));</script>\n");
      out.write("\n");
      out.write("        <!-- Bootstrap.js, Jquery plugins and Custom JS code -->\n");
      out.write("        <script src=\"js/vendor/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"js/plugins.js\"></script>\n");
      out.write("        <script src=\"js/app.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Load and execute javascript code used only in this page -->\n");
      out.write("        <script src=\"js/pages/readyLogin.js\"></script>\n");
      out.write("        <script>$(function(){ ReadyLogin.init(); });</script>\n");
      out.write("    </body>\n");
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
        out.write("\n");
        out.write("                                <div class=\"alert alert-danger alert-dismissable\">\n");
        out.write("                                        <h5 style=\"text-align:center\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${msg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</h5>\n");
        out.write("                                </div>\n");
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
