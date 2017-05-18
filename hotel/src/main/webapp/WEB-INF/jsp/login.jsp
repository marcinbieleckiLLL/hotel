<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="/webstore/resource/js/controllers.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Logowanie</title>
</head>
<body>
			<section>
				<div class="jumbotron">
					<div class="container">
						
						<h2 style="text-align:center"><spring:message code="login.zalozKonto" /></h2>
						<h2>${user}</h2>
					</div>
				</div>
			</section>
				<div class="container">
					<div class="row">
						<div class="col-md-6 col-md-offset-3 ">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="panel-title" style="text-align:center"><spring:message code="login.zaloguj" /></h3>
								</div>
							<div class="panel-body">
								<c:if test="${not empty error}">
									<div class="alert alert-danger">
										<spring:message code="login.failed" /><br />
									</div>
								</c:if>
								<form action="<c:url value="/j_spring_security_check"></c:url>" method="post">
									<fieldset>
										<div class="form-group">
											<input class="form-control" placeholder="Nazwa użytkownika" name='j_username' type="text">
										</div>
										<div class="form-group">
											<input class="form-control" placeholder="Hasło" name='j_password' type="password" value="">
										</div>
										<input class="btn btn-lg btn-success btn-block" type="submit" value="Zaloguj się">
									</fieldset>
								</form>
								<a href="<spring:url value="/addAccount" />" class="btn btn-link">
									<h2><spring:message code="login.NieMaszKonta" /></h2>
								</a>
							</div>
							</div>
						</div>
					</div>
		
				</div>
</body>
</html>