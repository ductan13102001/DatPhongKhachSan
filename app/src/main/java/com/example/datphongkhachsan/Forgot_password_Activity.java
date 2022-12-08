package com.example.datphongkhachsan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.*;

public class Forgot_password_Activity extends AppCompatActivity {
    Button btnLaylaiMK;
    TextView txtDN;
    EditText edUsername_forgotpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        anhxa();
    }
    public void anhxa(){
        btnLaylaiMK = (Button) findViewById(R.id.btnLaylaimạtkhau);
        txtDN = (TextView) findViewById(R.id.txtForgot_next_SignIn);
        edUsername_forgotpass = (EditText) findViewById(R.id.edtUserName);

        txtDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mhForgot_pass = new Intent(Forgot_password_Activity.this, SignIn_Activity.class);
                startActivity(mhForgot_pass);
                finish();
            }
        });

        btnLaylaiMK.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String layMK = String.valueOf( edUsername_forgotpass );
//                if(layMK.equals("123")){
                    Toast.makeText(Forgot_password_Activity.this, "Mật khẩu: 3254", Toast.LENGTH_LONG).show();
                    Intent mhForgot_pass = new Intent(Forgot_password_Activity.this, SignIn_Activity.class);
                    startActivity(mhForgot_pass);
                    finish();
//                }else{
//                    Toast.makeText(Forgot_password_Activity.this, "Tên tài khoản vừa nhập không tồn tại", Toast.LENGTH_LONG).show();
//                }
            }
        } );
    }
}