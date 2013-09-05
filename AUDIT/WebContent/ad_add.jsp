<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jp.co.hiroshimaj2p.audit.dto.CorporateDTO"%>
<%@page import="jp.co.hiroshimaj2p.audit.dto.AgencyDTO"%>
<%@page import="jp.co.hiroshimaj2p.audit.dto.LocationDTO"%>
<%@page import="java.util.List"%>
<%@page import="jp.co.hiroshimaj2p.audit.form.ADAddForm"%>
<%@ page language="java" contentType="text/html; charset=windows-31j"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Creative Studio - XHTML CSS template</title>
<meta name="keywords"
	content="Creative Studio, XHTML CSS template, free download, web design" />
<meta name="description"
	content="Creative Studio is a standard compliant XHTML CSS template from templatemo.com" />
<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%
ADAddForm form=(ADAddForm)request.getAttribute("ADADDFORM");
%>
	<div id="templatemo_container">
		<div id="templatemo_site_title_bar">
			<div id="site_title">
				<h1>
					<a href="http://www.templatemo.com" target="_parent">Advertisement
						Auditor</a> <span>The website and its management will help
						corporates to Audit all the advertisement locations sitting at
						their office.</span>
				</h1>
			</div>
		</div>
		<!-- templatemo_site_title_bar -->
		<!-- Start of menu -->
		<div id="templatemo_menu">
			<ul>
				<li><a href="#" class="current fast">Home</a>
				</li>
				<li><a href="#">About</a>
				</li>
				<li><a href="#">Blog</a>
				</li>
				<li><a href="http://www.templatemo.com" target="_parent">Gallery</a>
				</li>
				<li><a href="#">Contact</a>
				</li>
				<li><a href="#">&nbsp;</a>
				</li>
				<li><a href="#">&nbsp;</a>
				</li>
				<li><a href="#">&nbsp;</a>
				</li>
				<li><a href="#">&nbsp;</a>
				</li>
				<li><a href="#">&nbsp;</a>
				</li>
				<li><a href="#">&nbsp;</a>
				</li>
				<li><a href="#">&nbsp;</a>
				</li>
				<li><a href="#">&nbsp;</a>
				</li>
				
				<%SimpleDateFormat toDate=new SimpleDateFormat("dd-MMM-yyyy");
				String displayDate=toDate.format(new Date(System.currentTimeMillis()));%>
				<li><%=displayDate %></li>
			</ul>
		</div>
		<!-- end of menu -->
		<!-- Start of templatemo_content -->
		<div id="templatemo_content">
			<div class="content_sec">



				<!-- ADD CODE START -->
				
				<form action="ADAddF" method="post">
					<table>
						<tr class="lbltxt">
							<td colspan="2" align="center" height=50%>
								<h1>New Advertisement</h1><br><br>
							</td>
							<td>&nbsp;</td>
						</tr>
						
						<tr class="lbltxt">
							<td>Corporate:</td>
							<td><select id="corporate" name="corporate"
								style="width: 150px;">
									<option value="0"></option>
									<%
									List<CorporateDTO> lstCorp = form.getListOfCorporates(); 
									for(CorporateDTO dto : lstCorp) {
									%>
										<option value="<%=dto.getId() %>"><%=dto.getName() %></option>
									<% 
										}
									%>
									
							</select>
							</td>
						</tr>

						<tr class="lbltxt">
							<td>Agency:</td>
							<td><select id="agency" name="agency" style="width: 150px;">
									<option value="0"></option>
									<%  
									List<AgencyDTO> lstAgen = form.getListOfAgencies(); 
									for(AgencyDTO dto : lstAgen) {
									%>
										<option value="<%=dto.getId() %>"><%=dto.getName() %></option>
									<% 
										}
									%>
									
							</select>
							</td>
						</tr>

						<tr class="lbltxt">
							<td>Product:</td>
							<td><input type="text" name="product_name" size="30"></input>
							</td>
						</tr>

						<tr class="lbltxt">
							<td>Description:</td>
							<td><textarea name=product_description cols="50" rows="10"></textarea>
							</td>
						</tr>

						<tr class="lbltxt">
							<td>Location:</td>
							<td><select id="location" name="location"
								style="width: 150px;"">
									<option value="0"></option>
									<%
									List<LocationDTO> lstLocat = form.getListOfLocations(); 
									for(LocationDTO dto : lstLocat) {
									%>
										<option value="<%=dto.getId() %>"><%=dto.getName() %></option>
									<% 
										}
									%>
								
							</select>
							</td>
						</tr>

						<tr class="lbltxt">
							<td colspan="2" align="center" height=50%>
							<br><br>
								<input type="submit" name="AD_submit" value="SAVE"></input> 
								<input type="button" value="CANCEL" onclick="history.go(-1);"></input>
							</td>
							<td>&nbsp;</td>
						</tr>
					</table>
				
				</form>
				<!-- ADD CODE END -->

				<div class="cleaner_h40"></div>
				<div class="cleaner"></div>
			</div>
		</div>
		<!-- end of templatemo_content -->

		<div id="content_bottom"></div>
		<div id="templatemo_footer">
			<ul class="footer_menu">
				<li><a href="#">Home</a>
				</li>
				<li><a href="#">About</a>
				</li>
				<li><a href="#">Gallery</a>
				</li>
				<li><a href="#">Blog</a>
				</li>
				<li class="last_menu"><a href="#">Contact</a>
				</li>
			</ul>

			Copyright © 2048 <a href="#" target="_parent">Your Company Name</a> |
			<a href="http://www.iwebsitetemplate.com" target="_parent">Website
				Templates</a> by <a href="http://www.templatemo.com/page/1"
				target="_parent">Free CSS Templates</a>
		</div>
		<!-- end of footer -->
		<div class="cleaner"></div>
	</div>
	<!-- end of container -->
	<div align=center>
		This template downloaded form <a
			href='http://all-free-download.com/free-website-templates/'>free
			website templates</a>
	</div>
</body>
</html>