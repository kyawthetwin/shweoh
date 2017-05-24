package moneytransfer.miracle.com.shweoh.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import moneytransfer.miracle.com.shweoh.InstructorProfile;
import moneytransfer.miracle.com.shweoh.Model.CourseItemModel;
import moneytransfer.miracle.com.shweoh.R;

/**
 * Created by user on 5/24/17.
 */

public class InstructorCourseAdapter extends RecyclerView.Adapter<InstructorCourseAdapter.SingleItemRowHolder> {

    private ArrayList<CourseItemModel> itemsList;
    private Context mContext;

    public InstructorCourseAdapter(Context context, ArrayList<CourseItemModel> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.course_single_item, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int i) {



       /* Glide.with(mContext)
                .load(feedItem.getImageURL())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .error(R.drawable.bg)
                .into(feedListRowHolder.thumbView);*/
    }

    @Override
    public int getItemCount() {
        return 7;
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView tvTitle;

        protected ImageView itemImage;


        public SingleItemRowHolder(View view) {
            super(view);

            this.tvTitle = (TextView) view.findViewById(R.id.course_title);
            this.itemImage = (ImageView) view.findViewById(R.id.imageView_course);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Intent intent = new Intent(mContext, InstructorProfile.class);
                    mContext.startActivity(intent);


                    // Toast.makeText(v.getContext(), tvTitle.getText(), Toast.LENGTH_SHORT).show();

                }
            });


        }

    }
}


