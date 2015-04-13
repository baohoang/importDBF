<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>Site Map | Whirlpool - Free Website Template from
	Templates.com</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta name="description" content="Place your description here" />
<meta name="keywords" content="put, your, keyword, here" />
<meta name="author" content="Templates.com - website templates provider" />
<link href="style.css" rel="stylesheet" type="text/css" />
<!--[if lt IE 7]><script type="text/javascript" src="ie_png.js"></script><script type="text/javascript">ie_png.fix('.png, #nav li a, .button span, .button a');</script><![endif]-->
</head>

<body id="page6">
	<div class="tail-right"></div>
	<div class="tail-right-top"></div>
	<div class="tail-top">
		<div class="tail-bottom">
			<div class="tail-bg">
				<div class="top-bg">
					<div class="tail-right-bot"></div>
					<div class="bot-bg">
						<div id="main">
							<!-- header -->
							<div id="header">
								<h1>
									<a href="home.html">whirlpool</a><span>Free 1024 x 768
										Optimized Website Template from Templates.com</span>
								</h1>
								<ul class="top-links">
									<li><a href="home.html"><img alt="home"
											src="images/icon-home.gif" /></a></li>
									<li><a href="contact.html"><img alt="mail"
											src="images/icon-mail.gif" /></a></li>
									<li><a><img alt="map" src="images/icon-map.gif" /></a></li>
								</ul>
							</div>
							<!-- Form Upload File -->
							<div class="upload-file">
								<form enctype="multipart/form-data" action="UpLoadFile"
									method="post">
									<b>Choose file</b>
									<input name="file" type="file">
										<td colspan="2" align="center"></td>
										<td colspan="2" align="center"><input type="submit"
											value="Upload"></td>
								</form>
							</div>
							<!-- End Form Upload File -->
							<div class="extra-img">
								<img alt="extra-img" src="images/extra-img.png" class="png" />
							</div>
							<div class="wrapper">
								<!-- nav -->
								<div id="nav">
									<table style="width: 90%">
										<%
											ArrayList<String> columnNames1 = (ArrayList<String>) session.getValue("columnNames");
											if(columnNames1!=null){
												for(int i=0;i<columnNames1.size();i++){%>
													<tr>
														<td><%=columnNames1.get(i)%></td>
													</tr>
												<%}
											}
										%>
									</table>
								</div>
								<!-- content -->
								<div id="content">
									<div class="section">
										<!-- box begin -->
										<div class="box">
											<div class="left-top-corner png">
												<div class="right-top-corner png">
													<div class="border-top png"></div>
												</div>
											</div>
											<div class="border-left png">
												<div class="border-right png">
													<div class="inside png">
														<h2>View Data DBFile </h2>
														<!-- Table View DBF -->
														<table style="width: 100%">
															<thead>
																<tr>
															<%
																ArrayList<String> columnNames = (ArrayList<String>) session.getValue("columnNames");
																if(columnNames!=null){
																	for(int i=0;i<columnNames.size();i++){ %>
																			<th><%=columnNames.get(i)%></th>
																	<% }
																}
															%>
																</tr>
															</thead>
															<tbody>
															<%
																ArrayList<Object[]> rowData =(ArrayList<Object[]>) session.getValue("rowData");
																if(rowData!=null){
																	for(int i=0;i<rowData.size();i++){%>
																	<tr><%
 																		for(int j=0;j<rowData.get(i).length;j++){%>
 																				<td><%=rowData.get(i)[j]%></td>
 																		<%}%>
																	</tr>
																	<%}
																}
															%>	
															</tbody>
														</table>
														<!-- End Table View DBF -->
													</div>
												</div>
											</div>
											<div class="left-bot-corner png">
												<div class="right-bot-corner png">
													<div class="border-bot png"></div>
												</div>
											</div>
										</div>
										<!-- box end -->
									</div>
								</div>
							</div>
						</div>
						<!-- footer -->
						<div id="footer">
							<div class="indent">
								<div class="fleft">Copyrights - Type in Your Name Here</div>
								<div class="fright">
									Designed by: <a href="http://www.templates.com/"
										title="templates.com - website templates provider"><img
										alt="website templates" src="images/templates-logo.gif" /></a>&nbsp;
									<a href="http://www.templates.com"
										title="templates.com - website templates provider">Website
										Templates</a> Provider
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>