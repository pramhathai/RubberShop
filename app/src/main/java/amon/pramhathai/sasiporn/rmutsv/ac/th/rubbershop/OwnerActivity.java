package amon.pramhathai.sasiporn.rmutsv.ac.th.rubbershop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import amon.pramhathai.sasiporn.rmutsv.ac.th.rubbershop.fragment.OwnerFragment;

public class OwnerActivity extends AppCompatActivity {

    private String[] loginStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner);

//        Receive Login Value
        loginStrings = getIntent().getStringArrayExtra("Login");

//        Add Fragment
        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentOwnerFragment, OwnerFragment.ownerInstance(loginStrings))
            .commit();
        }


    }   // main method
}   // main class
