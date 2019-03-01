package com.example.adhfixer.waleed;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class AlertDialogActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if(which== dialog.BUTTON_POSITIVE){
            Toast.makeText(this,"Yes",Toast.LENGTH_LONG).show();
        }
        if(which==dialog.BUTTON_NEGATIVE){
            Intent intent= new Intent(getApplication(),MainActivity.class);
            startActivity(intent);
        }


    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setMessage("are you sure");
        builder.setCancelable(false);
        builder.setPositiveButton("yes",this);
        builder.setNegativeButton("no",this);
        AlertDialog dialog= builder.create();
        dialog.show();


    }
}
