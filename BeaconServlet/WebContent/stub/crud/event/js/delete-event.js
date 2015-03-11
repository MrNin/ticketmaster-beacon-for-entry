// Function used to get parameters from URL
function getUrlParameter(sParam)
{
	var sPageURL = window.location.search.substring(1);
	var sURLVariables = sPageURL.split('&');
	for(var i = 0; i < sURLVariables.length; i++) {
		var sParameterName = sURLVariables[i].split('=');
		if (sParameterName[0] == sParam) {
			return sParameterName[1];
		}
	}
}

$(document).ready(function(){
	// Setup RESTful URL for Ajax call
	var camId = getUrlParameter('id');
	var restUrl = ("/BeaconServlet/api/rest/Event/"+camId);
	
	// Make Ajax call to get info on current Camera
	$.ajax({
			url: restUrl
		}).then(function(data) { 
			var template = $('#mustacheTemplate').html();
			var out = Mustache.render(template, data);
			$('#tableDiv').html(out);
		});
	
	// Form to delete camera is submitted 
	$("form#deleteForm").submit(function() {
		// Setup data for Ajax call (Pass in only the id of the camera)
		restUrl = ("/BeaconServlet/api/rest/Event");
		var myData = $("form#deleteForm").serialize();
		
		//Make Ajax call to delete camera at specified id
		$.ajax({
			type: 'DELETE',
			url: restUrl,
			data:myData,
			complete:function() {
				alert("DELETE request sent...");
			}
		});
		
	});// end form.submit()
	
});// end document.ready()



