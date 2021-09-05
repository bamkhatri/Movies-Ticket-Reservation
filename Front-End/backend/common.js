var TOKEN_KEY = "todoapp-token";

function sendHttpRequest(url, type, jsonData, successCallback) {

	var jsonString = null;

	if(jsonData != null)
		jsonString = JSON.stringify(jsonData)

	var config = { 
          url: url,
          type: type,
          data: jsonString,
      
          beforeSend: function(request) {  
            request.setRequestHeader("Content-Type", "application/json");
            request.setRequestHeader("Accept", "application/json");
            var token = localStorage.getItem(TOKEN_KEY);

            if(token != undefined)
              request.setRequestHeader("Authorization", "Bearer "+token); 
          },
          success: successCallback,
          error: handleError
    };
         
    $.ajax(config);
}


function handleError(error){
  var errorJson = error.responseJSON;
  if(error.status == 400)
      $("#divError").text(errorJson.message)
  else if(error.status == 401)
      window.location = "../unauthorized.html"
  else if(error.status == 403)
      window.location = "login.html"
  else
    alert(errorJson.message)

 }