package com.example.adhfixer.waleed;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;


public class FireBaseActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    ArrayList <String> users;
    Button btSave;
    ListView lvUsers;

    EditText etEmail, etPass;

    TextView tvEmail,tvProfession,tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference().child("Name");

        btSave = findViewById(R.id.btSave);
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = etEmail.getText().toString();
                myRef.setValue(email);
                myRef.child("Name").setValue(email);
                myRef.child("Profession").setValue("student");
                myRef.child("Name").setValue(email);


            }
        });

        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);

        tvEmail=findViewById(R.id.tvEmail);
        tvProfession = findViewById(R.id.tvProfession);

        lvUsers = findViewById(R.id.lvUsers);
        users = new ArrayList <String>();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, users);



        myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                tvEmail.setText(value);
                Map<String, String> map = (Map<String,String>) dataSnapshot.getValue();
                Log.v("E_VALUE","Data: "+ dataSnapshot.getValue());

                String name = map.get("Name");
                String Profession = map.get("Profession");
                tvName.setText(name);
                tvProfession.setText(Profession);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                myRef.child("Users").addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }
}












