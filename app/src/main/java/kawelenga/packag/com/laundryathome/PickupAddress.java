package kawelenga.packag.com.laundryathome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PickupAddress extends AppCompatActivity {

    Button clickNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickup_address);

        getSupportActionBar().setTitle(" ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        clickNext = findViewById(R.id.btnNext);

        clickNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent pick = new Intent(PickupAddress.this, Order.class);
                startActivity(pick);
            }
        });


    }
}