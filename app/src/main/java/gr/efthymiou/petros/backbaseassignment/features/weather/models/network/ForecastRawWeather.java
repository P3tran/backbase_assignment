package gr.efthymiou.petros.backbaseassignment.features.weather.models.network;

import com.google.gson.annotations.SerializedName;

public class ForecastRawWeather {
    private int id;

    @SerializedName("main")
    private String title;

    private String description;

    private String icon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public ForecastRawWeather() {
    }

    public ForecastRawWeather(int id, String title, String description, String icon) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "ForecastRawWeather{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}

