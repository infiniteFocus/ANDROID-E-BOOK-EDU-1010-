package com.infinitefocus.edu1010.Activites.TEST;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.infinitefocus.edu1010.Adapters.TitleAdapter;
import com.infinitefocus.edu1010.Constants.TESTS;
import com.infinitefocus.edu1010.Interface.CustomItemClickListener;
import com.infinitefocus.edu1010.R;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {


    private ActionBar actionBar;
    private Context mContext;
    private List<String> mTitleArrayList;
    private RecyclerView mRecyclerView;
    private AdView mAdView;
    private InterstitialAd  mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //action bar
        actionBar =getSupportActionBar();
        actionBar.setTitle("KEEP CALM,THIS IS UNZA");

       //banner ads
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //adapters
        mContext = TestActivity.this;
        mTitleArrayList = new ArrayList<String>() ;
        mTitleArrayList.add(TESTS.TEST1);
        mTitleArrayList.add(TESTS.TEST2);
        mTitleArrayList.add(TESTS.TEST3);
        mTitleArrayList.add(TESTS.TEST4);
        mTitleArrayList.add(TESTS.TEST5);
        mTitleArrayList.add(TESTS.TEST6);
        mTitleArrayList.add(TESTS.TEST7);
        mTitleArrayList.add(TESTS.TEST8);


        mRecyclerView = findViewById(R.id.mRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        TitleAdapter adapter = new TitleAdapter(mContext, mTitleArrayList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                //takes you to DetailsActivity
                Intent detailsIntent = new Intent(mContext, TestDetailsActivity.class);
                detailsIntent.putExtra("titles",mTitleArrayList.get(position));
                startActivity(detailsIntent);

              // Toast.makeText(mContext,"clicked " + mTitleArrayList.get(position),Toast.LENGTH_LONG).show();

            }
        });
        mRecyclerView.setAdapter(adapter);

    }

}