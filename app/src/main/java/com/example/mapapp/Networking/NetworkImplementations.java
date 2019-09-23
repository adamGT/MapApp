package com.example.mapapp.Networking;



import android.content.Context;
import android.widget.Toast;

import com.example.mapapp.Networking.ReturnValues.ReturnUploadPhoto;

import java.io.File;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkImplementations {

    private static Context context;
    private Call call;

    public NetworkImplementations() { }

    public NetworkImplementations(Context context) {
        this.context = context;
    }

    public void uploadPhoto(String imagePath, final ReturnUploadPhoto returnUploadPhoto) {

        //File creating from selected URL
        File file = new File(imagePath);

        // create RequestBody instance from file
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);

        MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), requestFile);

        Call<List<com.example.mapapp.POJO.File>> call = RetrofitClient
                .getInstance(context)
                .getApi().uploadFile(body);

        call.enqueue(new Callback<List<com.example.mapapp.POJO.File>>() {
            @Override
            public void onResponse(Call<List<com.example.mapapp.POJO.File>> call, Response<List<com.example.mapapp.POJO.File>> response) {

                returnUploadPhoto.onResponse();

                if(response.isSuccessful())
                {

                    Toast.makeText(context, "NetworkImplementations : success", Toast.LENGTH_SHORT).show();
                    returnUploadPhoto.onSuccess(response.body());
                }
                else
                {
                    returnUploadPhoto.onFailure();


                    //Toast.makeText(context,context.getResources().getString(R.string.response_failure_caused) + response.message(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<com.example.mapapp.POJO.File>> call, Throwable t) {
                if (call.isCanceled()){
                    Toast.makeText(context, "Cancelled", Toast.LENGTH_SHORT).show();
                }
                else {
                    returnUploadPhoto.onFailure();
                    Toast.makeText(context, "NetworkImplementations : failed = "+ t.getMessage(), Toast.LENGTH_SHORT).show();
                    //Toast.makeText(context,context.getResources().getString(R.string.failure_caused) + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        this.call = call;

    }
}
