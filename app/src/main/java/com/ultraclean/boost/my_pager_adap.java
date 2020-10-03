package com.ultraclean.boost;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class my_pager_adap extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public my_pager_adap(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                phone_boost_ tab1 = new phone_boost_();
                return tab1;
            case 1:
                battery_sav tab2 = new battery_sav();
                return tab2;
            case 2:
                cpucool tab3 = new cpucool();
                return tab3;
            case 3:
                junkclean tab4 = new junkclean();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
