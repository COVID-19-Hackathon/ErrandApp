package com.example.errand;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.GeoPoint;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends Activity {

    FirebaseFirestore database = FirebaseFirestore.getInstance();
    List<ongoingErrand> oeArray = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        database.collection("ongoing_errands")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("TAG", document.getId() + " => " + document.getData());
                                String ongoingErrandId =  document.getId();
                                String volunteerId =  document.getString("volunteer_id");
                                String store =  document.getString("store");
                                long waitTime =  document.getLong("wait_time");
                                GeoPoint geoP = document.getGeoPoint("start_gps_position");
                                geoPoint gp = new geoPoint(geoP.getLatitude(),geoP.getLongitude());
                                ongoingErrand oe = new ongoingErrand(ongoingErrandId,volunteerId,store,waitTime,gp);
                                oeArray.add(oe);
                            }
                        } else {
                            Log.w("TAG", "Error getting documents.", task.getException());
                        }
                    }
                });

        findViewById(R.id.test_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (ongoingErrand oe : oeArray) {
                    Log.e("TEST",oe.toString());
                }
            }
        });


    }

    private void testStuff() {

        Log.e("TEST", "YOU WILL SEE THE STUFF U PUT HERE IN RED IN THE CONSOLE");
    }
}
