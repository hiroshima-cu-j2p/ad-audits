<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@page language="java" import="jp.co.hiroshimaj2p.audit.dto.CorporateAgencyDTO,java.util.List" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Creative Studio - XHTML CSS template</title>
<meta name="keywords" content="Creative Studio, XHTML CSS template, free download, web design" />
<meta name="description" content="Creative Studio is a standard compliant XHTML CSS template from templatemo.com" />
<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="templatemo_container">
	<div id="templatemo_site_title_bar">	
        <div id="site_title">
            <h1>
                <a href="http://www.templatemo.com" target="_parent">Advertisement Auditor</a>
                <span>The website and its management will help corporates to Audit all the advertisement locations sitting at their office.</span>
            </h1>
        </div>
    </div> <!-- templatemo_site_title_bar -->
    <!-- Start of menu -->
     <div id="templatemo_menu">
    	<ul>
            <li><a href="#" class="current fast">Home</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">Blog</a></li>
        	<li><a href="http://www.templatemo.com" target="_parent">Gallery</a></li>
            <li><a href="#">Contact</a></li>
        </ul>
    </div> 
	<!-- end of menu -->
   	<!-- Start of templatemo_content -->
    <div id="templatemo_content"> 
        <div class="content_sec">
        
		
		
			<!-- ADD CODE START --> 
		    <div id="header">Corporate & Agency Screen</div>
			<div id="menu">&nbsp;</div>
		
			<div id="content">
			<form action="CorporateAgencyServlet" method="get">
				<table class="search">
					<tr>
						<th colspan="4">Search</th>
					</tr>
					<tr>
							<td>Product name:</td>
							<td><input type="text" id="product_name" name="product_name"></input></td>
							<td>Location:</td>
							<td>
								<select name="location">
									<option value="0"></option>
									<option value="1">Shinjyukyu Station</option>
									<option value="2">Tokyo Station</option>
								</select>
							</td>
					</tr>
					<tr>
						<td>Corporate:</td>
						<td>
							<select name="corporate">
								<option value="0"></option>
								<option value="1">Sony</option>
								<option value="2">Panasonic</option>
							</select>
						</td>
						<td>Agency:</td>
						<td>
							<select name="agency">
								<option value="0"></option>
								<option value="1">Dentsuu</option>
								<option value="2">Hakuoudou</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>Status:</td>
						<td>
							<select name="status">
								<option value=""></option>
								<option value="1">Resistered</option>
								<option value="2">Assigned</option>
							</select>
						</td>
						<td align="right">
							<input type="submit" value="Search"></input>
						</td>
						
					</tr>
				</table>
			</form>
		
				<table class="list">
					<tr class="headRow">
						<th>Location</th>
						<th>Company</th>
						<th>Agency</th>
						<th>Product</th>
					</tr>
					<%
						List<CorporateAgencyDTO> dtoList = (List<CorporateAgencyDTO>) request.getAttribute("adlist");
						for (int i = 0; i < dtoList.size(); i++) {
							CorporateAgencyDTO dto = dtoList.get(i);
							if (((i + 1) % 2) == 1) {
								out.println("<tr class=\"lbltxt odd\">");
							} else {
								out.println("<tr class=\"lbltxt even\">");
							}
							out.println("<td>" + dto.getLocation() + "</td>");
							out.println("<td>" + dto.getCompany() + "</td>");
							out.println("<td>" + dto.getAgency() + "</td>");
							out.println("<td>" + dto.getProduct() + "</td>");
							out.println("</tr>");
							if (((i + 1) % 2) == 1) {
								out.println("<tr class=\"odd\">");
							} else {
								out.println("<tr class=\"even\">");
							}
							out.println("<td colspan=\"4\">*" + dto.getDiscription()
									+ "</td></tr>");
						}
					%>
				</table>
		
			</div>
			<div id="menu" style="text-align: right;padding-right: 80px;">
			<form action="ADAddF" method="get">
				<input type="submit" value="Add an Advertisement"></input></a>
			</form>
			</div>
       
		<!-- ADD CODE END -->         
        <div class="cleaner_h40"></div>
   		<div class="cleaner"></div>
  </div> 
  <!-- end of templatemo_content -->
  
<div id="content_bottom"></div>
    <div id="templatemo_footer">
  		<ul class="footer_menu">
            <li><a href="#">Home</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">Gallery</a></li>
            <li><a href="#">Blog</a></li>
            <li class="last_menu"><a href="#">Contact</a></li>
        </ul>
        
        Copyright © 2048 <a href="#" target="_parent">Your Company Name</a> | 
        <a href="http://www.iwebsitetemplate.com" target="_parent">Website Templates</a> by 
        <a href="http://www.templatemo.com/page/1" target="_parent">Free CSS Templates</a>
	</div> <!-- end of footer -->
	<div class="cleaner"></div>
</div> <!-- end of container -->
<div align=center>This template downloaded form <a href='http://all-free-download.com/free-website-templates/'>free website templates</a></div></body>
</html>