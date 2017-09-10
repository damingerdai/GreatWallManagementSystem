$(function(){
    var $level1=$(".level1 .level1Style");
    var $showlevel1=$(".level1 .MenuLevel2");
    $level1.each(function(index){
        $(this).click(function(){
            if(!$(this).is(":animated")){

                $showlevel1.eq(index+1).slideToggle("normal").end()
                    .not($showlevel1[index+1]).slideUp("normal");
            };
        });

    });
});
$(function(){
    //导航切换
    $(".level2Style").click(function(){
        $(".level2Style.selected").removeClass("selected")
        $(this).addClass("selected");
    })
});