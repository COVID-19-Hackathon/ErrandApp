package com.example.errand;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.GeoPoint;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                                GeoPoint gp = document.getGeoPoint("start_gps_position");
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

    public List<errandRequest> retreiveOngoingRequests() {
        final List<errandRequest> prArray = new ArrayList<>();
        database.collection("posted_errands")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("TAG", document.getId() + " => " + document.getData());
                                String errandId =  document.getString("errand_id");
                                String volunteerId =  document.getString("volunteer_id");
                                String store =  document.getString("store");
                                long allowedServiceTime =  document.getLong("allowed_service_time");
                                GeoPoint gp = document.getGeoPoint("start_gps_position");
                                long distance = document.getLong("rough_total_distance");
                                long errandCost = document.getLong("errand_cost");
                                String acceptedStatus = document.getString("accepted_status");
                                String comments = document.getString("comments");
                                errandRequest pr = new errandRequest(volunteerId,acceptedStatus,store,allowedServiceTime,comments,errandCost,errandId,distance,gp);
                                prArray.add(pr);
                            }
                        } else {
                            Log.w("TAG", "Error getting documents.", task.getException());
                        }
                    }
                });
        return prArray;
    }


    public void postOngoingErrands(final ongoingErrand oe) {
        Map<String, Object> data = new HashMap<>();
        data.put("volunteer_id", oe.getVolunteerId());
        data.put("store", oe.getStore());
        data.put("start_gps_position", oe.getGp());
        data.put("sys_creation_date", Timestamp.now());
        data.put("sys_update_date", null);
        data.put("wait_time", oe.getWait_time());

        database.collection("ongoing_errands")
                .add(data)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.e("TAG", "DocumentSnapshot written with ID: " + documentReference.getId());
                        oe.setOngoingErrandId(documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("TAG", "Error adding document", e);
                    }
                });
    }


    public void postNewRequest(final errandRequest er) {
        Map<String, Object> data = new HashMap<>();
        data.put("volunteer_id", er.getVolunteerId());
        data.put("store", er.getStore());
        data.put("start_gps_position", er.getStartPos());
        data.put("sys_creation_date", Timestamp.now());
        data.put("sys_update_date", null);
        data.put("allowed_service_time", er.getAllowedServiceTime());
        data.put("rough_total_distance", er.getDistance());
        data.put("errand_id", er.getErrandId());
        data.put("errand_cost",er.getErrandCost());
        data.put("comments",er.getComments());
        data.put("accepted_status",er.getAcceptedStatus());
        data.put("accepted_by",null);

        database.collection("posted_errands")
                .add(data)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.e("TAG", "DocumentSnapshot written with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("TAG", "Error adding document", e);
                    }
                });
    }

}
