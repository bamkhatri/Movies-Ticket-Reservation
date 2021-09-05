function feedback(event) {
  event.preventDefault();
  var email = $("#email").val();
  var subject = $("#subject").val();
  var feedbackBody = $("#feedbackBody").val();


  var feedbackJson = {
        "email":email,
        "subject" : subject,
        "body":feedbackBody
  }
  console.log(feedbackJson)

  var url = "http://localhost:8080/MoviesTicketReservationWeb/feedback/registerfeedback"

  var onSuccess = function(response) {
      alert("Feedback is Success")
  		window.location = "index.html";
  };

  sendHttpRequest(url, "POST", feedbackJson, onSuccess);
}