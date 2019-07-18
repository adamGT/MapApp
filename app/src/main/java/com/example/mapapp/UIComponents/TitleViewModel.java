package com.example.mapapp.UIComponents;

import androidx.annotation.NonNull;

public class TitleViewModel {

    private String title;
    private String subtitle;

    public TitleViewModel(@NonNull String title){
        this.title = title;
        this.subtitle = null;
    }

    public TitleViewModel(@NonNull String title, @NonNull String subtitle){
        this.title = title;
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }
}

