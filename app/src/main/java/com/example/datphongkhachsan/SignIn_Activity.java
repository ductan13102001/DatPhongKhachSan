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

public class SignIn_Activity extends AppCompatActivity {
    TextView txtLogUp, txtForgotPass;
    Button btnLogIn, btnSignUpGoogle;
    EditText edtUsername, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        anhxa();
        nextScreen();
        nextLogIn();
    }
    public void anhxa(){
        txtLogUp = (TextView) findViewById(R.id.txtSignUp);
        txtForgotPass = (TextView) findViewById(R.id.txtSignIn_next_Forgotpass);
        btnLogIn = (Button) findViewById(R.id.btnSignUp );
        btnSignUpGoogle = (Button) findViewById(R.id.btnSignInGoogle);
        edtUsername = (EditText) findViewById(R.id.edtUserName);
        edtPassword = (EditText) findViewById(R.id.edtPassWord);
    }
    // chuyển màn hình
    public void nextScreen(){
        txtLogUp.setOnClickListener( view -> {
            Intent mhLogUp = new Intent(SignIn_Activity.this, SignUp_Activity.class);
            startActivity(mhLogUp);
        } );
        txtForgotPass.setOnClickListener( view -> {
            Intent mhForgotPass = new Intent(SignIn_Activity.this, Forgot_password_Activity.class);
            startActivity(mhForgotPass);
        } );

    }

    public void nextLogIn() {
        String nameUser = String.valueOf( edtUsername );
        String passWord = String.valueOf( edtPassword );
        btnLogIn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (nameUser.equals( "123" )) {
//                    if(passWord.equals( "3254" )){
                        Toast.makeText( SignIn_Activity.this, "Đăng nhập thành công", Toast.LENGTH_LONG ).show();
                        Intent mhHome = new Intent( SignIn_Activity.this, QuanLy_HeThong_Activity.class );
                        startActivity( mhHome );
//                    }else {
//                        Toast.makeText( SignIn_Activity.this, "Sai tên tài khoản hoặc mật khẩu", Toast.LENGTH_LONG ).show();
//                    }
//                } else {
//                    Toast.makeText( SignIn_Activity.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_LONG ).show();
//                }
            }
        } );
    }
}