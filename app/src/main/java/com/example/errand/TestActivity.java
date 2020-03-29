package com.example.errand;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


import com.google.firebase.firestore.GeoPoint;

public class TestActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        findViewById(R.id.test_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Database postQuery = new Database();
                ongoingErrand oe  = new ongoingErrand("test","uiouoiu","CVS", 500, new GeoPoint(12,12));
                postQuery.postOngoingErrands(oe);
            }
        });


    }

    private void testStuff() {

        Log.e("TEST", "YOU WILL SEE THE STUFF U PUT HERE IN RED IN THE CONSOLE");
    }
}
