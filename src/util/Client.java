package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

public class Client {

	public static JSONObject doGet(String url, String...parameters) {
		try {
			CloseableHttpClient client = HttpClientBuilder.create().build();
			for (String param : parameters) {
				url += param + "&";
			}
			HttpGet request = new HttpGet(url);
			HttpResponse response = client.execute(request);

			String str = "";
			// Get the response
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			String line = "";
			while ((line = rd.readLine()) != null) {
				str += line;
			}

			JSONObject json = new JSONObject(str);

			return json;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static JSONObject doPost(String url, List<NameValuePair> parameters) {
		try {
			CloseableHttpClient client = HttpClientBuilder.create().build();
			HttpPost post = new HttpPost();
			post.setEntity(new UrlEncodedFormEntity(parameters));
			String str = "";

			HttpResponse response = client.execute(post);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				str += line;
			}
			
			return new JSONObject(str);

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}