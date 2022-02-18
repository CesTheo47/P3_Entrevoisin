package com.openclassrooms.entrevoisins.ui.neighbour_details;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NeighbourInfoActivity extends AppCompatActivity {


    @BindView(R.id.txt_name)
    TextView name;
    @BindView(R.id.img_avatar)
    ImageView picture;
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

    private NeighbourApiService mApiService;
    protected Neighbour mNeighbour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neighbour_info);

        mApiService = DI.getNeighbourApiService();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_neighbour_info, container, false);
        ButterKnife.bind(this, view);

        name.setText(mNeighbour.getName());
        name2.setText(mNeighbour.getName());
        social.setText("www.facebook.com/" + mNeighbour.getName());
        adress.setText(mNeighbour.getAddress());
        phone.setText(mNeighbour.getPhoneNumber());
        about.setText(mNeighbour.getAboutMe());

        return view;
    }

    public void setFavoriteImg() {
        ImageView fab_favorite = null;
        if (mApiService.isFavorite(mNeighbour)) {
            fab_favorite.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_white_24dp));
        } else {
            fab_favorite.setImageDrawable(getResources().getDrawable(R.drawable.ic_star_border_white_24dp));
        }
    }

    public void setFabFavorite() {
        if (mApiService.isFavorite(mNeighbour)) {
            mApiService.removeFavorite(mNeighbour);
            Toast.makeText(this.getContext(), R.string.toast_not_fav, Toast.LENGTH_SHORT).show();
        } else {
            mApiService.addFavorite(mNeighbour);
            Toast.makeText(this.getContext(), R.string.toast_fav, Toast.LENGTH_SHORT).show();
        }
        setFavoriteImg();
    }

    private Context getContext() {
    }

}
