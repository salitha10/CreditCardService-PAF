
var userID = "123";

$(document).ready(function() {
	$("#alertSuccess").hide();
	$("#alertError").hide();
	$("#allCardsTable").hide();


});

//Insert complete
function onItemSaveComplete(response, status) {
	if (status == "success") {

		var resultSet = JSON.parse(response.responseText);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			
			//Show table
			$("#allCardsTable").show();
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
			$("#allCardsTable").show();
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
	
	$("#card_number").prop('disabled', false);
	var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT";

	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();


	$.ajax(
		{
			url: "CardsAPI",
			type: type,
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


$(document).on("click", "#btnUpdate", function(event) {

	$("#txtForm").text("Update Card");

	$("#hidItemIDSave").val($(this).closest("tr").find('td:eq(0)').text());
	$("#card_number").val($(this).closest("tr").find('td:eq(0)').text());
	$("#card_number").prop('disabled', true);
	
	$("#cvv").val($(this).closest("tr").find('td:eq(1)').text());
	$("#name").val($(this).closest("tr").find('td:eq(3)').text());
	$("#exp_date").val($(this).closest("tr").find('td:eq(2)').text());
	$("#issuer").val($(this).closest("tr").find('td:eq(4)').text());

});