package com.example.mapapp.Features.Dragging;

import android.content.Context;
import android.graphics.Point;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.view.Display;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mapapp.Adapters.BackCardAdapter;
import com.example.mapapp.POJO.BackCardItem;
import com.example.mapapp.R;

import java.util.ArrayList;
import java.util.List;

import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;

/**
 * A simple {@link androidx.fragment.app.Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ViewDraggingFragment.OnDraggListener} interface
 * to handle interaction events.
 * Use the {@link ViewDraggingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewDraggingFragment extends Fragment implements Listener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static float DX ;
    private static float DY ;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

//    private ImageButton imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8;
//    private RecyclerView recyclerView;

//    @BindView(R.id.rvTop)
//    RecyclerView rvTop;
//    @BindView(R.id.rvBottom)
//    RecyclerView rvBottom;
//    @BindView(R.id.tvEmptyListTop)
//    TextView tvEmptyListTop;
//    @BindView(R.id.tvEmptyListBottom)
//    TextView tvEmptyListBottom;

    private RecyclerView rvTop,rvBottom;
    private TextView tvEmptyListTop,tvEmptyListBottom;

    private List<String> backCardItems =new ArrayList<>();
    private BackCardAdapter adapter;

    private OnDraggListener mListener;

    public ViewDraggingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ViewDraggingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ViewDraggingFragment newInstance(String param1, String param2) {
        ViewDraggingFragment fragment = new ViewDraggingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_dragging, container, false);

        rvTop = view.findViewById(R.id.rvTop);
        rvBottom = view.findViewById(R.id.rvBottom);

        tvEmptyListTop = view.findViewById(R.id.tvEmptyListTop);
        tvEmptyListBottom = view.findViewById(R.id.tvEmptyListBottom);




        initTopRecyclerView();
        initBottomRecyclerView();


        tvEmptyListTop.setVisibility(View.GONE);
        tvEmptyListBottom.setVisibility(View.GONE);

        return  view;
    }

    private void initTopRecyclerView() {
        rvTop.setLayoutManager(new LinearLayoutManager(
                getContext(), LinearLayoutManager.VERTICAL, false));

        List<BackCardItem> topList = new ArrayList<>();
//        topList.add("A");
//        topList.add("B");

        ListAdapter topListAdapter = new ListAdapter(getContext(),topList, this,"backItems");
        rvTop.setAdapter(topListAdapter);
        tvEmptyListTop.setOnDragListener(topListAdapter.getDragInstance());
        rvTop.setOnDragListener(topListAdapter.getDragInstance());
    }

    private void initBottomRecyclerView() {
        rvBottom.setLayoutManager(new GridLayoutManager(getContext(), 4,LinearLayoutManager.VERTICAL,true));

        List<BackCardItem> bottomList = new ArrayList<>();
        bottomList.add(new BackCardItem("car_pic",R.mipmap.car_pic));
        bottomList.add(new BackCardItem("run_pic",R.mipmap.run_pic));
        bottomList.add(new BackCardItem("cycle_pic",R.mipmap.cycle_pic));
        bottomList.add(new BackCardItem("pool_pic",R.mipmap.pool_pic));
        bottomList.add(new BackCardItem("train_pic",R.mipmap.train_pic));
        bottomList.add(new BackCardItem("motor_pic",R.mipmap.motor_pic));

        ListAdapter bottomListAdapter = new ListAdapter(getContext(),bottomList, this,"collectionItems");
        rvBottom.setAdapter(bottomListAdapter);
        tvEmptyListBottom.setOnDragListener(bottomListAdapter.getDragInstance());
        rvBottom.setOnDragListener(bottomListAdapter.getDragInstance());
    }



    @Override
    public void setEmptyListTop(boolean visibility) {
        tvEmptyListTop.setVisibility(visibility ? View.VISIBLE : View.GONE);
        rvTop.setVisibility(visibility ? View.GONE : View.VISIBLE);
    }

    @Override
    public void setEmptyListBottom(boolean visibility) {
        tvEmptyListBottom.setVisibility(visibility ? View.VISIBLE : View.GONE);
        rvBottom.setVisibility(visibility ? View.GONE : View.VISIBLE);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnDraggListener) {
            mListener = (OnDraggListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnDraggListener {
        // TODO: Update argument type and name
        void onDragged();
    }
}
