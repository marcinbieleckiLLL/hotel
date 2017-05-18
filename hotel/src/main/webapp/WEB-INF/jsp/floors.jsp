<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
		<title>Floors</title>
	</head>
	<body>
			<section>
				<div class="jumbotron">
					<div class="container" style="text-align:center">
						<h1><spring:message code="floors.hello" /></h1>
					</div>
				
				</br>
				</br>
				</br>
				<div class="row">
				
					<c:set var="licznik" value="${0}"/>
					<c:forEach items="${floors}" var="floor">
						
							<c:if test="${licznik==8}">
								<div class="col-md-3 col-md-offset-3">
									
								</div>
							</c:if>
							
							
							<div class="col-md-3" style="padding-bottom: 25px">
								<div class="thumbnail">
									<img src="<c:url value="/resource/images/${floor.name}.jpg"></c:url>" alt="image" style= "width:100%" />
										<div class="caption" style="text-align:center">
											
											<a href="<spring:url value="/floors/${floor.name}" />" class="btn btn-link">
												<h2>${floor.name}</h2>
											</a>
												<p><spring:message code="floor.terrace" />  ${floor.ifThereIsATerrace}</p>
												<p><spring:message code="floor.bowling" />  ${floor.ifThereIsABowling}</p>
												<p><spring:message code="floor.pool" />  ${floor.ifThereIsAPool}</p>
												<p><spring:message code="floor.roastingRoom" />  ${floor.ifThereIsARoastingRoom}</p>
												
										</div>
								</div>
							</div>
							<c:set var="licznik" value="${licznik+1}"/>
					</c:forEach>
				</div>
				</div>
			</section>
	</body>
</html>