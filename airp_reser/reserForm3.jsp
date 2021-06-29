<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<script>
	$(document).ready(function() {
		var i = 1; // 변수설정은 함수의 바깥에 설정!
		$("#add").click(function() {

			$("#boxWrap").append("<form  class='frm' name='frm"+i+"' id= 'frm' method='POST' action='reser.do'><input type='hidden' name='ta_code' value='${ta_code}'><table class = 'table'><tr><th>항공권 예약</th></tr><tr><th>id</th><td><input type='text' name='tu_id' size='20' placeholder='id'></td></tr><tr><th>좌석번호</th><td><input type='text' name='tar_seat' size='10'placeholder='좌석번호'></td></tr><tr><th>여권 이름</th><td><input type='text' name='tar_name' size='30'placeholder='여권이름'></td></tr><tr><th>여권 번호</th><td><input type='text' name='tar_passcode' size='30'placeholder='여권번호'></td></tr></table></form>")

			i++; // 함수 내 하단에 증가문 설정

		});
		
		$("#remove").click(function() {
			$( "form.frm"+i+"" ).remove();
			i--; // 함수 내 하단에 증가문 설정

		});
		
		 $("#btn_submit").click(function(){
			    $.post("reser.do", $('form').serialize(), function(data){
			 
			   });
			 });
	});
</script>
	<!-- 버튼 -->
	<div class="btnWrap">
		<button id="add">누르면 폼 추가!</button>
	</div>
	
	<div class="btnWrap">
		<button id="remove">누르면 폼 삭제!</button>
	</div>
	
	<div class="btnWrap">
		<button id="btn_submit">폼 전송</button>
	</div>


	<!-- 박스 추가되는 영역 -->

	<div id="boxWrap">
		

	<input type='submit' value='예약하기'> 
	</div>
	
	



<%@ include file="../footer.jsp"%>