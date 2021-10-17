$("#item").on('click',function() {
    alert('잡히긴 한겅미?');
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