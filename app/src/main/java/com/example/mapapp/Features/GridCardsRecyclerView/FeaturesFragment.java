package com.example.mapapp.Features.GridCardsRecyclerView;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;

import com.example.mapapp.Adapters.FeatureListAdapter;
import com.example.mapapp.POJO.Feature;
import com.example.mapapp.R;
import com.example.mapapp.UIComponents.TitleView;
import com.example.mapapp.UIComponents.TitleViewModel;
import com.example.mapapp.Utils.MainUtills;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FeaturesFragment.OnFeatureListener} interface
 * to handle interaction events.
 * Use the {@link FeaturesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FeaturesFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private Toolbar toolbar;
    private TitleView titleView;
    private RecyclerView recyclerView;

    private String moduleName;
    private List<Feature> features = new ArrayList<>();

    private FeatureListAdapter adapter;

    private OnFeatureListener mListener;

    private FeaturesFragment() {
        // Required empty public constructor
    }

    public static FeaturesFragment newInstance(String param1 ) {
        FeaturesFragment fragment = new FeaturesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            moduleName = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_features, container, false);

        toolbar = view.findViewById(R.id.app_bar);
        titleView = view.findViewById(R.id.titleView);

        MainUtills.setUpToolbar(toolbar,getActivity());

        titleView.configure(new TitleViewModel(moduleName));

        recyclerView = view.findViewById(R.id.feature_recycler);

//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));
        recyclerView.setLayoutManager(new LinearLayoutManager(
                getContext(), LinearLayoutManager.VERTICAL, false));

        features.add(new Feature("Feature 1", R.color.beez_code_background,true));
        features.add(new Feature("Feature 2", R.color.beezprofessional,true));
        features.add(new Feature("Feature 3", R.color.bottomSheetOptions,false));
        features.add(new Feature("Feature 4", R.color.beezsocial,false));
        features.add(new Feature("Feature 5", R.color.yellow,true));

        adapter = new FeatureListAdapter(getContext(),features);

        recyclerView.setAdapter(adapter);


        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFeatureListener) {
            mListener = (OnFeatureListener) context;
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
    public interface OnFeatureListener {
        void onFeatureClicked();
    }
}
