package com.example.mapapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.view.ContextThemeWrapper;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link UserGuideFragment.OnButtonsClickedListener} interface
 * to handle interaction events.
 * Use the {@link UserGuideFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserGuideFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnButtonsClickedListener mListener;


    public Button mButton,mCountryButton,mLangageButton,mPopUp,mAddToCalendar,mSkip,mStepGuide;
    public UserGuideFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserGuideFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserGuideFragment newInstance(String param1, String param2) {
        UserGuideFragment fragment = new UserGuideFragment();
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
        View view =  inflater.inflate(R.layout.fragment_user_guide, container, false);

        mButton=view.findViewById(R.id.button);
        mCountryButton=view.findViewById(R.id.country_list_button);
        mLangageButton=view.findViewById(R.id.language);
        mPopUp=view.findViewById(R.id.popup);
        mSkip=view.findViewById(R.id.skipButton);
        mAddToCalendar=view.findViewById(R.id.addToCalendar);
        mStepGuide=view.findViewById(R.id.step_guide);

        mButton.setVisibility(View.INVISIBLE);
        mLangageButton.setVisibility(View.INVISIBLE);
        mPopUp.setVisibility(View.INVISIBLE);
        mAddToCalendar.setVisibility(View.INVISIBLE);
        mStepGuide.setVisibility(View.INVISIBLE);

        mCountryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mButton.setVisibility(View.VISIBLE);
                mCountryButton.setVisibility(View.INVISIBLE);
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mButton.setVisibility(View.INVISIBLE);
                mLangageButton.setVisibility(View.VISIBLE);
            }
        });

        mLangageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLangageButton.setVisibility(View.INVISIBLE);
                mPopUp.setVisibility(View.VISIBLE);
            }
        });

        mPopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopUp.setVisibility(View.INVISIBLE);
                mAddToCalendar.setVisibility(View.VISIBLE);
            }
        });

        mAddToCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAddToCalendar.setVisibility(View.INVISIBLE);
                mStepGuide.setVisibility(View.VISIBLE);

            }
        });

        mStepGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStepGuide.setVisibility(View.INVISIBLE);
                mCountryButton.setVisibility(View.VISIBLE);
            }
        });

        mSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSkipButtonPressed();
            }
        });

        return view;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onSkipButtonPressed() {
        if (mListener != null) {
            mListener.onSkipButtonClicked();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnButtonsClickedListener) {
            mListener = (OnButtonsClickedListener) context;
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
    public interface OnButtonsClickedListener {
        void onSkipButtonClicked();
    }
}
