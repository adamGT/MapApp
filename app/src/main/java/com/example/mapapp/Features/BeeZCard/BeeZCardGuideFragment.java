package com.example.mapapp.Features.BeeZCard;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.mapapp.R;
import com.haipq.android.flagkit.FlagImageView;

import mehdi.sakout.fancybuttons.FancyButton;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BeeZCardGuideFragment.OnBeeZCardGuideInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BeeZCardGuideFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BeeZCardGuideFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnBeeZCardGuideInteractionListener mListener;

    private ImageView profileImageView;

    private FancyButton mFancyButton;
    private Button mSkipButton;

    private TextView nameTextView;
    private TextView jobTitleTextView;
    private TextView aboutTextView;
    private TextView moreAboutTextView;

    private TextView tags1TitleTextView;
    private TextView tag11TextView;
    private TextView tag12TextView;
    private TextView tag13TextView;

    private TextView tags2TitleTextView;
    private TextView tag21TextView;
    private TextView tag22TextView;
    private TextView tag23TextView;
    private FlagImageView flagImageView;

    private ConstraintLayout mNameAndFlagLayout;
    private ConstraintLayout mAboutLayout;
    private ConstraintLayout mGeneralBottomLayout;
    private ConstraintLayout mTagOneLayout;
    private ConstraintLayout mTagTwoLayout;


    public BeeZCardGuideFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BeeZCardGuideFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BeeZCardGuideFragment newInstance(String param1, String param2) {
        BeeZCardGuideFragment fragment = new BeeZCardGuideFragment();
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
       View view  = inflater.inflate(R.layout.fragment_bee_zcard_guide, container, false);

        profileImageView = view.findViewById(R.id.profilePictureImageView);

        mFancyButton = view.findViewById(R.id.uploadProfilePictureButton);
        mSkipButton = view.findViewById(R.id.skipButton);

        nameTextView = view.findViewById(R.id.nameTextView);
        jobTitleTextView = view.findViewById(R.id.jobTitleTextView);
        aboutTextView = view.findViewById(R.id.aboutTextView);
        moreAboutTextView = view.findViewById(R.id.moreAboutText);

        flagImageView = view.findViewById(R.id.flagView);

        tags1TitleTextView = view.findViewById(R.id.tag1TitleTextView);
        tag11TextView = view.findViewById(R.id.tag11TextView);
        tag12TextView = view.findViewById(R.id.tag12TextView);
        tag13TextView = view.findViewById(R.id.tag13TextView);

        tags2TitleTextView = view.findViewById(R.id.tag2TitleTextView);
        tag21TextView = view.findViewById(R.id.tag21TextView);
        tag22TextView = view.findViewById(R.id.tag22TextView);
        tag23TextView = view.findViewById(R.id.tag23TextView);

        mNameAndFlagLayout = view.findViewById(R.id.constraintLayout);

        mGeneralBottomLayout = view.findViewById(R.id.bottomLayouts);
        mAboutLayout = view.findViewById(R.id.aboutLayout);
        mTagOneLayout = view.findViewById(R.id.tag1Layout);
        mTagTwoLayout = view.findViewById(R.id.tag2Layout);


        setAllViewsInvisible();

        mFancyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFancyButton.setVisibility(View.INVISIBLE);
                mNameAndFlagLayout.setVisibility(View.VISIBLE);
                nameTextView.setVisibility(View.VISIBLE);
            }
        });

        nameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameTextView.setVisibility(View.INVISIBLE);
                jobTitleTextView.setVisibility(View.VISIBLE);
            }
        });

        jobTitleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jobTitleTextView.setVisibility(View.INVISIBLE);
                flagImageView.setVisibility(View.VISIBLE);
            }
        });

        flagImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flagImageView.setVisibility(View.INVISIBLE);
                mNameAndFlagLayout.setVisibility(View.INVISIBLE);
                mGeneralBottomLayout.setVisibility(View.VISIBLE);
            }
        });

        aboutTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAboutLayout.setVisibility(View.INVISIBLE);
                mTagOneLayout.setVisibility(View.VISIBLE);
            }
        });

        tag11TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tag11TextView.setVisibility(View.INVISIBLE);
                tag12TextView.setVisibility(View.VISIBLE);
            }
        });

        tag12TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tag12TextView.setVisibility(View.INVISIBLE);
                tag13TextView.setVisibility(View.VISIBLE);
            }
        });

        tag13TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tag13TextView.setVisibility(View.INVISIBLE);
                mTagOneLayout.setVisibility(View.INVISIBLE);
                mTagTwoLayout.setVisibility(View.VISIBLE);
            }
        });

        tag21TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tag21TextView.setVisibility(View.INVISIBLE);
                tag22TextView.setVisibility(View.VISIBLE);
            }
        });

        tag22TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tag22TextView.setVisibility(View.INVISIBLE);
                tag23TextView.setVisibility(View.VISIBLE);
            }
        });

        tag23TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onGuideCompleated();
            }
        });

        mSkipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSkipPressed();
            }
        });


       return view;
    }

    public void onSkipPressed() {
        if (mListener != null) {
            mListener.onGuideSkipClicked();
        }
    }

    public void onGuideCompleated() {
        if (mListener != null) {
            mListener.onGuideFinished();
        }
    }

    public void setAllViewsInvisible(){
        profileImageView.setVisibility(View.INVISIBLE);

        mNameAndFlagLayout.setVisibility(View.INVISIBLE);
        nameTextView.setVisibility(View.INVISIBLE);
        jobTitleTextView.setVisibility(View.INVISIBLE);
        flagImageView.setVisibility(View.INVISIBLE);

        mGeneralBottomLayout.setVisibility(View.INVISIBLE);

        mTagOneLayout.setVisibility(View.INVISIBLE);
        tag12TextView.setVisibility(View.INVISIBLE);
        tag13TextView.setVisibility(View.INVISIBLE);

        mTagTwoLayout.setVisibility(View.INVISIBLE);
        tag22TextView.setVisibility(View.INVISIBLE);
        tag23TextView.setVisibility(View.INVISIBLE);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnBeeZCardGuideInteractionListener) {
            mListener = (OnBeeZCardGuideInteractionListener) context;
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
    public interface OnBeeZCardGuideInteractionListener {
        void onFancyButtonClicked();
        void onUserNameClicked();
        void onPossitionClicked();
        void onBioClicked();
        void onFirstTagOneClicked();
        void onFirstTagTwoClicked();
        void onFirstTagThreeClicked();
        void onSecondTagOneClicked();
        void onSecondTagTwoClicked();
        void onSecondTagThreeClicked();
        void onGuideSkipClicked();
        void onGuideFinished();
    }
}
