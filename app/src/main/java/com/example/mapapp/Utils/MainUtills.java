package com.example.mapapp.Utils;

import android.app.Activity;
import android.hardware.input.InputManager;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainUtills {

    public static void navigateTo(int layoutId, Fragment fragment, String addType, boolean addToBackstack, FragmentManager fm) {

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        if(addType.contentEquals("add")){
            transaction.add(layoutId, fragment);
        }else if(addType.contentEquals("replace")){
            transaction.replace(layoutId, fragment);
        }
        if (addToBackstack) {
            transaction.addToBackStack(""+fragment.getId());
        }
        transaction.commit();
    }

    public static void setUpToolbar(Toolbar toolbar, FragmentActivity mActivity) {
        AppCompatActivity activity = (AppCompatActivity) mActivity;
        if (activity != null) {
            activity.setSupportActionBar(toolbar);
            activity.getSupportActionBar().setDisplayShowTitleEnabled(true);
        }
    }

    public static void hideSoftKeyboard(Activity activity){
            InputMethodManager inputManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }
}
