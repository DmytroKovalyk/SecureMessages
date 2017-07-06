<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@ taglib  uri="http://www.springframework.org/tags" prefix="spring" %>

			<div class="row wrapper border-bottom white-bg page-heading">
                <div class="col-lg-9">
                    <h2>${titlePage}</h2>
                </div>
            </div>

		<div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
            	<c:if test="${searchWrapper.searchInfo != null}">
	                <div class="col-lg-12">
	                    <div class="ibox float-e-margins">
	                        <div class="ibox-content">
	                            <h2>
	                                ${accounts.size()} результат(-и/-ів) знайдено за: "<span class="text-navy">${searchWrapper.searchInfo}</span>"
	                            </h2>
	
	                            <div class="search-form">
	                                <form:form action="<spring:url value='/user/search' />" commandName="searchWrapper" method="post">
	                                    <div class="input-group">
	                                        <form:input path="searchInfo" type="text" placeholder="Пошук користувачів..." name="search" class="form-control input-lg"/>
	                                        <div class="input-group-btn">
	                                            <button class="btn btn-lg btn-primary" type="submit">
	                                                Шукати
	                                            </button>
	                                        </div>
	                                    </div>
	                                </form:form>
	                            </div>
	       					</div>
	       				</div>
	       			</div>
	       		</c:if>
	       		
	       		<c:forEach items="${accounts}" var="account">
			       	<div class="col-lg-4">
		                <div class="contact-box">
		                    <a href="<spring:url value="/profile/${account.id}"/>">
			                    <div class="col-sm-4">
			                        <div class="text-center">
			                            <c:if test="${account.photo != null}">
				                            <img  alt="${account.fullName}" class="img-circle m-t-xs img-responsive" src="../resources/img/${account.photo}">
				                        </c:if>
				                            
				                        <c:if test="${account.photo == null}">
				                         	<img alt="${account.fullName}" class="img-circle m-t-xs img-responsive" src="../resources/img/profile_photo.png">
				                   		</c:if>
			                            <div class="m-t-xs font-bold">Нікнейм: ${account.nickName}</div>
			                        </div>
			                    </div>
			                    <div class="col-sm-8">
			                        <h3><strong>${account.fullName}</strong></h3>
			                        <address>
			                            <strong>Пошта:</strong><br>
			                            ${account.email}
			                        </address>
			                    </div>
			                    <div class="clearfix"></div>
		                    </a>
		                </div>
		            </div>
	       		</c:forEach>
	       		
       		</div>
       	</div>
       	
       	
       	
       	
   	<script>
        $(document).ready(function(){
            $('.contact-box').each(function() {
                animationHover(this, 'pulse');
            });
        });
    </script>
       	
       	
       	