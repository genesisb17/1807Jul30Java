window.onload = function(){
    $('#mybutton').on("click",fib);

    
    


    function fib(){
        let num = $("#fib").val();
        
        var a =1;
        var b =0;
        var temp;
    
        console.log(num);
        while (num >= 0){
            temp = a;
            a = a + b;
            b = temp;
            num--;
        }
        
        console.log(b);
        }

}