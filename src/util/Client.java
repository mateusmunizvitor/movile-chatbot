package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

public class Client {

	public static JSONObject doGet(final String URL) {
		try {
			CloseableHttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(URL);
			HttpResponse response = client.execute(request);
		
			String str = "";
			// Get the response
			BufferedReader rd = new BufferedReader
			  (new InputStreamReader(response.getEntity().getContent()));
			    
			String line = "";
			while ((line = rd.readLine()) != null) {
			  str += line;
			}
			
			JSONObject json = new JSONObject(str);
			
			return json;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


}