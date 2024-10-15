package SeleniumPracticeTesting.SeleniumPracticeTesting;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Sep25 {
	private static final String Jokes_URI = "https://official-joke-api.appspot.com/jokes/programming/ten";

	public static void main(String[] args) {

          HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(Jokes_URI)).GET().build();

		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			ObjectMapper mapper = new ObjectMapper();
			JsonNode jsonNode = mapper.readTree(response.body());
			System.out.println(jsonNode);
			String bitcoinPriceUsd = jsonNode.get(0).asText();
			System.out.println(bitcoinPriceUsd);

		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
