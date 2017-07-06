<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@ taglib  uri="http://www.springframework.org/tags" prefix="spring" %>

    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                    	<a href="<spring:url value="/profile/${user.id}"/>"> 
                    		<span>
                    			<c:if test="${user.photo != null}">
                                	<img width="48" height="48" alt="${user.fullName}" class="img-circle" src="../resources/img/${user.photo}">
                                </c:if>
                                <c:if test="${user.photo == null}">
                            		<img width="48" height="48" alt="${user.fullName}" class="img-circle" src="../resources/img/default_profile.png" />
                            	</c:if>
                            </span> 
                        </a>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="<spring:url value="/profile/${user.id}"/>">
                            <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">${user.fullName}</strong>
                            	<b class="caret"></b> </span> </span> </a>
                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
                            <li><a href="#">Редагувати особисті дані</a></li>
                            <li><a href="<spring:url value="/profile/${user.id}"/>">Мій Профіль</a></li>
                            <li><a href="<spring:url value="/friends/${user.id}"/>">Мої Друзі</a></li>
                            <li class="divider"></li>
                            <li><a href="<spring:url value="/logout"/>">Вийти</a></li>
                        </ul>
                    </div>
                </li>
                <li>
                    <a href="<spring:url value="/profile/${user.id}"/>"><i class="fa fa-th-large"></i> <span class="nav-label">Мій Профіль</span> <span class="fa arrow"></span></a>
                    
                </li>
                <li>
                    <a href="<spring:url value="/friends/${user.id}"/>"><i class="fa fa-users"></i> <span class="nav-label">Мої Друзі</span><span class="label label-warning pull-right">${user.friends.size()}</span></a>
                </li>
                <li>
                    <a href="<spring:url value="/my/messages"/>"><i class="fa fa-envelope"></i> <span class="nav-label">Мої Повідомлення</span><span class="label label-warning pull-right">${countNewMessages}</span></a>

                </li>
            </ul>

        </div>
    </nav>