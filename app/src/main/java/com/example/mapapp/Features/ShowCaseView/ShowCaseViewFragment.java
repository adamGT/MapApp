package com.example.mapapp.Features.ShowCaseView;

import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.mapapp.R;
import com.example.mapapp.ShowCase.BeezMaterialShowCaseView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ShowCaseViewFragment.OnShowCaseViewListener} interface
 * to handle interaction events.
 * Use the {@link ShowCaseViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShowCaseViewFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnShowCaseViewListener mListener;

    private Button mShowCase;

    public ShowCaseViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShowCaseViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShowCaseViewFragment newInstance(String param1, String param2) {
        ShowCaseViewFragment fragment = new ShowCaseViewFragment();
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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_show_case_view, container, false);

        mShowCase = view.findViewById(R.id.show_case_btn);


        BeezMaterialShowCaseView.Builder showCaseBuilder;
        showCaseBuilder = new BeezMaterialShowCaseView.Builder(getActivity());
        showCaseBuilder
                .setTarget(mShowCase)
                .setDelay(500)
                .setTargetTouchable(true)
                .setDismissOnTouch(false)
                .setFadeDuration(300)
                .show() ;


        return view;
    }

    private int layoutHeight(float percent){
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int height = size.y;
        int myheight= (int) (height*percent); // any percent of the screen you want
//        Toast.makeText(mContext,"My Height: "+myheight+" Pix",Toast.LENGTH_SHORT).show();

        return myheight;
    }

    public int getSoftButtonsBarSizePort() {

        int resourceId = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            return getResources().getDimensionPixelSize(resourceId);
        }

        return 0;

    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onShowCaseInteraction();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnShowCaseViewListener) {
            mListener = (OnShowCaseViewListener) context;
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
    public interface OnShowCaseViewListener {
        void onShowCaseInteraction();
    }
}
