package com.example.errand;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.GeoPoint;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private FirebaseFirestore database = FirebaseFirestore.getInstance();

    public List<ongoingErrand> retreiveOngoingErrands() {
        final List<ongoingErrand> oeArray = new ArrayList<>();
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
            return oeArray;
    }

    public List<ongoingErrand> retreiveOngoingRequests() {
        /**
         * Fill in your code Mothil
         */
        return null;
    }




}
