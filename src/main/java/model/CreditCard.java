package model;

public class CreditCard {
	private String user_ID;
	private String card_number;
	private int cvv;
	private String date;
	private String name_on_card;
	private String card_issuer;


	//Constructor
	public CreditCard(String user_ID, String card_number, int cvv, String date, String name_on_card, String card_issuer) {
		super();
		this.user_ID = user_ID;
		this.card_number = card_number;
		this.cvv = cvv;
		this.date = date;
		this.name_on_card = name_on_card;
		this.card_issuer = card_issuer;
	}
	
	public CreditCard(String user_ID, int cvv, String date, String name_on_card, String card_issuer) {
		super();
		this.user_ID = user_ID;
		this.card_number = card_number;
		this.cvv = cvv;
		this.date = date;
		this.name_on_card = name_on_card;
		this.card_issuer = card_issuer;
	}


	//Getters and setters
	public String getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}

	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName_on_card() {
		return name_on_card;
	}

	public void setName_on_card(String name_on_card) {
		this.name_on_card = name_on_card;
	}

	public String getCard_issuer() {
		return card_issuer;
	}

	public void setCard_issuer(String card_issuer) {
		this.card_issuer = card_issuer;
	}
}
