package weather.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import weather.services.WeatherService;

@RestController
class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService){
        this.weatherService = weatherService;

    }

    @GetMapping("/cityWeather")
    public String getCityWeather(String city){
        return weatherService.callWeatherAPI(city);

    }

}
