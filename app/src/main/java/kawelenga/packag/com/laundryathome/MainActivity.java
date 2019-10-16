package kawelenga.packag.com.laundryathome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.parse.ParseInstallation;

public class MainActivity extends AppCompatActivity {

    private float x1, x2, y1, y2;
    private Button mbtnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // ParseInstallation.getCurrentInstallation().saveInBackground();


        mbtnSignIn = findViewById(R.id.btnSignUp);

        mbtnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent signin = new Intent(MainActivity.this, SignIn.class);
                startActivity(signin);

            }
        });


        setTitle("");
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
                Intent i = new Intent(MainActivity.this, Delivery.class);
                startActivity(i);
            }else if(x1 > x2){
                Intent i = new Intent(MainActivity.this, Pickup.class);
                startActivity(i);
            }
            break;
        }
        return false;
    }


}
