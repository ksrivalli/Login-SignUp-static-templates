//----WT ASSIGNMENT- 2--------------
// BY : 1602-18-737-049 (MSM SARVANI)  IT-A
//       1602-18-737-050 (K SRIVALLI )  IT-A

function myfunc() {
    let text = document.getElementById("text");
    let bird1 = document.getElementById("bird1");
    let bird2 = document.getElementById("bird2");
    let btn = document.getElementById("btn");
    let rocks = document.getElementById("rocks");
    let forest = document.getElementById("forest");

    let value = window.scrollY;
    text.style.top = 50 + value * -0.3 + '%';
    bird1.style.top = value * -1.5 + 'px';
    bird1.style.left = value * 2 + 'px';
    bird2.style.top = value * -1.5 + 'px';
    bird2.style.left = value * -5 + 'px';
   btn.style.marginTop = value * -2.1 + 'px';
    rocks.style.top = value * -0.12 + 'px';
    forest.style.top = value * -0.25 + 'px';
}

$(document).ready(function()
{
    $('#user-login').on('click',function(e){
        $("#tab-login").trigger("click");
    });
    $('#user-register').on('click',function(e){
        $("#tab-register").trigger("click");
    });
});