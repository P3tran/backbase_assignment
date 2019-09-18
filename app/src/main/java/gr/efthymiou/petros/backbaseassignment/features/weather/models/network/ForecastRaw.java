package gr.efthymiou.petros.backbaseassignment.features.weather.models.network;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ForecastRaw {

    @SerializedName("dt")
    private long timestamp;
    private ForecastRawMain main;
    private List<ForecastRawWeather> weather;
    private ForecastRawWind wind;
    private ForecastRawRain rain;
    @SerializedName("dt_txt")
    private String date;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public ForecastRawMain getMain() {
        return main;
    }

    public void setMain(ForecastRawMain main) {
        this.main = main;
    }

    public List<ForecastRawWeather> getWeather() {
        return weather;
    }

    public void setWeather(List<ForecastRawWeather> weather) {
        this.weather = weather;
    }

    public ForecastRawWind getWind() {
        return wind;
    }

    public void setWind(ForecastRawWind wind) {
        this.wind = wind;
    }

    public ForecastRawRain getRain() {
        return rain;
    }

    public void setRain(ForecastRawRain rain) {
        this.rain = rain;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ForecastRaw() {
    }

    public ForecastRaw(long timestamp, ForecastRawMain main, List<ForecastRawWeather> weather, ForecastRawWind wind, ForecastRawRain rain, String date) {
        this.timestamp = timestamp;
        this.main = main;
        this.weather = weather;
        this.wind = wind;
        this.rain = rain;
        this.date = date;
    }

    @Override
    public String toString() {
        return "ForecastRaw{" +
                "timestamp=" + timestamp +
                ", main=" + main +
                ", weather=" + weather +
                ", wind=" + wind +
                ", rain=" + rain +
                ", date='" + date + '\'' +
                '}';
    }
}


