import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Selection")
public class Selection extends HttpServlet
{
   private final float APPLES_PRICE = 1.45F;
   private final float PEARS_PRICE = 1.75F;
   //In a real application, above prices would
   //be retrieved from a database, of course.

   public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
                     throws IOException,ServletException
   {
      String currentProduct =
                        request.getParameter("Product");
      HttpSession cart = request.getSession();
      cart.putValue("currentProd",currentProduct);
      //Places user's selected product into the session
      //variable called 'cart'.
      //This product name will then be available to any
      //servlet that accesses this session variable.

      if (currentProduct.equals("Checkout"))
         response.sendRedirect("Checkout");
      else
         sendPage(response,currentProduct);
         //Creates page for selection of weight.
   }

   private void sendPage(HttpServletResponse reply,
                      String product) throws IOException
   {
      reply.setContentType("text/HTML");
      PrintWriter out = reply.getWriter();

      out.println("<HTML>");
      out.println("<HEAD>");
      out.println("<TITLE>" + product + "</TITLE>");
      out.println("</HEAD>");

      out.println("<BODY>");

      out.println("<CENTER>");
      out.println("<H1><FONT COLOR=Red>"
                     + product + "</FONT></H1>");
      out.println("<BR><BR><BR>");

      out.println("<FORM METHOD=POST ACTION='Weight'");

      out.println("<TABLE>");
      out.println("<TR>");
      out.println("   <TD>Quantity required (kg)");
      out.println("   <INPUT TYPE='Text' NAME='Qty'"
                          + " VALUE='' SIZE=5></TD>");
      out.println("</TR>");
      out.println("</TABLE>");

      out.println("<BR><BR><BR>");

      out.println("<TABLE>");

      out.println("<TR>");
      out.println("   <TD><INPUT TYPE='Radio'"
            + " NAME='Option' VALUE='Add' CHECKED>");
      out.println("   <FONT COLOR=blue>   "
                       + "Add to cart.</FONT></TD>");
      out.println("</TR>");

      out.println("<TR>");
      out.println("   <TD><INPUT TYPE='Radio'"
                   + " NAME='Option' VALUE='Remove'>");
      out.println("   <FONT COLOR=blue> " +
                 "Remove item from cart.</FONT></TD>");
      out.println("</TR>");

      out.println("<TR>");
      out.println("   <TD><INPUT TYPE='Radio'"
                     + " NAME='Option' VALUE='Next'>");
      out.println("   <FONT COLOR=blue> "
			      + "Choose next item.</FONT></TD>");
      out.println("</TR>");

      out.println("<TR>");
      out.println("   <TD><INPUT TYPE='Radio'"
                  + " NAME='Option' VALUE='Checkout'>");
      out.println("   <FONT COLOR=blue>   "
                      + "Go to checkout.</FONT></TD>");
      out.println("</TR>");

      out.println("</TABLE>");

      out.println("<BR><BR><BR>");
      out.println("<INPUT TYPE='Submit'
                                   VALUE='Submit'>");
      out.println("</FORM>");
      out.println("</CENTER>");

      out.println("</BODY>");
      out.println("</HTML>");
      out.flush();
   }
}
