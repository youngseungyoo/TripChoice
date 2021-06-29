package kr.co.tripChoice.tbrq;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import net.utility.DBClose;
import net.utility.DBOpen;

@Controller
public class TbrqDAO {
		
	@Autowired  //@Component 어노테이션으로 자동 생성된 객체를 사용하려면 객체간 서로 연결이 되어야 한다. 
	private DBOpen dbOpen;
	
	@Autowired
    private DBClose dbClose;	
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	StringBuilder sql=null;
	ArrayList<TbrqDTO> list=null;
		
	public TbrqDAO() {
		System.out.println("=== TbrqDAO() 객체가 생성 되었습니다. ===");
	}//end
	
	public int create(TbrqDTO dto) {
		int cnt = 0;
		try {
			con = dbOpen.getConnection();
			sql = new StringBuilder();
			sql.append("INSERT INTO tbrq(  tbrq_sub,tbrq_con,tbrq_cnt,tbrq_date )");
			sql.append(" VALUES( ?,?,?,? )");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, dto.getTbrq_no());
			pstmt.setString(2, dto.getTbrq_sub());
			pstmt.setString(3, dto.getTbrq_con());
			pstmt.setString(4, dto.getTbrq_date());
		
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("자주찾는질문 등록실패 :" +e);
		}finally {
			DBClose.close(con, pstmt);
		}//end
		return cnt;
	}//create() end
	
	
	public ArrayList<TbrqDTO> list(int tbrq_no) {
		try {
			con=dbOpen.getConnection();
			sql=new StringBuilder();
			sql.append(" SELECT tbrq_sub,tbrq_con,tbrq_cnt,tbrq_date ");
			sql.append(" FROM tbrq");
			sql.append(" WHERE tbrq_no =? ");
			sql.append(" ORDER BY tbrq_no ");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, tbrq_no);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<TbrqDTO>();
				do {
					TbrqDTO dto=new TbrqDTO();
					dto.setTbrq_sub(rs.getString("tbrq_sub"));
					dto.setTbrq_con(rs.getString("tbrq_con"));
					dto.setTbrq_date(rs.getString("tbrq_date"));
					
					list.add(dto);
				}while(rs.next());
			}else {
				list=null;
			}//if end
		
		}catch(Exception e) {
			System.out.println("자주찾는질문 목록실패 : "+e);
		}finally {
			DBClose.close(con, pstmt, rs);
		}
		return list;
		
	}// list() end
	
	public int delete(int tbrq_no) {
		int cnt = 0;
		try {
			con = dbOpen.getConnection();
			sql = new StringBuilder();
			sql.append(" DELETE FROM tbrq ");
			sql.append(" WHERE tbrq_no =?  ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, tbrq_no);
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("자주찾는질문 삭제 실패:"+e);
		}finally {
			DBClose.close(con, pstmt);
		}//end
		return cnt;
	}//delete() end
	
	public int update(TbrqDTO dto) {
		int cnt = 0;
		try {
			con = dbOpen.getConnection();
			sql = new StringBuilder();
			sql.append(" UPDATE tbrq ");
			sql.append(" SET tbrq_sub=? , tbrq_con=? ,tbrq_date=? ");
			sql.append(" WHERE tbrq_no =? ");
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setString(1, dto.getTbrq_sub());
			pstmt.setString(2, dto.getTbrq_con());
			pstmt.setString(3, dto.getTbrq_date());
		
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("자주찾는질문 수정 실패:"+e);
		}finally {
			DBClose.close(con, pstmt);
		}//end
		return cnt;
	}//update() end
	
	public TbrqDTO read(int tbrq_no){ 
		TbrqDTO dto=null;
		try {
			con = dbOpen.getConnection();
			sql = new StringBuilder();
			sql.append(" SELECT tbrq_sub,tbrq_con,tbrq_cnt,tbrq_date ");
			sql.append(" FROM tbrq ");
			sql.append(" WHERE tbrq_no =? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, tbrq_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto=new TbrqDTO();
				dto.setTbrq_sub(rs.getString("trip_sub"));
				dto.setTbrq_con(rs.getString("tbrq_con"));
				dto.setTbrq_date(rs.getString("tbrq_date"));
			}//if end
		}catch(Exception e) {
			System.out.println("자주찾는질문 상세보기 실패:"+e);
		}finally {
			DBClose.close(con, pstmt, rs);
		}//end
		return dto;
	}//read() end 
	
	 public void incrementCnt(int trip_no){
	        try{
	            con=dbOpen.getConnection();
	            sql=new StringBuilder();
	            sql.append(" UPDATE trip ");
	            sql.append(" SET readcnt=readcnt+1 ");
	            sql.append(" WHERE trip_no=? ");
	            pstmt=con.prepareStatement(sql.toString());
	            pstmt.setInt(1, trip_no);
	            pstmt.executeUpdate();
	        }catch(Exception e){
	            System.out.println("조회수 증가 실패:"+e);
	        }finally {
	          DBClose.close(con, pstmt);
	        }//end 
	    }//incrementCnt() end    
	
	 public int insert(TbrqDTO dto) {
	        int cnt=0;
	        try {
	          con=dbOpen.getConnection();
	          sql=new StringBuilder();
	          sql.append(" INSERT INTO tbrq ( tbrq_sub,tbrq_con ) ");
	          sql.append(" VALUES ( ?,?) ) ");      
	          
	          pstmt=con.prepareStatement(sql.toString());
	          pstmt.setString(1, dto.getTbrq_sub());
	          pstmt.setString(2, dto.getTbrq_con());
	                   
	        
	          cnt=pstmt.executeUpdate();
	        }catch (Exception e) {
	          System.out.println("추가실패:"+e);
	        }finally {
	          DBClose.close(con, pstmt);
	        }// end
	        return cnt;
	    }//insert () end    
	 
	 
	 public int updateproc(TbrqDTO dto) {
	        int cnt=0;
	        try {
	            con=dbOpen.getConnection();
	            sql=new StringBuilder();
	            sql.append(" UPDATE tbrq ");
	            sql.append(" SET tbrq_sub=? ");
	            sql.append(" ,tbrq_con=? ");
	            sql.append(" WHERE tbrq_no=?  ");
	            pstmt=con.prepareStatement(sql.toString());
	            pstmt.setString(1, dto.getTbrq_sub());
	            pstmt.setString(2, dto.getTbrq_con());
	          
	            cnt=pstmt.executeUpdate();
	        }catch (Exception e) {
	            System.out.println("수정 실패:"+e);
	        }finally {
	            DBClose.close(con, pstmt);
	        }//end    
	        return cnt;
	    }//updateproc() end
	    
	 
	 
}//class()end
