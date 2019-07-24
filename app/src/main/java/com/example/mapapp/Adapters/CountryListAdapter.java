package com.example.mapapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mapapp.R;

import java.util.List;


public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.ViewHolder> {

    private List<String> countries;
    private Context mContext;

    public CountryListAdapter(Context  mContext, List<String> countries) {
        this.mContext=mContext;
        this.countries=countries;
    }

    public void setCountry(List<String> countries){
        this.countries=countries;
    }

    public List<String> getCountry(){
        return countries;
    }

    @NonNull
    @Override
    public CountryListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.country_list_item, parent, false);

        return new CountryListAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryListAdapter.ViewHolder holder, int position) {
        final String item = this.countries.get(position);
        Toast.makeText(mContext,countries.get(1)+", "+countries.get(2)+", "+countries.get(3),Toast.LENGTH_LONG).show();

        holder.countryTextView.setText(item);
    }

    @Override
    public int getItemCount() {
        return this.countries != null ? this.countries.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView countryTextView;

        public ViewHolder(@NonNull View view) {
            super(view);
            countryTextView = view.findViewById(R.id.tv_country);

        }


    }
}

