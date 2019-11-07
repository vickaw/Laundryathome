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

        //Get this now

        Bundle bundle = getIntent().getExtras();
        String picku = bundle.getString("UserE", "Default");
        String pickd = bundle.getString("PickD", "Default");
        String pickt = bundle.getString("PickT", "Default");
        String deld = bundle.getString("DelD", "Default");
        String delt = bundle.getString("DelT", "Default");

        // Address
        String homS = bundle.getString("HStre", "Default");
        String homSb = bundle.getString("HSurb", "Default");
        String nomC = bundle.getString("HCity", "Default");
        String nomP = bundle.getString("HPost", "Default");

        Toast.makeText(this, homS, Toast.LENGTH_SHORT).show();

        // This is the setting the arguments to fragments
        bundle.putString("UserE",picku);
        bundle.putString("PickD",pickd);
        bundle.putString("PickT",pickt);
        bundle.putString("DelD", deld);
        bundle.putString("DelT", delt);

        bundle.putString("HStre",homS);
        bundle.putString("HSurb", homSb);
        bundle.putString("HCity", nomC);
        bundle.putString("HPost", nomP);

        // Get Adapater going

        viewpager=findViewById(R.id.viewPager);
        tabAdapter=new TabAdapter(getSupportFragmentManager(), bundle);
        viewpager.setAdapter(tabAdapter);


        tabLayout=findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewpager,false);




    }

}
