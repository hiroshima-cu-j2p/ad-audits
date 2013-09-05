<%@page import="jp.co.hiroshimaj2p.audit.dto.AuditorDTO"%>
<%@page import="java.util.List"%>
<%@page import="jp.co.hiroshimaj2p.audit.form.AssignAuditerForm"%>
<%@ page language="java" contentType="text/html; charset=windows-31j"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Creative Studio - XHTML CSS template</title>
<meta name="keywords" content="Creative Studio, XHTML CSS template, free download, web design" />
<meta name="description" content="Creative Studio is a standard compliant XHTML CSS template from templatemo.com" />
<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
body {
	color: #494234;
	font-family: Georgia, "Times New Roman", Times, serif;
	font-size: 15px;
	line-height: 1.5em;
}

.textdata {
	padding: 0;
	text-align: justify;
}

th,.lbltxt { /*border-bottom: 2px solid #494234;*/
	color: #494234;
	font-size: 15px;
	font-style: italic;
	font-weight: normal;
	margin: 0 0 15px;
	padding: 2px 0 10px;
}

th {
	font-size: 15px;
	border-bottom: 2px solid #494234;
}

#header {
	font-size: 30px;
	height: 40px;
	width: 100%;
}

#menu {
	font-size: 18px;
	height: 30px;
	width: 100%;
	text-align: right;
	background-color: #c6c6c6;
}

a {
	font-style: normal;
	text-decoration: underline;
}

a:link,a:visited {
	color: #191815;
	font-style: italic;
	font-weight: normal;
	text-decoration: none;
}

table {
	width: 60%;
	margin: 0px auto;
}
</style>
<script type="text/javascript">
function blank(a) { if(a.value == a.defaultValue) a.value = ""; }
function unblank(a) { if(a.value == "") a.value = a.defaultValue; }
</script>
</head>
<body>
<%
AssignAuditerForm form = (AssignAuditerForm)request.getAttribute("ASSIGNAUDITORFORM");


%>
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
       <form action="AssignAuditerServlet" method="post">
			<table>
				<tr class="lbltxt">
					<td width="60%">Company Name</td>
					<td><%=form.getCompanyName() %></td>
				</tr>
				<tr class="lbltxt">
					<td>Agency Name</td>
					<td><%=form.getAgencyName() %></td>
				</tr>
				<tr class="lbltxt">
					<td>Description</td>
					<td><%=form.getDescripution() %></td>
				</tr>
				<tr class="lbltxt">
					<td>Location</td>
					<td><%=form.getLocation() %></td>
				</tr>
				<tr class="lbltxt">
					<td>Audit Date</td>
					<%
					String dateValue = form.getAuditDate();
					if(null==dateValue){
						dateValue="DD/MM/YYYY";	
					}
					%>
					<td><input id="auditdate" name="auditdate" type="text" 
						onfocus="blank(this)" onblur="unblank(this)" value="<%=dateValue%>"></input>
						<input type="hidden" name="id" value="<%=form.getAdId()%>"></input></td>
				</tr>
				<tr class="lbltxt">
					<td>Auditer name</td>
					<td><select id="auditer_name" name="auditer_name" style="width: 150px;">
					<option value="0"></option>
					<%
					List<AuditorDTO> auditors = form.getAuditors();
					for(AuditorDTO dto: auditors) {
					%>
						<option value="<%=dto.getId().intValue() %>"><%=dto.getName() %></option>
					<%} %>		
					</select></td>
				</tr>
				<tr class="lbltxt">
					<td colspan="2" align="center">
					<button type="submit">ASSIGN</button></td>
					<td>&nbsp;</td>
				</tr>
				
				
				
			</table>
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
<div align=center>This template  downloaded form <a href='http://all-free-download.com/free-website-templates/'>free website templates</a></div></body>
</html>