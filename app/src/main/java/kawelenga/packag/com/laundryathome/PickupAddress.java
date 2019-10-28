package kawelenga.packag.com.laundryathome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.List;

public class PickupAddress extends AppCompatActivity {

    TextView addressType;
    CheckBox sameAsPickup;
    EditText streetA, surburbA, cityA, postcodeA;
    Button clickNext , homebtn, officebtn, otherbtn;
    Boolean ishome, isoffice, isother, isPickDelivery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickup_address);

        getSupportActionBar().setTitle(" ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sameAsPickup =findViewById(R.id.checkBox);
        homebtn = findViewById(R.id.button);
        officebtn=findViewById(R.id.button9);
        otherbtn=findViewById(R.id.button8);
        addressType=findViewById(R.id.textView10);


        streetA =findViewById(R.id.edtStreet);
        surburbA =findViewById(R.id.edtSurburb);
        cityA=findViewById(R.id.txtCity);
        postcodeA=findViewById(R.id.edtPostCode);
        clickNext = findViewById(R.id.btnNext);
        ishome=true;
        isoffice=false;
        isother=false;
        isPickDelivery= true;


        // Get Username

        final ParseUser currentUser = ParseUser.getCurrentUser();
        final GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);

        // Retrieving arguments from previous screen
        String passedArg = getIntent().getExtras().getString("PickD");
        Toast.makeText(this, passedArg, Toast.LENGTH_SHORT).show();



        // Initialize with home address
        FillinAddress("HomeAddress", account.getEmail());
        Testme(homebtn);


        // Set the indicators for clicks

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ishome = true;

                FillinAddress("HomeAddress", account.getEmail());
                Testme(homebtn);
            }
        });

        officebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 isoffice =true;
                //officebtn.setBackground(R.id.button9 000000);
                 FillinAddress("OfficeAddress", account.getEmail());
                 Testme(officebtn);
            }
        });

        otherbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isother = true;
                FillinAddress("OtherAddress", account.getEmail());
                Testme(otherbtn);
            }
        });

        clickNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Checkpoint delivery address


                if (!isPickDelivery){


                    FancyToast.makeText(getApplicationContext(), "Show me the delivery screen", FancyToast.LENGTH_LONG,
                            FancyToast.SUCCESS, true).show();

                    sameAsPickup.setVisibility(View.INVISIBLE);
                    addressType.setText("What's your delivery address ?");
                    isPickDelivery = true;
                    return;

                } else {
                    //check if there is and address already

                    if (ishome) {
                    SaveAddressUpdates(account.getEmail(),"HomeAddress" );
                    } else if (isoffice) {
                        SaveAddressUpdates(account.getEmail(), "OfficeAddress");
                    } else {
                    SaveAddressUpdates(account.getEmail(),"OtherAddress" );}

                }


                /* Testing new method to save data
                //Toast.makeText(this,"Saved" + )
               Intent pick = new Intent(PickupAddress.this, Order.class);
                startActivity(pick);


                 */

                Intent newIntent = new Intent(PickupAddress.this, Order.class);
                Bundle bundle = getIntent().getExtras();
                if (bundle != null) {
                    newIntent.putExtras(bundle);
                }
                startActivity(newIntent);

            }
        });


        sameAsPickup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((CompoundButton) view).isChecked()){

                    isPickDelivery = true;
                    FancyToast.makeText(getApplicationContext(), "Checked", FancyToast.LENGTH_LONG,
                            FancyToast.SUCCESS, true).show();
                } else {
                    FancyToast.makeText(getApplicationContext(), "Un-checked", FancyToast.LENGTH_LONG,
                            FancyToast.SUCCESS, true).show();
                    isPickDelivery = false;
                }
            }
        });
    }

public void FillinAddress(String addtype , String accname ){
        // placeholder for method to fill addrress

    if (ishome){
        //Search for home address if it exists
        ParseQuery<ParseObject> queryAll = ParseQuery.getQuery(addtype);
        queryAll.whereEqualTo("username",accname);
        queryAll.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {

                if (objects.size() >0  && e==null){

                    for (ParseObject k1: objects) {

                        streetA.setText(k1.get("home1").toString());
                        surburbA.setText(k1.get("home2").toString());
                        cityA.setText(k1.get("home3").toString());
                        postcodeA.setText(k1.get("home4").toString());
                    }

                }

            }
        });

    } else if (isoffice) {

    } else if (isother) {

    }

    }

    public void Testme(View v) {

        Drawable dr = getResources().getDrawable(R.drawable.button_pressed);
        dr.setColorFilter(Color.parseColor("#38B6FF"), PorterDuff.Mode.SRC_ATOP);

        Drawable tr = getResources().getDrawable(R.drawable.button_pressed);
        tr.setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_ATOP);


        switch (v.getId()) {
            case R.id.button:
                homebtn.setBackground(dr);
                officebtn.setBackground(tr);
                otherbtn.setBackground(tr);

                break;

            case R.id.button9:
                officebtn.setBackground(dr);
                otherbtn.setBackground(tr);
                homebtn.setBackground(tr);
                break;

            case R.id.button8:
                otherbtn.setBackground(dr);
                officebtn.setBackground(tr);
                homebtn.setBackground(tr);
                break;

            default:
                break;
        }
    }

    public void SaveAddressUpdates (final String useremail, final String Addrtype){

        final ParseQuery<ParseObject> queryAddr = ParseQuery.getQuery(Addrtype);
        queryAddr.whereEqualTo("username",useremail);
        queryAddr.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {

                if (objects.size() >0  && e==null){

                    for (ParseObject kb: objects) {

                        try {
                            kb.put("home1",streetA.getText().toString() );
                            kb.put("home2", surburbA.getText().toString());
                            kb.put("home3", cityA.getText().toString());
                            kb.put("home4", postcodeA.getText().toString());
                            kb.saveInBackground(new SaveCallback() {
                                @Override
                                public void done(ParseException e) {
                                    if (e == null) {
                                        FancyToast.makeText(getApplicationContext(), "Address updates completed !", FancyToast.LENGTH_LONG,
                                                FancyToast.SUCCESS, true).show();
                                    } else {
                                        FancyToast.makeText(getApplicationContext(), e.getMessage(),
                                                FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                                    }

                                }
                            });
                        } catch (Exception e1) {

                            FancyToast.makeText(getApplicationContext(), e1.getMessage(),
                                    FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                        }



                    }

                } else {

                    try {
                        final ParseObject pickupAddr = new ParseObject(Addrtype);
                        pickupAddr.put("username", useremail);
                        pickupAddr.put("home1",streetA.getText().toString() );
                        pickupAddr.put("home2", surburbA.getText().toString());
                        pickupAddr.put("home3", cityA.getText().toString());
                        pickupAddr.put("home4", postcodeA.getText().toString());
                        pickupAddr.saveInBackground(new SaveCallback() {
                            @Override
                            public void done(ParseException e) {
                                if (e == null) {
                                    FancyToast.makeText(getApplicationContext(), "Address updates completed !", FancyToast.LENGTH_LONG,
                                            FancyToast.SUCCESS, true).show();
                                } else {
                                    FancyToast.makeText(getApplicationContext(), e.getMessage(),
                                            FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                                }

                            }
                        });
                    } catch (Exception e1) {

                        FancyToast.makeText(getApplicationContext(), e1.getMessage(),
                                FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                    }

                }

            }
        });


    }
}
