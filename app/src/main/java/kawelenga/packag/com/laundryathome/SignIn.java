package kawelenga.packag.com.laundryathome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignIn extends AppCompatActivity {

    private Button loginIntoApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        getSupportActionBar().setTitle(" ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loginIntoApp= findViewById(R.id.btnLogin);

        loginIntoApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Intent loginin = new Intent(SignIn.this, ScheduleWashing.class);
                startActivity(loginin);


            }
        });

    }
}
