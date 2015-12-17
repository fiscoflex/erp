<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Prueba Unauthorized</h3>
	<form action="authentication" method="post">
		<label>Botón Normal</label>
		<button type="submit">Autenticar</button>
	</form>
	<br />
	<br />
	<form name="form" id="form">
		<label>Botón Ajax</label>
		<button type="button" id="submit">Botón Ajax</button>
	</form>
</body>
<script type="text/javascript">
	$("#submit").click(function() {
		$.ajaxSetup({
			statusCode : {
				401 : function() {
					location.href = "/fiscoflex/login"
				}
			}
		});
		$.ajax({
			type : 'post',
			url : '/fiscoflex/authentication'
		});
	});
</script>
</html>