
$(document).ready(function()
{
 $("#alertSuccess").hide();
 $("#alertError").hide();
});


$(document).on("click", "#btnSave", function(event)
{

$("#alertSuccess").text("");
$("#alertSuccess").hide();
$("#alertError").text("");
$("#alertError").hide();

	// Form validation-------------------
var status = validateItemForm();
// If not valid
if (status != true)
{
 $("#alertError").text(status);
 $("#alertError").show();
return;
}
	
});



