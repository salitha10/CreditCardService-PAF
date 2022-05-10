
$(document).ready(function() {
	$("#alertSuccess").hide();
	$("#alertError").hide();
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
					$("#alertSuccess").text(response.responseText);
					$("#alertSuccess").show();
				} else {
					$("#alertError").text(response.responseText);
					$("#alertError").show();
				}
			}
		});


});

