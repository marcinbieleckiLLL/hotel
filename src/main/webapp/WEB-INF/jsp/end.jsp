<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	</head>
	<title>Koniec</title>
	<body>
		<section>
			<div class="jumbotron">
				<div class="container">	
					<div class="row" style="text-align:center">
						<h1 style="text-shadow:0 0 6px #FFFFCC"><font face="Verdana"><spring:message code="end" /></font></h1>
						<h2 style="text-shadow:0 0 6px #FFFFCC"><font face="Verdana"><spring:message code="end.finaly" /></font></h2>
						<h3><a href="<c:url value="/logout" />"><spring:message code="end.logout" /></a></h3>
						
					</div>
				</div>
			</div>
	</body>
</html>