
function showMenu(strID){
    var i;
    for(i=0;i<2;i++){
        var lay;

        lay = eval('lay' + i);
        if (lay.style.display=="block" && lay != eval(strID)){
            lay.style.display = "none";
        }
    }

    if (strID.style.display=="none"){
        strID.style.display = "block"; 
    }else{
        strID.style.display = "none"; 
    }
}
function showMenu(strID){
                var sub_menu = document.getElementById(strID);
                var dis_v = sub_menu.style.display;
                
                if(dis_v == "none")
                    sub_menu.style.display = "block";
                else
                    sub_menu.style.display = "none"; 
					}