package com.infinitefocus.edu1010.Activites.Books;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.infinitefocus.edu1010.R;

public class BooksDetailsActivity extends AppCompatActivity {
private ActionBar actionBar;
private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //action bar
        actionBar =getSupportActionBar();
        actionBar.setTitle("KEEP CALM,THIS IS UNZA");

        Context mContext = BooksDetailsActivity.this;

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(String.valueOf(R.string.interstitial_ad_unit));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        //web initialisation
        PDFView pdfView = findViewById(R.id.pdfView);
        Bundle extras = getIntent().getExtras();

        assert extras != null;
        String data = extras.getString("titles");

        assert data != null;
        if (data.equals("EDU_1010_MODULE_ONE")) {
            pdfView.fromAsset("BOOKS/EDU 1010 MODULE ONE.pdf") .load();
        }


        if (data.equals("EDU_1010_MODULE_TWO")) {
            pdfView.fromAsset("BOOKS/EDU_1010_MODULE_TWO-1.pdf").load();
        }

        if (data.equals("EDU_1010_MODULE_THREE")) {
            pdfView.fromAsset("BOOKS/EDU 1010 MODULE THREE.pdf") .load();
        }

        if (data.equals("GOOD_EDU_1010")) {
            pdfView.fromAsset("BOOKS/GOOD EDU 1010.pdf").load();
        }
        if (data.equals("EDU_1010_ACRONYMS")) {
            pdfView.fromAsset("BOOKS/acronyms.pdf").load();
        }
        if (data.equals("ESSAY'S")) {
            pdfView.fromAsset("BOOKS/edu-1010-essay.pdf").load();
        }




    }
    
    public void onBackPressed() {

        mInterstitialAd.show();
        super.onBackPressed();

    }

}
