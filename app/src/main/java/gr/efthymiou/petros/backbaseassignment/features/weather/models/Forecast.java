package gr.efthymiou.petros.backbaseassignment.features.weather.models;

public class Forecast {

    private String date;
    private String title;
    private String description;
    private String temp;
    private String tempMinMax;
    private String humidity;
    private int iconId;
    private String windInfo;
    private String rainInfo;
    private int rainSelectionVisibility;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getTempMinMax() {
        return tempMinMax;
    }

    public void setTempMinMax(String tempMinMax) {
        this.tempMinMax = tempMinMax;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWindInfo() {
        return windInfo;
    }

    public void setWindInfo(String windInfo) {
        this.windInfo = windInfo;
    }

    public String getRainInfo() {
        return rainInfo;
    }

    public void setRainInfo(String rainInfo) {
        this.rainInfo = rainInfo;
    }

    public int getRainSelectionVisibility() {
        return rainSelectionVisibility;
    }

    public void setRainSelectionVisibility(int rainSelectionVisibility) {
        this.rainSelectionVisibility = rainSelectionVisibility;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public Forecast(String date, String title, String description, String temp, String tempMinMax, String humidity, int iconId, String windInfo, String rainInfo, int rainSelectionVisibility) {
        this.date = date;
        this.title = title;
        this.description = description;
        this.temp = temp;
        this.tempMinMax = tempMinMax;
        this.humidity = humidity;
        this.iconId = iconId;
        this.windInfo = windInfo;
        this.rainInfo = rainInfo;
        this.rainSelectionVisibility = rainSelectionVisibility;
    }
}
