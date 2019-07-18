package com.example.mapapp.UIComponents;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mapapp.R;

public class TitleView extends LinearLayout {

    private TextView mTitleTextView;
    private TextView mSubtitleTextView;

    public TitleView(Context context) {
        super(context);
        init(null);
    }

    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public TitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }


    private void init(AttributeSet attrs) {

        LayoutInflater.from(getContext()).inflate(R.layout.custom_view_title, this);


        mTitleTextView = findViewById(R.id.titleTextView);
        mSubtitleTextView = findViewById(R.id.subtitleTextView);


        if (attrs == null) {
            return;
        }

        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.TitleView,
                0, 0);


        final Boolean centerize = a.getBoolean(R.styleable.TitleView_centerize, false);

        if (centerize){
            setGravity(Gravity.CENTER);
            mTitleTextView.setGravity(Gravity.CENTER);
            mSubtitleTextView.setGravity(Gravity.CENTER);
        }


        final int titleLines = a.getInt(R.styleable.TitleView_lines, 1);
        mTitleTextView.setLines(titleLines);
        // set custom title
        final String titleText = a.getString(R.styleable.TitleView_titleText);
        mTitleTextView.setText(titleText);

        // set custom subtitle
        final String subtitleText = a.getString(R.styleable.TitleView_subtitleText);
        mSubtitleTextView.setText(subtitleText);


        // handle subtitle visibility
        final boolean showSubtitle = a.getBoolean(R.styleable.TitleView_ShowSubtitle, false);
        // hide/show subtitle following the show subtitle custom attribute value
        mSubtitleTextView.setVisibility(showSubtitle ? View.VISIBLE : View.GONE);


    }

    public TextView getmTitleTextView() {
        return mTitleTextView;
    }

    public TextView getmSubtitleTextView() {
        return mSubtitleTextView;
    }

    public void configure(TitleViewModel viewModel) {

        mTitleTextView.setText(viewModel.getTitle());

        if (viewModel.getSubtitle() != null) {
            mSubtitleTextView.setText(viewModel.getSubtitle());
            mSubtitleTextView.setVisibility(View.VISIBLE);
        } else {
            mSubtitleTextView.setVisibility(View.GONE);
        }
    }
}
