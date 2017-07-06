<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>

  <head>
	<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>INSTANT MESSENGER | <tiles:insertAttribute name="title-name" /></title>
 
    <link href='<c:url value="resources/css/bootstrap.min.css"/>' rel="stylesheet">
    <link href='<c:url value="resources/font-awesome/css/font-awesome.css"/>' rel="stylesheet">

	<link href='<c:url value="resources/css/plugins/iCheck/custom.css"/>' rel="stylesheet">

    <link href='<c:url value="resources/css/animate.css"/>' rel="stylesheet">
    <link href='<c:url value="resources/css/style.css" />'rel="stylesheet">
 
    <script src="<c:url value="resources/js/jquery-2.1.1.js"/>"></script>
    <script src="<c:url value="resources/js/bootstrap.min.js"/>"></script>
 
   </head>
<body class="gray-bg">   

	<tiles:insertAttribute name="content" />
    
</body>
</html>