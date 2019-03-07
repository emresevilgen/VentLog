package com.example.user.ventlog;

/**
 * __This activity works as Log in and Sign up activity, it is the first activity of app.___
 * @author __Utku Kalkanlı. Münib Emre Sevilgen. Tuana Türkmen. Efe Dağdemir.___
 * @version __11.05.2018__
 */
import com.example.user.ventlog.ventlog.*;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.ventlog.ventlog.User;
import com.example.user.ventlog.ventlog.VentLog;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText emailText;
    EditText passwordText;
    VentLog ventlog;
    User user2;
    Settings settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        emailText = findViewById(R.id.emailText);
        passwordText = findViewById(R.id.passwordText);
        ventlog = new VentLog();
        user2 = new User();
        settings = new Settings();
        settings.setUser(user2);
        ventlog.setSettings(settings);
        ventlog.getSettings().getUser().setName("Utku Kalkanlı");
    }

    /**
     * This method listens signUp button. It creates a new user if it does not exists, then enters the app by intent.
     * @param view comes from onClick.
     */
    public void signUp(View view)
    {
        mAuth.createUserWithEmailAndPassword(emailText.getText().toString(),passwordText.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    // creating user successful.
                    Toast.makeText(getApplicationContext(), "User created", Toast.LENGTH_LONG).show();
                    user2.setEmail(emailText.getText().toString());

                    // intent
                    Intent intent = new Intent(getApplicationContext(),MyLog.class);
                    intent.putExtra("mylog",ventlog);
                    startActivity(intent);
                }
            }
        }).addOnFailureListener(this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // hata mesajı
                Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }


    /**
     * This method listens signIn button, it uses password and email properties.
     * @param view comes from onClick.
     */
    public void signIn(View view)
    {
        mAuth.signInWithEmailAndPassword(emailText.getText().toString(), passwordText.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            user2.setEmail(emailText.getText().toString());

                            // intent , goes to MyLog.
                            Intent intent = new Intent(getApplicationContext(),MyLog.class);
                            intent.putExtra("mylog",ventlog);
                            startActivity(intent);
                        }
                    }
                }).addOnFailureListener(this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),e.getLocalizedMessage(), Toast.LENGTH_LONG).show(); // Password wrong or user does not exist.
            }
        });
    }

}
