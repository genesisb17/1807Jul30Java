window.onload = function() {
	
	globalObject = {};
	g_userId = 0;
	
	console.log(g_userId);

	g_userId++;
	
	console.log(g_userId);
	
	
	loadLogInView();
	
//	loadHomeView();
	
	g_userId++;

	console.log(g_userId);

	$('#home').on('click', loadHomeView);
    $("#about").on("click", loadAboutView);
    $('#myStatementButton').on('click', viewTable);
    $("#logoutButton").on('click', loadLogInView);
    
}

//$(document).ready(function() {
//    $("#entireTab tr:has(td)").mouseover(function(e) {
//        $(this).css("cursor", "pointer");
//    });
//    $("#entireTab tr:has(td)").click(function(e) {
//        $("#entireTab td").removeClass("highlight");
//        var clickedCell = $(e.target).closest("td");
//        clickedCell.addClass("highlight");
//        $("#spnText").html(
//            'Clicked table cell value is: <b> ' + clickedCell.text() + '</b>');
//    });
//});



// 		 Load Home View
function loadHomeView() {
	
    console.log("Loading HomeView");

	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
    	
    	console.log('xhr.readyState -> ' + xhr.readyState);
    	console.log('xhr.status -> ' + xhr.status);
    	
        if(xhr.readyState == 4 && xhr.status == 200){
        	console.log(xhr.responseText);
        	$('#viewLoader').html(xhr.responseText);     	   	
        }
    }
    
//    setTimeout(function() {
    	xhr.open("GET", 'home.view', true);
    	xhr.send();  
//    }, 1000);
    
}

//		Load About View
function loadAboutView() {
	
    console.log("Loading AboutView");

	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
        	$('#viewLoader').html(xhr.responseText);     	   	
        }
    }
    xhr.open("GET", 'about.view', true);
    xhr.send();      
}


//		 Show statements
//function viewTable(obj){
function viewTable() {
	
	console.log("======================");
//	console.log(obj);
	
	var xhr = new XMLHttpRequest();
	
    xhr.onreadystatechange = function() {

        if(xhr.readyState == 4 && xhr.status == 200) {
        	
        	console.log('gonna get statements');
        	console.log(xhr.responseText);
        	
        	console.log(globalObject);
        	
        	if (globalObject.roleId == 1) {
        		
//        		alert('employee info');
        		
	        	$('#viewLoader').html(xhr.responseText);   
	        	$('#ticketsManagerForm').hide();
	        	$('#ticketsForm').show();
	
	            // js to control drop down
		    	$(".dropdown-menu li a").click(function () {
		    	  var selText = $(this).text();
		    	  $(this).closest('.form-group').find('#expenseTypeTxt').val(selText);
		    	});

	            $('#newTicketButton').on('click', function() {
	            	
	            	console.log(' inside the click function');
	            	
	            	// Expense type
	            	var type = $('#expenseTypeTxt').val();
	            	
	            	// Expense description
	            	var descrip = $('#descriptionText').val();
	            	
	            	// Expense cash
	            	var cash = $('#cashMoneyYall').val();
	            	
	//            	sendTicket(obj, type, descrip, cash);
	            	sendTicket(type, descrip, cash);
	            	
	            	$('#expenseTypeTxt').val('');
	            	$('#descriptionText').val('');
	            	$('#cashMoneyYall').val('');
	
	            })
	            
        	} //end of roleId if
        	else if (globalObject.roleId == 2) {
        		
//        		alert('manager info');
        		
        		$('#viewLoader').html(xhr.responseText);  
        		$('#ticketsForm').hide();
        		$('#ticketsManagerForm').show();
        		
        	}
            
    	  // Here, we make another AJAX call to get JSON data of tickets
	    	  
    	  populateTicketsTable();
	    	  
    	  // End of JSON get request

        }

    }
    xhr.open("GET", 'table.view', true);
    xhr.send();
}


//function populateUserTable() {
function populateTicketsTable() {
	
    var xhr = new XMLHttpRequest();
    
    xhr.onreadystatechange = function(){
    	
        if(xhr.readyState == 4 && xhr.status == 200){
        	
//          user = JSON.parse(xhr.responseText);
            tickets = JSON.parse(xhr.responseText);
            
            console.log(tickets);
            
            var $dropdown = $("#allTicketsList");
            $.each(tickets, function() {
            	var ticketName = "Ticket # " + this.ticketId + "" + this.userId + " (" + this.status + ")";
                $dropdown.append($("<option />").val(this.ticketId).text(ticketName));
                
                console.log("Ticket # " + this.ticketId + "" + this.userId + " (" + this.status + ")");
            });
            
            var ticketId_toUpdate = 0;
            
        	$('#allTicketsList').change(function() {
        		
        		console.log($(this).val());
        		
        		ticketId_toUpdate = parseInt($(this).val());
        		
        		var ticketAuthor = tickets.filter(x => parseInt(x.ticketId) == parseInt($(this).val()))[0].firstName;
        		var ticketAmount = tickets.filter(x => parseInt(x.ticketId) == parseInt($(this).val()))[0].cash;
        		var ticketDescription = tickets.filter(x => parseInt(x.ticketId) == parseInt($(this).val()))[0].description;
        		
        		$('#ticketAuthor').html(ticketAuthor);
        		$('#ticketAmount').html(ticketAmount);
        		$('#ticketDescription').html(ticketDescription);
        		
        	});
        	
        	$('#ticketStatus').change(function() {
    			var statusId = $(this).val();
    			updateTicketStatus(statusId, globalObject.userId, ticketId_toUpdate);
        	});
            
            $('#entireTab tbody').html('');
            for(var b of tickets){
                addUserToTable(b); 
            }
            
            // https://www.learningjquery.com/2017/09/get-html-table-cell-value-using-jquery
//            $("#entireTab tr:has(td)").mouseover(function(e) {
//                $(this).css("cursor", "pointer");
//            });
//            $("#entireTab tr:has(td)").click(function(e) {
//                $("#entireTab td").removeClass("highlight");
//                var clickedCell = $(e.target).closest("td");
//                clickedCell.addClass("highlight");
//                $("#spnText").html(
//                    'Clicked table cell value is: <b> ' + clickedCell.text() + '</b>');
//            });
            
            //https://codereview.stackexchange.com/questions/14295/select-row-based-on-another-table-row-index
//            $('#entireTab tbody td').click(function() {
//            	
//                var rowIndex = $(this).parent().index();
//                $('#spnText').html(rowIndex);
//
//                var myData= [];
//
//                $($('#entireTab tbody tr')[rowIndex]).map(function() {
//                	
//                    return $(this.cells).get();
//                    
//                }).each(function() {
//                	
//                    var headerVal = $(this).closest('table').find('thead th').eq($(this).index()).html();
//                    
//                    myData.push([headerVal,parseFloat($(this).html())]);
//                    
//                });
//
////                alert(myData);
//                console.log(myData);
//            });
            
        }

    }
    
    console.log('globalObject.userId -> ' + globalObject.userId);
    
//    xhr.open("GET", 'ticket', true);
    xhr.open("GET", 'ticket?userId='+globalObject.userId+"&roleId="+globalObject.roleId, true);
    xhr.send();
}

// Update reimbursement status id
function updateTicketStatus(statusId, userId, ticketId_toUpdate) {
	
	var dataToPost = {
		statusId: statusId,
		userId:	userId,
		ticketId: ticketId_toUpdate
	};
	
	dataToPost = JSON.stringify(dataToPost);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			
			var jsonResponse =  xhr.responseText;
//			var jsonResponse = JSON.parse(xhr.responseText);
			
			console.log('jsonResponse: ');
			console.log(jsonResponse);
			
		}
	}
	xhr.open('POST', 'ticket', true);
	xhr.send(dataToPost);
}

function addUserToTable(b){
	
    var row = document.createElement("tr");
    
//    var cellTest = document.createElement("td");
    
    var cell0 = document.createElement("td");
    var cell1 = document.createElement("td");
    var cell2 = document.createElement("td");
    var cell3 = document.createElement("td");
    var cell4 = document.createElement("td");
    var cell5 = document.createElement("td");
    var cell6 = document.createElement("td");
    var cell7 = document.createElement("td");  
    
//    cellTest.innerHTML = b.userId;
//    cellTest.innerHTML = globalObject.userId

    cell0.innerHTML = b.ticketId + "" + b.userId;
    cell1.innerHTML = b.firstName;
    cell2.innerHTML = b.lastName;
    cell3.innerHTML = b.cash;
    cell4.innerHTML = b.submit;
    cell5.innerHTML = b.resolved;
    cell6.innerHTML = b.description;
    cell7.innerHTML = b.status;
    
//    row.appendChild(cellTest);
    row.appendChild(cell0);
    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);
    row.appendChild(cell5);
    row.appendChild(cell6);
    row.appendChild(cell7);
    
//    $('#entireTab tbody').html('');
//    document.getElementById("entireTab").appendChild(row);
    document.getElementById("entireTab").getElementsByTagName('tbody')[0].appendChild(row);
//    $('#entireTab tbody').append(row);
}


/*  
 * 
 * Post ticket data
 * 
 * */

// Function below is being called by click event of $('#newTicketButton') element.
//function sendTicket(obj, type, description, cash){
function sendTicket(type, description, cash){
			//object, type, descrip, cash
	
	if(type == 'Lodging')
		type = 1;
	else if(type == 'Food')
		type = 2;
	else (type = 3)
	
	console.log(type);
	
    var xhr = new XMLHttpRequest();
    
    var newObj = new Object();
    newObj.cash = cash;
    newObj.type = type;
    newObj.description = description;
    
//  newObj.userId = 1;
    newObj.userId = globalObject.userId;
    
//    newObj.userId = obj.userId;
    
//    newObj.roleId = obj.roleId;
//    newObj.email = obj.email;
//    newObj.userName = obj.userName;
//    newObj.password = obj.password;
//    newObj.firstName = obj.firstName;
//    newObj.lastName = obj.lastName;
    
    console.log('js object');
    console.log(newObj);
    
    var strObj = JSON.stringify(newObj);
    
	console.log('json object');
	console.log(strObj);
	
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 ){
        	
			console.log('data response from server');
			console.log(xhr.responseText);
			
            tickets = JSON.parse(xhr.responseText);
            
            console.log('--->');
            console.log(tickets);
            
            $('#entireTab tbody').html('');
            for(var b of tickets){
                addUserToTable(b); 
            }

        }
    }
//    xhr.open('POST', 'employee', true);
    xhr.open('POST', 'employee?userId='+newObj.userId, true);
	xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(strObj);
}

///////////////////////////////////////////////////////////////////////////////////////

/*  
 * 
 * Log In Section
 * 
 * */

function loadLogInView() {
	
	console.log("inside my login div");
	$('nav').hide();
	
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		
		
		if(xhr.readyState == 4 && xhr.status == 200){

			
			console.log("inside my login ajax");
			
			console.log(xhr.responseText);
			
			$('#viewLoader').html(xhr.responseText);
			
		    $('#loginViewButton').on('click', loginValues);
		    
		}
		
	}
	xhr.open('GET', 'login.view', true);
	xhr.send();
}

function loginValues() {
	
	console.log(1);
	console.log('inside login Values');
	
	//user data
	var uname = $('#username').val();
    var pword = $('#password').val();
    
    // variable holding my drop down selection for manager or employee
    var dropDownSelect = document.getElementById("inlineFormCustomSelect").value;
  
//    alert(dropDownSelect + " The dropdown selection!");
    
    console.log(uname);
    console.log(pword);
    
    if (dropDownSelect == '') {
    	alert('Select a role');
    	return false;
    }
    
    getInfo(uname, pword, dropDownSelect);
    
    console.log('after getinfo');
    
    return false;		/// PLEASE DO NOT DELEETE THIS LINE
}


function getInfo(uname, pword, dropDownSelect){
	
    console.log('Loading credentials');
	var xhr = new XMLHttpRequest();
	
    var count = 0;
    var uNum = 0;
    
    xhr.onreadystatechange = function() {

    	console.log('xhr.readyState -> ' + xhr.readyState);
    	console.log('xhr.status -> ' + xhr.status);
    	
        if(xhr.readyState == 4 && xhr.status == 200) {

            var myObj = JSON.parse(xhr.responseText);
            
            myObj.forEach(function(arrayItem){
            	
            	if(arrayItem.userName == uname){
        			console.log('uname value is -> ' + uname);
            		uNum = count;
            	}
            	
            	count++;
            	
            });
            
            console.log('before the ifs');
            
            if(myObj[uNum].userName == uname & myObj[uNum].password == pword) {
            	
            	console.log('Role id is -> ' + myObj[uNum].roleId);
            	
            	if ( ( myObj[uNum].roleId == 1 ) && ( myObj[uNum].roleId == dropDownSelect ) ) {
            	
            		alert('you are an employee');
            		
//            		viewTable(myObj[uNum]);
            		console.log('will now load home view');
            		
            		globalObject = myObj[uNum];
            		
            		$('nav').show();
            		loadHomeView();
            		
            	} else if ( ( myObj[uNum].roleId == 2 ) && ( myObj[uNum].roleId == dropDownSelect ) ) {
//            	
            		alert('you are a manager');
            		
            		globalObject = myObj[uNum];
            		
            		$('nav').show();
//            		viewManagerTable(myObj[uNum]);    
            		loadHomeView();
            	
            	}
            	
            }else {
            	console.log(myObj[uNum].roleId);
            	console.log("Invalid username/password");
            	loadLogInView();
            }
        }
    }
    
    xhr.open("GET", "login", true);
//    xhr.open("GET", "http://localhost:8080/ers/login");
//    xhr.open("GET", "http://localhost:8081/ers/login");
    xhr.send();
}

///////////////////////////////////////////////////////////////////////////////////////

function viewManagerTable(){
	console.log("need to implement this")
}

function submitUser(){
    var ui = $('#userId').val();
    var uri = $('#userRoleId').val();
    var ue = $('#userEmail').val();
    var un = $('#userName').val();
    var p = $('#password').val();
    var fn = $('#firstname').val();
    var ln = $('#lastname').val();

    var users = {
            firstname: fn, 
            lastname: ln,
            password: p,
            useremail: ue,
            username: un,
            userroleid: uri,
            usersid: ui
    };

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 ){
            console.log(xhr.responseText);
            let b = JSON.parse(xhr.responseText);
            addUserToTable(b);
        }
    }
        xhr.open('POST', 'user', true);
        xhr.send(JSON.stringify(users));
}


//function newTicketView(){
//    console.log("Loading newTicketView");
//
//    var xhr = new XMLHttpRequest();
//    
//    xhr.onreadystatechange = function(){
//    	
//        if(xhr.readyState == 4 && xhr.status == 200){
//        	
//        	$('#viewLoader').html(xhr.responseText);     	
//
//        }
//}
//    xhr.open("GET", 'newTicket.view', true);
//    xhr.send();
//	
//}
////////////////////////////////////////////////////////////////
//function createTicket(x, y, z) {
//	   console.log('Loading createTicket to submit');
//		var xhr = new XMLHttpRequest();
//	    var count = 0;
//	    var uNum = 0;
//	    
//	    
//	    
//	    xhr.onreadystatechange = function(){
//
//	        if(xhr.readyState == 4 && xhr.status == 200){
//	        	
//	            var myObj = JSON.parse(this.responseText);
//	            console.log(myObj);
//	            
//	            myObj.forEach(function(arrayItem){
//	            	if(arrayItem.userName == uname){
//	            		uNum = count;
//	            	}
//	            	count++;
//	            });
//	            console.log(myObj[uNum]);  
//	            sendTicket(myObj[uNum]);
//	        }
//	    }
//	    xhr.open("GET", "http://localhost:8081/ers/login");
//	    xhr.send();	
//}

