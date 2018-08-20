window.onload = function(){
    $("#example1But").on('click', typeWriterE1);
    $("#example2But").on('click', typeWriterE2);
}

function typeWriterE1() {
    $("#example1").removeAttr('hidden');
    $("#example1pt2").removeAttr('hidden');
    $("#example1pt3").removeAttr('hidden');
    $("#example1pt4").removeAttr('hidden');
    $("#brace1").removeAttr('hidden');
    $("#brace2").removeAttr('hidden');
    $("#brace3").removeAttr('hidden');
    $("#example1But").on('click', hideTypeWriterE1);
}

function hideTypeWriterE1(){
    $("#example1").attr('hidden', 'true');
    $("#example1pt2").attr('hidden', 'true');
    $("#example1pt3").attr('hidden', 'true');
    $("#example1pt4").attr('hidden', 'true');
    $("#brace1").attr('hidden', 'true');
    $("#brace2").attr('hidden', 'true');
    $("#brace3").attr('hidden', 'true');
    $("#example1But").on('click', typeWriterE1);
}

function typeWriterE2() {
    console.log("working");
    $(".secondexample").removeAttr('hidden');
    $("#example2").removeAttr('hidden');
    $("#example2pt1").removeAttr('hidden');
    $("#example2pt2").removeAttr('hidden');
    $("#example2pt3").removeAttr('hidden');
    $("#example2pt4").removeAttr('hidden');
    $("#brace4").removeAttr('hidden');
    $("#brace5").removeAttr('hidden');
    $("#brace6").removeAttr('hidden');
    $("#example2But").on('click', hideTypeWriterE2);
}

function hideTypeWriterE2() {
    $("#example2").attr('hidden', 'true');
    $("#example2pt1").attr('hidden', 'true');
    $("#example2pt2").attr('hidden', 'true');
    $("#example2pt3").attr('hidden', 'true');
    $("#example2pt4").attr('hidden', 'true');
    $("#brace4").attr('hidden', 'true');
    $("#brace5").attr('hidden', 'true');
    $("#brace6").attr('hidden', 'true');
    $("#example2But").on('click', typeWriterE2);
}