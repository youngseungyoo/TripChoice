package net.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Component;
@Component
public class DBClose { //DB연결 자원 반납
    
	public DBClose() {
		System.out.println("------------DBClose 객체 생성");
	}
	
    public static void close(Connection con) {      
        try{
            if(con != null){ con.close(); con=null; }
        }catch(Exception e){}
    }//end

    public static void close(Connection con, PreparedStatement pstmt) {        
        try{
            if(pstmt != null){ pstmt.close(); pstmt=null; }
        }catch(Exception e){}
      
        try{
            if(con != null){ con.close(); con=null; }
        }catch(Exception e){}
    }//end
    
    public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
        try{
            if(rs != null){ rs.close(); rs=null; }
        }catch(Exception e){}
        
        try{
            if(pstmt != null){ pstmt.close(); pstmt=null; }
        }catch(Exception e){}
      
        try{
            if(con != null){ con.close(); con=null; }
        }catch(Exception e){}
    }//end
    
}//class end
