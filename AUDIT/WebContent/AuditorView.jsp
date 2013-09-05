<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jp.co.hiroshimaj2p.audit.dto.PlanDetailDTO"%>
<%@page import="jp.co.hiroshimaj2p.audit.dao.AuditorViewDAO,java.util.List"%>
<%@page import="jp.co.hiroshimaj2p.audit.form.AuditorViewForm,jp.co.hiroshimaj2p.audit.dto.AuditPlanViewDTO"%>
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
</head>
<body>
<%
	AuditorViewForm form = (AuditorViewForm) request
			.getAttribute("AUDITORVIEWFORM");
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
  	     <div id="header">Corporate & Agency Screen</div>
			<div id="menu">&nbsp;</div>
		
			<div id="content">
			<form action="AuditorView" method="get">
		<table>
			<tr class="headRow">
				<th>Location</th>
				<th>Company</th>
				<th>Agency</th>
				<th>Product</th>
				<th>&nbsp;</th>
			</tr>
			
			<%
				List<AuditPlanViewDTO> dtoList = form.getViewList();
				String rowClass = "even";
				for (AuditPlanViewDTO dto : dtoList) {
					if("odd".equals(rowClass)) {
						rowClass = "even";
					} else {
						rowClass = "odd";
					}
			%>
			<tr class='<%=rowClass %>'>
				<td><%=dto.getLocation() %></td>
				<td><%=dto.getCompanyName() %></td>
				<td><%=dto.getAgencyName() %></td>
				<td><%=dto.getProductName() %></td>
				<td rowspan="2" style="text-decoration:underline;color: #484741; font-size: medium;font-weight: bold;">&nbsp;<a href="AuditorReportingServlet?planid=<%=dto.getPlanId()%>">Edit</a>&nbsp;</td>					
			</tr>
			<tr class='<%=rowClass %>' style="font-style: italic;">
				<td colspan="4" style="padding-right: 10px;"><%=dto.getDescription() %>
				<span style="color: #2E64FE">
				<%
					SimpleDateFormat timeFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
					List<PlanDetailDTO> planDetails = dto.getPlanDetails();
					for(PlanDetailDTO detDto : planDetails) {
				%>
				
				<br/><%="(" + timeFormat.format(detDto.getCommentTime()) + " : " + detDto.getStatus()+ ") &nbsp;" +  detDto.getComment() %>
				
				<%} %>
				</span>
				</td>
			</tr>
			<%
				}
			%>
		</table>
		</form>
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
<div align=center>This template  downloaded form <a href='http://all-free-download.com/free-website-templates/'>free website templates</a></div></body>
</html>