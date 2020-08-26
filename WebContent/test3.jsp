<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>

<script>
var corList = [

	
	{corNo:1, corArea:'서울', corSum:555, corNew:2},
	{corNo:2, corArea:'경기', corSum:33, corNew:3}
	
];	

function loadData(){
	var html = '';
	
	for(var i=0; i<corList.length; i++){
		var cor = corList[i];
		html +=  '<tr>';
		$('td[data-col]').each(function(idx,td){
			var col= td.getAttribute('data-col');
			html += '<td>' + cor[col]+ '</td>';
		})
			
		html += '</tr>';
	}
	$('#tbody').html(html);
} 

$(document).ready(loadData);
</script>

<table border="1">
	<tr>
		<td data-col="corNo">버노</td>
		<td data-col="corArea">지역</td>
		<td data-col="corSum">합계</td>
		<td data-col="corNew">신규</td>
	</tr>
	
	<tbody id="tbody">
	
	</tbody>
</table>
</body>
</html>