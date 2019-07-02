package com.example.mapapp;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity implements
        MapFragment.OnMapFragmentInteractionListener,
        HomeFragment.OnHomeFragmentInteractionListener{


    private FragmentManager fm = getSupportFragmentManager();

    private MapFragment mapFragment = MapFragment.newInstance(null, null);
    private HomeFragment homeFragment = HomeFragment.newInstance(null, null);

    @Override
    public void onMapFragmentInteraction() {

    }

    private enum Fragments {
        Map("MapFragment"),
        Home("HomeFragment");

        private final String name;

        Fragments(String s) {
            name = s;
        }


        public String toString() {
            return this.name;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm.beginTransaction()
                .add(R.id.container, homeFragment, Fragments.Home.name)
                .commit();

    }


    @Override
    public void onHomeFragmentInteraction(Uri uri) {

    }

    @Override
    public void openMapFragment(){
        fm.beginTransaction()
                .replace(R.id.container, mapFragment, Fragments.Map.name)
                .addToBackStack(Fragments.Home.name)
                .commit();
    }



}
