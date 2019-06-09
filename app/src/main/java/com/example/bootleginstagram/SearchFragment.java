package com.example.bootleginstagram;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class SearchFragment extends Fragment {
    BootlegViewModel bootlegViewModel;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.searchfrag,container,false);
        recyclerView = view.getRootView().findViewById(R.id.SearchRecycler);
        bootlegViewModel= MainFeedFragment.GetBootlegViewModel();
        bootlegViewModel.GetThemSearchResults().observe(this, Results -> initRecyclerView(Results)  );

        return view;
    }
    public void initRecyclerView(SearchResults Results)
    {
        SearchRecyclerViewAdapter adapter = new SearchRecyclerViewAdapter(Results,getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
