package com.example.chatchat;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText etUsername, etEmail, etPassword;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsername = findViewById(R.id.etRegisterUsername);
        etPassword = findViewById(R.id.etRegisterPassword);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (isValidCredentials(username, email, password)) {
                    registerUser(username, email, password);
                } else {
                    Toast.makeText(RegisterActivity.this, "Please fill all fields correctly", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidCredentials(String username, String email, String password) {
        // 简单验证输入是否为空
        return !username.isEmpty() && !email.isEmpty() && !password.isEmpty();
    }

    private void registerUser(String username, String email, String password) {
        // 这里应该调用后端API来注册用户
        // 以下为模拟的注册成功提示
        Toast.makeText(this, "User registered successfully", Toast.LENGTH_SHORT).show();

    }
}