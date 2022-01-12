package com.example.a5_recyclerview_inside_recyclerview_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.a5_recyclerview_inside_recyclerview_java.adapter.CustomAdapter;
import com.example.a5_recyclerview_inside_recyclerview_java.model.Member;
import com.example.a5_recyclerview_inside_recyclerview_java.model.SubMember;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        List<Member> members = prepareMembersList();
        refreshAdapter(members);

}
    private void initViews() {
            recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(new GridLayoutManager(context,1));
        }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter = new CustomAdapter(context,members);
        recyclerView.setAdapter(adapter);
    }

    private List<Member> prepareMembersList() {
            List<Member> members = new ArrayList<>();
            for(int i = 0; i<30; i++){
                if(i == 2  || i == 10){
            members.add(new Member("Sarvarbek"+i,"Khalmatov"+i,prepareSubMembers()));
                }else {
            members.add(new Member("Sarvarbek"+i,"Khalmatov"+i,null));
                }
            }
            return members;
    }

    private List<SubMember> prepareSubMembers(){
        List <SubMember> subMembers = new ArrayList<>();
        for(int i = 0; i<5; i++){
            subMembers.add(new SubMember());
        }
        return subMembers;
    }
    }
