package com.infinitefocus.edu1010;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.infinitefocus.edu1010.Activites.AboutActivity;
import com.infinitefocus.edu1010.Activites.Books.BooksActivity;
import com.infinitefocus.edu1010.Activites.ExamPapers.PastPapersActivity;
import com.infinitefocus.edu1010.Activites.TEST.TestActivity;


public class    StartActivity extends AppCompatActivity {
    private Context context;
    private NavigationView mBottomNav;
    // nav drawer
    private DrawerLayout mDrawer;
    private ActionBarDrawerToggle mToggle;
    private Button mBooks,mQuizzes,mTest,mPastpapers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        setUpDrawer();

        mBooks = findViewById(R.id.mBooks);
        mBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this, BooksActivity.class));
            }
        });

        mTest= findViewById(R.id.mTest);
        mTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this, TestActivity.class));
            }
        });

        mPastpapers= findViewById(R.id.mPast_papers);
        mPastpapers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this, PastPapersActivity.class));
            }
        });


    }

    // drawer setup
    public void setUpDrawer(){

        mDrawer = findViewById(R.id.mDrawer);
        mToggle = new ActionBarDrawerToggle(this,mDrawer,R.string.open,R.string.close);
        mDrawer.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mBottomNav = findViewById(R.id.mNav);
        mBottomNav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.mLog:
                        Intent share = new Intent(Intent.ACTION_SEND);
                        share.setType("text/plain");
                        share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                        // Add data to the intent, the receiving app will decide
                        // what to do with it.
                        share.putExtra(Intent.EXTRA_SUBJECT, "UNZA ICT1110- App from ART OF PROGRAMMING");
                        share.putExtra(Intent.EXTRA_TEXT, ""+ getString(R.string.link) + "\n"+ Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName()));
                        startActivity(Intent.createChooser(share, "Share app using"));

                        return true;

                    case R.id.mFed:
                        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                                "mailto", "Georgebest842@gmail.com", null));
                        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback regarding UNZA ICT1110");
                        startActivity(Intent.createChooser(emailIntent, null));

                    case R.id.mRate:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+getPackageName())));
                        return true;


                    case R.id.mFollow:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://free.facebook.com/kademo.george.9?refid=7")));
                        return true;

                    case R.id.mApps:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://free.facebook.com/GeorgeBestJrIII/")));
                        return true;

                    case R.id.mAbout:
                        AboutActivity aboutActivity = new AboutActivity();
                        aboutActivity.show(getSupportFragmentManager(),"about the dev");
                        return true;

                    case R.id.mExit:
                        System.exit(0);
                        return true;
                }

                return true;
            }
        });


    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

