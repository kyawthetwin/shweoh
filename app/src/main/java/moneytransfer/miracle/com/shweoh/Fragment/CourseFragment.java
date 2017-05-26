package moneytransfer.miracle.com.shweoh.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import moneytransfer.miracle.com.shweoh.Adapter.CourseDataListAdapter;
import moneytransfer.miracle.com.shweoh.Adapter.CourseRecyclerAdapter;
import moneytransfer.miracle.com.shweoh.Model.CourseDataModel;
import moneytransfer.miracle.com.shweoh.Model.CourseItemModel;
import moneytransfer.miracle.com.shweoh.R;

/**
 * Created by user on 5/22/17.
 */

public class CourseFragment extends android.support.v4.app.Fragment {


    ArrayList<CourseDataModel> courseDataModelArrayList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_course,container,false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        courseDataModelArrayList = new ArrayList<CourseDataModel>();

        createDummyData();


        RecyclerView my_recycler_view = (RecyclerView) view.findViewById(R.id.course_category_recycler);

        my_recycler_view.setHasFixedSize(true);

        CourseRecyclerAdapter adapter = new CourseRecyclerAdapter(getActivity(), courseDataModelArrayList);

        my_recycler_view.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        my_recycler_view.setAdapter(adapter);


    }

    public void createDummyData() {
        for (int i = 0; i <= 4; i++) {

            CourseDataModel dm = new CourseDataModel();

            if (i == 0) {

                dm.setHeaderTitle("Programming");
            }
            else if (i == 1) {

                dm.setHeaderTitle("Design");
            }
            else if (i == 2) {

                dm.setHeaderTitle("Business");
            }
            else if (i == 3){
                dm.setHeaderTitle("Language");
            }
            else
            {
                dm.setHeaderTitle("Arts");
            }
            ArrayList<CourseItemModel> singleItem = new ArrayList<CourseItemModel>();
            for (int j = 0; j <= 3; j++) {
                singleItem.add(new CourseItemModel("Item " + j, "URL " + j));
            }

            dm.setAllItemsInSection(singleItem);

            courseDataModelArrayList.add(dm);

        }
    }



    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        setUserVisibleHint(true);
    }
}
