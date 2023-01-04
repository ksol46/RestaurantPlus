package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.PlusDTO;

public class PlusDAO {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	//데이터 베이스 연결 메소드
	public static Connection getConnection(){
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection
					("jdbc:oracle:thin:@//localhost:1521/xe","test","test1234");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	// 홈 화면 지도에 대한 데이터 리스트 (마커) 불러오기 (상점이 위도, 경도)
	public ArrayList<PlusDTO> getMapList(HttpServletRequest request,HttpServletResponse response) {
		ArrayList<PlusDTO> mapList = new ArrayList<PlusDTO>();
		try {
			conn = getConnection();
			
			String sql = "select c.c_id, r.r_id, r.r_name, r.r_latitude, r.r_longitude";
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
	
	//컨텐츠 내용 보여주는 페이지
	public PlusDTO getView(int c_id) {
		conn = getConnection();
		PlusDTO pd = new PlusDTO();
		
		String sql = " select r.r_name, to_char(c.c_date, 'yyyy\"년\"mm\"월\"dd\"일\" hh:mi'), r.r_address, r.r_latitude, r.r_longitude, c.c_grade, c.c_text, r.r_id";
		sql += " from rp_contents c, rp_restaurant r";
		sql += " where c.r_id = r.r_id and c.c_id = ?";
		
    	
    	try {
    		ps = conn.prepareStatement(sql);
    		ps.setInt(1, c_id);
        	ResultSet rs = ps.executeQuery(); //쿼리문 실행 -> 데이터 베이스 결과 저장
        	rs.next();
    		
    		
    		pd.setR_name(rs.getString(1));
			pd.setC_date(rs.getString(2));
			pd.setR_address(rs.getString(3));
			pd.setR_latitude(rs.getString(4));
			pd.setR_longitude(rs.getString(5));
			pd.setC_grade(rs.getInt(6));
			pd.setC_text(rs.getString(7));
			pd.setC_id(c_id);
			pd.setR_id(rs.getInt(8));
			
			ps.executeQuery();
		
			conn.close();
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return pd;
	}
	
	//r_id 자동증가
	public int nextInsertR_id (HttpServletRequest request) {
		int r_id = 0;
		try {
			conn = getConnection();
			String sql = "select max(r_id)+1 r_id from rp_restaurant";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			
			
			if(rs.next()) r_id = rs.getInt(1);
			
			conn.close();
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r_id;
	}
	
	//c_id 자동증가
	public int nextInsertC_id (HttpServletRequest request) {
		int c_id = 0;
		try {
			conn = getConnection();
			String sql = "select max(c_id)+1 c_id from rp_contents";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			
			
			if(rs.next()) c_id = rs.getInt(1);
			
			conn.close();
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c_id;
	}
	
	//글 작성
	public void insert_c (int cid, int rid, int c_grade, String c_text) {
		conn = getConnection();
		
		String sql = " insert into rp_contents values (?, 100, ?, list_seq.nextval, sysdate, ?, ?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			ps.setInt(2, rid);
    		ps.setInt(3, c_grade);
    		ps.setString(4, c_text);
        	ps.executeUpdate(); //쿼리문 실행 -> 데이터 베이스 결과 저장
        	
        	
        	conn.close();
    		ps.close();
    		rs.close();
        	
		} catch (Exception e) {
			e.printStackTrace();
			
		}		
	} 
	
	
	public void insert_r (int rid, String r_name, String r_address, String r_latitude, String r_longitude ) {
		conn = getConnection();
		
		String sql = "insert into rp_restaurant values (?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
	
			ps.setInt(1, rid);
    		ps.setString(2, r_name);
    		ps.setString(3, r_address);
    		ps.setString(4, r_latitude);
    		ps.setString(5, r_longitude);
        	ps.executeUpdate(); //쿼리문 실행 -> 데이터 베이스 결과 저장
        	
        	
        	conn.close();
    		ps.close();
    		rs.close();
        	
		} catch (Exception e) {
			e.printStackTrace();
			
		}		
	}
	
	
	//글 수정 화면 보여주기
		public PlusDTO getEdit(int c_id) {
			conn = getConnection();
			PlusDTO pd = new PlusDTO();
			
			String sql = " select r.r_name, to_char(c.c_date, 'yyyy\"년\"mm\"월\"dd\"일\" hh:mi'), r.r_address, r.r_latitude, r.r_longitude,  c.c_grade, c.c_text, r.r_id";
			sql += " from rp_contents c, rp_restaurant r";
			sql += " where c.r_id = r.r_id and c.c_id = ?";
			
	    	
	    	try {
	    		ps = conn.prepareStatement(sql);
	    		ps.setInt(1, c_id);
	        	ResultSet rs = ps.executeQuery(); //쿼리문 실행 -> 데이터 베이스 결과 저장
	        	rs.next();
	    		
	    		
	    		pd.setR_name(rs.getString(1));
				pd.setC_date(rs.getString(2));
				pd.setR_address(rs.getString(3));
				pd.setR_latitude(rs.getString(4));
				pd.setR_longitude(rs.getString(5));
				pd.setC_grade(rs.getInt(6));
				pd.setC_text(rs.getString(7));
				pd.setR_id(rs.getInt(8));
				
				ps.executeQuery();
			
				conn.close();
				ps.close();
				rs.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	return pd;
		}
		
	
	//글 수정 해주기 1
	public int update_c (int rid, int c_grade, String c_text) {
		conn = getConnection();
		int result =0 ;
		
		String sql = " update rp_contents";
			   sql+= " set c_grade = ?, c_text = ?";
			   sql+= " where r_id =?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, c_grade);
    		ps.setString(2, c_text);
    		ps.setInt(3 ,rid);
        	result = ps.executeUpdate(); //쿼리문 실행 -> 데이터 베이스 결과 저장
        	
        	
        	conn.close();
    		ps.close();
    		rs.close();
        	
		} catch (Exception e) {
			e.printStackTrace();
			
		}		
		return result;
	} 
	
	//글 수정 해주기 2
	public void update_r (int rid, String r_name, String r_address, String r_latitude, String r_longitude ) {
		conn = getConnection();
		
		String sql = " update rp_restaurant";
		   	   sql+= " set r_name = ?, r_address = ?, r_latitude = ?, r_longitude = ?";
		   	   sql+= " where r_id =?";
		try {
			ps = conn.prepareStatement(sql);
	
    		ps.setString(1, r_name);
    		ps.setString(2, r_address);
    		ps.setString(3, r_latitude);
    		ps.setString(4, r_longitude);
    		ps.setInt(5, rid);
        	ps.executeUpdate(); //쿼리문 실행 -> 데이터 베이스 결과 저장
        	
        	
        	conn.close();
    		ps.close();
    		rs.close();
        	
		} catch (Exception e) {
			e.printStackTrace();
			
		}		
	}
	
	//게시글 삭제 1
	public void delete_c(int rid) {
		conn = getConnection();
		
		String sql = "delete from rp_contents where r_id = ? ";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, rid);
        	ps.executeUpdate(); //쿼리문 실행 -> 데이터 베이스 결과 저장
        	
			conn.close();
    		ps.close();
    		rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//게시글 삭제 2
	public void delete_r(int rid) {
		conn = getConnection();
		
		String sql = "delete from rp_restaurant where r_id = ? ";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, rid);
        	ps.executeUpdate(); //쿼리문 실행 -> 데이터 베이스 결과 저장
        	
			conn.close();
    		ps.close();
    		rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
