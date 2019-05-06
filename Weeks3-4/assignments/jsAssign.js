window.onload =function(){

    $('#mybutton').on('click',fib);
    

    function fib(){
       let num = $("#input").val();
       var a =1;
       var b =0;
       var temp;

       while (num >= 0){
           temp = a;
           a = a + b;
           b = temp;
           num--;
       }

       $('#results').html(b);
    }


    $('#bubButton').on('click',bubble);

    function bubble(){
        var arr = [5, 4, 3, 2, 1];
        $('#bubIn').html(arr);

        for(let i = 0; i < arr.length; i++){
            for(let j = 0; j < arr.length-1;j++){
                if(arr[j]>arr[j+1]){
                    let temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }

        }
        $('#bubbleAns').html(arr);

    }

    $('#revButton').on('click',revString);

    function revString(){
        let myString = 'string';
        $('#revIn').html(myString);

        let reversed = "";    
        for (var i = myString.length - 1; i >= 0; i--){        
          reversed += myString[i];
        }  

        $('#reverseAns').html(reversed);
    }

    $('#factButt').on('click', factorial);
    
    function factorial(){
        let num = 5;
        let temp =1;
        
        $('#factorIn').html(num);
        
        for(let i = num; i >0; i--){
            temp = temp * i;
        }

        $('#factAns').html(temp);

    }

    $('#SubStringResult').on('click', substring);

    function substring(){
        let Astring = $('#subinput1').val();
        let oneInt = $('#subinput2').val();
        let twoInt = $('#subinput3').val();

        let Bstring = Astring.substring(oneInt, twoInt);
        $('#theAnswer').html(Bstring);

    }


    $('#checkEven').on('click',isItEven);

    function isItEven(){
        let num = $("#isEven").val();
    
        if(num & 1){
            $('#prob6Ans').html('Its ODD');
        }else {
            $('#prob6Ans').html('Its EVEN');
        }

     }

     $('#pallindromeB').on('click', isPally);

     function isPally(){
         var newString = $('#inboundString').val();
         var left = 0;
         var right = newString.length-1;
         while(left < right){
             if(newString[left++] !== newString[right--]){
                console.log('test');
                $('#IsPalinRes').html('Not A Palindrome');
                return;
             }
         }
         $('#IsPalinRes').html('A Palindrome');

    }


    $('#makeShape').on('click', shapes);
    function shapes(){
        console.log('test');
        let shape = $('#shapeIn1').val();
        let height = $('#shapeIn2').val();
        let character = $('#shapeIn3').val();

        switch(shape){
            case 'Square': 
                        for(let i = 0; i < height;i++){
                            for(let j = 0; j < height;j++){
                                console.log(character);
                            }
                            console.log('\n');
                        }
                        break;
            case 'Triangle': 
                        for(let i = 0; i < height;i++){
                            for(let j= 0;j<=i;j++){
                                console.log(character);
                            }
                            console.log('\n');  
                        }                      
                        break;
            case 'Diamond': 
                        for(let i = 0; i < height;i++){
                            for(let j= 0;j<=i;j++){
                                console.log(character);
                            }
                            console.log('\n');  
                        }     
                        for(let i = height; i > 0;i--){
                            for(let j= 1;j<=i;j++){
                                console.log(character);
                            }
                            console.log('\n');  
                        }    

                        break;
            default: 
                        console.log("Invalid input");
                        break;
        }

    }

}
