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

var corList = [
		{corNo:1,corArea:'대구',corSum:6978,corNew:0},
		{corNo:2,corArea:'서울',corSum:2986,corNew:97},
		{corNo:3,corArea:'경기',corSum:2612,corNew:85},
		{corNo:4,corArea:'경북',corSum:1443,corNew:6},
		{corNo:5,corArea:'검역',corSum:1322,corNew:4},
		{corNo:6,corArea:'인천',corSum:543,corNew:20},
		{corNo:7,corArea:'광주',corSum:280,corNew:1},
		{corNo:8,corArea:'부산',corSum:262,corNew:3},
];

function loadData(){
	var html = '';
	var corSumTotal = 0;
	var corNewTotal = 0;
	for(var i=0; i<corList.length; i++){
		var cor = corList[i];
		html+='<tr>';
		$('td[data-col]').each(function(idx,td){
			var col = td.getAttribute('data-col');
			html += '<td>'+ cor[col] +'</td>';
			if(col=='corSum'){
				corSumTotal += cor[col];
			}else if(col=='corNew'){
				corNewTotal+=cor[col];
			}
		})
		html+='</tr>';
		
	}
	html += '<tr><td colspan="2">합계</td>';
	html += '<td>' + corSumTotal + '</td>';
	html += '<td>' + corNewTotal + '</td></tr>';
	
	
	$('#tBody').html(html);
}

$(document).ready(loadData);
</script>
	
	<table border="1">
		<tr>
			<td data-col='corNo'>번호</td>
			<td data-col='corArea'>지역</td>
			<td data-col='corSum'>확진자수</td>
			<td data-col='corNew'>신규감염자수</td>
			
		</tr>
	
	<tbody id="tBody">
	</tbody>
	</table>
	
	
		
</body>
</html>