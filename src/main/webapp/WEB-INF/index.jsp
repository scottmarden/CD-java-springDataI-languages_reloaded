<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Group Languages Home</title>
</head>
<body>
	<h1>Group Languages Home</h1>
	
	<div id="languageTable">
		<table cellspacing="15">
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${languages}" var="language" varStatus="loop">
			<tr>
				<td><a href="language/${language.id}"><c:out value="${language.name}" /></a></td>
				<td><c:out value="${language.creator}" /></td>
				<td><c:out value="${language.version}" /></td>
				<td><a href="language/update/${language.id}">Edit</a> <a href="language/delete/${language.id}">Delete</a></td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<div id="languageForm">
		<form:form action="/language/new" modelAttribute="newLanguage" method="POST">
			<form:label path="name">Name:
			<form:errors path="name"/>
			<form:input path="name"/></form:label>
			
			<form:label path="creator">Creator:
			<form:errors path="creator"/>
			<form:input path="creator"/></form:label>
			
			<form:label path="version">Version:
			<form:errors path="version"/>
			<form:input path="version"/></form:label>
			
			<button type="submit">Sumbit</button>
		</form:form>
			
			
	
	</div>
</body>
</html>