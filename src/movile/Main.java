package movile;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
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

		JSONObject botOption =  Client.doGet(urlbase+apibase+"getMe");
		JSONObject botInfo = botOption.getJSONObject("result");
		System.out.println(botInfo.get("first_name"));
		
		int lastId = 0;
		while(true){
			JSONObject update = Client.doGet(urlbase+apibase+"getUpdates?limit=1&offset="+lastId);
			
			JSONArray result = update.getJSONArray("result");
			if(result.length() == 0) continue;
			
			JSONObject msg = result.getJSONObject(0).getJSONObject("message");
			Long chatId = msg.getJSONObject("chat").getLong("id");
			
			String txt = (String) msg.get("text");
			int id = result.getJSONObject(0).getInt("update_id");
			JSONObject user = msg.getJSONObject("from");
			
			lastId = id+1;
			System.out.println(user.getString("first_name") + ": " + txt);
			
			List<NameValuePair> parameters = new ArrayList<>();
			parameters.add(new BasicNameValuePair("chat_id", chatId.toString()));
			parameters.add(new BasicNameValuePair("text", "Fala leks!"));
			
			JSONObject ret = Client.doPost(urlbase+apibase+"sendMessage", parameters);
		}
		
	}
}
