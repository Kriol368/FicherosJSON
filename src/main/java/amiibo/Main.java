package amiibo;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        try {
            // URL of the API
            String apiUrl = "https://www.amiiboapi.com/api/amiibo/?gameseries=xenoblade";

            // Create a URL object
            URL url = new URL(apiUrl);

            // Create an HttpURLConnection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();

            // Check if the response code is successful
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Parse JSON using Gson
                Gson gson = new Gson();
                AmiiboResponse amiiboResponse = gson.fromJson(response.toString(), AmiiboResponse.class);

                // Print the information in a visual way
                for (Amiibo amiibo : amiiboResponse.amiibo) {
                    System.out.println("Amiibo Series: " + amiibo.amiiboSeries);
                    System.out.println("Character: " + amiibo.character);
                    System.out.println("Game Series: " + amiibo.gameSeries);
                    System.out.println("Release Dates:");
                    for (String region : amiibo.release.keySet()) {
                        System.out.println("\t" + region.toUpperCase() + ": " + amiibo.release.get(region));
                    }
                    System.out.println("Image: " + amiibo.image);
                    System.out.println();
                }
            } else {
                System.out.println("Error: Failed to retrieve data from API. Response code: " + responseCode);
            }

            // Disconnect the connection
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
