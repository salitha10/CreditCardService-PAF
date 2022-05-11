
var userID = "123";

$(document).ready(function() {
	$("#alertSuccess").hide();
	$("#alertError").hide();

	getAllCards(userID);

});

//Insert complete
function onItemSaveComplete(response, status) {
	if (status == "success") {

		var resultSet = JSON.parse(response.responseText);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#card_table").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}
}

//Delete complete
function onItemDeleteComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response.responseText);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#card_table").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}

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
				console.log(response.responseText);
				onItemSaveComplete(response, status);
			}
		});

});

function getAllCards(userID) {
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

$(document).on("click", "#btnRemove", function(event) {

	$.ajax(
		{
			url: "CardsAPI",
			type: "DELETE",
			data: "card_number=" + $(this).data("card_number"),
			dataType: "text",
			complete: function(response, status) {
				onItemDeleteComplete(response, status);

			}
		});
});
