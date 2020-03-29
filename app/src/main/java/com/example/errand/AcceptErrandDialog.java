package com.example.errand;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

public class AcceptErrandDialog extends DialogFragment {

    private String mName;

    public AcceptErrandDialog(String name) {
        mName = name;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return new FrameLayout(getContext());
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View layout = inflater.inflate(R.layout.accept_errand_dialog_layout, null);

        TextView name = layout.findViewById(R.id.name_text_view);
        name.setText(mName);

        layout.findViewById(R.id.post_request).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AcceptErrandDialog.this.getDialog().cancel();
            }
        });

        layout.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AcceptErrandDialog.this.getDialog().cancel();
            }
        });


        AlertDialog dialog = builder.create();
        dialog.setView(layout,0,0,0,0);
        return dialog;
    }
}
