window.onload =function(){

    $('#LMButton').on('click',wiki);
    function wiki(){
        window.location.assign('https://en.wikipedia.org/wiki/Serialization#Serialization_formats');

    }

    $('#gSearch').on('click', google);
    function google(){
        window.location.assign('https://www.google.com');
    }

}