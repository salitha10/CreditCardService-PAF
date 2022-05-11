package controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.protobuf.TextFormat.ParseException;
import model.CreditCard;
import service.CreditCardService;
import service.CreditCardServiceImpl;


@Path("/CreditCard")
public class CreditCardController {


	//Card service
	CreditCardService cardService = new CreditCardServiceImpl();

	ArrayList<CreditCard> cards= new ArrayList<>();


	String currentUser = "123";

	//Insert
	@POST
	@Path("/New")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertCard(@FormParam("card_number") String cardNumber, @FormParam("cvv") int cvv
			,@FormParam("date") String date, @FormParam("name_on_card") String name, @FormParam("card_issuer") String issuer) {

		String output = "";
		
		
		if(currentUser.equals("login failed")) {
			
			System.err.println("Login failed");
			
		}else {

			//Validate card number
			if(cardNumber.length() > 19 || cardNumber.length() == 0){
				output += " Invalid card Number";
			}

			//Validate cvv
			if(cvv == 0 || cvv > 9999) {
				output += " Invalid CVV";
			}

			//Validate Name on card
			if(name.length() == 0){
				output += " Invalid Name";
			}

			//Validate card issuer
			if(issuer.length() == 0) {
				output += " Invalid Issuer";
			}

			//Execute Insert
			if(output == "") {
				output = cardService.insertCreditCard(new CreditCard(
						currentUser, cardNumber, cvv, date, name, issuer));
			}

		}
		
		return output;
	}


	//View
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public String viewCards() {
		String output = "";
		
		cards = cardService.viewCards(currentUser);
		
		if(cards == null) {
			output = "Error loading data";
		}
		else {
		//Return table
		output = "<table class='table table-striped' border='1'>"
				 + "<caption>List of users</caption>"
				 + "<tr><th>Card Number</th>"
				 + "<th>CVV</th>"
				 + "<th>Expiery Date</th>"
				 + "<th>Name</th>"
				 + "<th>Card Issuer</th>"
				 + "<th>Update</th><th>Remove</th></tr>";
		
		Iterator iter = cards.iterator();
	      while (iter.hasNext()) {
	    	  CreditCard card = (CreditCard) iter.next();
	    	  
	    	  output += "<tr><td>" + card.getCard_number() + "</td>";
	    	  output += "<td>" + card.getCvv() + "</td>";
	    	  output += "<td>" + card.getCard_issuer() + "</td>";
	    	  output += "<td>" + card.getDate() + "</td>";
	    	  output += "<td>" + card.getCard_issuer() + "</td>"; 
	    	  
	    	  
	    	  output += "<td><input name='btnUpdate' type='button' value='Update' "
	    			  + "class='btnUpdate btn btn-secondary' data-card_number='" + card.getCard_number() + "'></td>"
	    			  + "<td><input id='btnRemove' type='button' value='Remove' "
	    			  + "class='btn btn-danger' data-card_number='" + card.getCard_number() + "'></td></tr>";
	      }

		}
		return output;
	}

	//Delete
	@DELETE
	@Path("/{card_number}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteCard(@PathParam("card_number") String CardNum) {
		String response = cardService.deleteCard(CardNum);
		return response;
	}


	//Update
	@PUT
	@Path("/Updatecard/{old_card}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateCard(@PathParam("old_card") String old_card, @FormParam("cvv") int cvv
			,@FormParam("date") String date, @FormParam("name_on_card") String name, @FormParam("card_issuer") String issuer) {

		String output = "";
		

		//Validate cvv
		if(cvv == 0 || cvv > 9999){
			output += " Invalid CVV";
		}

		//Validate Name on card
		if(name.length() == 0){
			output += " Invalid Name";
		}

		//Validate card issuer
		if(issuer.length() == 0){
			output += " Invalid Issuer";
		}

		if(output == "") {
			output = cardService.updateCard(old_card, new CreditCard(
					null, cvv, date, name, issuer));
		}

		return output;
	}
}
