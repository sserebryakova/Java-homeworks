package lesson7.entity;


public class Weather {
    private String city;
    private String localDate;
    private double minTemperature;
    private double maxTemperature;

    public Weather(String city, String localDate, double minTemperature, double maxTemperature) {
        this.city = city;
        this.localDate = localDate;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "city = " + city +
                "\nlocalDate = " + localDate +
                "\nMinimum temperature = " + String.format("%.2f C", minTemperature) +
                "\nMaximum temperature = " + String.format("%.2f C", maxTemperature) +
                '}';
    }
}
