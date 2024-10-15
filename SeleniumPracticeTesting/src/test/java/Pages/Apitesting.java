package Pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Apitesting {

	public void getRequest() throws IOException {
		String urlString = "https://official-joke-api.appspot.com/jokes/programming/random";

		// Create a URL object
		URL url = new URL(urlString);

		// Open a connection
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// Set the request method to GET
		connection.setRequestMethod("GET");

		// Set request headers if needed (optional)
		connection.setRequestProperty("Accept", "application/json");

		int responseCode = connection.getResponseCode();

		System.out.println("Response Code: " + responseCode);

		assertEquals(responseCode, HttpURLConnection.HTTP_OK, "Expected response code 200");

		try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
			String responseBody = in.lines().reduce("", (acc, line) -> acc + line);
			System.out.println("Response Body: " + responseBody);

			assertTrue(responseBody.contains("Programming"), "Response body should contain 'programming'");
			assertTrue(responseBody.contains("data"), "Response body should contain 'data'");
		}

	}
}
