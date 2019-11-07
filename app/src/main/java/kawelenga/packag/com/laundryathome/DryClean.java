package kawelenga.packag.com.laundryathome;


import android.content.Intent;
import android.os.Bundle;

import androidx.core.internal.view.SupportMenuItem;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.sql.Date;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DryClean extends Fragment {

    private Button n1,n2,n3,n4,n5, p1, p2, p3,p4,p5, btnSubmission;
    private TextView i1,i2,i3,i4,i5, suitItem, suitPrice, dressItem, dressPrice, totalPrice,
    shirtItem,shirtPrice, touserItem, trouserPrice,trouserItem, jacketItem, jacketPrice,suitQty, dressQty, jacketQty, trouserQty,shirtQty, inNum ;
    private Integer c1,c2,c3,c4,c5, invoiceNum, test;
    private double grandTot;

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
        btnSubmission=view.findViewById(R.id.button3);
        inNum= view.findViewById(R.id.idInvNo);


        totalPrice =view.findViewById(R.id.textView85);
        grandTot =0;
        invoiceNum=0;



        // Pull up the pricing sheet
        //Suit
        suitItem = view.findViewById(R.id.textView12);
        suitPrice = view.findViewById(R.id.textView21);
        dressItem = view.findViewById(R.id.textView37);
        dressPrice = view.findViewById(R.id.textView40);
        shirtItem = view.findViewById(R.id.textView41);
        shirtPrice = view.findViewById(R.id.textView42);
        trouserItem = view.findViewById(R.id.textView36);
        trouserPrice = view.findViewById(R.id.textView39);
        jacketItem = view.findViewById(R.id.textView35);
        jacketPrice = view.findViewById(R.id.textView38);

        suitQty= view.findViewById(R.id.textView22);
        dressQty = view.findViewById(R.id.textView46);
        shirtQty = view.findViewById(R.id.textView45);
        trouserQty = view.findViewById(R.id.textView44);
        jacketQty = view.findViewById(R.id.textView43);


        final ParseQuery<ParseObject> queryAddr = ParseQuery.getQuery("Pricesheet");
        queryAddr.whereEqualTo("item","suit");
        queryAddr.findInBackground(new FindCallback<ParseObject>() {
                                       @Override
                                       public void done(List<ParseObject> objects, ParseException e) {

                                           if (objects.size() > 0 && e == null) {

                                               for (ParseObject k : objects) {
                                                   suitItem.setText(k.get("item").toString());
                                                   suitPrice.setText(k.get("price").toString());;
                                               }

                                           }
                                       }
                                   });

        //Dress price
        queryAddr.whereEqualTo("item","dress");
        queryAddr.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {

                if (objects.size() > 0 && e == null) {

                    for (ParseObject kb : objects) {
                        dressItem.setText(kb.get("item").toString());
                        dressPrice.setText(kb.get("price").toString());;
                    }

                }
            }
        });

        //Shirt

        queryAddr.whereEqualTo("item","shirt");
        queryAddr.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {

                if (objects.size() > 0 && e == null) {

                    for (ParseObject ks : objects) {
                        shirtItem.setText(ks.get("item").toString());
                        shirtPrice.setText(ks.get("price").toString());;
                    }

                }
            }
        });

        //Trouser


        queryAddr.whereEqualTo("item","trouser");
        queryAddr.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {

                if (objects.size() > 0 && e == null) {

                    for (ParseObject kt : objects) {
                        trouserItem.setText(kt.get("item").toString());
                        trouserPrice.setText(kt.get("price").toString());;
                    }

                }
            }
        });

        //jacket

        queryAddr.whereEqualTo("item","jacket");
        queryAddr.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {

                if (objects.size() > 0 && e == null) {

                    for (ParseObject kj : objects) {
                        jacketItem.setText(kj.get("item").toString());
                        jacketPrice.setText(kj.get("price").toString());;
                    }

                }
            }
        });


        // //
        final ParseQuery<ParseObject> queryAddrAll = ParseQuery.getQuery("RequestNo");
        queryAddr.whereEqualTo("item","suit");
        queryAddr.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {

                if (objects.size() > 0 && e == null) {

                    for (ParseObject k : objects) {
                        suitItem.setText(k.get("item").toString());
                        suitPrice.setText(k.get("price").toString());;
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

                 calcTotal(c1,c2,c3,c4,c5);

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

                calcTotal(c1,c2,c3,c4,c5);
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

                calcTotal(c1,c2,c3,c4,c5);
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

               calcTotal(c1,c2,c3,c4,c5);
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
                calcTotal(c1,c2,c3,c4,c5);
            }
        });

        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c1++;
                i1.setText(c1.toString());
                calcTotal(c1,c2,c3,c4,c5);
            }
        });

        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c2++;
                i2.setText(c2.toString());

                calcTotal(c1,c2,c3,c4,c5);
            }
        });

        p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                c3++;
                i3.setText(c3.toString());
                calcTotal(c1,c2,c3,c4,c5);
            }
        });

        p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c4++;
                i4.setText(c4.toString());
                calcTotal(c1,c2,c3,c4,c5);
            }
        });
        p5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                c5++;
                i5.setText(c5.toString());
                calcTotal(c1,c2,c3,c4,c5);
            }
        });



        // Send for submission

        btnSubmission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // Data passed from activity to activity and finally to the fragments

                getNextCount();


                // Current fragment Data


                final String picku = getArguments().getString("UserE");
                final String pickd = getArguments().getString("PickD");
                final String pickt = getArguments().getString("PickT");
                final String deld = getArguments().getString("DelD");
                final String delt = getArguments().getString("DelT");


                final String homS = getArguments().getString("HStre");
                final String homSb = getArguments().getString("HSurb");
                final String nomC = getArguments().getString("HCity");
                final String nomP = getArguments().getString("HPost");

                Toast.makeText(getContext(),picku, Toast.LENGTH_SHORT).show();


                // Submit to Laundering for Saving


                try {

                    final ParseObject pickupRequest = new ParseObject("Laundering");
                    pickupRequest.put("cusname", picku);
                    pickupRequest.put("pickdate", pickd);
                    pickupRequest.put("picktime", pickt);
                    pickupRequest.put("deliverydate", deld);
                    pickupRequest.put("deliverytime", delt);
                    pickupRequest.put("suitqty", Double.parseDouble(suitQty.getText().toString()));
                    pickupRequest.put("suitprice", Double.parseDouble(suitPrice.getText().toString()));
                    pickupRequest.put("dressqty", Double.parseDouble(dressQty.getText().toString()));
                    pickupRequest.put("dressprice", Double.parseDouble(dressPrice.getText().toString()));
                    pickupRequest.put("shirtqty",Double.parseDouble(shirtQty.getText().toString()));
                    pickupRequest.put("shirtprice",Double.parseDouble(shirtPrice.getText().toString()));
                    pickupRequest.put("trouserqty", Double.parseDouble(trouserQty.getText().toString()));
                    pickupRequest.put("trouserprice",Double.parseDouble(trouserPrice.getText().toString()));
                    pickupRequest.put("jacketqty", Double.parseDouble(jacketQty.getText().toString()));
                    pickupRequest.put("jacketprice",Double.parseDouble(jacketPrice.getText().toString()));

                    pickupRequest.put("pickaddtype","home");
                    pickupRequest.put("pickstreet", homS);
                    pickupRequest.put("picksurburb", homSb);
                    pickupRequest.put("pickcity", nomC);
                    pickupRequest.put("pickcode", nomP);


                   // FancyToast.makeText(getContext()," LOG "+ inNum.getText().toString(),
                     //       FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();

                    pickupRequest.put("invoicenum", Integer.parseInt(inNum.getText().toString()));

                    pickupRequest.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                FancyToast.makeText(getContext(), "Request submitted successfully!", FancyToast.LENGTH_LONG,
                                        FancyToast.SUCCESS, true).show();
                                Intent newIntent = new Intent(getContext(), Invoice.class);
                                Bundle bundle = new Bundle();
                                bundle.putString("UE",picku);
                                bundle.putString("PD",pickd);
                                bundle.putString("PT", pickt);
                                bundle.putString("DD", deld);
                                bundle.putString("DT", delt);
                                bundle.putString("PT","home");
                                bundle.putString("PS", homS);
                                bundle.putString("PSb", homSb);
                                bundle.putString("PC", nomC);
                                bundle.putString("PCe", nomP);

                                bundle.putString("IN",inNum.getText().toString());
                                bundle.putString("SQ", suitQty.getText().toString());
                                bundle.putString("SP", suitPrice.getText().toString());
                                bundle.putString("DQ", dressQty.getText().toString());
                                bundle.putString("DP", dressPrice.getText().toString());
                                bundle.putString("ShQ",shirtQty.getText().toString());
                                bundle.putString("ShP",shirtPrice.getText().toString());
                                bundle.putString("TQ", trouserQty.getText().toString());
                                bundle.putString("TP",trouserPrice.getText().toString());
                                bundle.putString("JQ", jacketQty.getText().toString());
                                bundle.putString("JP",jacketPrice.getText().toString());
                                newIntent.putExtras(bundle);
                                startActivity(newIntent);

                            } else {
                                FancyToast.makeText(getContext(), e.getMessage(),
                                        FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                            }

                        }
                    });
                } catch (Exception e1) {

                    FancyToast.makeText(getContext(), e1.getMessage(),
                            FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                }




            }


        });

        return view;




    }

    public  void calcTotal (int cnum1 , int cnum2, int cnum3 , int cnum4 , int cnum5){

        double calc = Double.parseDouble(suitPrice.getText().toString()) *  cnum1;
         double calc2 =Double.parseDouble(dressPrice.getText().toString()) *  cnum2;
         double calc3 = Double.parseDouble(shirtPrice.getText().toString()) *  cnum3;
       double calc4 =Double.parseDouble(trouserPrice.getText().toString()) *  cnum4;
       double calc5 = Double.parseDouble(jacketPrice.getText().toString()) *  cnum5;
        grandTot = calc + calc2 +calc3 + calc4 + calc5;
        totalPrice.setText(grandTot + "");

    }

 public void getNextCount(){
       final ParseQuery<ParseObject> queryAll = ParseQuery.getQuery("RequestNo");
     queryAll.whereEqualTo("taxno","invoice");
     queryAll.findInBackground(new FindCallback<ParseObject>() {
         @Override
         public void done(List<ParseObject> objects, ParseException e) {
             if (objects.size() > 0 && e == null) {

                 for (ParseObject kt : objects) {

                     invoiceNum = kt.getInt("RequestNumber");

                     inNum.setText(invoiceNum + "");

                     invoiceNum = kt.getInt("RequestNumber")+ 1;
                     kt.put("RequestNumber", invoiceNum);

                     kt.saveInBackground();


                 }
             }


         }
     });

    }


}
