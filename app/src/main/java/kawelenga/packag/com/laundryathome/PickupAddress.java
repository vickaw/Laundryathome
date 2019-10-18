package kawelenga.packag.com.laundryathome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class PickupAddress extends AppCompatActivity {

    EditText streetA, surburbA, cityA, postcodeA;
    Button clickNext;
    Boolean ishome, isoffice, isother;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickup_address);

        getSupportActionBar().setTitle(" ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        streetA =findViewById(R.id.edtStreet);
        surburbA =findViewById(R.id.edtSurburb);
        cityA=findViewById(R.id.txtCity);
        postcodeA=findViewById(R.id.edtPostCode);
        clickNext = findViewById(R.id.btnNext);
        ishome=true;
        isoffice=false;
        isother=false;

        // Get Username

        final ParseUser currentUser = ParseUser.getCurrentUser();
        final GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);

        // Retrieving arguments from previous screen

        String passedArg = getIntent().getExtras().getString("PickD");
        Toast.makeText(this, passedArg, Toast.LENGTH_SHORT).show();



        clickNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {
                    final ParseObject pickupAddr = new ParseObject("HomeAddress");
                    pickupAddr.put("username", account.getEmail());
                    pickupAddr.put("home1",streetA.getText().toString() );
                    pickupAddr.put("home2", surburbA.getText().toString());
                    pickupAddr.put("home3", cityA.getText().toString());
                    pickupAddr.put("home4", postcodeA.getText().toString());
                    pickupAddr.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                FancyToast.makeText(getApplicationContext(), "Home address saved", FancyToast.LENGTH_LONG,
                                        FancyToast.SUCCESS, true).show();
                            } else {
                                FancyToast.makeText(getApplicationContext(), e.getMessage(),
                                        FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                            }

                        }
                    });
                } catch (Exception e) {

                    FancyToast.makeText(getApplicationContext(), e.getMessage(),
                            FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                }




                //Toast.makeText(this,"Saved" + )
               // Intent pick = new Intent(PickupAddress.this, Order.class);
               // startActivity(pick);
            }
        });


    }
}
