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
	document.querySelector('#deleteBtn').onclick=function(){
		var uiNumObjs = $('[name=ui_num]:checked');
		if(!uiNumObjs.length){
			alert('선택 하고 누르라구욧!!');
			return;
		}
		var uiNums=[];
		for(var i=0; i<uiNumObjs.length;i++){
			uiNums.push(uiNumObjs[i].value);
		}
		var params = {
				uiNums:uiNums,
				cmd:'deleteUsers'
		}
		
		$.ajax({
			url : '/ajax/user',
			method:'POST',
			data:JSON.stringify(params),
			success:function(res){
				if(res.result){
					alert('삭제완료');
				}
				
			}
		})
	}
	document.querySelector('#allCheck').onchange=function(){
		$('[name=ui_num]').prop('checked',this.checked);
	}
	$.ajax({
		url:'/ajax/user',
		method : 'GET',
		data : {cmd:'list'},
		success : function(res){
			var html ='';
			for(var i=0; i<res.list.length; i++){
				var user=res.list[i];
				html +='<tr>';
				$('th[data-col],th[data-pk]').each(function(idx,th){
					var col = th.getAttribute('data-col');
					if(col){
					html +='<td>' + user[col] + '</td>';	
					}else {
						col=th.getAttribute('data-pk');
						html+='<td><input type="checkbox" name="' +col+'"value="'+user[col] + '"></td>';
					}
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
			<th data-pk="ui_num"><input type="checkbox" id="allCheck"></th>
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
	<button class="btn btn-primary" id="deleteBtn">유저삭제</button>
</div>
</body>
</html>