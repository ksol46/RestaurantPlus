function chkForm(){
	var f = document.frm;
	
	if(f.r_name.value ==''){ //값이 없으면
		alert("상점명을 입력해주세요.");
		return false;
	}
	
	if(f.c_date.value ==''){ //값이 없으면
		alert("작성날짜를 입력해주세요.");
		return false;
	}
	
	if(f.r_address.value ==''){ //값이 없으면
		alert("상점주소를 입력해주세요.");
		return false;
	}
	
	if(f.r_longitude.value ==''){ //값이 없으면
		alert("url 주소창에 나오는 Ma=위도를 입력해주세요.");
		return false;
	}
	
	if(f.r_latitude.value ==''){ //값이 없으면
		alert("url 주소창에 나오는 La=경도를 입력해주세요.");
		return false;
	}
	
	if(f.c_grade.value ==''){ //값이 없으면
		alert("평점을 입력해주세요.");
		return false;
	}
	
	f.submit(); //폼태그 전송
	}