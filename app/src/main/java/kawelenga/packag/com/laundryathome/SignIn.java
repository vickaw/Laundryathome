package kawelenga.packag.com.laundryathome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignIn extends AppCompatActivity {

    int RC_SIGN_IN=0;
    GoogleSignInClient mGoogleSignInClient;

    private Button loginIntoApp,useGoogleLogin;
    private TextView forgotpassword, gettingstarted;
    private EditText signInEmail, signInPassword, signinFullName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        getSupportActionBar().setTitle(" ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loginIntoApp= findViewById(R.id.btnSignUp);
        forgotpassword =findViewById(R.id.txtForgotPassword);
        gettingstarted =findViewById(R.id.txtSignIn);
        signinFullName = findViewById(R.id.edtSignUpFullName);
        signInEmail =findViewById(R.id.edtSignUpEmail);
        signInPassword = findViewById(R.id.edtSignUpPassword);
        useGoogleLogin=findViewById(R.id.btnSignInGoogle);


        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        mGoogleSignInClient.signOut();


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


        useGoogleLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, RC_SIGN_IN);


            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            //Register 
            // Signed in successfully, show authenticated UI.
            startActivity(new Intent(SignIn.this, ScheduleWashing.class));
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("Google Sign In Error", "signInResult:failed code=" + e.getStatusCode());
            FancyToast.makeText(SignIn.this,"Google login fail",FancyToast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onStart() {

        GoogleSignInAccount account =GoogleSignIn.getLastSignedInAccount(this);
        if (account!=null){
            //startActivity(new Intent(SignIn.this,SignUp.class ));
           signinFullName.setText(account.getDisplayName());
           signInEmail.setText(account.getEmail());


        }
        super.onStart();



    }
}
