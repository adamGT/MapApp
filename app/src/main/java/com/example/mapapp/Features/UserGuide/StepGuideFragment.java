package com.example.mapapp.Features.UserGuide;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.mapapp.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StepGuideFragment.OnButtonClickedListener} interface
 * to handle interaction events.
 * Use the {@link StepGuideFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StepGuideFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnButtonClickedListener mListener;


    private EditText mTag1,mTag2,mTag3,mTag4;

    public StepGuideFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StepGuideFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StepGuideFragment newInstance(String param1, String param2) {
        StepGuideFragment fragment = new StepGuideFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_step_guide, container, false);


        mTag1 = view.findViewById(R.id.inputOne);
        mTag2 = view.findViewById(R.id.inputTwo);
        mTag3 = view.findViewById(R.id.inputThree);
        mTag4 = view.findViewById(R.id.inputFour);


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onStepGuidePressed() {
        if (mListener != null) {
            mListener.onStepGuideButtonClicked();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnButtonClickedListener) {
            mListener = (OnButtonClickedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    public void setmTag1(String text){
        mTag1.setText(text);
    }

    public void setmTag2(String text){
        mTag2.setText(text);
    }

    public void setmTag3(String text){
        mTag3.setText(text);
    }

    public void setmTag4(String text){
        mTag4.setText(text);
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
    public interface OnButtonClickedListener {
        // TODO: Update argument type and name
        void onStepGuideButtonClicked();
    }
}
