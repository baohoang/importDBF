<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<s:head />
</head>

<body>
	<h1>Import DBF</h1>

	<s:form action="resultAction" namespace="/" method="POST"
		enctype="application/octet-stream">

		<s:file name="fileUpload" label="Select a File to upload" size="40" />

		<s:submit value="submit" name="submit" />

	</s:form>
</body>
</html>