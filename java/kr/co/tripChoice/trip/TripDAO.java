package kr.co.tripChoice.trip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import net.utility.DBClose;
import net.utility.DBOpen;

@Controller
public class TripDAO {
		
	@Autowired  //@Component 어노테이션으로 자동 생성된 객체를 사용하려면 객체간 서로 연결이 되어야 한다. 
	private DBOpen dbOpen;
	
	@Autowired
    private DBClose dbClose;	
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	StringBuilder sql=null;
	ArrayList<TripDTO> list=null;
		
	public TripDAO() {
		System.out.println("=== TripDAO() 객체가 생성 되었습니다. ===");
	}//end
	
	public int insert(TripDTO dto) {
        int cnt=0;
        try {
          con=dbOpen.getConnection();
          sql=new StringBuilder();
          sql.append(" INSERT INTO trip (trip_code,trip_area,trip_name,trip_content,trip_cost1,trip_cost2,trip_cost3,trip_possible,trip_airpcost,trip_bedcost,trip_situation) ");
          sql.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?) ) ");      
          
          	pstmt=con.prepareStatement(sql.toString());
          	pstmt.setString(1, dto.getTrip_code());
		  	pstmt.setString(2, dto.getTrip_area());
		  	pstmt.setString(3, dto.getTrip_name());
		    pstmt.setString(4, dto.getTrip_content());
			pstmt.setString(5, dto.getTrip_cost1());
			pstmt.setString(6, dto.getTrip_cost2());
			pstmt.setString(7, dto.getTrip_cost3());
			pstmt.setString(8, dto.getTrip_possible());
			pstmt.setString(9, dto.getTrip_airpcost());
			pstmt.setString(10, dto.getTrip_bedcost());
			pstmt.setString(11, dto.getTrip_situation());
          cnt=pstmt.executeUpdate();
        }catch (Exception e) {
          System.out.println("추가실패:"+e);
        }finally {
          DBClose.close(con, pstmt);
        }// end
        return cnt;
    }//insert () end    
	
	
	
	
	
	public ArrayList<TripDTO> list(int trip_no) {
		try {
			con=dbOpen.getConnection();
			sql=new StringBuilder();
			sql.append(" SELECT trip_no,trip_code,trip_area,trip_name,trip_content,trip_cost1,trip_cost2,trip_cost3,trip_possible,trip_airpcost,trip_bedcost,trip_situation ");
			sql.append(" FROM trip");
			sql.append(" WHERE trip_no =? ");
			sql.append(" ORDER BY trip_no ");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, trip_no);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<TripDTO>();
				do {
					TripDTO dto=new TripDTO();
					dto.setTrip_no(rs.getInt("trip_no"));
					dto.setTrip_code(rs.getString("trip_code"));
					dto.setTrip_area(rs.getString("trip_area"));
					dto.setTrip_name(rs.getString("trip_name"));
					dto.setTrip_content(rs.getString("trip_content"));
					dto.setTrip_cost1(rs.getString("trip_cost1"));
					dto.setTrip_cost2(rs.getString("trip_cost2"));
					dto.setTrip_cost3(rs.getString("trip_cost3"));
					dto.setTrip_possible(rs.getString("trip_possible"));
					dto.setTrip_airpcost(rs.getString("trip_airpcost"));
					dto.setTrip_bedcost(rs.getString("trip_bedcost"));
					dto.setTrip_situation(rs.getString("trip_situation"));
					list.add(dto);
				}while(rs.next());
			}else {
				list=null;
			}//if end
		
		}catch(Exception e) {
			System.out.println("여행상품 목록실패 : "+e);
		}finally {
			DBClose.close(con, pstmt, rs);
		}
		return list;
		
	}// list() end
	
	
	
	public int create(TripDTO dto) {
		int cnt = 0;
		try {
			con = dbOpen.getConnection();
			sql = new StringBuilder();
			sql.append("INSERT INTO trip( trip_code,trip_area,trip_name,trip_content,trip_cost1,trip_cost2,trip_cost3,trip_possible,trip_airpcost,trip_bedcost,trip_situation )");
			sql.append(" VALUES( ?,?,?,?,?,?,?,?,?,?,? )");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getTrip_code());
			pstmt.setString(2, dto.getTrip_area());
			pstmt.setString(3, dto.getTrip_name());
			pstmt.setString(4, dto.getTrip_content());
			pstmt.setString(5, dto.getTrip_cost1());
			pstmt.setString(6, dto.getTrip_cost2());
			pstmt.setString(7, dto.getTrip_cost3());
			pstmt.setString(8, dto.getTrip_possible());
			pstmt.setString(9, dto.getTrip_airpcost());
			pstmt.setString(10, dto.getTrip_bedcost());
			pstmt.setString(11, dto.getTrip_situation());
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("여행상품 등록실패 :" +e);
		}finally {
			DBClose.close(con, pstmt);
		}//end
		return cnt;
	}//create() end
	
	
	
	
	public int delete(int trip_no) {
		int cnt = 0;
		try {
			con = dbOpen.getConnection();
			sql = new StringBuilder();
			sql.append(" DELETE FROM trip ");
			sql.append(" WHERE trip_no =?  ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, trip_no);
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("여행목록 삭제 실패:"+e);
		}finally {
			DBClose.close(con, pstmt);
		}//end
		return cnt;
	}//delete() end
	
	public int update(TripDTO dto) {
		int cnt = 0;
		try {
			con = dbOpen.getConnection();
			sql = new StringBuilder();
			sql.append(" UPDATE trip ");
			sql.append(" SET trip_no=?, trip_code=? ,trip_area=?, trip_name=?,trip_content=?,trip_cost1=?,trip_cost2=?,trip_cost3=?,trip_possible=?,trip_airpcost=?,trip_bedcost=?,trip_situation=?");
			sql.append(" WHERE trip_no =? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, dto.getTrip_no());
			pstmt.setString(2, dto.getTrip_code());
			pstmt.setString(3, dto.getTrip_area());
			pstmt.setString(4, dto.getTrip_name());
			pstmt.setString(5, dto.getTrip_content());
			pstmt.setString(6, dto.getTrip_cost1());
			pstmt.setString(7, dto.getTrip_cost2());
			pstmt.setString(8, dto.getTrip_cost3());
			pstmt.setString(9, dto.getTrip_possible());
			pstmt.setString(10, dto.getTrip_airpcost());
			pstmt.setString(11, dto.getTrip_bedcost());
			pstmt.setString(12, dto.getTrip_situation());
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("여행상품 수정 실패:"+e);
		}finally {
			DBClose.close(con, pstmt);
		}//end
		return cnt;
	}//update() end
	
	public TripDTO read(int trip_no){ 
		TripDTO dto=null;
		try {
			con = dbOpen.getConnection();
			sql = new StringBuilder();
			sql.append(" SELECT trio_no,trip_code,trip_area,trip_name,trip_content,trip_cost1,trip_cost2,trip_cost3,trip_possible,trip_airpcost,trip_bedcost,trip_situation ");
			sql.append(" FROM trip ");
			sql.append(" WHERE trip_no =? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, trip_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto=new TripDTO();
				dto.setTrip_no(rs.getInt("trip_no"));
				dto.setTrip_code(rs.getString("trip_code"));
				dto.setTrip_area(rs.getString("trip_area"));
				dto.setTrip_name(rs.getString("trip_name"));
				dto.setTrip_content(rs.getString("trip_content"));
				dto.setTrip_cost1(rs.getString("trip_cost1"));
				dto.setTrip_cost2(rs.getString("trip_cost2"));
				dto.setTrip_cost3(rs.getString("trip_cost3"));
				dto.setTrip_possible(rs.getString("trip_possible"));
				dto.setTrip_airpcost(rs.getString("trip_airpcost"));
				dto.setTrip_bedcost(rs.getString("trip_bedcost"));
				dto.setTrip_situation(rs.getString("trip_situation"));
			}//if end
		}catch(Exception e) {
			System.out.println("여행상품 상세보기 실패:"+e);
		}finally {
			DBClose.close(con, pstmt, rs);
		}//end
		return dto;
	}//read() end 
	
	 public int updateproc(TripDTO dto) {
	        int cnt=0;
	        try {
	            con=dbOpen.getConnection();
	            sql=new StringBuilder();
	            sql.append(" UPDATE trip ");
	            sql.append(" SET trip_code=? ");
	            sql.append(" ,trip_area=? ");
	            sql.append(" ,trip_name=? ");
	            sql.append(" ,trip_content=? ");
	            sql.append(" ,trip_cost1=? ");
	            sql.append(" ,trip_cost2=? ");
	            sql.append(" ,trip_cost3=? ");
	            sql.append(" ,trip_possible=? ");
	            sql.append(" ,trip_airpcost=? ");
	            sql.append(" ,trip_bedcost=? ");
	            sql.append(" ,trip_situation=? ");
	            sql.append(" WHERE trip_code=?  ");
	            pstmt=con.prepareStatement(sql.toString());
	            pstmt.setString(1, dto.getTrip_code());
	            pstmt.setString(2, dto.getTrip_area());
	            pstmt.setString(3, dto.getTrip_name());
	            pstmt.setString(4, dto.getTrip_content());
	            pstmt.setString(5, dto.getTrip_cost1());
	            pstmt.setString(5, dto.getTrip_cost2());
	            pstmt.setString(5, dto.getTrip_cost3());
	            pstmt.setString(6, dto.getTrip_possible());
	            pstmt.setString(7, dto.getTrip_airpcost());
	            pstmt.setString(8, dto.getTrip_bedcost());
	            pstmt.setString(9, dto.getTrip_situation());
	            cnt=pstmt.executeUpdate();
	        }catch (Exception e) {
	            System.out.println("여행상품 수정 실패:"+e);
	        }finally {
	            DBClose.close(con, pstmt);
	        }//end    
	        return cnt;
	    }//updateproc() end
	
}//class()end
