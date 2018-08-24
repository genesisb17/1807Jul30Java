window.onload = function() {
	windowLoad();
	
}

function windowLoad() {
	loadHomeView();
	$('#logoutIcon').click(back2LoginView);
	
    
}

function loadHomeView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			$('#loginBtn').click(loadAccntView);
			$('#createBtn').click(loadCreateView);
		}
		
	}
	xhr.open("GET", "login.view", true);
	xhr.send();
	
	
}

function loadAccntView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			$('#logoutLink').removeAttr('hidden');
		}
		
	}
	xhr.open("GET", "account.view", true);
	xhr.send();

	var xhr2 = new XMLHttpRequest();
	xhr2.onreadystatechange = function(){
		
		if(xhr2.readyState == 4 && xhr2.status == 200){
			$('#navMenu').html(xhr2.responseText);
			$('#accntNav').addClass("active");
		}
		
	}
	xhr2.open("GET", "menu.view", true);
	xhr2.send();
	
}

function loadCreateView() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			
		}
		
	}
	xhr.open("GET", "create.view", true);
	xhr.send();
}

function back2LoginView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
		}
		
	}
	xhr.open("GET", "login.view", true);
	xhr.send();
	
}
