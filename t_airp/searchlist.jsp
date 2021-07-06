<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../header.jsp"%>
<body>
	<div class="title" style = "text-align:center">티켓 예약하기</div>

	<table class="text-center" style="width:60%; height: 100px; margin: auto; text-align: center;">
		<tr id="table_title">
			<th>티켓번호</th>
			<th>출발지</th>
			<th>도착지</th>
			<th>출발일시</th>
			<th>도착일시</th>
			<th>여분좌석</th>
			<th>예약</th>
			<c:if test="${sessionScope.s_tu_rank =='admin'}">
			<th>삭제</th>
		    </c:if>
		</tr>
		<c:forEach var="dto1" items="${list}">
			<tr class="airp">
				<td>${dto1.ta_code}</td>
				<td>${dto1.ta_dep}</a></td>
				<td>${dto1.ta_arr}</a></td>
				<td>${dto1.ta_sdate}</a></td>
				<td>${dto1.ta_fdate}</a></td>
				<td>${dto1.ta_pax}</a></td>
				<td><input type="button" value="예약"
					onclick="location.href='../airp_reser/reser.do?ta_code=${dto1.ta_code}'">
				</td>
				
				<c:if test="${sessionScope.s_tu_rank =='admin'}">
				<td><input type="button" value="삭제"
					onclick="location.href='delete.do?ta_code=${dto1.ta_code}'">
				</td>
				</c:if>
			</tr>
		</c:forEach>
	</table>


</body>

<%@ include file="../footer.jsp"%>
