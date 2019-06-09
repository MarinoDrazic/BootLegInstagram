package com.example.bootleginstagram;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import static com.example.bootleginstagram.MainFeedFragment.bootlegInstagramApi;

public class SearchFragment extends Fragment {
    BootlegViewModel bootlegViewModel;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.searchfrag,container,false);
        recyclerView = view.getRootView().findViewById(R.id.SearchRecycler);
        bootlegViewModel= MainFeedFragment.GetBootlegViewModel();
        bootlegInstagramApi=MainFeedFragment.GetBootlegInstagramApi();
        bootlegViewModel.GetThemSearchResults().observe(this, Results -> initRecyclerView(Results)  );
        final EditText edittext = (EditText) view.findViewById(R.id.editText);
        edittext.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    if (!edittext.getText().equals("")) {
                        String Temp = edittext.getText().toString();
                        Temp = Temp.replaceAll("\\s+","%20");
                        bootlegViewModel.fetchSearchResults(bootlegInstagramApi,Temp);
                    }
                    return true;
                }
                return false;
            }
        });

        return view;
    }
    public void initRecyclerView(SearchResults Results)
    {
        SearchRecyclerViewAdapter adapter = new SearchRecyclerViewAdapter(Results,getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
