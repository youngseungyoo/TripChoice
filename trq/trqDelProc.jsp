<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>
<%@ include file="../header.jsp" %>
    
<!-- 본문 시작 trqDelProc.jsp-->
<h3>문의사항 삭제</h3>
<%
	int trq_no=Integer.parseInt(request.getParameter("trq_no"));
	
	
	dto.setTrq_no(trq_no);
	
	
	int cnt=dao.delete(trq_no);
	if(cnt==0){
	    out.println("<p>비밀번호가 일치하지 않습니다</p>");
	    out.println("<p><a href='javascript:history.back()'>[다시시도]</a></p>");
	}else{
	    out.println("<script>");
	    out.println("  alert('게시글이 삭제되었습니다');");
	    out.println("  location.href='trqList.jsp'");
	    out.println("</script>");
	}//if end	
%>
<!-- 본문 끝-->
        
<%@ include file="../footer.jsp" %>  