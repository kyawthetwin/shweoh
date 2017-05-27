package moneytransfer.miracle.com.shweoh.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import moneytransfer.miracle.com.shweoh.R;

/**
 * Created by user on 5/27/17.
 */

public class FlipperAdapter extends BaseAdapter implements View.OnClickListener {

    int [] images = {R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};
    Context context;
    ImageView imgonVF;
    TextView flipperTitle;
    RatingBar ratingBar;
    public int AdapterPosition;
    int movieID;



    public FlipperAdapter(Context context) {

        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images.length;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        if (convertView == null) {

            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.view_flipper_list, null);

        }

        imgonVF = (ImageView) convertView.findViewById(R.id.imgonVF);
        flipperTitle = (TextView) convertView.findViewById(R.id.viewflipper_title);
        ratingBar = (RatingBar) convertView.findViewById(R.id.flipper_ratingBar);


        imgonVF.setImageResource(images[position]);
        imgonVF.setOnClickListener(this);


        ratingBar.setRating(4);

        flipperTitle.setText("Video Tutorial");



        return convertView;

    }

    @Override
    public void onClick(View v) {


    }
}
