/**
 *  Single JS script for entire bookstore app. 
 *  Separate functionality into methods and keep as 
 *  organized as possible.. as this will get lengthy
 */
window.onload=function(){
	loadHomeView();
	
	$('#homeNav').on('click', loadHomeView);
	$('#reimbursementsNav').on('click', loadReimbursementsView);
	
	//loadEmployeesView();
	$('#employeesNav').on('click', loadEmployeesView);
	
	
}

function loadHomeView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		//just showing what we're getting back for now
		//console.log(xhr.responseText);
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
		}
		
	}
	xhr.open("GET", "home.view", true);
	xhr.send();
}

function loadEmployeesView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		//just showing what we're getting back for now
		//console.log(xhr.responseText);
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			$('#toggleAdd').on('click', function(){
				$('#employeesView').removeAttr('hidden');		
				$('#toggleAdd').remove();
			});
			$('#addEmployee').on('click', submitEmployee);
			//once view is loaded, populate table and add eventlisteners
			populateEmployeeTable();
		}
		
	}
	xhr.open("GET", "employees.view");
	xhr.send();
}
function loadReimbursementsView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		//just showing what we're getting back for now
		//console.log(xhr.responseText);
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			$('#toggleAdd').on('click', function(){
				$('#reimbursmentsView').removeAttr('hidden');		
				$('#toggleAdd').remove();
			});
			$('#addReimbursement').on('click', submitReimbursement);
			//once view is loaded, populate table and add eventlisteners
			populateReimbursementTable();
		}
		
	}
	xhr.open("GET", "reimbursements.view");
	xhr.send();
}
function submitEmployee(){
	var eu = $('#emp_username').val();
	var ep = $('#emp_password').val();
	var fn = $('#first_name').val();
	var ln = $('#email').val();
	var eri = $('#emp_role').val();

	var employee = {
			emp_username: eu,
			emp_password: ep,
			first_name: fn,
			last_name: ln,
			emp_role_id: eri
	};
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 ){
			console.log(xhr.responseText);
			let b = JSON.parse(xhr.responseText);
			addEmployeeToTable(b);
		}
	}
		xhr.open('POST', 'employees', true); //may need to be employee
		xhr.send(JSON.stringify(employee));
}

function submitReimbursement(){
	var amo = $('#emount').val();
//	var sub = $('#submitted').val();
//	var res = $('#resolved').val();
	var des = $('description').val();
	var rec = $('#receipt').val();
	var aut = $('#author').val();
//	var rvr = $('#resolver').val();
	var sti = $('status_id').val();
	var tid = $('type_id').val();
	
	var reimbursement = {
			amount: amo,
//			submitted: sub,
//			resolved: res,
			description: des,
			receipt: rec,
			author: aut,
//			resolver: rvr,
			status_id: sti,
			type_id: tid
	};
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 ){
			console.log(xhr.responseText);
			let b = JSON.parse(xhr.responseText);
			addReimbursementToTable(b);
		}
	}
		xhr.open('POST', 'reimbursements', true); //may need to be reimbursement
		xhr.send(JSON.stringify(reimbursement));
}
function loadReimbursementsView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		//just showing what we're getting back for now
		//console.log(xhr.responseText);
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			//once view is loaded, populate table and add eventlisteners
			populateReimbursementsTable();
		}
		
	}
	xhr.open("GET", "reimbursements.view");
	xhr.send();
}


function populateEmployeeTable(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			employees = JSON.parse(xhr.responseText);
			console.log(employees);
			for(var e of employees){
				addEmployeeToTable(e); //helper function to create elements
			}
		}
		
	}
	xhr.open("GET", "employees");
	xhr.send();
}

function populateReimbursementTable(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			reimbursements = JSON.parse(xhr.responseText);
			console.log(reimbursements);
			for(var b of reimbursements){
				addReimbursementToTable(b); //helper function to create elements
			}
		}

	}
	xhr.open("GET", "books");
	xhr.send();
}

function addEmployeeToTable(b){
	 var row = document.createElement("tr");
	    var cell1 = document.createElement("td");
	    var cell2 = document.createElement("td");
	    var cell3 = document.createElement("td");
	    var cell4 = document.createElement("td");
	    var cell5 = document.createElement("td");
	    var cell6 = document.createElement("td");
	    var cell7 = document.createElement("td");
	    console.log(b);
	    cell1.innerHTML = b.employee_id;
	    cell2.innerHTML = b.emp_username;
	    cell3.innerHTML = b.emp_password;
	    cell4.innerHTML = b.first_name;
	    cell5.innerHTML = b.last_time;
	    cell6.innerHTML = b.email_time;
	    cell7.innerHTML = b.emp_role_id;
	    
	    row.appendChild(cell1);
	    row.appendChild(cell2);
	    row.appendChild(cell3);
	    row.appendChild(cell4);
	    row.appendChild(cell5);
	    row.appendChild(cell6);
	    row.appendChild(cell7);
	    
	    document.getElementById("employeeTable").appendChild(row);
}

function addReimbursement(b){
	 var row = document.createElement("tr");
	    var cell1 = document.createElement("td");
	    var cell2 = document.createElement("td");
	    var cell3 = document.createElement("td");
	    var cell4 = document.createElement("td");
	    var cell5 = document.createElement("td");
	    var cell6 = document.createElement("td");
	    var cell7 = document.createElement("td");
	    var cell8 = document.createElement("td");
	    var cell9 = document.createElement("td");
	    var cell10 = document.createElement("td");
	    console.log(b);
	    cell1.innerHTML = b.reimb_id;
	    cell2.innerHTML = b.amount;
	    cell3.innerHTML = b.submitted;
	    cell4.innerHTML = b.resolved;
	    cell5.innerHTML = b.description;
	    cell6.innerHTML = b.receipt;
	    cell7.innerHTML = b.author;
	    cell8.innerHTML = b.resolver;
	    cell9.innerHTML = b.status_id;
	    cell10.innerHTML = b.type_id;
	    
	    row.appendChild(cell1);
	    row.appendChild(cell2);
	    row.appendChild(cell3);
	    row.appendChild(cell4);
	    row.appendChild(cell5);
	    row.appendChild(cell6);
	    row.appendChild(cell7);
	    row.appendChild(cell8);
	    row.appendChild(cell9);
	    row.appendChild(cell10);
	    
	    document.getElementById("reimbursementTable").appendChild(row);
}
function loadGenreView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		//just showing what we're getting back for now
		//console.log(xhr.responseText);
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
		}
		
	}
	xhr.open("GET", "genre.view");
	xhr.send();
}

function loadAuthorView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		//just showing what we're getting back for now
		//console.log(xhr.responseText);
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
		}
		
	}
	xhr.open("GET", "author.view");
	xhr.send();
}