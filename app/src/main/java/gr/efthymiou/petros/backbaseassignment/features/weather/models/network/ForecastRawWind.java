package gr.efthymiou.petros.backbaseassignment.features.weather.models.network;

public class ForecastRawWind {
    private double speed;
    private double deg;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDeg() {
        return deg;
    }

    public void setDeg(double deg) {
        this.deg = deg;
    }

    public ForecastRawWind() {
    }

    public ForecastRawWind(double speed, double deg) {
        this.speed = speed;
        this.deg = deg;
    }

    @Override
    public String toString() {
        return "ForecastRawWind{" +
                "speed=" + speed +
                ", deg=" + deg +
                '}';
    }
}

