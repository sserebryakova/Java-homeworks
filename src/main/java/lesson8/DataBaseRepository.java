package lesson8;

import lesson8.entity.Weather;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataBaseRepository {
    private final String insertWeather = "INSERT INTO weather (city, localDate, minTemperature, maxTemperature) VALUES (?, ?, ?, ?)";
    String getWeather = "SELECT * FROM weather WHERE city = ?";
    private static final String DB_PATH = "jdbc:sqlite:homework.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean saveWeatherToDataBase(Weather weather) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            saveWeather.setString(1, weather.getCity());
            saveWeather.setString(2, weather.getLocalDate());
            saveWeather.setDouble(3, weather.getMinTemperature());
            saveWeather.setDouble(4, weather.getMaxTemperature());
            return saveWeather.execute();
        } catch (SQLException troubles) {
            troubles.printStackTrace();
        }
        throw new SQLException("Сохранение погоды в базу данных не выполнено!");
    }

    public void saveWeatherToDataBase(List<Weather> weatherList) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            for (Weather weather : weatherList) {
                saveWeather.setString(1, weather.getCity());
                saveWeather.setString(2, weather.getLocalDate());
                saveWeather.setDouble(3, weather.getMinTemperature());
                saveWeather.setDouble(4, weather.getMaxTemperature());
                saveWeather.addBatch();
            }
            saveWeather.executeBatch();
        } catch (SQLException troubles) {
            troubles.printStackTrace();
        }
    }

    public List<Weather> getSavedToDBWeather(String city) {
        List<Weather> weathers = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement statement = connection.prepareStatement(getWeather);
            statement.setString(1, city);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("id"));
                System.out.println(" ");
                System.out.print(resultSet.getString("city"));
                System.out.println(" ");
                System.out.print(resultSet.getString("localDate"));
                System.out.println(" ");
                System.out.print(resultSet.getDouble("minTemperature"));
                System.out.println(" ");
                System.out.print(resultSet.getDouble("maxTemperature"));
                System.out.println(" ");
                weathers.add(new Weather(resultSet.getString("city"),
                        resultSet.getString("localDate"),
                        resultSet.getDouble("minTemperature"),
                        resultSet.getDouble("maxTemperature")));
            }
        } catch (SQLException troubles) {
            troubles.printStackTrace();
        }
        return weathers;
    }
}
