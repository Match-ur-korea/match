$(function (){
    $("#toggle").click(function (){
        $("#slideToggleBox").toggle();
    });
});
// TODO Ajax로 상세 정보 잘 뜨는지 확인
$("#item").on('click',function() {

    var contentid = document.getElementById("contentid").value;
    $.ajax({
        url: 'callDetail',
        type: 'get',
        data : {"contentId" : contentid}, //"contentTypeId" : contenttypeid},
        dataType: 'json',
        success: function(data){

            var myItem = data.response.body.items.item;
            var output = '';
            output += '<p>'+myItem.overview+'</p>';

            $('#detail').append(output);
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            alert("Status: " + textStatus); alert("Error: " + errorThrown);
        }
    });
});

$("#item").on('hover',function() {

    $.ajax({
        url: 'callDetail',
        type: 'get',
        data : {"contentId" : contentid}, //"contentTypeId" : contenttypeid},
        dataType: 'json',
        success: function(data){

            var myItem = data.response.body.items.item;
            var output = '';
            output += '<p>'+myItem.overview+'</p>';

            $('#detail').html(output);
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            alert("Status: " + textStatus); alert("Error: " + errorThrown);
        }
    });
});