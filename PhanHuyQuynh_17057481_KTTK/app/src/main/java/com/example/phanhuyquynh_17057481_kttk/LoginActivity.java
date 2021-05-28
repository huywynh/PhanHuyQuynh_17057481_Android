package com.example.phanhuyquynh_17057481_kttk;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = LoginActivity.class.getSimpleName();
    private EditText etEmail, etPassword;
    private static FirebaseAuth mAuth;
    static {
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.editTextTextEmailAddress);
        etPassword = findViewById(R.id.editTextNumberPassword);

        findViewById(R.id.buttondangnhap).setOnClickListener(v -> {
            etEmail.setError(null);
            etPassword.setError(null);

            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();

            if (email.isEmpty()) {
                etEmail.setError("Vui lòng nhập Email");
                return;
            }

            if (password.isEmpty()) {
                etEmail.setError("Vui lòng nhập Email");
                return;
            }

            mAuth.signInWithEmailLink(email, password)
                    .addOnSuccessListener(authResult -> {
                        Intent intent = new Intent(this, MainActivity.class);
                        startActivity(intent);
                    })
                    .addOnFailureListener(e -> {
                        Log.d(TAG, e.getMessage());
                        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                        dialog.setTitle("Thông báo")
                                .setMessage("Đăng nhập tài khoản thất bại. Vui lòng thử lại")
                                .setPositiveButton("Đã hiểu", (dialog1, which) -> dialog1.dismiss())
                                .show();
                    });

        });

        findViewById(R.id.buttondangki).setOnClickListener(v -> {
            startActivity(new Intent(this, RegisterActivity.class));
        });
    }
}
