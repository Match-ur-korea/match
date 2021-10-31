function button1_click(clicked_id) {
    console.log(clicked_id);
    document.getElementById('select_local').value = clicked_id;
    document.getElementById("submit").click();
}