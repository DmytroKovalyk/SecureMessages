<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@ taglib  uri="http://www.springframework.org/tags" prefix="spring" %>

<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-10">
        <h2>Мої повідомлення</h2>
        <ol class="breadcrumb">
            <li>
                <a href="<spring:url value="/profile"/>">Мій профіль</a>
            </li>
            <li class="active">
                <strong>Мої повідомлення</strong>
            </li>
        </ol>
    </div>

</div>

<div class="wrapper wrapper-content animated fadeInRight">

    <div class="row">
        <div class="col-lg-12">

                <div class="ibox chat-view">

                    <div class="ibox-title">
                        <c:if test="${account != null}">
                        	Переписка з ${account.fullName}
                        </c:if>
                    </div>


                    <div class="ibox-content">

                        <div class="row">

                            <div class="col-md-9 ">
                                <div class="chat-discussion">
									<c:forEach items="${messages}" var="message">
										<c:if test="${message.to.id == user.id}">
		                                    <div class="chat-message message-left">
		                                    	<a href="<spring:url value="/profile/${message.from.id}"/>" >
			                                    	<c:if test="${message.from.photo != null}">
					                                	<img width="48" height="48" alt="${message.from.fullName}" class="message-avatar" src="../resources/img/${message.from.photo}">
					                                </c:if>
					                                <c:if test="${message.from.photo == null}">
					                            		<img width="48" height="48" alt="${message.from.fullName}" class="message-avatar" src="../resources/img/default_profile.png" />
					                            	</c:if>
		                                    	</a>
		                                        <div class="message ${message.read?'':'unread'}">
		                                            <a class="message-author" href="<spring:url value="/profile/${message.from.id}"/>"> ${message.from.nickName} </a>
		                                            <span class="message-date">  <fmt:formatDate value="${message.date}" pattern="dd-MM-yyyy HH:mm:ss" /> </span>
		                                            <span class="message-content">
														${message.message}
		                                            </span>
		                                        </div>
		                                    </div>
	                                    </c:if>
                                    
                                    	<c:if test="${message.to.id != user.id}">
		                                    <div class="chat-message message-right ">
		                                        
		                                        <div class="message ${message.read?'':'unread'}">
		                                            <span class="message-date">  <fmt:formatDate value="${message.date}" pattern="dd-MM-yyyy HH:mm:ss" /> </span>
		                                            <span class="message-content">
														${message.message}
		                                            </span>
		                                        </div>
		                                    </div>
                                    	</c:if>
                                    </c:forEach>
                                   
                                </div>

                            </div>
                            <div class="col-md-3">
                                <div class="chat-users">
                                    <div class="users-list">
                                        <c:forEach items="${friends}" var="friend">
	                                        <div id="${friend.id}" class="chat-user ${friend.id==param.id?'selected':''}">
	                                        	<c:if test="${friend.online}">
	                                            	<span class="pull-right label label-primary">Online</span>
	                                            </c:if>
	                                            
		                                            <c:if test="${friend.photo != null}">
						                            	<img alt="${friend.fullName}" width="36px" height="36px" class="chat-avatar" src="../resources/img/${friend.photo}">
						                            </c:if>
						                            <c:if test="${friend.photo == null}">
						                            	<img alt="${friend.fullName}" width="36px" height="36px" class="chat-avatar" src="../resources/img/profile_photo.png">
						                            </c:if>
					                            
	                                            <div class="chat-user-name">
	                                                ${friend.fullName}
	                                            </div>
	                                        </div>
                                        </c:forEach>
                                        
                                    </div>

                                </div>
                            </div>

                        </div>
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="chat-message-form">
                                    <div class="form-group">
                                        <textarea data-toggle="tooltip" data-placement="bottom" class="form-control message-input" id="message-text" name="message" placeholder="Введіть текст повідомлення"></textarea>
                                    </div>

                                </div>
                            </div>
                        </div>
						<div class="row">
                            <div class="col-lg-4 pull-right">
								<button type="button" id="sent-message" class="btn btn-primary btn-sm btn-block"><i class="fa fa-envelope"></i> Відправити повідомлення</button>
							</div>
                        </div>
                    </div>

                </div>
        </div>

    </div>


</div>
<script>
function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

$(document).ready(function(){
	var id = '${param.id}';
	var messageTextarea = $('#message-text');
	$('[data-toggle="tooltip"]').tooltip();
	messageTextarea.tooltip('hide');
	if (!id){
		messageTextarea.attr("readonly", true);
		messageTextarea.attr("title", "Виберіть співрозмовника");
		messageTextarea.tooltip('show');
	}
	
	messageTextarea.hover(function() {
		
	});
	
	$('.chat-user').click(function() {
		$('.chat-user').removeClass('selected');
		
		$(this).addClass('selected');
		
		var dataString = {"id": $(this).attr('id')};
		
		$.ajax({
           	type: "POST",
           	url: "friendmessages",
	        dataType : 'json',
            contentType: "application/json; charset=utf-8",
	        data: JSON.stringify(dataString),
           	success: function(data){
           		alert(data);
           	}
		})
		
		messageTextarea.tooltip('hide');
		messageTextarea.attr("readonly", false);
	});
	
	$('#sent-message').click(function() {
		alert('Hi');
	});
});
</script>


