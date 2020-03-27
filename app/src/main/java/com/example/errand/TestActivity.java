package com.example.errand;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class TestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        findViewById(R.id.test_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testStuff();
            }
        });


    }

    private void testStuff() {
        Log.e("TEST", "YOU WILL SEE THE STUFF U PUT HERE IN RED IN THE CONSOLE");
    }
}
