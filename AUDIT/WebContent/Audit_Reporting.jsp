<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="jp.co.hiroshimaj2p.audit.form.AuditorReportingForm"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@page language="java" import="jp.co.hiroshimaj2p.audit.dto.AuditReportingDTO" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Creative Studio - XHTML CSS template</title>
<meta name="keywords" content="Creative Studio, XHTML CSS template, free download, web design" />
<meta name="description" content="Creative Studio is a standard compliant XHTML CSS template from templatemo.com" />
<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<form action="/audit/AuditorReportingServlet" method="post">
<input type="hidden" id="auditPlainId" name="auditPlainId" value="<%=((AuditReportingDTO)request.getAttribute("displayAdList")).getAuditPlaneId()%>" />
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
		<table border="0">
			<tr>
				<td>Company</td>
				<td>:</td>
				<td><%=((AuditReportingDTO)request.getAttribute("displayAdList")).getCompany()%></td>
			</tr>
			<tr>
				<td>Product</td>
				<td>:</td>
				<td><%=((AuditReportingDTO)request.getAttribute("displayAdList")).getProduct()%></td>
			</tr>
			<tr>
				<td>Agency</td>
				<td>:</td>
				<td><%=((AuditReportingDTO)request.getAttribute("displayAdList")).getAgency()%></td>
			</tr>
			<tr>
				<td>Location</td>
				<td>:</td>
				<td><%=((AuditReportingDTO)request.getAttribute("displayAdList")).getLocation()%></td>
			</tr>
			<tr>
				<td>Detail</td>
				<td>:</td>
				<td><%=((AuditReportingDTO)request.getAttribute("displayAdList")).getDiscription()%></td>
			</tr>
			<tr>
				<td>Status</td>
				<td>:</td>
				<td>
					<select name="status" id="status" >
						<option value="0">--Select--</option>
						<option value="1">Checked</option>
						<option value="2">Unchecked</option>
	  				</select>
	  			</td>
			</tr>
			<tr>
				<td>Comment</td>
				<td>:</td>
				<td><textarea name="comment" id="comment" rows="4" cols="40"></textarea></td>
				</tr>
			<tr>
				<td align="center" colspan="3"><input type="submit" value="SUBMIT"></td>
			</tr>
			</table>
        	
        	<!-- ADD CODE END -->
        </div>
		         
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
<div align=center>This template  downloaded form <a href='http://all-free-download.com/free-website-templates/'>free website templates</a></div>
</form>
</body>
</html>