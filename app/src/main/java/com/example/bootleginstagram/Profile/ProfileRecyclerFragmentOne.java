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
import com.example.bootleginstagram.RecyclerAdapters.GridRecyclerViewAdapter;
import com.example.bootleginstagram.SharedModels.InstagramUsers;
import com.example.bootleginstagram.R;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ProfileRecyclerFragmentOne extends Fragment implements ProfileRecyclerFragmentOneCallback {

    @BindView(R.id.ProfileTabRecyclerOne)
    RecyclerView recyclerView;
    private List<InstagramUsers> users;

    public  ProfileRecyclerFragmentOne getInstance(List<InstagramUsers> users) {
        this.users=users;
        return this;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profiletablayout,container,false);
        ButterKnife.bind(this,view);
        initRecyclerView();
        return view;
    }

    @Override
    public void initRecyclerView() {
        GridRecyclerViewAdapter adapter = new GridRecyclerViewAdapter(users,getContext());

        recyclerView.setAdapter((adapter));
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        recyclerView.setHasFixedSize(true);
    }


}
