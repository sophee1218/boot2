<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
</head>
<body>

<script>

$(document).ready(function(){
	$.ajax({
		url:'/ajax/user',
		method : 'GET',
		data : {cmd:'list'},
		success : function(res){
			var html ='';
			for(var i=0; i<res.list.length; i++){
				var user=res.list[i];
				html +='<tr>';
				$('th[data-col]').each(function(idx,th){
					var col = th.getAttribute('data-col');
					html +='<td>' + user[col] + '</td>';	
				})
				html +='</tr>';
			}
			$('#tbody').html(html);
		}
	})
})

</script>
<h3>유저리스트</h3>
<div id="userListDiv">

	<table class="table table-bordered">
		<tr>
			<th data-col="ui_num"> 번호</th>
			<th data-col="ui_id"> 아이디</th>
			<th data-col="ui_name"> 이름</th>
			<th data-col="ui_nickname"> 닉네임</th>
			<th data-col="ui_birth"> 생일</th>
			<th data-col="ui_age"> 나이</th>
			<th data-col="ui_phone"> 전화번호</th>
			<th data-col="ui_email"> 이메일</th>
			<th data-col="ui_credat"> 가입일</th>
			<th data-col="ui_admin"> 어드민</th>
			
		</tr>
		<tbody id="tbody">
		</tbody>
	</table>
</div>
</body>
</html>