<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="map_wrap">
		<div id="map"
			style="width: 700px; height: 400px; display: inline-block;"></div>

		<script type="text/javascript"
			src="//dapi.kakao.com/v2/maps/sdk.js?appkey=07363c0dc0bf7d6b8e3a7ced482a5de9"></script>
		<script>
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
			mapOption = {
				center : new kakao.maps.LatLng(37.5021576, 127.0243763), // 지도의 중심좌표, 이젠 아이티 강남 학원
				level : 3
			// 지도의 확대 레벨
			};

			var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

			//지도를 클릭했을때 클릭한 위치에 마커를 추가하도록 지도에 클릭이벤트를 등록합니다
			kakao.maps.event.addListener(map, 'click', function(mouseEvent) {
				// 클릭한 위치에 마커를 표시합니다 
				addMarker(mouseEvent.latLng);
			});

			//지도에 표시된 마커 객체를 가지고 있을 배열입니다
			var markers = [];

			//마커 하나를 지도위에 표시합니다 
			addMarker(new kakao.maps.LatLng(37.5021576, 127.0243763));

			//마커를 생성하고 지도위에 표시하는 함수입니다
			function addMarker(position) {
				// 마커를 생성합니다
				var marker = new kakao.maps.Marker({
					position : position
				});
				
				//alert("선택하신 장소의 위도는 " + position.Ma + " 입니다.");
				//alert("선택하신 장소의 경도는 " + position.La + " 입니다.");

				// 마커가 지도 위에 표시되도록 설정합니다
				marker.setMap(map);
				
				var iwContent = '<div style="padding:1px;">'+'위도는: '+position.Ma.toFixed(4)+'<br>'+'경도는: '+position.La.toFixed(4)+'</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
			    iwPosition = new kakao.maps.LatLng(37.5021576, 127.0243763), //인포윈도우 표시 위치입니다
			    iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다
			    

				// 생성된 마커를 배열에 추가합니다
				markers.push(marker);
				
				// 인포윈도우를 생성합니다
				var infowindow = new kakao.maps.InfoWindow({
				    position : iwPosition, 
				    content : iwContent 
				});
				  
				// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
				infowindow.open(map, marker); 
				
			}
			
			

			//배열에 추가된 마커들을 지도에 표시하거나 삭제하는 함수입니다
			function setMarkers(map) {
				for (var i = 0; i < markers.length; i++) {
					markers[i].setMap(map);
				}
			}

		</script>
	</div>
</body>
</html>