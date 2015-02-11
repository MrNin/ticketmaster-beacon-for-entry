$(document).ready(function(){
	$.ajax({
		url: "/BeaconServlet/api/rest/Roster/Event/1"
	}).then(function(data) {
		
		//**************************//
		//		for each item		//
		//**************************//
		$.each(data, function(i, item) {
			$("#results").append(
				"<p>Visitor ID: " + item.visitor[0].id + "</p>" +
				"<p>Visitor Username: " + item.visitor[0].username + "</p>" +
				"<p>Visitor Password: " + item.visitor[0].password + "</p>" +
				"<p>First name: " + item.visitor[0].firstName + "</p>" +
				"<p>Last name: " + item.visitor[0].lastName + "</p>" +
				
				"<p>Attended? " + item.didAttend + "</p>" +
				
				"<p>Event ID: " + item.event[0].id + "</p>" +
				"<p>Event Name: " + item.event[0].name + "</p>" +
				"<p></p>"
			);			
		}) //end of .each item
		
		
	});
});