package com.example.mapapp.Networking.ReturnValues;

import com.example.mapapp.POJO.File;

import java.util.List;

public interface ReturnUploadPhoto {

    void onSuccess(List<File> files);
    void onFailure();
    void onResponse();
}
