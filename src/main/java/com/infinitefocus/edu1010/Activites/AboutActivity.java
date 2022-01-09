package com.infinitefocus.edu1010.Activites;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.infinitefocus.edu1010.R;

public class AboutActivity extends AppCompatDialogFragment {
 private Button dismiss,rate;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {



        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();

        View view = layoutInflater.inflate(R.layout.activity_about,null);

        builder.setView(view);
       // builder.setTitle("About the Developer");
        builder.setCancelable(true);

        return builder.create();







    }

}