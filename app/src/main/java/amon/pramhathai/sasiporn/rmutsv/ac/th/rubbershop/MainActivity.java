package amon.pramhathai.sasiporn.rmutsv.ac.th.rubbershop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import amon.pramhathai.sasiporn.rmutsv.ac.th.rubbershop.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {                // ถ้า saveInstanceState มีค่าเท่ากับความว่างเปล่า ให้ทำใน if

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentMainFragment, new MainFragment())
                    .commit();


        }



    } //main method
} // main class
