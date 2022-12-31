package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.keyvalue.AbstractMapEntryDecorator;

import DTO.PlusDTO;

public class PlusDAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	//데이터 베이스 연결 메소드
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@//localhost:1521/xe","system","sys1234");
		return con;
	}

	// 홈 화면 지도에 대한 데이터 리스트 (마커) 불러오기 (상점이 위도, 경도)
	public ArrayList<PlusDTO> getMapList(HttpServletRequest request,HttpServletResponse response) {
		ArrayList<PlusDTO> mapList = new ArrayList<PlusDTO>();
		// 리소스 자동 닫기
		try {
			conn = getConnection();
			
			String sql = " select c.c_id, r.r_id, r.r_name, r.r_latitude, r.r_longitude";
			sql += " from rp_contents c, rp_restaurant r";
			sql += " where c.r_id = r.r_id";
			
			ps = conn.prepareStatement(sql); //쿼리문 실행 준비
			rs = ps.executeQuery(); //쿼리문 실행
			
			while (rs.next()) {
				PlusDTO map = new PlusDTO();
				map.setC_id(rs.getInt(1));
				map.setR_id(rs.getInt(2));
				map.setR_name(rs.getString(3));
				map.setR_latitude(rs.getString(4));
				map.setR_longitude(rs.getString(5));
				
				mapList.add(map);
				
			}
			
			request.setAttribute("mapList", mapList);
			
			conn.close();
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapList;
	}

}
