package moneytransfer.miracle.com.shweoh.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import moneytransfer.miracle.com.shweoh.Adapter.InstructorListAdapter;
import moneytransfer.miracle.com.shweoh.R;


public class InstructorlistFragment extends Fragment {


    RecyclerView rcv;
    InstructorListAdapter ila;

    String[] instructor_name_list  = {"Kyaw San Win","Dr.Myintzu Thinn Aung","U Zin Phyo Paing","Aye Chan Myae"};
    String[] instructor_title_list = {"Technical Manager","Lecture (Department of Zoology, University of Yangon)","CEO and Principal at MESI Entrepreneur SMEs","Relationship Coordinator"};
    String[] instructor_qualifications_list = {"(B.C.Tech) Bechalor of Computer Technology (UCSMGY)","B.Sc, M.Sc, Ph.D (Zoology)","   "," BA(Japanese) YUFL"};
    int[] instructor_photo_list = {R.mipmap.instructor_4,R.mipmap.instructor_3,R.mipmap.instructor_2,R.mipmap.instructor_1};

    public InstructorlistFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_instructorlist, container, false);

        ila = new InstructorListAdapter(getActivity(),instructor_name_list,instructor_title_list,instructor_qualifications_list,instructor_photo_list);
        rcv = (RecyclerView) rootView.findViewById(R.id.rcv4_instructor);
        rcv.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        rcv.setAdapter(ila);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
