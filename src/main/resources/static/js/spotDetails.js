function openImg(imgId) {
    if( appYn == 'Y') {
        location.href = "opentab://"+mainurl+'/common/image_viewer.do?imgId='+imgId;
    } else {
        var imgObj = new Image();
        imgObj.src = mainimgurl + imgId;
        setTimeout(function(){
            imageWin = window.open("", "profile_popup", "width=" + imgObj.width + "px, height=" + imgObj.height + "px");
            imageWin.document.write("<html><body style='margin:0; overflow-x:hidden; overflow-y:hidden;'>");
            imageWin.document.write("<a href=javascript:window.close()><img src='" + imgObj.src + "' border=0></a>");
            imageWin.document.write("</body><html>");
            imageWin.document.title = "Image Viewer";
        }, 100);
    }
}