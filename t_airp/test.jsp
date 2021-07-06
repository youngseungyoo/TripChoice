<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<script src="../js/myscript.js"></script>

<form action="../index.do" onsubmit="return send()">

<div style="text-align: center">
	
<script>
/*
String[][] seat = { {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
	"L", "M", "N",	"O", "P", "Q", "R", "S", "T", "U", "V" ,"W", 
	"X", "Y", "Z"}, 
	{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}};
for(int i=0; i<26; i++){
for(int j=0; j<10; j++){
	System.out.printf(seat[0][i]+seat[1][j]);
}
}*/

{
"List": [
	{
		"1": "A",
		"11": "B",
		"21": "C",
		"31": "D",
		"41": "E",
		"51": "F",
		"61": "G",
		"71": "H",
		"81": "I",
		"91": "J",
		"101": "K",
		"111": "L",
		"121": "M",
		"131": "N",
		"141": "O",
		"151": "P",
		"161": "Q",
		"171": "R",
		"181": "S",
		"191": "T",
		"201": "U",
		"211": "V",
		"221": "W",
		"231": "X",
		"241": "Y",
		"251": "Z"
        }
	]
}

function apply(tar_seat) {
	//alert(id);
	//중복 확인된 id를 부모창(opener)에 적용				
	opener.frm.tar_seat.value=tar_seat;
	window.close();
}//apply() end

</script>
${dto.ta_code}
${dto.ta_flightnum}
${dto.ta_pax}

<input type='button' value='${dto.ta_pax}' >

<br>

<c:forEach var="a" begin="1" end='${dto.ta_pax}' step="10">
	<ul>
	<span class="seatNum"><c:out value="${a}"/></span>
	<c:forEach var="b" begin="1" end="10">
		<input type="button" value="${b}" id="tar_seat" name="tar_seat" class="tar_seat">
	</c:forEach>
	</ul>
</c:forEach>


<input type="button" value="확인" class="btn btn-primary" onclick="apply()"/> 
</div>

</form>

<%@ include file="../footer.jsp" %>