<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@ taglib  uri="http://www.springframework.org/tags" prefix="spring" %>

	<div class="middle-box text-center loginscreen   animated fadeInDown">
        <div>
            
            <h3>Авторизація до INSTANT MESSENGER
            </h3><c:if test="${not empty message}">
				<div id="message" class="alert alert-${message.type} alert-dismissable">${message.message}</div>
			</c:if>
            
		<spring:url value="/authorization" var="addAccount"/>
            <form:form class="m-t" role="form" action="${addAccount}" commandName="account" method="post">
                <div class="form-group">
                    <form:input type="text" class="form-control" path="firstName" placeholder="Ім'я" required="true" />
                    <form:errors path="firstName" cssClass="error" />
                </div>
                <div class="form-group">
                    <form:input type="text" class="form-control" path="secondName" placeholder="Прізвище" required="true" />
                    <form:errors path="secondName" cssClass="error" />
                </div>
                <div class="form-group">
                    <form:input type="text" class="form-control" path="nickName" placeholder="Нік" required="true" />
                    <form:errors path="nickName" cssClass="error" />
                </div>
                <div class="form-group">
                    <form:input type="email" class="form-control" path="email" placeholder="Пошта" required="true" />
                    <form:errors path="email" cssClass="error" />
                </div>
                <div class="form-group">
                    <form:input type="password" class="form-control" path="password" placeholder="Пароль" required="true" />
                    <form:errors path="password" cssClass="error" />
                </div>
                <div class="form-group">
                    <form:input type="password" class="form-control" path="retypePassword" placeholder="Повторення пароля" required="true" />
                	<form:errors path="retypePassword" cssClass="error" />
                </div>
                <div class="form-group">
                    <div class="checkbox i-checks"><label> <form:checkbox path="termsAndPolicy"/><i></i> Погодьтеся з умовами і політикою конфеденційності </label></div>
                	<form:errors path="termsAndPolicy" cssClass="error" />
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">Зареєструватися</button>

                <p class="text-muted text-center"><small>Вже є аккаунт?</small></p>
                <a class="btn btn-sm btn-white btn-block" href="<c:url value="/login"/>">Сторінка ідентифікації</a> 
            </form:form>
        </div>
    </div>

	<!-- iCheck -->
    <script src="<c:url value="resources/js/plugins/iCheck/icheck.min.js"/>"></script>
    <script>
        $(document).ready(function(){
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        });
    </script>