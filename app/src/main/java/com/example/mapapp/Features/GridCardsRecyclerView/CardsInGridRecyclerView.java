package com.example.mapapp.Features.GridCardsRecyclerView;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mapapp.Adapters.GridCardAdapter;
import com.example.mapapp.POJO.Module;
import com.example.mapapp.R;
import com.example.mapapp.Utils.ItemTouchListener;
import com.example.mapapp.storage.SharedPreferenceManager;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CardsInGridRecyclerView.OnGridCardsListener} interface
 * to handle interaction events.
 * Use the {@link CardsInGridRecyclerView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CardsInGridRecyclerView extends Fragment {

    public enum LaunchMode {
        SETUP,
        EDIT
    }

    private static final String ARG_LAUNCH_MODE = " ";

    private Context mContext;
    private RecyclerView recyclerView;

    private List<Module> moduleList = new ArrayList<>();

    private GridCardAdapter adapter;

    private OnGridCardsListener mListener;

    private String setup;

    private CardsInGridRecyclerView() {
        // Required empty public constructor
    }

    public static CardsInGridRecyclerView newInstance(LaunchMode launchMode) {
        CardsInGridRecyclerView fragment = new CardsInGridRecyclerView();
        Bundle args = new Bundle();
        args.putInt(ARG_LAUNCH_MODE, launchMode.ordinal());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            setup = CardsInGridRecyclerView.LaunchMode.values()[getArguments().getInt(ARG_LAUNCH_MODE)].name();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cards_in_grid_recycler_view, container, false);

        mContext = getContext();

        recyclerView = view.findViewById(R.id.grid_card_recycler);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL,false));

        if(SharedPreferenceManager.getInstance(mContext).getIsFirstTime() == 0) {
            moduleList.clear();

            moduleList.add(new Module(" ", R.drawable.add_module_icon));

        }else {
                moduleList.clear();

                moduleList.add(new Module("Employee On-Boarding", R.drawable.emp_on_boarding_module));
                moduleList.add(new Module("Application Submission", R.drawable.app_submission_module));

        }

        if(adapter == null) {
            adapter = new GridCardAdapter(getContext(), moduleList);
        }

            recyclerView.setAdapter(adapter);



        recyclerView.addOnItemTouchListener(new ItemTouchListener(getContext(), recyclerView, new ItemTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                if(!(mListener == null)){
                    if(SharedPreferenceManager.getInstance(mContext).getIsFirstTime() == 0){

                        SharedPreferenceManager.getInstance(mContext).isFirstTime(1);
                        moduleList.clear();

                        moduleList.add(new Module(" ", R.drawable.emp_on_boarding_module));
                        moduleList.add(new Module(" ", R.drawable.app_submission_module));

                        adapter = new GridCardAdapter(getContext(), moduleList);
                        recyclerView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    } else mListener.onItemClicked(moduleList.get(position).getModuleName());

                }
            }

            @Override
            public void onLongClick(View view, final int position) {

            }
        }));

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnGridCardsListener) {
            mListener = (OnGridCardsListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnGridCardsListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnGridCardsListener {
        void onItemClicked(String moduleName);
    }
}
