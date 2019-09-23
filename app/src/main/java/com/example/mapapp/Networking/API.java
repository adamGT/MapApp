package com.example.mapapp.Networking;

import com.example.mapapp.POJO.File;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface API {

    @Multipart
    @POST("files")
    Call<List<File>> uploadFile(@Part MultipartBody.Part file);

}
