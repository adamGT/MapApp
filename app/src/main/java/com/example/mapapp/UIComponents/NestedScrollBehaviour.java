package com.example.mapapp.UIComponents;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;

import com.google.android.material.appbar.AppBarLayout;

public class NestedScrollBehaviour <V extends View> extends AppBarLayout.ScrollingViewBehavior {

    public NestedScrollBehaviour(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public int getTopAndBottomOffset() {
        return super.getTopAndBottomOffset();
    }
}
