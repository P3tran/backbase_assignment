package gr.efthymiou.petros.backbaseassignment.features.weather.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Forecast implements Parcelable {

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

    protected Forecast(Parcel in) {
        date = in.readString();
        title = in.readString();
        description = in.readString();
        temp = in.readString();
        tempMinMax = in.readString();
        humidity = in.readString();
        iconId = in.readInt();
        windInfo = in.readString();
        rainInfo = in.readString();
        rainSelectionVisibility = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(temp);
        dest.writeString(tempMinMax);
        dest.writeString(humidity);
        dest.writeInt(iconId);
        dest.writeString(windInfo);
        dest.writeString(rainInfo);
        dest.writeInt(rainSelectionVisibility);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Forecast> CREATOR = new Parcelable.Creator<Forecast>() {
        @Override
        public Forecast createFromParcel(Parcel in) {
            return new Forecast(in);
        }

        @Override
        public Forecast[] newArray(int size) {
            return new Forecast[size];
        }
    };
}
