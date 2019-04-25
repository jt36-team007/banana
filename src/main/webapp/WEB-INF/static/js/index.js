/**
 * Created by David on 2019-01-08.
 */


$(document).ready(function(){
    $("li:even").css({"background-color":"#F0F0F0"});
});

$(function(){
    $("#content>ul>span").html("")
})
function inMfg(rfqno) {
    window.location.href=getRootPath()+"/inMfg/"+rfqno;
}