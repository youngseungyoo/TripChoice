<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../header.jsp" %>

<head> <script src="https://cdn.ckeditor.com/ckeditor5/11.0.1/classic/ckeditor.js"></script> </head>


<!-- mailForm.jsp 시작 -->
	<h2 align="center"> 메일 보내기 </h2>
	<form method="post" action="mailProc.jsp" >
<table class="table" arign="center">
<tr>
    <th>받는사람</th>
	<td><input type="email" name="to"></td>
</tr>
<tr>
    <th>보내는사람</th>
	<td><input type="email" name="from"></td>
</tr>
 <tr>
   <th>제목</th>
   <td><input type="text" name="subject"></td>
 </tr>
 <tr>
   <th>내용</th>
   <td><textarea rows="20" cols="30"  class="form-control" name="content" id="editor"></textarea>
   	<script>
    	// 3. CKEditor5를 생성할 textarea 지정
    	ClassicEditor
        .create( document.querySelector( '#editor' ) )
        .catch( error => {
            console.error( error );
        } );  
    </script>
   </td>
 </tr>
 <tr>
   <td colspan="2" align="center">
     <input type="submit" value="메일보내기" class="btn btn-success">
     <input type="reset"  value="취소"      class="btn btn-info">
   </td>
 </tr> 
</table>
</form>
	
	
	
	
<!-- mailForm.jsp 끝 -->

<%@ include file="../footer.jsp" %>
