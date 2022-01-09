package com.infinitefocus.edu1010.Activites.TEST;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.infinitefocus.edu1010.R;

public class TestDetailsActivity extends AppCompatActivity {
private ActionBar actionBar;
private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //action bar
        actionBar =getSupportActionBar();
        actionBar.setTitle("KEEP CALM AND CHARGE");

        Context mContext = TestDetailsActivity.this;

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(String.valueOf(R.string.interstitial_ad_unit));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        //web initialisation
        PDFView pdfView = findViewById(R.id.pdfView);
        Bundle extras = getIntent().getExtras();

        assert extras != null;
        String data = extras.getString("titles");

        assert data != null;

        if (data.equals("2014/2015_TEST_ONE")) {
            pdfView.fromAsset("PAST PAPERS/edu-1010-2014_2015-test-one_ano.pdf") .load();
        }

        if (data.equals("2014/2015_TEST_TWO")) {
            pdfView.fromAsset("PAST PAPERS/edu-1010-2014_2015-test-two-mke.pdf") .load();
        }

        if (data.equals("2015/2016_TEST")) {
            pdfView.fromAsset("PAST PAPERS/edu-1010-2014_2015-test-two_1.pdf").load();
        }

        if (data.equals("2015/2016_TEST_MARKING_KEY")) {
            pdfView.fromAsset("PAST PAPERS/edu-1010-2015_2016-test-one.pdf").load();
        }
        if (data.equals("2015/2016_TEST_ONE_STREAM_B")) {
            pdfView.fromAsset("PAST PAPERS/edu-1010-2015_2016-test-one-mke.pdf") .load();
        }


        if (data.equals("2015/2016_TEST_ONE_STREAM_B_MARKING_KEY")) {
            pdfView.fromAsset("PAST PAPERS/edu-1010-2015_2016-test-two-str.pdf") .load();
        }

        if (data.equals("2015/2016_TEST_TWO")) {
            pdfView.fromAsset("PAST PAPERS/edu-1010-2015_2016-test-two-str_1.pdf").load();
        }

        if (data.equals("2016/2017_TEST_ONE")) {
            pdfView.fromAsset("PAST PAPERS/edu-1010-2015_2016-test-two-str_2.pdf") .load();
        }





    }
    
    public void onBackPressed() {

        mInterstitialAd.show();
        super.onBackPressed();

    }

}
