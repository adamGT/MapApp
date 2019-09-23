package com.example.mapapp.Features.FilePicker;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mapapp.Networking.NetworkImplementations;
import com.example.mapapp.Networking.ReturnValues.ReturnUploadPhoto;
import com.example.mapapp.R;
import com.example.mapapp.Utils.FileUtils;
import com.example.mapapp.storage.SharedPreferenceManager;

import java.io.File;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FilePickerFragment.OnImagePickerListener} interface
 * to handle interaction events.
 * Use the {@link FilePickerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FilePickerFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private static final int READ_REQUEST_CODE = 42;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private String filePath = ""; // Used to store image url

    private Button openFilePicker;
    private ImageView imageView;

    private Context mContext;

    private NetworkImplementations mNetworkImplementations;
    private FragmentManager fm;

    private OnImagePickerListener mListener;

    public FilePickerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FilePickerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FilePickerFragment newInstance(String param1, String param2) {
        FilePickerFragment fragment = new FilePickerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_file_picker, container, false);

        openFilePicker = view.findViewById(R.id.file_picker);
        imageView = view.findViewById(R.id.file_picker_imageview);

        mContext = getContext();
        fm = getFragmentManager();

        // Setup mNetworkImplementations
        mNetworkImplementations = new NetworkImplementations(mContext);

        openFilePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FilePickerButtonPressed();
            }
        });

        return view;
    }


    private void FilePickerButtonPressed(){

        // ACTION_OPEN_DOCUMENT is the intent to choose a file via the system's file
        // browser.
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);

        // Filter to only show results that can be "opened", such as a
        // file (as opposed to a list of contacts or timezones)
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        // Filter to show only images, using the image MIME data type.
        // If one wanted to search for ogg vorbis files, the type would be "audio/ogg".
        // To search for all documents available via installed storage providers,
        // it would be "*/*".
        intent.setType("application/*");

        startActivityForResult(intent, READ_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode,
                                 Intent resultData) {

        // The ACTION_OPEN_DOCUMENT intent was sent with the request code
        // READ_REQUEST_CODE. If the request code seen here doesn't match, it's the
        // response to some other intent, and the code below shouldn't run at all.

        if (requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            // The document selected by the user won't be returned in the intent.
            // Instead, a URI to that document will be contained in the return intent
            // provided to this method as a parameter.
            // Pull that URI using resultData.getData().
            Uri uri = null;
            if (resultData != null) {
                uri = resultData.getData();


                File file = FileUtils.getFile(getContext(), uri);
                filePath = file.getAbsolutePath();
//                imageView.setImageURI(uri);
//                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//                Toast.makeText(getContext(), "Path = "+ filePath,Toast.LENGTH_LONG).show();
//                showImage(uri);

                ReturnUploadPhoto returnUploadPhoto = new ReturnUploadPhoto() {
                    @Override
                    public void onSuccess(List<com.example.mapapp.POJO.File> files) {

                        Toast.makeText(mContext,"ReturnUploadPhoto : success",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure() {
//                        Toast.makeText(mContext, "ReturnUploadPhoto : failed", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse() {
                        //dialog.dismiss();
                    }
                };


                mNetworkImplementations.uploadPhoto(filePath, returnUploadPhoto);

            }
        }
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnImagePickerListener) {
            mListener = (OnImagePickerListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnImagePickerListener {
        // TODO: Update argument type and name
        void onImagePickerInteraction();
    }
}
