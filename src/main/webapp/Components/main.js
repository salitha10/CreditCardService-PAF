
var userID = "123";

$(document).ready(function() {
	$("#alertSuccess").hide();
	$("#alertError").hide();
	
	getAllCards(userID);
	
});


//SAVE BUTTON
$(document).on("click", "#btnSave", function(event) {

	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();


	$.ajax(
		{
			url: "CardsAPI",
			type: "POST",
			data: $("#formCreditCard").serialize(),
			dataType: "text",
			complete: function(response, status) {
				if (response.responseText == "Inserted Successfully" && status == "success") {
					$("#alertSuccess").text();
					$("#alertSuccess").show();
				} else {
					$("#alertError").text();
					$("#alertError").show();
				}
				//$("#formCreditCard").hide();
				$("#card_table").html(response.responseText);
				
			}
		});

});

function getAllCards(userID){
	$.ajax(
		{
			url: "CardsAPI",
			type: "GET",
			data: userID,
			dataType: "text",
			complete: function(response, status) {
				
				console.log(response);
			}
		});
}
