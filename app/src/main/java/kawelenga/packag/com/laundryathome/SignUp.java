package kawelenga.packag.com.laundryathome;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUp extends AppCompatActivity {

    Button btnregNewUser;
    EditText txtSignupFullName,txtSignupEmail, txtSignupPassword, txtSignupMobile;
    TextView changetoSignin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getSupportActionBar().setTitle(" ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnregNewUser= findViewById(R.id.btnSignUp);
        txtSignupEmail = findViewById(R.id.edtSignUpEmail);
        txtSignupFullName = findViewById(R.id.edtSignUpFullName);
        txtSignupMobile =findViewById(R.id.edtSignUpMobile);
        txtSignupPassword =findViewById(R.id.edtSignUpPassword);
        changetoSignin = findViewById(R.id.txtSignIn);

        changetoSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent getin = new Intent(SignUp.this, SignIn.class);
                startActivity(getin);


            }
        });


        btnregNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {


                    if (txtSignupEmail.getText().toString().equals("") || txtSignupFullName.getText().toString().equals("") ||
                            txtSignupMobile.getText().toString().equals("") || txtSignupMobile.getText().toString().equals("")) {

                        FancyToast.makeText(SignUp.this, " Hi " + txtSignupFullName.getText().toString() + ". Please complete all the fields in order to sign up.",
                                FancyToast.LENGTH_LONG, FancyToast.INFO, true).show();
                    } else {


                        ParseUser user = new ParseUser();
                        // Set the user's username and password, which can be obtained by a forms
                        user.setUsername(txtSignupEmail.getText().toString());
                        user.setPassword(txtSignupPassword.getText().toString());
                        user.setEmail(txtSignupEmail.getText().toString());
                        user.put("mobile", txtSignupMobile.getText().toString());
                        user.put("fullname", txtSignupFullName.getText().toString());


                        final ProgressDialog progressDialog = new ProgressDialog(SignUp.this);
                        progressDialog.setMessage("Please wait ! " + txtSignupFullName.getText().toString());
                        progressDialog.show();
                        user.signUpInBackground(new SignUpCallback() {
                            @Override
                            public void done(ParseException e) {
                                if (e == null) {
                                    //alertDisplayer("Sucessful Sign Up!","Welcome" + <Insert Username Here> + "!");
                                    FancyToast.makeText(SignUp.this, "Welcome " + txtSignupFullName.getText().toString(),
                                            FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();

                                    Intent loginin = new Intent(SignUp.this, ScheduleWashing.class);
                                    startActivity(loginin);


                                } else {
                                    ParseUser.logOut();
                                    //Toast.makeText(SignUpActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                                    FancyToast.makeText(SignUp.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.INFO, true).show();

                                }
                                progressDialog.dismiss();
                            }
                        });


                    }
                } catch ( Exception e) {
                    e.printStackTrace();
                }




            }
        });

    }

    public void rootlayerTapped (View view) {

        try {

            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), SignIn.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
}
