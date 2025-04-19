package com.example.kori.ui.cities;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kori.R;

import java.util.List;

public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private List<CityItem> cities;
    private MediaPlayer mediaPlayer;

    public GridViewAdapter(Context context, List<CityItem> cities) {
        this.context = context;
        this.cities = cities;
    }

    @Override
    public int getCount() {
        return cities.size();
    }

    @Override
    public Object getItem(int position) {
        return cities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CityItem city = cities.get(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false);
        }

        ImageView cityImage = convertView.findViewById(R.id.city_image);
        TextView title = convertView.findViewById(R.id.city_title);
        TextView description = convertView.findViewById(R.id.city_description);
        TextView longDescription = convertView.findViewById(R.id.city_long_description);
        Button playAudio = convertView.findViewById(R.id.play_audio_button);

        cityImage.setImageResource(city.getImageResId());
        title.setText(city.getTitle());
        description.setText(city.getDescription());
        longDescription.setText(city.getLongDescription());

        playAudio.setOnClickListener(v -> {
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.release();
            }

            mediaPlayer = MediaPlayer.create(context, city.getSoundResId());
            mediaPlayer.start();
        });

        return convertView;
    }
}

