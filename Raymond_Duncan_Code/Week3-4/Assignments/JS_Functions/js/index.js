window.onload = function () {
    console.log("Welcome!");
    $("#nav-list").on("click", "li", switchFunctionality);
    $("#fibonacci-button").on("click", function () {
        //Call the fibonacci function and put the output in fibonacci-output
        let n = $("#fibonacci-input").val();
        let output = fib(n).join(", ");
        console.log(output);
        $("#fibonacci-output").html(output);
    })
    $("#bubbleSort-button").on("click", function () {
        let arr = $("#bubbleSort-input").val();
        let output = bubbleSort(arr.split(",")).join(", ");
        $("#bubbleSort-output").html(output);
    });
    $("#reverseString-button").on("click", function () {
        let str = $("#reverseString-input");
        let output = reverseString(str);
        $("#reverseString-output").html(output);
    });
    $("#factorial-button").on("click", function () {
        let n = $("#factorial-input").val();
        let output = factorial(n);
        $("#factorial-output").html(output);
    });
    $("#substring-button").on("click", function () {
        let str = $("#substring-str").val();
        let len = Number($("#substring-length").val());
        let offset = Number($("#substring-offset").val());
        let output = substring(str, len, offset);
        console.log(`Str: ${str}\tLen: ${typeof (len)}\tOffset: ${typeof (offset)}`);
        $("#substring-output").html(output);
    });
    $("#evenNumber-button").on("click", function () {
        let n = Number($("#evenNumber-input").val());
        let is_even = isEven(n);
        console.log(is_even, typeof (is_even));
        let is_even_div = $("#isEven-div");
        is_even_div.attr("isEven", is_even);
        console.log(is_even_div.attr("isEven"));
        if(is_even_div.attr("isEven") != is_even){
            console.log("Switching cards");
            $(`#${"even-".concat(!is_even)}`).slideUp("fast", function () {
                $(`#${"even-".concat(is_even)}`).slideDown("fast");
            });
        }
    });
    $("#palindrome-button").on("click",function(){
        let str = $("#palindrome-input").val();
        let output = isPalindrome(str);
        $("#palindrome-output").html(output);
    });
    $("#shapes-button").on("click",function(){
        let shape = document.getElementById("shapes-selector");
        shape = shape.options[shape.selectedIndex].value;
        let character = $("#shapes-character").val();
        let height = Number($("#shapes-height").val());
        console.log(shape,character,height);
        let output = printShape(shape,height,character);
        console.log(output);
        $("#shapes-output").html(output);
        console.log(shape);
    });
    $("#objectLiteral-addButton").on("click",function(){
        let key = $("#object-key").val();
        let value = $("#object-value").val();
        let li = document.createElement("li");
        li.innerHTML = `${key}: ${value}`;
        document.getElementById("object-fields").appendChild(li);
        $("#object-key").html("");
        $("#object-value").html("");
    });
    $("#objectLiteral-print").on("click",function(){
        let fields = document.getElementById("object-fields").getElementsByTagName("li");
        console.log();
    });
    $("#deleteElement-button").on("click",function(){
        let arr = $("#deleteElement-array").val();
        let index = $("#deleteElement-index").val();
        let output = deleteElement(arr,index);
        console.log(output);
        $("#deleteElement-output").html(output);
    });
    // $("#")
}

switchFunctionality = function () {
    //Switches the currently displayed function for the selected function
    console.log(this.innerHTML);
    let selected_function_element = $(`#${this.id}`);
    let selected_function_id = this.id;

    console.log("Selected function element: ", selected_function_element)
    // console.log("Selected function id: ",selected_function_id);

    let function_selector = $("#nav-list")
    let active_function_id = function_selector.attr("active");
    let active_function_div = $(`#${active_function_id.concat("-div")}`);
    // console.log(active_function_id, selected_function_id);
    if (selected_function_id === active_function_id) {
        //This is the function that is already active
        console.log("This is the active function");
        active_function_div.show();
    } else if (active_function_id === "") {
        selected_function_element.attr("toggled", "toggled");
        function_selector.attr("active", selected_function_id);
        selected_function_div = $(`#${selected_function_id.concat("-div")}`);
        $("#welcome-div").slideUp("fast", function () {
            console.log(selected_function_element.innerText, this.innerHTML);
            $("#welcome-row").html(selected_function_element.innerHTML);
            selected_function_div.slideDown("fast");
        });
    } else {
        //Set the new function as active
        active_function_element = $(`#${active_function_id}`);
        active_function_element.removeAttr("toggled");
        selected_function_element.attr("toggled", "toggled");
        function_selector.attr("active", selected_function_id);


        active_function_div.slideUp("fast", function () {

            selected_function_div = $(`#${selected_function_id.concat("-div")}`);
            selected_function_div.slideDown("fast");
        });
    }

}

