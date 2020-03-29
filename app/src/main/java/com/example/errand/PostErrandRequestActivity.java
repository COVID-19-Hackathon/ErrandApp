package com.example.errand;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class PostErrandRequestActivity extends FragmentActivity implements AddItemDialogListener{

    TextView itemsAddedTextView;
    List<Item> itemsAdded = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_errand_request);

        itemsAddedTextView = findViewById(R.id.items_text_view);


        findViewById(R.id.add_item_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                AddItemDialog addItemDialog = new AddItemDialog(PostErrandRequestActivity.this);
                addItemDialog.show(fm, "map_dialog");

            }
        });

        findViewById(R.id.help_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(PostErrandRequestActivity.this);
                builder.setMessage("Give a reward to the person who will do the errand. The person will see it and decide if he is willing to do it for you. This reward is in addition to the cost of your products");
                builder.setCancelable(true);

                builder.setPositiveButton(
                        "Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });


                AlertDialog alert = builder.create();
                alert.show();
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
