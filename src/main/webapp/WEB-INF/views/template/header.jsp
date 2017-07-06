<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@ taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<div class="row border-bottom">
        <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
            
		<spring:url value="/user/search" var="searchResult"/>
            <form:form role="search" class="navbar-form-custom" method="post" commandName="searchWrapper" action="${searchResult}" >
                <div class="form-group">
                    <form:input type="text" placeholder="Пошук користувачів..." class="form-control" path="searchInfo" id="top-search"/>
                </div>
            </form:form>
        </div>
            <ul class="nav navbar-top-links navbar-right">
                <li>
                    <span class="m-r-sm text-muted welcome-message">Ласкаво просимо до INSTANT MESSENGER</span>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                        <i class="fa fa-envelope"></i>  <span class="label label-warning">${countNewMessages}</span>
                    </a>
                    <ul class="dropdown-menu dropdown-messages">
                    	<c:forEach items="${newMessages}" var="message">
	                        <li>
	                            <div class="dropdown-messages-box">
	                                <a href="<spring:url value="/profile/${message.from.id}"/>" class="pull-left">
		                                <c:if test="${message.from.photo != null}">
		                                	<img width="48" height="48" alt="${message.from.fullName}" class="img-circle" src="../resources/img/${message.from.photo}">
		                                </c:if>
		                                <c:if test="${message.from.photo == null}">
		                            		<img width="48" height="48" alt="${message.from.fullName}" class="img-circle" src="../resources/img/default_profile.png" />
		                            	</c:if>
	                                </a>
	                                <div class="media-body">
	                                    <small class="pull-right">
											<fmt:formatDate value="${message.date}" pattern="dd-MM-yyyy HH:mm:ss" />
										</small>
	                                    <strong>${message.from.fullName}</strong> <br>
	                                    <c:if test="${message.message.length() > 25}">
	                                    	<div>${fn:substring(message.message, 0, 25)}${'...'}</div>
	                                    </c:if>
	                                    <c:if test="${message.message.length() <= 25}">
	                                    	<div>${message.message}</div>
	                                    </c:if>
	                                </div>
	                            </div>
	                        </li>
	                        <li class="divider"></li>
                        </c:forEach>
                        <c:if test="${newMessages != null}">
	                        <li>
	                            <div class="text-center link-block">
	                                <a href="#">
	                                    <i class="fa fa-envelope"></i> <strong>Переглянути всі повідомлення</strong>
	                                </a>
	                            </div>
	                        </li>
                        </c:if>
                    </ul>
                </li>
                
                <li>
                    <a href="<spring:url value="/logout"/>">
                        <i class="fa fa-sign-out"></i> Вийти
                    </a>
                </li>
            </ul>

        </nav>
       </div>