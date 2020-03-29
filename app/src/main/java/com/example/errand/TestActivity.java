package com.example.errand;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


import com.google.firebase.firestore.GeoPoint;

import java.util.List;

public class TestActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        findViewById(R.id.test_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Database postQuery = new Database();
                errandRequest er = new errandRequest("blah","ACCEPTED","SAFEWAY",100,"Get me my beer", (long) 10.3,"blah",20,new GeoPoint(5.66666,5.6666));
                postQuery.postNewRequest(er);
            }
        });


    }

    private void testStuff() {

        Log.e("TEST", "YOU WILL SEE THE STUFF U PUT HERE IN RED IN THE CONSOLE");
    }
}
