package sg.edu.rp.c346.id22023689.mymovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Movies> moviesList;

    public CustomAdapter (Context context, int resource, ArrayList<Movies> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id =resource;
        moviesList = objects;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(layout_id, parent, false);

        TextView textviewTitle = rowView.findViewById(R.id.textviewTitle);
        TextView textviewGenre = rowView.findViewById(R.id.textviewGenre);
        TextView textviewYear = rowView.findViewById(R.id.textviewYear);
        ImageView ivRating = rowView.findViewById(R.id.imageView);

        Movies currentItem = moviesList.get(position);
        textviewTitle.setText((currentItem.getTitle()));
        textviewGenre.setText((currentItem.getGenre()));
        textviewYear.setText(currentItem.getYear());

        if (currentItem.getGenre().equalsIgnoreCase("g")) {
            ivRating.setImageResource(R.drawable.rating_g);
        } else if (currentItem.getGenre().equalsIgnoreCase("M18")) {
            ivRating.setImageResource(R.drawable.rating_m18);
        } else if (currentItem.getGenre().equalsIgnoreCase("nc16")) {
            ivRating.setImageResource(R.drawable.rating_nc16);
        } else if (currentItem.getGenre().equalsIgnoreCase("pg")) {
            ivRating.setImageResource(R.drawable.rating_pg);
        } else if (currentItem.getGenre().equalsIgnoreCase("pg13")) {
            ivRating.setImageResource(R.drawable.rating_pg13);
        } else if (currentItem.getGenre().equalsIgnoreCase("r21")) {
            ivRating.setImageResource(R.drawable.rating_r21);
        }

        return rowView;
    }
}
