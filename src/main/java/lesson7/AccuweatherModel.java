package lesson7;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lesson7.entity.Weather;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AccuweatherModel implements WeatherModel {
    private static final String PROTOKOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAY = "5day";
    private static final String API_KEY = "UfKdoKzw1IoHTehNGUA8oE0UNNv8Rxui";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";
    private static final String METRIC_PARAM = "metric";
    private static final String METRIC = "true";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();



    public void getWeather(String selectedCity, Period period) throws IOException {
        switch (period) {
            case NOW:
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .addQueryParameter(METRIC_PARAM, METRIC)
                        .build();

                Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();

                Response oneDayForecastResponse = okHttpClient.newCall(request).execute();
                String weatherResponse = oneDayForecastResponse.body().string();
                List<Weather> result = parseForecast(selectedCity, weatherResponse);
                for(Weather weather : result) {
                    System.out.println(weather);
                }
                break;
            case FIVE_DAYS:
                httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .addQueryParameter(METRIC_PARAM, METRIC)
                        .build();

                Request request1 = new Request.Builder()
                        .url(httpUrl)
                        .build();

                Response fiveDayForecastResponse = okHttpClient.newCall(request1).execute();
                weatherResponse = fiveDayForecastResponse.body().string();
                List<Weather> result5 = parseForecast(selectedCity, weatherResponse);
                for(Weather weather : result5) {
                    System.out.println(weather);
                }
                break;
        }
    }



    private String detectCityKey(String selectCity) throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter("q", selectCity)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseString = response.body().string();

        String cityKey = objectMapper.readTree(responseString).get(0).at("/Key").asText();
        return cityKey;
    }

    private List<Weather> parseForecast(String city, String forecast) throws JsonProcessingException {
        List<Weather> result = new ArrayList<>();
        JsonNode jsonNode = objectMapper.readTree(forecast);
        JsonNode dailyForecasts = jsonNode.get("DailyForecasts");
        Iterator<JsonNode> forecasts = dailyForecasts.elements();
        while (forecasts.hasNext()) {
            JsonNode singleDayForecast = forecasts.next();
            String date = singleDayForecast.get("Date").asText();
            String minTemperature = singleDayForecast.get("Temperature").get("Minimum").get("Value").asText();
            double minTemperatureValue = Double.valueOf(minTemperature);
            String maxTemperature = singleDayForecast.get("Temperature").get("Maximum").get("Value").asText();
            double maxTemperatureValue = Double.valueOf(maxTemperature);
            Weather weather = new Weather(city, date, minTemperatureValue, maxTemperatureValue);
            result.add(weather);
        }
        return result;
    }
}
