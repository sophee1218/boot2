<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
		<li class="nav-item">
			<a href="" class="nav-link">메뉴1</a>
		</li>
		<li class="nav-item">
			<a href="" class="nav-link">메뉴2</a>
		</li>
		<li class="nav-item">
			<a href="" class="nav-link">메뉴3</a>
		</li>
		<li class="nav-item">
			<a href="" class="nav-link">메뉴4</a>
		</li>
	</ul>
</nav>
<div class="container">
	${sessionScope.user.ui_name}님 반갑습니다.
</body>
</html>