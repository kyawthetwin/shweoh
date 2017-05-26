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

import moneytransfer.miracle.com.shweoh.CourseDetail;
import moneytransfer.miracle.com.shweoh.Model.CourseItemModel;
import moneytransfer.miracle.com.shweoh.R;

/**
 * Created by user on 5/25/17.
 */

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.SingleItemRowHolder> {

   // private ArrayList<CourseItemModel> itemsList;
    private Context mContext;
    int [] videoimage = {R.drawable.android2,R.drawable.handmade1,R.drawable.ios2,R.drawable.illustrator1};
    String [] title = {"android json parser","DIY Bags","iOS development","AI Advanced"};

    int [] categories = {R.drawable.business2,R.drawable.web1,R.drawable.painting, R.drawable.english1};
    String [] CateTitle = {"Business", "Technology", "Arts", "Language"};

    int recycler;

    public RecommendedAdapter(Context context, int recycler) {
     //   this.itemsList = itemsList;
        this.mContext = context;
        this.recycler = recycler;
    }

    @Override
    public RecommendedAdapter.SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        RecommendedAdapter.SingleItemRowHolder mh = null;
        if (recycler == 1) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.video_single_item, null);
            mh = new RecommendedAdapter.SingleItemRowHolder(v);

        }
        else{
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.categories_item, null);
            mh = new RecommendedAdapter.SingleItemRowHolder(v);
        }

        return mh;
    }

    @Override
    public void onBindViewHolder(RecommendedAdapter.SingleItemRowHolder holder, int i) {

      //  CourseItemModel singleItem = itemsList.get(i);

        if (recycler == 1) {

            holder.tvTitle.setText(title[i]);
            holder.itemImage.setImageResource(videoimage[i]);
        }

        else{

            holder.tvTitle.setText(CateTitle[i]);
            holder.itemImage.setImageResource(categories[i]);
        }

       /* Glide.with(mContext)
                .load(feedItem.getImageURL())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .error(R.drawable.bg)
                .into(feedListRowHolder.thumbView);*/
    }

    @Override
    public int getItemCount() {
        return 4;
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


                    Intent intent = new Intent(mContext, CourseDetail.class);
                    mContext.startActivity(intent);


                    // Toast.makeText(v.getContext(), tvTitle.getText(), Toast.LENGTH_SHORT).show();

                }
            });


        }

    }
}
