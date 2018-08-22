window.onload = function () {
    createDemospace();
    document.getElementById("test").addEventListener("click",function (event){console.log(event)});
}

var layers = 10;

function createDemospace() {

    let currLayer = 0;
    colors = ["blue", "black", "red", "green", "yellow"]
    for (let i = 0; i < layers; i++) {
        currLayer = document.getElementById(`demoLayer${i}`)
        var nextLayer = document.createElement("form");
        nextLayer.setAttribute("id", `demoLayer${i + 1}`);
        nextLayer.setAttribute("class", "demoLayer");
        nextLayer.innerHTML = `Demo Layer ${i + 1}`
        nextLayer.style.borderColor = "blue";
        nextLayer.style.background = colors[i % 5];
        currLayer.appendChild(nextLayer);
    }
}

var colorToggle = function () {
    console.log(this.value);
    this.target.style.backgroundColor = "red";
}

var propValue = document.getElementById("propagationSelector");
// propValue = propValue.options[propValue.selectedIndex].value;

// document.getElementsByClassName("demoLayer").addEventListener("click",colorToggle,propValue[propValue.selectedIndex].value);
// document.getElementsByClassName("demoLayer").addEventListener("click",function (event) {
//     console.log("Click!");
//     event.target.style.backgroundColor = 'yellow';

//     // chrome needs some time to paint yellow
//     setTimeout(() => {
//         alert("target = " + event.target.tagName + ", this=" + this.tagName);
//         event.target.style.backgroundColor = '';
//     }, 0);
// });

// document.getElementsByClassName("demoLayer").addEventListener("click",function (event) {
//     console.log("Click!");
//     event.target.style.backgroundColor = 'yellow';

//     // chrome needs some time to paint yellow
//     setTimeout(() => {
//         alert("target = " + event.target.tagName + ", this=" + this.tagName);
//         event.target.style.backgroundColor = '';
//     }, 0);
// })

