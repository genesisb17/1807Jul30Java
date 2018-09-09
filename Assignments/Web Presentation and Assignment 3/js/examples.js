window.onload = function(){
    $("#example1But").on('click', typeWriterE1);
    $("#example2But").on('click', typeWriterE2);
};

function typeWriterE1() {
    console.log("butotn 1 works");
    $("#frame1").removeAttr('hidden');
    $("#example1But").on('click', hideTypeWriterE1);
}

function hideTypeWriterE1(){
    $('#frame1').attr('hidden', 'true');
    $("#example1But").on('click', typeWriterE1);
}

function typeWriterE2() {
    console.log("working");
    $('#frame2').removeAttr('hidden');
    $("#example2But").on('click', hideTypeWriterE2);
}

function hideTypeWriterE2() {
    $('#frame2').attr('hidden', 'true');
    $("#example2But").on('click', typeWriterE2);
}