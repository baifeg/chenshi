<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="title" fragment="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title><c:out value="${title}">陈氏</c:out></title>
	<link rel="stylesheet" href="/assets/css/bootstrap.min.css"><link>
	<link rel="stylesheet" href="/assets/css/bootstrap-theme.min.css"><link>
	<script type="text/javascript" src="/assets/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="/assets/js/jquery-modal.js"></script>
	<script type="text/javascript" src="/assets/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="/views/common/topNav.jsp" />
	<jsp:include page="/views/common/modal.jsp" />
	<div id="body" class="container">
		<jsp:doBody />
	</div>
</body>
</html>