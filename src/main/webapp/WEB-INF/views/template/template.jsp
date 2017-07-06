<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>

  <head>
	<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>INSTANT MESSENGER | <tiles:insertAttribute name="title" /></title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">    
    <!--  -->
    <link href='<spring:url value="../resources/css/bootstrap.min.css"/>' rel="stylesheet">
    <link href='<spring:url value="../resources/font-awesome/css/font-awesome.css"/>' rel="stylesheet">

    <link href='<spring:url value="../resources/css/animate.css"/>' rel="stylesheet">
    <link href='<spring:url value="../resources/css/style.css" />'rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

     <!-- Mainly scripts -->
    <script src="<spring:url value="../resources/js/jquery-2.1.1.js"/>"></script>
    <script src="<spring:url value="../resources/js/bootstrap.min.js"/>"></script>
    <script src="<spring:url value="../resources/js/plugins/metisMenu/jquery.metisMenu.js"/>"></script>
    <script src="<spring:url value="../resources/js/plugins/slimscroll/jquery.slimscroll.min.js"/>"></script>

    <!-- Custom and plugin javascript -->
    <script src="<spring:url value="../resources/js/inspinia.js"/>"></script>
    <script src="<spring:url value="../resources/js/plugins/pace/pace.min.js"/>"></script>
  </head>
<body >
 	<!-- Site wrapper -->
	<div class="wrapper">
		
		<!-- Menu Page -->
		<tiles:insertAttribute name="menu" />
		
		<div id="page-wrapper" class="gray-bg">
			<!-- Header -->
			<tiles:insertAttribute name="header" />
		
			<!-- Body Page -->
			<tiles:insertAttribute name="body" />
			
			<!-- Footer Page -->
			<tiles:insertAttribute name="footer" />
		</div>
		
	</div>
	
    
    
</body>
</html>