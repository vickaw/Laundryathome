package kawelenga.packag.com.laundryathome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;


public class Order extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewpager;
    private TabLayout tabLayout;
    private TabAdapter tabAdapter;
    private Button btndryclean, btnLaundry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        getSupportActionBar().setTitle("Orders");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btndryclean= findViewById(R.id.button);
        btnLaundry=findViewById(R.id.button9);

        // Get Adapater going

        viewpager=findViewById(R.id.viewPager);
        tabAdapter=new TabAdapter(getSupportFragmentManager());
        viewpager.setAdapter(tabAdapter);


        tabLayout=findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewpager,false);
    }

}
