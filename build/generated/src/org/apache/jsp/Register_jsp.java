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

public final class Register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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

    /*List<User> list1 = User.showPatientList();
    request.setAttribute("list1", list1);
    List<DiabetesLog> list2 = DiabetesLog.showValueList();
    request.setAttribute("list2", list2);
    List<NutritionDB> list3 = NutritionDB.showNutrition();
    request.setAttribute("list3", list3);
    List<MedicineDB> list4 = MedicineDB.showMedicine();
    request.setAttribute("list4", list4);
    List<Content> list5 = Content.showContent();
    request.setAttribute("list5", list5);*/

      out.write("\n");
      out.write("<html  xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("        <title>Register Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <br/>\n");
      out.write("        <div align=\"center\"><font size=\"48\">BAOWHAN</font></div>\n");
      out.write("        <form action=\"Register\" method=\"Get\" name=\"Reg1\" >\n");
      out.write("                            <div align=\"center\">\n");
      out.write("                                <table width=\"500px\" border=\"1\" align=\"center\">\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td align=\"right\">Username : </td>\n");
      out.write("                                        <td><input type=\"username\" name=\"username\" size=\"20\" required=\"\"/></td>\n");
      out.write("                                    </tr>\t\n");
      out.write("\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td align=\"right\">Password :</td>\n");
      out.write("                                        <td><input type=\"password\" name=\"pwd1\" required=\"\"/> </td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td align=\"right\">Re-Enter Password :</td>\n");
      out.write("                                        <td><input type=\"password\" name=\"pwd2\" required=\"\"/> </td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td align=\"right\">Email :</td> \n");
      out.write("                                        <td><input type=\"email\" name=\"email\" required=\"\"/></td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td align=\"right\">Firstname :</td>\n");
      out.write("                                        <td><input type=\"firstname\" name=\"firstname\" required=\"\"/></td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td align=\"right\">Lastname: </td>\n");
      out.write("                                        <td><input type=\"lastname\" name=\"lastname\" required=\"\"/></td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    \n");
      out.write("                                    <tr>\n");
      out.write("                                        <td align=\"right\">Telephone : </td>\n");
      out.write("                                        <td><input type=\"telephone\" name=\"telephone\" required=\"\"/></td>\n");
      out.write("                                    </tr>                                 \n");
      out.write("                                    <tr>\n");
      out.write("                                        <td align=\"right\" valign=\"top\">Address :</td>\n");
      out.write("                                        <td> <textarea rows=\"5\" cols=\"50\" name=\"address\" required=\"\"></textarea></td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td align=\"right\">Province : </td>\n");
      out.write("                                        <td><input type=\"province\" name=\"province\"/></td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    \n");
      out.write("                                    <tr>\n");
      out.write("                                        <td align=\"right\">Zipcode :</td> \n");
      out.write("                                        <td><input type=\"zipcode\" name=\"zipcode\" required=\"\"/></td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td align=\"right\">RelatedUserID :</td> \n");
      out.write("                                        <td><input type=\"relatedUserID\" name=\"relatedUserID\" required=\"\"/></td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td align=\"right\">HospitalID :</td> \n");
      out.write("                                        <td><input type=\"hospitalID\" name=\"hospitalID\" required=\"\"/></td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td align=\"right\">ยาที่ใช้ปัจจุบัน :</td> \n");
      out.write("                                        <td><input type=\"hospitalID\" name=\"currentmed\" required=\"\"/></td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td align=\"right\">ยาตัวก่อนที่เคยใช้ :</td> \n");
      out.write("                                        <td><input type=\"hospitalID\" name=\"pastmed\" required=\"\"/></td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr align=\"center\">\n");
      out.write("                                        <td colspan='2' align=\"center\">\n");
      out.write("                                            <input type=\"submit\" value=\"Sign Up\" />\n");
      out.write("                                            <input type=\"reset\" value=\"Reset\" />\n");
      out.write("                                        </td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    ");
      out.write("\n");
      out.write("                                    \n");
      out.write("                                    \n");
      out.write("                        \n");
      out.write("                                </table>\n");
      out.write("                            </div>\n");
      out.write("                        </form> \n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
}
