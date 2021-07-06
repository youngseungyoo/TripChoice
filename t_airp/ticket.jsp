<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<style>
p{
margin-top: 10px;
font-weight: bold ;
font-size: 1.5em;
}

td{

width:100px;
}
th{
	border-bottom:0.5px solid white;
	width:200px;
    background-color: #D64418;
    color:white;
}
input{
margin:20px;
outline:0;
}
input.next{
background-color: #D64418;
border:0;
outline:0;
color:white;
border-radius: 8px;
}
</style>

<body>

	<p class="title" style="text-align: center;">항공권 등록</p>
	<br>
	<c:if test="${sessionScope.s_tu_rank =='admin'}">
		<form name='frm' method='POST' action='ticket.do'">
			<table style="width:30%; height: 100px; margin: auto; text-align: center;">
				<tr>
					<th>항공권 코드</th>
					<td><input type='text' name='ta_code' size='15'
						placeholder='코드'></td>
				</tr>
				<tr>
					<th>출발장소</th>
					<td><input type='text' name='ta_dep' size='15'
						placeholder='출발장소'></td>
				</tr>
				<tr>
					<th>도착장소</th>
					<td><input type='text' name='ta_arr' size='15'
						placeholder='도착장소'></td>
				</tr>
				<tr>
					<th>예약가능 인원</th>
					<td><input type='number' name='ta_pax' size='10'
						placeholder='예약가능인원'></td>
				</tr>

				<tr>
					<th>비행기모델</th>
					<td><input type='text' name='ta_flightnum' size='15'
						placeholder='모델명'></td>
				</tr>
				<tr>
					<th>출발일시</th>
					<td><input type='text' name='ta_sdate' size='15'
						placeholder='출발일시'></td>
				</tr>
				<tr>
					<th>도착일시</th>
					<td><input type='text' name='ta_fdate' size='15'
						placeholder='도착일시'></td>
				</tr>
				<tr>
					<th>상품코드</th>
					<td><input type='text' name='trip_code' size='15'
						placeholder='상품코드'></td>
				</tr>
			</table>
			<br>
			<div class='row text-center'>
				<input type='submit' class=next value='등록'> <input type='button' class='next'
					value='취소'
					onclick="location.href='<%=request.getContextPath()%>/index.do'">
			</div>
		</form>
	</c:if>
	

	<!-- 관리자가 아닐 때 띄우기 -->
	<c:if test="${sessionScope.s_tu_rank !='admin'}">
		<div align="center">
			관리자만 접근 가능합니다 <br> <a href="javascript:history.back()">돌아가기</a>
		</div>
	</c:if>
	<!-- 본문 끝-->
</body>

<%@ include file="../footer.jsp"%>
