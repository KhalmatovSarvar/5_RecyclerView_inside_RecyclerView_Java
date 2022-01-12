package com.example.a5_recyclerview_inside_recyclerview_java.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a5_recyclerview_inside_recyclerview_java.R;
import com.example.a5_recyclerview_inside_recyclerview_java.model.SubMember;

import java.util.List;

public class customSubAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        Context context;
        List<SubMember> subMembers;

    public customSubAdapter(Context context, List<SubMember> subMembers) {
        this.context = context;
        this.subMembers = subMembers;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_view_sub,parent,false);
        return new CustomSubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            SubMember subMember = subMembers.get(position);
    }

    @Override
    public int getItemCount() {
        return subMembers.size();
    }

    private class CustomSubViewHolder extends RecyclerView.ViewHolder {
        View view;
        public CustomSubViewHolder(View v) {
            super(v);
            view = v;
        }
    }
}
