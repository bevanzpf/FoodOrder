// var updateCar = function(){
//     var num = $(".num").children("span").text();
//     var num1 = Number(num)+1;
//     $(".num").fadeOut(300);
//     //alert(num1);
//     //setTimeout(updateCar, 3000);
//     $(".num").children("span").text(num1);
//     $(".num").fadeIn(300);
// };

var getByAjax = function(urll){
    //var urll = $(this).find(".add").children("#link").attr("href");
    //alert(urll);
    $.get({
        //type: "GET",
        //url: "/addDish2Car.action",
        url: urll,
        //data:"id=1",
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