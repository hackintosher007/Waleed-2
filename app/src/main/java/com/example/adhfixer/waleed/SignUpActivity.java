package com.example.adhfixer.waleed;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etName, etPass, etEmail, etNum, etAge, etLanguage;
    TextView Title;
    Button btSignup;
    private FirebaseAuth mAuth;
    public static final String TAG = "FIREBASE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etName =  (EditText) findViewById(R.id.etName);
        etPass =  (EditText) findViewById(R.id.etPass);
        etEmail =  (EditText) findViewById(R.id.etEmail);
        etNum =  (EditText) findViewById(R.id.etNum);
        etAge =  (EditText) findViewById(R.id.etAge);
        etLanguage =  (EditText) findViewById(R.id.etLanguage);
        btSignup =  (Button) findViewById(R.id.btSignup);
        btSignup.setOnClickListener(this);
        Title =  (TextView) findViewById(R.id.textView);

         mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
       // updateUI(currentUser);
    }

    public void createAccount (String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            final FirebaseDatabase database = FirebaseDatabase.getInstance();
                            final DatabaseReference myRef = database.getReference("Users");
                            myRef.child(user.getUid()).push().setValue(new User(etName.getText().toString(),etAge.getText().toString(), etNum.getText().toString(), etLanguage.getText().toString()));
                            Intent i = new Intent(SignUpActivity.this, LoginActivity.class);
                            startActivity(i);
                           // updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });
    }


    @Override
    public void onClick(View v) {
        createAccount(etEmail.getText().toString(), etPass.getText().toString());


    }
}
