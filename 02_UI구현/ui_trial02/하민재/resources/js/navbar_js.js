$(function(){
    const toggleBtn=$('.navbar_toggle');
    
    const menu=$('.navbar_menu');
    const goInto=$('.navbar_menu2');

    //토글버튼을 클릭하면 이벤트 발생 - 액티브를 부여.
    toggleBtn.click(function(){
        //햄버거가 클릭됐다면
        //hasClass() : 현재 가리키고있는 태그가 active클래스를 가지고있는가?
        if(!(menu.hasClass('active') && goInto.hasClass('active'))){
            //active가없다면 => active적용
            menu.addClass('active');
            goInto.addClass('active');
        }else{
            //active가있다면 => active적용안하기
            menu.removeClass('active');
            goInto.removeClass('active');
        }
    });

});