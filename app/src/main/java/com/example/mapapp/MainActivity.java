package com.example.mapapp;

import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.mapapp.Features.BeeZCard.BeeZCardFragment;
import com.example.mapapp.Features.CardLanguage.CardLanguageFragment;
import com.example.mapapp.Features.UserGuide.GuideFragment;
import com.example.mapapp.Features.Map.MapFragment;
import com.example.mapapp.Features.CardLanguage.RecyclerFragment;
import com.example.mapapp.Features.UserGuide.StepGuideFragment;
import com.example.mapapp.Features.UserGuide.UserGuideFragment;
import com.example.mapapp.Utils.MainUtills;

public class MainActivity extends AppCompatActivity implements
        MapFragment.OnMapFragmentInteractionListener,
        HomeFragment.OnHomeFragmentInteractionListener,
        RecyclerFragment.OnFragmentInteractionListener,
        CardLanguageFragment.CardLanguageListener,
        UserGuideFragment.OnButtonsClickedListener,
        StepGuideFragment.OnButtonClickedListener,
        GuideFragment.OnButtonsClickedListener,
        BeeZCardFragment.OnBeeZCardInteractionListener {


    private FragmentManager fm = getSupportFragmentManager();

    private MapFragment mapFragment = MapFragment.newInstance(null, null);
    private HomeFragment homeFragment = HomeFragment.newInstance(null, null);
    private RecyclerFragment recyclerFragment = RecyclerFragment.newInstance(null, null);
    private CardLanguageFragment languageFragment = CardLanguageFragment.newInstance(null, null);
    private UserGuideFragment userGuideFragment = UserGuideFragment.newInstance(null, null);
    private StepGuideFragment stepGuideFragment = StepGuideFragment.newInstance(null, null);
    private GuideFragment guideFragment = GuideFragment.newInstance(null, null);
    private BeeZCardFragment beeZCardFragment = BeeZCardFragment.newInstance(null, null);


    private enum Fragments {
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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                    getSupportFragmentManager().popBackStack();
                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                }
                else {
                    finish();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        } else {
            super.onBackPressed();
        }
    }

//    Fragment Management Methods

    @Override
    public void onHomeFragmentInteraction(Uri uri) {

    }

    @Override
    public void onLanguageSaved() {

    }

    @Override
    public void openMapFragment(){
        MainUtills.navigateTo(R.id.container,mapFragment,"replace",true,fm);
    }

    @Override
    public void onCountryClicked(){
        MainUtills.navigateTo(R.id.container,recyclerFragment,"replace",true,fm);
    }

    @Override
    public void onLanguageClicked() {
        MainUtills.navigateTo(R.id.container,languageFragment,"replace",true,fm);
    }
    @Override
    public void onUserGuideClicked(){
        MainUtills.navigateTo(R.id.container,userGuideFragment,"add",true,fm);
    }

    @Override
    public void onStepGuideClicked() {
        MainUtills.navigateTo(R.id.container,stepGuideFragment,"replace",true,fm);
        MainUtills.navigateTo(R.id.container,guideFragment,"add",true,fm);
    }

    @Override
    public void onStepGuideButtonClicked() {

    }

    @Override
    public void onSkipButtonClicked() {
        MainUtills.navigateTo(R.id.container,homeFragment,"replace",false,fm);
    }

    @Override
    public void onBeeZCardClicked() {
        MainUtills.navigateTo(R.id.container,beeZCardFragment,"replace",true,fm);
    }

    @Override
    public void onSkipClicked() {
            getSupportFragmentManager().popBackStack();
//            MainUtills.hideSoftKeyboard(this);
//        MainUtills.navigateTo(R.id.container,stepGuideFragment,"replace",false,fm);
    }


    @Override
    public void onMapFragmentInteraction() {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onCardInteraction() {

    }



//    Tags


    @Override
    public void editTag1(String text) {
        stepGuideFragment.setmTag1(text);
    }

    @Override
    public void editTag2(String text) {
        stepGuideFragment.setmTag2(text);
    }

    @Override
    public void editTag3(String text) {
        stepGuideFragment.setmTag3(text);
    }

    @Override
    public void editTag4(String text) {
        stepGuideFragment.setmTag4(text);
    }
}
