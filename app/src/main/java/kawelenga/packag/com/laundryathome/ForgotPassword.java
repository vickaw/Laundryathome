package kawelenga.packag.com.laundryathome;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.text.ParseException;

public class ForgotPassword extends AppCompatActivity {

    Button resetmypswd;
    EditText resetemailaddr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        getSupportActionBar().setTitle(" ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        resetmypswd = findViewById(R.id.btnReset);
        resetemailaddr =findViewById(R.id.edtForgotPwd);


        resetmypswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ParseUser.requestPasswordResetInBackground(resetemailaddr.getText().toString(), new RequestPasswordResetCallback() {
                            @Override
                            public void done(com.parse.ParseException e) {
                                if (e == null) {
                                    // An email was successfully sent with reset
                                    // instructions.
                                    FancyToast.makeText(ForgotPassword.this, "Email to reset password sent successfully!",
                                            FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();;
                                } else {
                                    // Something went wrong. Look at the ParseException
                                    // to see what's up.
                                    FancyToast.makeText(ForgotPassword.this, "Sorry we could not find your details in our database !",
                                            FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                                }
                            }

                        }
                );

            }
        });
        // ProgressDialog.show(ForgotPassword.this, "", "Please wait ");

    }

    public void rootlayerTapped (View view) {

        try {

            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }
}
