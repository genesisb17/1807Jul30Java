window.onload = function() {
    alert('JS is loaded!'); 
    document.getElementById("logIn").addEventListener(
    //   event    function    propagate
        "click", getUserInfo, true
    );
      
}