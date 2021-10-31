if(localStorage.getItem('character'))
{
    var id = localStorage.getItem('character')
}
//테스트 이미지 변경하기
var select_character=document.getElementById('characterType').innerText
var characterImg_arr=["img/testResult/캐릭2.png","img/testResult/캐릭6.png","img/testResult/캐릭4.png","img/testResult/캐릭7.png","img/testResult/캐릭1.png","img/testResult/캐릭5.png","img/testResult/캐릭8.png","img/testResult/캐릭3.png"];
var characterType_arr=["나른한 도시 여행자","물아일체 자연인","실속형 관광객","용감한 탐험가","유유자적 선비","자연친화 지식인","지치지 않는 에너자이저","체험학습형 플레이어"]
var goodType_arr=["img/testResult/캐릭4-4.png","img/testResult/캐릭2-2.png","img/testResult/캐릭2-2.png","img/testResult/캐릭3-3.png","img/testResult/캐릭3-3.png","img/testResult/캐릭1-1.png","img/testResult/캐릭4-4.png","img/testResult/캐릭1-1.png"]
var badType_arr=["img/testResult/캐릭7-7.png","img/testResult/캐릭3-3.png","img/testResult/캐릭5-5.png","img/testResult/캐릭2-2.png","img/testResult/캐릭8-8.png","img/testResult/캐릭4-4.png","img/testResult/캐릭1-1.png","img/testResult/캐릭6-6.png"]

for(var i=0;i<8;i++){
    if(characterType_arr[i]==select_character){
        document.getElementById('characterImg').src=characterImg_arr[i];
        document.getElementById('goodTypeImg').src=goodType_arr[i];
        document.getElementById('badTypeImg').src=badType_arr[i];
        break;
    }
}

var characterImg=document.getElementById('characterImg');
characterImg.src
//지역 이름 추가하기
var local_name=document.getElementById('local').innerText;

if(local_name==1)
document.getElementById('local').innerText="서울";
else if(local_name==2)
document.getElementById('local').innerText="인천";
else if(local_name==3)
document.getElementById('local').innerText="대전";
else if(local_name==4)
document.getElementById('local').innerText="대구";
else if(local_name==5)
document.getElementById('local').innerText="광주";
else if(local_name==6)
document.getElementById('local').innerText="부산";
else if(local_name==7)
document.getElementById('local').innerText="울산";
else if(local_name==8)
document.getElementById('local').innerText="세종특별시";
else if(local_name==31)
document.getElementById('local').innerText="경기도";
else if(local_name==32)
document.getElementById('local').innerText="강원도";
else if(local_name==33)
document.getElementById('local').innerText="충청북도";
else if(local_name==34)
document.getElementById('local').innerText="충청남도";
else if(local_name==35)
document.getElementById('local').innerText="경상북도";
else if(local_name==36)
document.getElementById('local').innerText="경상남도";
else if(local_name==37)
document.getElementById('local').innerText="전라북도";
else if(local_name==38)
document.getElementById('local').innerText="전라남도";
else
document.getElementById('local').innerText="제주도";




  var x = [0,126.9751811398,126.6832460000,127.3686912472,128.6205183884,126.9160879510,129.0798725132,129.0561398456,127.2858062335]
  var y=[0,37.6122099878,37.4373973287,36.3674994928,35.9841102996,35.1618648223,35.1851949389,35.6367354352,36.4981108410]
   x[31]=127.1549676193;x[32]=128.6003708453;x[33]=127.4358669978;x[34]=127.1216721795;x[35]=128.4866884526;x[36]=128.5064669527;x[37]=127.1532917977;x[38]=126.4090769892;x[39]=126.5039945305;
   y[31]=37.9941326372;y[32]=38.2133149015;y[33]=36.6278652990;y[34]=36.4529297875;y[35]=36.0863823335;y[36]=34.7671312725;y[37]=35.8170640681;y[38]=35.3997293920;y[39]=33.4889034625;

    var lng=local_name;
    console.log(y[lng]);
   var mapContainer = document.getElementById('map'), // 지도를 표시할 div
    mapOption = {
        center: new kakao.maps.LatLng(y[lng],x[lng]), // 지도의 중심좌표
        level: 10 // 지도의 확대 레벨
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
        image : markerImage,// 마커 이미지
        clickable: true
    })
    // 인포윈도우를 생성합니다
    var infowindow = new kakao.maps.InfoWindow({
        content : positions[i].title+'^'+positions[i].addr+'^'+positions[i].image+'^'+positions[i].id
    });

    // 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다

    // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
    // 이벤트 리스너로는 클로저를 만들어 등록합니다
    // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
    kakao.maps.event.addListener(marker, 'click',  makeTitle(map,marker,infowindow));

}
var arr= new Array();

function makeTitle(map, marker,infowindow){
  return function() {
      document.getElementById("back_top").style="block";
      document.getElementById("course_btn").style="block";
      arr[0]="";
      arr[1]="";
      arr[2]="";
      arr[3]="";
       //TODO 클릭된 마커 색깔 변경
      //infowindow.open(map,marker);
      var contents=infowindow.getContent();
      var cnt=0;
      for(var j=0;j<contents.length;j++){
         if(contents[j]=='^'){
           cnt++;
           continue;
          }
         arr[cnt]+=contents[j];
        }


      const title = document.getElementById("title12");
      title.innerText =arr[0];
      const addr = document.getElementById("addr");
      addr.innerText =arr[1];
      const img = document.getElementById("back_top");
      img.src = arr[2];
      const contenId = document.getElementById("content_id");
      contenId.value=arr[3];

     //TODO 상세설명 추가하기
       const des = document.getElementById("des");
       document.getElementById("des").style.fontSize = '0.6rem';

     des.innerText = "자세한 내용은 [나의 여행코스]에서 확인하세요!"
     // $("#relo").load(location.href+" #relo>*");
    };
}

//선택 버튼 클릭시
var src_arr=[]
var contenId_arr=["","","","","",""]
$("#course_btn").click(function(){
       var isCheck=0;
       for(var i=1;i<6;i++){
            var cur=i.toString();
            const s = document.getElementById(cur);
            var ix=i+5;
            ix.toString();
            var sel =document.getElementById(ix).innerText
            //TODO 나중에 링크 이름 바꿔야 함
            if(sel=="1"){
                for(var j=1;j<6;j++){
                     if(src_arr[j]==arr[2]){
                          isCheck=1;
                          break;
                     }
                }
                if(isCheck){
                alert("이미 선택한 장소입니다.");
                    break;
                }
                 document.getElementById(ix).innerText="0";
                 s.src=arr[2];
                 src_arr[i]=arr[2];
                 contenId_arr[i]=arr[3];
                 //삭제 버튼
                 var delete_btn=i+10;
                 document.getElementById(delete_btn).style="block";
                 break;
            }
        }
})
//TODO 5개 선택 안 하면 여행 못하게 하기
$("#select_btn").click(function(){
    document.getElementById('c1').value = contenId_arr[1]
    document.getElementById('c2').value = contenId_arr[2]
    document.getElementById('c3').value = contenId_arr[3]
    document.getElementById('c4').value = contenId_arr[4]
    document.getElementById('c5').value = contenId_arr[5]
})
//삭제 버튼 클릭시
$("#11").click(function(){
    document.getElementById("6").innerText="1"
    delete_btn("1",1)
})
$("#12").click(function(){
    document.getElementById("7").innerText="1"
    delete_btn("2",2)
})
$("#13").click(function(){
    document.getElementById("8").innerText="1"
    delete_btn("3",3)

})
$("#14").click(function(){
    document.getElementById("9").innerText="1"
    delete_btn("4",4)

})
$("#15").click(function(){
    document.getElementById("10").innerText="1"
    delete_btn("5",5)

})
function delete_btn(btn,num) {
var select_characterImg_arr=["0","img/testResult/캐릭5.png","img/testResult/캐릭1.png","img/testResult/캐릭2.png","img/testResult/캐릭3.png","img/testResult/캐릭4.png"];
    var s = document.getElementById(btn);
     //TODO 나중에 링크 이름 바꿔야 함
     var cnt=0;
     for(var i=1;i<=5;i++){
        var cur=i+5;
        if(document.getElementById(cur).innerText=="0")
            cnt++;
     }
    console.log(cnt);
    for(var i=num+1;i<=5;i++){
        var cur=i.toString();
        var s2=document.getElementById(cur);
         s.src=s2.src
         s=s2;
    }
    for(var i=1;i<=cnt;i++){
        var id=i+5;
        document.getElementById(id.toString()).innerText="0"
        src_arr[i]=document.getElementById(i.toString()).src;
        console.log(src_arr[i]);
    }
    for(var i=cnt+1;i<=5;i++){
        var id=i+5;
        document.getElementById(i.toString()).src=select_characterImg_arr[i];
        document.getElementById(id.toString()).innerText="1"
        src_arr[i]="";
        var idx=i+10;
        document.getElementById(idx.toString()).style.display="none"
        contenId_arr[i]="";
    }
}
//제출 버튼 클릭시

//TODO 삭제 버튼 만들기

// 제출 버튼 클릭시 CONTENT내용 넘어가도록 하기
//세부 내용 추가하기