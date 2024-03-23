package com.example.instagram;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;

public class Login extends AppCompatActivity {
    EditText usr,pass;
    Button login;
    LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        usr = findViewById(R.id.userdata);
        pass = findViewById(R.id.Password);

        login = findViewById(R.id.login);

        animationView = findViewById(R.id.animation_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = usr.getText().toString();
                String password = pass.getText().toString();

                if(id.equals("test") && password.equals("123")){
                    animationView.setVisibility(View.VISIBLE);
                    login.setVisibility(View.VISIBLE);
                    animationView.playAnimation();
                    Thread td = new Thread(){
                        public void run(){
                            try{
                                sleep(4000);
                            }
                            catch (Exception e){
                                e.printStackTrace();
                            }
                            finally {
                                Intent intent = new Intent(Login.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }
                    };td.start();

                }
            }
        });

    }
}