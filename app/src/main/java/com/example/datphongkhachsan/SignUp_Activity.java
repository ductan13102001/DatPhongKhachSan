package com.example.datphongkhachsan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp_Activity extends AppCompatActivity {
    EditText edUsername_SignUp, edPassword_SignUp, edEmail_SignUp;
    Button butSignUp, butSignUp_Google;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        anhxa();

    }
    public void anhxa(){
        edUsername_SignUp = (EditText) findViewById( R.id.edtUserName );
        edEmail_SignUp = (EditText) findViewById( R.id.edtEmail );
        edPassword_SignUp = (EditText) findViewById( R.id.edtPassWord );
        butSignUp = (Button) findViewById( R.id.btnSignUp );
        butSignUp_Google = (Button) findViewById( R.id.btnSignInGoogle );

        butSignUp.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sceenSignUp = new Intent(SignUp_Activity.this, SignIn_Activity.class);
                startActivity( sceenSignUp );
                finish();
            }
        } );
    }
}