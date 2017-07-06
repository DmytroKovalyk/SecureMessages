<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@ taglib  uri="http://www.springframework.org/tags" prefix="spring" %>


			<div class="row wrapper border-bottom white-bg page-heading">
                <div class="col-lg-10">
                    <h2>Профіль</h2>
                </div>
                <div class="col-lg-2">

                </div>
            </div>
            
   		<div class="wrapper wrapper-content">
            <div class="row animated fadeInRight">
                <div class="col-md-4">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>Деталі Профілю</h5>
                        </div>
                        <div>
                            <div class="ibox-content no-padding border-left-right">
                            	<c:if test="${account.photo != null}">
                                	<img alt="image" align="middle" alt="${account.fullName}" class="img-responsive" src="../resources/img/${account.photo}">
                                </c:if>
                                <c:if test="${account.photo == null}">
                                	<img alt="image" align="middle" alt="${account.fullName}" class="img-responsive" src="../resources/img/profile_photo.png">
                                </c:if>
                            </div>
                            <div class="ibox-content profile-content">
                                <h4><strong>${account.fullName}</strong></h4>
                                <!--  
                                <p><i class="fa fa-map-marker"></i> Riviera State 32/106</p>
                                -->
                                <div class="row m-t-lg">
                                    <div class="col-md-4">
                                        <h5><a href='<spring:url value="/following/${account.id}"/>'><strong>${account.followersToOther.size()}</strong> Підписаний на</a></h5>
                                    </div>
                                    <div class="col-md-4">
                                        <h5><a href='<spring:url value="/follower/${account.id}"/>'><strong>${account.followersToMe.size()}</strong> Підписники</a></h5>
                                    </div>
                                    <div class="col-md-4">
                                        <h5><a href='<spring:url value="/friends/${account.id}"/>'><strong>${account.friends.size()}</strong> Друзі </a></h5>
                                    </div>
                                </div>
                                <c:if test="${user.id != account.id}">
	                                <div class="user-button">
	                                    <div class="row">
	                                        <div class="col-md-6">
	                                            <button type="button" class="btn btn-primary btn-sm btn-block"><i class="fa fa-envelope"></i> Відправити повідомлення</button>
	                                        </div>
			                                <c:if test="${not twofriends}">
				                                <c:if test="${not folowingToAccount}">
			                                        <div class="col-md-6">
			                                            <button type="button" class="btn btn-primary btn-sm btn-block"><i class="fa fa-users"></i> Додати до друзів</button>
			                                        </div>
				                                </c:if>
				                                <c:if test="${folowingToAccount}">
			                                        <div class="col-md-6 ">
			                                            <button type="button" class="btn btn-primary btn-sm btn-block" disabled="disabled" data-toggle="tooltip" data-placement="top" title="Запит дружити надіслано"><i class="fa fa-users"></i> Додати до друзів</button>
			                                        </div>
				                                </c:if>
			                                </c:if>
	                                 	</div>
	                                </div>
                                </c:if>
                            </div>
                    	</div>
                	</div>
                </div>
                <c:if test="${user.id == account.id}">
                	<div class="col-md-8">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>Повідомлення</h5>
                                <div class="ibox-tools">
                                    <a class="collapse-link">
                                        <i class="fa fa-chevron-up"></i>
                                    </a>
                                    <a class="close-link">
                                        <i class="fa fa-times"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="ibox-content ibox-heading">
                                <h3><i class="fa fa-envelope-o"></i> Нові повідомлення</h3>
                                <small><i class="fa fa-tim"></i> Ви отримали ${countNewMessages} нових повідомлень.</small>
                            </div>
                            <div class="ibox-content">
                                <div class="feed-activity-list">
									<c:forEach items="${messages}" var="message">
	                                    <div class="feed-element">
	                                        <div>
	                                            <small class="pull-right text-navy">
	                                            	<fmt:formatDate
														value="${message.date}"
														pattern="dd-MM-yyyy HH:mm:ss" />
												</small>
	                                            <strong>${message.from.fullName}</strong>
	                                            <div>${message.message}</div>
	                                            <small class="text-muted">
												</small>
	                                        </div>
	                                    </div>
                                    </c:forEach>                                   
                                </div>
                            </div>
                        </div>
                    </div>
              	</c:if>
              	<c:if test="${user.id != account.id}">
              		<c:forEach items="${friends}" var="friend">
				       	<div class="col-md-4">
			                <div class="contact-box">
			                    <a href="<spring:url value="/profile/${friend.id}"/>">
				                    <div class="col-sm-4">
				                        <div class="text-center">
				                        	<c:if test="${friend.photo != null}">
				                            	<img alt="${friend.fullName}" class="img-circle m-t-xs img-responsive" src="../resources/img/${friend.photo}">
				                            </c:if>
				                            
				                            <c:if test="${account.photo == null}">
				                            	<img alt="${friend.fullName}" class="img-circle m-t-xs img-responsive" src="../resources/img/profile_photo.png">
				                            </c:if>
				                            
				                            <div class="m-t-xs font-bold">${friend.nickName}</div>
				                        </div>
				                    </div>
				                    <div class="col-sm-8">
				                        <h3><strong>${friend.fullName}</strong></h3>
				                        <address>
				                            <strong>Email:</strong><br>
				                            ${friend.email}
				                        </address>
				                    </div>
				                    <div class="clearfix"></div>
			                    </a>
			                </div>
			            </div>
		       		</c:forEach>
              	</c:if>
            </div>
        </div>
        
  	<script>
        $(document).ready(function(){
            $('.contact-box').each(function() {
                animationHover(this, 'pulse');
            });
        });
    </script>
    
    