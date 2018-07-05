package com.example.admin.designandroid;


import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         if(savedInstanceState==null) {
             BodyFragmentpart headFragment = new BodyFragmentpart();
             headFragment.setImageId(AndroidImageAssets.getHeads());
             int headIndex = getIntent().getIntExtra("headIndex", 0);
             headFragment.setListIndex(headIndex);

             FragmentManager fragmentManager = getSupportFragmentManager();
             fragmentManager.beginTransaction()
                     .add(R.id.headcont, headFragment)
                     .commit();


             BodyFragment bodyFragment = new BodyFragment();
             bodyFragment.setImageId(AndroidImageAssets.getBodies());
             int bodyIndex = getIntent().getIntExtra("bodyIndex", 0);
             bodyFragment.setListIndex(bodyIndex);
             fragmentManager.beginTransaction()
                     .add(R.id.body_body, bodyFragment)
                     .commit();


             BodyLegFragment legFragment = new BodyLegFragment();
             legFragment.setImageId(AndroidImageAssets.getLegs());
             int legIndex = getIntent().getIntExtra("legIndex", 0);
             legFragment.setListIndex(legIndex);
             fragmentManager.beginTransaction()
                     .add(R.id.legg, legFragment)
                     .commit();

         }
    }

}


















