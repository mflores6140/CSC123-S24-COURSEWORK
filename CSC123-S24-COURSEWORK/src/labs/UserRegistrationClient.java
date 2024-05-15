package labs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class UserRegistrationClient {
	private static int idCounter = 1;
	
    private static final String API_ENDPOINT = "https://e3m1dkivq8.execute-api.us-west-1.amazonaws.com/Production/create-record";

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.println("Enter user details:");
                System.out.print("First Name: ");
                String firstName = reader.readLine();
                System.out.print("Last Name: ");
                String lastName = reader.readLine();
                System.out.print("City: ");
                String city = reader.readLine();
                System.out.print("School: ");
                String school = reader.readLine();
                System.out.print("State: ");
                String state = reader.readLine();
                System.out.print("Country: ");
                String country = reader.readLine();

                String custId = generateUniqueId();

                String jsonPayload = "{\"cust_id\":\"" + custId + "\",\"first_name\":\"" + firstName + "\",\"last_name\":\"" + lastName + "\",\"city\":\"" + city + "\",\"school\":\"" + school + "\",\"state\":\"" + state + "\",\"country\":\"" + country + "\"}";

                String response = sendPostRequest(API_ENDPOINT, jsonPayload);

                if (response != null) {
                    System.out.println("Registration successful.");
                } else {
                    System.out.println("Failed to register user. Please try again.");
                }

                System.out.print("Do you want to register another user? (yes/no): ");
                String choice = reader.readLine();
                if (!choice.equalsIgnoreCase("yes")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String generateUniqueId() {
        String uniqueId = String.valueOf(idCounter++);
        return uniqueId;
    }

    private static String sendPostRequest(String endpoint, String payload) {
        try {
            URL url = new URL(endpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = payload.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                return "success";
            } else {
                System.out.println("POST request failed with response code: " + responseCode);
                System.out.println("Response message: " + connection.getResponseMessage());
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}