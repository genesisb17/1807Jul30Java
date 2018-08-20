window.onload = function() {
    document.getElementById("nnf").addEventListener(
        "click", noNF, true
    );
    document.getElementById("1nf").addEventListener(
        "click", firstNF, true
    );
    document.getElementById("2nf").addEventListener(
        "click", secondNF, true
    );
    document.getElementById("3nf").addEventListener(
        "click", thirdNF, true
    );
}

function hideDenormal() {
   $("#table").attr("hidden","true");
}

function hide1nf() {
    $("#table1nf").attr("hidden","true");
 }

function hide2nf() {
    $("#table2nf").attr("hidden","true");
}

function hide3nf() {
    $("#table3nf").attr("hidden","true");
}


//shows the denormalized table
function noNF() {
    var x, y;
    y = document.getElementById("table");
    hide1nf();
    hide2nf();
    hide3nf();
    y.removeAttribute("hidden");
}
//shows the table in 1st normal form
function firstNF() {
    var x, y;
    y = document.getElementById("table1nf");
    hideDenormal();
    hide2nf();
    hide3nf();
    y.removeAttribute("hidden");
}
//shows the table in second normal form
function secondNF() {
    var x, y;
    y = document.getElementById("table2nf");
    hideDenormal();
    hide1nf();
    hide3nf();
    y.removeAttribute("hidden");
}
// shows the table in third normal from
function thirdNF() {
    var x, y;
    y = document.getElementById("table3nf");
    hideDenormal();
    hide1nf();
    hide2nf();
    y.removeAttribute("hidden");
}
