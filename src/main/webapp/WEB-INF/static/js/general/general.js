$(function () {
    $("header button").on("click",function () {
        var attr = $("header").attr("view-type");
        if(attr=="show"){
            $("header").attr({"view-type":"hide"});
            $("header").siblings().hide();
        }else {
            $("header").attr({"view-type":"show"});
            $("header").siblings().show();
        }
    })
})
//验证码 start
function verification(obj) {
    $(obj).children("span").eq(0).html(verificationString());
}
//生成验证码(4位数的验证码)
function verificationString() {
    var arr=["z","A","b","B","a","C","f","D",
        "c","E","d","F","h","G","l","H","j","I","e","J","m","k","K","i","L","n","M","o","N","p",
        "O","q","P","r","Q","s","R","t","S","u","T","v","U","w","V","x","W","X","y","Y","g","Z"];
    var rankRegExp = "";
    for (var i = 0; i < 2; i++) {
        rankRegExp += arr[Math.floor(Math.random() * 52)];
        rankRegExp += Math.ceil(Math.random() * 9);
    }
    return rankRegExp;
}
$(function () {
    $("a[dataType=verification]").find("span").html(verificationString());
})
//验证码 end
// 分页 -start
// 检查最小值,最大值
var currentPage = $("#currentPage");
var pageCount =$("#pageCount").html();
function checkNum(obj) {
    if(obj.value<0){
        if(parseInt(pageCount)>1){
            obj.value = 1;
        }else{
            obj.value = 0;
        }
    }else if(obj.value>parseInt(pageCount)){
        obj.value = pageCount;
    }
}
function submitPager(obj) {
    var changePageNum = obj.previousElementSibling.value;
    changePage(parseInt(changePageNum));
}
function minusPage(){
    if(parseInt(pageCount)>0&&parseInt($(currentPage).html())>1){
        changePage(parseInt($(currentPage).html())-1);
    }
}
function addPage(){
    var html = $(currentPage).html();
    if(parseInt(html)<parseInt(pageCount)){
        changePage(parseInt($(currentPage).html())+1);
    }
}
function changePage(currentPage){
    $("#currentPage").html(currentPage);
    changePageSheet(currentPage,5);
    var sLI = $($("#addPage")[0].parentNode).children("li");
    for (var i =0;i<sLI.length;i++){
        sLI.eq(i).find("button").removeClass("page-checked");
        if(sLI.eq(i).find("button").html()==currentPage){
            sLI.eq(i).find("button").addClass("page-checked")
        }
    }
}
function changePageSheet(currentPage,pageViewTotal) {
    var middlePage = Math.ceil(pageViewTotal/2);
    var newViewPage = 0;
    if(currentPage - middlePage < 1 ){
        newViewPage =  Math.ceil(currentPage / middlePage);
    }else if(currentPage + middlePage - 1 > pageCount){
        var pageMax = Math.ceil(pageCount/pageViewTotal)*pageViewTotal;
            newViewPage = pageMax - pageViewTotal + 1 -(pageMax-pageCount);
    }else{
        if(pageCount-Math.floor(pageViewTotal/2)>currentPage) {
            newViewPage = currentPage - middlePage + 1;
        }else{
            newViewPage = currentPage - middlePage;
        }
    }
    var ul = $("#pcx");
    $(ul).html("");
    var minusPage = '<li id="minusPage"> <button type="button"onclick="minusPage()"><span aria-hidden="true">&laquo;</span></button></li> ';
    $(ul).append(minusPage);
    for(var i = newViewPage,count=0;i<=pageCount;i++,count++){
        if(count<pageViewTotal){
            var li ='<li><button type="submit">'+i+'</button></li> ';
            $(ul).append(li);
        }
    }
    var addPage ='<li id="addPage"><button type="button" onclick="addPage()"><span aria-hidden="true">&raquo;</span></button></li> ';
    $(ul).append(addPage);
}
// 分页 -end


//下拉列表
var downList = $(".downList");
$(downList).each(function () {
    var s =$(this);
    $(s.children("li")).each(function () {
        var l =$(this);
        $(this).find("a").on("click", function () {
            $(s).siblings("button").eq(0).html($(this).html()+' <span class="caret"></span>');
            var name = $(s).attr("name");
            var inputHidden = $('input[name='+name+']');
            $(inputHidden).val($(l).attr("data"))
        })
    })
})





