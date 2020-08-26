<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style>
table{
	text-align:center;
}
th{
	
	background-color : orange;
	font-weight : bold;
}

td{
	font-weight : bold;
	color : orange;
	
}

</style>

<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
</head>
<body>

 
<script>




var param = {
		cmd : 'list',
		page:1
}
$.ajax({
	url : '/ajax/member',
	method : 'GET',
	data : {
		json : JSON.stringify(param)
	},
	
	success:function(res){
		var html='';
			for(var i=0; i<res.list.length; i++)
			{
			var member = res.list[i];
			html += '<tr>';
			$('th[data-col]').each(function(idx,th){
				var col = th.getAttribute('data-col');
				html +='<td>'+ member[col]+'</td>';
				
			})
			html += '</tr>';
			}
			$('#tbody').html(html);
		
	},
	
	error : function(err){
		console.log(err.responseText);
	}
	
	
})


$(document).ready();
</script>



<table class="table table-bordered table-hover" >
	<tr>
		<th data-col="rNum">번호</th>
		<th data-col="miNum">멤버번호</th>
		<th data-col="miId">멤버아이디</th>
		<th data-col="miName">멤버이름</th>
	</tr>
			<tbody id="tbody"></tbody>
</table>


</body>
</html>