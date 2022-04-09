package weather.services;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class WeatherService {


    public String callWeatherAPI(String cityName){

        try {
            cityName = cityName.replaceAll(" ", "%20");
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(URI.create(String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=ce234887e6f25880e7d52a2b48999109&units=imperial",cityName))).GET().build();

            return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        }
        catch (IOException | InterruptedException e){
            return "Something Went Wrong";
        }
    }
}
