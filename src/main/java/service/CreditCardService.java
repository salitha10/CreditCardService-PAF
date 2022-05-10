package service;

import java.util.ArrayList;

import model.CreditCard;

public interface CreditCardService {
	public String insertCreditCard(CreditCard card);
	public String deleteCard(String  card_ID);
	public ArrayList<CreditCard> viewCards(String user_ID);
	public String updateCard(String old_card, CreditCard card);
}
