/**
 * Created by daming on 2017/6/24.
 */
var getProjectPath = function(){
   var pathName = window.document.location.pathname;
   return pathName.substring(0,pathName.substr(1).indexOf('/')+1);
}

var ajaxCall = function(url,method,data,thisObj,callback){
    $.ajax({
        url : getProjectPath() + url,
        type : method,
        headers : {
            'Accept':'application/json',
            'Content-Type':'application/json'
        },
        data : JSON.stringify(data),
        cache : false,
        dataType : 'json',
        success : function (response) {
            if(callback && typeof callback === 'function'){
                callback.call(thisObj,null,response);
            }
        },
        error : function(XMLHttpRequest,textStatus,error){
            if(callback && typeof callback === 'function'){
                
            }
        }
    });
}