package kawelenga.packag.com.laundryathome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignIn extends AppCompatActivity {

    private Button loginIntoApp;
    private TextView forgotpassword, gettingstarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        getSupportActionBar().setTitle(" ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loginIntoApp= findViewById(R.id.btnLogin);
        forgotpassword =findViewById(R.id.txtForgotPassword);
        gettingstarted =findViewById(R.id.txtSignIn);

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
