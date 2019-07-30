package com.example.mapapp.UIComponents;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.mapapp.R;
import com.haipq.android.flagkit.FlagImageView;

public class BeeZCardView extends ConstraintLayout implements View.OnClickListener {

private ImageView profileImageView;
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


private boolean allowEditing = false;

private BeeZCardViewListener listener;


public BeeZCardView(Context context) {
        super(context);
        init();
        }

public BeeZCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        }

public BeeZCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        }

private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.custom_beezcard_view, this);

        profileImageView = findViewById(R.id.profilePictureImageView);

        nameTextView = findViewById(R.id.nameTextView);
        jobTitleTextView = findViewById(R.id.jobTitleTextView);
        aboutTextView = findViewById(R.id.aboutTextView);
        moreAboutTextView = findViewById(R.id.moreAboutText);

        tags1TitleTextView = findViewById(R.id.tag1TitleTextView);
        tag11TextView = findViewById(R.id.tag11TextView);
        tag12TextView = findViewById(R.id.tag12TextView);
        tag13TextView = findViewById(R.id.tag13TextView);

        tags2TitleTextView = findViewById(R.id.tag2TitleTextView);
        tag21TextView = findViewById(R.id.tag21TextView);
        tag22TextView = findViewById(R.id.tag22TextView);
        tag23TextView = findViewById(R.id.tag23TextView);
        flagImageView = findViewById(R.id.flagView);

        toggleEditing(false);
        }


public void toggleEditing(boolean editing){
        allowEditing = editing;
// handle BeeZCard editing

final int visibility = allowEditing ? View.VISIBLE : View.GONE;


        }

public void setListener(BeeZCardViewListener listener){
        this.listener = listener;

        attachListeners();
        }

public ImageView getProfileImageView() {
        return profileImageView;
        }

public TextView getNameTextView() {
        return nameTextView;
        }

public TextView getJobTitleTextView() {
        return jobTitleTextView;
        }

public TextView getAboutTextView() {
        return aboutTextView;
        }

public TextView getTags1TitleTextView() {
        return tags1TitleTextView;
        }

public TextView getTags2TitleTextView() {
        return tags2TitleTextView;
        }

public TextView getTag11TextView() {
        return tag11TextView;
        }

public TextView getTag12TextView() {
        return tag12TextView;
        }

    public TextView getTag13TextView() {
        return tag13TextView;
        }

    public TextView getTag21TextView() {
        return tag21TextView;
        }

    public TextView getTag22TextView() {
        return tag22TextView;
        }

    public TextView getTag23TextView() {
        return tag23TextView;
        }

    public TextView getMoreAboutTextView() {
        return moreAboutTextView;
        }

    public FlagImageView getFlagImageView() {
        return flagImageView;
        }

    private void attachListeners(){

        }

    @Override
    public void onClick(View view) {

        if (listener == null){
        return;
        }

    final int viewId = view.getId();
    final View v = BeeZCardView.this;


        }
}


