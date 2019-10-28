package kawelenga.packag.com.laundryathome;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabAdapter extends FragmentPagerAdapter {

    private final Bundle fragmentBundle;

    public TabAdapter(@NonNull FragmentManager fm, Bundle data) {
        super(fm);
        fragmentBundle =data;
    }

    @Override
    public Fragment getItem(int tabposition) {
        switch (tabposition) {

            case 0:

               //Bundle bundle = new Bundle();
                //bundle.putString("Pick", "testing testing");
                DryClean drycleanTab=new DryClean();
                drycleanTab.setArguments(fragmentBundle);
                return drycleanTab;
            case 1:
                Laundry laundryTab = new Laundry();
                return laundryTab;
            case 2:
                Other otherTab = new Other();
                return otherTab;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){

            case 0:
                return "Dryclean";
            case 1:
                return "Laundry";
            case 2:
                return "Other";
            default:
                return null;
        }

        //return super.getPageTitle(position);
    }
}
