<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.js"></script>
		<title>Startowa Strona</title>
	</head>
	
	<body>
			<section>
				<div class="jumbotron">
					<div class="container" style="text-align:center">
						<h1><spring:message code="room.hello" /></h1>
					</div>
				</div>
			</section>
			<section class="container" ng-app="roomsApp">
				<div class="row">
					
					<c:forEach items="${rooms}" var="room">
					
					
						<div class="col-md-3" style="padding-bottom: 25px" ng-controller="roomsController">
							
							<div class="thumbnail">
								<img src="<c:url value="/resource/images/${room.name}.jpg"></c:url>" alt="image" style= "width:100%; height: 200px" />
									<div class="caption" style="text-align:center">
										
										<a href="<spring:url value="/${room.name}" />" class="btn btn-link">
											<h2>${room.name}</h2>
										</a>
											<p><spring:message code="room.size" /> ${room.size}</p>
											
											<c:if test="${room.availability == 'wolne'}">
												<p><spring:message code="room.availabilityPrawda" /></p>
											</c:if>
											
											<c:if test="${room.availability == 'chwilowoZajete' || room.availability == 'zajete'}">
												<p><spring:message code="room.availabilityFalsz" /></p>
												<p><spring:message code="room.daysToBeEmpty" /> ${room.daysToBeEmpty}</p>
											</c:if>	
											
											<p><spring:message code="room.priceForOneDay" /> ${room.priceForOneDay} PLN</p>
											<p><spring:message code="room.directionOfWindow" /> ${room.directionOfWindow}</p>
											
											
												<form>
												    <div class="form-group">
												      	<label for="sel1"><spring:message code="room.timeOfArrival" /></label>
												      		<select class="form-control" id="sel1" ng-click="show = true">
														        <option>0</option>
														        <option>1</option>
														        <option>2</option>
														        <option>3</option>
														        <option>4</option>
														        <option>5</option>
														        <option>6</option>
														        <option>7</option>
												      		</select>
												    </div>
												</form>
												
												<form>
												    <div class="form-group" ng-show="show">
												      	<label for="sel1"><spring:message code="room.breakfast" /></label>
												      	
						
												      		<select class="form-control" id="sel2"  ng-click="init('${room.name}')">
														        <option>0</option>
														        <option>1</option>
														        <option>2</option>
														        <option>3</option>
														        <option>4</option>
														        <option>5</option>
														        <option>6</option>
														        <option>7</option>
														        <option>8</option>
														        <option>9</option>
												      		</select>
												      	</div>
												    
												</form>
												
												<div ng-controller="textController">
													<c:if test="${room.availability == 'wolne'}">	
														<a href="<spring:url value="/basket/${room.name}"/>" class="btn btn-success btn-block" ng-show="show2" ng-click="timeOfArrival(text,roomName)" >
														
															<spring:message code="room.reserve" />
														</a>
													</c:if>
												</div>
												<c:if test="${room.availability == 'chwilowoZajete'}">
													<a href="<spring:url value="/basket/${room.name}"/>" class="btn btn-warning disabled btn-block" ng-show="zeros()">
														<spring:message code="room.temporaryBusy" />
													</a>
												</c:if>
												<c:if test="${room.availability == 'zajete'}">
													<a href="<spring:url value="/basket/${room.name}"/>" class="btn btn-danger disabled btn-block" ng-show="zeros()">
														<spring:message code="room.busy" />
													</a>
												</c:if>		
												
												
												
									</div>
							</div>
							
						</div>
						
						
						
					</c:forEach>
					
				</div>
			</section>
			
			<script>
				var app = angular.module('roomsApp', []);
				app.controller('roomsController', function ($scope, $http){
						
					$scope.zeros = function(){
						sleep(2000);
						location.reload();
					}
					
					$scope.init = function(roomName){
						$scope.roomName = roomName;
						$scope.show2 = true;
					}
					
					$scope.timeOfArrival = function(text1,roomName1){
						
						var data = {
									text: text1,
									roomName: roomName1
									};
						
						var successCallBack = function(response){
							 $scope.a = reposnse.data;
						    };
				
				    	var errorCallBack = function(response){
				    		$scope.a = response.data;
				    		
						    };
						    
						
						$http.post('http://localhost:8080/hotel/room/rest',JSON.stringify(data)).then(successCallBack, errorCallBack);
					}
					
				});
				</script>
				<script>
				app.controller('textController', function ($scope){
					
					$(document).ready(function () {
					     $('.form-control').change(function () {
					        $scope.text =  $('.form-control option:selected').text();
					     });
					 });
					
				});
						 
					 
			</script>	
	</body>
</html>