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
<title>addAccount</title>
</head>
<body>
			<section>
				<div class="jumbotron">
					<div class="col-md-6 col-md-offset-5 ">
						<span class="label label-danger" class="btn btn-primary btn-lg"><spring:message code="addAccount.witaj" />	</span>
					</div>
				</div>
			</section>
			<section class="container">
			<div class="row">
				<div class="col-md-6 col-md-offset-3 ">
					<div class="panel panel-info">
						<div class="panel-heading">
									<h3 class="panel-title" style="text-align:center"><spring:message code="addAccount.formularzTitle" /></h3>
						</div>
						<div class="panel-body">
							<form:form modelAttribute="nowyUser" enctype="multipart/form-data">
							<form:errors path="*" cssClass = "alert alert-danger" element="div"/>
								<fieldset>
									
									<div-class="form-group" style="text-align:center">
										
											
											<label class="control-label col-sm-4  col-sm-offset-1 primary-label" for="pwd">
												
													<spring:message code="addAccount.nazwaUzytkownika" />
											</label>
											
											<div class="col-sm-3">
													<form:input id="username" path="username" type="text" class="form:input-large" />
													<form:errors path="username" cssClass = "text-danger"/>
											</div>
								
									
									
									<div-class="form-group" style="text-align:center">
										
											
											
											<label class="control-label col-sm-2  col-sm-offset-3 for="pwd">
												
													<spring:message code="addAccount.haslo" />
											</label>
											<div class="col-sm-3">
											
													<form:input id="password" path="password" type="password" class="form:input-large" />
													<form:errors path="password" cssClass = "text-danger"/>
										
											</div>
									</div>
									<div-class="form-group">
											<div class="col-md-9 col-md-offset-5">
												<input type="submit" id="btnAdd" class="btn btn-primary" value="Załóż konto!" />
											</div>
									</div>
								
								</fieldset>
							</form:form>
						</div>
					</div>
				</div>
			</div>
			</section>
</body>
</html>