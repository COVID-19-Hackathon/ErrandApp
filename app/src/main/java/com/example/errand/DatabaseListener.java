package com.example.errand;

import java.util.List;

public interface DatabaseListener {

    void onOngoingErrandsFetchComplete(List<OngoingErrandModel> list);
}
