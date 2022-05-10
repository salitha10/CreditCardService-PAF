package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CardsAPI") 
public class CardsAPI extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException
			{
			

//			 String user_ID = request.getParameter("");
			 String card_number = request.getParameter("card_number");
			 int cvv = Integer.parseInt(request.getParameter("cvv"));
			 String date = request.getParameter("exp_date");;
			 String name_on_card = request.getParameter("name");
			 String card_issuer =request.getParameter("issuer");

	
			 CreditCardController  cc = new CreditCardController();
			 String output = cc.insertCard(card_number, cvv, date, name_on_card, card_issuer);
			 
			 String html = "<h1>Hello</h1>";
			 //Get items
			 String cards = cc.viewCards();
			 
			 PrintWriter out = response.getWriter();
		     response.setContentType("application/json");
		     response.setCharacterEncoding("UTF-8");
			 response.getWriter().write(cards);
			 
			}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException
			{
			
			}

}
