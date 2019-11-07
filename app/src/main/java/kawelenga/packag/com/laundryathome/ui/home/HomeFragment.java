package kawelenga.packag.com.laundryathome.ui.home;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.parse.ParseUser;

import kawelenga.packag.com.laundryathome.MainActivity;
import kawelenga.packag.com.laundryathome.Order;
import kawelenga.packag.com.laundryathome.PickupAddress;
import kawelenga.packag.com.laundryathome.R;
import kawelenga.packag.com.laundryathome.ScheduleWashing;
import kawelenga.packag.com.laundryathome.SignIn;

import java.util.Calendar;

public class HomeFragment extends Fragment {

    //private Boolean nextAction;

    private HomeViewModel homeViewModel;
    private TextView mDisplayDate, mDisplayTime, mPickDate, mPickTime;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private Button nextActivity;
    private static final String TAG = "Home";


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);
        //final TextView tv = root.findViewById(R.id.txt_home3);

        nextActivity = root.findViewById(R.id.btnNext);
        mDisplayDate =root.findViewById(R.id.edtPickDate);
        mDisplayTime=root.findViewById(R.id.edtPickTime);
        mPickDate =root.findViewById(R.id.edtDeliveryDate);
        mPickTime=root.findViewById(R.id.edtDeliveryTime);

        // Workout if User logged in using Google/ Parse / Facebook

        final ParseUser currentUser = ParseUser.getCurrentUser();
        final GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getContext());


        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);

                nextActivity.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //// I assume Page.class is your second ativity
                        //Intent intent = new Intent(this, Page.class);
                        //intent.putExtra("arg", getText()); // getText() SHOULD NOT be static!!!
                        //startActivity(intent);

                       /*** Alternative method
                        Intent pickaddress = new Intent(getContext(),PickupAddress.class);
                        pickaddress.putExtra("PickD", mDisplayDate.getText());
                        pickaddress.putExtra("PickT", mDisplayTime.getText());
                        pickaddress.putExtra("DelD", mPickDate.getText());
                        pickaddress.putExtra("DelT", mPickTime.getText());
                        startActivity(pickaddress);
                        */
                        // Trying with Bundle

                        Intent intent = new Intent(getContext(),PickupAddress.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("UserE", account.getEmail());
                        bundle.putString("PickD", mDisplayDate.getText().toString());
                        bundle.putString("PickT", mDisplayTime.getText().toString());
                        bundle.putString("DelD", mPickDate.getText().toString());
                        bundle.putString("DelT", mPickTime.getText().toString());
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });


                mDisplayDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Toast.makeText(getContext(), "Date Listener working ! ", Toast.LENGTH_LONG).show();
                        Calendar cal = Calendar.getInstance();
                        int year = cal.get(Calendar.YEAR);
                        int month = cal.get(Calendar.MONTH);
                        int day = cal.get(Calendar.DAY_OF_MONTH);

                        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                month = month + 1;
                                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                                String date = month + "/" + day + "/" + year;
                                mDisplayDate.setText(date);
                            }
                        };


                        DatePickerDialog dialog = new DatePickerDialog(
                                getContext(),
                                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                                mDateSetListener,
                                year,month,day);
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog.show();

                    }





                });


                mDisplayTime.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Calendar mcurrentTime = Calendar.getInstance();
                        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                        int minute = mcurrentTime.get(Calendar.MINUTE);
                        TimePickerDialog mTimePicker;
                        mTimePicker = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                                mDisplayTime.setText( selectedHour + ":" + selectedMinute);
                            }
                        }, hour, minute, true);//Yes 24 hour time
                        mTimePicker.setTitle("Select Time");
                        mTimePicker.show();
                    }
                });

                mPickDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Toast.makeText(getContext(), "Date Listener working ! ", Toast.LENGTH_LONG).show();
                        Calendar cal = Calendar.getInstance();
                        int year = cal.get(Calendar.YEAR);
                        int month = cal.get(Calendar.MONTH);
                        int day = cal.get(Calendar.DAY_OF_MONTH);

                        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                month = month + 1;
                                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                                String date = month + "/" + day + "/" + year;
                                mPickDate.setText(date);
                            }
                        };


                        DatePickerDialog dialog = new DatePickerDialog(
                                getContext(),
                                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                                mDateSetListener,
                                year,month,day);
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog.show();

                    }





                });


                mPickTime.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Calendar mcurrentTime = Calendar.getInstance();
                        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                        int minute = mcurrentTime.get(Calendar.MINUTE);
                        TimePickerDialog mTimePicker;
                        mTimePicker = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                                mPickTime.setText( selectedHour + ":" + selectedMinute);
                            }
                        }, hour, minute, true);//Yes 24 hour time
                        mTimePicker.setTitle("Select Time");
                        mTimePicker.show();
                    }
                });




            }
        });
        return root;



    }
}