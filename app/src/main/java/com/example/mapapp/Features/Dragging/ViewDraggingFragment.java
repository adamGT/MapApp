package com.example.mapapp.Features.Dragging;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.mapapp.R;

/**
 * A simple {@link androidx.fragment.app.Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ViewDraggingFragment.OnDraggListener} interface
 * to handle interaction events.
 * Use the {@link ViewDraggingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewDraggingFragment extends Fragment implements View.OnTouchListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static float DX ;
    private static float DY ;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ImageButton imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8;

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

        imageView1 = view.findViewById(R.id.my_image1);
        imageView2 = view.findViewById(R.id.my_image2);
        imageView3 = view.findViewById(R.id.my_image3);
        imageView4 = view.findViewById(R.id.my_image4);
        imageView5 = view.findViewById(R.id.my_image5);
        imageView6 = view.findViewById(R.id.my_image6);
        imageView7 = view.findViewById(R.id.my_image7);
        imageView8 = view.findViewById(R.id.my_image8);

        imageView1.setOnTouchListener(this);
        imageView2.setOnTouchListener(this);
        imageView3.setOnTouchListener(this);
        imageView4.setOnTouchListener(this);
        imageView5.setOnTouchListener(this);
        imageView6.setOnTouchListener(this);
        imageView7.setOnTouchListener(this);
        imageView8.setOnTouchListener(this);



        return  view;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN :
                DX = v.getX() - event.getRawX();
                DY = v.getY() - event.getRawY();

                break;
            case MotionEvent.ACTION_MOVE :
                v.setX(event.getRawX()+DX);
                v.setY(event.getRawY()+DY);

                break;
        }

        return false;
    }

    public void onButtonPressed() {
        if (mListener != null) {
            mListener.onDragged();
        }
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
