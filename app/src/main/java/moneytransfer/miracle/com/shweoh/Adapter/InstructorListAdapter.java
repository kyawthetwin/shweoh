package moneytransfer.miracle.com.shweoh.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import moneytransfer.miracle.com.shweoh.InstructorProfile;
import moneytransfer.miracle.com.shweoh.R;

/**
 * Created by kyawthetwin on 5/26/17.
 */

public class InstructorListAdapter extends RecyclerView.Adapter<InstructorListAdapter.InstructorItemRowHolder>  {

    private Context mContext;
    private int []images;
    private String [] i_name;
    private String [] i_title;
    private String [] i_qualifications;


    public InstructorListAdapter(FragmentActivity activity, String[] instructor_name_list, String[] instructor_title_list, String[] instructor_qualifications_list, int[] instructor_photo_list) {

        this.mContext = activity;
        this.images = instructor_photo_list;
        this.i_name = instructor_name_list;
        this.i_title = instructor_title_list;
        this.i_qualifications = instructor_qualifications_list;

    }

    @Override
    public InstructorListAdapter.InstructorItemRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.instructor, null);
        InstructorListAdapter.InstructorItemRowHolder ih = new InstructorListAdapter.InstructorItemRowHolder(v);
        return ih;
    }

    @Override
    public void onBindViewHolder(InstructorListAdapter.InstructorItemRowHolder holder, int position) {

        holder.in.setText(i_name[position]);
        holder.in.setTextColor(mContext.getResources().getColor(R.color.colorPrimaryDark));

        holder.it.setText(i_title[position]);
        holder.iq.setText(i_qualifications[position]);
        holder.iv.setImageResource(images[position]);
        holder.iv.setImageResource(images[position]);




    }

    @Override
    public int getItemCount() {
        return i_name.length;
    }

    public class InstructorItemRowHolder  extends RecyclerView.ViewHolder  {

        ImageView iv;
        TextView in;
        TextView it;
        TextView iq;


        public InstructorItemRowHolder(View itemView) {
            super(itemView);


            iv = (ImageView) itemView.findViewById(R.id.i_image);
            in = (TextView) itemView.findViewById(R.id.i_name);
            it = (TextView) itemView.findViewById(R.id.i_title);
            iq = (TextView) itemView.findViewById(R.id.i_qualifictions);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(mContext, InstructorProfile.class);
                    i.putExtra("IN",in.getText().toString());
                    i.putExtra("IT",it.getText().toString());
                    i.putExtra("iq",iq.getText().toString());
                    mContext.startActivity(i);
                }
            });
        }
    }
}
