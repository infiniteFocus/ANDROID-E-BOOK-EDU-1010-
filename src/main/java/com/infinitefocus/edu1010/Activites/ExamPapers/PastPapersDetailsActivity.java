package com.infinitefocus.edu1010.Activites.ExamPapers;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.infinitefocus.edu1010.R;

public class PastPapersDetailsActivity extends AppCompatActivity {
private ActionBar actionBar;
private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //action bar
        actionBar =getSupportActionBar();
        actionBar.setTitle("KEEP CALM,THIS IS UNZA");

        Context mContext = PastPapersDetailsActivity.this;

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(String.valueOf(R.string.interstitial_ad_unit));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        //web initialisation
        PDFView pdfView = findViewById(R.id.pdfView);
        Bundle extras = getIntent().getExtras();

        assert extras != null;
        String data = extras.getString("titles");

        assert data != null;

        if (data.equals("PAST_PAPERS_COMPILATION")) {
            pdfView.fromAsset("QNA/Compilation of EDU past papers (Ben).pdf") .load();
        }


        if (data.equals("QUESTIONS_AND_ANSWERS")) {
            pdfView.fromAsset("QNA/EAP 112 QUESTION AND ANSWER.pdf") .load();
        }

        if (data.equals("PAST_PAPERS")) {
            pdfView.fromAsset("QNA/EAP 112 PAST PAPERS.pdf") .load();
        }

        if (data.equals("MARKING_KEY1")) {
            pdfView.fromAsset("QNA/EAP 111-MARKG KEY.pdf") .load();
        }

        if (data.equals("MARKING_KEY2")) {
            pdfView.fromAsset("QNA/EAP 112 MARKING KEY.pdf") .load();
        }


    }
    
    public void onBackPressed() {

        mInterstitialAd.show();
        super.onBackPressed();

    }

}
