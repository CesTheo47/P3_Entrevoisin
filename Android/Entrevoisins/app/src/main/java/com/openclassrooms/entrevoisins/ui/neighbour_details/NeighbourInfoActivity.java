package com.openclassrooms.entrevoisins.ui.neighbour_details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;
import com.openclassrooms.entrevoisins.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NeighbourInfoActivity extends AppCompatActivity {


    @BindView(R.id.txt_name)
    TextView name;
    @BindView(R.id.img_avatar)
    ImageView picture;
    @BindView(R.id.fab_favorite)
    FloatingActionButton favorite ;
    @BindView(R.id.txt_name_info)
    TextView name2;
    @BindView(R.id.txt_fb_info)
    TextView social;
    @BindView(R.id.txt_address_info)
    TextView adress;
    @BindView(R.id.txt_phone_info)
    TextView phone;
    @BindView(R.id.txt_bio_description)
    TextView about;
    @BindView(R.id.toolbar)
    MaterialToolbar toolbar;


    private NeighbourApiService mApiService;
    protected Neighbour mNeighbour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neighbour_info);
        ButterKnife.bind(this);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mApiService = DI.getNeighbourApiService();

        Long id = getIntent().getExtras().getLong(Constants.NEIGHBOUR_ID_KEY);
        mNeighbour = mApiService.getNeighbour(id);

        // Get profile info
        name.setText(mNeighbour.getName());
        name2.setText(mNeighbour.getName());
        social.setText("www.facebook.com/" + mNeighbour.getName());
        adress.setText(mNeighbour.getAddress());
        phone.setText(mNeighbour.getPhoneNumber());
        about.setText(mNeighbour.getAboutMe());
        Glide.with(this).load(mNeighbour.getAvatarUrl()).centerCrop().into(picture);
        setFavoriteImg();

        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "text", Toast.LENGTH_LONG ).show();
                mApiService.changeFavoriteStatus(mNeighbour);
                setFavoriteImg();
            }

        });
    }

    public void setFavoriteImg() {
        if (mNeighbour.isFavorite()) {
            favorite.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_white_24dp));
        } else {
            favorite.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_border_white_24dp));
        }

    }

}