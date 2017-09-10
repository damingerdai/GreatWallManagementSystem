/**
 * Created by daming on 2017/6/24.
 */
function LoginIn(){
    $("#errorMsg").html("");
    if($("#empid").val().length == 0){
        $("#errorMsg").html("员工号不能为空");
        return;
    }
    if($("#psw").val().length == 0){
        $("#errorMsg").html("密码不能为空");
        return;
    }
    document.getElementById("login").submit();
}