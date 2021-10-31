$(function (){
    $("#toggle").click(function (){
        $("#slideToggleBox").toggle();
    });
});
// $.ajax({
//     method:"GET",
//     url:"http://api.vicontentIdsitkorea.or.kr/openapi/service/rest/KorService/detailIntro?ServiceKey=+key",
//     data:{"contentId":contentid,
//             "defaultYN":Y,
//             "firstImageYN":Y,
//             "areacodeYN":Y,
//             "catcodeYN":Y,
//             "addrinfoYN":Y,
//             "mapinfoYN":Y,
//             "overviewYN":Y,
//             "transGuideYN":Y,
//             "MobileOS":ETC,
//             "MobileApp":MatchUrKorea,
//             "_type":json},
//     dataType : "json",
//     },
// )

// $(document).ready(function(){
//     var zindex = 10;
//
//     $("div.card").click(function(e){
//         e.preventDefault();
//
//         var isShowing = false;
//
//         if ($(this).hasClass("show")) {
//             isShowing = true
//         }
//
//         if ($("div.cards").hasClass("showing")) {
//             // a card is already in view
//             $("div.card.show")
//                 .removeClass("show");
//
//             if (isShowing) {
//                 // this card was showing - reset the grid
//                 $("div.cards")
//                     .removeClass("showing");
//             } else {
//                 // this card isn't showing - get in with it
//                 $(this)
//                     .css({zIndex: zindex})
//                     .addClass("show");
//
//             }
//
//             zindex++;
//
//         } else {
//             // no cards in view
//             $("div.cards")
//                 .addClass("showing");
//             $(this)
//                 .css({zIndex:zindex})
//                 .addClass("show");
//
//             zindex++;
//         }
//
//     });
// });