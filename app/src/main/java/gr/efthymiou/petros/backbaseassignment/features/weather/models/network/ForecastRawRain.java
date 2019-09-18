package gr.efthymiou.petros.backbaseassignment.features.weather.models.network;

import com.google.gson.annotations.SerializedName;

public class ForecastRawRain {

    @SerializedName("3h")
    private double threeHours;

    @SerializedName("1h")
    private double oneHour;

    public double getThreeHours() {
        return threeHours;
    }

    public void setThreeHours(double threeHours) {
        this.threeHours = threeHours;
    }

    public double getOneHour() {
        return oneHour;
    }

    public void setOneHour(double oneHour) {
        this.oneHour = oneHour;
    }

    public ForecastRawRain() {
    }

    public ForecastRawRain(double threeHours, double oneHour) {
        this.threeHours = threeHours;
        this.oneHour = oneHour;
    }

    @Override
    public String toString() {
        return "ForecastRawRain{" +
                "threeHours=" + threeHours +
                ", oneHour=" + oneHour +
                '}';
    }
}
