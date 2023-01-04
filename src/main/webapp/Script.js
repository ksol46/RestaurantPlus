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
		alert("위도를 입력해주세요.");
		return false;
	}
	
	if(f.r_latitude.value ==''){ //값이 없으면
		alert("경도를 입력해주세요.");
		return false;
	}
	
	if(f.c_grade.value ==''){ //값이 없으면
		alert("평점을 입력해주세요.");
		return false;
	}
	
	if(f.c_coment.value ==''){ //값이 없으면
		alert("코멘트를 입력해주세요.");
		return false;
	}
	
	alert("작성이 완료 되었습니다.");
	
	f.submit(); //폼태그 전송
	
	}
	
function editForm(){
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
		alert("위도를 입력해주세요.");
		return false;
	}
	
	if(f.r_latitude.value ==''){ //값이 없으면
		alert("경도를 입력해주세요.");
		return false;
	}
	
	if(f.c_grade.value ==''){ //값이 없으면
		alert("평점을 입력해주세요.");
		return false;
	}
	
	if(f.c_coment.value ==''){ //값이 없으면
		alert("코멘트를 입력해주세요.");
		return false;
	}
	
	alert("수정이 완료 되었습니다.");

	f.submit(); //폼태그 전송
	
	}

	function chkDelete(r_id) {
		const result = confirm("삭제하시겠습니까?");
		
		if(result) {
			const url = location.origin; //'http://localhost:8082'
			
			location.href = url + "/RestaurantPlus/delete?r_id=" + r_id; //페이지 이동
				
			} else {
				return false;
			}
		}