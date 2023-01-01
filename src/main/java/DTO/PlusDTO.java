package DTO;

public class PlusDTO {
	private int u_id;
	private String u_name;
	private int c_id;
	private int r_id;
	private int c_no;
	private String c_date;
	private int c_grade;
	private String c_text;
	private String r_name;
	private String r_address;
	private String r_latitude;
	private String r_longitude;
	
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public String getC_date() {
		return c_date;
	}
	public void setC_date(String c_date) {
		this.c_date = c_date;
	}
	public int getC_grade() {
		return c_grade;
	}
	public void setC_grade(int c_grade) {
		this.c_grade = c_grade;
	}
	public String getC_text() {
		return c_text;
	}
	public void setC_text(String c_text) {
		this.c_text = c_text;
	}
	public String getR_name() {
		return r_name;
	}
	public void setR_name(String r_name) {
		this.r_name = r_name;
	}
	public String getR_address() {
		return r_address;
	}
	public void setR_address(String r_address) {
		this.r_address = r_address;
	}
	public String getR_latitude() {
		return r_latitude;
	}
	public void setR_latitude(String r_latitude) {
		this.r_latitude = r_latitude;
	}
	public String getR_longitude() {
		return r_longitude;
	}
	public void setR_longitude(String r_longitude) {
		this.r_longitude = r_longitude;
	}
	
	
	@Override
	public String toString() {
		return 
				 u_id+
				 u_name+
				 c_id+
				r_id+
				c_no+
				 c_date+
				 c_grade+
				c_text+
				 r_name+
				 r_address+
				 r_latitude+
				 r_longitude
				;
	}
	

}
