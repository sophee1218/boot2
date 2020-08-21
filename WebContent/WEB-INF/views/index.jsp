<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

<input type="hidden" name="ui_num" id="ui_num" value="${user.ui_num}">

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

<div class="container">
	${sessionScope.user.ui_name}님 반갑습니다.<br>
	<c:if test="${sessionScope.user.ui_admin=='1'}">
		<a href="/views/list"><button class="btn btn-info">회원목록</button></a>
	</c:if>
	<button class="btn btn-info" onclick="doLogout()">로그아웃</button>
	<a href="/views/modify"><button class="btn btn-info">정보수정</button></a>
	<button class="btn btn-info" onclick="doDelete()">회원탈퇴</button>
	</div>

<script>
	function doLogout(){
		alert('로그아웃');
		$.ajax({
			url:'/ajax/user',
			method:'POST',
			data:JSON.stringify({cmd:'logout'}),
			success : function (res) {
				if(res.result){
					alert('로그아웃 되었습니다');
					location.href='/views/login';
				}
			}
		})
	}
	
	function doDelete(){
		var ui_num=document.querySelector('#ui_num').value;
		var params={};
		alert('회원탈퇴');
		params.ui_num=ui_num;
		params.cmd='delete';
		$.ajax({
			url:'ajax/user',
			method:'POST',
			data:JSON.stringify(params),
			success:function (res){
				if(res.result){
					alert('회원탈퇴 되었습니다');
					location.href='/views/login';
				}
				
			}
		})
	}
</script>
</body>
</html>