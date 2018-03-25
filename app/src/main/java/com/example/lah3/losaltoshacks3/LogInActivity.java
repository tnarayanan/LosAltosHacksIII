package com.example.lah3.losaltoshacks3;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogInActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        mAuth = FirebaseAuth.getInstance();

        final EditText emailfield = (EditText) findViewById(R.id.email);
        final EditText passField = (EditText) findViewById(R.id.passsword);

        Button logInButton = (Button) findViewById(R.id.logIn);
        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn(emailfield.getText().toString(), passField.getText().toString());
            }
        });

    }

   public void signIn(String email, String password){
       mAuth.signInWithEmailAndPassword(email, password)
               .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if (task.isSuccessful()) {
                           // Sign in success, update UI with the signed-in user's information
                           FirebaseUser user = mAuth.getCurrentUser();
                           Intent i = new Intent(LogInActivity.this, WeekViewTest.class);
                           startActivity(i);
                       } else {
                           // If sign in fails, display a message to the user.
                           Toast.makeText(LogInActivity.this, "Authentication failed.",
                                   Toast.LENGTH_SHORT).show();
                       }

                       // ...
                   }
               });
   }
}
