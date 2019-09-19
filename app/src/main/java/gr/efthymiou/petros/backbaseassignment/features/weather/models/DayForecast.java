package gr.efthymiou.petros.backbaseassignment.features.weather.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class DayForecast implements Parcelable {

    private String date;
    private String tempMinMax;
    private List<Forecast> hourlyForecasts;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTempMinMax() {
        return tempMinMax;
    }

    public void setTempMinMax(String tempMinMax) {
        this.tempMinMax = tempMinMax;
    }

    public List<Forecast> getHourlyForecasts() {
        return hourlyForecasts;
    }

    public void setHourlyForecasts(List<Forecast> hourlyForecasts) {
        this.hourlyForecasts = hourlyForecasts;
    }


    public DayForecast(String date, String tempMinMax, List<Forecast> hourlyForecasts) {
        this.date = date;
        this.tempMinMax = tempMinMax;
        this.hourlyForecasts = hourlyForecasts;
    }

    @Override
    public String toString() {
        return "DayForecast{" +
                "date='" + date + '\'' +
                ", tempMinMax='" + tempMinMax + '\'' +
                ", hourlyForecasts=" + hourlyForecasts +
                '}';
    }

    protected DayForecast(Parcel in) {
        date = in.readString();
        tempMinMax = in.readString();
        if (in.readByte() == 0x01) {
            hourlyForecasts = new ArrayList<>();
            in.readList(hourlyForecasts, Forecast.class.getClassLoader());
        } else {
            hourlyForecasts = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeString(tempMinMax);
        if (hourlyForecasts == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(hourlyForecasts);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<DayForecast> CREATOR = new Parcelable.Creator<DayForecast>() {
        @Override
        public DayForecast createFromParcel(Parcel in) {
            return new DayForecast(in);
        }

        @Override
        public DayForecast[] newArray(int size) {
            return new DayForecast[size];
        }
    };
}
