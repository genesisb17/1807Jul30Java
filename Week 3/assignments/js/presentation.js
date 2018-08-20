window.onload = function(){
    $("#frameBut").on('click', showDiagram);
}

function showDiagram(){
    console.log("clicked");
    $("#keyimg").removeAttr('hidden');
    $('#frameBut').on('click', removeDiagram);
}

function removeDiagram(){
    $("#keyimg").attr('hidden', 'true');
    $("#frameBut").on('click', showDiagram);
}

