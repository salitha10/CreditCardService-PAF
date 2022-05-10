
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

				<form id="formCreditCard" name="formCreditCard">

					<!-- Card number -->
					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblNum">Card Number: </span>
						</div>
						<input type="number" step="1" min="0" id="card_number"
							name="card_number">
					</div>

					<!-- CVV -->
					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblCvv">CVV: </span>
						</div>
						<input type="number" step="1" min="0" maxlength="3" id="cvv"
							name="cvv">
					</div>

					<!-- Name -->
					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblName">Name: </span>
						</div>
						<input type="text" id="name" name="name">
					</div>

					<!-- Expiry date -->
					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblDate">Expiry Date: </span>
						</div>
						<input type="date" id="exp_date" name="exp_date">
					</div>

					<!-- Issuer -->
					<div class="input-group input-group-sm mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblDate">Expiry Date: </span>
							<select id="issuer" name="issuer">
								<option value="0">--Select Card Issuer--</option>
								<option value="VISA">VISA</option>
								<option value="MASTER CARD">MASTER CARD</option>
								<option value="AMERICAN EXPRESS">AMERICAN EXPRESS</option>
							</select>
						</div>
					</div>


					<!-- Button -->
					<div class="input-group input-group-sm mb-3">
						<input class="btn btn-primary" type="button" id="btnSave"
							value="save">
					</div>

				</form>

				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>

				<div id="card_table"></div>
			</div>
			
		</div>
	</div>
</html>


