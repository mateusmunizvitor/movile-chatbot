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
	
		TreeNode root = FullTree.instanciate();

		JSONObject botOption =  Client.doGet(urlbase+apibase+"getMe");
		JSONObject botInfo = botOption.getJSONObject("result");
		System.out.println(botInfo.get("first_name"));
		
		int lastId = 0;
		Map<Long, StateMachine> hash_user_statemachine = new LinkedHashMap<>();
		while(true){
			try {
				//String js = "{ keyboard: [[\"1\",\"2\"]] }";
				//System.out.println(js);
				
				
				
				JSONObject update = Client.doGet(urlbase+apibase+"getUpdates?limit=1&offset="+lastId);
				
				JSONArray result = update.getJSONArray("result");
				if(result.length() == 0) continue;
				
				
				JSONObject msg = result.getJSONObject(0).getJSONObject("message");
				Long chatId = msg.getJSONObject("chat").getLong("id");
				
				String usrMessage = (String) msg.get("text");
				int id = result.getJSONObject(0).getInt("update_id");
				lastId = id+1;
				
				JSONObject user = msg.getJSONObject("from");
				Long usrId = user.getLong("id");
				if(hash_user_statemachine.get(usrId) == null){
					hash_user_statemachine.put(usrId, new StateMachine(usrId.toString(), root));
					String returnToUsr = "Hello " + user.getString("first_name") + " how are you today?\n";
					List<NameValuePair> parameters = new ArrayList<>();
					parameters.add(new BasicNameValuePair("chat_id", chatId.toString()));
					parameters.add(new BasicNameValuePair("text", returnToUsr));
					JSONObject ret = Client.doPost(urlbase+apibase+"sendMessage", parameters);
				}
				
				System.out.println(user.getString("first_name") + ": " + usrMessage);
				StateMachine sm = hash_user_statemachine.get(usrId);
				
				
				String returnToUsr;
				if("/cancel".equals(usrMessage)){
					returnToUsr = "Order successfully cancelled! \nIf you want to try again please press /start \n";
					hash_user_statemachine.remove(usrId);
					List<NameValuePair> parameters = new ArrayList<>();
					parameters.add(new BasicNameValuePair("chat_id", chatId.toString()));
					parameters.add(new BasicNameValuePair("text", returnToUsr));
					JSONObject ret = Client.doPost(urlbase+apibase+"sendMessage", parameters);
					continue;
				} else if("/purchase".equals(usrMessage)){
					returnToUsr = "Great. Your order is done!";
					hash_user_statemachine.remove(usrId);
					List<NameValuePair> parameters = new ArrayList<>();
					parameters.add(new BasicNameValuePair("chat_id", chatId.toString()));
					parameters.add(new BasicNameValuePair("text", returnToUsr));
					JSONObject ret = Client.doPost(urlbase+apibase+"sendMessage", parameters);
					continue;
				}
				
				String processResult = sm.processMessage(usrMessage);
				String kbd = "{\"keyboard\":[";
				boolean hasKeyboard = false;
				String realResult = "";
				String[] messages = processResult.split("\n");
				
				for (int i = 0; i < messages.length; i++){
					if (messages[i].charAt(0) == '/'){
						hasKeyboard = true;
						kbd += "[\"" + messages[i] + "\"]";
						if (i != messages.length - 1) kbd += ",";
					}
					else realResult += messages[i];
				}

				kbd += "]}";
				returnToUsr = realResult;
				if("".equals(realResult)){
					returnToUsr = "Type your command again";
				}
				
				List<NameValuePair> parameters = new ArrayList<>();
				if (hasKeyboard)
					parameters.add(new BasicNameValuePair("reply_markup", kbd));
				parameters.add(new BasicNameValuePair("chat_id", chatId.toString()));
				parameters.add(new BasicNameValuePair("text", returnToUsr));
				JSONObject ret = Client.doPost(urlbase+apibase+"sendMessage", parameters);			
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		
	}
}
