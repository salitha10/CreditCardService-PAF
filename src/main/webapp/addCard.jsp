
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html>

<link rel="stylesheet" href="Views/bootstrap.min.css" />
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/main.js"></script>

<head>
<meta charset="ISO-8859-1">
<title>Add New Credit Card</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-6">
				<h1 class="m-3">Add New Credit Card</h1>

				<form id="formCreditCard">

					<!-- Card number -->
					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblNum">Card Number: </span>
						</div>
						<input type="number" step="1" min="0" id="inpNum" name="inpNum">
					</div>

					<!-- CVV -->
					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblCvv">CVV: </span>
						</div>
						<input type="number" step="1" min="0" maxlength="3" id="inpCvv"
							name="inpCvv">
					</div>

					<!-- Name -->
					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblName">Name: </span>
						</div>
						<input type="text" id="inpName" name="inpName">
					</div>

					<!-- Expiry date -->
					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblName">Expiry Date: </span>
						</div>
						<input type="date" id="inpDate" name="inpDate">
					</div>

					<!-- Button -->
					<div class="input-group input-group-sm mb-3">
						<input class="btn btn-primary" type="button" id="btnSave"
							value="save">
					</div>

					<div id="alertSuccess" class="alert alert-success"></div>
					<div id="alertError" class="alert alert-danger"></div>

				</form>
			</div>
		</div>
	</div>

</html>


