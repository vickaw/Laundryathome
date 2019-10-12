package kawelenga.packag.com.laundryathome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class Delivery extends AppCompatActivity {

    private float x1, x2, y1, y2;
    private Button btndelsignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        setTitle("");

        /* Resolve of swipes
        btndelsignin=findViewById(R.id.btnPickupSignIn);

        btndelsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent delsignin = new Intent(Delivery.this, SignIn.class);
                startActivity(delsignin);

            }
        });
        */
    }

    public boolean onTouchEvent(MotionEvent touchEvent){
        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if(x1 < x2){
                    Intent i = new Intent(Delivery.this, Pickup.class);
                    startActivity(i);
                }else if(x1 > x2){
                    Intent i = new Intent(Delivery.this, MainActivity.class);
                    startActivity(i);
                }
                break;
        }
        return false;



    }


}
