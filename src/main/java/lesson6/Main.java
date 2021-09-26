package lesson6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Main {
    private static final String PROTOKOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String HOURLY= "hourly";
    private static final String FIVE_DAYS = "120hour";
    private static final String API_KEY = "OLu1mwMldQGQdFgdi2vv6YoLT7OVZyEe";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        getWeather("St. Petersburg");
    }

    public static void getWeather(String selectedCity) throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(BASE_HOST)
                .addPathSegment(FORECASTS)
                .addPathSegment(VERSION)
                .addPathSegment(HOURLY)
                .addPathSegment(FIVE_DAYS)
                .addPathSegment(detectCityKey(selectedCity))
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        Response oneDayForecastResponse = okHttpClient.newCall(request).execute();
        String weatherResponse = oneDayForecastResponse.body().string();
        System.out.println(weatherResponse);
    }

    private static String detectCityKey(String selectCity) throws IOException {

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
}
