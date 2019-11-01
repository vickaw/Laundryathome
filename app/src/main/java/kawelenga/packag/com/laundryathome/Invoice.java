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

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class Invoice extends AppCompatActivity {

    private Button btnexit;
    private ScrollView scrollinvoice;
    private ListView listview;
    private TextView cusemail,pickStreet, pickSurburb, pickCity, pickCode, delStreet, delSurburb, delCity,delCode
    , suitQty, suitPrice, dressQty, dressPrice, jacketQty, jacketPrice, shirtQty,shirtPrice;

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


        findInvoice();


        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Stop the application 
            }
        });

    }

    private void findInvoice() {

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Laundering");
        query.whereEqualTo("cusname", "a@com"); //assume you have a DonAcc column in your Country table
        query.orderByDescending("createdAt"); //Parse has a built createAt
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> nameList, ParseException e) {
                if (nameList.size() > 0 && e == null) {

                    for (ParseObject kb : nameList) {
                        cusemail.setText(kb.get("cusname").toString());
                        pickStreet.setText(kb.get("pickstreet").toString());
                       pickSurburb.setText(kb.get("picksurburb").toString());
                      // pickCode.setText(kb.get("pickcode").toString());
                        delStreet.setText(kb.get("deliverstreet").toString());
                        delSurburb.setText(kb.get("deliversurburb").toString());
                        delCity.setText(kb.get("delivercity").toString());
                        shirtQty.setText(kb.get("shirtqty").toString());
                        shirtPrice.setText(kb.get("shirtprice").toString());
                        jacketPrice.setText(kb.get("jacketprice").toString());
                        jacketQty.setText(kb.get("jacketqty").toString());
                        dressQty.setText(kb.get("dressqty").toString());
                        dressPrice.setText(kb.get("dressprice").toString());

                    }

                } else {
                    Log.d("error", "Error: " + e.getMessage());
                }
            }
        });


    }
}
