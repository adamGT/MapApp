package com.example.mapapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.mapapp.Features.BeeZCard.BeeZCardFragment;
import com.example.mapapp.Features.BeeZCard.BeeZCardGuideFragment;
import com.example.mapapp.Features.BeeZCard.CongratulationsFragment;
import com.example.mapapp.Features.CardLanguage.CardLanguageFragment;
import com.example.mapapp.Features.CoordinatorFeatures.CoordinatorBasicFragment;
import com.example.mapapp.Features.Dragging.ViewDraggingFragment;
import com.example.mapapp.Features.FilePicker.FilePickerFragment;
import com.example.mapapp.Features.GridCardsRecyclerView.CardsInGridRecyclerView;
import com.example.mapapp.Features.GridCardsRecyclerView.FeaturesFragment;
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
        BeeZCardFragment.OnBeeZCardInteractionListener,
        BeeZCardGuideFragment.OnBeeZCardGuideInteractionListener,
        CongratulationsFragment.OnCongratulationsListener,
        ViewDraggingFragment.OnDraggListener,
        FilePickerFragment.OnImagePickerListener,
        CoordinatorBasicFragment.OnCoordinatorActionListener,
        CardsInGridRecyclerView.OnGridCardsListener,
        FeaturesFragment.OnFeatureListener {


    private FragmentManager fm = getSupportFragmentManager();

    private MapFragment mapFragment = MapFragment.newInstance(null, null);
    private HomeFragment homeFragment = HomeFragment.newInstance(null, null);
    private RecyclerFragment recyclerFragment = RecyclerFragment.newInstance(null, null);
    private CardLanguageFragment languageFragment = CardLanguageFragment.newInstance(null, null);
    private UserGuideFragment userGuideFragment = UserGuideFragment.newInstance(null, null);
    private StepGuideFragment stepGuideFragment = StepGuideFragment.newInstance(null, null);
    private GuideFragment guideFragment = GuideFragment.newInstance(null, null);
    private BeeZCardFragment beeZCardFragment = BeeZCardFragment.newInstance(null, null);
    private BeeZCardGuideFragment beeZCardGuideFragment = BeeZCardGuideFragment.newInstance(null, null);
    private CongratulationsFragment congratulationsFragment = CongratulationsFragment.newInstance(null, null);
    private ViewDraggingFragment viewDraggingFragment = ViewDraggingFragment.newInstance(null, null);
    private FilePickerFragment filePickerFragment = FilePickerFragment.newInstance(null, null);
    private CoordinatorBasicFragment coordinatorBasicFragment = CoordinatorBasicFragment.newInstance(null, null);
    private CardsInGridRecyclerView cardsInGridRecyclerView = CardsInGridRecyclerView.newInstance();


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
        MainUtills.navigateTo(R.id.container,beeZCardGuideFragment,"add",true,fm);

    }

    @Override
    public void onShowCaseClicked() {
        Intent intent = new Intent(MainActivity.this, ShowCaseActivity.class);
        finishAffinity();
        startActivity(intent);

    }

    @Override
    public void onDraggingClicked() {
        MainUtills.navigateTo(R.id.container,viewDraggingFragment,"replace",true,fm);
    }

    @Override
    public void onFilePickerClicked() {
        MainUtills.navigateTo(R.id.container,filePickerFragment,"replace",true,fm);
    }

    @Override
    public void onCoordinatorClicked() {
        MainUtills.navigateTo(R.id.container,coordinatorBasicFragment,"replace",true,fm);
    }
    @Override
    public void onCardRecyclerClicked() {
        MainUtills.navigateTo(R.id.container,cardsInGridRecyclerView,"replace",true,fm);
    }

    @Override
    public void onSkipClicked() {
            getSupportFragmentManager().popBackStack();
//            MainUtills.hideSoftKeyboard(this);
//        MainUtills.navigateTo(R.id.container,stepGuideFragment,"replace",false,fm);
    }

    @Override
    public void onImagePickerInteraction() {

    }

    //For Cards in Grid RecyclerView
    @Override
    public void onItemClicked(String moduleName) {
        MainUtills.navigateTo(R.id.container,FeaturesFragment.newInstance(moduleName),"replace",true,fm);
    }

    @Override
    public void onFeatureClicked() {

    }

    //    ViewDragging Fragment

    @Override
    public void onDragged() {

    }


//    For Congratulations Fragment


    @Override
    public void onContinueClicked() {
        MainUtills.navigateTo(R.id.container,beeZCardFragment,"replace",false,fm);
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


//    For BeeZCardGuide Fragment


    @Override
    public void onFancyButtonClicked() {

    }

    @Override
    public void onUserNameClicked() {

    }

    @Override
    public void onPossitionClicked() {

    }

    @Override
    public void onBioClicked() {

    }

    @Override
    public void onFirstTagOneClicked() {

    }

    @Override
    public void onFirstTagTwoClicked() {

    }

    @Override
    public void onFirstTagThreeClicked() {

    }

    @Override
    public void onSecondTagOneClicked() {

    }

    @Override
    public void onSecondTagTwoClicked() {

    }

    @Override
    public void onSecondTagThreeClicked() {

    }

    @Override
    public void onGuideSkipClicked() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void onGuideFinished() {
        MainUtills.navigateTo(R.id.container,congratulationsFragment,"replace",false,fm);
    }
}
