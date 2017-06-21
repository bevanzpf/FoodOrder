

var getByAjax = function(urll){
    $.get({
        url: urll,
        success: function(data){
            var num = $(".num").children("span").text();
            var num1 = Number(num)+1;
            $(".num").fadeOut(300);
            $(".num").children("span").text(num1);
            $(".num").fadeIn(300);
        }
    });
}


$(document).ready(function(){
    $(".add").click(function () {
       var url = $(this).find("#link").attr("href");
        getByAjax(url);
    });
});