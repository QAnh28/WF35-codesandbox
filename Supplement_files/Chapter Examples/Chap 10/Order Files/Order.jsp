<HTML>
	<%@ page language="java" contentType="text/html" %>
	<jsp:useBean id="purchase" class="shopping.OrderBean">
		<jsp:setProperty name="purchase" property="*" />
	</jsp:useBean>

	<HEAD> 
		<TITLE>Order Bean Test</TITLE>
	  	<STYLE>
			body {text-align:center;}
	  	</STYLE>
	</HEAD>

	<BODY>
		<H1>Results</H1>
		<BR>
		<TABLE style="background-color:aqua">
			<TR>
				<TH style="background-color:orange">Field Name</TH>
				<TH style="background-color:orange">Value</TH>
			</TR>
			<TR>
				<TD>name</TD>
				<TD><jsp:getProperty name="purchase" property="name" /></TD>
			</TR>
			<TR>
				<TD>addressLine1</TD>
				<TD><jsp:getProperty name="purchase" property="addressLine1" /></TD>
			</TR>
			<TR>
				<TD>addressLine2</TD>
				<TD><jsp:getProperty name="purchase" property="addressLine2" /></TD>
			</TR>
			<TR>
				<TD>addressLine3</TD>
				<TD><jsp:getProperty name="purchase" property="addressLine3" /></TD>
			</TR>
			<TR>
				<TD>postCode</TD>
				<TD><jsp:getProperty name="purchase" property="postCode" /></TD>
			</TR>
			<TR>
				<TD>orderItem</TD>
				<TD><jsp:getProperty name="purchase" property="orderItem" /></TD>
			</TR>
			<TR>
				<TD>quantity</TD>
				<TD><jsp:getProperty name="purchase" property="quantity" /></TD>
			</TR>
		</TABLE>
		<BR><BR>
		<FORM METHOD=GET ACTION="Acceptance.html">
			<INPUT TYPE="submit" VALUE="Confirm">
		</FORM>
	</BODY>

</HTML>




