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
        console.log(id);
        //마지막 페이지에선 자신의 id(=결과)를 따로 저장해준다.
        // 지금까지 선택한 값을 form 태그 value에 저장
        document.getElementById('select').value = id;
        swiper.slideTo(4,1000);
   })
     $(".local").click(function(){
            document.getElementById('select_local').value = id;
            swiper.slideTo(5,1000);
      })
   $("#n8").click(function(){
        console.log(id);
        //마지막 페이지에선 자신의 id(=결과)를 따로 저장해준다.
        //마지막 페이지에선 자신의 id(=결과)를 따로 저장해준다.
        document.getElementById('select').value = id;
      swiper.slideTo(5,1000);
   })
