Vue.config.devtools=true;

$(function(){
    $("#checkAll").click(function(){
        $("tbody input").prop("checked",function (i,val) {
            return !val;
        })
    });

    // window.localStorage.setItem("userName",${userName});
//    画表格
    new Vue({
        el:"#showCols",
        data:{
            items:""
        },
        created:function() {
                    var _self = this;
                    $.ajax({
                        type: 'post',
                        url: "/admin/list",
                        success: function (data) {
                            _self.items = data;
                        },
                        error:function(msg){
                            alert("服务出现异常，请刷新后重试！"+msg);
                        }
                    });
                }
    });
});
function propChecked() {
    $("tbody input").prop("checked", function (i, val) {
        if (val) {
            $(this).parent().parent().parent().attr("style","background-color:cadetblue");
        } else {
            $(this).parent().parent().parent().attr("style","background-color:#d1e9ff");
        }
    });
}

function toAdd(){
    $.ajax({
        url:"/admin/toAdd",
        type:"post",
        success:function (data) {
            console.log(data)
        },
        error:function () {

        }
    })
}