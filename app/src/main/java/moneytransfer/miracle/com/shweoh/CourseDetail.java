package moneytransfer.miracle.com.shweoh;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;

public class CourseDetail extends AppCompatActivity {


    TextView showmore,showless,aboutCourse;

    CircularImageView circularImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);


        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_course);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapse_toolbar_course);
        collapsingToolbar.setTitle(" ");
        collapsingToolbar.setCollapsedTitleTextColor(getResources().getColor(android.R.color.white));
        collapsingToolbar.setExpandedTitleTextColor(ColorStateList.valueOf(getResources().getColor(R.color.colorAccent)));
        collapsingToolbar.setContentScrimColor(getResources().getColor(R.color.colorPrimary));



        circularImageView = (CircularImageView) findViewById(R.id.circular_image_instructor);
        showmore = (TextView) findViewById(R.id.seeMoreCourse);
        showless = (TextView) findViewById(R.id.showLessCourse);
        aboutCourse = (TextView) findViewById(R.id.aboutCourse);
        circularImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),InstructorProfile.class);
                startActivity(i);
            }
        });


        showmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aboutCourse.setVisibility(View.VISIBLE);
                showmore.setVisibility(View.GONE);
                showless.setVisibility(View.VISIBLE);
            }
        });

        showless.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aboutCourse.setVisibility(View.GONE);
                showmore.setVisibility(View.VISIBLE);
                showless.setVisibility(View.GONE);
            }
        });

    }
}
