package com.example.mapapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mapapp.R;

import java.util.List;

public class BackCardAdapter extends RecyclerView.Adapter<BackCardAdapter.ViewHolder> {

    List<String> backCardItems;

    public BackCardAdapter(List<String> backCardItems){
        this.backCardItems = backCardItems;
    }


    public BackCardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.country_list_item, parent, false);

        return new BackCardAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String item = this.backCardItems.get(position);
//        Toast.makeText(mContext,countries.get(1)+", "+countries.get(2)+", "+countries.get(3),Toast.LENGTH_LONG).show();

        holder.countryTextView.setText(item);
    }

    @Override
    public int getItemCount() {
        return this.backCardItems != null ? this.backCardItems.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView countryTextView;

        public ViewHolder(@NonNull View view) {
            super(view);
            countryTextView = view.findViewById(R.id.tv_country);

        }


    }

}
