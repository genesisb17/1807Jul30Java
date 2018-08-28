window.onload = function() {
    console.log("in onload function");
    $("#homeView").on('click', loadHomeView);
    $("#definitionsView").on('click', loadDefinitionsView);
    $("#characteristicsView").on('click', loadCharacteristicsView);
}

function loadHomeView() {
    console.log("loading home view");
    window.location.href = 'home.html';
}

function loadDefinitionsView() {
    window.location.href = 'definitions.html';
}

function loadCharacteristicsView() {
    window.location.href = 'characteristics.html';
}