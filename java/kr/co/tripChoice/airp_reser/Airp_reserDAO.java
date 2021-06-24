package kr.co.tripChoice.airp_reser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.tripChoice.t_airp.T_airpDTO;
import kr.co.tripChoice.airp_reser.Airp_reserDTO;
import net.utility.DBClose;
import net.utility.DBOpen;

@Component
public class Airp_reserDAO {
	@Autowired // @componet어노테이션으로 자동 생성된 객체를 사용하려면 객체가 서로 연결이 되어야 한다 이때 쓰는 것
	private DBOpen dbopen;
	@Autowired
	private DBClose dbclose;

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuilder sql = null;
	ArrayList<T_airpDTO> list = null;

	public Airp_reserDAO() {
		System.out.println("---------Trip_reserDAO() 객체 생성");
	}// Airp_reserDAO() end

	public int reser(Airp_reserDTO dto) {
		int cnt = 0;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" INSERT INTO airp_reser(ta_code, tar_seat, tu_id, tar_name, tar_passcode, tar_code) ");
			sql.append(" VALUES (?, ?, ?, ?, ?,?) ");
			pstmt = con.prepareStatement(sql.toString());

			pstmt.setString(1, dto.getTa_code());
			pstmt.setString(2, dto.getTar_seat());
			pstmt.setString(3, dto.getTu_id());
			pstmt.setString(4, dto.getTar_name());
			pstmt.setString(5, dto.getTar_passcode());
			pstmt.setString(6, dto.getTa_code()+dto.getTar_seat());
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("항공권 예약 실패" + e);
		} finally {
			DBClose.close(con, pstmt);
		}
		return cnt;
	}// reser() end
	
	

}// class end
