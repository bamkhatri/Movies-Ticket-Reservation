function getMovies(event){
   var url = "http://localhost:8080/MoviesTicketReservationWeb/movies/displaymovie"
  
   var onSuccess = function(response) {
      drawMovies(response);
   }

   sendHttpRequest(url, "GET", null, onSuccess)
};

function drawMovies(moviesList){
	console.log(moviesList);
	var nowShowing = "";
	var upcoming = "";

	for (var i = 0; i < moviesList.length; i++) {
		if(moviesList[i].type == "Now Showing"){
			nowShowing += "<div class=\"card\" onclick=\"addMovieId("+moviesList[i].id+")\">";
			nowShowing += "<img src=\"" +moviesList[i].poster+"\"" + "style=\"width:230px; height:250px\">";
			nowShowing += "<div class=\"container\">";
			nowShowing += "<h4><b>" +"<a href=\"booking.html\">"+moviesList[i].movieName+"</a>"+ "</b></h4>" + "<p>" + moviesList[i].cast+ "</p>";
			nowShowing += "<p>" + moviesList[i].type+ "</p>"
			nowShowing += "</div></div>"
		}else{
			upcoming += "<div class=\"card\" onclick=\"addMovieId("+moviesList[i].id+")\">";
			upcoming += "<img src=\"" +moviesList[i].poster+"\"" + "style=\"width:230px; height:250px\">";
			upcoming += "<div class=\"container\">";
			upcoming += "<h4><b>" +"<a href=\"booking.html\">"+moviesList[i].movieName+"</a>"+ "</b></h4>" + "<p>" + moviesList[i].cast+ "</p>";
			upcoming += "<p>" + moviesList[i].type+ "</p>"
			upcoming += "</div></div>"
		}
	}
	document.querySelector("#nowShowing").innerHTML = nowShowing;
	document.querySelector("#upcoming").innerHTML = upcoming;
}
