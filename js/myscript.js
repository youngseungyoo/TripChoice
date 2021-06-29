/**
 * myscript.js
 */

function bbsCheck(){ //게시판 유효성 검사
	//alert("bbsCheck()호출");

	//1)작성자 2글자 이상 입력
	var tu_name=document.getElementById("tu_name").value; //작성자 가져오기
	tu_name=tu_name.trim();                               //좌우 공백 제거하기
	if(tu_name.length<2){
	    alert("작성자 2글자 이상 입력해 주세요");
    	document.getElementById("tu_name").focus();     //작성자 칸에 커서 생성
    	return false;                                 //전송하지 않음
	}//if end
	
	//2)제목 2글자 이상 입력
	var subject=document.getElementById("subject").value;
	subject=subject.trim();                               
	if(subject.length<2){
	    alert("제목 2글자 이상 입력해 주세요");
    	document.getElementById("subject").focus();     
    	return false;                                 
	}//if end
	
	//3)내용 2글자 이상 입력
	var content=document.getElementById("content").value;
	content=content.trim();                               
	if(content.length<2){
	    alert("내용 2글자 이상 입력해 주세요");
    	document.getElementById("content").focus();     
    	return false;                                 
	}//if end
	
	//4)비밀번호는 4글자이상이면서 숫자형 기호만 입력
	var tu_pw=document.getElementById("tu_pw").value;
	tu_pw=tu_pw.trim();                               
	if(tu_pw.length<4 || isNaN(tu_pw)){
	    alert("비밀번호 4글자 이상 숫자로 입력해 주세요");
    	document.getElementById("tu_pw").focus();     
    	return false;                                 
	}//if end
	
	return true; //onsubmit이벤트에서 서버로 전송
	
}//bbsCheck() end


function pwCheck(){
	//비밀번호는 4글자이상이면서 숫자형 기호만 입력
	var tu_pw=document.getElementById("tu_pw").value;
	tu_pw=tu_pw.trim();                               
	if(tu_pw.length<4 || isNaN(tu_pw)){
	    alert("비밀번호 4글자 이상 숫자로 입력해 주세요");
    	document.getElementById("tu_pw").focus();     
    	return false;                                 
	}//if end
	
	var message="진행된 내용은 복구되지 않습니다\n계속 진행할까요?";
	if(confirm(message)){ //확인true, 취소false
		return true;      //서버로 전송
	}else{
		return false;
	}//if end	
}//pwCheck() end



function searchCheck(){
	//검색어를 입력해야만 서버로 전송
	var word=document.getElementById("word").value;
	word=word.trim();                               
	if(word.length==0){
	    alert("검색어를 입력해 주세요");     
    	return false;                                 
	}//if end
	
	return true;
	
}//searchCheck() end


function loginCheck() { //로그인 유효성 검사
	//1)아이디 5~10글자이내인지 검사
	var tu_id=document.getElementById("tu_id").value;
    tu_id=tu_id.trim();
    if(!(tu_id.length>=5 && tu_id.length<=10)){
    	alert("아이디 5~10글자이내 입력해 주세요");
	    document.getElementById("tu_id").focus();
    	return false;
	}//if end

	//2)비밀번호 5~10글자이내인지 검사
    var tu_pw=document.getElementById("tu_pw").value;
    tu_pw=tu_pw.trim();
    if(!(tu_pw.length>=5 && tu_pw.length<=10)){
    	alert("비밀번호 5~10글자이내 입력해 주세요");
    	document.getElementById("tu_pw").focus();
    	return false;
    }//if end

	return true;
	
}//loginCheck() end



function idCheck() { //아이디 중복확인
	//bootstrap 모달창
	//->부모창과 자식창이 한몸으로 구성되어 있음
	//->참조 https://www.w3schools.com/bootstrap/bootstrap_modal.asp	
	
	//새창만들기
	//->부모창과 자식창이 별개로 구성되어 있음
	//->모바일에 기반을 둔 frontend단에서는 사용하지 말것!!
	//window.open("파일명", "새창이름", "다양한 옵션들")
	window.open("idCheckForm.do", "idwin", "width=400, height=350");	
	
}//idCheck() end


function emailCheck() { //이메일 중복확인

	window.open("emailCheckForm.do", "idwin", "width=400, height=350");	
	
}//idCheck() end


function memberCheck(){ //회원가입 유효성 검사
	  //1)아이디 5~10글자 인지?
	  var tu_id=document.getElementById("tu_id").value;
	  tu_id=tu_id.trim();
	  if(!(tu_id.length>=5 && tu_id.length<=10)){
	    alert("아이디 5~10글자이내 입력해 주세요");
	    document.getElementById("tu_id").focus();
	    return false;
	  }//if end
	
	  //2)비밀번호 5~10글자 인지?
	  var tu_pw=document.getElementById("tu_pw").value;
	  tu_pw=tu_pw.trim();
	  if(!(tu_pw.length>=5 && tu_pw.length<=10)){
	    alert("비밀번호 5~10글자이내 입력해 주세요");
	    document.getElementById("tu_pw").focus();
	    return false;
	  }//if end
	  
	  //3)비밀번호와 비밀번호확인이 서로 일치하는지?
	  var retu_pw=document.getElementById("retu_pw").value;
	  retu_pw=retu_pw.trim();
	  if(tu_pw!=retu_pw){
	    alert("비밀번호 2개를 똑같이 입력해 주세요");
	    document.getElementById("tu_pw").focus();
	    return false;
	  }//if end
	
	  //4)이름 두글자 이상 인지?
	  var tu_name=document.getElementById("tu_name").value;
	  tu_name=tu_name.trim();
	  if(tu_name.length<=1){
	    alert("이름 두글자 이상 입력해 주세요");
	    document.getElementById("tu_name").focus();
	    return false;
	  }//if end  
	  
	  //5)이메일 5글자 인지?
	  var tu_email=document.getElementById("tu_email").value;
	  tu_email=tu_email.trim();
	  if(tu_email.length<5){
	    alert("이메일 5글자 이상 입력해 주세요");
	    document.getElementById("tu_email").focus();
	    return false;
	  }//if end  
	
	  return true;

}//memberCheck() end




function memberWithdraw(){
	  var tu_pw=document.getElementById("tu_pw").value;
	  tu_pw=tu_pw.trim();
	  if(!(tu_pw.length>=5 && tu_pw.length<=10)){
	    alert("비밀번호 5~10글자이내 입력해 주세요");
	    document.getElementById("tu_pw").focus();
	    return false;
	  }//if end
	
	var message="기존의 회원 정보는 모두 삭제됩니다\n계속 진행할까요?";
	if(confirm(message)){
		return true;      
	}else{
		return false;
	}//if end	
}//memberWithdraw() end



function findIDCheck(){ //아이디/비번 찾기 유효성 검사
 	var tu_name=document.getElementById("tu_name").value;
	tu_name=tu_name.trim();
	if(tu_name.length<=1){
	    alert("이름 두글자 이상 입력해 주세요");
	    document.getElementById("tu_name").focus();
	    return false;
	}//if end  
  
    //이메일 5글자 인지?
    var tu_email=document.getElementById("tu_email").value;
    tu_email=tu_email.trim();
    if(tu_email.length<5){
        alert("이메일 5글자 이상 입력해 주세요");
        document.getElementById("tu_email").focus();
        return false;
    }//if end  

    return true;
}//findIDCheck() end



function pdsCheck(){ //포토갤러리 유효성 검사
	//1)이름
	//2)제목
	//3)비밀번호
	
	//4)첨부파일 : 확장명이 이미지 파일(png, jpg, gif)인지 확인하시오
	var filename=document.getElementById("filename").value;
	filename=filename.trim();
	if(filename.length==0){
	    alert("첨부 파일 선택하세요");
	    return false;
	}else{
		//filename변수값에서 마지막 .의 순서 값
		var dot=filename.lastIndexOf(".");
		//확장명 : 마지막 . 이후 문자열 자르기
		var ext=filename.substr(dot+1);
		//확장명을 전부 소문자 치환
		ext=ext.toLowerCase();
		//alert(ext);
		if(ext=="png" || ext=="jpg" || ext=="gif"){
			return true;
		}else{
			alert("이미지 파일만 가능합니다!!");
			return false;
		}//if end
	
	}//if end
	
}//pdsCheck() end





function airpreserCheck() { //로그인 유효성 검사

	//1)여권번호가 M으로 시작하는 8글자인지 체크
    var tar_passcode=document.getElementById("tar_passcode").value;
    tar_passcode=tar_passcode.trim();
    if(tar_passcode.length!=8 && tar_passcode.charAt(0)!='M'){
    	alert("여권번호를 M이 포함된 8글자로 입력하세요");
    	document.getElementById("tar_passcode").focus();
    	return false;
    }//if end

	return true;
	alert("예약성공");
}//airpreserCheck() end








