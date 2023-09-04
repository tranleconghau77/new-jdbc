<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	<title><dec:title default="Trang chu"/></title>
	<!-- Core theme CSS (includes Bootstrap)-->
	<link rel="stylesheet" href="<c:url value='/template/web/css/style.css' />" />
</head>
<body>
	<!-- header -->
	<%@ include file="/common/web/header.jsp"%>

	<div class="container px-4 px-lg-5">
		<dec:body />
	</div>

	<!-- Footer-->
	<%@ include file="/common/web/footer.jsp"%>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="<c:url value='/template/web/js/scripts.js' />"></script>
</body>
</html>
