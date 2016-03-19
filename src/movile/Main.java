package movile;

import org.json.JSONObject;

import util.Client;

public class Main {
	static final String urlbase = "https://api.telegram.org/bot";
	static final String apibase = "192610098:AAEGaQN3juTYXBotgkRFxKbMP8FXRI9JAmw/";
	public static void main(String[] args) {
	
		TreeNode root = new TreeNode("root","root",null,null);
		
		TreeNode cursor;

		root.addChild("category","pizza",null);
		cursor = root.getChild("pizza");
		cursor.addChild("restaurant","Friend Brothers",null);
		// Friend Brother's Pizza
		
		cursor = root.getChild("Friend Brother's Pizzeria");
		cursor.addChild("meal", "Main course", null);
		cursor.addChild("meal", "Drink", null);
		cursor = cursor.getChild("Main Course");
		cursor.addChild("food", "Cockatrice Pizza", 
				new Item("Cockatrice Pizza","001",999999));
		cursor.addChild("food", "Paperoni Pizza", 
				new Item("Paperoni Pizza","002",0.5));
		cursor = cursor.getFather().getChild("Drink");
		cursor.addChild("food", "MtnDew", new Item("MtnDew", "012", 5));
		
		while(true){
			

		}
		
		JSONObject obj =  Client.doGet(urlbase+apibase+"getMe");
		JSONObject obj2 = obj.getJSONObject("result");
		System.out.println(obj2.get("first_name"));
		
		JSONObject update = Client.doGet(urlbase+apibase+"getUpdates");
		JSONObject msg = update.getJSONObject("message");
		
		JSONObject txt = msg.getJSONObject("text");
		System.out.println(txt);
	}
}
