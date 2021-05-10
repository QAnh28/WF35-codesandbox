<!-- Checkout.jsp -->

<%@ page import="java.util.Enumeration" %>

<HTML>
   <HEAD>
      <TITLE>Checkout</TITLE>
	<STYLE>
	   body{text-align=center; }
	   table,th,td{border:2px solid black;}
	   table{background-color:aqua;}	
	</STYLE>
   </HEAD>

   <BODY>
   <%
      final float APPLES_PRICE = 1.45F;
      final float PEARS_PRICE = 1.75F;
      //In a real application, the above prices would be 
      //retrieved from a database, of course.
   %>


      <BR><BR><BR>

      <H1><P STYLE="color:red">Order List</P></H1>
      <BR><BR><BR>

      <TABLE>
         <TR>
            <TH>Item</TH>
            <TH>Weight(kg)</TH>
            <TH>Cost(�)</TH>
         </TR>

   <!-- Now make use of the implicit object session -->
   <!-- to retrieve the contents of the shopping cart... -->
   <%
      session.removeAttribute("currentProd");
      //(Removes "Checkout".)

      Enumeration prodNames = session.getAttributeNames();
      float totalCost = 0;

      int numProducts = 0;
      while (prodNames.hasMoreElements())
      {
         float wt=0,cost=0;
         String product = (String)prodNames.nextElement();
         String stringWt = 
                  (String)session.getAttribute(product);
         wt = Float.parseFloat(stringWt);
         if (product.equals("Apples"))
            cost = APPLES_PRICE * wt;
         else if (product.equals("Pears"))
            cost = PEARS_PRICE * wt;
   %>
         <TR>
            <TD><%= product %></TD>
            <TD><%= wt %></TD>
            <TD><%= String.format("%.2f",cost) %></TD>
         </TR>
   <%
         totalCost+=cost;
         numProducts++;
      }
   %>
         <TR STYLE="background-color:yellow">
   <%
      if (numProducts == 0)
      {
   %>
            <TD>*** No orders placed! ***</TD>
         </TR>
   <%
      }
      else
      {
   %>
         <TR STYLE="background-color:yellow">
            <TD></TD>	<!-- Blank cell -->
            <TD>Total cost:</TD>
            <TD>
		 <%= String.format("%.2f",totalCost) %>
	    </TD>
         </TR>
   <%
      }
   %>
      </TABLE>

   </BODY>

</HTML>



