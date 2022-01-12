package com.example.a5_recyclerview_inside_recyclerview_java.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a5_recyclerview_inside_recyclerview_java.R;
import com.example.a5_recyclerview_inside_recyclerview_java.model.Member;
import com.example.a5_recyclerview_inside_recyclerview_java.model.SubMember;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final int TYPE_ITEM_VIEW = 0;
    private static final int TYPE_ITEM_LIST = 1;

    Context context;
    List<Member> members;

    public CustomAdapter(Context context, List<Member> members) {
        this.context = context;
        this.members = members;
    }

    @Override
    public  int getItemViewType(int position){
        if(members.get(position).getSubMembers() != null) return TYPE_ITEM_LIST;

        return TYPE_ITEM_VIEW;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == TYPE_ITEM_VIEW){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_lauout_view,parent,false);
        return new CustomViewHolderAdapter(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_list,parent,false);
        return new CustomListHolderAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);

        if(holder instanceof CustomViewHolderAdapter){ }
        if(holder instanceof CustomListHolderAdapter){
            RecyclerView recyclerView = ((CustomListHolderAdapter) holder).recyclerView;
            recyclerView.setLayoutManager(new GridLayoutManager(context,1));

            List<SubMember> subMembers = member.getSubMembers();
            refreshSubAdapter(recyclerView,subMembers);
        }
    }
private void refreshSubAdapter(RecyclerView recyclerView, List<SubMember> subMembers){
        customSubAdapter adapter = new customSubAdapter(context,subMembers);
        recyclerView.setAdapter(adapter);
}

    @Override
    public int getItemCount() {
        return members.size();
    }

    private class CustomViewHolderAdapter extends RecyclerView.ViewHolder {
        View view;
        public CustomViewHolderAdapter(View v) {
            super(v);
            view = v;
        }
    }

    private class CustomListHolderAdapter extends RecyclerView.ViewHolder {
        View view;
        RecyclerView recyclerView;
        public CustomListHolderAdapter(View v) {
            super(v);
            view = v;

            recyclerView = view.findViewById(R.id.recyclerViewSub);
        }
    }
}
