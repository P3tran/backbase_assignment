package gr.efthymiou.petros.backbaseassignment.features.weather;


import android.content.Context;

import gr.efthymiou.petros.backbaseassignment.features.bookmarks.Bookmark;

public interface WeatherForecastPresenter {

    void getForecast(Bookmark bookmark, Context ctx);

}
