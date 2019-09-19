package gr.efthymiou.petros.backbaseassignment.features.weather.models;

import java.util.Objects;

public class ForecastDomain {

    private long timestamp;
    private String date;
    private int weatherId;
    private String title;
    private String description;
    private double temp;
    private double tempMin;
    private double tempMax;
    private int humidity;
    private String icon;
    private Double windSpeed;
    private Double windDeg;
    private Double threeHourRain;
    private Double oneHourRain;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(int weatherId) {
        this.weatherId = weatherId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Double getWindDeg() {
        return windDeg;
    }

    public void setWindDeg(Double windDeg) {
        this.windDeg = windDeg;
    }

    public Double getThreeHourRain() {
        return threeHourRain;
    }

    public void setThreeHourRain(Double threeHourRain) {
        this.threeHourRain = threeHourRain;
    }

    public Double getOneHourRain() {
        return oneHourRain;
    }

    public void setOneHourRain(Double oneHourRain) {
        this.oneHourRain = oneHourRain;
    }

    public void setOneHourRain(double oneHourRain) {
        this.oneHourRain = oneHourRain;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public ForecastDomain(long timestamp, String date, int weatherId, String title, String description, double temp, double tempMin, double tempMax, int humidity, String icon, double windSpeed, double windDeg, double threeHourRain, double oneHourRain) {
        this.timestamp = timestamp;
        this.date = date;
        this.weatherId = weatherId;
        this.title = title;
        this.description = description;
        this.temp = temp;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.humidity = humidity;
        this.icon = icon;
        this.windSpeed = windSpeed;
        this.windDeg = windDeg;
        this.threeHourRain = threeHourRain;
        this.oneHourRain = oneHourRain;
    }

    public ForecastDomain(long timestamp, String date, int weatherId, String title, String description, double temp, double tempMin, double tempMax, int humidity, String icon) {
        this.timestamp = timestamp;
        this.date = date;
        this.weatherId = weatherId;
        this.title = title;
        this.description = description;
        this.temp = temp;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.humidity = humidity;
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "ForecastDomain{" +
                "timestamp=" + timestamp +
                ", date='" + date + '\'' +
                ", weatherId=" + weatherId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", temp=" + temp +
                ", tempMin=" + tempMin +
                ", tempMax=" + tempMax +
                ", humidity=" + humidity +
                ", icon='" + icon + '\'' +
                ", windSpeed=" + windSpeed +
                ", windDeg=" + windDeg +
                ", threeHourRain=" + threeHourRain +
                ", oneHourRain=" + oneHourRain +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ForecastDomain)) return false;
        ForecastDomain that = (ForecastDomain) o;
        return getTimestamp() == that.getTimestamp() &&
                getWeatherId() == that.getWeatherId() &&
                Double.compare(that.getTemp(), getTemp()) == 0 &&
                Double.compare(that.getTempMin(), getTempMin()) == 0 &&
                Double.compare(that.getTempMax(), getTempMax()) == 0 &&
                getHumidity() == that.getHumidity() &&
                Double.compare(that.getWindSpeed(), getWindSpeed()) == 0 &&
                Double.compare(that.getWindDeg(), getWindDeg()) == 0 &&
                Double.compare(that.getThreeHourRain(), getThreeHourRain()) == 0 &&
                Double.compare(that.getOneHourRain(), getOneHourRain()) == 0 &&
                getDate().equals(that.getDate()) &&
                getTitle().equals(that.getTitle()) &&
                getDescription().equals(that.getDescription()) &&
                getIcon().equals(that.getIcon());
    }

}
