window.onload=function(){
	loadHomeView();
	 $('#homeNav').on('click', loadHomeView);
	 $('#userNav').on('click', loadUserView);
	 $('#loginNav').on('click', loadLoginView);
}

function loadHomeView(){
	console.log("In loadhomeview")
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        //just showing what we're getting back for now
        if(xhr.readyState == 4 && xhr.status == 200){
        	$('#userNav').attr('hidden', 'true');
        	$('#logoutNav').attr('hidden', 'true');
        	$('#currentUserNav').attr('hidden', 'true');
            $('#loginNav').removeAttr('hidden');
        	$('#view').html('');
        }
    }
    xhr.open("GET", 'home.view', true);
    xhr.send();
}
//------------------------------------------HOME VIEW------------------------------------------------------------\\
function loadLoginView(){

    var xhr = new XMLHttpRequest();
    
    xhr.onreadystatechange = function(){
        //just showing what we're getting back for now
        //console.log(xhr.responseText);
        if(xhr.readyState == 4 && xhr.status == 200){
        	$('#view').html(xhr.responseText);
        	$('#homeNav').attr('class', 'nav-item nav-link');
            $('#userNav').attr('class', 'nav-item nav-link');
            $('#currentUserNav').attr('hidden', 'true');
            $('#loginNav').attr('class', 'nav-item nav-link active');
            document.getElementById('buttonId').addEventListener("click", loginValues);
        }
    }

    xhr.open("GET", "login.view");
    xhr.send(); 
    
}


function loginValues(uname, pword){
	console.log('inside login Values');
	var uname = document.getElementById('username').value;
    var pword = document.getElementById('password').value;
    getCredentials(uname, pword);
}

function getCredentials(uname, pword){
    console.log('inside credentials');
	var xhr = new XMLHttpRequest();
    var count = 0;
    var uNum = 0;
    xhr.onreadystatechange = function(){
        //just showing what we're getting back for now
        //console.log(xhr.responseText);
        if(xhr.readyState == 4 && xhr.status == 200){
            var myObj = JSON.parse(this.responseText);
            console.log(myObj);
            myObj.forEach(function(arrayItem){
            	if(arrayItem.username == uname){
            		uNum = count;
            	}
            	count++;
            })
            
            if(myObj[uNum].username == uname & myObj[uNum].password == pword){
            	console.log(myObj[uNum].userroleid);
            	if(myObj[uNum].userroleid == 2){
            		employee(myObj[uNum]);
            	} else if(myObj[uNum].userroleid == 3){
            		fin_manager(myObj[uNum]);
            	} else if(myObj[uNum].userroleid == 1){
            		loadUserView(myObj[uNum]);
            	}else {
	            	console.log("Invalid username/password");
	        		loadLoginView;
            	}
            	
            }
        }
    }

    xhr.open("GET", "login");
    xhr.send();
    
}

//----------------------------------------------LOGIN------------------------------------------------------------\\

//function admin(o){
//	$('#userNav').removeAttr('hidden');
//}

function fin_manager(o){
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        //just showing what we're getting back for now
        //console.log(xhr.responseText);
        if(xhr.readyState == 4 && xhr.status == 200){
        	$('#loginView').attr('hidden', 'true');
        	$('#homeNav').attr('hidden', 'true');
            $('#homeNav').attr('class', 'nav-item nav-link');
            $('#userNav').attr('hidden', 'true');
            $('#currentUserNav').removeAttr('hidden');
            $('#currentUserNav').attr('class', 'nav-item nav-link active');
            $('#loginNav').attr('hidden', 'true');
            $('#logoutNav').removeAttr('hidden');
            $('#view').html(xhr.responseText);
            $('#welcome').html("Welcome, " + o.firstname + " " + o.lastname);
            $('#submitBut').attr('hidden', 'true');
            $('#viewTix').attr('hidden', 'true');
            $('#fnManager').removeAttr('hidden');
            displayFnManTable(o);
            
            document.getElementById("logoutNav").addEventListener('click', function(){
            	loadLogOutView(o);
            })
            
            document.getElementById("adConfirm").addEventListener('click', function(){
            	var e = document.getElementById("reimBurse");
            	var i = e.options[e.selectedIndex].value;
            	var f = document.getElementById("acceptDeny");
            	var c = f.options[f.selectedIndex].value;
            	
            	updateReimb(o, i, c);
            })
            
            document.getElementById("viewHis").addEventListener('click', function(){
            	$('#hisHead').removeAttr('hidden');
            	getHisTable();
            })
        }

    }
    xhr.open("GET", "employee.view", true);
    xhr.send();
	
}

function getHisTable(){
	 var xhr = new XMLHttpRequest();
	    xhr.onreadystatechange = function(){
	        if(xhr.readyState == 4 && xhr.status == 200){
	            var b = JSON.parse(xhr.responseText);
	            var count = 0;
	            for(var tick of b){
	                addTicketToHis(b[count]);
	                count++;
	            }
	        }
	    }
	 xhr.open('GET', 'fmUpdate');
     xhr.send();
}

function addTicketToHis(b){
	console.log(b);
    var row = document.createElement("tr");
    var cell1 = document.createElement("td");
    var cell2 = document.createElement("td");
    var cell3 = document.createElement("td");
    var cell4 = document.createElement("td");
    var cell5 = document.createElement("td");
    var cell6 = document.createElement("td");
    var cell7 = document.createElement("td");
    var cell8 = document.createElement("td");
    	
    cell1.innerHTML = b.reimbid;
    cell2.innerHTML = b.reimbtype;
    cell3.innerHTML = b.status;
    cell4.innerHTML = b.amt;
    cell5.innerHTML = b.submitted;
    cell6.innerHTML = b.descrip;
    cell7.innerHTML = b.fname;
    cell8.innerHTML = b.lname;
    
    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);
    row.appendChild(cell5);
    row.appendChild(cell6);
    row.appendChild(cell7);
    row.appendChild(cell8);
    
    document.getElementById("hisTab").appendChild(row);

}

function updateReimb(o, i, c){
	
	var xhr = new XMLHttpRequest();
    var newObj = new Object();
    newObj.reimbid = i;
    newObj.statustypeid = c;
    newObj.type = o.type;
    newObj.usersid = o.usersid;
    newObj.userroleid = o.userroleid;
    newObj.useremail = o.useremail;
    newObj.username = o.username;
    newObj.password = o.password;
    newObj.fname = o.firstname;
    newObj.lname = o.lastname;
    newObj.descrip = o.descrip;
    
    console.log(newObj);
    
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200 ){
        }
    }
    xhr.open('POST', 'fmUpdate', true);
    xhr.send(JSON.stringify(newObj));
}

function displayFnManTable(o){

    var xhr = new XMLHttpRequest();
    console.log(o);
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            var b = JSON.parse(xhr.responseText);
            var count = 0;
            for(var tick of b){
            	console.log("inside for loop");
                addTicketToFn(b[count]); 
                addReimbToTab(b[count].reimbid);
                count++;
            }
            console.log(b);
        }
    }
    
    xhr.open("POST", "pendFm");
    xhr.send(JSON.stringify(o));
}

function addReimbToTab(b){
	var s = b.toString();
	var x = document.getElementById("reimBurse");
	var option = document.createElement("option");
	option.value = b;
	option.text = s;
	console.log(option.value);
	console.log(option.text);
	x.add(option);
}

function addTicketToFn(b){
    var row = document.createElement("tr");
    var cell1 = document.createElement("td");
    var cell2 = document.createElement("td");
    var cell3 = document.createElement("td");
    var cell4 = document.createElement("td");
    var cell5 = document.createElement("td");
    var cell6 = document.createElement("td");
    var cell7 = document.createElement("td");
    var cell8 = document.createElement("td");
    	
    cell1.innerHTML = b.reimbid;
    cell2.innerHTML = b.reimbtype;
    cell3.innerHTML = b.status;
    cell4.innerHTML = b.amt;
    cell5.innerHTML = b.submitted;
    cell6.innerHTML = b.descrip;
    cell7.innerHTML = b.fname;
    cell8.innerHTML = b.lname;
    
    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);
    row.appendChild(cell5);
    row.appendChild(cell6);
    row.appendChild(cell7);
    row.appendChild(cell8);
    
    document.getElementById("fnManTab").appendChild(row);

}
//------------------------------------------Finance Manager-------------------------------------------------------\\
function employee(o){
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
        	$('#loginView').attr('hidden', 'true');
        	$('#homeNav').attr('hidden', 'true');
            $('#homeNav').attr('class', 'nav-item nav-link');
            $('#userNav').attr('hidden', 'true');
            $('#currentUserNav').removeAttr('hidden');
            $('#currentUserNav').attr('class', 'nav-item nav-link active');
            $('#loginNav').attr('hidden', 'true');
            $('#view').html(xhr.responseText);
            $('#employeeV').removeAttr('hidden');
        	$('#fnManager').attr('hidden', 'true');
            $('#logoutNav').removeAttr('hidden');
            $('#viewPast').removeAttr('hidden');
            $('#welcome').html("Welcome, " + o.firstname + " " + o.lastname);
            document.getElementById("submitBut").addEventListener('click', function(){
            	$('#tixForm').removeAttr('hidden');
            })
            document.getElementById("sendBut").addEventListener('click', function(){
            	var type = $('#reimb').val();
            	var amt = $('#amount').val();
            	var descrip = $('#descrip').val();
            	sendTicket(o, type, amt, descrip);
            })
            
            document.getElementById("viewTix").addEventListener('click',function(){
            	$("#tickHead").removeAttr('hidden');
            	viewPend(o); //sends o object with username
            })
            document.getElementById("logoutNav").addEventListener('click', function(){
            	loadLogOutView(o);
            })
            
            document.getElementById("viewPast").addEventListener('click', function(){
            	$("#pastHead").removeAttr('hidden');
            	seePast(o);
            })
             document.getElementById("currentUserNav").addEventListener('click', function(){
            	console.log('usernav clicked');
            	employee(o);
            })
        }

    }
    xhr.open("GET", "employee.view", true);
    xhr.send();
}

function seePast(o){
	 var xhr = new XMLHttpRequest();
	    var newObj = new Object();
	    newObj.usersid = o.usersid;
	    newObj.userroleid = o.userroleid;
	    newObj.useremail = o.useremail;
	    newObj.username = o.username;
	    newObj.password = o.password;
	    newObj.fname = o.firstname;
	    newObj.lname = o.lastname;
	    
	    console.log(newObj);
	    
	    xhr.onreadystatechange = function(){
	        if(xhr.readyState == 4 && xhr.status == 200 ){
	        	let b = JSON.parse(xhr.responseText);
	        	var count = 0;
	            for(var tick of b){
	                addTicketToPast(b[count]); //helper function to create elements
	                count++;
	            }
	        }
	    }
	    xhr.open('POST', 'pastTick', true);
	    xhr.send(JSON.stringify(newObj));
}

function addTicketToPast(b){
	 var row = document.createElement("tr");
	    var cell1 = document.createElement("td");
	    var cell2 = document.createElement("td");
	    var cell3 = document.createElement("td");
	    var cell4 = document.createElement("td");
	    var cell5 = document.createElement("td");
	    var cell6 = document.createElement("td");
	    var cell7 = document.createElement("td");
	    cell1.innerHTML = b.reimbid;
	    cell2.innerHTML = b.status;
	    cell3.innerHTML = b.reimbtype;
	    cell4.innerHTML = b.amt;
	    cell5.innerHTML = b.descrip;
	    cell6.innerHTML = b.resolved;
	    cell7.innerHTML = b.resolver;

	    row.appendChild(cell1);
	    row.appendChild(cell2);
	    row.appendChild(cell3);
	    row.appendChild(cell4);
	    row.appendChild(cell5);
	    row.appendChild(cell6);
	    row.appendChild(cell7);
	    
	    document.getElementById("ePastTable").appendChild(row);
}

function sendTicket(o, type, amt, descrip){

    var xhr = new XMLHttpRequest();
    var newObj = new Object();
    newObj.amt = amt;
    newObj.type = type;
    newObj.usersid = o.usersid;
    newObj.userroleid = o.userroleid;
    newObj.useremail = o.useremail;
    newObj.username = o.username;
    newObj.password = o.password;
    newObj.fname = o.firstname;
    newObj.lname = o.lastname;
    newObj.descrip = descrip;
    
    console.log(newObj);
    
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200 ){
        }
    }
    xhr.open('POST', 'employee', true);
    xhr.send(JSON.stringify(newObj));
}

function viewPend(o){

	var newObj = new Object();
    
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            let b = JSON.parse(xhr.responseText);
            var count = 0;
            for(var tick of b){
                addTicketToTable(b[count]); //helper function to create elements
                count++;
            }
            //populateEmployeeTable();
            console.log(b);
        }
    }
        xhr.open('POST', 'employeePend', true);
        xhr.send(JSON.stringify(o));
}

function addTicketToTable(b){
    var row = document.createElement("tr");
    var cell1 = document.createElement("td");
    var cell2 = document.createElement("td");
    var cell3 = document.createElement("td");
    var cell4 = document.createElement("td");
    var cell5 = document.createElement("td");
    var cell6 = document.createElement("td");
    cell1.innerHTML = b.reimbtype;
    cell2.innerHTML = b.amt;
    cell3.innerHTML = b.descrip;
    cell4.innerHTML = b.resolver;
    cell5.innerHTML = b.submitted;
    cell6.innerHTML = b.status;

    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);
    row.appendChild(cell5);
    row.appendChild(cell6);

    document.getElementById("eTickTable").appendChild(row);

}

function loadLogOutView(o){
    
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
        	document.getElementById("submitBut").style.visibility="hidden";
        	document.getElementById("viewTix").style.visibility="hidden";
        	$('#loginView').attr('hidden', 'true');
        	$('#homeNav').attr('hidden', 'true');
            $('#homeNav').attr('class', 'nav-item nav-link');
            $('#userNav').attr('hidden', 'true');
            $('#currentUserNav').removeAttr('hidden');
            $('#currentUserNav').attr('class', 'nav-item nav-link');
            $('#loginNav').attr('hidden', 'true');
            $('#logoutNav').removeAttr('hidden');
            $('#logoutNav').attr('class', 'nav-item nav-link active')
            $('#welcome').html("Are you sure you want to log out, " + o.firstname + "?");
            $('#confirm').removeAttr('hidden');
            $('#viewPast').attr('hidden', 'true');
            document.getElementById("confirm").addEventListener('click', function(){
            	console.log("confirm clicked");
            	$('#homeNav').removeAttr('hidden');
            	loadHomeView();
            })
        }
    }
        xhr.open('GET', 'employee.view', true);
        xhr.send();
}

function adminLogOutView(o){
    
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
        	$('#loginView').attr('hidden', 'true');
        	$('#homeNav').attr('hidden', 'true');
            $('#homeNav').attr('class', 'nav-item nav-link');
            $('#adminNav').attr('hidden', 'true');
            $('#currentUserNav').attr('hidden', 'true');
            $('#currentUserNav').attr('class', 'nav-item nav-link');
            $('#loginNav').attr('hidden', 'true');
            $('#logoutNav').removeAttr('hidden');
            $('#logoutNav').attr('class', 'nav-item nav-link active')
            $('#view').html(xhr.responseText);
            $('#welcome').html("Are you sure you want to log out, " + o.firstname + "?");
            $('#confirm').removeAttr('hidden');
            $('#viewPast').attr('hidden', 'true');
            document.getElementById("confirm").addEventListener('click', function(){
            	$('#homeNav').removeAttr('hidden');
            	$('#adminView').attr('hidden', 'true');
            	loadHomeView();
            })
        }
    }
        xhr.open('GET', 'admin.view', true);
        xhr.send();
}
//--------------------------------------------EMPLOYEE------------------------------------------------------------\\
function loadUserView(o){
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){

        //just showing what we're getting back for now
        //console.log(xhr.responseText);
        if(xhr.readyState == 4 && xhr.status == 200){
        	$('#userNav').removeAttr('hidden', 'true');
        	$('#loginView').attr('hidden', 'true');
            $('#currentUserNav').attr('hidden', 'true');
            $('#userNav').attr('class', 'nav-item nav-link active');
            $('#loginNav').attr('class', 'nav-item nav-link');
            $('#loginNav').attr('hidden', 'true');
            $('#homeNav').attr('hidden', 'true');
            $('#view').html(xhr.responseText);
            $('#logoutNav').removeAttr('hidden');
            $('#toggleAdd').on('click', function(){
                $('#userView').removeAttr('hidden');
            });
            $('#addUser').on('click', submitUser);
            //once view is loaded, populate table and add eventlisteners
            populateUserTable();
            document.getElementById("logoutNav").addEventListener('click', function(){
            	adminLogOutView(o);
            })
 
        }

    }
    xhr.open("GET", "user.view", true);
    xhr.send();
   
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

function populateUserTable(){
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            user = JSON.parse(xhr.responseText);
            console.log(user);
            for(var b of user){
                addUserToTable(b); //helper function to create elements
            }
        }

}
    xhr.open("GET", "user");
    xhr.send();
}

function addUserToTable(b){
    var row = document.createElement("tr");
    var cell1 = document.createElement("td");
    var cell2 = document.createElement("td");
    var cell3 = document.createElement("td");
    var cell4 = document.createElement("td");
    var cell5 = document.createElement("td");
  
    cell1.innerHTML = b.username;
    cell2.innerHTML = b.firstname;
    cell3.innerHTML = b.lastname;
    cell4.innerHTML = b.useremail;
    cell5.innerHTML = b.userroleid;

    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);
    row.appendChild(cell5);

    document.getElementById("userTable").appendChild(row);
}