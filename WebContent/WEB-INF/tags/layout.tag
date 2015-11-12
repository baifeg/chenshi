<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="title" fragment="true" %>
<html>
<head>
	<title><jsp:invoke fragment="title"/></title>
	<link rel="stylesheet" href="/assets/css/bootstrap.min.css"><link>
	<link rel="stylesheet" href="/assets/css/bootstrap-theme.min.css"><link>
	<script type="text/javascript" src="/assets/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="/assets/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="/views/common/topNav.jsp" />
	<div id="body" class="container">
		<jsp:doBody />
	</div>
</body>
</html>