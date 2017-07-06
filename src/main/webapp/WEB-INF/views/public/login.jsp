<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@ taglib  uri="http://www.springframework.org/tags" prefix="spring" %>


    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
			
            <h3>Ласкаво Просимо до INSTANT MESSENGER</h3>
				
	<c:if test="${param.error != null}">
        <div class="alert alert-danger alert-dismissable">
            Неправильне ім'я користувача та/або пароль
        </div>
    </c:if>
    
            <form class="m-t" action="<spring:url value="/login"/>" method="post">
                <div class="form-group">
                    <input type="email" class="form-control" placeholder="Логін" name="username" >
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="Пароль" name="password" >
                </div>
                <button name="submit" type="submit" class="btn btn-primary block full-width m-b">Увійти</button>

                <a href="#"><small>Забули пароль?</small></a>
                <p class="text-muted text-center"><small>Немає аккаунта?</small></p>
                <a class="btn btn-sm btn-white btn-block" href="<c:url value="/authorization"/>">Створити акаунт</a>
            </form>
        </div>
    </div>

    
    
    