package moneytransfer.miracle.com.shweoh.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterViewFlipper;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;

import java.util.ArrayList;

import moneytransfer.miracle.com.shweoh.Adapter.FlipperAdapter;
import moneytransfer.miracle.com.shweoh.Adapter.RecommendedAdapter;
import moneytransfer.miracle.com.shweoh.R;

/**
 * Created by user on 5/22/17.
 */

public class TutorialFragment extends android.support.v4.app.Fragment {
    private BoomMenuButton bmb;
    RecyclerView recommendedView, categoriesView;
    RecommendedAdapter recommendedAdapter1, recommendedAdapter2;
   // AdapterViewFlipper adapterViewFlipper;
    ViewFlipper simpleViewFlipper;

    int [] images = {R.drawable.android3,R.drawable.ios2,R.drawable.business2,R.drawable.english1,R.drawable.voilincourse};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tutorial,container,false);
        bmb = (BoomMenuButton) v.findViewById(R.id.bmb);
        ArrayList<Integer> namelist = new ArrayList<>();

        namelist.add(R.string.ham_english);
        namelist.add(R.string.ham_burmese);
        namelist.add(R.string.ham_package);

        int[] imageList = new int[]{
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher};

        assert bmb != null;

        bmb.setButtonEnum(ButtonEnum.Ham);
        bmb.setPiecePlaceEnum(PiecePlaceEnum.HAM_3);
        bmb.setButtonPlaceEnum(ButtonPlaceEnum.HAM_3);


        for (int i = 0; i < 3; i++) {
            bmb.addBuilder(getHamButtonBuilderWithDifferentPieceColor( imageList[i],namelist.get(i)));
        }

        return v;
    }

    HamButton.Builder getHamButtonBuilderWithDifferentPieceColor(int image, int name) {
        return new HamButton.Builder().listener(new OnBMClickListener() {
            @Override
            public void onBoomButtonClick(int index) {



                Log.i("index", index + "");
                Intent i = null;
                if (index == 0) {

                } else if (index == 1) {



                } else if (index == 2) {
                } else {



                }

            }
        })
                .pieceColor(R.color.colorAccent)
                .normalImageRes(image)
                .normalTextRes(name)
                .normalColorRes(R.color.colorPrimary);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recommendedView = (RecyclerView) view.findViewById(R.id.recommended_rcv);
        recommendedAdapter1 = new RecommendedAdapter(getActivity(),1);
        recommendedView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        recommendedView.setAdapter(recommendedAdapter1);


        categoriesView = (RecyclerView) view.findViewById(R.id.categories_rcv);
        recommendedAdapter2 = new RecommendedAdapter(getActivity(),2);
        categoriesView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        categoriesView.setAdapter(recommendedAdapter2);


        simpleViewFlipper = (ViewFlipper) view.findViewById(R.id.simpleViewFlipper);

        for (int i=0; i < images.length; i++) {

            ImageView imageView = new ImageView(getActivity());
            imageView.setImageResource(images[i]);
            simpleViewFlipper.addView(imageView);


        }


        Animation in = AnimationUtils.loadAnimation(getActivity(), android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(getActivity(), android.R.anim.slide_out_right);
        // set the animation type's to ViewFlipper
        simpleViewFlipper.setInAnimation(in);
        simpleViewFlipper.setOutAnimation(out);

        ;
        // set auto start for flipping between views
        simpleViewFlipper.setAutoStart(true);
        simpleViewFlipper.setFlipInterval(3000);
        simpleViewFlipper.startFlipping();
        /*adapterViewFlipper = (AdapterViewFlipper) view.findViewById(R.id.viewflipper_video_turotrial);
        adapterViewFlipper.setAdapter(new FlipperAdapter(getActivity()));

        adapterViewFlipper.setFlipInterval(3000);
        adapterViewFlipper.setAutoStart(true);*/


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        setUserVisibleHint(true);
    }
}
