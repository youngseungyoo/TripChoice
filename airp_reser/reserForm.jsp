<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<style>
th{
background-color: #D64418;
width:200px;
color:white;
border-bottom: 1px solid white;
}
th.head{
background-color: white;
color:black;
}
td{
width:400px
}
tr{
height:80px;
}

tr.people{
height:200px;

}

td.people{
width:400px;
border: 1px solid #444444;
border-color: 	#C0C0C0;
}

div.a{
font-size: 1.5em;

}

div.k{
font-size: 1.5em;
}

div.b{
font-size: 1.5em;
}

p.p1{
font-weight: bold ;
font-size: 1.5em;
}

p.p2{
font-size: 1em;
font-weight: bold ;

}

div.reser {
  margin-top: 20px;
  margin-bottom: 20px;
  margin-right: 400px;
  margin-left: 400px;

}


input[type='radio']{
margin:40px;
padding:40px;
}

input.next{
background-color: #D64418;
border:0;
outline:0;
color:white;
border-radius: 8px;
}


</style>
<script>

function seatselect() {
	   window.open("../t_airp/test.do?ta_code=${ta_code}", "tar_seat", "width=500, height=1000");   
	}
	
	$(document).ready(function() {
		
		var a = 0; // 변수설정은 함수의 바깥에 설정!
		var k = 0;
		var b=  0;
		$("#add").click(function() {
			a++; // 함수 내 하단에 증가문 설정
			$("#adultbox").append("<table class='adult"+a+"' style='text-align: center;'><input type='hidden' name='ta_code' value='${ta_code}'><input type='hidden' name='tu_id' value='${sessionScope.s_tu_id}'><th class='head'>성인"+a+"</th><tr class='active'><th>좌석번호</th><td><input type='text' name='tar_seat' size='25' placeholder='좌석번호' readonly><input type='button' value='좌석선택' onclick='seatselect()'></td><th>여권 이름</th><td><input type='text' name='tar_name' size='25'placeholder='ex)yoo(성) youngseung(이름)'></td></tr><tr><th>여권 번호</th><td><input type='text' name='tar_passcode' size='25'placeholder='M으로 시작하는 8자리'></td></tr></table><hr class='"+a+"'>")
			document.getElementById("adult").value = a;
		});
		
		$("#add1").click(function() {
			k++; // 함수 내 하단에 증가문 설정
			$("#kidbox").append("<table class='kid"+k+"' style='text-align: center;'><input type='hidden' name='ta_code' value='${ta_code}'><input type='hidden' name='tu_id' value='${sessionScope.s_tu_id}'><th class='head'>아동"+k+"</th><tr class='active'><th>좌석번호</th><td><input type='text' name='tar_seat' size='25' placeholder='좌석번호'></td><th>여권 이름</th><td><input type='text' name='tar_name' size='25'placeholder='ex)yoo(성) youngseung(이름)'></td></tr><tr><th>여권 번호</th><td><input type='text' name='tar_passcode' size='25'placeholder='M으로 시작하는 8자리'></td></tr></table><hr class='"+k+"'>")
			document.getElementById("kid").value = k;
		});
		
		$("#add2").click(function() {
			b++; // 함수 내 하단에 증가문 설정
			$("#babybox").append("<table class='baby"+b+"' style='text-align: center;'><input type='hidden' name='ta_code' value='${ta_code}'><input type='hidden' name='tu_id' value='${sessionScope.s_tu_id}'><th class='head'>유아"+b+"</th><tr class='active'><th>좌석번호</th><td><input type='text' name='tar_seat' size='25' placeholder='좌석번호'></td><th>여권 이름</th><td><input type='text' name='tar_name' size='25'placeholder='ex)yoo(성) youngseung(이름)'></td></tr><tr><th>여권 번호</th><td><input type='text' name='tar_passcode' size='25'placeholder='M으로 시작하는 8자리'></td></tr></table><hr class='"+b+"'>")
			document.getElementById("baby").value = b;
		});
		
		$("#remove").click(function() {
			
			$( "table.adult"+a+"" ).remove();
			$( "hr."+a+"" ).remove();
			a--; // 함수 내 상단에 감소문 설정
			if(a<0){
				a=0;
				alert("0 밑으로 내려갈수없습니다.")
			}
			
			document.getElementById("adult").value = a;
			
			


		});
		
		$("#remove1").click(function() {
			
			$( "table.kid"+k+"" ).remove();
			$( "hr."+k+"" ).remove();
			k--; // 함수 내 상단에 감소문 설정
			if(k<0){
				k=0;
				alert("0 밑으로 내려갈수없습니다.")
			}
			
			document.getElementById("kid").value = k;
			
			


		});
		
		$("#remove2").click(function() {
			
			$( "table.baby"+b+"" ).remove();
			$( "hr."+b+"" ).remove();
			b--; // 함수 내 상단에 감소문 설정
			if(b<0){
				b=0;
				alert("0 밑으로 내려갈수없습니다.")
			}
			
			document.getElementById("baby").value = b;
			
			


		});
		
	});
	
	function airpreserCheck() { //로그인 유효성 검사

		//1)여권번호가 M으로 시작하는 8글자인지 체크
	    var tar_passcode=document.getElementById("tar_passcode").value;
	    tar_passcode=tar_passcode.trim();
	    if(!(tar_passcode.length==8 && tar_passcode.charAt(0)=='M')){
	    	alert("여권번호를 M이 포함된 8글자로 입력하세요");
	    	document.getElementById("tar_passcode").focus();
	    	return false;
	    }//if end

		return true;
		alert("예약 성공");
	}//airpreserCheck() end


</script>

	<!-- 버튼 -->
<div class='reser'>

			<p class="p1">인원정보</p>
			<p class="p2">여행인원</p>
				<table>
					<tr class="people">
						<td class="people">
							<div>성인 <p>만13세 이상</p></div>
							<div><button class="add" id="add">+</button><input type='text' id='adult' value='0' size='3' style="text-align:center; border: 0px;" readonly ><button id="remove">-</button></div>
						</td>
						<td class="people">
							<div>아동 <p>만13세 미만</p></div>
							<div><button id="add1">+</button><input type='text' id='kid' value='0' size='3' style="text-align:center; border: 0px;" readonly ><button id="remove1">-</button></div>
						</td>
						<td class="people">
							<div>유아 <p>만2세 미만</p></div>
							<div><button id="add2">+</button><input type='text' id='baby' value='0' size='3' style="text-align:center; border: 0px;" readonly ><button id="remove2">-</button></div>
						</td>
					</tr>		
			    </table>
<!-- 폼양식 시작 -->
			
	    <form name='frm' method='POST' action='reser.do'>
	    
	    	<div id="adultbox">
	    	<!-- 테이블 생성 공간 -->
	    	</div>
	 
	    
	
	     	<div id="kidbox">
	    	<!-- 테이블 생성 공간 -->
	    	</div>
	  
	    
	 
	     	<div id="babybox">
	    	<!-- 테이블 생성 공간 -->
	    	</div>
	   
	     	 <br>
		     <div style='text-align:center;'>
			 <input type='submit'  value='예약하기' class="next">
			 </div>
		</form> 
<!-- 폼양식 끝 -->

</div>	






<%@ include file="../footer.jsp"%>