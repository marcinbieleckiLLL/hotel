<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
		<title>Strona startowa:</title>
	</head>
	<body>
			<section>
				<div class="jumbotron">
					<div class="container" style="text-align:center">
						<h1><spring:message code="index.hello" /></h1>
					</div>
				</div>
			</section>
			
			<section class="container">
			
				<div class="row">
					
						<div class="col-md-6" style="padding-bottom: 15px">
							<div class="thumbnail">
								<img src="<c:url value="/resource/images/hotel.jpg"></c:url>" alt="image" style= "width:100%" />
							</div>
						</div>
						
						<div class="col-md-5" style="padding-bottom: 25px">
							<div class="caption" style="text-align:justify">
								<h4><font face="Verdana"><blockquote><spring:message code="index.description" /></blockquote></font></h4>		
							</div>
						</div>
						
				</div>
				
				</br>
				</br>
				</br>
				</br>
				
				<div class="row">
					<div class="col-md-9 col-md-offset-1">
							<div class="thumbnail" style="width:100%" style="text-align:center">
								
									<div class="embed-responsive embed-responsive-16by9">
											<video width="835" heihgt="800" controls>
											  	<source src="<c:url value="/resource/movies/hotel.mp4"></c:url>" type="video/mp4">
												<source src="<c:url value="/resource/movies/hotel.ogg"></c:url>" type="video/ogg">
											</video>
									</div>
									
									<div class="caption" style="text-align:center">		
										<spring:message code="index.watchUs" />
										</br>
										</br>
										<a href="<spring:url value="/floors"/>" class="btn btn-success btn-block">
											<spring:message code="index.reserve" />
										</a>
									</div>
							</div>
							
						</div>
				</div>
			
			</section>
	</body>
</html>