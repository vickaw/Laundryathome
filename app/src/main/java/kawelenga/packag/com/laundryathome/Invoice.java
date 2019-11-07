package kawelenga.packag.com.laundryathome;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.ArrayList;
import java.util.List;

public class Invoice extends AppCompatActivity {

    private int keyin;
    private Button btnexit;
    private ScrollView scrollinvoice;
    private ListView listview;
    private TextView cusemail,pickStreet, pickSurburb, pickCity, pickCode, delStreet, delSurburb, delCity,delCode
    , suitQty, suitPrice, dressQty, dressPrice, jacketQty, jacketPrice, shirtQty,shirtPrice, inv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        // Initialize
        btnexit=findViewById(R.id.btnExit);
    scrollinvoice = findViewById(R.id.svInvoice);
    cusemail= findViewById(R.id.txtName);
    pickStreet= findViewById(R.id.txtPStreet);
    pickSurburb= findViewById(R.id.txtPSurburb);
    pickCity=findViewById(R.id.txtCity);
    delStreet =findViewById(R.id.txtDStreet);
    delSurburb=findViewById(R.id.txtDSurburb);
    delCity=findViewById(R.id.txtDCity);
    suitQty=findViewById(R.id.textView70);
    jacketQty=findViewById(R.id.textView72);
    shirtQty=findViewById(R.id.textView74);
    dressQty=findViewById(R.id.textView76);
    suitPrice=findViewById(R.id.textView86);
    jacketPrice=findViewById(R.id.textView87);
    shirtPrice=findViewById(R.id.textView88);
    dressPrice=findViewById(R.id.textView89);
    inv = findViewById(R.id.textView92);


    //Get Saved data bundles
        Bundle bundle = getIntent().getExtras();
        String invkey = bundle.getString("IN", "Default");

        String picku = bundle.getString("UE", "Default");
        String pickd = bundle.getString("PD", "Default");
        String pickt = bundle.getString("PT", "Default");
        String deld = bundle.getString("DD", "Default");
        String delt = bundle.getString("DT", "Default");

        // Address


        String homS = bundle.getString("PS", "Default");
        String homSb = bundle.getString("PSb", "Default");
        String nomC = bundle.getString("PC", "Default");
        String nomP = bundle.getString("PCe", "Default");

        // Pricing

        String suitq = bundle.getString("SQ", "Default");
        String suitp = bundle.getString("SP", "Default");
        String dressq = bundle.getString("DQ", "Default");
        String dressp = bundle.getString("DP", "Default");
        String shirtq = bundle.getString("ShQ","Default");
        String shirtp = bundle.getString("ShP","Default");
        String trouserq = bundle.getString("TQ", "Default");
        String trouserp = bundle.getString("TP","Default");
        String jacketq = bundle.getString("JQ", "Default");
        String jacketp = bundle.getString("JP","Default");


        FancyToast.makeText(getApplicationContext(), "INVOICE ?" + invkey, FancyToast.LENGTH_LONG,FancyToast.WARNING, true).show();


        //Show the receipt;

        inv.setText(" Invoice Number :"+ invkey);
        cusemail.setText(picku);
        pickStreet.setText(homS);
        pickSurburb.setText(homSb);

        delStreet.setText(homS);
        delSurburb.setText(homSb);
        delCity.setText(nomC);
        shirtQty.setText(shirtq);
        shirtPrice.setText(shirtp);
        jacketPrice.setText(jacketp);
        jacketQty.setText(jacketq);
        dressQty.setText(dressq);
        dressPrice.setText(dressp);




        //keyin = Integer.parseInt(invkey);


    //   findInvoice(keyin);


        // Display from Arguments passed





        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Stop the application
            }
        });

    }


    private void findInvoice(int invoice) {

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Laundering");
        query.whereEqualTo("invoicenum", invoice); //assume you have a DonAcc column in your Country table
        query.orderByDescending("createdAt"); //Parse has a built createAt
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> nameList, ParseException e) {
                if (nameList.size() > 0 && e == null) {

                    for (ParseObject kb : nameList) {


                        cusemail.setText(kb.get("cusname").toString());


                        pickStreet.setText(kb.get("pickstreet").toString());
                       pickSurburb.setText(kb.get("picksurburb").toString());
                      // pickCode.setText(kb.get("pickcode").toString());

                        /*
                        delStreet.setText(kb.get("deliverstreet").toString());

                        delSurburb.setText(kb.get("deliversurburb").toString());
                        delCity.setText(kb.get("delivercity").toString());
                        shirtQty.setText(kb.get("shirtqty").toString());
                        shirtPrice.setText(kb.get("shirtprice").toString());
                        jacketPrice.setText(kb.get("jacketprice").toString());
                        jacketQty.setText(kb.get("jacketqty").toString());
                        dressQty.setText(kb.get("dressqty").toString());
                        dressPrice.setText(kb.get("dressprice").toString());
                        */
                    }

                } else {
                    Log.d("error", "Error: " + e.getMessage());
                }
            }
        });


    }
}
