package gr.efthymiou.petros.backbaseassignment.features.weather;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;

import gr.efthymiou.petros.backbaseassignment.features.bookmarks.Coord;
import gr.efthymiou.petros.backbaseassignment.features.weather.models.network.Forecast5daysRaw;
import gr.efthymiou.petros.backbaseassignment.utils.Const;
import gr.efthymiou.petros.backbaseassignment.utils.LogUtils;

public class WeatherForecastInteractorImpl implements WeatherForecastInteractor {

    private ForecastMapperDomain mapper = new ForecastMapperDomain(new ForecastRawValidator());

    @Override
    public void getForecast(Coord coord, GetForecastFinishListener listener) {
        AsyncTask.execute(() -> {
            try {
                Forecast5daysRaw response = fetchForecast(coord);
                if (response != null) {
                    Log.d(LogUtils.NETWORKING_TAG, "parsed forecast: " + response.toString());
                    listener.onSuccess(mapper.apply(response));
                } else {
                    listener.onFailure();
                }
            } catch (Exception e) {
                Log.e(LogUtils.NETWORKING_TAG, "failed to get forecast: " + e.getMessage());
                listener.onFailure();
            }
        });
    }

    private Forecast5daysRaw fetchForecast(Coord coord) throws Exception {
        String stringUrl = String.format(Locale.getDefault(), "http://api.openweathermap.org/data/2.5/forecast?lat=%s&lon=%s&appid=%s&units=metric", coord.getLat(), coord.getLon(), Const.WEATHER_API_KEY);
        URL serverUrl = new URL(stringUrl);
        HttpURLConnection httpConnection = (HttpURLConnection) serverUrl.openConnection();
        httpConnection.setRequestMethod("GET");
        int responseCode = httpConnection.getResponseCode();
        if (responseCode == 200) {
            BufferedReader responseReader = new BufferedReader(
                    new InputStreamReader(httpConnection.getInputStream()));
            String responseLine;
            StringBuilder response = new StringBuilder();
            while ((responseLine = responseReader.readLine()) != null) {
                response.append(responseLine);
            }
            responseReader.close();
            Gson gson = new Gson();

            return gson.fromJson(response.toString(), Forecast5daysRaw.class);
        } else
            return null;
    }
}
