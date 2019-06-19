package com.example.bootleginstagram.ViewOtherUser;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bootleginstagram.R;
import com.example.bootleginstagram.SharedModels.InstagramUsers;

public class ViewUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otheruser);


        if (getIntent().hasExtra("User")) {

            inflateFragment(new OtherUserProfileFragment(), "aefadf");

        }

    }
    public void inflateFragment(OtherUserProfileFragment fragment, String fragmentTag) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerOtherProfile, fragment, fragmentTag)
                .commitAllowingStateLoss();

        fragment.setUser(getIntent().getParcelableExtra("User"));
    }
}
