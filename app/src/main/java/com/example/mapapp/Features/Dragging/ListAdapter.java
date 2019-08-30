package com.example.mapapp.Features.Dragging;

import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mapapp.POJO.BackCardItem;
import com.example.mapapp.R;

import java.util.List;

class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder>
        implements View.OnTouchListener {

    private List<BackCardItem> list;
    private Listener listener;
    private Context mContext;
    private String launchMode = "collectionItems";

    ListAdapter(Context mContext,List<BackCardItem> list, Listener listener,String launchMode) {
        this.list = list;
        this.listener = listener;
        this.mContext = mContext;
        this.launchMode = launchMode;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if(launchMode == "collectionItems"){
        view = LayoutInflater.from(
                parent.getContext()).inflate(R.layout.list_row, parent, false);
            return new ListViewHolder(view);
        }else {
            view = LayoutInflater.from(
                    parent.getContext()).inflate(R.layout.back_card_item, parent, false);
            return new ListViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        if(launchMode == "backItems"){holder.textView.setText(list.get(position).getItemName());}

        holder.imageView.setImageDrawable(mContext.getResources().getDrawable(list.get(position).getItemIconId()));
        holder.frameLayout.setTag(position);
        holder.frameLayout.setOnTouchListener(this);
        holder.frameLayout.setOnDragListener(new DragListener(listener));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    v.startDragAndDrop(data, shadowBuilder, v, 0);
                } else {
                    v.startDrag(data, shadowBuilder, v, 0);
                }
                return true;
        }
        return false;
    }

    List<BackCardItem> getList() {
        return list;
    }

    void updateList(List<BackCardItem> list) {
        this.list = list;
    }

    DragListener getDragInstance() {
        if (listener != null) {
            return new DragListener(listener);
        } else {
            Log.e("ListAdapter", "Listener wasn't initialized!");
            return null;
        }
    }

    class ListViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        FrameLayout frameLayout;
        TextView textView;

        ListViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            frameLayout = itemView.findViewById(R.id.frame_layout_item);
        }
    }
}
