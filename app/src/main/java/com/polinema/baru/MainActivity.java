package com.polinema.baru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting pemanggilan object dalam mempengaruhi keadaan potrait atau landscape
        if (savedInstanceState==null){


            //inialisasi untuk mengaktifkan fragment
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();

            //membuat inisialisasi pada masing-masing object
            BodyPartFragment bodyFragment = new BodyPartFragment();
            BodyPartFragment bodyFragment1 = new BodyPartFragment();
            BodyPartFragment bodyFragment2 = new BodyPartFragment();

            //membuat object pemanggilan untuk head atau kepala

            //mengambil data dari setter yang dibuat
            bodyFragment.setmImageIds(ImageAssets.getHeads());
            bodyFragment.setmListIndex(0);

            fragmentManager.beginTransaction().add(R.id.heads_container, bodyFragment).commit();



            bodyFragment1.setmImageIds(ImageAssets.getBodys());
            bodyFragment1.setmListIndex(0);

            fragmentManager.beginTransaction().add(R.id.body_container, bodyFragment1).commit();

            //object untuk pemanggilan legs atau kaki
            bodyFragment2.setmImageIds(ImageAssets.getLegs());
            bodyFragment2.setmListIndex(0);

            fragmentManager.beginTransaction().add(R.id.legs_container, bodyFragment2).commit();
        }

    }
}
