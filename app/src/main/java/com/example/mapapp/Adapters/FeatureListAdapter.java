package com.example.mapapp.Adapters;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mapapp.POJO.Feature;
import com.example.mapapp.R;

import java.util.List;

public class FeatureListAdapter extends RecyclerView.Adapter<FeatureListAdapter.ViewHolder> {

    private List<Feature> features;
    private Context mContext;

    public FeatureListAdapter(Context  mContext, List<Feature> features) {
        this.mContext=mContext;
        this.features=features;
    }

    @NonNull
    @Override
    public FeatureListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.feature_list_item, parent, false);

        return new FeatureListAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FeatureListAdapter.ViewHolder holder, int position) {
        final Feature feature = this.features.get(position);

        holder.featureTitle.setText(feature.getFeatureTitle());
        holder.featureDescription.setText(feature.getFeatureDescription());
        holder.featureImage.setImageResource(feature.getFeatureImageId());
        holder.featureImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if(feature.isActive()){
            holder.featureActive.setText("Active");
            holder.featureActive.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
            holder.dotImage.setColorFilter(mContext.getResources().getColor(R.color.colorAccent));
        }else {
            holder.featureActive.setText("Not Active");
            holder.featureActive.setTextColor(mContext.getResources().getColor(R.color.quantum_grey_600));
            holder.dotImage.setColorFilter(mContext.getResources().getColor(R.color.quantum_grey_600));
        }
    }

    @Override
    public int getItemCount() {
        return this.features != null ? this.features.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView featureTitle,featureActive,featureDescription;
        public ImageView featureImage,dotImage;

        public ViewHolder(@NonNull View view) {
            super(view);
            featureTitle = view.findViewById(R.id.feature_title);
            featureDescription = view.findViewById(R.id.feature_title_description);
            featureActive = view.findViewById(R.id.feature_active);
            featureImage = view.findViewById(R.id.feature_image);
            dotImage = view.findViewById(R.id.dot_img);

        }


    }
}
