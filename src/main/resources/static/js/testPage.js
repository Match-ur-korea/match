const swiper = new Swiper('.swiper', {
 touchRatio: 0,
});
   var id;
   $("#n1").click(function(){
        id="1";
        swiper.slideTo(1,1000);
   })
   $("#n2").click(function(){
        id="2";
        swiper.slideTo(1,1000);
   })
   $("#n3").click(function(){
        id+="3";
        swiper.slideTo(2,1000);
   })
   $("#n4").click(function(){
        id+="4";
         swiper.slideTo(2,1000);
   })
   $("#n5").click(function(){
        id+="5";
        swiper.slideTo(3,1000);
   })
   $("#n6").click(function(){
         id+="6";
         swiper.slideTo(3,1000);
   })

   $("#n7").click(function(){
        document.getElementById('select').value = id;
        swiper.slideTo(4,1000);
   })
   //원하는 지역이 있다고 선택한 경우
     $('.local').click(function(){
        //클릭된 버튼의 id 값을 알아내서 form 태그 값으로 저장
         var id_check = $(this).attr("id");
         document.getElementById('select_local').value = id_check;
         swiper.slideTo(5,1000);
     });
   // 원하는 지역이 없다고 선택한 경우
   $("#n8").click(function(){
        //1~18까지의 랜덤값을 생성해서 form 태그 값으로 저장
         document.getElementById('select').value = id;
        var id_check =Math.floor(Math.random()*7)+1;
        document.getElementById('select_local').value = id_check;
      swiper.slideTo(5,1000);
   })