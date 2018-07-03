window.onload=function(){
    var liGroup=document.getElementsByClassName("li-group")[0];
    var lis=liGroup.getElementsByTagName("li");
    var main=document.getElementsByClassName("main")[0];
    var jsNavs=main.getElementsByClassName("js-nav");
    for(var i=0;i<jsNavs.length;i++){
        lis[i].index=i;
        lis[i].onmouseover=function(){
            for(var j=0;j<jsNavs.length;j++){
            jsNavs[j].style.display="none";
        }
            jsNavs[this.index].style.display='block';
        }
        jsNavs[i].onmouseleave=function(){
            this.style.display="none";
        }
    }
}