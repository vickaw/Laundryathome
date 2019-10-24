package kawelenga.packag.com.laundryathome;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DryClean extends Fragment {

    Button n1,n2,n3,n4,n5, p1, p2, p3,p4,p5;
    TextView i1,i2,i3,i4,i5, suitItem, suitPrice;
    Integer c1,c2,c3,c4,c5;

    public DryClean() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dry_clean, container, false);

        n1= view.findViewById(R.id.btnMinus);
        n2= view.findViewById(R.id.btnMinus5);
        n3= view.findViewById(R.id.btnMinus4);
        n4= view.findViewById(R.id.btnMinus3);
        n5= view.findViewById(R.id.btnMinus2);
        p1=view.findViewById(R.id.btnPlus);
        p2=view.findViewById(R.id.btnPlus2);
        p3=view.findViewById(R.id.btnPlus3);
        p4=view.findViewById(R.id.btnPlus6);
        p5=view.findViewById(R.id.btnPlus7);
        i1=view.findViewById(R.id.textView22);
        i2=view.findViewById(R.id.textView46);
        i3=view.findViewById(R.id.textView45);
        i4=view.findViewById(R.id.textView44);
        i5=view.findViewById(R.id.textView43);
        c1 =Integer.parseInt(i1.getText().toString());
        c2 =Integer.parseInt(i2.getText().toString());
        c3 =Integer.parseInt(i3.getText().toString());
        c4 =Integer.parseInt(i4.getText().toString());
        c5 =Integer.parseInt(i5.getText().toString());


        // Pull up the pricing sheet

        suitItem = view.findViewById(R.id.textView12);
        suitPrice = view.findViewById(R.id.textView21);

        final ParseQuery<ParseObject> queryAddr = ParseQuery.getQuery("Pricesheet");
        queryAddr.whereEqualTo("item","suit");
        queryAddr.findInBackground(new FindCallback<ParseObject>() {
                                       @Override
                                       public void done(List<ParseObject> objects, ParseException e) {

                                           if (objects.size() > 0 && e == null) {

                                               for (ParseObject kb : objects) {
                                                   suitItem.setText(kb.get("item").toString());
                                                   suitPrice.setText(kb.get("price").toString());;
                                               }

                                           }
                                       }
                                   });
        // Work the buttons

        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                c1--;
                if (c1 <= 0) {

                i1.setText("0");
                c1=0;
                }
                 else {

                    i1.setText(c1.toString());
                }


            }
        });

        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                c2--;
                if (c2 <= 0) {

                    i2.setText("0");
                    c2=0;
                }
                else {

                    i2.setText(c2.toString());
                }



            }
        });

        n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                c3--;
                if (c3 <= 0) {

                    i3.setText("0");
                    c3=0;
                }
                else {

                    i3.setText(c3.toString());
                }


            }
        });


        n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c4--;
                if (c4 <= 0) {

                    i4.setText("0");
                    c4=0;
                }
                else {

                    i4.setText(c4.toString());
                }


            }
        });

        n5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                c5--;
                if (c5 <= 0) {

                    i5.setText("0");
                    c5=0;
                }
                else {

                    i5.setText(c5.toString());
                }

            }
        });

        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c1++;
                i1.setText(c1.toString());
            }
        });

        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c2++;
                i2.setText(c2.toString());

            }
        });

        p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                c3++;
                i3.setText(c3.toString());
            }
        });

        p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c4++;
                i4.setText(c4.toString());
            }
        });
        p5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                c5++;
                i5.setText(c5.toString());
            }
        });

        return view;


    }

}
