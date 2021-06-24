<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>


<body>
	<div class="title">항공권 예약</div>
	<form name='frm' method='POST' action='reser.do'>
		<c:forEach begin="0" end="2">
			<input type="hidden" name="ta_code" value="${ta_code}">
			<!-- 부모글 번호 -->
			<table class='table'>
				<tr>
					<th>항공권 예약</th>
				</tr>
				<tr>
					<th>id</th>
					<td><input type='text' name='tu_id' size='20' placeholder='id'></td>
				</tr>
				<tr>
					<th>좌석번호</th>
					<td><input type='text' name='tar_seat' size='10'
						placeholder='좌석번호'></td>
				</tr>
				<tr>
					<th>여권 이름</th>
					<td><input type='text' name='tar_name' size='30'
						placeholder='여권이름'></td>
				</tr>
				<tr>
					<th>여권 번호</th>
					<td><input type='text' name='tar_passcode' size='30'
						placeholder='여권번호'></td>
				</tr>
			</table>
		</c:forEach>
		<div class='row text-center'>
			<input type='submit' value='예약하기'> <input type='button'
				value='취소' onclick="location.href='../index.do'">
		</div>
	</form>
</body>



<%@ include file="../footer.jsp"%>