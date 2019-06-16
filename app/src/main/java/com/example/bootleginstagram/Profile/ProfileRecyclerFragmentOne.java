package com.example.bootleginstagram.Profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.bootleginstagram.GridRecyclerViewAdapter;
import com.example.bootleginstagram.InstagramUsers;
import com.example.bootleginstagram.R;
import java.util.List;

public class ProfileRecyclerFragmentOne extends Fragment {

    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profiletablayout,container,false);
        recyclerView=view.getRootView().findViewById(R.id.ProfileTabRecyclerOne);
        return view;
    }
    public void initRecyclerView(List<InstagramUsers> users){
        GridRecyclerViewAdapter adapter = new GridRecyclerViewAdapter(users,getContext());

        recyclerView.setAdapter((adapter));
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        recyclerView.setHasFixedSize(true);

    }
}
