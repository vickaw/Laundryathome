package kawelenga.packag.com.laundryathome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignIn extends AppCompatActivity {

    private Button loginIntoApp;
    private TextView forgotpassword, gettingstarted;
    private EditText signInEmail, signInPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        getSupportActionBar().setTitle(" ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loginIntoApp= findViewById(R.id.btnSignUp);
        forgotpassword =findViewById(R.id.txtForgotPassword);
        gettingstarted =findViewById(R.id.txtSignIn);
        signInEmail = findViewById(R.id.edtSignUpFullName);
        signInPassword = findViewById(R.id.edtSignUpPassword);

        loginIntoApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Intent loginin = new Intent(SignIn.this, ScheduleWashing.class);
                startActivity(loginin);
            }
        });

        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent fpass = new Intent(SignIn.this, ForgotPassword.class);
                startActivity(fpass);

            }
        });

        gettingstarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent fpass = new Intent(SignIn.this, SignUp.class);
                startActivity(fpass);
            }
        });

    }
}
