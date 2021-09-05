function login(event) {
  
	event.preventDefault();
	var email = $("#email").val();
	var password = $("#pword").val();

			
	var userJson = {
		"email" : email,
		"password":password

	}

	console.log(userJson);
	
	var url = "http://localhost:8080/MoviesTicketReservationWeb/user/login"

    var onSuccess = function(response) {
        var token = response.token;
        localStorage.setItem(TOKEN_KEY,token);
        window.location = "index.html";
    };

    sendHttpRequest(url, "POST", userJson, onSuccess);
};


//Regestration JS Code
function register(event) {
  event.preventDefault();
  var fname = $("#fname").val();
  var email = $("#email").val();
  var mobileNo = $("#mobileNo").val();
  var password = $("#pword").val();
  var gender = $("#gender").val();
  var dob = $("#dob").val();
  var location = $("#loc").val();

  if(fname == "Himal"){
    document.querySelector(".errors").innerHTML = "Please Enter Valid Input!!!";
    return false;
  }else{
    document.querySelector(".errors").innerHTML = "";
  }

  var userJson = {
        "name" : fname,
        "email":email,
        "mobileNo" : mobileNo,
        "password":password,
        "gender" : gender,
        "dob":dob,
        "location" : location

  }
  console.log(userJson)

  var url = "http://localhost:8080/MoviesTicketReservationWeb/user/register"

  var onSuccess = function(response) {
      alert("Register is Success")
  		window.location = "index.html";
  };

  sendHttpRequest(url, "POST", userJson, onSuccess);
}

function logOut(){
  localStorage.removeItem(TOKEN_KEY);
  window.location = "login.html";
}
