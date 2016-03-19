package movile;

import org.json.JSONObject;

import util.Client;

public class Main {
	static final String urlbase = "https://api.telegram.org/bot";
	static final String apibase = "192610098:AAEGaQN3juTYXBotgkRFxKbMP8FXRI9JAmw/";
	public static void main(String[] args) {
	
		JSONObject obj =  Client.doGet(urlbase+apibase+"getMe");
		JSONObject obj2 = obj.getJSONObject("result");
		System.out.println(obj2.get("first_name"));
		
		JSONObject update = Client.doGet(urlbase+apibase+"getUpdates");
		JSONObject msg = update.getJSONObject("message");
		
		JSONObject txt = msg.getJSONObject("text");
		System.out.println(txt);
	}
}
