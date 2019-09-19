package gr.efthymiou.petros.backbaseassignment.features.weather.models.network;

import java.util.List;

public class Forecast5daysRaw {

    private List<ForecastRaw> list;

    public List<ForecastRaw> getList() {
        return list;
    }

    public void setList(List<ForecastRaw> list) {
        this.list = list;
    }

    public Forecast5daysRaw() {
    }

    public Forecast5daysRaw(List<ForecastRaw> list) {
        this.list = list;
    }

}
