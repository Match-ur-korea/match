const swiper = new Swiper('.swiper', {
 touchRatio: 0,
});

   $("#n1").click(function(){
        //var index = $(this).index();
        swiper.slideTo(1,1000);
   })
   $("#n2").click(function(){
        swiper.slideTo(1,1000);
   })
   $("#n3").click(function(){
        //var index = $(this).index();
        swiper.slideTo(2,1000);
   })
   $("#n4").click(function(){
         swiper.slideTo(2,1000);
   })
   $("#n5").click(function(){
        //var index = $(this).index();
        swiper.slideTo(3,1000);
   })
   $("#n6").click(function(){
         swiper.slideTo(3,1000);
   })
   $("#n7").click(function(){
        //마지막 페이지에선 자신의 id(=결과)를 따로 저장해준다.
        //var index = $(this).index();
        swiper.slideTo(4,1000);
   })
   $("#n8").click(function(){
      //마지막 페이지에선 자신의 id(=결과)를 따로 저장해준다.
      swiper.slideTo(4,1000);
   })
