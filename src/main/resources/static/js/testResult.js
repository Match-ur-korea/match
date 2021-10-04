if(localStorage.getItem('character'))
{
    var id = localStorage.getItem('character')
}

$(document).ready(function(){
		$.ajax({
	 		type: "GET",
	 		url : "/testResult?selectId=135&local=10",
	 		dataType: "json",
			success: function(data){
	 		        $(data).find('spotList').each(function(){
	 		            console.log($(this).find("title").text())
	 		        })
	 		},
	 		error: function(data){
       		     console.log("1")
			}
	  })
});

// 마커를 표시할 위치와 title 객체 배열입니다
var positions = [];
/*
for(var i=0;i<Object.keys(spots).length;i++){
    var content={
        title: '${spotList[i].title}',
        latlng: new kakao.maps.LatLng('${spotList[i].mapy}','${spotList[i].mapy}')
        /*addr1: spot.addr1
        detail:"추가"
        tel:"추가"
    }
    positions.push(content);
};
*/
var mapContainer = document.getElementById('map'), // 지도를 표시할 div
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다



// 마커 이미지의 이미지 주소입니다
var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

for (var i = 0; i < positions.length; i ++) {

    // 마커 이미지의 이미지 크기 입니다
    var imageSize = new kakao.maps.Size(24, 35);

    // 마커 이미지를 생성합니다
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position: positions[i].latlng, // 마커를 표시할 위치
        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
        image : markerImage // 마커 이미지
    })
}