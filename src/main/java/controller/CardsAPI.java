package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/CardsAPI")
public class CardsAPI extends HttpServlet {

	CreditCardController cc = new CreditCardController();

	// Convert request parameters to a Map
	private static Map getParasMap(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
			scanner.close();
			String[] params = queryString.split("&");
			for (String param : params) {
				String[] p = param.split("=");
				map.put(p[0], p[1]);
			}
		} catch (Exception e) {
		}
		return map;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Gson gson =  new Gson();
		String res;
//			 String user_ID = request.getParameter("");
		String card_number = request.getParameter("card_number");
		int cvv = Integer.parseInt(request.getParameter("cvv"));
		String date = request.getParameter("exp_date");
		String name_on_card = request.getParameter("name");
		String card_issuer = request.getParameter("issuer");

		String output = cc.insertCard(card_number, cvv, date, name_on_card, card_issuer);

		// Get items
		String cards = cc.viewCards();

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		if(output == "Inserted Successfully") {
			res = "{\"status\":\"success\", \"data\": \"" + cards + "\"}";
		}
		else{
			res = "{\"status\":\"error\", \"data\": \"" + output + "\"}";
		}
		
		response.getWriter().write(res);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map paras = getParasMap(request);

		String card_number = paras.get("card_number").toString();
		int cvv = Integer.parseInt(paras.get("cvv").toString());
		String date = paras.get("exp_date").toString();
		String name_on_card = paras.get("name").toString();
		String card_issuer = paras.get("issuer").toString();

		String output = cc.updateCard(card_number, cvv, date, name_on_card, card_issuer);
		response.getWriter().write(output);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map paras = getParasMap(request);
		String output = cc.deleteCard(paras.get("card_number").toString());
		
		String cards = cc.viewCards();
		
		if(output != "error") {
			output = "{\"status\":\"success\", \"data\": \"" + cards + "\"}";
		}
		else{
			output = "{\"status\":\"error\", \"data\": \"" + output + "\"}";
		}
		response.getWriter().write(output);
	}

}
