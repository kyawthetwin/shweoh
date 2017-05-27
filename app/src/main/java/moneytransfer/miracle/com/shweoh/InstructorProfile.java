package moneytransfer.miracle.com.shweoh;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import moneytransfer.miracle.com.shweoh.Adapter.InstructorCourseAdapter;
import moneytransfer.miracle.com.shweoh.Model.CourseItemModel;

public class InstructorProfile extends AppCompatActivity {

    RecyclerView instructorCourseRecycler;
    InstructorCourseAdapter instructorCourseAdapter;
    ArrayList<CourseItemModel> courseItemModelArrayList;
    TextView seeMore, aboutInstructor, seeLess;
    RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_profile);


        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_instructor);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapse_toolbar_instructor);
        collapsingToolbar.setTitle("  ");
        collapsingToolbar.setContentScrimColor(getResources().getColor(R.color.colorPrimary));


        seeMore = (TextView) findViewById(R.id.seeMore);
        seeLess = (TextView) findViewById(R.id.showLess);
        aboutInstructor = (TextView) findViewById(R.id.aboutInstructor);
        ratingBar = (RatingBar) findViewById(R.id.instructor_rating);


        ratingBar.setRating(4.0f);



        seeMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aboutInstructor.setVisibility(View.VISIBLE);
                seeMore.setVisibility(View.GONE);
                seeLess.setVisibility(View.VISIBLE);
            }
        });

        seeLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aboutInstructor.setVisibility(View.GONE);
                seeMore.setVisibility(View.VISIBLE);
                seeLess.setVisibility(View.GONE);
            }
        });

        instructorCourseAdapter = new InstructorCourseAdapter(this,courseItemModelArrayList);
        instructorCourseRecycler = (RecyclerView) findViewById(R.id.instructor_course);
        instructorCourseRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
        instructorCourseRecycler.setAdapter(instructorCourseAdapter);

    }



}
