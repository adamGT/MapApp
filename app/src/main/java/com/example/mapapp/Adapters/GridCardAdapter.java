package com.example.mapapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mapapp.POJO.Module;
import com.example.mapapp.R;

import java.util.List;

public class GridCardAdapter extends RecyclerView.Adapter<GridCardAdapter.ViewHolder> {

    private List<Module> modules;
    private Context mContext;

    public GridCardAdapter(Context  mContext, List<Module> modules) {
        this.mContext=mContext;
        this.modules=modules;
    }

    @NonNull
    @Override
    public GridCardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.module_list_item, parent, false);

        return new GridCardAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GridCardAdapter.ViewHolder holder, int position) {
        final Module module = this.modules.get(position);

        holder.moduleTitle.setText(module.getModuleName());
        holder.moduleImage.setImageResource(module.getModuleResId());
    }

    @Override
    public int getItemCount() {
        return this.modules != null ? this.modules.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView moduleTitle;
        public ImageView moduleImage;

        public ViewHolder(@NonNull View view) {
            super(view);
            moduleTitle = view.findViewById(R.id.card_item_title);
            moduleImage = view.findViewById(R.id.card_item_image);

        }


    }
}