package gr.efthymiou.petros.backbaseassignment.features.weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import gr.efthymiou.petros.backbaseassignment.R;
import gr.efthymiou.petros.backbaseassignment.features.weather.models.Forecast;

public class ForecastsRecyclerAdapter extends RecyclerView.Adapter<ForecastsRecyclerAdapter.ViewHolder> {

    private List<Forecast> forecasts;
    private Context ctx;

    public ForecastsRecyclerAdapter(List<Forecast> forecasts, Context ctx) {
        this.forecasts = forecasts;
        this.ctx = ctx;
    }

    @Override
    public ForecastsRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                  int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_forecast_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mTitle.setText(forecasts.get(position).getTitle());
        holder.mDescription.setText(forecasts.get(position).getDescription());
        holder.mTemperature.setText(forecasts.get(position).getTemp());
        holder.mIcon.setImageDrawable(ctx.getResources().getDrawable(forecasts.get(position).getIconId()));
        holder.mHumidity.setText(forecasts.get(position).getHumidity());
        holder.mWindInfo.setText(forecasts.get(position).getWindInfo());
        holder.mRainInfo.setText(forecasts.get(position).getRainInfo());
        holder.mRainLl.setVisibility(forecasts.get(position).getRainSelectionVisibility());
    }

    @Override
    public int getItemCount() {
        return forecasts.size();
    }

    public void setForecasts(List<Forecast> forecasts) {
        this.forecasts = forecasts;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTitle, mDescription, mTemperature, mHumidity, mWindInfo, mRainInfo, mTime;
        ImageView mIcon;
        ViewGroup mRainLl;

        public ViewHolder(View view) {
            super(view);
            mTitle = view.findViewById(R.id.title);
            mTime = view.findViewById(R.id.time);
            mDescription = view.findViewById(R.id.description);
            mIcon = view.findViewById(R.id.icon);
            mTemperature = view.findViewById(R.id.temperature);
            mHumidity = view.findViewById(R.id.humidity);
            mWindInfo = view.findViewById(R.id.wind);
            mRainInfo = view.findViewById(R.id.rain);
            mRainLl = view.findViewById(R.id.rain_ll);
        }
    }
}