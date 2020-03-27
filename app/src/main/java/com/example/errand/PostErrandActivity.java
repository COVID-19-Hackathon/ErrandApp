package com.example.errand;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PostErrandActivity extends FragmentActivity implements AddItemDialogListener{

    TextView itemsAddedTextView;
    List<Item> itemsAdded = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_errand);

        itemsAddedTextView = findViewById(R.id.items_text_view);


        findViewById(R.id.add_item_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                AddItemDialog addItemDialog = new AddItemDialog(PostErrandActivity.this);
                addItemDialog.show(fm, "map_dialog");

            }
        });
    }

    @Override
    public void onItemAdded(Item item) {
        String itemsAddedString = itemsAddedTextView.getText().toString();
        if (itemsAdded.isEmpty()) {
            itemsAddedTextView.setText(item.toString());
        } else {
            itemsAddedTextView.setText(itemsAddedString + ", " + item.toString());
        }
        itemsAdded.add(item);
    }
}
