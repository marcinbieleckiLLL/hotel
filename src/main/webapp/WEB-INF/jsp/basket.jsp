<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="KoszykApp">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
		<title>Koszyk</title>
	</head>
	<body ng-controller="KoszykCtrl">
		<section>
					<div class="jumbotron">
						<div class="container" style="text-align:center">
							<h1><spring:message code="basket.basket" /></h1>
							<h3><spring:message code="basket.listOfRooms" /></h3>
							
						</div>
					</div>
		</section>
		<section class="container">
		<c:set var = "licznik" scope = "session" value = "${0}"/>
				<div>
					<div>
						<a class="btn btn-danger pull-left" ng-click="clearKoszyk()">
							<span class="glyphicon glyphicon-remove-sign">
							</span>
							<spring:message code="basket.clear" />
						</a>
						<a href="/hotel/end" class="btn btn-success pull-right">
							<span class="glyphicon-shopping-cart glyphicon">
							</span>
							<spring:message code="basket.buy" />
						</a>
					</div>
					<table class="table table-hover">
						<tr>
							<th><spring:message code="basket.roomName" /></th>
							<th><spring:message code="basket.floorName" /></th>
							<th><spring:message code="basket.roomSize" /></th>
							<th><spring:message code="basket.directionOfWindow" /></th>
							<th><spring:message code="basket.price" /></th>
							<th><spring:message code="basket.quantityOfDays" /></th>
							<th><spring:message code="basket.quantityOfBreakfasts" /></th>
							<th><spring:message code="basket.price" /></th>
						</tr>
										
						<c:forEach items="${basket.basketItems}" var="item"> 
							<tr>
								<td>${item.room.name}</td>
								<td>${item.room.floor.name}</td>
								<td>${item.room.size}</td>
								<td>${item.room.directionOfWindow}</td>
								<td>${item.room.priceForOneDay}</td>
								<td>${data[licznik].quantityOfDays}</td>
								<td>${data[licznik].quantityOfBreakfast}</td>
								<td>${data[licznik].priceConnecetdWithOneData}</td>
							</tr>
							<c:set var = "licznik" scope = "session" value = "${licznik + 1}"/>
						</c:forEach>
						<tr>
							<th></th>
							<th></th>
							<th></th>
							<th></th>
							<th></th>
							<th><spring:message code="basket.wholePrice" /></th>
							<th></th>
							<th>${data[licznik - 1].priceConnecetdWithWholeBasket}</th>
							
						</tr>
					</table>
					<a  href="/hotel/floors" class="btn btn-success pull-right">
							<span class="glyphicon-hand-left glyphicon">
							</span>
							<spring:message code="basket.back" />		
					</a>
					
				</div>
		</section>
		<script>
		
		
				var app = angular.module('KoszykApp', []);
				app.controller('KoszykCtrl', function ($scope, $http){
					
					$scope.clearKoszyk = function(){
						
						var successCallBack = function(response){
							location.reload();
						    };
		
				   		var errorCallBack = function(response){
				   			location.reload();
						    };
						      
						  $http.post('http://localhost:8080/hotel/basket/rest/rest').then(successCallBack, errorCallBack);
					
					}
					
					
					
				});
		
		
		</script>
	</body>
</html>