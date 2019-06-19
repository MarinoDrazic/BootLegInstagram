package com.example.bootleginstagram.ViewOtherUser;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bootleginstagram.R;
import com.example.bootleginstagram.SharedModels.InstagramUsers;
import com.example.bootleginstagram.SharedModels.UserPhotos;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OtherUserProfileFragment extends Fragment {

    private OtherUserProfilePresenter presenter;

    private InstagramUsers User;

    //TODO 3 lazy to rename
    @BindView(R.id.imageProfile2)
    ImageView profileImage;
    @BindView(R.id.textViewUserName2)
    TextView ProfileName;
    @BindView(R.id.textViewPosts2)
    TextView Posts;
    @BindView(R.id.textViewFollowers2)
    TextView Followers;
    @BindView(R.id.textViewFollowing2)
    TextView Following;
    @BindView(R.id.textViewDescription2)
    TextView Description;
    public void setUser(InstagramUsers user)
    {
        this.User=user;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //TODO rename layout so its not activity.
        View view = inflater.inflate(R.layout.activity_view_user,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);

        fillWithData();
    }
    public void fillWithData(){



        Glide.with(getContext())
                .asBitmap()
                .load(User.getUser().getProfileImage().getLarge())
                .into(profileImage);
        ProfileName.setText(User.getUser().getInstagramUsername());
        Posts.setText(User.getUser().getTotalPhotos() + "\n Photos");
        Followers.setText(User.getUser().getTotalLikes() + "\n Likes");
        Following.setText(User.getUser().getTotalCollections() + "\nCollections");
        Description.setText(User.getUser().getBio());
    }
}
