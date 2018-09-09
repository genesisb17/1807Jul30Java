window.onload = function(){
    $("#frameBut").on('click', showDiagram);
}

function showDiagram(){
    console.log("clicked");
    $("#diagram").removeAttr('hidden');
    $('#frameBut').on('click', removeDiagram);
}

function removeDiagram(){
    $("#diagram").attr('hidden', 'true');
    $("#frameBut").on('click', showDiagram);
}

