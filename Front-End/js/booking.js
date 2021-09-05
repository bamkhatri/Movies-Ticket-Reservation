function calcTotal(){
	var noOfSeat = document.querySelector("#seat");
	var price = document.querySelector("#price");
	console.log(price.value)
	var totalPrice = document.querySelector("#totPrice");

	totalPrice.value = noOfSeat.value*price.value;

	console.log(totalPrice.value)
}


// function getMovies(event){
//    var url = "http://localhost:8080/MoviesTicketReservationWeb/movies/displaymovie"
  
//    var onSuccess = function(response) {
//       drawMovies(response);
//    }

//    sendHttpRequest(url, "GET", null, onSuccess)
// };

// function drawMovies(movieDetails){
// 	console.log(movieDetails);
// 	var poster = "";

// 	poster += "<div class=\"card\" onclick=\"addMovieId("+movieDetails[i].id+")\">";
// 	poster += "<img src=\"" +movieDetails[i].poster+"\"" + "style=\"width:230px; height:250px\">";
// 	poster += "<div class=\"container\">";
// 	poster += "<h4><b>" +"<a href=\"booking.html\">"+movieDetails[i].movieName+"</a>"+ "</b></h4>" + "<p>" + movieDetails[i].cast+ "</p>";
// 	poster += "<p>" + movieDetails[i].type+ "</p>"
// 	poster += "</div></div>"	
// }

var poster = "";

	poster += "<div class=\"card\" onclick=\"addMovieId("+"himal"+")\">";
	// poster += "<img src=\"" +"https://m.media-amazon.com/images/M/MV5BMjE5MjkwODI3Nl5BMl5BanBnXkFtZTcwNjcwMDk4NA@@._V1_.jpg"+"\"" + "style=\"width:230px; height:230px\">";
	poster += "<div class=\"container\">";
	poster += "<h4><b>" +"<a href=\"booking.html\">"+"Himal Pandey"+"</a>"+ "</b></h4>" + "<p>" +"bam khatri"+ "</p>";
	poster += "<p>" + "Horror"+ "</p>"
	poster += "</div></div>"


document.querySelector("#poster").innerHTML = poster;

