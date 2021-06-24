package net.utility;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Component;

@Component
public class DBOpen {
	
	public DBOpen() {
		System.out.println("----------DBOpen() 객체 생성됨");
	}
	
    //데이터베이스 연결 메소드
    public Connection getConnection() {
        
        Connection con=null;
        
        try{
        	String url     ="jdbc:mariadb://127.0.0.1:3306/tripChoice";
            String user    ="root";
            String password="dudtmd97";
            String driver  ="org.mariadb.jdbc.Driver";
              
            Class.forName(driver);                    
            con=DriverManager.getConnection(url, user, password);
        }catch (Exception e) {
            System.out.println("DB연결실패:"+e);
        }//end
        
        return con;
        
    }//getConnetion() end
    
}//class end
