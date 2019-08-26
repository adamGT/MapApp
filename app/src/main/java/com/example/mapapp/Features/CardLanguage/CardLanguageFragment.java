package com.example.mapapp.Features.CardLanguage;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.mapapp.R;
import com.example.mapapp.UIComponents.TitleView;
import com.example.mapapp.Utils.MainUtills;

import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CardLanguageFragment.CardLanguageListener} interface
 * to handle interaction events.
 * Use the {@link CardLanguageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CardLanguageFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TitleView titleView;
    private Toolbar toolbar;

    private CardLanguageListener mListener;

    public CardLanguageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CardLanguageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CardLanguageFragment newInstance(String param1, String param2) {
        CardLanguageFragment fragment = new CardLanguageFragment();
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
        View view= inflater.inflate(R.layout.fragment_card_language, container, false);

        toolbar=view.findViewById(R.id.app_bar);
        MainUtills.setUpToolbar(toolbar,getActivity());

        titleView= view.findViewById(R.id.titleView);


        return view;
    }

    public void onButtonPressed() {
        if (mListener != null) {
            mListener.onLanguageSaved();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof CardLanguageListener) {
            mListener = (CardLanguageListener) context;
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

    public void populateLanguages(){
        for (Locale locale : Locale.getAvailableLocales()) {
            Log.d("LOCALES", locale.getLanguage() + "_" + locale.getCountry() + " [" + locale.getDisplayName() + "]");
        }
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
    public interface CardLanguageListener {
        // TODO: Update argument type and name
        void onLanguageSaved();
    }
}