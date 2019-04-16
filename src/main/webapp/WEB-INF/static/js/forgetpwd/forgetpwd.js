var chooseViewNum  = 0;
var view = $("#view").children();
$(function () {
    // url>> http://localhost:8086/topic/index
    //路径名 (/topic/index)
    var pathname = window.location.pathname;
    //地址栏url(http://localhost:8086/topic/index)
    var href = window.location.href;
    //服务器地址 (http://localhost:8086)
    var path = href.substring(0,href.indexOf(pathname));
    //项目名(/topic)
    var projectName = href.substring(href.indexOf(path),href.indexOf(pathname));
    $("a[dataType=verification]").find("span").html(verificationString());
    // 验证表单
    $("button[type=button]").on("click",function () {
        var success  = $(this).attr("match-success");
        //验证是否完成
        if(success=="yes"){
            var username = $("#inputUserName").val();
            var password = $("#inputPassword").val();
            $.ajax({
                url:path + projectName +"/login",
                method:"post",
                data:{"userName":username,"password":password},
                dataType:"JSON",
                success:function(result){
                    window.location.href = path + projectName + "/index";
                }
            })
        }
        // 表单验证
        if(true){
            $(view[chooseViewNum]).addClass("hidden-xs");
            $(view[chooseViewNum]).removeClass("checked");
            $(view[chooseViewNum+=2]).addClass("checked");
            $(view[chooseViewNum]).removeClass("hidden-xs");
            var parentNode = $(this)[0].parentNode.parentNode.parentNode.parentNode;
            $(parentNode).hide();
            $($(parentNode)[0].nextElementSibling).show();
            $("a[dataType=verification]").find("span").html(verificationString());
        }
    })
    //添加切换视图单击事件
    // var childrenLi = $("#changeView").children();
    // for(var cv =0;cv< childrenLi.length;cv++){
    //     $(childrenLi[cv]).find("a").attr("onclick","changeView(this)");
    // }
})
//更换视图
// function changeView(obj) {
//     changCheck(obj);
//     //刷新验证码
//     $("a[dataType=verification]").find("span").html(verificationString());
//     var ul = obj.parentNode.parentNode;
//     var li = ul.children;
//     var iChooseView = -1;
//     for (var i = 0; i < li.length; i++) {
//         if (li[i].innerHTML.indexOf(obj.innerHTML)>0) {
//             iChooseView = i;
//             break;
//         }
//     }
//    //修改视图
//    var viewcc = $("section nav").children();
//    if(iChooseView!=-1) {
//        $(viewcc[iChooseView]).show();
//        $(viewcc[iChooseView]).siblings().hide();
//        chooseViewNum = 0;
//        view.removeClass("checked");
//        view.eq(0).addClass("checked");
//        //清空列表并返回账号信息填写表单
//        truncateFrom(iChooseView);
//        //告诉隐藏域选择的是那种视图
//        $("#chooseView").val(iChooseView);
//    }
// }


//被选择的样式
function changCheck(obj){
    var thisLi = obj.parentNode;
    var sibling = $(thisLi).siblings();
    $(thisLi).addClass("active");
    $(sibling).removeClass("active");
}
//清空列表并返回账号信息填写表单
function truncateFrom(iChooseView) {
    var navUL = $("nav").children("ul");
    if($("#chooseView").val()!=iChooseView){
        var siblings = $(navUL[iChooseView]).siblings();
        for(var i =0;i<siblings.length;i++){
            var p =$(siblings).eq(i).children("li");
            for(var x =0;x<p.length;x++) {
                if(p.eq(x).find("form").html()!=undefined){
                    p.eq(x).find("form")[0].reset();
                }
            }
        }
        var self =$(navUL[iChooseView]).children("li");;
        $(self[0]).css("display","block");
        $(self[0]).siblings("li").css("display","none");
    }
}

