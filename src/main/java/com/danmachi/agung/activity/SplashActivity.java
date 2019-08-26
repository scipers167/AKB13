package com.danmachi.indra.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.danmachi.sounandesuka.R;
import com.danmachi.indra.data.model.Friends;
import com.danmachi.indra.data.model.FriendsData;
import com.danmachi.indra.data.repo.FriendsRepository;
import com.danmachi.indra.preference.UserPreference;


public class SplashActivity extends AppCompatActivity {

    FriendsRepository repo;
    UserPreference prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        repo = new FriendsRepository(this);
        prefs = new UserPreference(this);

        Boolean isFirstRun = prefs.isFirstRun();
        if (isFirstRun) {
            Friends friends;
            for (String[] aData : FriendsData.initFriendsData) {
                friends = new Friends(aData[0], aData[1], aData[2], aData[3], aData[4], aData[5]);
                repo.insertFriend(friends);
            }

            prefs.setFirstRun(false);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        },2000);
    }
}
