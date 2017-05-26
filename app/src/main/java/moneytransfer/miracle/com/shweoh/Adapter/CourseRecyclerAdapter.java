package moneytransfer.miracle.com.shweoh.Adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import moneytransfer.miracle.com.shweoh.Model.CourseDataModel;
import moneytransfer.miracle.com.shweoh.R;

/**
 * Created by user on 5/23/17.
 */

public class CourseRecyclerAdapter extends RecyclerView.Adapter<CourseRecyclerAdapter.ItemRowHolder> {

    private ArrayList<CourseDataModel> dataList;
    private Context mContext;
    CourseDataListAdapter itemListDataAdapter;
    int [] itcourse = {R.drawable.android,R.drawable.ios1,R.drawable.web1,R.drawable.android3};
    int [] businesscourse = {R.drawable.business1,R.drawable.business2,R.drawable.marketing,R.drawable.humanresources};
    int [] languagecourse = {R.drawable.english1,R.drawable.japan,R.drawable.french1,R.drawable.spain1};
    int [] designcourse = {R.drawable.photoshop1,R.drawable.illustrator1,R.drawable.max3d,R.drawable.animation2d};
    int [] artscourse = {R.drawable.guitar1,R.drawable.painting,R.drawable.voilincourse,R.drawable.guitar1};

    String [] stringIT = {"Android Development","iOS Development","Web Development","Android"};
    String [] stringLang = {"English Speaking","Japanese Language","French Language","Spanish Language"};
    String [] stringBusiness = {"Management","Business Development","Marketing","Human Resources"};
    String [] stringDesign = {"PS for beginner","AI Advanced Course","3D Max","Animation with 2D"};
    String [] stringArts = {"Guitar Lesson 1","painting for beginner","violin for kids","Guitar Lesson 2"};

    public CourseRecyclerAdapter(Context context, ArrayList<CourseDataModel> dataList) {
        this.dataList = dataList;
        this.mContext = context;
    }

    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.course_list_item, null);
        ItemRowHolder mh = new ItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(ItemRowHolder itemRowHolder, int i) {

        final String sectionName = dataList.get(i).getHeaderTitle();

        ArrayList singleSectionItems = dataList.get(i).getAllItemsInSection();

        itemRowHolder.itemTitle.setText(sectionName);
        if (i == 0) {
             itemListDataAdapter = new CourseDataListAdapter(mContext, singleSectionItems, itcourse, stringIT);
        }
        else if (i == 1){
            itemListDataAdapter = new CourseDataListAdapter(mContext, singleSectionItems, designcourse , stringDesign);
        }
        else if (i == 2){
            itemListDataAdapter = new CourseDataListAdapter(mContext, singleSectionItems, businesscourse, stringBusiness);
        }
        else if (i == 3){
            itemListDataAdapter = new CourseDataListAdapter(mContext, singleSectionItems, languagecourse, stringLang);
        }
        else if (i == 4){
            itemListDataAdapter = new CourseDataListAdapter(mContext, singleSectionItems, artscourse , stringArts);
        }

        itemRowHolder.recycler_view_list.setHasFixedSize(true);
        itemRowHolder.recycler_view_list.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        itemRowHolder.recycler_view_list.setAdapter(itemListDataAdapter);


        itemRowHolder.txtMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


             //   Toast.makeText(v.getContext(), "click event on more, "+sectionName , Toast.LENGTH_SHORT).show();



            }
        });


       /* Glide.with(mContext)
                .load(feedItem.getImageURL())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .error(R.drawable.bg)
                .into(feedListRowHolder.thumbView);*/
    }

    @Override
    public int getItemCount() {
        return (null != dataList ? dataList.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView itemTitle;

        protected RecyclerView recycler_view_list;

        protected TextView txtMore;



        public ItemRowHolder(View view) {
            super(view);

            this.itemTitle = (TextView) view.findViewById(R.id.course_category_title);
            this.recycler_view_list = (RecyclerView) view.findViewById(R.id.course_recycler_view_list);
            this.txtMore= (TextView) view.findViewById(R.id.txtMore);


        }

    }

}
